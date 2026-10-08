package jimenez.alberto.mipokedex_jimenezalberto.view.components

import jimenez.alberto.mipokedex_jimenezalberto.model.Dominio.Pokemon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import jimenez.alberto.mipokedex_jimenezalberto.model.data.pokemonList
import jimenez.alberto.mipokedex_jimenezalberto.navigation.MyApp
import jimenez.alberto.mipokedex_jimenezalberto.ui.theme.MiPokedex_JimenezAlbertoTheme

@Composable
fun MenuPokedex(pokemonList: List<Pokemon>, onNavigateOnDetail: (pokemon: Int)-> Unit) {
    LazyColumn {
        items(pokemonList) { pokemon ->
            PokemonRow(pokemon = pokemon, onNavigateOnDetail)
        }
    }
}


@Composable
fun FavoritesRow(favoriteList: List<Pokemon>, onNavigateOnDetail: (pokemon: Int) -> Unit) {
    LazyRow {
        items(favoriteList) { pokemon ->
            FavoritePokemon(pokemon = pokemon,onNavigateOnDetail)
        }
    }
}

@Composable
fun PokedexGrid(pokemonList: List<Pokemon>, onNavigateOnDetail: (pokemon: Int)-> Unit) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        contentPadding = PaddingValues(horizontal = 5.dp, vertical = 20.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        items(pokemonList) { pokemon ->
            PokemonCell(pokemon = pokemon,onNavigateOnDetail)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MenuPokedexPreview() {
    MiPokedex_JimenezAlbertoTheme {
        MenuPokedex(
            pokemonList = pokemonList, {pokemon ->}
        )
    }
}