package com.dqitech.galleryphotogrid

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

@Composable
fun GalleryScreen(imageUriList: List<Uri>) {
    val context = LocalContext.current
    Column(modifier = Modifier.padding(16.dp)) {
        Button(onClick = {
            (context as? MainActivity)?.requestStoragePermission()
        }) {
            Text("Select Photos")
        }
        Spacer(modifier = Modifier.height(16.dp))
        LazyVerticalGrid(
            GridCells.Fixed(3)) {
            items(imageUriList.size) { index ->
                // ImageItem(imageUriList[index])
                val reversedIndex = imageUriList.size - 1 - index
                ImageItem(imageUriList[reversedIndex])
            }
        }
    }
}

@Composable
fun ImageItem(uri: Uri) {
    val painter: Painter = rememberAsyncImagePainter(uri)
    Image(
        painter = painter,
        contentDescription = null,
        modifier = Modifier
            .size(142.dp)
            .fillMaxWidth()
            .padding(horizontal = 0.4.dp, vertical = 0.4.dp),
        contentScale = ContentScale.FillHeight
    )
}