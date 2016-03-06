package vn.edu.techkids.mahr.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vn.edu.techkids.mahr.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class EmployeePropertiesFragment extends Fragment {


    public EmployeePropertiesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_employee_properties, container, false);
    }

}
