package com.pmdm.thefirst

import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.getString
import com.pmdm.thefirst.ui.theme.TheFirstTheme

/**
 * test de Simon Dice
 * rama principal
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("Etiqueta", "Valor")
        Log.d("Etiqueta", "Hola Universo")
        enableEdgeToEdge()

        val text = "Hello toast!"
        val duration = Toast.LENGTH_LONG

        val toast = Toast.makeText(this, text, duration) // in Activity
        toast.show()


        setContent {
            // unaTostada()
            // MisBotones()
            }
        }


}

@Composable
fun unaTostada() {

}
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

enum class Colores(var valor: Int, var nombre: String) {
    ROJO(1, R.string.color_red.toString()),VERDE(2, "verde"),AZUL(3, "azul"),AMARILLO(4,"amarillo")
}

@Composable
fun MisBotones(){

    var pulsaciones by remember { mutableStateOf(mutableListOf<Int>())}
    var colores_pulsados by remember { mutableStateOf(mutableListOf<String>())}


    var name = remember { mutableStateOf("") }
    var counter by remember { mutableStateOf(0) }


    Column {
        // mostrar el contador de clics
        TextButton(
            onClick = {
                Log.d("botones", "click!")
                counter++
                pulsaciones.add(Colores.ROJO.valor)

                colores_pulsados.add(Colores.ROJO.nombre)
               
                Log.d("botones", colores_pulsados.toString())
            }) {
            Text("CLICS: para el log y $counter")
        }

        // mientras no tecleamos mas de tres caracteres no se muestra el saludo
        if (name.value.length > 3) {
            Text(
                text = "Nombre: ${name.value}!",
                fontSize = 24.sp
            )
        }
        // campo de texto para rellenar
        TextField(
            value = name.value,
            onValueChange = {
                name.value = it
            },
            label = { Text(text = "Name") }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TheFirstTheme {
        Greeting("Star Wars")
    }
}