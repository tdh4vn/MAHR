package vn.edu.techkids.mahr.fragment;


import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;

import vn.edu.techkids.mahr.R;

import java.util.Calendar;
import java.util.Date;
/**
 * A simple {@link Fragment} subclass.
 */
public class TwoDatePickerFragment extends BaseDialogFragment implements View.OnClickListener{

    protected Button mOKButton;
    protected String mTitle;
    protected TextView mStartDateTextView;
    protected TextView mEndDateTextView;

    public TwoDatePickerFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two_date_picker, container, false);
        initLayout(view);
        fillDates();
        return view;
    }

    protected void initLayout(View view) {
        mOKButton = (Button)view.findViewById(R.id.btn_OK);
        mStartDateTextView = (TextView)view.findViewById(R.id.tv_start_date);
        mEndDateTextView = (TextView)view.findViewById(R.id.tv_end_date);

        mOKButton.setOnClickListener(this);
        mStartDateTextView.setOnClickListener(this);
        mEndDateTextView.setOnClickListener(this);

        if(mTitle != null) {
            getDialog().setTitle(mTitle);
        }
    }

    protected void fillDates() {
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        mStartDateTextView.setText(date);
        mEndDateTextView.setText(date);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_OK:
                handleOKClick();
                break;
            case R.id.tv_start_date:
                handleStartDateClick();
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
        DatePickerFragment datePickerFragment = createDateTimePicker();
        getScreenManager().showDialogFragment(datePickerFragment, "");
    }

    protected void handleStartDateClick() {
        DatePickerFragment datePickerFragment = createDateTimePicker();
        getScreenManager().showDialogFragment(datePickerFragment, "");
    }

    private DatePickerFragment createDateTimePicker() {
        final Calendar c = Calendar.getInstance();
        int yy = c.get(Calendar.YEAR);
        int mm = c.get(Calendar.MONTH);
        int dd = c.get(Calendar.DAY_OF_MONTH);

        DatePickerFragment datePickerFragment = new DatePickerFragment();
        datePickerFragment.setDate(yy, mm, dd);
        return datePickerFragment;
    }

    protected TwoDatePickerFragment setTitle(String title) {
        mTitle = title;
        return this;
    }
}
