package com.example.myapplication.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class RegistrationViewModel : ViewModel() {
    var email = mutableStateOf("")
    var password = mutableStateOf("")
}