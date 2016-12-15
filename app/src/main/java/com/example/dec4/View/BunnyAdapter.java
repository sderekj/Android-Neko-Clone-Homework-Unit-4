package com.example.dec4.View;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dec4.Model.Bunny;
import com.example.dec4.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Millochka on 12/5/16.
 */
public class BunnyAdapter extends RecyclerView.Adapter implements ViewGroup.OnClickListener {

    private List<Bunny> mBunnies = new ArrayList<>();


    private Activity mManinActivity;



    public BunnyAdapter(List<Bunny> bunnies, Activity maninActivity){

        this.mBunnies=bunnies;
        this.mManinActivity=maninActivity;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cute_bunny, parent, false);
        BunnyViewHolder cuteBunny = new BunnyViewHolder(view);
        return cuteBunny;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        BunnyViewHolder mBunnyViewHolder=(BunnyViewHolder)holder;
         mBunnyViewHolder.bind(mBunnies.get(position));
         mBunnyViewHolder.getmBunnyName().setOnClickListener(this);

    }

    @Override
    public int getItemCount() {
        return mBunnies.size();
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.bunny_name:

                mManinActivity.getFragmentManager().beginTransaction().add(R.id.bunny_second_activity, new NameFragment()).commit();


            break;
        }

    }
}
