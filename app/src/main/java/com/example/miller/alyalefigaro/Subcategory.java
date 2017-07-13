package com.example.miller.alyalefigaro;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


    class Subcategory implements Parcelable {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("ranking")
    @Expose
    private Integer ranking;
    @SerializedName("isVisible")
    @Expose
    private Boolean isVisible;

        protected Subcategory(Parcel in) {
            id = in.readString();
            name = in.readString();
        }

        public static final Creator<Subcategory> CREATOR = new Creator<Subcategory>() {
            @Override
            public Subcategory createFromParcel(Parcel in) {
                return new Subcategory(in);
            }

            @Override
            public Subcategory[] newArray(int size) {
                return new Subcategory[size];
            }
        };

        public Subcategory() {

        }

        public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    public Boolean getIsVisible() {
        return isVisible;
    }

    public void setIsVisible(Boolean isVisible) {
        this.isVisible = isVisible;
    }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(id);
            dest.writeString(name);
        }
    }
