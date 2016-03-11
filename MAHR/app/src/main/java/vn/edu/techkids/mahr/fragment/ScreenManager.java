package vn.edu.techkids.mahr.fragment;

import android.app.DialogFragment;
import android.app.Fragment;

/**
 * Created by qhuydtvt on 3/7/2016.
 */
public interface ScreenManager {
    void openFragment(Fragment fragment, boolean addToBackStack);
    void showDialogFragment(DialogFragment dialogFragment, String tag);
    boolean back();
    void showActionBar();
    void hideDisplayHomeButton();
    void showDisplayHomeButton();
    void hideActionBar();
    void setActionBarColor(String color);
    void setTitleOfActionBar(String titles);
    void showShareButtonOnRightActionBar();
    void hidenButtonActionBar();
}
