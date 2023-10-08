package com.example.waterinquiry.presentation

import android.annotation.SuppressLint
import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.waterinquiry.R
import com.example.waterinquiry.ui.theme.Border
import com.example.waterinquiry.ui.theme.Light

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun InfoScreen(navController: NavController) {
    Scaffold(backgroundColor = Light, topBar = {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "",
                tint = Color.White,
                modifier = Modifier
                    .size(32.dp)
                    .clickable {
                        navController.navigateUp()
                    }
            )
            Spacer(modifier = Modifier.width(100.dp))
            Text(text = "Hudson River", fontSize = 18.sp, color = Color.White)
        }
    }) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LazyVerticalGrid(
                modifier = Modifier
                    .padding(horizontal = 5.dp, vertical = 30.dp),
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(16.dp),
                horizontalArrangement = Arrangement.spacedBy(15.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp),
                content = {
                    items(6) {
                        InfoCard()
                    }
                })
            FactSection()
        }
    }
}


@Composable
fun InfoCard() {
    Box(
        modifier = Modifier
            .background(Border, shape = RoundedCornerShape(15.dp))
            .padding(10.dp)
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(5.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painterResource(id = R.drawable.fish),
                contentDescription = "",
                modifier = Modifier.size(35.dp),
                tint = Color.White
            )
            Text(
                text = "Fish quality",
                fontSize = 20.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            Text(text = "Good", fontSize = 17.sp, color = Color.Green, fontWeight = FontWeight.Bold)
        }
    }
}


@Composable
fun FactSection() {
    Column(
        modifier = Modifier.padding(vertical = 5.dp, horizontal = 20.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(text = "Interesting Facts", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Text(text = "1. About 50 fish died yesterday ", color = Color.White, fontSize = 16.sp)
        Text(
            text = "2. Hot water freezes faster than cold water",
            color = Color.White,
            fontSize = 16.sp
        )
        Text(
            text = "3. Mosquitoes kill about a million people every year",
            color = Color.White,
            fontSize = 16.sp
        )
        Text(
            text = "4. The tiger's skin has the same stripes as its fur.",
            color = Color.White,
            fontSize = 16.sp
        )
    }
}