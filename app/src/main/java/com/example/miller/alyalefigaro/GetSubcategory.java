package com.example.miller.alyalefigaro;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Miller on 02-03-17.
 */

interface GetSubcategory {

    @GET("/article/categories")
    Call<List<Result>> allCallResult();

    @GET("/article/categories")
    Call<List<Subcategory>> allSubcategoryResult();

}
