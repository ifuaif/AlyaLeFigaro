package com.example.miller.alyalefigaro;

/**
 * Created by Miller on 26-01-17.
 */
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.view.View;
import android.view.ViewGroup;
import android.os.Bundle;
import android.view.LayoutInflater;

public class ALaUne extends  Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment1_a_la_une,container,false);
        return rootView;
    }
}
