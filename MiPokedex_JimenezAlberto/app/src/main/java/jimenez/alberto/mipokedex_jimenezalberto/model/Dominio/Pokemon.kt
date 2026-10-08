package jimenez.alberto.mipokedex_jimenezalberto.model.Dominio

data class Pokemon(
    val name: String,
    val number: Int,
    val type: String,
    val description: String,
    val height: Float,
    val weight: Float,
    val favorite: Boolean,
    val ability: String,
    val image: Int
)
