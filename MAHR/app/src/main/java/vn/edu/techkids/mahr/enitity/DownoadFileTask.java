package vn.edu.techkids.mahr.enitity;

import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Logger;

import vn.edu.techkids.mahr.fragment.WorkerListFragment;

/**
 * Created by qhuydtvt on 3/11/2016.
 */
public class DownoadFileTask extends AsyncTask<String, String, String> {

    private String mDir;
    private String mUrl;

    private WorkerListFragment workerListFragment;

    public void setmDir(String mDir) {
        this.mDir = mDir;
    }

    /*public void setmUrl(String mUrl) {
        this.mUrl = mUrl;
    }*/

    public void setWorkerListFragment(WorkerListFragment workerListFragment) {
        this.workerListFragment = workerListFragment;
    }

    public DownoadFileTask() {
        /*mDir = dir;
        this.mUrl = url;
        this.workerListFragment = workerListFragment;*/
    }

    @Override
    protected String doInBackground(String... params)
    {
        int count;
        try {

            mUrl = params[0];
            URL url = new URL(mUrl);
            URLConnection conection = url.openConnection();

            conection.connect();

            // this will be useful so that you can show a tipical 0-100%
            // progress bar
            int lenghtOfFile = conection.getContentLength();

            // download the file
            InputStream input = new BufferedInputStream(url.openStream(),
                    8192);

            // Output stream

            File SDCardRoot = Environment.getExternalStorageDirectory();
            //create a new file, specifying the path, and the filename
            //which we want to save the file as.
            File file = new File(SDCardRoot, "test.xls");

            OutputStream output = new FileOutputStream(file);

            byte data[] = new byte[1024];

            long total = 0;

            while ((count = input.read(data)) != -1) {
                total += count;
                // publishing the progress....
                // After this onProgressUpdate will be called
                        /*publishProgress("" + (int) ((total * 100) / lenghtOfFile));*/

                // writing data to file
                output.write(data, 0, count);
            }

            // flushing output
            output.flush();

            // closing streams
            output.close();
            input.close();
            Log.d("Download", "Download done");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        File SDCardRoot = Environment.getExternalStorageDirectory();
        //create a new file, specifying the path, and the filename
        //which we want to save the file as.
        File file = new File(SDCardRoot, "test.xls");

        workerListFragment.openWorkerDetail("file:///" + file.getAbsolutePath());
        super.onPostExecute(s);
    }
}
