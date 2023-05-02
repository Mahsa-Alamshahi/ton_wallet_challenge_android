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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ton_blockchain.ton_wallet_challenge.R
import com.ton_blockchain.ton_wallet_challenge.common.ui.TextComponent
import com.ton_blockchain.ton_wallet_challenge.common.ui.theme.Blue80
import com.ton_blockchain.ton_wallet_challenge.domain.model.PhraseList
import com.ton_blockchain.ton_wallet_challenge.presentation.main_screen.components.AnimationLoader

@Composable
fun TestPhraseScreen(
    navController: NavController,
    phraseList: PhraseList?,
    viewModel: TestPhraseViewModel = hiltViewModel()
) {

    var firstTextState by rememberSaveable { mutableStateOf("") }
    var secondTextState by rememberSaveable { mutableStateOf("") }
    var thirdTextState by rememberSaveable { mutableStateOf("") }

    var inputPhraseList = remember{ mutableListOf<Pair<Int, String>>()}
    val randomNumberList =  remember{viewModel.generateThreeRandomNumber()}

    Scaffold(
        topBar = {
            Row {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        tint = Blue80,
                        contentDescription = stringResource(R.string.back),
                        modifier = Modifier
                            .padding(4.dp)
                            .clickable {
                                navController.navigateUp()
                            }
                    )
                    TextComponent(
                        text = stringResource(id = R.string.back),
                        modifier = Modifier.padding(4.dp), textColor = Blue80
                    )
                }
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
                resId = R.raw.wallet_science
            )

            TextComponent(
                text = stringResource(R.string.test_phrase_title),
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(8.dp)
            )

            TextComponent(
                text = stringResource(R.string.test_phrase_content),
                modifier = Modifier.padding(16.dp)
            )


            TextField(
                value = firstTextState,
                modifier = Modifier.padding(8.dp),
                textStyle = TextStyle.Default.copy(fontSize = 16.sp),
                onValueChange = { firstTextState = it
                    },
                label = {
                    Text("${randomNumberList[0]}")
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
                value = secondTextState,
                modifier = Modifier.padding(8.dp),
                textStyle = TextStyle.Default.copy(fontSize = 16.sp),
                onValueChange = { secondTextState = it
                   },
                label = {
                    Text("${randomNumberList[1]}")
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
                value = thirdTextState,
                modifier = Modifier.padding(8.dp),
                textStyle = TextStyle.Default.copy(fontSize = 16.sp),
                onValueChange = {
                    thirdTextState = it

                                },
                label = {
                    Text("${randomNumberList[2]}")
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
                    inputPhraseList.add(0, Pair(randomNumberList[0], firstTextState))
                    inputPhraseList.add(1,Pair(randomNumberList[1], secondTextState))
                    inputPhraseList.add(2,Pair(randomNumberList[2], thirdTextState))
                    if (viewModel.checkRandomPhrase(phraseList!!.phrases, inputPhraseList)) {
                        navController.navigate("main_screen")
                    } else {

                    }
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
                    text = stringResource(R.string.continue_btn),
                    color = Color.White,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp
                )
            }
        }
    }


}