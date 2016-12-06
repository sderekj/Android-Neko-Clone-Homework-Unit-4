package com.example.dec4.View;

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

    private List<Bunny> bunnies = new ArrayList<>();

    public BunnyAdapter(List<Bunny> bunnies){

        this.bunnies=bunnies;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cute_bunny, parent, false);
        BunnyViewHolder cuteBunny = new BunnyViewHolder(view);
        return cuteBunny;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        BunnyViewHolder bunnyViewHolder=(BunnyViewHolder)holder;
        bunnyViewHolder.bind(bunnies.get(position));

    }

    @Override
    public int getItemCount() {
        return bunnies.size();
    }
}
