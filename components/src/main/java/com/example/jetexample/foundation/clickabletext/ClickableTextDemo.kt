package com.example.jetexample.foundation.clickabletext

import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.jetexample.utils.showMessage

/**
 * [EN]
 * A continent version of [Text] component to be able to handle click event on the text.
 */

/**
 * [ES]
 * Una version del componente [Text] que registra eventos de click.
 */

@Composable
fun ClickableTextDemo(){
    val context = LocalContext.current
    ClickableText(
            text = AnnotatedString(text = "This is a clickable text, please click me",
                spanStyle = SpanStyle(fontSize = 20.sp)),
            onClick = {
        showMessage(context,"Thanks for clicking me :)")
    })
}

@Preview(showBackground = true)
@Composable
private fun ClickableTextPreview(){
    ClickableTextDemo()
}