package vn.edu.techkids.mahr.fragment.JobCriteriaEditFragments;

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
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import vn.edu.techkids.mahr.R;
import vn.edu.techkids.mahr.enitity.Expertise;
import vn.edu.techkids.mahr.enitity.JobCriteria;

/**
 * Created by qhuydtvt on 3/7/2016.
 */
public class ExpertiseEditFragment extends DialogFragment implements View.OnClickListener{

    private ListView mListView;
    private Button mBtnOK;
    private List<Expertise> mExpertiseArrayList;

    public ExpertiseEditFragment() {
        this.mExpertiseArrayList = JobCriteria.getInst().getExpertiseList();
    }

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

        DoubleExpertiseEditAdapter doubleExpertiseEditAdapter = new DoubleExpertiseEditAdapter();
        doubleExpertiseEditAdapter.setLayoutInflater(this.getActivity().getLayoutInflater());
        mListView.setAdapter(doubleExpertiseEditAdapter);

//        mListView.setAdapter(new BaseAdapter()
//
//        {
//
//            @Override
//            public int getCount() {
//                if(mExpertiseArrayList == null) return 0;
//                return mExpertiseArrayList.size();
//            }
//
//            @Override
//            public Object getItem(int position) {
//                if(mExpertiseArrayList == null) return null;
//                return mExpertiseArrayList.get(position);
//            }
//
//            @Override
//            public long getItemId(int position) {
//                return position;
//            }
//
//            @Override
//            public View getView(int position, View convertView, ViewGroup parent) {
//                final Expertise expertise = mExpertiseArrayList.get(position);
//                TextView txvExpertise = null;
//                CheckBox chbSelect = null;
//
//                if (convertView == null) {
//                    convertView = getActivity().getLayoutInflater().inflate(
//                            R.layout.list_item_multi_choice, parent, false);
//                }
//                txvExpertise = (TextView) convertView.findViewById(R.id.txvTitle);
//                chbSelect = (CheckBox)convertView.findViewById(R.id.chbSelect);
//                chbSelect.setChecked(expertise.getSelected());
//                chbSelect.setTag(expertise);
//
//
//                chbSelect.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        CheckBox chb = (CheckBox) v;
//                        if (chb != null) {
//                            Expertise expt = (Expertise) chb.getTag();
//                            if (expt != null) {
//                                expt.setSelected(chb.isChecked());
//                                if(expt.getSelected()) {
//                                    Log.d("getView", "Checked");
//                                }
//                            }
//                        }
//                    }
//                });
//
//                txvExpertise.setText(expertise.getName());
//                return convertView;
//            }
//        });

        mBtnOK.setOnClickListener(this);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        getDialog().setTitle(getString(R.string.expertise));
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onClick(View v) {
        JobCriteria.getInst().notifyListener();
        this.dismiss();
    }

    private class DoubleExpertiseEditAdapter extends BaseAdapter implements View.OnClickListener{

        private List<DoubleExpertise> mDoubleExpertiseList;
        private LayoutInflater mLayoutInflater;

        public DoubleExpertiseEditAdapter() {
            mDoubleExpertiseList = new ArrayList<>();
            List<Expertise> expertiseList = JobCriteria.getInst().getExpertiseList();
            int size = expertiseList.size();
            for(int i = 0; i < size; i+=2) {
                Expertise expertise1 = expertiseList.get(i);
                Expertise expertise2 = null;
                if (i + 1 < size) {
                    expertise2 = expertiseList.get(i + 1);
                }
                mDoubleExpertiseList.add(new DoubleExpertise(expertise1, expertise2));
            }
        }

        public void setLayoutInflater(LayoutInflater mLayoutInflater) {
            this.mLayoutInflater = mLayoutInflater;
        }

        @Override
        public int getCount() {
            return mDoubleExpertiseList.size();
        }

        @Override
        public Object getItem(int position) {
            return mDoubleExpertiseList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            DoubleExpertise doubleExpertise = mDoubleExpertiseList.get(position);

            if(convertView == null) {
                convertView = mLayoutInflater.inflate(R.layout.list_item_expertise_double,
                        parent, false);
            }

            TextView tvExpertise1Title = (TextView)convertView.findViewById(R.id.tv_expertise1_title);
            TextView tvExpertise2Title = (TextView)convertView.findViewById(R.id.tv_expertise2_title);

            CheckBox chbExpertise1Select = (CheckBox)convertView.findViewById(R.id.chb_expertise1_select);
            CheckBox chbExpertise2Select = (CheckBox)convertView.findViewById(R.id.chb_expertise2_select);

            Expertise expertise1 = doubleExpertise.expertise1;
            Expertise expertise2 = doubleExpertise.expertise2;

            fillExpertiseView(expertise1, tvExpertise1Title, chbExpertise1Select);
            fillExpertiseView(expertise2, tvExpertise2Title, chbExpertise2Select);

//            if(expertise1 != null) {
//                tvExpertise1Title.setText(expertise1.getName());
//            }
//            else {
//                tvExpertise1Title.setVisibility(View.INVISIBLE);
//                chbExpertise1Select.setVisibility(View.INVISIBLE);
//            }
//
//            if(expertise2 != null) {
//                tvExpertise2Title.setText(expertise2.getName());
//            }
//            else {
//                tvExpertise2Title.setVisibility(View.INVISIBLE);
//                chbExpertise2Select.setVisibility(View.INVISIBLE);
//            }

            return convertView;
        }

        private void fillExpertiseView(Expertise expertise, TextView textView, CheckBox checkBox) {
            if(expertise != null) {
                textView.setText(expertise.getName());
                checkBox.setChecked(expertise.getSelected());
                checkBox.setTag(expertise);
                checkBox.setOnClickListener(this);
            }
            else {
                textView.setVisibility(View.INVISIBLE);
                checkBox.setVisibility(View.INVISIBLE);
            }
        }

        @Override
        public void onClick(View v) {
            CheckBox chb = (CheckBox) v;
            if (chb != null) {
                Expertise expertise = (Expertise) chb.getTag();
                if (expertise != null) {
                    expertise.setSelected(chb.isChecked());
                    if (expertise.getSelected()) {
                        Log.d("getView", "Checked");
                    }
                }
            }
        }
    }

    private class DoubleExpertise {
        private Expertise expertise1;
        private Expertise expertise2;

        public DoubleExpertise(Expertise expertise1, Expertise expertise2) {
            this.expertise1 = expertise1;
            this.expertise2 = expertise2;
        }
    }
}
