package com.example.basedemo.ui.content.splash

class SplashViewModel {

    sealed class UiState {
        object Empty : UiState()
        object Loading : UiState()
        object Loaded : UiState()
    }
}