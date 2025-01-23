package com.example.mirinfo.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.CircleShape
import kotlinx.coroutines.delay
import com.example.mirinfo.R

@Composable
fun ImageSlideshow() {
    // List of image resources
    val images = listOf(
        R.drawable.erp,
        R.drawable.scm,
        R.drawable.placement_resource
    )

    // Initialize pager state
    val pagerState = rememberPagerState(pageCount = {
        images.size
    })

    // Auto change pages every 5 seconds
    LaunchedEffect(Unit) {
        while (true) {
            delay(5000) // 5 seconds delay
            val nextPage = (pagerState.currentPage + 1) % images.size // Loop back to the first image
            pagerState.animateScrollToPage(nextPage)
        }
    }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // HorizontalPager with the required 'pageCount' parameter
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
        ) { page ->
            // Display image based on the current page
            Image(
                painter = painterResource(id = images[page]),
                contentDescription = "Image $page",
                modifier = Modifier.fillMaxSize()
            )
        }

        // Custom page indicator (dot-based) to show which page the user is on
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(images.size) { page ->
                val isSelected = pagerState.currentPage == page
                Box(
                    modifier = Modifier
                        .padding(4.dp)
                        .size(8.dp)
                        .background(
                            color = if (isSelected) Color.Gray else Color.LightGray,
                            shape = CircleShape
                        )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewImageSlideshow() {
    ImageSlideshow()
}