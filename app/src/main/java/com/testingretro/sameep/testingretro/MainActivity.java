package com.testingretro.sameep.testingretro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.testingretro.sameep.testingretro.Adapter.ListAdapters;
import com.testingretro.sameep.testingretro.Api.RetroApi1;
import com.testingretro.sameep.testingretro.Model.ListModel;

import java.util.ArrayList;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView listView;
    private Retrofit retrofit;
    private String baseUrl;
    private RetroApi1 retroApi1;
    ArrayList<ListModel> listModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list_item);
        baseUrl = getResources().getString(R.string.url);


        listView.setOnItemClickListener(this);

        retrofit = new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient()).build();
        retroApi1 = retrofit.create(RetroApi1.class);

        Call<ArrayList<ListModel>> listModel = retroApi1.getList();

        listModel.enqueue(new Callback<ArrayList<ListModel>>() {
            @Override
            public void onResponse(Call<ArrayList<ListModel>> call, Response<ArrayList<ListModel>> response) {

                listModels = response.body();
                populateListView();

            }



            @Override
            public void onFailure(Call<ArrayList<ListModel>> call, Throwable t) {
                //System.out.println("Hello");

            }
        });
    }

    public void populateListView(){

        ListAdapters listAdapters = new ListAdapters(this, listModels);
        listView.setAdapter(listAdapters);

    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("id", listModels.get(i).id.toString());
        startActivity(intent);
//        System.out.println(listModels.get(i).id);

    }
}
