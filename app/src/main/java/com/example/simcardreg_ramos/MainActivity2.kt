package com.example.simcardreg_ramos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.simcardreg_ramos.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding:ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        //initializing variable to get the user's input from MainActivtiy/Screen1
        var userName = intent.getStringExtra("nameData")
        var contactNo = intent.getStringExtra("contactNo")
        var simNetwork = intent.getStringExtra("simNetwork")
        var completeAddress = intent.getStringExtra("address")

        //this will display the user's information from Screen1
        binding.txtViewDetails.text = "Here are you details: \n\n Name: $userName\n\n" +
                "Contact Number: $contactNo\n\n Sim Network: $simNetwork\n\nComplete Address: $completeAddress"

        binding.txtViewTitleScreen2.text = "Sim Registration Successful!"
    }
    
    //Copyrights © https://github.com/Dramos02
}
