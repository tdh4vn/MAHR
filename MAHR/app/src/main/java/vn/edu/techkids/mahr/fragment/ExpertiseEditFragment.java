package vn.edu.techkids.mahr.fragment;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import vn.edu.techkids.mahr.R;
import vn.edu.techkids.mahr.enitity.Expertise;
import vn.edu.techkids.mahr.enitity.JobCriteria;

/**
 * Created by qhuydtvt on 3/7/2016.
 */
public class ExpertiseEditFragment extends DialogFragment implements View.OnClickListener{

    private ListView mListView;
    private Button mBtnOK;
    private ArrayList<Expertise> mExpertiseArrayList;

    public ExpertiseEditFragment() {
        this.mExpertiseArrayList = JobCriteria.getInst().getExpertiseArrayList();
    }

    /*private final int[] mItems = new int[]{
            R.string.cnc,
            R.string.textile,
            R.string.mechanic,
            R.string.woodwork,
            R.string.electronics,
            R.string.food
    };*/

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit_expertise, container, false);
        initLayout(view);
        return view;
    }

    private void initLayout(View view) {
        mListView = (ListView)view.findViewById(R.id.ltv);
        mBtnOK = (Button)view.findViewById(R.id.btnOK);

        mListView.setAdapter(new BaseAdapter() {

            @Override
            public int getCount() {
                return mExpertiseArrayList.size();
            }

            @Override
            public Object getItem(int position) {
                return mExpertiseArrayList.get(position);
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                final Expertise expertise = mExpertiseArrayList.get(position);
                TextView txvExpertise = null;
                CheckBox chbSelect = null;

                if (convertView == null) {
                    convertView = getActivity().getLayoutInflater().inflate(
                            R.layout.list_item_multi_choice, parent, false);
                }
                txvExpertise = (TextView) convertView.findViewById(R.id.txvTitle);
                chbSelect = (CheckBox)convertView.findViewById(R.id.chbSelect);
                chbSelect.setChecked(expertise.getSelected());
                chbSelect.setTag(expertise);


                chbSelect.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        CheckBox chb = (CheckBox) v;
                        if (chb != null) {
                            Expertise expt = (Expertise) chb.getTag();
                            if (expt != null) {
                                expt.setSelected(chb.isChecked());
                                if(expt.getSelected()) {
                                    Log.d("getView", "Checked");
                                }
                            }
                        }
                    }
                });

                txvExpertise.setText(expertise.getName());
                return convertView;
            }
        });

        mBtnOK.setOnClickListener(this);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        getDialog().setTitle(getString(R.string.expertise));
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onClick(View v) {
        this.dismiss();
    }

/*
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        JobCriteria.getInst().setExpertise(mExpertiseArrayList.get(position).getid());
        this.dismiss();
    }*/
}
