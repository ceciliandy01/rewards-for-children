package com.jinen.intelli.rewards_for_children.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jinen.intelli.rewards_for_children.data.model.Reward
import com.jinen.intelli.rewards_for_children.data.repository.RewardRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: RewardRepository
) : ViewModel() {

    private val _rewards = MutableStateFlow<List<Reward>>(emptyList())
    val rewards: StateFlow<List<Reward>> = _rewards.asStateFlow()

    init {
        repository.getAllRewards()
            .onEach { _rewards.value = it }
            .launchIn(viewModelScope)
    }

    fun addReward(reward: Reward) {
        viewModelScope.launch {
            repository.insertReward(reward)
        }
    }

    fun updateReward(reward: Reward) {
        viewModelScope.launch {
            repository.updateReward(reward)
        }
    }

    fun deleteReward(reward: Reward) {
        viewModelScope.launch {
            repository.deleteReward(reward)
        }
    }
}
