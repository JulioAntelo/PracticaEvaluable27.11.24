package com.example.practicaenclasepmdm.Navegacion

sealed class AppScreen (val route: String){
    object PrimeraPantalla: AppScreen("PrimeraPantalla")
    /*dentro del objeto segunda pantalla debemos especificarle los 2 datos, ya que enviamos:
      - el navcontroller
      - el nombre con apellidos
      - la edad
      */
    object SegundaPantalla: AppScreen("SegundaPantalla/{nombreYapellidos}/{edadInt}")
}