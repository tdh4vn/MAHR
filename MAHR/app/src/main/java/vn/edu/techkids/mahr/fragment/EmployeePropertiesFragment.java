package vn.edu.techkids.mahr.fragment;


import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.zip.Inflater;

import vn.edu.techkids.mahr.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class EmployeePropertiesFragment extends Fragment {

    private ListView mEmployeeProperitesListView;
    private String[] mEmployeeProperites;

    private LayoutInflater mLayoutInflater;

    public EmployeePropertiesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vRet =  inflater.inflate(R.layout.fragment_employee_properties, container, false);
        getIntances(vRet);
        setupView();
        return vRet;
    }

    private void getIntances(View vLayoutRoot) {
        mEmployeeProperitesListView = (ListView)vLayoutRoot.
                findViewById(R.id.ltvEmployeePropetiesList);
        mEmployeeProperites = getResources().getStringArray(R.array.employee_property_names);
        mLayoutInflater = getActivity().getLayoutInflater();
    }

    private void setupView() {
        mEmployeeProperitesListView.setAdapter(new BaseAdapter() {

            @Override
            public int getCount() {
                return mEmployeeProperites.length;
            }

            @Override
            public Object getItem(int position) {
                return mEmployeeProperites[position];
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if(convertView == null) {
                    convertView = mLayoutInflater.inflate(R.layout.list_item_employee_property,
                            parent, false);
                }

                TextView txvEmployeeProperty = (TextView)convertView.findViewById (
                        R.id.txv_employee_property);

                txvEmployeeProperty.setText(mEmployeeProperites[position]);

                return convertView;
            }
        });
    }
}
