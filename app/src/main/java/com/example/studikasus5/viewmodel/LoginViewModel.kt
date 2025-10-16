package com.example.studikasus5.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.studikasus5.data.UserData

class MainViewModel : ViewModel() {
    private val _userList = mutableStateListOf<UserData>()
    val userList: List<UserData> get() = _userList

    fun registerUser(user: UserData): Boolean {
        val existingUser = _userList.find { it.email == user.email }
        return if (existingUser == null) {
            _userList.add(user)
            true
        } else {
            false
        }
    }

    init {
        _userList.add(
            UserData(
                email = "lathiifahtuss@student.ub.ac.id",
                nim = "235150407111046",
                nama = "Lathiifahtus Sunniyyah",
                alamat = "Jl. Raya Sumbersari",
                password = "12345"
            )
        )
    }

    fun login(email: String, password: String): UserData? {
        return _userList.find { it.email == email && it.password == password }
    }
}
