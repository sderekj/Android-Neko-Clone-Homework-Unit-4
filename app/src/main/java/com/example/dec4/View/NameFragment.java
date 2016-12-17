package com.example.dec4.View;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.dec4.R;

/**
 * Created by Millochka on 12/14/16.
 */
public class NameFragment extends Fragment{

    private EditText mBunnyName;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.to_change_name, container, false);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mBunnyName=(EditText) view.findViewById(R.id.type_bunny_name);


    }


    public EditText getmBunnyName() {
        return mBunnyName;
    }

    public void setmBunnyName(String input) {

        this.mBunnyName.setText("");
        this.mBunnyName.setHint(input);
    }
}
