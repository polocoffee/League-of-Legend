package com.banklannister.leagueoflegends.ui.util

import kotlinx.serialization.Serializable

@Serializable
data object SplashScreen

@Serializable
data object ChampionList


@Serializable
data class ChampionDetail(val name:String)