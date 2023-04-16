package com.edwardjdp.todocompose.navigation.destinations

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.edwardjdp.todocompose.ui.screens.splash.SplashScreen
import com.edwardjdp.todocompose.util.Constants.SPLASH_SCREEN

@ExperimentalAnimationApi
@ExperimentalMaterialApi
fun NavGraphBuilder.splashComposable(
    navigateToListScreen: () -> Unit,
) {
    composable(
        route = SPLASH_SCREEN,
    ) {
        SplashScreen(navigateToListScreen = navigateToListScreen)
    }
}
