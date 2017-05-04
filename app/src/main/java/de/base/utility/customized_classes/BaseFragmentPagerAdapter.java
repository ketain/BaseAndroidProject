package de.base.utility.customized_classes;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import javax.inject.Inject;

import de.base.injection.ActivityContext;
//import timum.timumapp.ui.dashboard.on_click_listeners.SerializableClickListener;


/**
 * Created by scorp on 15.02.2017.
 */

public class BaseFragmentPagerAdapter extends FragmentPagerAdapter{

    private final Context mContext;

    @Inject
    public BaseFragmentPagerAdapter(FragmentManager fm, @ActivityContext Context context) {
        super(fm);
        this.mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
       return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

}
