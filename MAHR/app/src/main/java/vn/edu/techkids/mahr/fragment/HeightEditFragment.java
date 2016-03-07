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
public class HeightEditFragment extends InRangeEditFragment {

    @Override
    protected void initLayout(View view) {
        super.initLayout(view);
        setRange(Constants.MIN_HEIGHT, Constants.MAX_HEIGHT);
    }

    @Override
    public void onClick(View v) {
        JobCriteria.getInst().setMinHeight(mFromPicker.getValue());
        JobCriteria.getInst().setMaxHeight(mToPicker.getValue());
        super.onClick(v);
    }
}
