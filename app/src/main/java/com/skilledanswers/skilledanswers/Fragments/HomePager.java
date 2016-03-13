package com.skilledanswers.skilledanswers.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.skilledanswers.skilledanswers.Adapters.ViewpagerAdapter;
import com.skilledanswers.skilledanswers.MainActivity;
import com.skilledanswers.skilledanswers.R;

/**
 * Created by Nishanth on 3/12/2016.
 */
public class HomePager extends Fragment{
    ViewPager viewPager;
    TabLayout tabLayout;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.home_pager,container,false);
        ((MainActivity) getActivity()).getSupportActionBar().show();




        viewPager = (ViewPager) v.findViewById(R.id.viewpager);
        setupViewPager(viewPager);


        tabLayout = (TabLayout) v.findViewById(R.id.tab);
        tabLayout.setupWithViewPager(viewPager);


        return  v;
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewpagerAdapter adapter = new ViewpagerAdapter(getChildFragmentManager());
        adapter.addFrag(new TopNews(), "TOP NEWS");
        adapter.addFrag(new Briefs(), "BRIEFS");
        adapter.addFrag(new Latest(), "LATEST");
        adapter.addFrag(new Trending(), "TRENDING");
        adapter.addFrag(new Videos(), "VIDEOS");

        viewPager.setAdapter(adapter);
    }
}
