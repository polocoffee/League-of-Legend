package com.banklannister.leagueoflegends

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.banklannister.leagueoflegends.ui.screen.champion_detail.ChampionDetailScreen
import com.banklannister.leagueoflegends.ui.screen.champion_detail.ChampionDetailViewModel
import com.banklannister.leagueoflegends.ui.screen.champion_list.ChampionListScreen
import com.banklannister.leagueoflegends.ui.screen.champion_list.ChampionListViewModel
import com.banklannister.leagueoflegends.ui.theme.LeagueOfLegendsTheme
import com.banklannister.leagueoflegends.ui.util.ChampionDetail
import com.banklannister.leagueoflegends.ui.util.ChampionList
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LeagueOfLegendsTheme  {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = ChampionList) {

                    composable<ChampionList> {
                        val viewModel = hiltViewModel<ChampionListViewModel>()

                        val state by viewModel.state.collectAsStateWithLifecycle()

                        ChampionListScreen(
                            state = state,
                            onValueChange = viewModel::onSearchTextChange,
                            navigate = { name ->
                                navController.navigate(ChampionDetail(name))
                            }
                        )
                    }

                    composable<ChampionDetail> {
                        val viewModel = hiltViewModel<ChampionDetailViewModel>()

                        viewModel.champions.value?.let {
                            ChampionDetailScreen(champion = it)
                        }
                    }
                }
            }
        }
    }
}






