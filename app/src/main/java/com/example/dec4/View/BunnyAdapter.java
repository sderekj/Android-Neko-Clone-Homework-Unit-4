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
public class BunnyAdapter extends RecyclerView.Adapter {


    private List<Bunny> mBunnies = new ArrayList<>();


    private Activity mSecondActivity;




    private Listener listener;




    public BunnyAdapter(List<Bunny> bunnies, Activity secondActivity, Listener listener){

        this.mBunnies=bunnies;
        this.mSecondActivity=secondActivity;
        this.listener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cute_bunny, parent, false);
        BunnyViewHolder cuteBunny = new BunnyViewHolder(view);
        return cuteBunny;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        BunnyViewHolder mBunnyViewHolder=(BunnyViewHolder)holder;
         mBunnyViewHolder.bind(mBunnies.get(position));
        mBunnyViewHolder.getmBunnyLayout().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                listener.onBunnyClicked(mBunnies.get(position));

            }
        });

        mBunnyViewHolder.getmBunnyLayout().setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                listener.onBunnyLongClicked(mBunnies.get(position));

                return true;
            }
        });




    }

    @Override
    public int getItemCount() {
        return mBunnies.size();
    }

    public void setData(List<Bunny> bunnies) {
        this.mBunnies = bunnies;
        notifyDataSetChanged();
    }


    public interface Listener {
        void onBunnyClicked(Bunny bunny);
        void onBunnyLongClicked(Bunny bunny);
    }

}
