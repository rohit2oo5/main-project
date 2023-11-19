package com.littlelemon.menu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class ProductActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var title= intent.getStringExtra(MainActivity.KEY_TITLE)!!
        var price= intent.getDoubleExtra(MainActivity.KEY_PRICE,0.0)
        var category = intent.getStringExtra(MainActivity.KEY_CATEGORY)!!
        var image = intent.getIntExtra(MainActivity.KEY_IMAGE,-1)
        val productItem =
            ProductItem(title,price ,category , image)//todo replace with the passed values from intent
        setContent { ProductDetails(productItem) }
    }
}