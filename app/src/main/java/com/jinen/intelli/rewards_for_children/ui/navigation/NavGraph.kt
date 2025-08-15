package com.jinen.intelli.rewards_for_children.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.jinen.intelli.rewards_for_children.ui.screens.AddEditRewardScreen
import com.jinen.intelli.rewards_for_children.ui.screens.HomeScreen
import com.jinen.intelli.rewards_for_children.ui.screens.StatisticsScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(Screen.AddEditReward.route) {
            AddEditRewardScreen(navController = navController)
        }
        composable(Screen.Statistics.route) {
            StatisticsScreen()
        }
    }
}
