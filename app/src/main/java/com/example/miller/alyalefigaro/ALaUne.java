package com.example.miller.alyalefigaro;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.miller.alyalefigaro.App.ENDPOINT_URL;
import static com.example.miller.alyalefigaro.R.id.btn_show_all;
import static com.example.miller.alyalefigaro.R.id.btn_show_one;
import static com.example.miller.alyalefigaro.R.id.textAll;

public class ALaUne extends Fragment {
    TextView tVShowJSON;
    List<Subcategory> subcategories = null;
    GetSubcategory getSubcategory;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment1_a_la_une, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Retrofit retrofit = new Retrofit.Builder().baseUrl(ENDPOINT_URL).
               addConverterFactory(GsonConverterFactory.create()).
                build();
        getSubcategory = retrofit.create(GetSubcategory.class);

        tVShowJSON = (TextView) view.findViewById(textAll);


        Button btnShowAll = (Button) view.findViewById(btn_show_all);
        btnShowAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadSubcategorys();

            }
        });

        Button btnShowOne = (Button) view.findViewById(btn_show_one);
        btnShowOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadCategory();
            }
        });

    }


    public void loadCategory() {
        Call<List<Result>> callCategory = getSubcategory.allCallResult();
        callCategory.enqueue(new Callback<List<Result>>(){

            @Override
            public void onResponse(Call<List<Result>> call, Response<List<Result>> response) {
                int statusCode = response.code();
                List<Result> results = response.body();
                displayResultCategory(results);
            }

            @Override
            public void onFailure(Call<List<Result>> call, Throwable t) {

            }
        });
    }

    public void loadSubcategorys() {
        Call<List<Subcategory>> callSubcategory = getSubcategory.allSubcategoryResult();
        callSubcategory.enqueue(new Callback<List<Subcategory>>() {
            @Override
            public void onResponse(Call<List<Subcategory>> call, Response<List<Subcategory>> response) {
                List<Subcategory> subcategories = response.body();
                displaySub(subcategories);
            }

            @Override
            public void onFailure(Call<List<Subcategory>> call, Throwable t) {

            }
        });
    }



    private  void displaySub(List<Subcategory> subc){
        if (subc != null) {
            List<Subcategory> listCategories = subc;

            String tmp = " ";

            for (Subcategory sub : listCategories) {
                tmp += sub.getId()+ "= ID  " + sub.getName()+"= NAME " + sub.getRanking()+"= RANKING";
            }

            tVShowJSON.setText(tmp);
        } else {
            tVShowJSON.setText("Eror to get Subscategory");
        }

    }
//    private void displaySubcategorys(Subcategory subcategory) {
//
//        if (subcategory != null) {
//            List<Subcategory> listSubC = (List<Subcategory>) subcategory;
//            String tmp = subcategory.getId() + " <> " + subcategory.getName() + " <> " + subcategory.getRanking();
//            tVShowJSON.setText(tmp);
//        }else{
//            tVShowJSON.setText("Eror to get Category");
//        }
//
//
//    }


    public void displayResultCategory(List<Result> result) {
        if (result != null) {
            List<Result> listCategories = result;
            List<Result> listSubcategories = result;

            String tmp = " ";
            List list;
            for (Result sub : listCategories) {
                tmp += sub.getCategory() + "" + sub.getSubcategories() ;
                List<Subcategory> listOfGet = sub.getSubcategories();
            }
//
//            for (Result res : listSubcategories){
//               subcategories = res.getSubcategories();
//                list = subcategories;
//                for(Object item: list){
//                    System.out.println(item);
//                }
//            }
            tVShowJSON.setText(tmp);
        } else {
            tVShowJSON.setText("Eror to get Subscategory");
        }
    }


}