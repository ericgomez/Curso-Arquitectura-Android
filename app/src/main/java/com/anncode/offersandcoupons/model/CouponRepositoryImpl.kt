package com.anncode.offersandcoupons.model

import com.anncode.offersandcoupons.presenter.CouponPresenter

//Las clases heredan de las interfaces padre
class CouponRepositoryImpl(var couponPresenter: CouponPresenter): CouponRepository {

    //Colocamos toda la logica de conexion
    override fun getCouponAPI() {
        //couponPresenter.showCoupons()
    }

}