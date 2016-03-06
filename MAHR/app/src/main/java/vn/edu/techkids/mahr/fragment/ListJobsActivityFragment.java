package vn.edu.techkids.mahr.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vn.edu.techkids.mahr.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class ListJobsActivityFragment extends BaseFragment {

    public ListJobsActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list_jobs, container, false);
    }
}
