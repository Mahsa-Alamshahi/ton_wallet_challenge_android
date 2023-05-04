package com.ton_blockchain.ton_wallet_challenge.presentation.recovery_phrase

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.accompanist.flowlayout.FlowRow
import com.ton_blockchain.ton_wallet_challenge.R
import com.ton_blockchain.ton_wallet_challenge.common.ui.ButtonComponent
import com.ton_blockchain.ton_wallet_challenge.common.ui.TextComponent
import com.ton_blockchain.ton_wallet_challenge.common.ui.TopBarComponent
import com.ton_blockchain.ton_wallet_challenge.domain.model.PhraseList
import com.ton_blockchain.ton_wallet_challenge.presentation.main_screen.components.AnimationLoader
import com.ton_blockchain.ton_wallet_challenge.presentation.recovery_phrase.components.PhraseListComponent


@Composable
fun RecoveryPhraseScreen(
    navController: NavController,
    viewModel: RecoveryPhraseViewModel = hiltViewModel()
) {

    val customCardElevation = CardDefaults.cardElevation(
        defaultElevation = 8.dp,
        pressedElevation = 2.dp,
        focusedElevation = 4.dp
    )

    var phraseList: List<Pair<Int, String>> = remember { viewModel._state.toList() }

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

            AnimationLoader(resId = R.raw.wallet_note)

            TextComponent(
                text = stringResource(R.string.recovery_phrase_title),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            TextComponent(
                text = stringResource(R.string.recovery_phrase_content),
            )

            FlowRow(Modifier.padding(12.dp)) {
                Card(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    shape = MaterialTheme.shapes.small,
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ),
                    elevation = customCardElevation
                ) {
                    PhraseListComponent(phraseList)
                }
            }


            ButtonComponent(text = stringResource(R.string.done)) {
                val list = mutableListOf<Pair<Int, String>>()
                list.addAll(phraseList)
                val phraseListParcelable = PhraseList(list)
                navController.navigate("test_phrase_screen/$phraseListParcelable")
            }

        }
    }
}