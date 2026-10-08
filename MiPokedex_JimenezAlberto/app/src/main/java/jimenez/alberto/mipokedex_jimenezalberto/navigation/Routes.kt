package jimenez.alberto.mipokedex_jimenezalberto.navigation

import kotlinx.serialization.Serializable

@Serializable
object PokemonList

@Serializable
data class PokemonDetail(val pokemon: Int)