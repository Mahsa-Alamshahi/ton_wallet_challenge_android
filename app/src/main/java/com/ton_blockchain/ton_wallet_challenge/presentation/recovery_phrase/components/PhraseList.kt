package com.ton_blockchain.ton_wallet_challenge.presentation.recovery_phrase.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
internal fun PhraseListComponent(phraseList: List<Pair<Int, String>>) {
    var counter = 0
    repeat(12) {
        Row(
            modifier = Modifier
                .padding(start = 2.dp, end = 2.dp)
                .fillMaxWidth()
        ) {

            Row(
                modifier = Modifier
                    .weight(1f)
                    .padding(4.dp),
                horizontalArrangement = Arrangement.Start
            ) {

                Text(
                    text = phraseList[counter].first.toString(),
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    color = Color.Gray,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.padding(2.dp)
                )
                Text(
                    text = phraseList[counter].second,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.padding(2.dp)
                )
            }

            Row(
                modifier = Modifier
                    .weight(1f)
                    .padding(4.dp),
                horizontalArrangement = Arrangement.Start
            ) {

                counter+= 1
                Text(
                    text =phraseList[counter].first.toString(),
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    color = Color.Gray,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.padding(2.dp)
                )
                Text(
                    text = phraseList[counter].second,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.padding(2.dp)
                )
            }
        }
        counter+=1
    }
}