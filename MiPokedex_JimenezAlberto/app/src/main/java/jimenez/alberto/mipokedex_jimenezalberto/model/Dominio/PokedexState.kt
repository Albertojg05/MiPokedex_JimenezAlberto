package jimenez.alberto.mipokedex_jimenezalberto.model.Dominio

data class PokedexState(
    val team: List<Pokemon> = emptyList(),
    val lastCaptured: Pokemon? = null
)
