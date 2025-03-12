package com.banklannister.leagueoflegends.ui.screen.champion_detail

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.banklannister.leagueoflegends.data.repository.ApiRepositoryImpl
import com.banklannister.leagueoflegends.domain.model.SpellModel


@Composable
fun ChampionSpell(
    spell: SpellModel,
    modifier: Modifier = Modifier,
) {

    ListItem(
        headlineContent = {
            Text(
                text = spell.name ?: ""
            )
        },
        supportingContent = {
            Text(
                text = spell.description ?: ""
            )
        },
        leadingContent = {
            AsyncImage(
                model = ApiRepositoryImpl.IMAGE_ABILITY_URL + "${spell.id}.png",
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(32.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
        }
    )

}