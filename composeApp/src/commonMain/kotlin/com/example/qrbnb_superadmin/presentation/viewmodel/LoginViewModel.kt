package com.example.qrbnb_superadmin.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.qrbnb_superadmin.domain.exception.InvalidCredentialsException
import com.example.qrbnb_superadmin.domain.usecase.LoginUseCase
import com.example.qrbnb_superadmin.logging.Logger
import com.example.qrbnb_superadmin.presentation.state.LoginState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel(
    private val loginUseCase: LoginUseCase,
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

                _state.update { it.copy(isLoading = false, passwordInput = "") }
                Logger.d("LoginViewModel", "Login successful: ${user.email}")
            } catch (e: InvalidCredentialsException) {
                _state.update { it.copy(isLoading = false) }
                Logger.d("LoginViewModel", e.message ?: "Invalid credentials")
            } catch (e: Exception) {
                _state.update { it.copy(isLoading = false) }
            }
        }
    }
}
