package com.anncode.offersandcoupons.model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//Cuando la comunicacion se ejecute con exito va a regresar a CouponObservable
//Las clases heredan de las interfaces padre
class CouponRepositoryImpl: CouponRepository {

    //Creamos una lista Mutable que se refresca por cada cambio
    private var coupons = MutableLiveData<List<Coupon>>()
    //Subject -> MutableLiveData
    //Observers -> List Coupon
    //Change List Coupon -> MutableLiveData
    //Observe

    //Colocamos toda la logica de conexion
    override fun callCouponAPI() {
        //CONTROLLER
        var couponsList: ArrayList<Coupon>? = ArrayList<Coupon>()
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
                    couponsList?.add(coupon)
                }
            }

        })
        //<-CONTROLLER
        //Pamos la listanorma a la lista Mitable para que refreque los cambios en tiempo real
        coupons.value = couponsList
    }

    //Se unicamente traer la lista de cupones y esteremos devolviendola lista MutableLivedata
    override fun getCoupon(): MutableLiveData<List<Coupon>> {
        //si la lista sufre cambios el sugeto tambien sufre cambios
        return coupons
    }

}