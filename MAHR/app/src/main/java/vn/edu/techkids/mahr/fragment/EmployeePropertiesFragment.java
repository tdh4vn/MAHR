package vn.edu.techkids.mahr.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import vn.edu.techkids.mahr.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class EmployeePropertiesFragment extends Fragment {


    private ListView mEmployeeProperitesList;


    public EmployeePropertiesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vRet =  inflater.inflate(R.layout.fragment_employee_properties, container, false);
        return vRet;
    }

    private void getIntances(View vRet) {

    }

}
