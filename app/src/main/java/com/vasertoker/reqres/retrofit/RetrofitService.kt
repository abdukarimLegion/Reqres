package com.vasertoker.reqres.retrofit




import com.vasertoker.reqres.models.create.ReqUser
import com.vasertoker.reqres.models.create.ResUser
import com.vasertoker.reqres.models.list_user.UserResponse
import com.vasertoker.reqres.models.single_user.SingleUserResponse
import com.vasertoker.reqres.models.update.ResUpdateUser
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface RetrofitService {

    @GET("users")
    fun getUser() : Call<UserResponse>

    @GET("users/{id}")
    fun getSingleUser(@Path("id") id : Int) : Call<SingleUserResponse>

    @POST("user")
    fun createUser(@Body reqUser: ReqUser) : Call<ResUser>

    @PUT("users/{id}")
    fun updateUser(@Path("id") id : Int, @Body reqUser: ReqUser) : Call<ResUpdateUser>


    @DELETE("users/{id}")
    fun deleteUser(@Path("id") id : Int) : Call<ResponseBody>
}