package com.testingretro.sameep.testingretro.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by sameep on 11/6/16.
 */

public class ListModel {

    @SerializedName("userId")
    @Expose
    public Integer userId;
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("body")
    @Expose
    public String body;

}
