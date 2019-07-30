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
public class NotificationFragment extends Fragment {

    private static NotificationFragment INSTANCE;

    public static synchronized NotificationFragment getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new NotificationFragment();
        }
        return (INSTANCE);
    }

    private NotificationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notification, container, false);
    }

}
