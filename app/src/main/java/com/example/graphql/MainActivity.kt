package com.example.graphql

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider


class MainActivity  : AppCompatActivity() {

    private lateinit var mainActivityViewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainActivityViewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
        mainActivityViewModel.getUsers()
        observer()
    }

    fun observer()
    {
        mainActivityViewModel.resultUsers.observe(this){
            if(it.message != null)
            {
                Log.e("Error", it.message)
            }
            else
            {
                val data = it.data?.filter { it.employeeRefNo == "009472" }
                Log.e("Data", data.toString())
            }
        }
    }
}