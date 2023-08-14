package com.example.navcomponent

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController


@Composable
fun DetailsScreen(navController: NavHostController, profile: PlayerModel?) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            profile?.img?.let { ProfileImage(imageRes = it) }
            Spacer(modifier = Modifier.height(16.dp))
            profile?.name?.let {
                Text(
                    text = it,
                    style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp)
                )
            }
            Text(text = "Age: ${profile?.age}")
            Text(text = "Weight: ${profile?.weight} ")
            Text(text = "Height: ${profile?.height} ")
            Text(text = "Experience: ${profile?.experience} ")
            Spacer(modifier = Modifier.height(16.dp))
            Box(modifier = Modifier.weight(1f)) {
                LazyColumn {
                    item {
                        profile?.bio?.let { Text(text = "Bio: \n   $it") }
                    }
                }
            }
        }
    }
}


@Composable
fun ProfileImage(imageRes: Int) {
    Image(
        painter = painterResource(id = imageRes),
        contentDescription = null,
        modifier = Modifier
            .size(120.dp)
            .clip(CircleShape)
            .background(Color.Gray)
    )
}


