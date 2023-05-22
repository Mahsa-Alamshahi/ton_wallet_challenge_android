package com.ton_blockchain.ton_wallet_challenge.presentation.recovery_phrase.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ton_blockchain.ton_wallet_challenge.common.ui.TextComponent

@Composable
internal fun PhraseListComponent(phraseList: List<Pair<Int, String>>) {

    var counter = 0

    repeat(12) {
        Row(
            modifier = Modifier
                .padding(2.dp)
                .fillMaxWidth()
        ) {

            Row(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp)
                    .border(1.dp, Color.Black),
                horizontalArrangement = Arrangement.Start
            ) {


                TextComponent(
                    text = "${phraseList[counter].first}:  ",
                    textColor = Color.Gray,
                    textAlign = TextAlign.Start,
                    fontSize = 16.sp,
                    modifier = Modifier
                        .padding(4.dp)
                        .weight(.5f)
                        .align(Alignment.CenterVertically)
                )
                TextComponent(
                    text = phraseList[counter].second,
                    fontWeight = FontWeight.Bold,
                    textColor = Color.Black,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .padding(8.dp)
                        .weight(1.2f)
                )
            }


            Row(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 12.dp, end = 6.dp)
                    .border(1.dp, Color.Black), horizontalArrangement = Arrangement.Start
            ) {

                counter += 1

                TextComponent(
                    text = "${phraseList[counter].first}:  ",
                    textColor = Color.Gray,
                    textAlign = TextAlign.Start,
                    fontSize = 16.sp,
                    modifier = Modifier
                        .padding(4.dp)
                        .weight(.5f)
                        .align(Alignment.CenterVertically)
                )

                TextComponent(
                    text = phraseList[counter].second,
                    fontWeight = FontWeight.Bold,
                    textColor = Color.Black,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .padding(8.dp)
                        .weight(1.2f)
                )
            }
        }
        counter += 1
    }
}

