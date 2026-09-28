package jimenez.alberto.mipokedex_jimenezalberto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import jimenez.alberto.mipokedex_jimenezalberto.ui.theme.MiPokedex_JimenezAlbertoTheme
import jimenez.alberto.mipokedex_jimenezalberto.ui.theme.*

class PokedexCompose : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MiPokedex_JimenezAlbertoTheme {
                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->
                    Pokedex()
                }
            }
        }
    }
}

@Composable
fun Pokedex() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(yellow)
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
                text = "Pikachu",
                fontSize = 32.sp,
                color = white,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "#025",
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
                        .background(yellow, shape = RoundedCornerShape(50))
                        .padding(horizontal = 24.dp, vertical = 6.dp)
                ) {
                    Text(
                        text = "Eléctrico",
                        fontWeight = FontWeight.Bold,
                        color = black
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
                                text = "0,4m",
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
                                text = "6,0kg",
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
                            text = "Elec. Estática",
                            color = gray
                        )
                    }
                }

                Spacer(modifier = Modifier.height(40.dp))

                Text(
                    text = "Cuando se enfada, este Pokémon\ndescarga la energía que almacena\nen el interior de las bolsas de sus\nmejillas.",
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
                            painter = painterResource(id = R.drawable.arbok),
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
                                text = "Arbok N.º0024",
                                color = Color.DarkGray,
                                fontSize = 14.sp
                            )
                        }
                    }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.raichu),
                            contentDescription = "Raichu",
                            modifier = Modifier.size(60.dp)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Raichu N.º0026",
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
            painter = painterResource(R.drawable.pikachu),
            contentDescription = "Pikachu",
            modifier = Modifier.offset(125.dp,175.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MiPokedex_JimenezAlbertoTheme {
        Pokedex()
    }
}