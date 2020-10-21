package com.anncode.offersandcoupons.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.anncode.offersandcoupons.model.Coupon
import com.anncode.offersandcoupons.R
import com.anncode.offersandcoupons.model.ApiAdapter
import com.anncode.offersandcoupons.presenter.CouponPresenter
import com.anncode.offersandcoupons.presenter.CouponPresenterImpl
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), CouponView {

    private var couponPresenter: CouponPresenter? = null
    private var rvCoupons: RecyclerView? = null

    //Lo primero metodo que se ejecta es el onCreate
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        //onCreate instancia a al presentador(CouponPresenterImpl) aquiere una referencia de coupoView(this)
        couponPresenter = CouponPresenterImpl(this)//Instaciamos la clase

        //VIEW
        //Declaramos nuestra Vista
        rvCoupons = findViewById(R.id.rvCoupons)//UI
        rvCoupons?.layoutManager = LinearLayoutManager(this)
        //<-VIEW

        //Enseguida hacemos la llamada para traer los cupones
        getCoupons()
    }

    //Ejecutamos todo lo que tebga que ver con mostrar los cupones
    override fun showCoupons(coupons: ArrayList<Coupon>?) {
        //operador double bang (!!) en caso de que estemos obteniendo alguna exepcion podamos cachar
        try {
            rvCoupons!!.adapter = RecyclerCouponsAdapter(coupons, R.layout.card_coupon)
        }catch (e: Exception) {
            e.printStackTrace()
        }

    }

    //Metodo de la Vista
    override fun getCoupons() {
        //Empesamos a llamar al presentador su metodo getCoupons
        couponPresenter?.getCoupons()
    }
}
