package com.example.dec4;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BunnyFeederFragment extends Fragment implements View.OnClickListener {

    private View bunnyFeederLayout;
    private View carrotButton;
    private View lettuceButton;
    private View chiliButton;
    private View cakeButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bunny_feeder, container, false);

        // find views
        bunnyFeederLayout = view.findViewById(R.id.bunny_feeder_layout);
        carrotButton = view.findViewById(R.id.carrot_button);
        lettuceButton = view.findViewById(R.id.lettuce_button);
        chiliButton = view.findViewById(R.id.chili_button);
        cakeButton = view.findViewById(R.id.cake_button);

        // implement onClicks
        bunnyFeederLayout.setOnClickListener(this);
        carrotButton.setOnClickListener(this);
        lettuceButton.setOnClickListener(this);
        chiliButton.setOnClickListener(this);
        cakeButton.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.carrot_button: case R.id.lettuce_button:
                // Implement textColor changer

                closeFragment();
                break;
            case R.id.chili_button: case R.id.cake_button:
                // Implement textColor changer
                closeFragment();
                break;
            default:
                closeFragment();
                break;
        }

    }

    private void closeFragment() {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.remove(BunnyFeederFragment.this);
        fragmentTransaction.commit();
    }
}
