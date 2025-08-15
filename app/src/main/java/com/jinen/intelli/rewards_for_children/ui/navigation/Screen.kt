package com.jinen.intelli.rewards_for_children.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home_screen")
    object AddEditReward : Screen("add_edit_reward_screen")
    object Statistics : Screen("statistics_screen")
}
