package vn.edu.techkids.mahr.fragment;


import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

import vn.edu.techkids.mahr.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class OneDateTimePickerFragment
        extends BaseDialogFragment implements View.OnClickListener, DatePickerDialog.OnDateSetListener {

    protected Button mOKButton;
    protected String mTitle;
    protected TextView mEndDateTextView;

    public OneDateTimePickerFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_one_date_time_picker, container, false);
        initLayout(view);

        return view;
    }

    protected void initLayout(View view) {
        mOKButton = (Button)view.findViewById(R.id.btn_OK);
        mEndDateTextView = (TextView)view.findViewById(R.id.tv_end_date);

        mOKButton.setOnClickListener(this);
        mEndDateTextView.setOnClickListener(this);

        if(mEndDateTextView != null) {
            getDialog().setTitle(mTitle);
        }
    }

    protected void fillDates()
    {

    }

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

    protected void handleOKClick(){
        this.dismiss();
    }

    protected void handleEndDateClick() {
        final Calendar c = Calendar.getInstance();

        int yy = c.get(Calendar.YEAR);
        int mm = c.get(Calendar.MONTH);
        int dd = c.get(Calendar.DAY_OF_MONTH);

        DatePickerFragment datePickerFragment = new DatePickerFragment();
        datePickerFragment.setDate(yy, mm, dd);
        getScreenManager().showDialogFragment(datePickerFragment, "");


//        DatePickerDialog datePickerDialog = new DatePickerDialog(
//                mContext, this, yy, mm, dd);
//        datePickerDialog.show();
    }

    public OneDateTimePickerFragment setTitle(String title) {
        this.mTitle = title;
        return this;
    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

    }
}