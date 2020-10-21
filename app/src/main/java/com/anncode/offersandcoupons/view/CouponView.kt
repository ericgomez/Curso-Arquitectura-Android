package com.anncode.offersandcoupons.view

import com.anncode.offersandcoupons.model.Coupon

interface CouponView {
    //Vista
    fun showCoupons(coupons: ArrayList<Coupon>)//Devuelve los cupones en forma de lista

    //Presentador
    fun getCoupons()//obtengo la lista de componentes
}