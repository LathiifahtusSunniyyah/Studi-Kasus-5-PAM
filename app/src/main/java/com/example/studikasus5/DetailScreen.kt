package com.example.studikasus5

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun DetailScreen(navController: NavController, nim: String, nama: String, email: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Detail Mahasiswa", style = MaterialTheme.typography.titleLarge)
        Spacer(Modifier.height(16.dp))
        Text("235150407111046 : $nim")
        Text("Lathiifahtus Sunniyyah : $nama")
        Text("lathiifahtuss@student.ub.ac.id : $email")

        Spacer(Modifier.height(24.dp))
        Button(onClick = { navController.navigate("daftar") }) {
            Text("DAFTAR")
        }
    }
}
