package vn.edu.techkids.mahr.fragment;


import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.zip.Inflater;

import vn.edu.techkids.mahr.R;
import vn.edu.techkids.mahr.enitity.JobProperty;

/**
 * A simple {@link Fragment} subclass.
 */
public class EmployeePropertiesFragment extends BaseFragment {

    private ListView mEmployeeProperitesListView;
    //private String[] mEmployeeProperites;

    private LayoutInflater mLayoutInflater;

    private ArrayList<JobProperty> mJobPropertyList;

    public EmployeePropertiesFragment() {
        // Required empty public constructor
        mJobPropertyList = new ArrayList<JobProperty>();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vRet =  inflater.inflate(R.layout.fragment_employee_properties, container, false);
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
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // TODO Add your menu entries here

//        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_list_jobs, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.action_filter:
                Log.e("LOGEEEE", "FFASDSADASD");
                getScreenManager().openFragment(new ItemFragment(),true);
//                break;
//        }
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
        mJobPropertyList.add(new JobProperty(getString(R.string.expertise), R.drawable.ic_build_black_24dp));
        mJobPropertyList.add(new JobProperty(getString(R.string.age), R.drawable.ic_person_black_24dp));
        mJobPropertyList.add(new JobProperty(getString(R.string.height), R.drawable.ic_swap_vert_black_24dp));
        mJobPropertyList.add(new JobProperty(getString(R.string.weight), R.drawable.ic_view_module_black_24dp));
        mJobPropertyList.add(new JobProperty(getString(R.string.language), R.drawable.ic_font_download_black_24dp));
        mJobPropertyList.add(new JobProperty(getString(R.string.experience), R.drawable.ic_power_black_24dp));
        mJobPropertyList.add(new JobProperty(getString(R.string.degree), R.drawable.ic_group_work_black_24dp));
    }

    private void setupView() {
        mEmployeeProperitesListView.setAdapter(new BaseAdapter() {

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
                JobProperty jobProperty = mJobPropertyList.get(position);
                if(convertView == null) {
                    convertView = mLayoutInflater.inflate(R.layout.list_item_employee_property,
                            parent, false);
                }

                TextView txvEmployeeProperty = (TextView)convertView.findViewById (
                        R.id.txv_employee_property);
                ImageView imvJobProperty = (ImageView)convertView.findViewById(
                        R.id.imv_employee_property);
                txvEmployeeProperty.setText(jobProperty.getPropertyName());
                imvJobProperty.setImageResource(jobProperty.getImageId());

                return convertView;
            }
        });
    }
}

