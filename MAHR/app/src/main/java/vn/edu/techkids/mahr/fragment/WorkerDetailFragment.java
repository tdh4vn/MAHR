package vn.edu.techkids.mahr.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import vn.edu.techkids.mahr.R;
import vn.edu.techkids.mahr.enitity.Cloud;


public class WorkerDetailFragment extends BaseFragment {

    private String mWorkerDetailUrl;
    private WebView mWvWorkerDetail;

    public WorkerDetailFragment() {
        // Required empty public constructor
    }

    public void setWorkerDetailUrl(String workerDetailUrl) {
        this.mWorkerDetailUrl = workerDetailUrl;
        Log.d("setWorkerDetailUrl", workerDetailUrl);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_worker_detail, container, false);

        mWvWorkerDetail = (WebView)view.findViewById(R.id.wvWorkerDetail);

        mWvWorkerDetail.setWebViewClient(new AppWebViewClients());
        mWvWorkerDetail.getSettings().setBuiltInZoomControls(true);
        mWvWorkerDetail.getSettings().setSupportZoom(true);
        //mWvWorkerDetail.getSettings().setUseWideViewPort(true);
        mWvWorkerDetail.getSettings().setJavaScriptEnabled(true);
        mWvWorkerDetail.getSettings().setDisplayZoomControls(false);
        //mWvWorkerDetail.getSettings().setUseWideViewPort(true);

        mWvWorkerDetail.loadUrl("https://docs.google.com/gview?embedded=true&url=" + mWorkerDetailUrl);

        Cloud.getInstance().setUrlLink(mWorkerDetailUrl);

        view.findViewById(R.id.btnShare).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareExcelLink();
            }
        });

        return view;
    }

    /*@Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_list_jobs, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.e("onOptionsItemSelected", "2");
        if (item.getItemId() == R.id.action_share){
            Log.e("onOptionsItemSelected", "3");
            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, mWorkerDetailUrl);
            startActivity(Intent.createChooser(sharingIntent, mWorkerDetailUrl));
        }
        return super.onOptionsItemSelected(item);
    }

    private void shareExcelLink() {
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, mWorkerDetailUrl);
        startActivity(Intent.createChooser(sharingIntent, mWorkerDetailUrl));
    }


    @Override
    public void onStart() {
        getScreenManager().setTitleOfActionBar(getString(R.string.detail));
        getScreenManager().showShareButtonOnRightActionBar();
        setHasOptionsMenu(true);
        super.onStart();
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
