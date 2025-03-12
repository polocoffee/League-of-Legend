package com.banklannister.leagueoflegends.ui.screen.champion_detail

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.banklannister.leagueoflegends.domain.model.ChampionModel
import com.banklannister.leagueoflegends.domain.repository.ApiRepository
import com.banklannister.leagueoflegends.ui.util.ChampionDetail
import com.skydoves.sandwich.onSuccess
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ChampionDetailViewModel @Inject constructor(
    private val apiRepository: ApiRepository,
    private val saveStateHandle: SavedStateHandle,
) : ViewModel() {

    var champions = mutableStateOf<ChampionModel?>(null)


    init {

        val args = saveStateHandle.toRoute<ChampionDetail>()

        viewModelScope.launch {
            apiRepository.getChampionByName(args.name)
                .onSuccess {
                    champions.value = data.champion.values.firstOrNull()
                }
        }
    }
}