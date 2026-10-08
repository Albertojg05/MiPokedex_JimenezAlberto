package jimenez.alberto.mipokedex_jimenezalberto.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import jimenez.alberto.mipokedex_jimenezalberto.view.screens.MenuPokedexScreen
import jimenez.alberto.mipokedex_jimenezalberto.view.screens.PokemonDetailScreen

@Composable
fun MyApp(innerPadding: PaddingValues){
    val navController = rememberNavController()

    NavHost(navController, startDestination = PokemonList){
        composable<PokemonList>{
            MenuPokedexScreen(innerPadding,{pokemon -> navController.navigate(PokemonDetail(pokemon))})
        }
        composable<PokemonDetail>{
            val pokemon = it.arguments?.getInt("pokemon") ?: -1
            PokemonDetailScreen(innerPadding, pokemon)
        }
    }
}