package com.example.epass.Model

import androidx.lifecycle.ViewModel


data class AuthModel(
    var name: String = "",
    var username: String = "",
    var email: String = "",
    var phone: String = "",
    var password: String = "",
    var isLogin: Boolean = true
) : ViewModel() {
    fun isempty(): Boolean {
        if (isLogin) {
            return name.isEmpty() || username.isEmpty() || email.isEmpty() || phone.isEmpty() || password.isEmpty()
        }
        return username.isEmpty() || password.isEmpty()
    }

}