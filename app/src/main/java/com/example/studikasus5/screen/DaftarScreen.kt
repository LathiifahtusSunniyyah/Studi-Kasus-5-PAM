package com.example.studikasus5.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.studikasus5.data.UserData
import com.example.studikasus5.viewmodel.MainViewModel

@Composable
fun DaftarScreen(navController: NavController, mainViewModel: MainViewModel = viewModel()) {
    var nim by remember { mutableStateOf("") }
    var nama by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var registerMessage by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("FORM PENDAFTARAN", style = MaterialTheme.typography.titleLarge)
        Spacer(Modifier.height(16.dp))

        OutlinedTextField(value = nim, onValueChange = { nim = it }, label = { Text("NIM") })
        Spacer(Modifier.height(8.dp))
        OutlinedTextField(value = nama, onValueChange = { nama = it }, label = { Text("Nama") })
        Spacer(Modifier.height(8.dp))
        OutlinedTextField(value = email, onValueChange = { email = it }, label = { Text("Email") })
        Spacer(Modifier.height(8.dp))
        OutlinedTextField(value = alamat, onValueChange = { alamat = it }, label = { Text("Alamat") })
        Spacer(Modifier.height(8.dp))
        OutlinedTextField(value = password, onValueChange = { password = it }, label = { Text("Password") })

        if (registerMessage.isNotEmpty()) {
            Spacer(Modifier.height(8.dp))
            Text(registerMessage, color = MaterialTheme.colorScheme.primary)
        }

        Spacer(Modifier.height(16.dp))
        Button(
            onClick = { val newUser = UserData(nim, nama, email, alamat, password)
                val success = mainViewModel.registerUser(newUser)
                registerMessage = if (success) {

                    navController.navigate("detail/$nim/$nama/$email")
                    "Pendaftaran berhasil!"
                } else {
                    "Pendaftaran gagal. Email sudah terdaftar."
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("SIMPAN")
        }
    }
}