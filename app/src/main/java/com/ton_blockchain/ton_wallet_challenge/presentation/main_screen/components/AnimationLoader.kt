package com.ton_blockchain.ton_wallet_challenge.presentation.main_screen.components

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieAnimatable
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun AnimationLoader(resId: Int, width: Dp, height: Dp, alignment: Alignment = Alignment.Center,
                    enableMergePaths: Boolean = true,){

    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(resId))
    val shouldReverse = remember { mutableStateOf(false) }
    val anim = rememberLottieAnimatable()
    if (shouldReverse.value.not())
        LaunchedEffect(composition) {
            anim.animate(composition = composition, speed = 1f)
            shouldReverse.value = true
        }
    if (shouldReverse.value) {
        LaunchedEffect(composition) {
            anim.animate(composition = composition, speed = -1f)
            shouldReverse.value = false
        }
    }


    LottieAnimation(
        composition,
        anim.value,
        modifier = Modifier.size(width, height),
        enableMergePaths = remember { enableMergePaths },
        alignment = alignment
    )

}