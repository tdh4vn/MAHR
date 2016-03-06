package vn.edu.techkids.mahr.fragment;

/*import android.support.app.Fragment;*/
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import vn.edu.techkids.mahr.R;


/**
 * A placeholder fragment containing a simple view.
 */


public class ListJobsActivityFragment extends BaseFragment {

    public ListJobsActivityFragment() {

    }

    @Override
    public void onStart() {
        super.onStart();
        getScreenManager().showActionBar();
        getScreenManager().changeTitleOfActionBar(getString(R.string.listJobMainName));
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.setCustomAnimations(R.anim.trans_left_in,R.anim.trans_left_out);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_list_jobs, container, false);
        this.addListener(view);
        return view;
    }

    private void addListener(View view){
        Button btnMaleEmployee = (Button) view.findViewById(R.id.btnMaleEmployee);
        Button btnFemaleEmployee = (Button) view.findViewById(R.id.btnFemaleEmployee);
        Button btnHousemaid = (Button) view.findViewById(R.id.btnHousemaid);
        btnMaleEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getScreenManager().openFragment(new EmployeePropertiesFragment(), true);
            }
        });
        btnFemaleEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getScreenManager().openFragment(new EmployeePropertiesFragment(), true);
            }
        });
        btnHousemaid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getScreenManager().openFragment(new EmployeePropertiesFragment(), true);
            }
        });
    }
}
