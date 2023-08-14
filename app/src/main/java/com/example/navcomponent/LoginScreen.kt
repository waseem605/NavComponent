package com.example.navcomponent

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController


@Composable
fun LoginScreen(navController: NavHostController) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Login", fontSize = 24.sp, color = Color.Black)
        Spacer(modifier = Modifier.height(26.dp))
        TextField(value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        TextField(value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        Button(
            onClick = {
                if (username.isNotEmpty() && password.isNotEmpty()) {
                    navController.navigate(Routes.Home.route + "/$username") {
                        popUpTo(Routes.Login.route) {
                            inclusive = true
                        }
                    }
                } else {
                    Toast.makeText(context, "username or password is incorrect", Toast.LENGTH_SHORT)
                        .show()
                }
            }, modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text("Login")
        }

        Button(onClick = {
            navController.navigate(Routes.Home.route){
                popUpTo(Routes.Login.route) {
                    inclusive = true
                }
            }
        }) {
            Text("Login")
        }

        Spacer(modifier = Modifier.height(36.dp))
    }
}