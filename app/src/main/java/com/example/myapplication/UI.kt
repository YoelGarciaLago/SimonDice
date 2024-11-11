package com.example.simondice

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun Botones(modifier: Modifier = Modifier, modelView: ModelView){


    Box(modifier = modifier.fillMaxSize()
        .background(Color.White),
        contentAlignment = Alignment.Center){
        Column (verticalArrangement = Arrangement.Top,
            modifier = modifier.padding(bottom = 230.dp)){ Row { Text(
            modelView.texto.value
        ) } }
        Column(
            verticalArrangement = Arrangement.Center) {
            Row(horizontalArrangement = Arrangement.Center) {
                Boton(modifier, modelView,1)
                Boton(modifier,modelView,2)
            }
            Row(horizontalArrangement = Arrangement.Center) {
                Boton(modifier,modelView,3)
                Boton(modifier, modelView = modelView,4)
            }

            Column(verticalArrangement = Arrangement.Bottom) {
                Button(colors = ButtonDefaults.buttonColors(Color.Yellow),
                    onClick = {},
                    modifier = modifier.padding(start = 26.dp, top = 20.dp)){
                    Text("Start", color = Color.Black)
                }
            }
        }
    }
}


@Composable
fun UI(modelView: ModelView){
    Botones(modelView = modelView)
}
@Composable
private fun Boton(modifier: Modifier, modelView: ModelView, numColor: Int){

    Button(
        onClick = {modelView.compararColores(numColor) },
        modifier = modifier.padding(4.dp),
        colors = ButtonDefaults.buttonColors(modelView.darColor(numColor))
    )
    { }
}

@Preview
@Composable
fun MyAppPreview(){
    MyApplicationTheme {
        val viewM = ModelView()
        UI(viewM)
    }
}