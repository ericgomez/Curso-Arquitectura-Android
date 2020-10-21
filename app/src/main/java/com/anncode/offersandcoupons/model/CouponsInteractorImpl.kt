package com.anncode.offersandcoupons.model

import com.anncode.offersandcoupons.presenter.CouponPresenter

//Las clases heredan de las interfaces padre
class CouponsInteractorImpl(var couponPresenter: CouponPresenter): CouponsInteractor {

    //Intanciamos la clase hija y se la asignamos a la interfas padre
    private var couponRepository: CouponRepository = CouponRepositoryImpl(couponPresenter);


    //El metodo getCouponsAPI debe ejecutar lo que tiene implementado CouponRepositoryImpl
    override fun getCouponsAPI() {
        couponRepository.getCouponAPI()
    }



}