package vn.edu.techkids.mahr.fragment.MigrationProgressFragments;

import android.net.Uri;
import android.view.View;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import vn.edu.techkids.mahr.constants.Constants;
import vn.edu.techkids.mahr.enitity.DataChangeListener;
import vn.edu.techkids.mahr.enitity.HttpQueryBuilder;
import vn.edu.techkids.mahr.enitity.JSONObjectParser;
import vn.edu.techkids.mahr.enitity.JSONObjectPutTask;
import vn.edu.techkids.mahr.enitity.MigrationProgress;
import vn.edu.techkids.mahr.fragment.TypeOneMigrationParamFragment;

/**
 * Created by qhuydtvt on 3/17/2016.
 */
public class PassportPickerFragment extends TypeOneMigrationParamFragment {

    @Override
    protected void fillData() {
        mCheckBoxDone.setChecked(MigrationProgress.getInst().getPassportStatus() != 0);
        mEndDateTextView.setText(MigrationProgress.getInst().getPassportEndDate());
    }

    @Override
    public String buildQuery() {
        Uri.Builder builder = new Uri.Builder()
                .appendQueryParameter(MigrationProgress.API_MIG_PROG_PASSPORT_STATUS,
                        getCheckedString())
                .appendQueryParameter(MigrationProgress.API_MIG_PROG_PASSPORT_END_DATE,
                        getEndDateString());
        String query = builder.build().getEncodedQuery();
        return query;
    }
//    @Override
//    protected void initLayout(View view) {
//        super.initLayout(view);
//        mCheckBoxDone.setChecked(MigrationProgress.getInst().getPassportStatus() != 0);
//    }
//
//    @Override
//    protected void handleOKClick() {
//        JSONObjectPutTask putTask = new JSONObjectPutTask(this, this);
//        try {
//            putTask.execute(new URL(
//                    String.format(Constants.API_URL_PROGRESSES_PUT_FORMAT,
//                    MigrationProgress.getInst().getProfileId())));
//        } catch (MalformedURLException e) {
//        }
//    }
//
//    @Override
//    public String buildQuery() {
//        Uri.Builder builder = new Uri.Builder()
//                .appendQueryParameter(MigrationProgress.API_MIG_PROG_PASSPORT_STATUS, getCheckedString())
//                .appendQueryParameter(MigrationProgress.API_MIG_PROG_PASSPORT_END_DATE, getEndDateString());
//        return builder.build().getEncodedQuery();
//    }
//
//    @Override
//    public Object parse(String tag, InputStreamReader inputStreamReader) throws IOException {
//        MigrationProgress migrationProgress = (new Gson()).fromJson(inputStreamReader,
//                MigrationProgress.class);
//        if(migrationProgress != null){
//            this.dismiss();
//        }
//        return migrationProgress;
//    }
//
//    @Override
//    public void onDataChange(Object object) {
//
//    }
}
