package com.ton_blockchain.ton_wallet_challenge.presentation.recovery_phrase

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ton_blockchain.ton_wallet_challenge.R
import com.ton_blockchain.ton_wallet_challenge.common.ui.ButtonComponent
import com.ton_blockchain.ton_wallet_challenge.common.ui.TextComponent
import com.ton_blockchain.ton_wallet_challenge.common.ui.TopBarComponent
import com.ton_blockchain.ton_wallet_challenge.domain.model.PhraseList
import com.ton_blockchain.ton_wallet_challenge.presentation.main_screen.components.AnimationLoader
import com.ton_blockchain.ton_wallet_challenge.presentation.recovery_phrase.components.PhraseListComponent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun RecoveryPhraseScreen(
    navController: NavController, viewModel: RecoveryPhraseViewModel = hiltViewModel()
) {


    var isLoading by remember { mutableStateOf(true) }
    val state: MutableState<List<Pair<Int, String>>> =
        remember { mutableStateOf(emptyList<Pair<Int, String>>()) }


    LaunchedEffect(Unit) {
        isLoading = true
        withContext(Dispatchers.IO) {
            state.value = viewModel.generateRecoveryPhrase()
            println("*********************** " + state.value)
            isLoading = false
        }
    }

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

            if (isLoading) {

                Row(modifier = Modifier
                    .padding(32.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center) {
                    AnimationLoader(width = 64.dp, height = 64.dp, resId = R.raw.wallet_sync)
                }

            } else {
                FlowRow(Modifier.padding(12.dp)) {
                    PhraseListComponent(state.value)
                }
            }

            ButtonComponent(text = stringResource(R.string.done)) {
                val list = mutableListOf<String>()
                list.addAll(viewModel.createListOfWords(state.value))
                val phraseListParcelable = PhraseList(state.value)
                navController.navigate("test_phrase_screen/$phraseListParcelable")
            }

        }
    }
}


