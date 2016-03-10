package vn.edu.techkids.mahr.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;

import vn.edu.techkids.mahr.R;
import vn.edu.techkids.mahr.constants.Constants;
import vn.edu.techkids.mahr.enitity.DownloadJSONTask;
import vn.edu.techkids.mahr.enitity.ExpertiseJSONPostDownloadHandler;
import vn.edu.techkids.mahr.enitity.JSONPostDownloadHandler;
import vn.edu.techkids.mahr.enitity.JobCriteria;


/**
 * A simple {@link Fragment} subclass.
 */
public class NationalitySelectionFragment extends BaseFragment
        implements View.OnClickListener, JSONPostDownloadHandler {

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

        try {
            new DownloadJSONTask(null, this, null).execute(new URL(Constants.API_URL_EXPERTISE));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

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
        String nationality = null;
        switch (v.getId()) {
            case R.id.btnIndonesia:
                nationality = Constants.API_INDONESIA;
                break;
            case R.id.btnVietnam:
                nationality = Constants.API_VIETNAM;
                break;
        }
        JobCriteria.getInst().setNationality(nationality);
        getScreenManager().openFragment(new MajorSelectionFragment(), true);
    }

    @Override
    public void onPostDownload(JSONObject jsonObject, String tag) {
        if(jsonObject == null) {
            showToastMessage(getString(R.string.message_download_expertise_failed));
        }
        else {
            JobCriteria.getInst().loadExperiseArrayList(jsonObject);
        }
    }
}
