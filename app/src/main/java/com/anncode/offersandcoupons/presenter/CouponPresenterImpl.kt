package com.anncode.offersandcoupons.presenter

import com.anncode.offersandcoupons.model.Coupon
import com.anncode.offersandcoupons.model.CouponRepository
import com.anncode.offersandcoupons.view.CouponView

//Las clases heredan de las interfaces padre
class CouponPresenterImpl(var couponView: CouponView): CouponPresenter {

    //private var couponInteractor: CouponRepository.;

    override fun showCoupons(coupons: ArrayList<Coupon>) {

    }

    override fun getCoupons() {

    }

}