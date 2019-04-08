package com.nsuthack.echackadmin.network;

import com.nsuthack.echackadmin.model.RetroPeopleInLine;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface GetPeopleInLine {
    @POST("/peopleinline")
    Call<ResponseBody> pushPeopleCount(@Body RetroPeopleInLine retroPeopleInLine);
}
