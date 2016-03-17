package vn.edu.techkids.mahr.fragment;


import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.TextView;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;

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
 * A simple {@link Fragment} subclass.
 */
public abstract class  TypeOneMigrationParamFragment
        extends BaseDialogFragment implements
        View.OnClickListener,
        DatePickerDialog.OnDateSetListener,
        HttpQueryBuilder,
        JSONObjectPreDownloadHandler,
        JSONObjectPostDownloadHandler,
        DataChangeListener {

    protected Button mOKButton;
    protected String mTitle;

    protected TextView mEndDateTextView;
    protected CheckBox mCheckBoxDone;

    protected ProgressDialog progressDialog;

    public TypeOneMigrationParamFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_one_date_time_picker, container, false);
        initLayout(view);
        fillData();
        return view;
    }

    protected void initLayout(View view) {
        mOKButton = (Button)view.findViewById(R.id.btn_OK);
        mEndDateTextView = (TextView)view.findViewById(R.id.tv_end_date);
        mCheckBoxDone = (CheckBox)view.findViewById(R.id.chb_progress_done);

        mOKButton.setOnClickListener(this);
        mEndDateTextView.setOnClickListener(this);

        if(mEndDateTextView != null) {
            getDialog().setTitle(mTitle);
        }
    }

    protected void registerEvents() {
        MigrationProgress.getInst().setmDataChangeListener(this);
    }

    protected abstract void fillData();

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_OK:
                handleOKClick();
                break;
            case R.id.tv_end_date:
                handleEndDateClick();
                break;
        }
    }

    protected void handleOKClick() {
        JSONObjectPutTask jsonObjectPutTask = new JSONObjectPutTask(this, new MigrationProgresJSONParser());
        jsonObjectPutTask.setJSONObjectPostDownloadHandler(this);
        try {
            jsonObjectPutTask.execute(new URL(String.format(
                    Constants.API_URL_PROGRESSES_PUT_FORMAT,
                    MigrationProgress.getInst().getProfileId())));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    protected void handleEndDateClick() {
        final Calendar c = Calendar.getInstance();

        int yy = c.get(Calendar.YEAR);
        int mm = c.get(Calendar.MONTH);
        int dd = c.get(Calendar.DAY_OF_MONTH);

        DatePickerFragment datePickerFragment = new DatePickerFragment();
        datePickerFragment.setDate(yy, mm, dd);
        datePickerFragment.setOnDateSetListener(this);
        getScreenManager().showDialogFragment(datePickerFragment, "");
    }

    public TypeOneMigrationParamFragment setTitle(String title) {
        this.mTitle = title;
        return this;
    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        this.mEndDateTextView.setText(String.format(Constants.API_DATE_FORMAT, dayOfMonth, monthOfYear, year));
    }

    protected String getCheckedString() {
        return mCheckBoxDone.isChecked()? Constants.API_PUT_STATUS_DONE : Constants.API_PUT_STATUS_NOT_DONE;
    }

    protected String getEndDateString() {
        return mEndDateTextView.getText().toString();
    }

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
            this.dismiss();
        }
        else {
            getScreenManager().showMessage(getString(R.string.message_download_failed));
        }
    }

    @Override
    public void onDataChange(Object object) {
        fillData();
    }
}