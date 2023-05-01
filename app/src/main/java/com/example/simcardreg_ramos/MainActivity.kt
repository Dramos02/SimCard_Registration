package com.example.simcardreg_ramos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.simcardreg_ramos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //this btn will do the intent if my selection control structure is satisfited
        binding.btnRegister.setOnClickListener(){
            //initializing the variables so it well store/get the user's input
            var intent = Intent(this,MainActivity2::class.java)
            var name = binding.edtUsername.text.toString()
            var contactNo = binding.edtContactNo.text.toString()
            var simNetwork = binding.edtSimNetwork.text.toString()
            var completeAddress = binding.edtAddress.text.toString()

            //this if will check if the editextView is not empty or the user didn't leave it blank
            if(binding.edtUsername.text.toString().isNotEmpty() &&
                    binding.edtContactNo.text.toString().isNotEmpty() &&
                    binding.edtSimNetwork.text.toString().isNotEmpty() &&
                    binding.edtAddress.text.toString().isNotEmpty() &&
                    isValidPhoneNumber(contactNo)) {
                intent.putExtra("nameData", name)
                intent.putExtra("contactNo", contactNo)
                intent.putExtra("simNetwork", simNetwork)
                intent.putExtra("address", completeAddress)
                startActivity(intent)
                this.finish()
            //this else if will check if the editTextview is empty and the toast will remind the user fill up the required information
            }else if (binding.edtUsername.text.toString().isEmpty() &&
                binding.edtContactNo.text.toString().isEmpty() &&
                binding.edtSimNetwork.text.toString().isEmpty() &&
                binding.edtAddress.text.toString().isEmpty()){
                Toast.makeText(applicationContext, "Please complete all Required Information", Toast.LENGTH_SHORT).show()
            //this else if will check if the phone number is not valid so the toast will remind the user about it
            }else if (!isValidPhoneNumber(contactNo)){
                Toast.makeText(applicationContext, "Invalid Phone Number. Please enter a 11-Digit Number", Toast.LENGTH_SHORT).show()
            }

        }
        binding.txtTitle.text="Sim Registration By Dominic O.Ramos"
    }

    //i use this method to make way in validating the phone number
    fun isValidPhoneNumber(contactNo: String): Boolean {
        //it will check the users input if the Phone number is not equal to 11
        if (contactNo.length != 11) {
            return false
        }
        //this for loop will check every index of the Phone number if its satisfy the range from 0-9
        for (x in contactNo.indices) {
            if (contactNo[x] < '0' || contactNo[x] > '9') {
                return false
            }
        }

        return true
    }

    //coded by dominic o. ramos 2bsit2 submitted to - Professor Irysh Paulo R. Tipay
}