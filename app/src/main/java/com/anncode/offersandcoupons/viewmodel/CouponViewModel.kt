package com.anncode.offersandcoupons.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anncode.offersandcoupons.R
import com.anncode.offersandcoupons.model.Coupon
import com.anncode.offersandcoupons.model.CouponObservable
import com.anncode.offersandcoupons.view.RecyclerCouponsAdapter

//El flujo continua en *CouponViewModel y estara llamando a : CouponObservable
//La clase CouponViewModel estara heredando de la clase ViewModel
class CouponViewModel: ViewModel() {
    //Creamos una instacia a CouponObservable
    private var couponObservable: CouponObservable = CouponObservable()
    private var recyclerCouponsAdapter: RecyclerCouponsAdapter? = null

    fun callCoupons(){
        couponObservable.callCoupons()
    }

    fun getCoupons(): MutableLiveData<List<Coupon>> {
        return couponObservable.getCoupons()
    }

    fun setCouponsInRecyclerAdapter(coupons: List<Coupon>) {
        recyclerCouponsAdapter?.setCouponsList(coupons)
        recyclerCouponsAdapter?.notifyDataSetChanged()//Para añadir un nuevo elemento
    }

    fun getRecyclerCouponsAdapter(): RecyclerCouponsAdapter? {
        recyclerCouponsAdapter = RecyclerCouponsAdapter(this, R.layout.card_coupon)
        return recyclerCouponsAdapter
    }

    fun getCouponAt(position: Int): Coupon? {
        var coupons: List<Coupon>? = couponObservable.getCoupons().value
        return coupons?.get(position)
    }
}