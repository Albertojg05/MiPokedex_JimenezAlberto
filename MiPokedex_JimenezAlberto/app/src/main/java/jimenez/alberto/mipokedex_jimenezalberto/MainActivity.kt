package jimenez.alberto.mipokedex_jimenezalberto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import jimenez.alberto.mipokedex_jimenezalberto.navigation.MyApp
import jimenez.alberto.mipokedex_jimenezalberto.ui.theme.MiPokedex_JimenezAlbertoTheme

class MenuPokedex : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MiPokedex_JimenezAlbertoTheme {
                Scaffold { innerPadding ->
                    MyApp(innerPadding = innerPadding)
                }
            }
        }
    }
}