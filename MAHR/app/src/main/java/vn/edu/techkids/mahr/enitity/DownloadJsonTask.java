package vn.edu.techkids.mahr.enitity;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by qhuydtvt on 3/9/2016.
 */
public class DownloadJSONTask extends AsyncTask<URL, Integer, JSONObject>{

    private HttpURLConnection urlConnection = null;
    private BufferedReader bufferedReader = null;
    private JSONPostDownloadHandler jsonPostDownloadHandler = null;
    private JSONPreDownloadHandler jsonPreDownloadHandler = null;

    public void setJsonPostDownloadHandler(JSONPostDownloadHandler jsonPostDownloadHandler) {
        this.jsonPostDownloadHandler = jsonPostDownloadHandler;
    }

    public DownloadJSONTask() {
    }

    public DownloadJSONTask(JSONPreDownloadHandler preDownloadHandler,
                            JSONPostDownloadHandler jsonPostDownloadHandler) {
        this.jsonPreDownloadHandler = preDownloadHandler;
        this.jsonPostDownloadHandler = jsonPostDownloadHandler;
    }

    @Override
    protected void onPreExecute() {
        if(jsonPreDownloadHandler != null) {
            jsonPreDownloadHandler.onPreDownload();
        }
        super.onPreExecute();
    }

    @Override
    protected JSONObject doInBackground(URL... params) {
        Log.d("doInBackground", "Running");
        if (params.length > 0) {
            URL url = params[0];
            try {
                urlConnection = (HttpURLConnection) url.openConnection();
                int responseCode = urlConnection.getResponseCode();

                if (responseCode == HttpURLConnection.HTTP_OK) { /* Good! */
                    /* Prepare the buffer */
                    InputStream inputStream = urlConnection.getInputStream();
                    StringBuffer response = new StringBuffer();
                    bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        response.append(line);
                    }

                    try {
                        Log.d("doInBackground", response.toString());
                        return new JSONObject(response.toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
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
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(JSONObject jsonObject) {
        if(jsonPostDownloadHandler != null) {
            jsonPostDownloadHandler.onPostDownload(jsonObject);
        }
        super.onPostExecute(jsonObject);
    }
}
