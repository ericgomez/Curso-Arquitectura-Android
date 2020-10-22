package com.anncode.offersandcoupons.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.anncode.offersandcoupons.R
import com.anncode.offersandcoupons.databinding.ActivityMainBinding
import com.anncode.offersandcoupons.model.Coupon
import com.anncode.offersandcoupons.viewmodel.CouponViewModel

//El flujo comienza en *MainActivity y estara llamando a : CouponViewModel

class MainActivity : AppCompatActivity() {

    private var couponViewModel: CouponViewModel? = null

    //Lo primero metodo que se ejecta es el onCreate
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        //Estaremos ejecutando una llamada con CallCoupons
        setupBindings(savedInstanceState)
        //Cuando la llamada se ejecuta se llena una list de cupones con getCoupons que trae la lista de Cupones
    }

    //pone en orbita el sistema de Bindeo que pusimos en el XML activiti main
    fun setupBindings(savedInstanceState: Bundle?) {
        var activityMainBinding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //Hacemos percistente todo lo que tenga nuestro couponViewModel con ViewModelProviders
        couponViewModel = ViewModelProviders.of(this).get(CouponViewModel::class.java)

        activityMainBinding.setModelBinding(couponViewModel)
        setupListUpdate()
    }
    //Tendra toda la logica de levantar la lista de nuetro recyclerview
    fun setupListUpdate() {
        //CallCoupons
        couponViewModel?.callCoupons()
        //getCoupons - Lista de cupones
        couponViewModel?.getCoupons()?.observe(this, Observer {
            coupon: List<Coupon> ->
            Log.w("COUPON", coupon.get(0).title)
        })
    }

}
