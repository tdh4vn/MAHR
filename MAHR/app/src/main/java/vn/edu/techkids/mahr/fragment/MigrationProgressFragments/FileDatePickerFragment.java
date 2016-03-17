package vn.edu.techkids.mahr.fragment.MigrationProgressFragments;

import android.net.Uri;

import vn.edu.techkids.mahr.constants.Constants;
import vn.edu.techkids.mahr.enitity.MigrationProgress;
import vn.edu.techkids.mahr.fragment.TypeOneMigrationParamFragment;

/**
 * Created by qhuydtvt on 3/17/2016.
 */

public class FileDatePickerFragment extends TypeOneMigrationParamFragment {

    @Override
    protected void fillData() {
        mCheckBoxDone.setChecked(MigrationProgress.getInst().getFileStatus() != 0);
        mEndDateTextView.setText(MigrationProgress.getInst().getFileEndDate());
    }

    @Override
    public String buildQuery() {
        Uri.Builder builder = new Uri.Builder()
                .appendQueryParameter(MigrationProgress.API_MIG_PROG_FILE_STATUS,
                        getCheckedString())
                .appendQueryParameter(MigrationProgress.API_MIG_PROG_FILE_END_DATE,
                        getEndDateString());
        String query = builder.build().getEncodedQuery();
        return query;
    }
}
