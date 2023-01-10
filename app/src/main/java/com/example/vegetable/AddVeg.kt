package com.example.vegetable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.vegetable.databinding.ActivityAddVegBinding
import com.google.firebase.firestore.FirebaseFirestore

class AddVeg : AppCompatActivity() {
    lateinit var binding: ActivityAddVegBinding
    lateinit var dataBase:FirebaseFirestore
    lateinit var model:VEG
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding=DataBindingUtil.setContentView(this,R.layout.activity_add_veg)
        with(binding){
        send.setOnClickListener {
            addVeg()
        }
        }
    }

    private fun addVeg(){
        with(binding){
            model= VEG()
            model.heading=heading.text.toString()
            model.titleImage=R.drawable.img
            model.cost=cost.text.toString()
            model.description=discreption.text.toString()
            model.quantity=Quantity.text.toString()
            dataBase= FirebaseFirestore.getInstance()

            dataBase.collection("vegitable").document().set(model).addOnSuccessListener {
                Toast.makeText(this@AddVeg, "successfully add", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener {
                Toast.makeText(this@AddVeg, "something Went wrong", Toast.LENGTH_SHORT).show()
            }

        }
    }
}