package com.hbs.composestudy.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview
import com.hbs.composestudy.R
import com.hbs.composestudy.model.Food
import com.hbs.composestudy.theme.ComposeStudyTheme


class ChapterThreeCompose : ChapterCompose() {
    @Composable
    fun ColorTextStyle(color: Color): TextStyle {
        return TextStyle(color = color, fontSize = 16.sp)
    }

    @Composable
    fun FoodCard(food: Food, onClick: (Food) -> Unit) {
        val cardPadding = 16.dp
        val foodImage = imageResource(food.imageResource)
        Row {
            Spacer(modifier = Modifier.weight(1f))
            Card(
                shape = RoundedCornerShape(8.dp),
                elevation = 8.dp,
                backgroundColor = MaterialTheme.colors.surface,
                modifier = Modifier.weight(8f)
            ) {
                Column(
                    Modifier
                        .clickable(onClick = {
                            onClick(food)
                        })
                        .padding(cardPadding)
                        .fillMaxWidth()
                ) {
                    Image(
                        foodImage,
                        modifier = Modifier.fillMaxSize().clip(shape = RoundedCornerShape(8.dp)),
                        contentScale = ContentScale.Crop
                    )
                    Column {
                        Text(food.name)
                        Text(food.content)
                    }
                }
            }
            Spacer(modifier = Modifier.weight(1f))
        }

    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        ComposeStudyTheme {
            ContentView("감자튀김!", makeFoodItems())
        }
    }

    @Composable
    override fun ContentView(name: String, foodItems: List<Food>) {
        ScrollableColumn(Modifier.fillMaxSize().wrapContentSize(Alignment.Center)) {
            foodItems.forEach { food ->
                Spacer(Modifier.padding(16.dp))
                FoodCard(food, onClick = { food ->

                })
            }
        }
    }

    private fun makeFoodItems(): List<Food> {
        return listOf(
            Food(
                R.drawable.french_fries,
                "감자튀김",
                "감자튀김은 맛있어."
            ),
            Food(
                R.drawable.french_fries,
                "감자튀김",
                "감자튀김은 맛있어."
            ),
            Food(
                R.drawable.french_fries,
                "감자튀김",
                "감자튀김은 맛있어."
            ),
            Food(
                R.drawable.french_fries,
                "감자튀김",
                "감자튀김은 맛있어."
            )
        )
    }
}