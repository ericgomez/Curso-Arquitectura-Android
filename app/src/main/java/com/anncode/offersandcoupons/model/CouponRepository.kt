package com.anncode.offersandcoupons.model

import androidx.lifecycle.MutableLiveData

interface CouponRepository {
    fun getCoupon(): MutableLiveData<List<Coupon>>
    fun callCouponAPI()
}