package com.example.monkey.mobilefinal.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.monkey.mobilefinal.R;

import butterknife.ButterKnife;


public class ThirdFragment extends LinearLayout {
    private final View view;

    public ThirdFragment(Context context) {
        // Required empty public constructor
        super(context);
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.fragment_third, this);
        ButterKnife.bind(this,view);
    }
}