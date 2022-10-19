package com.example.vegetable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridLayout
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.example.vegetable.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var newArrayList:ArrayList<VEG>
    private lateinit var adapter: Adapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil. setContentView(this,R.layout.activity_main)
        with(binding){
            newArrayList= ArrayList()
            adapter= Adapter(newArrayList,this@MainActivity)
            newArrayList.add(VEG(R.drawable.img,"Baigan","₹20","xgysfdgdh"))
            newArrayList.add(VEG(R.drawable.img,"Baigan","₹20","xgysfdgdh"))
            newArrayList.add(VEG(R.drawable.img,"Baigan","₹20","xgysfdgdh"))
            newArrayList.add(VEG(R.drawable.img,"Baigan","₹20","xgysfdgdh"))
            newArrayList.add(VEG(R.drawable.img,"Baigan","₹20","xgysfdgdh"))
            newArrayList.add(VEG(R.drawable.img,"Baigan","₹20","xgysfdgdh"))
            newArrayList.add(VEG(R.drawable.img,"Baigan","₹20","xgysfdgdh"))
            newArrayList.add(VEG(R.drawable.img,"Baigan","₹20","xgysfdgdh"))
            newArrayList.add(VEG(R.drawable.img,"Baigan","₹20","xgysfdgdh"))
            recyclerView.adapter=adapter
            recyclerView.layoutManager=GridLayoutManager(this@MainActivity,3)

        }
    }
}