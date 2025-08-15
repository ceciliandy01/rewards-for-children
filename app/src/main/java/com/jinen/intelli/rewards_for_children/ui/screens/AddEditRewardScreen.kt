package com.jinen.intelli.rewards_for_children.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.jinen.intelli.rewards_for_children.data.model.Reward
import com.jinen.intelli.rewards_for_children.data.model.RewardType
import com.jinen.intelli.rewards_for_children.ui.viewmodel.MainViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddEditRewardScreen(
    navController: NavController,
    viewModel: MainViewModel = hiltViewModel()
) {
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var points by remember { mutableStateOf("") }

    Scaffold { paddingValues ->
        Column(modifier = Modifier.fillMaxSize()) {
            OutlinedTextField(
                value = title,
                onValueChange = { title = it },
                label = { Text("Title") }
            )
            OutlinedTextField(
                value = description,
                onValueChange = { description = it },
                label = { Text("Description") }
            )
            OutlinedTextField(
                value = points,
                onValueChange = { points = it },
                label = { Text("Points") }
            )
            Button(onClick = {
                val reward = Reward(
                    title = title,
                    description = description,
                    points = points.toInt(),
                    type = if (points.toInt() > 0) RewardType.REWARD else RewardType.PUNISHMENT
                )
                viewModel.addReward(reward)
                navController.popBackStack()
            }) {
                Text("Save")
            }
        }
    }
}

@Preview
@Composable
fun AddEditRewardScreenPreview() {
}
