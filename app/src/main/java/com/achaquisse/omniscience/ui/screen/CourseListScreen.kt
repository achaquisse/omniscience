package com.achaquisse.omniscience.ui.screen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.achaquisse.omniscience.data.repository.CourseRepository
import com.achaquisse.omniscience.ui.component.CourseBoxItem
import com.example.omniscience.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CourseListScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_launcher_foreground),
                            contentDescription = "App Logo",
                            modifier = Modifier
                                .size(40.dp)
                                .padding(end = 8.dp)
                        )
                        Text("Courses")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White)
            )
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            CoursesGrid()
        }
    }
}

@Composable
fun CoursesGrid() {
    val courses = CourseRepository.listCourses()
    val context = LocalContext.current

    LazyVerticalGrid(
        columns = GridCells.Fixed(2), modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(courses.size) { index ->
            Surface(onClick = {
                Toast.makeText(context, courses[index].name, Toast.LENGTH_SHORT).show()
            }) {
                CourseBoxItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    name = courses[index].name
                )
            }
        }
    }
}

@Preview(device = Devices.PIXEL, showBackground = true)
@Composable
private fun CourseListScreenPreview() {
    CourseListScreen()
}