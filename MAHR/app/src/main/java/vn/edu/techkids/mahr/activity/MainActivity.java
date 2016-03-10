package vn.edu.techkids.mahr.activity;

import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import vn.edu.techkids.mahr.R;
import vn.edu.techkids.mahr.fragment.WorkerListFragment;
import vn.edu.techkids.mahr.fragment.NationalitySelectionFragment;
import vn.edu.techkids.mahr.fragment.ScreenManager;

public class MainActivity extends AppCompatActivity implements ScreenManager {

    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTheme(R.style.AppTheme_NoActionBar);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#29B6F6")));

        /*hideActionBar();*/

        getIntances();
        openFragment(new NationalitySelectionFragment(), true);
    }

    private void getIntances() {
        mFragmentManager = getFragmentManager();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() != R.id.action_filter){
            onBackPressed();
            overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
        } else if (item.getItemId() == R.id.action_filter){
            openFragment(new WorkerListFragment(), true);
            overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
        }
        return true;
    }

    @Override

    /**
     * Open new screen
     * @param fragment
     * @param addToBackStack
     */
    public void openFragment(Fragment fragment, boolean addToBackStack) {
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.trans_left_in, R.anim.trans_left_out);
        fragmentTransaction.replace(R.id.fl_job_list, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        if (addToBackStack) {
            fragmentTransaction.addToBackStack(fragment.getClass().getName());
        }

        fragmentTransaction.commit();
    }

    @Override
    public boolean back() {
        if (mFragmentManager.getBackStackEntryCount() > 1) {
            mFragmentManager.popBackStack();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void showActionBar() {
        getSupportActionBar().show();
    }

    @Override
    public void hideDisplayHomeButton() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }

    @Override
    public void showDisplayHomeButton() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void hideActionBar() {
        getSupportActionBar().hide();
    }


    @Override
    public void showDialogFragment(DialogFragment dialogFragment, String tag) {
        dialogFragment.show(mFragmentManager, tag);
    }

    @Override
    public void setTitleOfActionBar(String titles) {
        getSupportActionBar().setTitle(titles);
    }

    @Override
    public void onBackPressed() {
        if(!back())
            super.onBackPressed();
    }
}
