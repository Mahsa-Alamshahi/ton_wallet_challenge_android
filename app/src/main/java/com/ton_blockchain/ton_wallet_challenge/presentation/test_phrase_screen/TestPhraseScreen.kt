package com.ton_blockchain.ton_wallet_challenge.presentation.test_phrase_screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ton_blockchain.ton_wallet_challenge.R
import com.ton_blockchain.ton_wallet_challenge.common.ui.theme.Blue80
import com.ton_blockchain.ton_wallet_challenge.presentation.main_screen.components.AnimationLoader

@Composable
fun TestPhraseScreen(navController: NavController) {
//    val kc = LocalSoftwareKeyboardController.current

    val textState = remember { mutableStateOf(TextFieldValue()) }
//    var text by remember { mutableStateOf("") }
//    var result by remember { mutableStateOf("") }
//    val callback = {
//        result = try {
//            val num = text.toFloat()
//            num.pow(2.0F).toString()
//        } catch (ex: NumberFormatException) {
//            ""
//        }
//        kc?.hide()
//    }

    Scaffold(
        topBar = {
            Row {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Back",
                    modifier = Modifier
                        .padding(4.dp)
                        .clickable {
                        }
                )
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            AnimationLoader(
                resId = R.raw.wallet_science, width = 128.dp,
                height = 128.dp
            )
            Text(
                text = "Test Time!",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 12.dp, top = 12.dp)
            )
            Text(
                text = "Let's check that you wrote them down correctly. Please enter the words and ",
                fontSize = 14.sp, fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center,
                style = LocalTextStyle.current.copy(lineHeight = 18.sp),
                modifier = Modifier.padding(8.dp)
            )

            TextField(
                value = textState.value,
                modifier = Modifier.padding(8.dp),
                textStyle = TextStyle.Default.copy(fontSize = 16.sp),
                onValueChange = { textState.value = it },
                label = {
                    Text("Text field 1")
                },
                        keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
//                    callback()
                }
            ),
            )
            TextField(
                value = textState.value,
                modifier = Modifier.padding(8.dp),
                textStyle = TextStyle.Default.copy(fontSize = 16.sp),
                onValueChange = { textState.value = it },
                label = {
                    Text("Text field 1")
                },
                        keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
//                    callback()
                }
            ),
            )
            TextField(
                value = textState.value,
                modifier = Modifier.padding(8.dp),
                textStyle = TextStyle.Default.copy(fontSize = 16.sp),
                onValueChange = { textState.value = it },
                label = {
                    Text("Text field 1")
                },
                        keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
//                    callback()
                }
            ),
            )



            Button(
                onClick = {
                },
                Modifier
                    .padding(top = 16.dp, start = 32.dp, end = 32.dp, bottom = 16.dp)
                    .fillMaxWidth(1f),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Blue80,
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(
                    text = "Continue",
                    color = Color.White,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp
                )
            }
        }
    }
}