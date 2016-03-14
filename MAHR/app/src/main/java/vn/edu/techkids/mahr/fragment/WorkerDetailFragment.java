package vn.edu.techkids.mahr.fragment;


import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
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

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import vn.edu.techkids.mahr.R;
import vn.edu.techkids.mahr.constants.Constants;
import vn.edu.techkids.mahr.enitity.Cloud;
import vn.edu.techkids.mahr.enitity.Worker;


public class WorkerDetailFragment extends BaseFragment implements View.OnClickListener{

    /*private String mWorkerDetailUrl;*/
    private Worker mWorker;
    private WebView mWvWorkerDetail;
    private Button mBtnShare;
    private Button mBtnConfirm;
    private Button mBtnUse;


    public WorkerDetailFragment() {
        // Required empty public constructor
        mWorker = new Worker();
        mWorker.setExcel_path("");
        mWorker.setId(1);
    }

    public void setWorker(Worker worker) {
        this.mWorker = worker;
        Log.d("setWorker", mWorker.getExcel_path());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_worker_detail, container, false);
        initLayout(view);
        return view;
    }

    private void initLayout(View view) {
        mWvWorkerDetail = (WebView)view.findViewById(R.id.wvWorkerDetail);
        mWvWorkerDetail.setWebViewClient(new AppWebViewClients());
        mWvWorkerDetail.getSettings().setBuiltInZoomControls(true);
        mWvWorkerDetail.getSettings().setSupportZoom(true);
        mWvWorkerDetail.getSettings().setJavaScriptEnabled(true);
        mWvWorkerDetail.getSettings().setDisplayZoomControls(false);

        mWvWorkerDetail.loadUrl("https://docs.google.com/gview?embedded=true&url=" + mWorker.getExcel_path());

        Cloud.getInstance().setUrlLink(mWorker.getExcel_path());

        mBtnConfirm = (Button)view.findViewById(R.id.btnConfirm);
        mBtnShare = (Button)view.findViewById(R.id.btnShare);
        mBtnUse = (Button)view.findViewById(R.id.btnUse);

        mBtnUse.setOnClickListener(this);
        mBtnShare.setOnClickListener(this);
        mBtnConfirm.setOnClickListener(this);

//        view.findViewById(R.id.btnShare).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                shareExcelLink();
//            }
//        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.e("onOptionsItemSelected", "2");
        if (item.getItemId() == R.id.action_share){
            Log.e("onOptionsItemSelected", "3");
            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, mWorker.getExcel_path());
            startActivity(Intent.createChooser(sharingIntent, mWorker.getExcel_path()));
        }
        return super.onOptionsItemSelected(item);
    }

    private void shareExcelLink() {
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, mWorker.getExcel_path());
        startActivity(Intent.createChooser(sharingIntent, mWorker.getExcel_path()));
    }

    @Override
    public void onStart() {
        super.onStart();
        try {
            getScreenManager().setTitleOfActionBar(getString(R.string.detail));
            getScreenManager().showShareButtonOnRightActionBar();
            setHasOptionsMenu(true);
        }catch (Exception e){

        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnShare:
                shareExcelLink();
                break;
            case R.id.btnUse:
                sendUseCommand();
                break;
            case R.id.btnConfirm:
                sendConfirmCommand();
                break;
        }
    }

    private void sendUseCommand() {
        try {
            HttpPutTask httpPutTask = new HttpPutTask(new HttpPutQueryBuilder() {
                @Override
                public String buildQuery() {
                    Uri.Builder builder = new Uri.Builder()
                            .appendQueryParameter(Constants.API_PUT_STATUS, Constants.API_PUT_STATUS_CONFIRM);
                    String query = builder.build().getEncodedQuery();
                    return query;
                }
            });

            httpPutTask.execute(new URL(String.format(Constants.API_URL_PROFILE_PUT_FORMAT,
                    mWorker.getId())));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

//        try {
//            URL url = new URL();
//            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
//            httpURLConnection.setRequestMethod("PUT");
//            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
//            httpURLConnection.setUseCaches(false);
//            httpURLConnection.setDoInput(true);
//            httpURLConnection.setDoOutput(true);
//
//            Uri.Builder builder = new Uri.Builder()
//                    .appendQueryParameter(Constants.API_PUT_STATUS, Constants.API_PUT_STATUS_CONFIRM);
//            String query = builder.build().getEncodedQuery();
//            Log.d("sendUseCommand", query);
//            OutputStream os = httpURLConnection.getOutputStream();
//            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
//            writer.write(query);
//
//            writer.flush();
//            writer.close();
//            os.close();
//
//            httpURLConnection.connect();
//
//            int responseCode = httpURLConnection.getResponseCode();
//            if(responseCode == HttpURLConnection.HTTP_OK) {
//                InputStream is = httpURLConnection.getInputStream();
//                BufferedReader rd = new BufferedReader(new InputStreamReader(is));
//                String line;
//                StringBuffer response = new StringBuffer();
//                while((line = rd.readLine()) != null) {
//                    response.append(line);
//                    response.append('\r');
//                }
//                rd.close();
//            }
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    private void sendConfirmCommand() {
        try {
            HttpPutTask httpPutTask = new HttpPutTask(new HttpPutQueryBuilder() {
                @Override
                public String buildQuery() {
                    Uri.Builder builder = new Uri.Builder()
                            .appendQueryParameter(Constants.API_PUT_STATUS, Constants.API_PUT_STATUS_USE);
                    String query = builder.build().getEncodedQuery();
                    return query;
                }
            });

            httpPutTask.execute(new URL(String.format(Constants.API_URL_PROFILE_PUT_FORMAT,
                    mWorker.getId())));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
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

    private interface HttpPutQueryBuilder {
        String buildQuery();
    }

    private class HttpPutTask extends AsyncTask<URL, Integer, Void> {

        private HttpPutQueryBuilder mHttpPutQueryBuilder;

        public HttpPutTask(HttpPutQueryBuilder httpPutQueryBuilder) {
            this.mHttpPutQueryBuilder = httpPutQueryBuilder;
        }

        @Override
        protected Void doInBackground(URL... params) {
            try {
                URL url = params[0];

                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("PUT");
                httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);

//                Uri.Builder builder = new Uri.Builder()
//                        .appendQueryParameter(Constants.API_PUT_STATUS, Constants.API_PUT_STATUS_CONFIRM);
//                String query = builder.build().getEncodedQuery();

                if(mHttpPutQueryBuilder != null) {
                    String query = mHttpPutQueryBuilder.buildQuery();
                    Log.d("sendUseCommand", query);
                    OutputStream os = httpURLConnection.getOutputStream();
                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                    writer.write(query);

                    writer.flush();
                    writer.close();
                    os.close();
                }

                int responseCode = httpURLConnection.getResponseCode();
                if(responseCode == HttpURLConnection.HTTP_OK) {
                    InputStream inputStream = httpURLConnection.getInputStream();
                    StringBuffer response = new StringBuffer();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        response.append(line);
                    }

                    Log.d("HttpPutTask", response.toString());
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }
    }
}
