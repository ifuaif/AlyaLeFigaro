package com.example.miller.alyalefigaro;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position ==0) {
            return new ALaUne();
        } else if (position == 1) {
            return new LeFlash();
        } else if (position == 3 )
            return new Videos();
        return new MaUne();
    }

    @Override
    public int getCount() {
        return 4;
    }
}