package com.banklannister.leagueoflegends.data.repository

import com.banklannister.leagueoflegends.domain.model.ChampionResponseModel
import com.banklannister.leagueoflegends.domain.repository.ApiRepository
import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.ktor.getApiResponse
import io.ktor.client.HttpClient

class ApiRepositoryImpl(
    private val httpClient: HttpClient,
) : ApiRepository {

    companion object {
        const val BASE_URL = "https://ddragon.leagueoflegends.com/cdn/9.19.1/data/en_US/"


        const val IMAGE_SPLASH_URL = "https://ddragon.leagueoflegends.com/cdn/img/champion/splash/"
        const val IMAGE_LOADING_URL =
            "https://ddragon.leagueoflegends.com/cdn/img/champion/loading/"
        const val IMAGE_SQUARE_URL = "https://ddragon.leagueoflegends.com/cdn/9.19.1/img/champion/"
        const val IMAGE_PASSIVE_URL = "https://ddragon.leagueoflegends.com/cdn/9.19.1/img/passive/"
        const val IMAGE_ABILITY_URL = "https://ddragon.leagueoflegends.com/cdn/9.19.1/img/spell/"

    }

    override suspend fun getAllChampions(): ApiResponse<ChampionResponseModel> =
        httpClient.getApiResponse("champion.json")

    override suspend fun getChampionByName(name: String): ApiResponse<ChampionResponseModel> =
        httpClient.getApiResponse("champion/$name.json")
}