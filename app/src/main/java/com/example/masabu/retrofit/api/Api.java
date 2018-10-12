package com.example.masabu.retrofit.api;

import com.example.masabu.retrofit.models.DefaultResponse;
import com.example.masabu.retrofit.models.LoginResponse;
import com.example.masabu.retrofit.models.UsersResponse;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface Api {

    @FormUrlEncoded
    @POST("createuser")
    Call<DefaultResponse> createUser(
            @Field("username") String username,
            @Field("password") String password,
            @Field("level") String level
    );

    @FormUrlEncoded
    @POST("userlogin")
    Call<LoginResponse> userLogin(
        @Field("username") String username,
        @Field("password") String password
    );

    @GET("allusers")
    Call<UsersResponse> getUsers();

    @FormUrlEncoded
    @PUT("updateuser/{id_user}")
    Call<LoginResponse> updateUser(
      @Path("id_user") int id_user,
      @Field("username") String username,
      @Field("level") String level
    );

    @FormUrlEncoded
    @PUT("updatepassword")
    Call<DefaultResponse> updatePassword(
            @Field("currentpassword") String currentpassword,
            @Field("newpassword") String newpassword,
            @Field("username") String username
    );

    @DELETE("deleteuser/{id_user}")
    Call<DefaultResponse> deleteUser(@Path("id_user") int id_user);
}
