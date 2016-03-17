package vn.edu.techkids.mahr.fragment;

import android.app.DialogFragment;

/**
 * Created by qhuydtvt on 3/17/2016.
 */
public class BaseDialogFragment extends DialogFragment{

    protected static ScreenManager mScreenManager;

    public static void setScreenManager(ScreenManager screenManager) {
        mScreenManager = screenManager;
    }

    protected static ScreenManager getScreenManager() {
        return mScreenManager;
    }
}
