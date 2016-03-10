package vn.edu.techkids.mahr.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import vn.edu.techkids.mahr.R;


public class WorkerDetailFragment extends BaseFragment {

    private String mWorkerDetailUrl;
    private WebView mWvWorkerDetail;

    public WorkerDetailFragment() {
        // Required empty public constructor
    }

    public void setWorkerDetailUrl(String mWorkerDetailUrl) {
        this.mWorkerDetailUrl = mWorkerDetailUrl;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_worker_detail, container, false);

        mWvWorkerDetail = (WebView)view.findViewById(R.id.wvWorkerDetail);

        mWvWorkerDetail.setWebViewClient(new AppWebViewClients());
        mWvWorkerDetail.getSettings().setJavaScriptEnabled(true);
        mWvWorkerDetail.getSettings().setUseWideViewPort(true);

        mWvWorkerDetail.loadUrl("https://docs.google.com/gview?embedded=true&url=" + mWorkerDetailUrl);

        getScreenManager().setTitleOfActionBar(getString(R.string.detail));

        return view;
    }

    private class AppWebViewClients extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            // TODO Auto-generated method stub
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            // TODO Auto-generated method stub
            super.onPageFinished(view, url);

        }
    }
}
