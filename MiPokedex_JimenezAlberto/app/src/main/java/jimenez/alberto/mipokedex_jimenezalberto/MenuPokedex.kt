package jimenez.alberto.mipokedex_jimenezalberto

import Dominio.Pokemon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import components.PokemonRow
import data.pokemonList
import jimenez.alberto.mipokedex_jimenezalberto.ui.theme.MiPokedex_JimenezAlbertoTheme

class MenuPokedex : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MiPokedex_JimenezAlbertoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MenuPokedex(
                        pokemonList = pokemonList,
                        innerPadding = innerPadding
                    )
                }
            }
        }
    }
}

@Composable
fun MenuPokedex(pokemonList: List<Pokemon>, innerPadding: PaddingValues) {
    LazyColumn(
        modifier = Modifier.padding(innerPadding)
    ) {
        items(pokemonList) { pokemon ->
            PokemonRow(pokemon = pokemon)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    MiPokedex_JimenezAlbertoTheme {
        MenuPokedex(
            pokemonList = pokemonList,
            innerPadding = PaddingValues(0.dp)
        )
    }
}