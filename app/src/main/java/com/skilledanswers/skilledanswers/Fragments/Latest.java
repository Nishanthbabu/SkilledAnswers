package com.skilledanswers.skilledanswers.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.skilledanswers.skilledanswers.MainActivity;
import com.skilledanswers.skilledanswers.R;

/**
 * Created by Nishanth on 3/12/2016.
 */
public class Latest extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycleview,container,false);
        ((MainActivity) getActivity()).getSupportActionBar().show();

        return  view;
    }

}
