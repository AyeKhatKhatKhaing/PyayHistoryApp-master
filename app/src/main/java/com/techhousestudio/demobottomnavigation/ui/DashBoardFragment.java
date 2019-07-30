package com.techhousestudio.demobottomnavigation.ui;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.techhousestudio.demobottomnavigation.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DashBoardFragment extends Fragment {
    private static DashBoardFragment INSTANCE;

    public static synchronized DashBoardFragment getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DashBoardFragment();
        }
        return (INSTANCE);
    }

    private DashBoardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dash_board, container, false);
    }

}
