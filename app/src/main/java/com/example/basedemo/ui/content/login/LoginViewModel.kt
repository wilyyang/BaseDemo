package com.example.basedemo.ui.content.login

class LoginViewModel {

    sealed class UiState {
        object Empty : UiState()
        object Loading : UiState()
        object Loaded : UiState()
    }
}