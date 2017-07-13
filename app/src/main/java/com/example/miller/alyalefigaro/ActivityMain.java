package com.example.miller.alyalefigaro;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ListView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.R.attr.fragment;
import static android.R.attr.name;
import static com.example.miller.alyalefigaro.ApiClient.ENDPOINT_URL;

import android.support.v7.widget.RecyclerView;
public class ActivityMain extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private final static String API_KEY = "";
    private static final String TAG = ActivityMain.class.getSimpleName();
    private GetApi getApi;
    private ProgressDialog pDialog;
    private ListView lv;
    private ViewPager viewPager;
    private DrawerLayout drawer;
    private TabLayout tabLayout;
    private String[] pageTitle = {"A LA UNE", "LE FLAHS", "MA UNE", "VIDEOS"};
    private RecyclerView recyclerView;
    ArrayList<Result> listResult;
    public List<Subcategory> listSubcategory;
    ALaUne alaune = new ALaUne();
    Bundle bundle = new Bundle();

    ArrayList<HashMap<String, String>> listWithAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //recyclerView.findViewById(R.id.recycle);
        listResult  = new ArrayList<>();

        listSubcategory  = new ArrayList<Subcategory>();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(ENDPOINT_URL).
                addConverterFactory(GsonConverterFactory.create()).
                build();

//        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        getApi = retrofit.create(GetApi.class);

        Call<List<Result>> callResult = getApi.allResult();
        callResult.enqueue(new Callback<List<Result>>() {
            @Override
            public void onResponse(Call<List<Result>> call, Response<List<Result>> response) {
                List<Result> list = response.body();
                Result result = null;

                for (int i =0 ;i<list.size();i++) {
                    result = new Result();

                    List<Subcategory> listOfSubcategories = list.get(i).getSubcategories();
                    String categories = list.get(i).getCategory();

                    result.setCategory(categories);
                    result.setSubcategories(listOfSubcategories);
                    listResult.add(result);

                    bundle.putParcelableArrayList("listSub", listResult);
                    alaune.setArguments(bundle);
                }
            }
            @Override
            public void onFailure(Call<List<Result>> call, Throwable t) {

            }
        });

    Call<List<Subcategory>> callSubcategory = getApi.allSubcategory();
    callSubcategory.enqueue(new Callback<List<Subcategory>>() {
        @Override
        public void onResponse(Call<List<Subcategory>> call, Response<List<Subcategory>> response) {
//            List<Subcategory> list = response.body();
//            Subcategory subcategory = null;
//
//            for (int i =0 ;i<list.size();i++) {
//                subcategory = new Subcategory();
//
//                String id = list.get(i).getId();
//                String name = list.get(i).getName();
//                int rank = list.get(i).getRanking();
//
//                subcategory.setId(id);
//                subcategory.setName(name);
//                subcategory.setRanking(rank);
//            listSubcategory.add(subcategory);
//
//            }
            listSubcategory.clear();
            listSubcategory.addAll(response.body());
        }

        @Override
        public void onFailure(Call<List<Subcategory>> call, Throwable t) {

        }
    });




        viewPager = (ViewPager) findViewById(R.id.view_pager);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawer = (DrawerLayout) findViewById(R.id.drawerLayout);


        listWithAll = new ArrayList<>();

       // lv = (ListView) findViewById(R.id.list_a_la_une);

        setSupportActionBar(toolbar);

        //create default navigation drawer toggle
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //setting Tab layout (number of Tabs = number of ViewPager pages)
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        for (int i = 0; i < 4; i++) {
            tabLayout.addTab(tabLayout.newTab().setText(pageTitle[i]));
        }
        //set gravity for tab bar
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        //handling navigation view item event
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        assert navigationView != null;
        navigationView.setNavigationItemSelectedListener(this);

        //set viewpager adapter
        ViewPagerAdapter pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);

        //change Tab selection when swipe ViewPager
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        //change ViewPager page when tab selected
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
        @Override
        public boolean onNavigationItemSelected (MenuItem item){
            int id = item.getItemId();

            if (id == R.id.nav_item_ala_une) {
                viewPager.setCurrentItem(0);
            } else if (id == R.id.nav_item_le_flash) {
                viewPager.setCurrentItem(1);
            } else if (id == R.id.nav_item_videos) {
                viewPager.setCurrentItem(3);
            }

            drawer.closeDrawer(GravityCompat.START);
            return true;
        }

        @Override
        public void onBackPressed () {
            assert drawer != null;
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            } else {
                super.onBackPressed();
            }
        }


    public static GetApi getApi() {
        return null;
    }
    public  List<Subcategory> getSub(){
        return listSubcategory;
    }

}
