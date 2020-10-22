package com.anncode.offersandcoupons.model

import androidx.databinding.BaseObservable
import androidx.lifecycle.MutableLiveData

//El flujo continua en *CouponObservable y estara llamando a : CouponRepositoryImpl
//La clase CouponObservable estara heredando de la clase BaseObservable
class CouponObservable: BaseObservable() {
    //Para generar la conexion con el CouponRepositoryImpl necesitamostener una instancia
    private var couponRepository: CouponRepository = CouponRepositoryImpl()
    //Repositorio
    fun callCoupons(){
        //El metodo callCouponAPI() se encarga de generar la conexion y ejecutar la llamada y llena una lista de copones
        couponRepository.callCouponAPI()
    }
    //Viewmodel
    fun getCoupons(): MutableLiveData<List<Coupon>> {
        return couponRepository.getCoupon()
    }
}