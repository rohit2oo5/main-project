package com.example.littlelemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.littlelemon.ui.theme.LittleLemonColor

@Composable
fun DishDetails(id: Int) {
    val dish = requireNotNull(DishRepository.getDish(id))
    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        //TODO: Insert code here
        TopAppBar()
        Image(
            painter = painterResource(id = dish.imageResource),
            contentDescription = "Dish image", //Maybe HardCode
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth

        )
        Column(
            modifier = Modifier.padding(start = 10.dp, end = 10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),

        ) {
            Text(
                text = dish.name,
                style = MaterialTheme.typography.h1
            )
            Text(
                text = dish.description,
                style = MaterialTheme.typography.body1
            )
            Counter()
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(LittleLemonColor.yellow),

                ) {
            Text(
                text = stringResource(id = R.string.add_for) + "$${dish.price}",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
        }
    }
}

@Composable
fun Counter() {
    Row(
        modifier = Modifier.fillMaxWidth()
        ,verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center
    ) {
        var counter by remember {
            mutableStateOf(1)
        }
        TextButton(
            onClick = {
                if (counter > 0) counter--
            }
        ) {
            Text(
                text = "-",
                style = MaterialTheme.typography.h2
            )
        }
        Text(
            text = counter.toString(),
            style = MaterialTheme.typography.h2,
            modifier = Modifier.padding(16.dp)
        )
        TextButton(
            onClick = {
                counter++
            }
        ) {
            Text(
                text = "+",
                style = MaterialTheme.typography.h2
            )
        }
    }
}

@Preview
@Composable
fun DishDetailsPreview() {
    DishDetails(id = 1)
}
