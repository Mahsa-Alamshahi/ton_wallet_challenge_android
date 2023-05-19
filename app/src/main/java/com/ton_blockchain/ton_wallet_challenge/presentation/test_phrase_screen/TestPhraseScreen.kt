package com.ton_blockchain.ton_wallet_challenge.presentation.test_phrase_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
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
import com.ton_blockchain.ton_wallet_challenge.common.navigation.TonWalletScreens
import com.ton_blockchain.ton_wallet_challenge.common.ui.ButtonComponent
import com.ton_blockchain.ton_wallet_challenge.common.ui.TextComponent
import com.ton_blockchain.ton_wallet_challenge.common.ui.TopBarComponent
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

    var inputPhraseList = remember { mutableListOf<Pair<Int, String>>() }
    val randomNumberList = remember { viewModel.generateThreeRandomNumber() }

    Scaffold(
        topBar = {
            TopBarComponent {
                navController.navigateUp()
            }
        },
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
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            TextComponent(
                text = stringResource(R.string.test_phrase_content)
            )


            TextField(
                value = firstTextState,
                modifier = Modifier.padding(top =32.dp),
                textStyle = TextStyle.Default.copy(fontSize = 16.sp),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White,
                    focusedIndicatorColor = Color.Blue
                ),
                onValueChange = {
                    firstTextState = it
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
                    }
                ),
            )
            TextField(
                value = secondTextState,
                modifier = Modifier.padding(8.dp),
                textStyle = TextStyle.Default.copy(fontSize = 16.sp),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White,
                    focusedIndicatorColor = Color.Blue
                ),
                onValueChange = {
                    secondTextState = it
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
                    }
                ),
            )
            TextField(
                value = thirdTextState,
                modifier = Modifier.padding(8.dp),
                textStyle = TextStyle.Default.copy(fontSize = 16.sp),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White,
                    focusedIndicatorColor = Color.Blue
                ),
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
                    }
                ),
            )

            ButtonComponent(text = stringResource(R.string.continue_btn)) {
                inputPhraseList.add(0, Pair(randomNumberList[0], firstTextState))
                inputPhraseList.add(1, Pair(randomNumberList[1], secondTextState))
                inputPhraseList.add(2, Pair(randomNumberList[2], thirdTextState))
                if (viewModel.checkRandomPhrase(phraseList!!.phrases, inputPhraseList)) {
                    navController.navigate(TonWalletScreens.WalletCreatedSuccessfullyScreen.route)
                } else {
                    navController.navigate(TonWalletScreens.ForgetPhraseScreen.route)
                }
            }

        }
    }


}