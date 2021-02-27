package com.example.jetexample.material.checkbox

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Checkbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetexample.utils.showMessage

/**
 * [EN]
 * A component that represents two states (checked / unchecked).
 */

/**
 * [ES]
 * Un componente que representa dos estados (checked / unchecked).
 */

@Composable
fun CheckBoxDemo() {
        val context = LocalContext.current
        val checkedState = remember { mutableStateOf(false) }
        Checkbox(modifier = Modifier.padding(16.dp) ,
            checked = checkedState.value,
            onCheckedChange = {
                    checkedState.value = it
                if(checkedState.value) showMessage(context,"Checked") else showMessage(context,"Unchecked")
            }
        )
}


@Preview(showBackground = true)
@Composable
private fun CheckBoxPreview(){
        CheckBoxDemo()
}