package com.example.dec4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.dec4.Model.Bunny;
import com.example.dec4.View.BunnyAdapter;
import com.example.dec4.View.MyNotificationService;

import java.util.ArrayList;
import java.util.List;

import nl.qbusict.cupboard.QueryResultIterable;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

/**
 * Created by Millochka on 12/4/16.
 */

public class SecondActivity extends AppCompatActivity {

    private static final String TAG ="SecondActivity" ;
    RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        mRecyclerView=(RecyclerView)findViewById(R.id.bunny_item);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        mRecyclerView.setAdapter(new BunnyAdapter(selectAllCats(),this));




    }

    private List<Bunny> selectAllCats() {
        List<Bunny> bunnies = new ArrayList<>();

        try {
            // Iterate cats
            QueryResultIterable<Bunny> itr = cupboard().withDatabase(MyNotificationService.db).query(Bunny.class).query();
            for (Bunny bunny : itr) {
                bunnies.add(bunny);
            }
            itr.close();
        } catch (Exception e) {
            Log.e(TAG, "selectAllCats: ", e);
        }

        return bunnies;
    }


}
