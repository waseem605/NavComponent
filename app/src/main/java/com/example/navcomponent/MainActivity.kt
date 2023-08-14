package com.example.navcomponent

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.UriHandler
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import com.example.navcomponent.ui.theme.NavComponentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavComponentTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
//                    Greeting("Android")
                    NavigationGraph()
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NavComponentTheme {
        NavigationGraph()
    }
}


@Composable
fun NavigationGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.Login.route) {

        composable(Routes.Login.route) {
            navController.popBackStack(Routes.Home.route, inclusive = true)
            LoginScreen(navController)
        }



        composable(Routes.Home.route + "/{username}") { backStackEntry ->
            val username = backStackEntry.arguments?.getString("username")
            HomeScreen(navController, username)
        }



        composable(
        "${Routes.Details.route}/{Model}"
        ) {
            val bookModel = navController.previousBackStackEntry?.arguments?.getParcelable<PlayerModel>("Model")
            DetailsScreen(navController, bookModel)
        }


            composable("home") {
                LoginScreen(navController)
            }
            composable("details/{itemId}",
                arguments = listOf(navArgument("itemId") { type = NavType.StringType })) {
                val itemId = it.arguments?.getString("itemId")
                HomeScreen(navController, itemId)
            }



            // Handle deep links
            composable(  route = "details",
                deepLinks = listOf(navDeepLink {
                uriPattern = "https://composables.com/blog/{argument}"
            })){

            }
        }

}



// It contains route names to all three screens
sealed class Routes(val route: String) {
    object Login : Routes("login")
    object Home : Routes("home")
    object Details : Routes("details")
}
