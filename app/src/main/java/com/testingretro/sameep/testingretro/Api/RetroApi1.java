package com.testingretro.sameep.testingretro.Api;


import com.testingretro.sameep.testingretro.Model.DetailModel;
import com.testingretro.sameep.testingretro.Model.ListModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


/**
 * Created by sameep on 11/6/16.
 */

public interface RetroApi1 {

    @GET("posts")
    Call<ArrayList<ListModel>> getList();


    @GET("posts/{id}/comments")
    Call<ArrayList<DetailModel>> getDetail(@Path("id") String id);
}
