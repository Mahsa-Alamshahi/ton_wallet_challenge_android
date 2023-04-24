package com.ton_blockchain.ton_wallet_challenge.presentation.recovery_phrase

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.accompanist.flowlayout.FlowRow
import com.ton_blockchain.ton_wallet_challenge.R
import com.ton_blockchain.ton_wallet_challenge.common.ui.TextComponent
import com.ton_blockchain.ton_wallet_challenge.common.ui.theme.Blue80
import com.ton_blockchain.ton_wallet_challenge.presentation.main_screen.components.AnimationLoader
import com.ton_blockchain.ton_wallet_challenge.presentation.recovery_phrase.components.PhraseList

@Composable
fun RecoveryPhraseScreen(navController: NavController) {
    Scaffold(
        topBar = {
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
                TextComponent(text = stringResource(id = R.string.back),
                    modifier = Modifier.padding(4.dp), textColor = Blue80)
            }
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            AnimationLoader(resId = R.raw.wallet_note)

            TextComponent(
                text = stringResource(R.string.recovery_phrase_title),
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(8.dp)
            )
            TextComponent(
                text = stringResource(R.string.recovery_phrase_content),
                modifier = Modifier.padding(16.dp)
            )

            FlowRow(Modifier.padding(16.dp)) {
                PhraseList()
            }

            Button(
                onClick = {
                          navController.navigate("test_phrase_screen")
                },
                Modifier
                    .padding(32.dp)
                    .fillMaxWidth(1f),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Blue80,
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(
                    text = stringResource(R.string.done),
                    color = Color.White,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp
                )
            }
        }
    }
}