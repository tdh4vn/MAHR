package vn.edu.techkids.mahr.fragment.MigrationProgressFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import vn.edu.techkids.mahr.R;
import vn.edu.techkids.mahr.fragment.BaseDialogFragment;
import vn.edu.techkids.mahr.fragment.BaseFragment;

/**
 * Created by hungtran on 3/18/16.
 */
public class EditProfilesFragment extends BaseDialogFragment implements View.OnClickListener {
    String mTitle;
    TextView txtDepartment;
    TextView txtCompany;
    TextView txtFactory;
    Button btnOK;
    public EditProfilesFragment() {

    }
    private void connectView(View view){
        txtDepartment = (TextView) view.findViewById(R.id.txt_department);
        txtCompany = (TextView) view.findViewById(R.id.txt_company);
        txtFactory = (TextView) view.findViewById(R.id.txt_factory);
        btnOK = (Button) view.findViewById(R.id.btn_fragment_profile_edit_OK);
        btnOK.setOnClickListener(this);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_migration_change_profiles, container, false);
        if(mTitle != null) {
            getDialog().setTitle(mTitle);
        }
        connectView(view);
        return view;
    }


    public EditProfilesFragment setTitle(String title) {
        this.mTitle = title;
        return this;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_fragment_profile_edit_OK:
                this.dismiss();
                break;
        }

    }
}
