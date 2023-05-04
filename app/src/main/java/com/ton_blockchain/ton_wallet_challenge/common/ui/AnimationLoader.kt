package com.ton_blockchain.ton_wallet_challenge.presentation.main_screen.components

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieAnimatable
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun AnimationLoader(
    resId: Int, width: Dp = 100.dp, height: Dp = 100.dp, alignment: Alignment = Alignment.Center,
    enableMergePaths: Boolean = true,
) {

    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(resId))
    val shouldReverse = remember { mutableStateOf(false) }
    val anim = rememberLottieAnimatable()


    val progress by animateLottieCompositionAsState(
        composition = composition,
        iterations = LottieConstants.IterateForever
    )

    LottieAnimation(
        composition,
//        anim.value,
        progress = { progress },
        modifier = Modifier
            .size(width, height)
            .wrapContentWidth(align = Alignment.CenterHorizontally),
        enableMergePaths = remember { enableMergePaths },
        alignment = alignment
    )

}