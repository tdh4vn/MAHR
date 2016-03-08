package vn.edu.techkids.mahr;

import android.app.Application;

import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;

import vn.edu.techkids.mahr.enitity.DownloadJsonTask;
import vn.edu.techkids.mahr.constants.Constants;
import vn.edu.techkids.mahr.enitity.Expertise;
import vn.edu.techkids.mahr.enitity.JSONDecoder;

/**
 * Created by qhuydtvt on 3/9/2016.
 */
public class MAHARApplication extends Application {

    private DownloadJsonTask downloadJsonTask;
    @Override
    public void onCreate() {
        downloadJsonTask = new DownloadJsonTask();
        downloadJsonTask.setJsonDecoder(new JSONDecoder() {
            @Override
            public void decode(JSONObject jsonObject) {
                Expertise.loadExperiseArrayList(jsonObject);
            }
        });

        try {
            downloadJsonTask.execute(new URL(Constants.API_URL_EXPERTISE));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        super.onCreate();
    }
}
