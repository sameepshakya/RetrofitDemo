package com.testingretro.sameep.testingretro.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by sameep on 11/6/16.
 */

public class DetailModel {

    @SerializedName("postId")
    @Expose
    public Integer postId;
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("email")
    @Expose
    public String email;
    @SerializedName("body")
    @Expose
    public String body;
}
