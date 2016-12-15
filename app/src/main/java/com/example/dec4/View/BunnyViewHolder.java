package com.example.dec4.View;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.dec4.Model.Bunny;
import com.example.dec4.R;


/**
 * Created by Millochka on 12/5/16.
 */
public class BunnyViewHolder extends RecyclerView.ViewHolder{

    ImageView mBunnyIcon;
    EditText mBunnyName;
    View mView;
    public BunnyViewHolder(View itemView) {
        super(itemView);

        mView =  itemView;
        mBunnyIcon =(ImageView)mView.findViewById(R.id.bunny_icon);
        mBunnyName=(EditText)mView.findViewById(R.id.bunny_name);
        mBunnyName.setFocusable(false);


    }

    public void bind(Bunny bunny){

        //mBunnyIcon.setImageResource(bunny.);
        mBunnyName.setHint(bunny.getName());
        mBunnyIcon.setImageResource(bunny.getBunnyIcon());



    }
}
