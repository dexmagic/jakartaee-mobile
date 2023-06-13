package jakarta.ee

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import jakarta.ee.ui.theme.JakartaEETheme
import org.eclipse.ee4j.samples.unmarahal_read.Main

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JakartaEETheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val context  = LocalContext.current
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
    Button(onClick = {
        Toast.makeText(context, "button pressed", Toast.LENGTH_SHORT).show()
        Main.main(context)
    }){
        Text("Process XML")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JakartaEETheme {
        Greeting("Android")
    }
}