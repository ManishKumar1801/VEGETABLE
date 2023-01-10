package com.example.vegetable

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.GridLayout
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.example.vegetable.databinding.ActivityMainBinding
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {
    lateinit var dataBase:FirebaseFirestore
    private lateinit var binding:ActivityMainBinding
    private lateinit var newArrayList:ArrayList<VEG>
    private lateinit var adapter: Adapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil. setContentView(this,R.layout.activity_main)
        buildRecycler()
        with(binding){
            Add.setOnClickListener{
                val intent=Intent(this@MainActivity,AddVeg::class.java)
                startActivity(intent)
            }



        }
    }
    private fun buildRecycler(){
        with(binding){
            newArrayList= ArrayList()
            var model=VEG()

            dataBase=FirebaseFirestore.getInstance()
            dataBase.collection("vegitable").get().addOnSuccessListener {

                if (!it.isEmpty){
                    for (d in it){
                        model=d.toObject(VEG::class.java)
                        newArrayList.add(model)
                        Log.d("listsss",newArrayList.toString())
                    }
                }
                adapter= Adapter(newArrayList,this@MainActivity)
                recyclerView.adapter=adapter
                recyclerView.layoutManager=GridLayoutManager(this@MainActivity,2)

            }.addOnFailureListener {

            }


//            newArrayList.add(VEG(R.drawable.img,"Baigan","₹20","xgysfdgdh"))
//            newArrayList.add(VEG(R.drawable.img,"Baigan","₹20","xgysfdgdh"))
//            newArrayList.add(VEG(R.drawable.img,"Baigan","₹20","xgysfdgdh"))
//            newArrayList.add(VEG(R.drawable.img,"Baigan","₹20","xgysfdgdh"))
//            newArrayList.add(VEG(R.drawable.img,"Baigan","₹20","xgysfdgdh"))
//            newArrayList.add(VEG(R.drawable.img,"Baigan","₹20","xgysfdgdh"))
//            newArrayList.add(VEG(R.drawable.img,"Baigan","₹20","xgysfdgdh"))
//            newArrayList.add(VEG(R.drawable.img,"Baigan","₹20","xgysfdgdh"))
//            newArrayList.add(VEG(R.drawable.img,"Baigan","₹20","xgysfdgdh"))

        }

    }
}