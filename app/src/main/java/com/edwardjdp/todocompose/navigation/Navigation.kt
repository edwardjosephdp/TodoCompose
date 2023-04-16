package com.edwardjdp.todocompose.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.edwardjdp.todocompose.navigation.destinations.listComposable
import com.edwardjdp.todocompose.navigation.destinations.splashComposable
import com.edwardjdp.todocompose.navigation.destinations.taskComposable
import com.edwardjdp.todocompose.ui.viewmodels.SharedViewModel
import com.edwardjdp.todocompose.util.Constants.SPLASH_SCREEN

@ExperimentalAnimationApi
@ExperimentalMaterialApi
@Composable
fun SetupNavigation(
    navController: NavHostController,
    sharedViewModel: SharedViewModel
) {
    val screen = remember(navController) {
        Screens(navController = navController)
    }

    NavHost(
        navController = navController,
        startDestination = SPLASH_SCREEN,
    ) {
        splashComposable(
            navigateToListScreen = screen.splash
        )
        listComposable(
            navigateToTaskScreen = screen.list,
            sharedViewModel = sharedViewModel
        )
        taskComposable(
            navigateToListScreen = screen.task,
            sharedViewModel = sharedViewModel
        )
    }
}
