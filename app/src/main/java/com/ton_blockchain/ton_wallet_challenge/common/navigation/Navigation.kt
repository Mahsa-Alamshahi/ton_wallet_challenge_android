package com.ton_blockchain.ton_wallet_challenge.common.navigation

import androidx.compose.runtime.Composable
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import com.dokar.sheets.rememberBottomSheetState
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.google.accompanist.navigation.material.ModalBottomSheetLayout
import com.google.accompanist.navigation.material.bottomSheet
import com.google.accompanist.navigation.material.rememberBottomSheetNavigator
import com.google.gson.Gson
import com.ton_blockchain.ton_wallet_challenge.domain.model.PhraseList
import com.ton_blockchain.ton_wallet_challenge.presentation.forget_phrase_screen.ForgetPhraseScreen
import com.ton_blockchain.ton_wallet_challenge.presentation.import_existing_wallet_screen.ImportExistingWalletScreen
import com.ton_blockchain.ton_wallet_challenge.presentation.main_screen.MainScreen
import com.ton_blockchain.ton_wallet_challenge.presentation.passcode_screen.ConfirmPasscodeScreen
import com.ton_blockchain.ton_wallet_challenge.presentation.passcode_screen.PasscodeScreen
import com.ton_blockchain.ton_wallet_challenge.presentation.pin_screen.PinScreen
import com.ton_blockchain.ton_wallet_challenge.presentation.qr_code_scanner_screen.QrCodeScannerScreen
import com.ton_blockchain.ton_wallet_challenge.presentation.ready_to_go_screen.ReadyToGoScreen
import com.ton_blockchain.ton_wallet_challenge.presentation.receive_screen.ReceiveScreen
import com.ton_blockchain.ton_wallet_challenge.presentation.recovery_phrase.RecoveryPhraseScreen
import com.ton_blockchain.ton_wallet_challenge.presentation.send_screen.SendResultScreen
import com.ton_blockchain.ton_wallet_challenge.presentation.send_screen.SendScreen
import com.ton_blockchain.ton_wallet_challenge.presentation.setting_screen.SettingScreen
import com.ton_blockchain.ton_wallet_challenge.presentation.test_phrase_screen.TestPhraseScreen
import com.ton_blockchain.ton_wallet_challenge.presentation.wallet_created.WalletCreatedScreen
import com.ton_blockchain.ton_wallet_challenge.presentation.wallet_screen.WalletScreen

@androidx.camera.core.ExperimentalGetImage
@OptIn(ExperimentalMaterialNavigationApi::class)
@Composable
fun Navigation(startDestination: String, context: FragmentActivity) {


    val sheetState = rememberBottomSheetState()
    val bottomSheetNavigator = rememberBottomSheetNavigator()
    val navController = rememberNavController(bottomSheetNavigator)


    ModalBottomSheetLayout(bottomSheetNavigator = bottomSheetNavigator) {

        NavHost(
            navController = navController, startDestination = startDestination
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
                route = TonWalletScreens.WalletCreatedScreen.route
            ) { entry ->
                WalletCreatedScreen(navController)
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
                PinScreen(navController, context)
            }
            bottomSheet(TonWalletScreens.SendScreen.route) {
                SendScreen(sheetState, navController)
            }
            composable(
                route = TonWalletScreens.SettingScreen.route
            ) { entry ->
                SettingScreen(navController)
            }
            composable(
                route = TonWalletScreens.QrCodeScannerScreen.route
            ) { entry ->
                QrCodeScannerScreen(navController)
            }
            composable(
                route = TonWalletScreens.ReceiveScreen.route
            ) { entry ->
                ReceiveScreen(navController)
            }
            composable(
                route = TonWalletScreens.SendResultScreen.route+ "/{wallet_address}/{amount}/{comment}",
                arguments = listOf(
                    navArgument("wallet_address") {
                        type = NavType.StringType
                        defaultValue = ""
                    },
                    navArgument("amount") {
                        type = NavType.FloatType
                        defaultValue = 0.0
                    },
                    navArgument("comment") {
                        type = NavType.StringType
                        defaultValue = ""
                    },
                ),
                deepLinks = listOf(navDeepLink {
                    uriPattern = "ton://transfer/{wallet_address}?amount={amount}&text={comment}"
                }),
            ) { backStackEntry ->
                val walletAddress = backStackEntry.arguments?.getString("wallet_address")
                val amount = backStackEntry.arguments?.getFloat("amount")
                val comment = backStackEntry.arguments?.getString("comment")
                SendResultScreen(
                    navController, walletAddress.toString(), amount, comment.toString()
                )
            }
        }
    }
}