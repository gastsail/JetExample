package com.example.jetexample.foundation.clickabletext

import androidx.compose.foundation.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ContextAmbient
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview
import com.example.jetexample.utils.showMessage


@Composable
fun ClickableTextDemo(){
    val context = ContextAmbient.current
    ClickableText(
            text = AnnotatedString(text = "This is a clickable text, please click me",
            spanStyle = SpanStyle(fontSize = 20.sp)),
            onClick = {
        showMessage(context,"Thanks for clicking me :)")
    })
}

@Preview
@Composable
private fun ClickableTextPreview(){
    ClickableTextDemo()
}