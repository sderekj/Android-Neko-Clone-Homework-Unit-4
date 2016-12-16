package com.example.dec4;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BunnyFeederFragment extends Fragment {

    private View bunnyFeederLayout;
    private View firstButton;
    private View secondButton;
    private View thirdButton;
    private View fourthButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bunny_feeder, container, false);

        bunnyFeederLayout = view.findViewById(R.id.bunny_feeder_layout);
        bunnyFeederLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.remove(BunnyFeederFragment.this);
                fragmentTransaction.commit();
            }
        });

        firstButton = view.findViewById(R.id.first_button);
        secondButton = view.findViewById(R.id.second_button);
        thirdButton = view.findViewById(R.id.third_button);
        fourthButton = view.findViewById(R.id.fourth_button);

        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // change timer

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.remove(BunnyFeederFragment.this);
                fragmentTransaction.commit();
            }
        });

        secondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // change timer

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.remove(BunnyFeederFragment.this);
                fragmentTransaction.commit();
            }
        });

        thirdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // change timer

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.remove(BunnyFeederFragment.this);
                fragmentTransaction.commit();
            }
        });

        fourthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // change timer

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.remove(BunnyFeederFragment.this);
                fragmentTransaction.commit();
            }
        });

        return view;
    }
}
