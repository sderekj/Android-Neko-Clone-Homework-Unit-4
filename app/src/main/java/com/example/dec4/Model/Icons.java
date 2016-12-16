package com.example.dec4.Model;

import com.example.dec4.R;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Millochka on 12/6/16.
 */

public class Icons {

    List<Integer> mIcons = new ArrayList<>();
    List<Integer> mNotifIcons = new ArrayList<>();

    public Icons() {

        initList();
        initNotificationIcons();

    }

    public void initDrawableList() {
        final R.drawable drawableResources = new R.drawable();
        final Class<R.drawable> c = R.drawable.class;
        final Field[] fields = c.getDeclaredFields();

        for (int i = 0, max = fields.length; i < max; i++) {
            final int resourceId;
            try {
                resourceId = fields[i].getInt(drawableResources);
            } catch (Exception e) {
                continue;
            }

            mIcons.add(resourceId);
    /* make use of resourceId for accessing Drawables here */
        }
    }

    public void initList() {
        mIcons.add(R.drawable.b1_l);
        mIcons.add(R.drawable.b2_l);
        mIcons.add(R.drawable.b3_l);
        mIcons.add(R.drawable.b4_l);
        mIcons.add(R.drawable.b5_l);
        mIcons.add(R.drawable.b6_l);
        mIcons.add(R.drawable.b7_l);
        mIcons.add(R.drawable.b8_l);
        mIcons.add(R.drawable.b9_l);


    }

    public void initNotificationIcons() {
        mNotifIcons.add(R.drawable.b1_s);
        mNotifIcons.add(R.drawable.b2_s);
        mNotifIcons.add(R.drawable.b3_s);
        mNotifIcons.add(R.drawable.b4_s);
        mNotifIcons.add(R.drawable.b5_s);
        mNotifIcons.add(R.drawable.b6_s);
        mNotifIcons.add(R.drawable.b7_s);
        mNotifIcons.add(R.drawable.b8_s);
        mNotifIcons.add(R.drawable.b9_s);


    }

    public List<Integer> getmIcons() {
        return mIcons;
    }

    public List<Integer> getmNotifIcons() {
        return mNotifIcons;
    }
}
