package com.example.thatdailydo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.thatdailydo.ui.theme.ThatDailyDoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var Daily_Meals by remember {
                mutableStateOf("")
            }
            
            var Meals_Name by remember{
                mutableStateOf("")
            }
            
           Column (
               horizontalAlignment =  Alignment.CenterHorizontally,
               modifier =  Modifier.fillMaxSize()
           ) {
               Text(
                   text = "ThatDailyDo",
                   fontSize = 30.sp,
                   fontWeight = FontWeight.Black
               )

               Divider()
               Spacer(modifier = Modifier.size(30.dp))

               OutlinedTextField(
                   value = Daily_Meals, 
                   onValueChange = {text ->
                       Daily_Meals = text
                       
                   },
                   placeholder = {
                       Text(text = "Enter first name of Meals")
                   }
               )
               Spacer(modifier = Modifier.size(30.dp))
               Row {
                   Button(onClick = {
                       Meals_Name= when(Daily_Meals){
                           "Breakfast" -> "Greek yogurt with mixed berries and a drizzle of honey."
                           "Snack" -> "Sliced apple with peanut butter."
                           "Lunch" -> " Grilled chicken wrap with lettuce, avocado, and hummus."
                           "snack" -> "Small somthie with barries and banana"
                           "Supper" -> "pap and mogodu"
                           "desert" -> "ice cream"
                           else -> "Invalid Daily Meals!"

                       }
                   }) {
                      Text(text = "Search")
                   }
                   Button(onClick = {
                   Daily_Meals =""
                       Meals_Name =""
                   }) {
                       Text(text = "Clear")
                   }
               }

               Text(text = "Meals_Names by $Daily_Meals is:")
               Text(text = Meals_Name)
           }
        }
    }
}

