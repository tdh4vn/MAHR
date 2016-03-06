package vn.edu.techkids.mahr.fragment;

import android.app.Fragment;

/**
 * Created by qhuydtvt on 3/7/2016.
 */
public interface ScreenManager {
    void openFragment(Fragment fragment, boolean addToBackStack);
    boolean back();
    void showActionBar();
    void hideActionBar();
}
