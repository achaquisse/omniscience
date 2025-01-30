package com.achaquisse.omniscience.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.math.abs
import kotlin.random.Random

@Composable
fun CourseBoxItem(modifier: Modifier = Modifier, name: String) {
    val initials = name.split(" ").map { it.first() }.joinToString("").replace("-","")
    val (circleColor, textColor) = getColorFromName(initials)

    Box(
        modifier = modifier
            .background(color = Color.LightGray.copy(alpha = 0.2f), shape = RoundedCornerShape(6.dp))
            .padding(16.dp)
    ) {
        Column {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(color = circleColor, shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = initials,
                    color = textColor,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = name, color = Color.Black,
                fontWeight = FontWeight.Bold, style = MaterialTheme.typography.bodyMedium)
        }
    }
}

private fun getColorFromName(name: String): Pair<Color, Color> {
    val hash = abs(name.hashCode())
    val rnd = Random(hash)
    val bgColor = Color(rnd.nextFloat(), rnd.nextFloat(), rnd.nextFloat(), 1f)
    val textColor = if ((bgColor.red * 0.299 + bgColor.green * 0.587 + bgColor.blue * 0.114) > 0.5) Color.Black else Color.White
    return Pair(bgColor, textColor)
}

@Composable
@Preview
private fun CourseBoxItemPreview() {
    CourseBoxItem(name = "Essential English - Course")
}