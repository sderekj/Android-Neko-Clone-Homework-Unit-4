package com.example.dec4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.dec4.Model.Bunny;
import com.example.dec4.View.BunnyAdapter;
import com.example.dec4.View.DetailedFragment;
import com.example.dec4.View.NameFragment;

import java.util.ArrayList;
import java.util.List;

import nl.qbusict.cupboard.QueryResultIterable;

import static com.example.dec4.View.MyNotificationService.db;
import static nl.qbusict.cupboard.CupboardFactory.cupboard;

/**
 * Created by Millochka on 12/4/16.
 */

public class SecondActivity extends AppCompatActivity implements BunnyAdapter.Listener{

    private static final String TAG ="SecondActivity" ;
    RecyclerView mRecyclerView;
    BunnyAdapter mBunnyAdapter;
     NameFragment mNameFragment;
    DetailedFragment mDetailedFragment;

    Bunny mClickedBunny;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        mRecyclerView=(RecyclerView)findViewById(R.id.bunny_item);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        mBunnyAdapter = new BunnyAdapter(selectAllCats(),this,this);
        mRecyclerView.setAdapter(mBunnyAdapter);
        mNameFragment = new NameFragment();
        mDetailedFragment=new DetailedFragment();
        mClickedBunny = new Bunny();

    }

    private List<Bunny> selectAllCats() {
        List<Bunny> bunnies = new ArrayList<>();

        try {
            // Iterate cats
            QueryResultIterable<Bunny> itr = cupboard().withDatabase(db).query(Bunny.class).query();
            for (Bunny bunny : itr) {
                bunnies.add(bunny);
            }
            itr.close();
        } catch (Exception e) {
            Log.e(TAG, "selectAllCats: ", e);
        }

        return bunnies;
    }

    public void ClickOk(View view){

        if(mNameFragment.getmBunnyName().getText().toString().trim().length()!=0){

        mClickedBunny.setName(mNameFragment.getmBunnyName().getText().toString());
        cupboard().withDatabase(db).put(mClickedBunny);
        refreshBunnyList();

            mNameFragment.setmBunnyName("Bunny Name");
        }

        getFragmentManager().beginTransaction().remove(mNameFragment).commit();

    }


    public void removeFragment(View view){

        getFragmentManager().beginTransaction().remove(mDetailedFragment).commit();

    }
    private void refreshBunnyList() {
        mBunnyAdapter.setData(selectAllCats());
    }

    @Override
    public void onBunnyClicked(Bunny bunny) {

        mClickedBunny=bunny;
        getFragmentManager().beginTransaction().add(R.id.bunny_second_activity, mNameFragment).commit();

    }

    @Override
    public void onBunnyLongClicked(Bunny bunny) {

        getFragmentManager().beginTransaction().add(R.id.bunny_second_activity, mDetailedFragment).commit();

    }
}
