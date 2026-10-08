package jimenez.alberto.mipokedex_jimenezalberto.view.components

import androidx.compose.runtime.Composable
import jimenez.alberto.mipokedex_jimenezalberto.model.Dominio.Pokemon
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import jimenez.alberto.mipokedex_jimenezalberto.model.data.bulbasaur
import jimenez.alberto.mipokedex_jimenezalberto.ui.theme.MiPokedex_JimenezAlbertoTheme
import jimenez.alberto.mipokedex_jimenezalberto.ui.theme.OffWhite
import jimenez.alberto.mipokedex_jimenezalberto.utilities.getColorByType

@Composable
fun PokemonRow(pokemon: Pokemon){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Image(
            painter = painterResource(id = pokemon.image),
            contentDescription = "${pokemon.name} image",
            modifier = Modifier
                .width(80.dp)
                .padding(10.dp)
        )
        Column(
            modifier = Modifier.fillMaxWidth(0.7f),
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Text(
                text = pokemon.name,
                style = MaterialTheme.typography.labelLarge
            )
            Text(
                text = pokemon.description,
                fontSize = 10.sp
            )
            Row(
                modifier = Modifier.fillMaxWidth(0.85f),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Alto: ${pokemon.height}",
                    style = MaterialTheme.typography.labelMedium
                )

                Text(
                    text = "Peso: ${pokemon.weight}",
                    style = MaterialTheme.typography.labelMedium
                )
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        val pokemonColors = getColorByType(pokemon.type)

        NumberChip(
            text = pokemon.number.toString(),
            colors = pokemonColors,
            modifier = Modifier.align(Alignment.Top)
        )
    }
}

@Composable
fun FavoritePokemon(pokemon: Pokemon) {
    val colors = getColorByType(pokemon.type)

    Column(
        modifier = Modifier.padding(vertical = 15.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box {
            Box(
                modifier = Modifier.border(
                    BorderStroke(
                        width = 5.dp,
                        brush = Brush.sweepGradient(
                            colors = listOf(
                                colors.first,
                                OffWhite,
                                colors.first,
                                OffWhite,
                                colors.first
                            )
                        )
                    )
                )
            ) {
                Image(
                    painter = painterResource(id = pokemon.image),
                    contentDescription = "${pokemon.name} image",
                    modifier = Modifier
                        .padding(5.dp)
                        .width(75.dp)
                )
            }

            NumberChip(
                text = pokemon.number.toString(),
                colors = colors,
                modifier = Modifier.align(Alignment.BottomEnd)
            )
        }

        Text(
            text = pokemon.name,
            style = MaterialTheme.typography.labelLarge
        )
    }
}

@Composable
fun PokemonCell(pokemon: Pokemon, onNavigateToDetail: (pokemon: Int) -> Unit) {
    val colors = getColorByType(pokemon.type)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable(true, onClick = {onNavigateToDetail(pokemon.number)})
    ) {
        Box {
            Image(
                painter = painterResource(id = pokemon.image),
                contentDescription = "${pokemon.name} image",
                modifier = Modifier
                    .size(150.dp)
                    .padding(10.dp)
            )

            NumberChip(
                text = pokemon.number.toString(),
                colors = colors,
                modifier = Modifier.align(Alignment.TopEnd)
            )
        }

        Text(
            text = pokemon.name,
            style = MaterialTheme.typography.labelLarge
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    MiPokedex_JimenezAlbertoTheme {
        PokemonRow(bulbasaur)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview4() {
    FavoritePokemon(pokemon = bulbasaur)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview5() {
    PokemonCell(pokemon = bulbasaur, {})
}