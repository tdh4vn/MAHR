package vn.edu.techkids.mahr.fragment;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.net.MalformedURLException;
import java.net.URL;

import vn.edu.techkids.mahr.R;
import vn.edu.techkids.mahr.constants.Constants;
import vn.edu.techkids.mahr.enitity.DataChangeListener;
import vn.edu.techkids.mahr.enitity.HttpQueryBuilder;
import vn.edu.techkids.mahr.enitity.JSONObjectPostDownloadHandler;
import vn.edu.techkids.mahr.enitity.JSONObjectPreDownloadHandler;
import vn.edu.techkids.mahr.enitity.JSONObjectPutTask;
import vn.edu.techkids.mahr.enitity.MigrationProgresJSONParser;
import vn.edu.techkids.mahr.enitity.MigrationProgress;

/**
 * Created by qhuydtvt on 3/18/2016.
 */
public abstract class MigrationParamFragment extends BaseDialogFragment implements
        HttpQueryBuilder,
        JSONObjectPreDownloadHandler,
        JSONObjectPostDownloadHandler {

//    protected Button mOKButton;
    protected String mTitle;

//    protected TextView mEndDateTextView;
//    protected CheckBox mCheckBoxDone;

    protected ProgressDialog progressDialog;

    public MigrationParamFragment() {
//        registerListeners();
    }


             //    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        View view = inflater.inflate(R.layout.fragment_one_date_time_picker, container, false);
//        initLayout(view);
//        fillData();
//        return view;
//    }
//
//    protected void initLayout(View view) {
//        mOKButton = (Button)view.findViewById(R.id.btn_OK);
//        mEndDateTextView = (TextView)view.findViewById(R.id.tv_end_date);
//        mCheckBoxDone = (CheckBox)view.findViewById(R.id.chb_progress_done);
//
//        mOKButton.setOnClickListener(this);
//        mEndDateTextView.setOnClickListener(this);
//
//        if(mEndDateTextView != null) {
//            getDialog().setTitle(mTitle);
//        }
//    }

//    protected void registerListeners() {
////        MigrationProgress.setDataChangeListener(this);
//    }

    protected abstract void fillData();

//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.btn_OK:
//                callPutAPI();
//                break;
//            case R.id.tv_end_date:
//                handleEndDateClick();
//                break;
//        }
//    }

    protected void callPutAPI() {
        JSONObjectPutTask jsonObjectPutTask = new JSONObjectPutTask(this, new MigrationProgresJSONParser());
        jsonObjectPutTask.setJSONObjectPreDownloadHandler(this);
        jsonObjectPutTask.setJSONObjectPostDownloadHandler(this);
        try {
            jsonObjectPutTask.execute(new URL(String.format(
                    Constants.API_URL_PROGRESSES_PUT_FORMAT,
                    MigrationProgress.getInst().getProfileId())));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    protected void showDatePicker(String title, String dateString,
                                  DatePickerDialog.OnDateSetListener onDateSetListener,
                                  String tag) {
//        final Calendar c = Calendar.getInstance();
//
//        int yy = c.get(Calendar.YEAR);
//        int mm = c.get(Calendar.MONTH);
//        int dd = c.get(Calendar.DAY_OF_MONTH);

        String[] splitedDateString = dateString.split("-");
        int yy = Integer.valueOf(splitedDateString[0]);
        int mm = Integer.valueOf(splitedDateString[1]);
        int dd = Integer.valueOf(splitedDateString[2]);

        DatePickerFragment datePickerFragment = new DatePickerFragment();

        datePickerFragment.setDate(yy, mm, dd);
        datePickerFragment.setTagForDatePicker(tag);
        datePickerFragment.setOnDateSetListener(onDateSetListener);
        getScreenManager().showDialogFragment(datePickerFragment, "");
    }

//    protected void showDatePicker(DatePickerFragment )

    @Override
    public void onPreDownload(String tag) {
        progressDialog = ProgressDialog.show(getScreenManager().getContext(),
                mTitle,
                getString(R.string.loading));
    }

    @Override
    public void onPost(String tag, Object object) {
        if(progressDialog != null){
            progressDialog.dismiss();
            progressDialog = null;
        }
        if(object != null){
            MigrationProgress.notifyDataChanged();
            this.dismiss();
        }
        else {
            getScreenManager().showMessage(getString(R.string.message_download_failed));
        }
    }

    protected String getDateString(String dateString) {
        if(dateString == null || dateString == "") return "0000-00-00";
        return dateString;
    }

//    @Override
//    public void onDataChange(Object object) {
//        fillData();
//    }
}

