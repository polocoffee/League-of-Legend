package com.banklannister.leagueoflegends.domain.repository

import com.banklannister.leagueoflegends.domain.model.ChampionResponseModel
import com.skydoves.sandwich.ApiResponse

interface ApiRepository {


    suspend fun getAllChampions(): ApiResponse<ChampionResponseModel>

    suspend fun getChampionByName(name: String): ApiResponse<ChampionResponseModel>
}