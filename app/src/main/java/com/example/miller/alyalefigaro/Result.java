package com.example.miller.alyalefigaro;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

 class Result implements Parcelable{

    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("subcategories")
    @Expose
    private List<Subcategory> subcategories = null;

     public Result() {

     }

     protected Result(Parcel in) {
         category = in.readString();
         subcategories = in.createTypedArrayList(Subcategory.CREATOR);
     }

     public static final Creator<Result> CREATOR = new Creator<Result>() {
         @Override
         public Result createFromParcel(Parcel in) {
             return new Result(in);
         }

         @Override
         public Result[] newArray(int size) {
             return new Result[size];
         }
     };


     public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Subcategory> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(List<Subcategory> subcategories) {
        this.subcategories = subcategories;
    }

     @Override
     public int describeContents() {
         return 0;
     }

     @Override
     public void writeToParcel(Parcel dest, int flags) {
         dest.writeString(category);
         dest.writeTypedList(subcategories);
     }
 }
