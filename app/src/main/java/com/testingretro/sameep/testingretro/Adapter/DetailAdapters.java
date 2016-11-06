package com.testingretro.sameep.testingretro.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.testingretro.sameep.testingretro.Model.DetailModel;
import com.testingretro.sameep.testingretro.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sameep on 11/6/16.
 */

public class DetailAdapters extends ArrayAdapter<DetailModel> {

    ArrayList<DetailModel> detailModels;
    TextView tv_id, tv_name, tv_email, tv_body;


    public DetailAdapters(Context context, ArrayList<DetailModel> detailModels) {
        super(context, R.layout.detail_data, detailModels);
        this.detailModels = detailModels;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        DetailModel detailModel = getItem(position);

        LayoutInflater layoutInflater = LayoutInflater.from(getContext());

        View detailView = layoutInflater.inflate(R.layout.detail_data, parent, false);

        tv_id = (TextView) detailView.findViewById(R.id.tv_id);
        tv_name = (TextView) detailView.findViewById(R.id.tv_name);
        tv_email = (TextView) detailView.findViewById(R.id.tv_email);
        tv_body = (TextView) detailView.findViewById(R.id.tv_body);


        tv_id.setText(detailModel.id.toString());
        tv_name.setText(detailModel.name);
        tv_email.setText(detailModel.email);
        tv_body.setText(detailModel.body);

        return detailView;
    }
}
