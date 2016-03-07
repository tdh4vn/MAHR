package vn.edu.techkids.mahr.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import vn.edu.techkids.mahr.R;
import vn.edu.techkids.mahr.constants.Constants;


/**
 * A simple {@link Fragment} subclass.
 */
public class NationalitySelectionFragment extends BaseFragment implements View.OnClickListener {

    private Button mVietnamSlectButton;
    private Button mIndoSelectButton;

    public NationalitySelectionFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_nationality_selection, container, false);
        initLayout(view);

        return view;
    }

    @Override
    public void onStart() {
        getScreenManager().hideActionBar();
        super.onStart();
    }

    private void initLayout(View view) {
        mVietnamSlectButton = (Button)view.findViewById(R.id.btnVietnam);
        mIndoSelectButton = (Button)view.findViewById(R.id.btnIndonesia);
        mVietnamSlectButton.setOnClickListener(this);
        mIndoSelectButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String key = "";
        switch (v.getId()) {
            case R.id.btnIndonesia:
                key = Constants.KEY_INDONESIA;
                break;
            case R.id.btnVietnam:
                key = Constants.KEY_VIETNAM;
                break;
        }

        getScreenManager().openFragment(new ListJobsActivityFragment(), true);
    }
}