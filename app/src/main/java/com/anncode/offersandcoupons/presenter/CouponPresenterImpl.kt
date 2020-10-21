package com.anncode.offersandcoupons.presenter

import com.anncode.offersandcoupons.model.Coupon
import com.anncode.offersandcoupons.model.CouponsInteractor
import com.anncode.offersandcoupons.model.CouponsInteractorImpl
import com.anncode.offersandcoupons.view.CouponView

//Las clases heredan de las interfaces padre
class CouponPresenterImpl(var couponView: CouponView): CouponPresenter {

    private var couponInteractor: CouponsInteractor = CouponsInteractorImpl(this)

    //El metodo le pasa el dato que venimos acarreando de la lista
    override fun showCoupons(coupons: ArrayList<Coupon>?) {
        // Lo manda a la vista
        couponView.showCoupons(coupons)
    }

    //El metodo getCoupons debe ejecutar lo que tiene implementado CouponPresenter
    override fun getCoupons() {
        couponInteractor.getCouponsAPI()
    }

}