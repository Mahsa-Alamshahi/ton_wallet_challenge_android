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
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.accompanist.flowlayout.FlowRow
import com.ton_blockchain.ton_wallet_challenge.R
import com.ton_blockchain.ton_wallet_challenge.common.ui.theme.Blue80
import com.ton_blockchain.ton_wallet_challenge.presentation.main_screen.components.AnimationLoader
import com.ton_blockchain.ton_wallet_challenge.presentation.recovery_phrase.components.PhraseList

@Composable
fun RecoveryPhraseScreen(navController: NavController) {
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
            modifier = Modifier.padding(paddingValues)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            AnimationLoader(resId = R.raw.wallet_note, width = 64.dp, height = 64.dp)
            Text(
                text = stringResource(R.string.recovery_phrase_title),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 12.dp, top = 12.dp)
            )
            Text(
                text = stringResource(R.string.recovery_phrase_content),
                fontSize = 14.sp, fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center,
                style = LocalTextStyle.current.copy(lineHeight = 18.sp),
                modifier = Modifier.padding(8.dp)
            )
            FlowRow {
//                NumberVerticalView()
                PhraseList()
            }


            Button(
                onClick = {
                },
                Modifier
                    .padding(top = 2.dp, start = 32.dp, end = 32.dp)
                    .fillMaxWidth(1f),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Blue80,
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(
                    text = "Done",
                    color = Color.White,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp
                )
            }
        }
    }
}