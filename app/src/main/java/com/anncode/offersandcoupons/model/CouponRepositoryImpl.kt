package com.anncode.offersandcoupons.model

import android.util.Log
import com.anncode.offersandcoupons.R
import com.anncode.offersandcoupons.presenter.CouponPresenter
import com.anncode.offersandcoupons.view.RecyclerCouponsAdapter
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//Las clases heredan de las interfaces padre
class CouponRepositoryImpl(var couponPresenter: CouponPresenter): CouponRepository {

    //Colocamos toda la logica de conexion
    override fun getCouponAPI() {

        //CONTROLLER
        var coupons: ArrayList<Coupon>? = ArrayList<Coupon>()
        val apiAdapter = ApiAdapter();//Intanciamos la clase ApiAdapter()
        val apiService = apiAdapter.getClientService()//Llamamos al metodo getClientService() desde la instancia apiAdapter
        val call = apiService.getCoupons()

        call.enqueue(object : Callback<JsonObject> {
            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                Log.e("ERROR: ", t.message)
                t.stackTrace
            }

            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                val offersJsonArray = response.body()?.getAsJsonArray("offers")
                offersJsonArray?.forEach { jsonElement: JsonElement ->
                    var jsonObject = jsonElement.asJsonObject
                    var coupon = Coupon(jsonObject)
                    coupons?.add(coupon)
                }
                //Nos comentamos con el Presentes y le enviamos los cupones
                couponPresenter.showCoupons(coupons)
            }

        })
        //<-CONTROLLER

        //couponPresenter.showCoupons()
    }

}