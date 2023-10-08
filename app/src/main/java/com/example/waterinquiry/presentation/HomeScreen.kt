package com.example.waterinquiry.presentation

import android.annotation.SuppressLint
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Tab
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import com.example.waterinquiry.R
import com.example.waterinquiry.navigation.Screen
import com.example.waterinquiry.ui.common.AppThemeTextField
import com.example.waterinquiry.ui.theme.Border
import com.example.waterinquiry.ui.theme.Light
import com.example.waterinquiry.ui.theme.Primary
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController) {
    var countryName by remember { mutableStateOf(TextFieldValue("")) }
    val pagerState = rememberPagerState()
    val categories = listOf("Swimming", "Aquatic life", "Eating fish", "Drinking water")

    val indicator = @Composable { tabPositions: List<androidx.compose.material3.TabPosition> ->
        CustomIndicator(tabPositions, pagerState)
    }

    val coroutineScope = rememberCoroutineScope()
    Scaffold(topBar = {

        Column(
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            AppThemeTextField(
                modifier = Modifier.fillMaxWidth(),
                textFieldValue = countryName,
                onTextFieldValueChange = { countryName = it },
                placeholder = {
                    androidx.compose.material3.Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Search...",
                        fontSize = 14.sp,
                        color = Color.Gray,
                        textAlign = TextAlign.Start
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "searchButton",
                        tint = Primary
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                keyboardActions = KeyboardActions(onSearch = {})
            )

            androidx.compose.material3.ScrollableTabRow(
                modifier = Modifier
                    .background(Light)
                    .height(50.dp),
                selectedTabIndex = pagerState.currentPage,
                containerColor = Light,
                indicator = indicator
            ) {
                categories.forEachIndexed { index, title ->
                    Tab(
                        modifier = Modifier.zIndex(2f),
                        selected = pagerState.currentPage == index,
                        onClick = {
                            coroutineScope.launch {
                                pagerState.animateScrollToPage(index)
                            }
                        },
                        text = { Text(text = title, color = Color.White) })
                }
            }
        }
    }, backgroundColor = Light) {
        HorizontalPager(
            modifier = Modifier
                .background(Light)
                .fillMaxWidth(),
            count = categories.size,
            state = pagerState
        ) { page ->
            when (page) {
                0 -> {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 20.dp)
                    ) {

                        items(15) {
                            RiverCard(navController)
                        }
                    }
                }

                1 -> {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 20.dp, vertical = 20.dp)
                    ) {
                        items(4) {
                            RiverCard(navController)
                        }
                    }
                }

                2 -> {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 20.dp)
                    ) {

                        items(11) {
                            RiverCard(navController)
                        }
                    }
                }

                3 -> {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 20.dp)
                    ) {

                        items(6) {
                            RiverCard(navController)
                        }
                    }
                }

                4 -> {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 20.dp)
                    ) {
                        items(3) {
                            RiverCard(navController)
                        }
                    }
                }
            }
        }

    }
}


@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomeScreenTopBar() {
    var countryName by remember { mutableStateOf(TextFieldValue("")) }
    val pagerState = rememberPagerState()
    val categories = listOf("Swimming", "Aquatic life", "Eating fish", "Drinking water")



    Column(
        modifier = Modifier.padding(horizontal = 20.dp, vertical = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        AppThemeTextField(
            modifier = Modifier.fillMaxWidth(),
            textFieldValue = countryName,
            onTextFieldValueChange = { countryName = it },
            placeholder = {
                androidx.compose.material3.Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Search...",
                    fontSize = 14.sp,
                    color = Color.Gray,
                    textAlign = TextAlign.Start
                )
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "searchButton",
                    tint = Primary
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            keyboardActions = KeyboardActions(onSearch = {})
        )


    }
}


@Composable
fun RiverCard(navController: NavController) {
    Row(
        modifier = Modifier
            .padding(vertical = 10.dp)
            .background(color = Primary, shape = RoundedCornerShape(10.dp))
            .border(width = 3.dp, color = Border, shape = RoundedCornerShape(10.dp))
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 10.dp)
            .clickable {
                navController.navigate(Screen.InfoScreen.route)
            },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Hudson River",
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            color = Color.White
        )
        Icon(
            painter = painterResource(id = R.drawable.good),
            contentDescription = "good",
            tint = Color.Green,
            modifier = Modifier.size(30.dp)
        )
    }
}

//@Composable
//fun CategoryCard() {
//    Row(
//        modifier = Modifier
//            .background(color = Primary, shape = RoundedCornerShape(15.dp))
//            .border(width = 3.dp, color = Border, shape = RoundedCornerShape(15.dp))
//            .padding(5.dp),
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//        Text(
//            text = "Swimming",
//            fontWeight = FontWeight.Medium,
//            fontSize = 16.sp,
//            color = Color.White
//        )
//    }
//}

@OptIn(ExperimentalPagerApi::class, ExperimentalMaterial3Api::class)
@Composable
private fun CustomIndicator(
    tabPositions: List<androidx.compose.material3.TabPosition>,
    pagerState: PagerState
) {
    val transition = updateTransition(pagerState.currentPage, label = "")
    val indicatorStart by transition.animateDp(
        transitionSpec = {
            if (initialState < targetState) {
                spring(dampingRatio = 1f, stiffness = 50f)
            } else {
                spring(dampingRatio = 1f, stiffness = 1000f)
            }
        }, label = ""
    ) {
        tabPositions[it].left
    }

    val indicatorEnd by transition.animateDp(
        transitionSpec = {
            if (initialState < targetState) {
                spring(dampingRatio = 1f, stiffness = 1000f)
            } else {
                spring(dampingRatio = 1f, stiffness = 50f)
            }
        }, label = ""
    ) {
        tabPositions[it].right
    }

    Box(
        Modifier
            .offset(x = indicatorStart)
            .wrapContentSize(align = Alignment.BottomStart)
            .width(indicatorEnd - indicatorStart)
            .padding(2.dp)
            .fillMaxSize()
            .background(color = Primary, RoundedCornerShape(50))
            .border(
                androidx.compose.foundation.BorderStroke(2.dp, Border),
                RoundedCornerShape(50)
            )
            .zIndex(1f)
    )
}

