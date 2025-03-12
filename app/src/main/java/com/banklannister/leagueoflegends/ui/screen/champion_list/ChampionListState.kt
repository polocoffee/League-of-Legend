package com.banklannister.leagueoflegends.ui.screen.champion_list

import com.banklannister.leagueoflegends.domain.model.ChampionModel

data class ChampionListState(
    val searchText: String = "",
    val champions: List<ChampionModel> = emptyList(),
    val filterChampion : List<ChampionModel> = emptyList()
)