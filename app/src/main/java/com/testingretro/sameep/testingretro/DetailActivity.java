package com.testingretro.sameep.testingretro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.testingretro.sameep.testingretro.Adapter.DetailAdapters;
import com.testingretro.sameep.testingretro.Api.RetroApi1;
import com.testingretro.sameep.testingretro.Model.DetailModel;

import java.util.ArrayList;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailActivity extends AppCompatActivity {

    private ListView list_detail;
    private String baseUrl;
    private Retrofit retrofit;
    private RetroApi1 retroApi1;
    ArrayList<DetailModel> detailModels;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

         list_detail = (ListView) findViewById(R.id.list_detail);
         baseUrl = getResources().getString(R.string.url);
         Bundle bundle = getIntent().getExtras();
         String id = bundle.getString("id");




        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(baseUrl)
                .client(new OkHttpClient())
                .build();

        retroApi1 = retrofit.create(RetroApi1.class);

        Call<ArrayList<DetailModel>> detailModel = retroApi1.getDetail(id);

        detailModel.enqueue(new Callback<ArrayList<DetailModel>>() {
            @Override
            public void onResponse(Call<ArrayList<DetailModel>> call, Response<ArrayList<DetailModel>> response) {
                //System.out.println(bundle.getString("id"));
                detailModels = response.body();

                populateDetailView();
            }


            @Override
            public void onFailure(Call<ArrayList<DetailModel>> call, Throwable t) {

            }
        });

    }

    public void populateDetailView(){
        DetailAdapters detailAdapters = new DetailAdapters(this, detailModels);
        list_detail.setAdapter(detailAdapters);

    }
}
