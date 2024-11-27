package com.example.practicaenclasepmdm.Pantallas

import android.widget.EditText
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.practicaenclasepmdm.Navegacion.AppScreen

@Composable
fun PrimeraPantalla(navController: NavController){
    VistaPrimeraPantalla(navController)
}


@Composable
fun VistaPrimeraPantalla(
    navController: NavController,
) {

    //valores que vamos a pasar de un lado al otro
    var nombreYapellidos by remember { mutableStateOf("") }
    var Edad by remember { mutableStateOf("") } //de primeras la app recoge un string que transforma en int, este int es el que se envia
    val edadInt = Edad.toIntOrNull() ?: 0

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(64.dp)
    ) {
        //primer tipo de dato a enviar, un texto
        TextField(
            value = nombreYapellidos,
            onValueChange = { nombreYapellidos = it },
            label = { Text("Nombre y apellidos") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        //segundo tipo de dato, un int
        TextField(
            value = Edad,
            onValueChange = { Edad = it },
            label = { Text("Edad") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        //el boton que al hacer click nos lleva a la otra pantalla y envia los datos
        Button(
            onClick = {
                //control de errores en caso de que esten vacios
                if (nombreYapellidos.isNotEmpty() && edadInt > 0) {
                    navController.navigate(
                        route = AppScreen.SegundaPantalla.route +
                                "/$nombreYapellidos/$edadInt"
                    )
                } else {

                    //control de que haya algun tipo de valor, se lanza un exception
                    throw IllegalArgumentException("no hay valores dentro de alguno de los campos")
                }
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("Ir a la Segunda Pantalla")
        }
    }
}