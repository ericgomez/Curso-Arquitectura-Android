package com.anncode.offersandcoupons.viewmodel

import androidx.lifecycle.ViewModel
import com.anncode.offersandcoupons.model.CouponObservable

//El flujo continua en *CouponViewModel y estara llamando a : CouponObservable
//La clase CouponViewModel estara heredando de la clase ViewModel
class CouponViewModel: ViewModel() {
    //Creamos una instacia a CouponObservable
    private var couponObservable: CouponObservable = CouponObservable()

    fun callCoupons(){
        couponObservable.callCoupons()
    }
}