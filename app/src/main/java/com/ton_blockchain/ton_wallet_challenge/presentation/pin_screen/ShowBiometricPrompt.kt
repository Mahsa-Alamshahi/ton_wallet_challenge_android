package com.ton_blockchain.ton_wallet_challenge.presentation.pin_screen.biometric_screen

import android.widget.Toast
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import com.ton_blockchain.ton_wallet_challenge.R
import com.ton_blockchain.ton_wallet_challenge.common.navigation.TonWalletScreens
import java.util.concurrent.Executor




private lateinit var executor: Executor
private lateinit var biometricPrompt: BiometricPrompt
private lateinit var promptInfo: BiometricPrompt.PromptInfo



fun showBiometricPrompt(context: FragmentActivity, navController: NavController) {


    executor = ContextCompat.getMainExecutor(context)

    biometricPrompt = BiometricPrompt(context, executor,
        object : BiometricPrompt.AuthenticationCallback() {


            override fun onAuthenticationError(errorCode: Int,
                                               errString: CharSequence) {
                super.onAuthenticationError(errorCode, errString)

                Toast.makeText(context,
                    "Authentication error: $errString", Toast.LENGTH_SHORT)
                    .show()
            }

            override fun onAuthenticationSucceeded(
                result: BiometricPrompt.AuthenticationResult) {
                super.onAuthenticationSucceeded(result)
                navController.navigate(
                    TonWalletScreens.MainScreen.route
                )
            }

            override fun onAuthenticationFailed() {
                super.onAuthenticationFailed()
                Toast.makeText(
                    context, context.getString(R.string.your_fingerprint_does_not_match),
                    Toast.LENGTH_LONG
                ).show()
            }
        })

    promptInfo = BiometricPrompt.PromptInfo.Builder()
        .setTitle(context.getString(R.string.biometric_log_in))
        .setSubtitle(context.getString(R.string.log_in_using_your_biometric_credential))
        .setNegativeButtonText(context.getString(R.string.cancel))
        .build()


        biometricPrompt.authenticate(promptInfo)

}