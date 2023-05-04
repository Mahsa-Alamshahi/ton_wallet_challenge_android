package com.ton_blockchain.ton_wallet_challenge.presentation.import_existing_wallet_screen.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
internal fun TextFieldComponent(index: Int, phraseList: ArrayList<Pair<Int, String>>) {

    var textState by rememberSaveable { mutableStateOf("") }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 64.dp, end = 64.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "${(index + 1)}:", modifier = Modifier.weight(.5f))
        TextField(
            value = textState,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .weight(4f),
            textStyle = TextStyle.Default.copy(fontSize = 16.sp),
            onValueChange = {
                textState = it
                generateList(index, it, phraseList)
            },

            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White,
                focusedIndicatorColor = Color.Blue
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                }
            ),

            )
    }
}

fun generateList(index: Int, phrase: String, phraseList: ArrayList<Pair<Int, String>>) {
    println(" $index  $phrase    ")
    phraseList.add(index, Pair(index + 1, phrase))
}


fun showText(phraseList: ArrayList<Pair<Int, String>>) {
    for (i in 0..23) {
        println(println(" ${phraseList.get(i)}   "))
    }
}