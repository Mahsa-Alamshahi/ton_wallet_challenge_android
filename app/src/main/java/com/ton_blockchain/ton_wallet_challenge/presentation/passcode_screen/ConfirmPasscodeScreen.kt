package com.ton_blockchain.ton_wallet_challenge.presentation.passcode_screen

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mukeshsolanki.OTP_VIEW_TYPE_UNDERLINE
import com.mukeshsolanki.OtpView
import com.orhanobut.hawk.Hawk
import com.ton_blockchain.ton_wallet_challenge.R
import com.ton_blockchain.ton_wallet_challenge.common.Constants.HAWK_PASSCODE
import com.ton_blockchain.ton_wallet_challenge.common.navigation.TonWalletScreens
import com.ton_blockchain.ton_wallet_challenge.common.ui.ButtonComponent
import com.ton_blockchain.ton_wallet_challenge.common.ui.TextComponent
import com.ton_blockchain.ton_wallet_challenge.common.ui.TopBarComponent
import com.ton_blockchain.ton_wallet_challenge.presentation.main_screen.components.AnimationLoader


@Composable
fun ConfirmPasscodeScreen(navController: NavController, passcode: String) {

    val context = LocalContext.current
    var passcodeTextState by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopBarComponent {
                navController.navigateUp()
            }
        },
    ) { paddingValues ->

        Column(
            modifier = Modifier.fillMaxSize()
                .padding(paddingValues).background(Color.White)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(12.dp).verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {


                AnimationLoader(
                    resId = R.raw.wallet_lock
                )

                TextComponent(
                    text = stringResource(R.string.confirm_a_passcode), fontSize = 24.sp, fontWeight = FontWeight.Bold
                )

                TextComponent(
                    text = stringResource(R.string.enter_the_4_digits_in_the_passcode)
                )

                OtpView(
                    otpText = passcodeTextState,
                    onOtpTextChange = {
                        passcodeTextState = it
                    },
                    type = OTP_VIEW_TYPE_UNDERLINE,
                    password = true,
                    otpCount = 4,
                    modifier = Modifier
                        .background(Color.White)
                        .padding(top = 32.dp),
                    containerSize = 48.dp,
                    charSize = 32.sp,
                    passwordChar = "•",
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Done),
                    charColor = Color.Black
                )
            }

            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .weight(.4f).verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {


                ButtonComponent(text = stringResource(R.string.confirm)) {
                    if (passcodeTextState == passcode) {
                        Hawk.put(HAWK_PASSCODE, passcode)
                        navController.navigate(TonWalletScreens.ReadyToGoScreen.route)
                    } else {
                        Toast.makeText(context, "Passcode does not match.", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }

        }
    }
}