package com.ton_blockchain.ton_wallet_challenge.presentation.recovery_phrase.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NumberVerticalView() {
    val list = (1..10).map { it.toString() }

    LazyVerticalStaggeredGrid(
//        columns = GridCells.Adaptive(128.dp),
        columns = StaggeredGridCells.Fixed(2),
        modifier = Modifier.padding(8.dp),
        // content padding
        contentPadding = PaddingValues(
            start = 8.dp,
            top = 2.dp,
            end = 8.dp,
            bottom = 0.dp
        ),
        content = {
            items(list.size) { index ->
                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ),
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 8.dp,
                        pressedElevation = 2.dp,
                        focusedElevation = 4.dp
                    )
                ) {
                    Row(modifier = Modifier.fillMaxWidth().padding(4.dp),
//                    horizontalArrangement = Arrangement.Start,
//                    verticalAlignment = Alignment.CenterVertically
                    ) {

                    }
                    Text(
                        text = index.toString(),
                        fontWeight = FontWeight.Normal,
                        fontSize = 12.sp,
                        color = Color.Gray,
                        textAlign = TextAlign.Start,
                        modifier = Modifier.padding(2.dp)
                    )
                    Text(
                        text = "Word List",
                        fontWeight = FontWeight.Normal,
                        fontSize = 12.sp,
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(2.dp)
                    )
                }
            }
        }
    )
}