package com.edwardjdp.todocompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.edwardjdp.todocompose.navigation.SetupNavigation
import com.edwardjdp.todocompose.ui.theme.ToDoComposeTheme
import com.edwardjdp.todocompose.ui.viewmodels.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalMaterialApi
@ExperimentalAnimationApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController
    private val sharedViewModel: SharedViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToDoComposeTheme {
                navController = rememberNavController()
                SetupNavigation(
                    navController = navController,
                    sharedViewModel = sharedViewModel
                )
            }
        }
    }
}
