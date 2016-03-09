package vn.edu.techkids.mahr.enitity;

import org.json.JSONObject;

/**
 * Created by qhuydtvt on 3/9/2016.
 */
public class ExpertiseJSONPostDownloadHandler implements JSONPostDownloadHandler {
    @Override
    public void onPostDownload(JSONObject jsonObject) {
        Expertise.loadExperiseArrayList(jsonObject);
    }
}
