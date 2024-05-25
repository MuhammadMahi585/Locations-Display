package com.example.worldbeauty

import androidx.compose.material3.*
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
         DataDisplay()
        }
    }
}

@Composable
fun DataDisplay(){
    var dataNumber by remember { mutableStateOf(1) }
    if(dataNumber>4){
        dataNumber=4
    }
    if(dataNumber<1){
        dataNumber=1
    }
    val img = when (dataNumber){
        1->R.drawable.tajmahal
        2->R.drawable.mounteverest
        3->R.drawable.seaview
        else->
           R.drawable.burjkhalifa
    }
    var des = when (dataNumber){
        1->R.string.taj_mahal
        2->R.string.mount_everest
        3->R.string.sea_view
        else->
            R.string.burj_khalifa
    }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = img),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(16.dp)
            )
            Text(
                text = stringResource(id = des),
                fontSize = MaterialTheme.typography.displayLarge.fontSize,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.5f),

            )
            Row(
                modifier = Modifier.fillMaxWidth().padding(50.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    modifier = Modifier.width(120.dp),
                    onClick = {dataNumber-- }) {
                    Text(text = "Previous")
                }
                Button(
                    modifier = Modifier.wrapContentWidth(Alignment.End)
                        .width(120.dp),
                    onClick = {dataNumber++},
                 )
                {
                    Text(text = "Next")
                }
            }
        }
    }

@Preview
@Composable
fun Display(){
    DataDisplay()
}
