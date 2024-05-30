package com.itnation.myresumebuilder.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.itnation.myresumebuilder.Activity.ResumeDataInputActivity;
import com.itnation.myresumebuilder.Adapter.ProfileRecyclerAdapter;
import com.itnation.myresumebuilder.MVVM.UserData;
import com.itnation.myresumebuilder.MVVM.UserDataViewModel;
import com.itnation.myresumebuilder.R;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {


    private UserDataViewModel userDataViewModel;

    RecyclerView profileRecycler;
    ProfileRecyclerAdapter profileRecyclerAdapter;
    LinearLayout startCreateBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_home, container, false);


        profileRecycler= view.findViewById(R.id.profileRecycler);
        startCreateBtn= view.findViewById(R.id.startCreateBtn);


        //profileRecycler.setLayoutManager(new GridLayoutManager(getContext(), 2));
        profileRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        profileRecyclerAdapter = new ProfileRecyclerAdapter();
        profileRecycler.setAdapter(profileRecyclerAdapter);


        startCreateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), ResumeDataInputActivity.class);
                startActivity(intent);

            }
        });

        userDataViewModel = new ViewModelProvider(getActivity()).get(UserDataViewModel.class);

        userDataViewModel.getAllUserData().observe(getActivity(), new Observer<List<UserData>>() {
            @Override
            public void onChanged(@Nullable List<UserData> userData) {
                profileRecyclerAdapter.setUserDataList(getActivity(),userData);
                profileRecyclerAdapter.notifyDataSetChanged();
            }
        });




        return view;
    }//-------------close OnCreate-----------------------------------




}