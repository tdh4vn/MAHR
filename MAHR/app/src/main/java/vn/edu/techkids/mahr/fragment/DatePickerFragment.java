package vn.edu.techkids.mahr.fragment;


import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;

import vn.edu.techkids.mahr.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DatePickerFragment extends DialogFragment implements View.OnClickListener{

    private DatePickerDialog.OnDateSetListener mOnDateSetListener;
    private Button mButtonOK;
    private DatePicker mDatePicker;

    private int year;
    private int month;
    private int day;

    public DatePickerFragment() {
    }

    public void setOnDateSetListener(DatePickerDialog.OnDateSetListener onDateSetListener) {
        mOnDateSetListener = onDateSetListener;
    }

    public void setDate(int yy, int mm, int dd) {
        year = yy;
        month = mm;
        day = dd;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_date_picker, container, false);
        initLayout(view);
        return view;
    }

    private void initLayout(View view) {
        mButtonOK = (Button)view.findViewById(R.id.btn_OK);
        mButtonOK.setOnClickListener(this);
        mDatePicker = (DatePicker)view.findViewById(R.id.date_picker);
        mDatePicker.updateDate(year, month, day);
    }

    @Override
    public void onClick(View v) {
        if(mOnDateSetListener != null) {
            int y = mDatePicker.getYear();
            int mm = mDatePicker.getMonth();
            int dd = mDatePicker.getDayOfMonth();
            mOnDateSetListener.onDateSet(mDatePicker, y, mm, dd);
        }
        this.dismiss();
    }
}