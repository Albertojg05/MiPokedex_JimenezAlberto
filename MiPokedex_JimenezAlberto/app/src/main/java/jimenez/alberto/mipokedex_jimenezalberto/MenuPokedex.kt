package jimenez.alberto.mipokedex_jimenezalberto

import Dominio.Pokemon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import components.FavoritePokemon
import components.PokemonCell
import components.PokemonRow
import data.pokemonList
import jimenez.alberto.mipokedex_jimenezalberto.ui.theme.MiPokedex_JimenezAlbertoTheme
import screens.MenuPokedexScreen

class MenuPokedex : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MiPokedex_JimenezAlbertoTheme {
                Scaffold { innerPadding ->
                    MenuPokedexScreen(innerPadding = innerPadding)
                }
            }
        }
    }
}

@Composable
fun MenuPokedex(pokemonList: List<Pokemon>) {
    LazyColumn {
        items(pokemonList) { pokemon ->
            PokemonRow(pokemon = pokemon)
        }
    }
}


@Composable
fun FavoritesRow(favoriteList: List<Pokemon>) {
    LazyRow {
        items(favoriteList) { pokemon ->
            FavoritePokemon(pokemon = pokemon)
        }
    }
}

@Composable
fun PokedexGrid(pokemonList: List<Pokemon>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        contentPadding = PaddingValues(horizontal = 5.dp, vertical = 20.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        items(pokemonList) { pokemon ->
            PokemonCell(pokemon = pokemon)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    MiPokedex_JimenezAlbertoTheme {
        MenuPokedex(
            pokemonList = pokemonList,
        )
    }
}