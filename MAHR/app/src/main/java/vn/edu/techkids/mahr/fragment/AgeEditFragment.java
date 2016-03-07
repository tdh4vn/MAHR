package vn.edu.techkids.mahr.fragment;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;

import vn.edu.techkids.mahr.R;
import vn.edu.techkids.mahr.constants.Constants;
import vn.edu.techkids.mahr.enitity.JobCriteria;

/**
 * Created by qhuydtvt on 3/7/2016.
 */
public class AgeEditFragment extends DialogFragment implements View.OnClickListener {

    private NumberPicker mFromPicker;
    private NumberPicker mToPicker;
    private Button mOKButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_edit_age, container, false);
        initLayout(view);
        return view;
    }

    private void initLayout(View view) {
        mFromPicker = (NumberPicker)view.findViewById(R.id.npFrom);
        mToPicker = (NumberPicker)view.findViewById(R.id.npTo);
        mOKButton = (Button)view.findViewById(R.id.btnOK);

        mFromPicker.setMinValue(Constants.MIN_AGE);
        mFromPicker.setMaxValue(Constants.MAX_AGE);
        mToPicker.setMinValue(Constants.MIN_AGE);
        mToPicker.setMaxValue(Constants.MAX_AGE);

        mOKButton.setOnClickListener(this);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getDialog().setTitle(getString(R.string.age));
    }

    @Override
    public void onClick(View v) {
        JobCriteria.getInst().setMinAge(mFromPicker.getValue());
        JobCriteria.getInst().setMaxAge(mToPicker.getValue());
        this.dismiss();
    }
}
