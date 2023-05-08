package com.ton_blockchain.ton_wallet_challenge.presentation.passcode_screen

import android.widget.Toast
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
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.orhanobut.hawk.Hawk
import com.ton_blockchain.ton_wallet_challenge.R
import com.ton_blockchain.ton_wallet_challenge.common.Constants.HAWK_PASSCODE
import com.ton_blockchain.ton_wallet_challenge.common.ui.ButtonComponent
import com.ton_blockchain.ton_wallet_challenge.common.ui.TextComponent
import com.ton_blockchain.ton_wallet_challenge.common.ui.TopBarComponent
import com.ton_blockchain.ton_wallet_challenge.presentation.main_screen.components.AnimationLoader


@Composable
fun ConfirmPasscodeScreen(navController: NavController, passcode: String) {

    val context = LocalContext.current
    var confirmPasscodeTextState by rememberSaveable { mutableStateOf("") }

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
                resId = R.raw.wallet_lock
            )

            TextComponent(
                text = "Confirm a Passcode",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            TextComponent(
                text = stringResource(R.string.enter_the_4_digits_in_the_passcode)
            )

            TextField(
                value = confirmPasscodeTextState,
                modifier = Modifier.padding(64.dp),
                textStyle = TextStyle.Default.copy(fontSize = 16.sp),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White,
                    focusedIndicatorColor = Color.Blue
                ),
                onValueChange = {
                    confirmPasscodeTextState = it
                },
                label = {
                    Text("passcode ")
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


            ButtonComponent(text = stringResource(R.string.confirm)) {
                if (confirmPasscodeTextState == passcode) {
                    Hawk.put(HAWK_PASSCODE, passcode)
                    navController.navigate("ready_to_go_screen")
                } else {
                    Toast.makeText(context, "Passcode does not match.", Toast.LENGTH_SHORT).show()
                }
            }

        }
    }
}