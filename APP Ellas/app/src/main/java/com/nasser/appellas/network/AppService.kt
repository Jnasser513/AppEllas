package com.nasser.appellas.network

import com.nasser.appellas.data.Blogs
import com.nasser.appellas.data.Contacts
import com.nasser.appellas.data.Users
import com.nasser.appellas.data.entity.User
import okhttp3.RequestBody
import okhttp3.Response
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface AppService {
    @GET("{key}")
    suspend fun searchUser(@Path("key") key:String): Users

    @FormUrlEncoded
    @POST("access/register")
    fun createUser(
        @Field("username") username: String,
        @Field("email") email:String,
        @Field("password") password: String,
        @Field("confirmPassword") confirmPassword: String
    ): Call<Users>

    @FormUrlEncoded
    @POST("access/createBlog")
    fun createBlog(
        @Field("tittle") tittle: String,
        @Field("subTittle") subTittle:String,
        @Field("description") description: String
    ): Call<Blogs>

    @FormUrlEncoded
    @POST("access/createContact")
    fun createContact(
        @Field("name") name: String,
        @Field("phone") phone: Int
    ): Call<Contacts>
}