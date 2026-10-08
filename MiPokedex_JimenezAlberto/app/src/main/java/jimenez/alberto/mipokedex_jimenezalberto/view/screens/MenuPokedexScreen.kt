package jimenez.alberto.mipokedex_jimenezalberto.view.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import jimenez.alberto.mipokedex_jimenezalberto.model.data.pokemonList
import jimenez.alberto.mipokedex_jimenezalberto.view.components.FavoritesRow
import jimenez.alberto.mipokedex_jimenezalberto.view.components.PokedexGrid

@Composable
fun MenuPokedexScreen(innerPadding: PaddingValues, onNavigateToDetail: (pokemon:Int)-> Unit) {
    val favoriteList = pokemonList.filter { it.favorite }

    Column(
        modifier = Modifier.padding(innerPadding)
    ) {
        Text(
            text = "Mis Favoritos",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 10.dp, top = 10.dp, bottom = 5.dp)
        )

        FavoritesRow(favoriteList = favoriteList)

        Text(
            text = "Todos mis pokemones",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 10.dp, top = 15.dp, bottom = 10.dp)
        )

        PokedexGrid(pokemonList = pokemonList,onNavigateToDetail)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview5() {
    MenuPokedexScreen(innerPadding = PaddingValues(0.dp),{})
}
