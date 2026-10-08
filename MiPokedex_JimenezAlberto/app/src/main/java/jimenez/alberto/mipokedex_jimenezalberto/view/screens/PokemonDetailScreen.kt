package jimenez.alberto.mipokedex_jimenezalberto.view.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import jimenez.alberto.mipokedex_jimenezalberto.R
import jimenez.alberto.mipokedex_jimenezalberto.model.data.getPokemonByNumber
import jimenez.alberto.mipokedex_jimenezalberto.model.data.pokemonList
import jimenez.alberto.mipokedex_jimenezalberto.ui.theme.MiPokedex_JimenezAlbertoTheme
import jimenez.alberto.mipokedex_jimenezalberto.ui.theme.black
import jimenez.alberto.mipokedex_jimenezalberto.ui.theme.gray
import jimenez.alberto.mipokedex_jimenezalberto.ui.theme.red
import jimenez.alberto.mipokedex_jimenezalberto.ui.theme.white
import jimenez.alberto.mipokedex_jimenezalberto.utilities.getColorByType

@Composable
fun PokemonDetailScreen(innerPadding: PaddingValues, pokemon: Int){
    val pokemon = getPokemonByNumber(pokemon)
    val (backgroundColor,textColor) = getColorByType(pokemon.type)

    val currentIndex = pokemonList.indexOfFirst { it.number == pokemon.number }

    val prevPokemon = if (currentIndex > 0) pokemonList[currentIndex - 1] else pokemonList.last()
    val nextPokemon = if (currentIndex < pokemonList.lastIndex) pokemonList[currentIndex + 1] else pokemonList.first()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
    ) {
        Image(
            painter = painterResource(R.drawable.pokeball),
            contentDescription = "Pokeball",
            modifier = Modifier
                .size(225.dp, 350.dp)
                .offset(200.dp,35.dp).rotate(30f)
        )
        Image(
            painter = painterResource(R.drawable.favorite_icon),
            contentDescription = "Favorito",
            modifier = Modifier
                .size(90.dp)
                .align(Alignment.TopEnd)
                .padding(top = 35.dp, end = 35.dp)
        )

        Column(
            modifier = Modifier
                .padding(24.dp)
                .offset(10.dp,75.dp)
        )   {
            Text(
                text = pokemon.name,
                fontSize = 32.sp,
                color = white,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "#" + pokemon.number.toString(),
                fontSize = 16.sp,
                color = gray
            )
        }

        Box(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
                .height(575.dp)
                .align(Alignment.BottomCenter)
                .background(white, shape = RoundedCornerShape(40.dp))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 80.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Box(
                    modifier = Modifier
                        .background(backgroundColor, shape = RoundedCornerShape(50))
                        .padding(horizontal = 24.dp, vertical = 6.dp)
                ) {
                    Text(
                        text = pokemon.type,
                        fontWeight = FontWeight.Bold,
                        color = textColor
                    )
                }

                Spacer(modifier = Modifier.height(32.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 40.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Row(
                            modifier = Modifier
                                .padding(bottom = 18.dp),
                            horizontalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            Text(
                                text = "Altura",
                                color = red,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = pokemon.height.toString(),
                                color = gray
                            )
                        }
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            Text(
                                text = "Peso",
                                color = red,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = pokemon.weight.toString(),
                                color = gray
                            )
                        }
                    }

                    Column(
                        verticalArrangement = Arrangement.spacedBy(18.dp)
                    ) {
                        Text(
                            text = "Habilidad",
                            color = red,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = pokemon.ability,
                            color = gray
                        )
                    }
                }

                Spacer(modifier = Modifier.height(40.dp))

                Text(
                    text = pokemon.description,
                    color = gray,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 32.dp)
                )

                Spacer(modifier = Modifier.height(100.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(prevPokemon.image),
                            contentDescription = "Arbok",
                            modifier = Modifier.size(60.dp)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.previous_icon),
                                contentDescription = "Anterior",
                                modifier = Modifier.size(24.dp)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = "N°"+prevPokemon.number+" "+prevPokemon.name,
                                color = Color.DarkGray,
                                fontSize = 14.sp
                            )
                        }
                    }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(nextPokemon.image),
                            contentDescription = "Raichu",
                            modifier = Modifier.size(60.dp)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = nextPokemon.name+" N°"+nextPokemon.number,
                                color = Color.DarkGray,
                                fontSize = 14.sp
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Image(
                                painter = painterResource(id = R.drawable.next_icon),
                                contentDescription = "Siguiente",
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    }
                }
            }
        }

        Image(
            painter = painterResource(pokemon.image),
            contentDescription = "${pokemon.name} image",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(200.dp)
                .align(Alignment.TopCenter)
                .offset(y = 140.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun pokemonDetailScreenPreview() {
    MiPokedex_JimenezAlbertoTheme {
        PokemonDetailScreen(PaddingValues(10.dp),4)
    }
}