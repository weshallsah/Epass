import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun InputBox(input: String, onChange: (String) -> Unit, inputname: String) {
    OutlinedTextField(
        modifier = Modifier
            .padding(horizontal = 15.dp)
            .fillMaxWidth(),
        value = input,
        onValueChange = onChange,
        label = { Text(text = inputname) },
        textStyle = TextStyle(
            fontSize = 18.sp,
            fontFamily = FontFamily.Default
        )
    )
}