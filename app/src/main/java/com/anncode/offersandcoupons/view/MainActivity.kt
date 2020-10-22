package com.anncode.offersandcoupons.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.anncode.offersandcoupons.R

//El flujo comienza en *MainActivity y estara llamando a : CouponViewModel

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

        //Estaremos ejecutando una llamada con CallCoupons
        //Cuando la llamada se ejecuta se llena una list de cupones con getCoupons que trae la lista de Cupones

    }

}
