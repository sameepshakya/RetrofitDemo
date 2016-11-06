package com.testingretro.sameep.testingretro.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.testingretro.sameep.testingretro.Model.ListModel;
import com.testingretro.sameep.testingretro.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sameep on 11/6/16.
 */

public class ListAdapters extends ArrayAdapter<ListModel> {

    ArrayList<ListModel> listModels;
    TextView tv_id, tv_userId, tv_title, tv_body;


    public ListAdapters(Context context,  ArrayList<ListModel> listModels) {
        super(context, R.layout.list_data, listModels);
        this.listModels = listModels;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ListModel listModel = getItem(position);

        LayoutInflater layoutInflater = LayoutInflater.from(getContext());

        View newView = layoutInflater.inflate(R.layout.list_data, parent, false);

        tv_id = (TextView) newView.findViewById(R.id.tv_id);
        tv_userId = (TextView) newView.findViewById(R.id.tv_userid);
        tv_title = (TextView) newView.findViewById(R.id.tv_body);
        tv_body = (TextView) newView.findViewById(R.id.tv_body);



        tv_id.setText(listModel.id.toString());
        tv_userId.setText(listModel.userId.toString());
        tv_title.setText(listModel.title);
        tv_body.setText(listModel.body);

        return newView;
    }
}




