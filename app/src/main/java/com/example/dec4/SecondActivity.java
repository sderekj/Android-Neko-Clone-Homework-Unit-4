package com.example.dec4;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
    private static final String BUNNY_NUMBER = "com.example.dec4";
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
        mClickedBunny = new Bunny();}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.lure_bunny_menu_item:
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.bunny_second_activity, new BunnyFeederFragment());
                fragmentTransaction.commit();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
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

        switch (view.getId()) {
            case R.id.bunny_view_details:
            getFragmentManager().beginTransaction().remove(mDetailedFragment).commit();
                break;
            case R.id.name_changer_layout:
                getFragmentManager().beginTransaction().remove(mNameFragment).commit();
                break;
        }

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



        Bundle bundle = new Bundle();

        bundle.putInt(BUNNY_NUMBER,bunny.getBunnyNumber());
        mDetailedFragment.setArguments(bundle);

        getFragmentManager().beginTransaction().add(R.id.bunny_second_activity, mDetailedFragment).commit();

    }

}
