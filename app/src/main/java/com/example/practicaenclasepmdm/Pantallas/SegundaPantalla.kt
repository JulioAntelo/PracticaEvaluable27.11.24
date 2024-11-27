package com.example.practicaenclasepmdm.Pantallas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.practicaenclasepmdm.Navegacion.AppScreen
import com.example.practicaenclasepmdm.R


@Composable
fun SegundaPantalla(navController: NavController, nombre: String, edad: Int) {
    VistaSegundaPantalla(navController, nombre, edad)
}

@Composable
fun VistaSegundaPantalla(navController: NavController, nombre: String, edad: Int) {

    //un pequeño icono para volver a la página anterior
    IconButton(onClick = { navController.popBackStack() }) {
        Icon(
            painter = painterResource(id = R.drawable.flechita),
            contentDescription = "Volver atrás"
        )
    }

    //una columna con los datos enviados
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp)
    ) {
        Text(text = "Nombre y Apellidos: $nombre")
        Text(text = "Edad: $edad")
    }
}