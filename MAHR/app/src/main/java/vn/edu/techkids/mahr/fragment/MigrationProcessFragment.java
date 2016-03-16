package vn.edu.techkids.mahr.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vn.edu.techkids.mahr.R;
import vn.edu.techkids.mahr.enitity.MigrationProgress;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MigrationProcessFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MigrationProcessFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MigrationProcessFragment extends BaseFragment {

    CardView cardPassport;
    CardView cardLegal;
    CardView cardHeath;
    CardView cardFile;
    CardView cardOffice;
    CardView cardVisa;
    CardView cardFlight;
    CardView cardFinish;

    private MigrationProgress mMigrationProgress;

    public void setMigrationProgress(MigrationProgress migrationProgress) {
        this.mMigrationProgress = migrationProgress;
    }

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private void connectView(View view){
        cardPassport = (CardView) view.findViewById(R.id.cardPassport);
        cardLegal = (CardView) view.findViewById(R.id.cardLegal);
        cardHeath = (CardView) view.findViewById(R.id.cardHealth);
        cardFile = (CardView) view.findViewById(R.id.cardFile);
        cardOffice = (CardView) view.findViewById(R.id.cardOffice);
        cardVisa = (CardView) view.findViewById(R.id.cardVisa);
        cardFlight = (CardView) view.findViewById(R.id.cardFlight);
        cardFinish = (CardView) view.findViewById(R.id.cardFinish);
    }

    private OnFragmentInteractionListener mListener;

    public MigrationProcessFragment() {
        // Required empty public constructor
    }

    public static MigrationProcessFragment newInstance(String param1, String param2) {
        MigrationProcessFragment fragment = new MigrationProcessFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_migration_process, container, false);
        connectView(view);
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
