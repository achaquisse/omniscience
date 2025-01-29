package com.achaquisse.omniscience.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CourseBoxItem(name: String){
    Box(){
        Text(text = name)
    }
}

@Composable
@Preview
private fun CourseBoxItemPreview(){

}