package components

import androidx.compose.runtime.Composable
import Dominio.Pokemon
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import data.bulbasaur
import jimenez.alberto.mipokedex_jimenezalberto.ui.theme.Green
import jimenez.alberto.mipokedex_jimenezalberto.ui.theme.MiPokedex_JimenezAlbertoTheme

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
        Text(
            text = pokemon.number.toString(),
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .align(Alignment.Top)
                .background(color = Green, shape = CircleShape)
                .size(32.dp)
                .wrapContentHeight(Alignment.CenterVertically)
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