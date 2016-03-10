package vn.edu.techkids.mahr.fragment;


import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.content.Context;
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

import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import vn.edu.techkids.mahr.R;
import vn.edu.techkids.mahr.constants.Constants;
import vn.edu.techkids.mahr.enitity.DownloadJSONTask;
import vn.edu.techkids.mahr.enitity.Expertise;
import vn.edu.techkids.mahr.enitity.ExpertiseJSONPostDownloadHandler;
import vn.edu.techkids.mahr.enitity.JSONPostDownloadHandler;
import vn.edu.techkids.mahr.enitity.JSONPreDownloadHandler;
import vn.edu.techkids.mahr.enitity.JobCriteria;
import vn.edu.techkids.mahr.enitity.JobCriteriaListener;
import vn.edu.techkids.mahr.enitity.JobCriteriaViewModel;
import vn.edu.techkids.mahr.enitity.Worker;

/**
 * A simple {@link Fragment} subclass.
 */
public class JobCriteriaFragment extends BaseFragment implements
        AdapterView.OnItemClickListener, JSONPreDownloadHandler, JSONPostDownloadHandler {
    private FloatingActionButton floatingActionButton;
    private ListView mEmployeeProperitesListView;
    private JobCriteria mJobCriteria;

    private ArrayList<Expertise> expertiseArrayList;

    //private String[] mEmployeeProperites;

    private LayoutInflater mLayoutInflater;

    private ArrayList<JobCriteriaViewModel> mJobPropertyList;

    private final String DOWNLOAD_TAG_EXPERTISE = "expertise";
    private final String DOWNLOAD_TAG_WORKER = "worker";
    private boolean mDownloadExpertisePending = false;

    private ProgressDialog progress;

    public JobCriteriaFragment() {
        // Required empty public constructor
        mJobCriteria = JobCriteria.getInst();
        mJobPropertyList = new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vRet =  inflater.inflate(R.layout.fragment_job_criteria, container, false);
        initData();
        getIntances(vRet);
        setupView();

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
        mLayoutInflater = getActivity().getLayoutInflater();
        floatingActionButton = (FloatingActionButton) vLayoutRoot.findViewById(R.id.fbFilter);
    }

    private void initData() {
        expertiseArrayList = JobCriteria.getInst().getExpertiseArrayList();

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

        floatingActionButton.setOnClickListener(new FloatingActionClickListener(this, this));
    }

    private class FloatingActionClickListener implements View.OnClickListener {

        private JSONPreDownloadHandler jsonPreDownloadHandler;
        private JSONPostDownloadHandler jsonPostDownloadHandler;

        public FloatingActionClickListener(JSONPreDownloadHandler preDownloadHandler,
                                           JSONPostDownloadHandler postDownloadHandler) {
            this.jsonPreDownloadHandler = preDownloadHandler;
            this.jsonPostDownloadHandler = postDownloadHandler;
        }

        @Override
        public void onClick(View v) {
            try {
                Log.d("floatingActionButton", JobCriteria.getInst().getAPIString());
                DownloadJSONTask downloadJSONTask = new DownloadJSONTask(jsonPreDownloadHandler,
                        jsonPostDownloadHandler, DOWNLOAD_TAG_WORKER);
                downloadJSONTask.execute(new URL(JobCriteria.getInst().getAPIString()));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
    }

    private String getStringFromCriteria(int criteria) {
        switch (criteria) {
            case JobCriteria.EXPERTISE:
                return mJobCriteria.getExpertiseString();
            case JobCriteria.AGE:
                return mJobCriteria.getAgeRange();
            case JobCriteria.HEIGHT:
                return mJobCriteria.getHeightRange();
            case JobCriteria.WEIGHT:
                return mJobCriteria.getWeightRange();
            case JobCriteria.LANG:
                /*if (mJobCriteria.getLanguage() == -1) return null;
                return getString(mJobCriteria.getLanguage());*/
                return mJobCriteria.getLangString();
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
        mDownloadExpertisePending = false;
        switch (jobProperty.getPropertyNameId()) {
            case R.string.expertise:
                if(JobCriteria.getInst().getExpertiseArrayList() == null) {
                    try {
                        mDownloadExpertisePending = true;
                        new DownloadJSONTask(this, this, DOWNLOAD_TAG_EXPERTISE).execute(new URL(Constants.API_URL_EXPERTISE));
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    dialogFragment = new ExpertiseEditFragment();
                }
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

    @Override
    public void onPreDownload(String tag) {
        switch (tag) {
            case DOWNLOAD_TAG_WORKER:
                progress = ProgressDialog.show(this.getActivity(), getString(R.string.worker),
                    getString(R.string.loading), true);
                break;
            case DOWNLOAD_TAG_EXPERTISE:
                progress = ProgressDialog.show(this.getActivity(), getString(R.string.expertise),
                        getString(R.string.loading), true);
                break;
        }
    }

    @Override
    public void onPostDownload(JSONObject jsonObject, String tag) {
        switch (tag) {
            case DOWNLOAD_TAG_WORKER:
                /* Parse JSON to WorkerList */
                if (jsonObject == null) {
                    showToastMessage(getString(R.string.message_download_worker_failed));
                } else {
            /* Log.d("onPostDownload", jsonObject.toString()); */
                    Worker.loadJsonToList(jsonObject);


            /* Change screen */
                    getScreenManager().openFragment(new WorkerListFragment(), true);
                }
                if (progress != null) {
                    progress.dismiss();
                }
                break;
            case DOWNLOAD_TAG_EXPERTISE:
                if (progress != null) {
                    progress.dismiss();
                }
                if(jsonObject == null) {
                    showToastMessage(getString(R.string.message_download_expertise_failed));
                }
                else {
                    JobCriteria.getInst().loadExperiseArrayList(jsonObject);
                    DialogFragment dialogFragment = new ExpertiseEditFragment();
                    getScreenManager().showDialogFragment(dialogFragment, "");
                }
                break;
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