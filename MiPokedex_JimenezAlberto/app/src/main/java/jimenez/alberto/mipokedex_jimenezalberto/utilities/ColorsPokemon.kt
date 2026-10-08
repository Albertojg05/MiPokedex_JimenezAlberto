package jimenez.alberto.mipokedex_jimenezalberto.utilities

import androidx.compose.ui.graphics.Color
import jimenez.alberto.mipokedex_jimenezalberto.ui.theme.*

fun getColorByType(type: String): Pair<Color, Color> {
    val primaryType = type.split("/")[0].trim()

    return when (primaryType) {
        "Normal" -> Pair(Normal, OffWhite)
        "Water" -> Pair(Water, OffWhite)
        "Fire" -> Pair(Fire, OffWhite)
        "Psych", "Psychic" -> Pair(Psych, OffWhite)
        "Ghost" -> Pair(Ghost, OffWhite)

        "Bug" -> Pair(Bug, DarkGray)
        "Poison" -> Pair(Poison, DarkGray)
        "Grass" -> Pair(Grass, DarkGray)
        "Ground" -> Pair(Ground, DarkGray)
        "Rock" -> Pair(Rock, DarkGray)
        "Electric" -> Pair(Electric, DarkGray)
        "Fairy" -> Pair(Fairy, DarkGray)
        "Fight", "Fighting" -> Pair(Fight, DarkGray)
        "Flying" -> Pair(Flying, DarkGray)

        else -> Pair(Color.LightGray, DarkGray)
    }
}