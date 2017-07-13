package com.example.miller.alyalefigaro;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import static com.example.miller.alyalefigaro.R.id.btn_show_all;
import static com.example.miller.alyalefigaro.R.id.btn_show_one;

public class ALaUne extends Fragment {

    TextView tvID;
    TextView tvName;
    TextView tvRank;
    Result getResult;
    ArrayList<Subcategory> subcategories = null;
    GetApi getApi;
    ActivityMain activityMain;
    private RecyclerView rGridView;
    private ArrayList<Subcategory> listSub;
    ALaUneRecyclerAdapter adapterRecycler;

    private void setSub(ArrayList<Subcategory> list) {
        this.listSub = list;
    }
    Bundle bundle;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        bundle = this.getArguments();
        if (bundle != null) {
            listSub = bundle.getParcelable("listSub");
            setSub(listSub);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment1_a_la_une, container, false);

    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvID = (TextView) view.findViewById(R.id.tv_id);
        tvName = (TextView) view.findViewById(R.id.tv_name);
        tvRank = (TextView) view.findViewById(R.id.tv_rank);



      rGridView = (RecyclerView) getActivity().findViewById(R.id.recycle);
      rGridView.setLayoutManager(new GridLayoutManager(getActivity(),2 ));

      adapterRecycler = new ALaUneRecyclerAdapter(listSub);
      rGridView.setAdapter(adapterRecycler);

        Button btnShowAll = (Button) view.findViewById(btn_show_all);
        btnShowAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Button btnShowOne = (Button) view.findViewById(btn_show_one);
        btnShowOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

    }
}
//    private void loadSubcategory() {
//        Call<Result> callSubResult = getSubcategory.allSubResult();
//        callSubResult.enqueue(new Callback<Result>() {
//            @Override
//            public void onResponse(Call<Result> call, Response<Result> response) {
//                int statusCode = response.code();
//                List<Subcategory> resultList = response.body().getSubcategories();
//                displaySub(resultList);
//            }
//            @Override
//            public void onFailure(Call<Result> call, Throwable t) {
//
//            }
//        });
//
//    }
//
//
//    public void loadAll() {
//        Call<List<Result>> callCategory = getSubcategory.allCallResult();
//        callCategory.enqueue(new Callback<List<Result>>(){
//
//            @Override
//            public void onResponse(Call<List<Result>> call, Response<List<Result>> response) {
//                int statusCode = response.code();
//                List<Result> results = response.body();
//                displayResultCategory(results);
//            }
//
//            @Override
//            public void onFailure(Call<List<Result>> call, Throwable t) {
//
//            }
//        });
//    }


//
//    private void displayResultSubCategorys(List<Result> result) {
//        List<Result>  listResult =  result;
//        String tmp = "";
//
//        if (result != null) {
//
//            for (Result res : listResult) {
//                subcategories = res.getSubcategories();
//                List<Subcategory> list;
//
//                list = subcategories;
//
//
//                for (Object item : list) {
//                    list.add((Subcategory) item);
//                }
//            }
////            for (Result subCategory : listResult) {
////                List<Subcategory> listOfGet = subCategory.getSubcategories();
////
////           }
//       tmp =  + " <> " + subcategory.getName() + " <> " + subcategory.getRanking();
//          //  tVShowJSON.setText(tmp);
//
//        }else{
//            tVShowJSON.setText("Eror to get Category");
//        }
//
//
//    private  void displaySub(List<Subcategory> subc) {
//        List<Subcategory> listSubCategories = subc;
//        if (subc != null) {
//
//            String tmp = " ";
//            List listWith = null;
//            List<Subcategory> checkList = null;
//            for (Subcategory res : listSubCategories) {
//
//                checkList = subcategories;
//
//                for (Object item : checkList) {
//                    checkList.add((Subcategory) item);
//                }
//            }
//            for (Subcategory subCategory : listSubCategories) {
//                //  List<Subcategory> listOfGet = subCategory.getSubcategories();
//            }

            //  tmp = checkList.get(0).getName()  subcategories.getName() + " <> " + subcategory.getRanking();
//          //  tVShowJSON.setText(tmp);
            // tVShowJSON.setText(tmp);
//
//            for (Subcategory sub : listSubCategories) {
//                tmp += sub.getName() + "\n" + sub.getId()+ "\n"  ;
//            }
            //      tVShowJSON.setText(tmp);
            //  } else {
            //      tVShowJSON.setText("Eror to get Subscategory");
//        }
//
//
//    }
//
//    public void displayResultCategory(List<Result> result) {
//        List<Result> listResult = result;
//        if (result != null) {
//            String tmp = " ";
//
//            for (Result sub : listResult) {
//                tmp += sub.getCategory() + "\n" + sub.getSubcategories()+ "\n"  ;
//            }
//
//         tVShowJSON.setText(tmp);
//        } else {
//            tVShowJSON.setText("Eror to get Subscategory");
//        }
//
//    }

