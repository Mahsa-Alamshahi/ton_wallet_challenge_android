package com.ton_blockchain.ton_wallet_challenge.common.ui

import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun TextComponent(
    text: String,
    textColor: Color = Color.Black,
    fontWeight: FontWeight = FontWeight.Normal,
    textAlign: TextAlign = TextAlign.Center,
    fontSize: TextUnit = 14.sp,
    modifier: Modifier,
    lineHeight: TextUnit = 18.sp
) {

    Text(
        text = text,
        color = textColor,
        fontWeight = fontWeight,
        textAlign = textAlign,
        style = LocalTextStyle.current.copy(lineHeight = lineHeight),
        fontSize = fontSize, modifier = modifier
    )


}