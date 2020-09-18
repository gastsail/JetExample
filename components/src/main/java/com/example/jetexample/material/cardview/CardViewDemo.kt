package com.example.jetexample.material.cardview

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview

/**
 * [EN]
 * Cards are [Surface]s that display content and actions on a single topic.
 */

/**
 * [ES]
 * Las Cards son [Surface]s que muestran su contenido y acciones en un solo topico
 */

@Composable
fun CardViewDemo(){
    Card(elevation = 8.dp,backgroundColor = Color.Gray,modifier = Modifier.padding(16.dp)){
        Column(modifier = Modifier.wrapContentWidth().padding(8.dp)) {
            Text("This is a Card",style = TextStyle(textAlign = TextAlign.Center,fontSize = 26.sp))
            for(number in 0..5){
                Text(text = "This is number $number")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewCard(){
    CardViewDemo()
}