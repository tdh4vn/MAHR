package vn.edu.techkids.mahr.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import vn.edu.techkids.mahr.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class WorkerDetailFragment extends BaseFragment {

    private String mWorkerDetailUrl;
    private WebView mWvWorkerDetail;

    public WorkerDetailFragment() {
        // Required empty public constructor
    }

    public void setmWorkerDetailUrl(String mWorkerDetailUrl) {
        this.mWorkerDetailUrl = mWorkerDetailUrl;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_worker_detail, container, false);

        mWvWorkerDetail = (WebView)view.findViewById(R.id.wvWorkerDetail);


        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        mWvWorkerDetail.loadUrl(this.mWorkerDetailUrl);
    }
}
