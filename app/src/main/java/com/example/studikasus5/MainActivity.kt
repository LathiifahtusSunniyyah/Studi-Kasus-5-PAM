package com.example.studikasus5

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
import com.example.studikasus5.screen.DetailScreen
import com.example.studikasus5.screen.LoginScreen
import com.example.studikasus5.screen.DaftarScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    MaterialTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            val navController = rememberNavController()
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
        composable("login") {
            LoginScreen(navController)
        }

        composable("detail/{nim}/{nama}/{email}") { backStackEntry ->
            val nim = backStackEntry.arguments?.getString("nim") ?: ""
            val nama = backStackEntry.arguments?.getString("nama") ?: ""
            val email = backStackEntry.arguments?.getString("email") ?: ""
            DetailScreen(navController, nim, nama, email)
        }

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
