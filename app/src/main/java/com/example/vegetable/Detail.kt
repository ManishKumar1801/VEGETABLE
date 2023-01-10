package com.example.vegetable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil

import com.example.vegetable.R
import com.example.vegetable.databinding.ActivityDetailBinding

class Detail : AppCompatActivity() {
    private  lateinit var binding: ActivityDetailBinding
    private var imagevalue=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil. setContentView(this, R.layout.activity_detail)
        with(binding){
            val bundle=intent.extras
            if(bundle!=null){
                imagevalue=bundle.getInt("image")
            }
            image.setImageResource(imagevalue)
            val title=intent.getStringExtra("heading")
            val cost=intent.getStringExtra("cost")
            val description=intent.getStringExtra("description")
            vegHeading.text=title
            textView3.text=cost
            textView4.text=description


        }
    }
}
