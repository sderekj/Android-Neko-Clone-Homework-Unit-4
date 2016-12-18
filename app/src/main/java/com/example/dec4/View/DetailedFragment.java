package com.example.dec4.View;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.dec4.R;

import static com.example.dec4.View.MyNotificationService.mIcons;

/**
 * Created by Millochka on 12/16/16.
 */

public class DetailedFragment extends Fragment{
    private static final String BUNNY_NUMBER = "com.example.dec4";
    private static final String BUNNY_FOOD = "Bunny food";

    private ImageView mBunnyImage;
    private ImageView mBunnyAte;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       super.onCreateView(inflater,container,savedInstanceState);
       return inflater.inflate(R.layout.details_of_bunny,container,false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mBunnyImage=(ImageView) view.findViewById(R.id.bunny_image);
        mBunnyAte=(ImageView) view.findViewById(R.id.bunny_ate);

        mBunnyImage.setImageResource(mIcons.getmIcons().get(getArguments().getInt(BUNNY_NUMBER)));

        if(getArguments().getInt(BUNNY_FOOD)==0){

            mBunnyAte.setImageResource(R.drawable.lily);

        }else{
            mBunnyAte.setImageResource(getArguments().getInt(BUNNY_FOOD));}

        }

    }



