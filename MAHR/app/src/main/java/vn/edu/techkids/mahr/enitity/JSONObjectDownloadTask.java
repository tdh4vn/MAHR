package vn.edu.techkids.mahr.enitity;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by qhuydtvt on 3/16/2016.
 */
public class JSONObjectDownloadTask extends AsyncTask<URL, Integer, Object> {

    private String mTag;
    private JSONObjectParser mJsonObjectParser;
    private JSONObjectPostDownloadHandler mJsonPostDownloadHandler;

    private HttpURLConnection urlConnection = null;
    private BufferedReader bufferedReader = null;
    private InputStream inputStream = null;
    private InputStreamReader inputStreamReader = null;

    public JSONObjectDownloadTask() {
    }

    public JSONObjectDownloadTask(String tag, JSONObjectParser jsonObjectParser, JSONObjectPostDownloadHandler
            jsonObjectPostDownloadHandler) {
        this.mTag = tag;
        this.mJsonObjectParser = jsonObjectParser;
        this.mJsonPostDownloadHandler = jsonObjectPostDownloadHandler;
    }

    @Override
    protected Object doInBackground(URL... params) {
        Log.d("doInBackground", "Running");
        if (params.length > 0) {
            URL url = params[0];
            try {
                urlConnection = (HttpURLConnection) url.openConnection();
                int responseCode = urlConnection.getResponseCode();

                if (responseCode == HttpURLConnection.HTTP_OK) { /* Good! */
                    inputStream = urlConnection.getInputStream();
                    inputStreamReader = new InputStreamReader(inputStream);

                    if (mJsonObjectParser != null) {
                        Object object = mJsonObjectParser.parse(mTag, inputStreamReader);
                        return object;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (urlConnection != null)
                    urlConnection.disconnect();
                if (bufferedReader != null)
                    try {
                        bufferedReader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (inputStreamReader != null) {
                    try {
                        inputStreamReader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(Object o) {
        if(mJsonPostDownloadHandler != null) {
            mJsonPostDownloadHandler.onPostDownload(mTag, o);
        }
        super.onPostExecute(o);
    }
}
