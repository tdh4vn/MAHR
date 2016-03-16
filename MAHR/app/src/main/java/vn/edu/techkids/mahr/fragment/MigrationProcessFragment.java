package vn.edu.techkids.mahr.fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.InputStream;

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
    ImageView avatar;

    CheckBox imageDone;
    CheckBox imageDoneTuPhap;
    CheckBox imageDoneKhamSK;
    CheckBox imageDoneNhanGT;
    CheckBox imageDoneTrinhCuc;
    CheckBox imageDoneVisa;
    CheckBox imageDoneDuKienBay;
    CheckBox imageDoneKetThuc;

    TextView txtS5Name;
    TextView txtS5ID;
    TextView txtS5Bone;
    TextView txtS5Branch;
    TextView txtS5Company;

    TextView textViewHoChieu;
    TextView textViewTuPhap;
    TextView textViewKhamSK;
    TextView textViewNhanGT;
    TextView textViewTrinhCuc;
    TextView textViewVisa;
    TextView textViewTuPhapDuKienBay;
    TextView textViewKetThuc;

    TextView textViewTimeHoChieu;
    TextView textViewTimeTuPhap;
    TextView textViewTimeKhamSK;
    TextView textViewTimeNhanGT;
    TextView textViewTimeTrinhCuc;
    TextView textViewTimeVisa;

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
        avatar = (ImageView) view.findViewById(R.id.imageViewScreen5);
        cardPassport = (CardView) view.findViewById(R.id.cardPassport);
        cardLegal = (CardView) view.findViewById(R.id.cardLegal);
        cardHeath = (CardView) view.findViewById(R.id.cardHealth);
        cardFile = (CardView) view.findViewById(R.id.cardFile);
        cardOffice = (CardView) view.findViewById(R.id.cardOffice);
        cardVisa = (CardView) view.findViewById(R.id.cardVisa);
        cardFlight = (CardView) view.findViewById(R.id.cardFlight);
        cardFinish = (CardView) view.findViewById(R.id.cardFinish);

        imageDone = (CheckBox) view.findViewById(R.id.imageDone);
        imageDoneTuPhap = (CheckBox) view.findViewById(R.id.imageDoneTuPhap);
        imageDoneKhamSK = (CheckBox) view.findViewById(R.id.imageDoneKhamSK);
        imageDoneNhanGT = (CheckBox) view.findViewById(R.id.imageDoneNhanGT);
        imageDoneTrinhCuc = (CheckBox) view.findViewById(R.id.imageDoneTrinhCuc);
        imageDoneVisa = (CheckBox) view.findViewById(R.id.imageDoneVisa);
        imageDoneDuKienBay = (CheckBox) view.findViewById(R.id.imageDoneDuKienBay);
        imageDoneKetThuc = (CheckBox) view.findViewById(R.id.imageDoneKetThuc);

        txtS5Name = (TextView) view.findViewById(R.id.txtS5Name);
        txtS5ID = (TextView) view.findViewById(R.id.txtS5ID);
        txtS5Bone = (TextView) view.findViewById(R.id.txtS5Bone);
        txtS5Branch = (TextView) view.findViewById(R.id.txtS5Branch);
        txtS5Company = (TextView) view.findViewById(R.id.txtS5Company);

        textViewHoChieu = (TextView) view.findViewById(R.id.textViewHoChieu);
        textViewTuPhap = (TextView) view.findViewById(R.id.textViewTuPhap);
        textViewKhamSK = (TextView) view.findViewById(R.id.textViewKhamSK);
        textViewNhanGT = (TextView) view.findViewById(R.id.textViewNhanGT);
        textViewTrinhCuc = (TextView) view.findViewById(R.id.textViewTrinhCuc);
        textViewVisa = (TextView) view.findViewById(R.id.textViewVisa);
        textViewTuPhapDuKienBay = (TextView) view.findViewById(R.id.textViewTuPhapDuKienBay);
        textViewKetThuc = (TextView) view.findViewById(R.id.textViewKetThuc);


        textViewTimeHoChieu = (TextView) view.findViewById(R.id.textViewTimeHoChieu);
        textViewTimeTuPhap = (TextView) view.findViewById(R.id.textViewTimeTuPhap);
        textViewTimeKhamSK = (TextView) view.findViewById(R.id.textViewTimeKhamSK);
        textViewTimeNhanGT = (TextView) view.findViewById(R.id.textViewTimeNhanGT);
        textViewTimeTrinhCuc = (TextView) view.findViewById(R.id.textViewTimeTrinhCuc);
        textViewTimeVisa= (TextView) view.findViewById(R.id.textViewTimeVisa);
    }

    private void connectData(){
        new DownloadImageTask(avatar).execute(mMigrationProgress.getProfile().getAvatar());

        txtS5Name.setText(getString(R.string.name) + ": " +mMigrationProgress.getProfile().getName());
        txtS5ID.setText(getString(R.string.number_id) + ": " + String.valueOf(mMigrationProgress.getProfileId()));
        txtS5Bone.setText(getString(R.string.bone_name) + ": " +mMigrationProgress.getFactory());
        txtS5Branch.setText(getString(R.string.branch) + ": " +mMigrationProgress.getDepartment());
        txtS5Company.setText(getString(R.string.vietnam_company) + ": " +mMigrationProgress.getCompany());



        textViewTimeHoChieu.setText(getString(R.string.complete) + " " + mMigrationProgress.getPassportEndDate());
        textViewTimeTuPhap.setText(getString(R.string.complete) + " " + mMigrationProgress.getLegalEndDate());
        textViewTimeKhamSK.setText(getString(R.string.complete) + " " + mMigrationProgress.getHealthEndDate());
        textViewTimeNhanGT.setText(getString(R.string.complete) + " " + mMigrationProgress.getFileEndDate());
        textViewTimeTrinhCuc.setText(getString(R.string.office_start) + " " + mMigrationProgress.getOfficeStartDate()
                + " - " + getString(R.string.office_end) + " " + mMigrationProgress.getOfficeEndDate());
        textViewTimeVisa.setText(getString(R.string.visa_start) + " " + mMigrationProgress.getVisaStartDate()
                + " - " + getString(R.string.office_end) + " " + mMigrationProgress.getVisaEndDate());
        textViewTuPhapDuKienBay.setText(getString(R.string.schedule_flight));
        textViewKetThuc.setText(getString(R.string.end));

        textViewHoChieu.setText(getString(R.string.passport));
        textViewTuPhap.setText(getString(R.string.justice));
        textViewKhamSK.setText(getString(R.string.checkup));
        textViewNhanGT.setText(getString(R.string.received_papers));
        textViewTrinhCuc.setText(getString(R.string.work_department));
        textViewVisa.setText(getString(R.string.visa));

//        imageDone.setEnabled(intToBoolean(mMigrationProgress.getPassportStatus()));
//        imageDoneTuPhap.setEnabled(intToBoolean(mMigrationProgress.getLegalStatus()));
//        imageDoneKhamSK.setEnabled(intToBoolean(mMigrationProgress.getHealthStatus()));
//        imageDoneNhanGT.setEnabled(intToBoolean(mMigrationProgress.getFileStatus()));
//        imageDoneTrinhCuc.setEnabled(intToBoolean(mMigrationProgress.getOfficeStatus()));
//        imageDoneVisa.setEnabled(intToBoolean(mMigrationProgress.getVisaStatus()));
//        imageDoneDuKienBay.setEnabled(intToBoolean(mMigrationProgress.getFlightStatus()));
//        imageDoneKetThuc.setEnabled(intToBoolean(mMigrationProgress.getFinish()));
    }

    private boolean intToBoolean(int input){
        return input > 0 ? true : false;
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
        connectData();
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
    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }

}
