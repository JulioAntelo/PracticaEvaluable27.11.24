package com.example.practicaenclasepmdm.Navegacion


import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.practicaenclasepmdm.Pantallas.PrimeraPantalla
import com.example.practicaenclasepmdm.Pantallas.SegundaPantalla


@Composable
fun AppNavigation() {
    val navControlador = rememberNavController()
    NavHost(navController = navControlador, startDestination = AppScreen.PrimeraPantalla.route) {
        composable(AppScreen.PrimeraPantalla.route) {
            PrimeraPantalla(navControlador)
        }
        composable(
            route = AppScreen.SegundaPantalla.route,
            //una lista de los diferentes argumentos que enviamos para que estos se envien
            //correctamente
            arguments = listOf(
                navArgument("nombre") { type = NavType.StringType },
                navArgument("edad") { type = NavType.IntType }
            )
        ) { /*backstackentry se usa para recuperar los diferentes argumentos, en caso de que no
              este alguno en la llamada a la segunda pantalla el propio codigo dara un error de
              que falta algun dato o de que sobra*/
            backStackEntry ->
            val nombre = backStackEntry.arguments?.getString("nombre") ?: ""
            val edad = backStackEntry.arguments?.getInt("edadInt") ?: 0

            SegundaPantalla(navController = navControlador, nombre = nombre, edad = edad)
        }
    }

}


