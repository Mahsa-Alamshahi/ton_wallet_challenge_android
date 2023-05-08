package com.ton_blockchain.ton_wallet_challenge.common.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.gson.Gson
import com.ton_blockchain.ton_wallet_challenge.domain.model.PhraseList
import com.ton_blockchain.ton_wallet_challenge.presentation.forget_phrase_dialog_screen.ForgetPhraseScreen
import com.ton_blockchain.ton_wallet_challenge.presentation.import_existing_wallet_screen.ImportExistingWalletScreen
import com.ton_blockchain.ton_wallet_challenge.presentation.main_screen.MainScreen
import com.ton_blockchain.ton_wallet_challenge.presentation.passcode_screen.ConfirmPasscodeScreen
import com.ton_blockchain.ton_wallet_challenge.presentation.passcode_screen.PasscodeScreen
import com.ton_blockchain.ton_wallet_challenge.presentation.pin_screen.PinScreen
import com.ton_blockchain.ton_wallet_challenge.presentation.ready_to_go_screen.ReadyToGoScreen
import com.ton_blockchain.ton_wallet_challenge.presentation.recovery_phrase.RecoveryPhraseScreen
import com.ton_blockchain.ton_wallet_challenge.presentation.test_phrase_screen.TestPhraseScreen
import com.ton_blockchain.ton_wallet_challenge.presentation.wallet_created.WalletCreatedSuccessfullyScreen
import com.ton_blockchain.ton_wallet_challenge.presentation.wallet_screen.WalletScreen

@Composable
fun Navigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = TonWalletScreens.ImportExistingWalletScreen.route
    ) {

        composable(route = TonWalletScreens.WalletScreen.route) {
            WalletScreen(navController = navController)
        }

        composable(
            route = TonWalletScreens.RecoveryPhraseScreen.route
        ) { entry ->
            RecoveryPhraseScreen(navController)
        }
        composable(
            TonWalletScreens.TestPhraseScreen.route + "/{phraseListArg}",
            arguments = listOf(navArgument("phraseListArg") {
                type = PhraseListArgType()
            })
        ) { navBackStackEntry ->
            val phraseList = navBackStackEntry.arguments?.getString("phraseListArg")
                ?.let { Gson().fromJson(it, PhraseList::class.java) }
            TestPhraseScreen(navController, phraseList)
        }
        composable(
            route = TonWalletScreens.MainScreen.route
        ) { backStackEntry ->
            MainScreen(navController)
        }
        composable(
            route = TonWalletScreens.WalletCreatedSuccessfullyScreen.route
        ) { entry ->
            WalletCreatedSuccessfullyScreen(navController)
        }
        composable(
            route = TonWalletScreens.ImportExistingWalletScreen.route
        ) { entry ->
            ImportExistingWalletScreen(navController)
        }
        composable(
            route = TonWalletScreens.ForgetPhraseScreen.route
        ) { entry ->
            ForgetPhraseScreen(navController)
        }
        composable(
            route = TonWalletScreens.PasscodeScreen.route
        ) { entry ->
            PasscodeScreen(navController)
        }
        composable(
            route = TonWalletScreens.ConfirmPasscodeScreen.route + "/{passcodeArg}",
            arguments = listOf(navArgument("passcodeArg") {
                type = NavType.StringType
            })
        ) { entry ->
            val passcodeArg = entry.arguments?.getString("passcodeArg")
            passcodeArg?.let { ConfirmPasscodeScreen(navController, it) }
        }
        composable(
            route = TonWalletScreens.ReadyToGoScreen.route
        ) { entry ->
            ReadyToGoScreen(navController)
        }
        composable(
            route = TonWalletScreens.PinScreen.route
        ) { entry ->
            PinScreen(navController)
        }
    }
}