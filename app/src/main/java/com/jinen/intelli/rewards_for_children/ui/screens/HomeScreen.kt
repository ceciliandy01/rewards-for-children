package com.jinen.intelli.rewards_for_children.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.jinen.intelli.rewards_for_children.data.model.Reward
import com.jinen.intelli.rewards_for_children.ui.navigation.Screen
import com.jinen.intelli.rewards_for_children.ui.viewmodel.MainViewModel

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: MainViewModel = hiltViewModel()
) {
    val rewards by viewModel.rewards.collectAsState()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate(Screen.AddEditReward.route)
            }) {
                Icon(Icons.Default.Add, contentDescription = "Add Reward")
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            items(rewards) { reward ->
                RewardItem(reward = reward)
            }
        }
    }
}

@Composable
fun RewardItem(reward: Reward) {
    Card(modifier = Modifier.padding()) {
        Column {
            Text(text = reward.title)
            Text(text = reward.description)
            Text(text = reward.points.toString())
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
}
