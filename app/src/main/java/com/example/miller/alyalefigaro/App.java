package com.example.miller.alyalefigaro;

import android.app.Application;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Miller on 07-03-17.
 */

public class App extends Application {

    public static final String ENDPOINT_URL= "http://figaro.service.yagasp.com/";

    Retrofit retrofit;
    private  static GetSubcategory getSubcategory;
    @Override
    public void onCreate() {
        super.onCreate();
        retrofit = new Retrofit.Builder().baseUrl(ENDPOINT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GetSubcategory getSubcategory = retrofit.create(GetSubcategory.class);

    }

  public static GetSubcategory getApi(){
      return  getSubcategory;
  }
}
