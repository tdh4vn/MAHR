package vn.edu.techkids.mahr;

import android.app.Application;

import java.net.MalformedURLException;
import java.net.URL;

import vn.edu.techkids.mahr.enitity.DownloadJSONTask;
import vn.edu.techkids.mahr.constants.Constants;
import vn.edu.techkids.mahr.enitity.ExpertiseJSONPostDownloadHandler;

/**
 * Created by qhuydtvt on 3/9/2016.
 */
public class MAHARApplication extends Application {

    private DownloadJSONTask downloadJSONTask;
    @Override
    public void onCreate() {
        try {
            new DownloadJSONTask(null, new ExpertiseJSONPostDownloadHandler()).execute(new URL(Constants.API_URL_EXPERTISE));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        super.onCreate();
    }
}
