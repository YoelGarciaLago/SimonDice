package com.example.myapplication

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel


class ModelView : ViewModel() {
    private val TAG_LOG:String = "Debuguer"
     var _numbers = mutableStateOf(0)
    var texto: MutableState<String> = mutableStateOf("Numero generado")
     var isCorrect: MutableState<Boolean?> = mutableStateOf(null)
    init {
        crearRandomBoton()
    }
    fun crearRandomBoton() {
        val randomButtonIndex = (1..4).random()
        Datos._numbers = randomButtonIndex
        Log.d(TAG_LOG, "Random: $randomButtonIndex") // Muestra en el Log el número aleatorio
    }


    fun darColor(numColor: Int): Color{
        return when(numColor){
            1 -> Color.Red
            2 -> Color.Blue
            3 -> Color.Green
            4 -> Color.Gray
            else -> Color.White
        }
    }

    fun compararColores(numColor: Int): Boolean {
        val resultado = numColor == Datos._numbers
        isCorrect.value = resultado  // Actualiza isCorrect y Compose detectará el cambio
        Log.d(TAG_LOG,"Resultado: " + resultado)
        // Actualiza el texto según el resultado
        texto.value = if (resultado) "Correcto" else "Incorrecto"
        return resultado
    }



}


