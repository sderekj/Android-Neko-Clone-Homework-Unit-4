package com.example.dec4.View;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dec4.Model.Bunny;
import com.example.dec4.R;


/**
 * Created by Millochka on 12/5/16.
 */
public class BunnyViewHolder extends RecyclerView.ViewHolder{

    ImageView mBunnyIcon;
    TextView mBunnyName;
    View mView;
    private LinearLayout mBunnyLayout;
    public BunnyViewHolder(View itemView) {
        super(itemView);

        mView =  itemView;
        mBunnyIcon =(ImageView)mView.findViewById(R.id.bunny_icon);
        mBunnyName=(TextView) mView.findViewById(R.id.bunny_name);
        mBunnyLayout = (LinearLayout) mView.findViewById(R.id.cute_bunny_item);




    }

    public void bind(Bunny bunny){

        //mBunnyIcon.setImageResource(bunny.);
        mBunnyName.setText(bunny.getName());
        mBunnyIcon.setImageResource(bunny.getBunnyIcon());

//        mBunnyLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });


    }

    public ImageView getmBunnyIcon() {
        return mBunnyIcon;
    }

    public TextView getmBunnyName() {
        return mBunnyName;
    }

    public View getmView() {
        return mView;
    }

    public LinearLayout getmBunnyLayout() {
        return mBunnyLayout;
    }
}
