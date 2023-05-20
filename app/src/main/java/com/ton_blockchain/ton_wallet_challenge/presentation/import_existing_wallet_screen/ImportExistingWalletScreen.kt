package com.ton_blockchain.ton_wallet_challenge.presentation.import_existing_wallet_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
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
import com.ton_blockchain.ton_wallet_challenge.common.Constants.RECOVERY_PHRASE_COUNT
import com.ton_blockchain.ton_wallet_challenge.common.navigation.TonWalletScreens
import com.ton_blockchain.ton_wallet_challenge.common.ui.ButtonComponent
import com.ton_blockchain.ton_wallet_challenge.common.ui.TextButtonComponent
import com.ton_blockchain.ton_wallet_challenge.common.ui.TextComponent
import com.ton_blockchain.ton_wallet_challenge.common.ui.TopBarComponent
import com.ton_blockchain.ton_wallet_challenge.presentation.main_screen.components.AnimationLoader


@Composable
fun ImportExistingWalletScreen(
    navController: NavController, viewModel: ImportExistingWalletViewModel = hiltViewModel()
) {

    val focusManager = LocalFocusManager.current
    val myLists: MutableList<String> = (1..RECOVERY_PHRASE_COUNT).map { "" }.toMutableList()
    val textFieldInitValues = List(myLists.size) { "" }
    val valueStateList =
        remember { mutableStateListOf<String>().apply { addAll(textFieldInitValues) } }


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
                .fillMaxWidth()
                .background(Color.White)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            AnimationLoader(resId = R.raw.wallet_note)

            TextComponent(
                text = stringResource(R.string._24_secret_words_title),
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .padding(8.dp)
                    .wrapContentWidth(align = Alignment.CenterHorizontally),
            )
            TextComponent(
                text = stringResource(R.string.secret_words_content),
                modifier = Modifier
                    .padding(16.dp)
                    .wrapContentWidth(align = Alignment.CenterHorizontally),
            )

            myLists.forEachIndexed { index, item ->

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 64.dp, end = 64.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "${(index + 1)}:", modifier = Modifier.weight(.5f))
                    TextField(
                        value = valueStateList[index],
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth()
                            .weight(4f),
                        textStyle = TextStyle.Default.copy(fontSize = 16.sp),
                        onValueChange = {
                            valueStateList[index] = it
                        },

                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.White, focusedIndicatorColor = Color.Blue
                        ),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Text, imeAction = ImeAction.Next
                        ),
                        keyboardActions = KeyboardActions(
                            onNext = {
                                focusManager.moveFocus(FocusDirection.Down)
                            },
                    ),)
                }

            }
            ButtonComponent(text = stringResource(R.string.done)) {
                if (viewModel.generateWalletAddress(valueStateList)) {
                    navController.navigate(TonWalletScreens.WalletCreatedScreen.route)
                } else {
                    navController.navigate(TonWalletScreens.ForgetPhraseScreen.route)
                }
            }

            TextButtonComponent(text = stringResource(R.string.i_don_t_have_them)) {
                navController.navigate(TonWalletScreens.ForgetPhraseScreen.route)
            }

        }
    }
}
