package com.vasertoker.reqres

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.vasertoker.reqres.databinding.ActivityMainBinding
import com.vasertoker.reqres.models.create.ReqUser
import com.vasertoker.reqres.models.create.ResUser
import com.vasertoker.reqres.models.list_user.UserResponse
import com.vasertoker.reqres.models.single_user.SingleUserResponse
import com.vasertoker.reqres.models.update.ResUpdateUser
import com.vasertoker.reqres.retrofit.Common
import com.vasertoker.reqres.retrofit.RetrofitService
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var retrofitService: RetrofitService

    lateinit var binding : ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        retrofitService = Common.retrofitService

        retrofitService.getUser().enqueue(object : Callback<UserResponse>{
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {

                if (response.isSuccessful){
                    Log.i(TAG, "onResponse: ${response.body()}")
                }
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {

            }

        })


        retrofitService.getSingleUser(43).enqueue(object : Callback<SingleUserResponse>{
            override fun onResponse(
                call: Call<SingleUserResponse>,
                response: Response<SingleUserResponse>
            ) {
                if (response.isSuccessful){
                    Log.i(TAG, "onResponse: ${response.body()}")
                }
            }

            override fun onFailure(call: Call<SingleUserResponse>, t: Throwable) {
                Log.i(TAG, "onFailure: ${t.message}")
            }

        })

        val reqUser = ReqUser("Android dev", "Abdukarimbek ")
        retrofitService.createUser(reqUser).enqueue(object : Callback<ResUser>{
            override fun onResponse(call: Call<ResUser>, response: Response<ResUser>) {
                if (response.isSuccessful){
                    Log.i(TAG, "onResponse: ${response.body()}")
                }
            }

            override fun onFailure(call: Call<ResUser>, t: Throwable) {

            }
        })


        retrofitService.updateUser(349, reqUser).enqueue(object : Callback<ResUpdateUser>{
            override fun onResponse(call: Call<ResUpdateUser>, response: Response<ResUpdateUser>) {
                if (response.isSuccessful){
                    Log.i(TAG, "onResponse: ${response.body()}")
                }
            }

            override fun onFailure(call: Call<ResUpdateUser>, t: Throwable) {
            }
        })


        retrofitService.deleteUser(2).enqueue(object : Callback<ResponseBody>{
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.isSuccessful){
                    Log.i(TAG, "onResponse: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {

            }
        })

    }
}