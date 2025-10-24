package com.example.qrbnb_superadmin.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.qrbnb_superadmin.domain.exception.InvalidCredentialsException
import com.example.qrbnb_superadmin.domain.usecase.LoginUseCase
import com.example.qrbnb_superadmin.logging.Logger
import com.example.qrbnb_superadmin.presentation.state.LoginState
import com.example.qrbnb_superadmin.toast.ToastManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel(
    private val loginUseCase: LoginUseCase,
    private val toastManager: ToastManager
) : ViewModel() {
    private val _state = MutableStateFlow(LoginState())
    val state: StateFlow<LoginState> = _state.asStateFlow()

    fun onEmailChanged(newEmail: String) {
        _state.update { it.copy(emailInput = newEmail) }
    }

    fun onPasswordChanged(newPassword: String) {
        _state.update { it.copy(passwordInput = newPassword) }
    }

    fun login() {
        val email = _state.value.emailInput
        val password = _state.value.passwordInput

        _state.update { it.copy(isLoading = true) }

        viewModelScope.launch {
            try {
                val user = loginUseCase(email, password)
                toastManager.show("Login Successful! for user :${user.email}")

                _state.update { it.copy(isLoading = false, passwordInput = "") }
                Logger.d("LoginViewModel", "Login successful: ${user.email}")

            } catch (e: InvalidCredentialsException) {

                _state.update { it.copy(isLoading = false) }
                toastManager.show(e.message)
                Logger.d("LoginViewModel", e.message)
            } catch (e: Exception) {
                _state.update { it.copy(isLoading = false) }
            }
        }
    }
}
