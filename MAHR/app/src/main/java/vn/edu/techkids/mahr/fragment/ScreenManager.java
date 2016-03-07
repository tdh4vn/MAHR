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
    void hideActionBar();
    void changeTitleOfActionBar(String titles);
}
