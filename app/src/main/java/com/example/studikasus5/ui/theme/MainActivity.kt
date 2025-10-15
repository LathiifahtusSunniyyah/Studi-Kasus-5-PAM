package com.example.studikasus5.ui.theme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.tooling.preview.Preview
import com.example.studikasus5.screen.DaftarScreen
import com.example.studikasus5.screen.DetailScreen
import com.example.studikasus5.screen.LoginScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Memanggil fungsi utama aplikasi
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    MaterialTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            // Membuat controller navigasi
            val navController = rememberNavController()
            // Menjalankan navigasi utama
            AppNavigation(navController)
        }
    }
}

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "login"
    ) {
        // Halaman Login
        composable("login") {
            LoginScreen(navController)
        }

        // Halaman Detail (dengan parameter)
        composable("detail/{nim}/{nama}/{email}") { backStackEntry ->
            val nim = backStackEntry.arguments?.getString("nim") ?: ""
            val nama = backStackEntry.arguments?.getString("nama") ?: ""
            val email = backStackEntry.arguments?.getString("email") ?: ""
            DetailScreen(navController, nim, nama, email)
        }

        // Halaman Daftar
        composable("daftar") {
            DaftarScreen(navController)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewApp() {
    MyApp()
}
