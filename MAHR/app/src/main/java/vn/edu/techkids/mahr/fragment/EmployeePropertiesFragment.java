package vn.edu.techkids.mahr.fragment;


import android.app.DialogFragment;
import android.os.Bundle;
import android.app.Fragment;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import vn.edu.techkids.mahr.R;
import vn.edu.techkids.mahr.enitity.JobCriteria;
import vn.edu.techkids.mahr.enitity.JobCriteriaListener;
import vn.edu.techkids.mahr.enitity.JobCriteriaViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class EmployeePropertiesFragment extends BaseFragment implements
        AdapterView.OnItemClickListener {
    private FloatingActionButton floatingActionButton;
    private ListView mEmployeeProperitesListView;
    private JobCriteria mJobCriteria;

    //private String[] mEmployeeProperites;

    private LayoutInflater mLayoutInflater;

    private ArrayList<JobCriteriaViewModel> mJobPropertyList;

    public EmployeePropertiesFragment() {
        // Required empty public constructor
        mJobCriteria = JobCriteria.getInst();
        mJobPropertyList = new ArrayList<JobCriteriaViewModel>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vRet =  inflater.inflate(R.layout.fragment_employee_properties, container, false);
        initData();
        getIntances(vRet);
        setupView();
        floatingActionButton = (FloatingActionButton) vRet.findViewById(R.id.fbFilter);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getScreenManager().openFragment(new ItemFragment(), true);
            }
        });
        return vRet;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onStart() {
        getScreenManager().showActionBar();
        super.onStart();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return true;

    }
    private void getIntances(View vLayoutRoot) {
        mEmployeeProperitesListView = (ListView)vLayoutRoot.
                findViewById(R.id.ltvEmployeePropetiesList);
        //mEmployeeProperites = getResources().getStringArray(R.array.employee_property_names);
        mLayoutInflater = getActivity().getLayoutInflater();
    }

    private void initData() {
        mJobPropertyList.clear();
        mJobPropertyList.add(new JobCriteriaViewModel(R.string.expertise, R.drawable.ic_build_black_24dp, JobCriteria.EXPERTISE));
        mJobPropertyList.add(new JobCriteriaViewModel(R.string.age, R.drawable.ic_person_black_24dp,JobCriteria.AGE));
        mJobPropertyList.add(new JobCriteriaViewModel(R.string.height, R.drawable.ic_swap_vert_black_24dp, JobCriteria.HEIGHT));
        mJobPropertyList.add(new JobCriteriaViewModel(R.string.weight, R.drawable.ic_view_module_black_24dp, JobCriteria.WEIGHT));
        mJobPropertyList.add(new JobCriteriaViewModel(R.string.language, R.drawable.ic_font_download_black_24dp, JobCriteria.LANG));
        mJobPropertyList.add(new JobCriteriaViewModel(R.string.experience, R.drawable.ic_power_black_24dp, JobCriteria.EXP));
        mJobPropertyList.add(new JobCriteriaViewModel(R.string.degree, R.drawable.ic_group_work_black_24dp, JobCriteria.DEGREE));
    }

    private void setupView() {
        JobCriteriaAdapter jobCriteriaAdapter = new JobCriteriaAdapter();
        mJobCriteria.setJobCriteriaListener(jobCriteriaAdapter);
        mEmployeeProperitesListView.setAdapter(jobCriteriaAdapter);
        mEmployeeProperitesListView.setOnItemClickListener(this);
    }

    private String getStringFromCriteria(int criteria) {
        switch (criteria) {
            case JobCriteria.EXPERTISE:
                if (mJobCriteria.getExpertise() == -1) return null;
                return getString(mJobCriteria.getExpertise());
            case JobCriteria.AGE:
                return mJobCriteria.getAgeRange();
            case JobCriteria.HEIGHT:
                return mJobCriteria.getHeightRange();
            case JobCriteria.WEIGHT:
                return mJobCriteria.getWeightRange();
            case JobCriteria.LANG:
                if (mJobCriteria.getLanguage() == -1) return null;
                return getString(mJobCriteria.getLanguage());
            case JobCriteria.EXP:
                return mJobCriteria.getExpRange();
            case JobCriteria.DEGREE:
                if (mJobCriteria.getDegree() == -1) return null;
                return getString(mJobCriteria.getDegree());
        }
        return null;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.d("onItemClick", "onItemClick");
        JobCriteriaViewModel jobProperty = mJobPropertyList.get(position);
        DialogFragment dialogFragment = null;
        switch (jobProperty.getPropertyNameId()) {
            case R.string.expertise:
                dialogFragment = new ExpertiseEditFragment();
                break;
            case R.string.age:
                dialogFragment = new AgeEditFragment();
                break;
            case R.string.height:
                dialogFragment = new HeightEditFragment();
                break;
            case R.string.weight:
                dialogFragment = new WeightEditFragment();
                break;
            case R.string.language:
                dialogFragment = new LanguageEditFragment();
                break;
            case R.string.experience:
                dialogFragment = new ExperienceEditFragment();
                break;
            case R.string.degree:
                dialogFragment = new DegreeEditFragment();
                break;
            default:
                break;
        }

        if(dialogFragment != null) {
            getScreenManager().showDialogFragment(dialogFragment, "");
        }
    }

    private class JobCriteriaAdapter extends BaseAdapter implements JobCriteriaListener {

        @Override
        public int getCount() {
            return mJobPropertyList.size();
        }

        @Override
        public Object getItem(int position) {
            return mJobPropertyList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            JobCriteriaViewModel jobProperty = mJobPropertyList.get(position);
            if(convertView == null) {
                convertView = mLayoutInflater.inflate(R.layout.list_item_employee_property,
                        parent, false);
            }

            TextView txvEmployeeProperty = (TextView)convertView.findViewById (
                    R.id.txv_employee_property);
            ImageView imvJobProperty = (ImageView)convertView.findViewById(
                    R.id.imv_employee_property);
            TextView txtDetailForFilter = (TextView)convertView.findViewById(
                    R.id.txtFilerOfType);
            txvEmployeeProperty.setText(getString(jobProperty.getPropertyNameId()));
            imvJobProperty.setImageResource(jobProperty.getImageId());

                /*txtDetailForFilter.setText("Default");*/

            String selectedValue = getStringFromCriteria(jobProperty.getCriteria());
            if(selectedValue == null || selectedValue.isEmpty()) {
                txtDetailForFilter.setText(getString(R.string.default_type_filter));
            } else {
                txtDetailForFilter.setText(selectedValue);
            }

            return convertView;
        }

        @Override
        public void onJobCriteriaChange() {
            Log.d("onJobCriteriaChange","onJobCriteriaChange");
            notifyDataSetChanged();
        }
    }
}

