package com.example.qrbnb_superadmin.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.qrbnb_superadmin.domain.usecase.GetAddClientFormUseCase
import com.example.qrbnb_superadmin.presentation.state.ClientFormState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class ClientFormViewModel(
    private val getAddClientFormUseCase: GetAddClientFormUseCase
): ViewModel(){

    private val _uiState= MutableStateFlow<ClientFormState>(ClientFormState.Loading)
    val uiState: StateFlow<ClientFormState> = _uiState.asStateFlow()


    init{
        loadFrom()
    }



    private fun loadFrom(){
        viewModelScope.launch {
            try{
                _uiState.value= ClientFormState.Loading
                val schema=getAddClientFormUseCase()
                _uiState.value= ClientFormState.Success(schema)


            } catch (e: Exception){
                _uiState.value= ClientFormState.Error("failed to load form")
            }
        }
    }



}