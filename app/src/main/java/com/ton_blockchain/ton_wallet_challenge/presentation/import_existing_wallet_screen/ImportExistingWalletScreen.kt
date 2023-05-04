package com.ton_blockchain.ton_wallet_challenge.presentation.import_existing_wallet_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ton_blockchain.ton_wallet_challenge.R
import com.ton_blockchain.ton_wallet_challenge.common.ui.ButtonComponent
import com.ton_blockchain.ton_wallet_challenge.common.ui.TextButtonComponent
import com.ton_blockchain.ton_wallet_challenge.common.ui.TextComponent
import com.ton_blockchain.ton_wallet_challenge.common.ui.TopBarComponent
import com.ton_blockchain.ton_wallet_challenge.presentation.import_existing_wallet_screen.components.TextFieldComponent
import com.ton_blockchain.ton_wallet_challenge.presentation.main_screen.components.AnimationLoader


@Composable
fun ImportExistingWalletScreen(navController: NavController) {


    val n = 24

    val list: MutableList<Pair<Int, String>> = (1..n).map { Pair(0, "") }.toMutableList()
    var phraseList: List<Pair<Int, String>> = mutableListOf()

    Scaffold(
        topBar = {
            TopBarComponent {
                navController.navigateUp()
            }
        },
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            item {

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

            }
            itemsIndexed(list) { index, item ->
                TextFieldComponent(index = index, list as ArrayList<Pair<Int, String>>)
            }

            item {
                ButtonComponent( text = stringResource(R.string.done)) {
                          navController.navigate("wallet_created_screen")
                }

                TextButtonComponent(text = stringResource(R.string.i_don_t_have_them)) {
                    navController.navigate("forget_phrase_screen")
                }

            }
        }
    }
}