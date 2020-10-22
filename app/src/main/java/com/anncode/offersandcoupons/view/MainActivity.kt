package com.anncode.offersandcoupons.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.anncode.offersandcoupons.R



class MainActivity : AppCompatActivity() {

    private var rvCoupons: RecyclerView? = null

    //Lo primero metodo que se ejecta es el onCreate
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        //VIEW
        //Declaramos nuestra Vista
        rvCoupons = findViewById(R.id.rvCoupons)//UI
        rvCoupons?.layoutManager =
            LinearLayoutManager(this)
        //<-VIEW

    }

}
