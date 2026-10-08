package jimenez.alberto.mipokedex_jimenezalberto.view.screens

import jimenez.alberto.mipokedex_jimenezalberto.R
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import jimenez.alberto.mipokedex_jimenezalberto.model.data.pokemonList
import jimenez.alberto.mipokedex_jimenezalberto.ui.theme.*
import jimenez.alberto.mipokedex_jimenezalberto.view.components.FavoritesRow
import jimenez.alberto.mipokedex_jimenezalberto.view.components.MenuPokedex
import jimenez.alberto.mipokedex_jimenezalberto.view.components.PokedexGrid

@Composable
fun MenuPokedexScreen(innerPadding: PaddingValues, onNavigateToDetail: (pokemon:Int)-> Unit) {
    val favoriteList = pokemonList.filter { it.favorite }

    var grid by remember { mutableStateOf(value = false) }

    Column(
        modifier = Modifier.padding(innerPadding)
    ) {
        Text(
            text = "Mis Favoritos",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 10.dp, top = 10.dp, bottom = 5.dp)
        )

        FavoritesRow(favoriteList = favoriteList,onNavigateToDetail)

        Text(
            text = "Todos mis pokemones",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 10.dp, top = 15.dp, bottom = 10.dp)
        )
        Switch(
            checked = grid,
            onCheckedChange = {
                grid = it
            },
            colors = SwitchDefaults.colors(
                checkedThumbColor = Green,
                checkedTrackColor = LightGreen,
                uncheckedThumbColor = Blue,
                uncheckedTrackColor = LightBlue,
                uncheckedBorderColor = Color.Transparent
            ),
            thumbContent = if (grid) {
                {
                    Icon(
                        painter = painterResource(R.drawable.grid_icon),
                        contentDescription = "grid icon",
                        modifier = Modifier.size(SwitchDefaults.IconSize)
                    )
                }
            } else {
                {
                    Icon(
                        painter = painterResource(id = R.drawable.list_icon),
                        contentDescription = "list icon",
                        modifier = Modifier.size(SwitchDefaults.IconSize)
                    )
                }
            }
        )

        if (grid) {
            PokedexGrid(pokemonList = pokemonList, onNavigateToDetail)
        } else {
            MenuPokedex(pokemonList = pokemonList, onNavigateToDetail)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview5() {
    MenuPokedexScreen(innerPadding = PaddingValues(0.dp),{})
}
