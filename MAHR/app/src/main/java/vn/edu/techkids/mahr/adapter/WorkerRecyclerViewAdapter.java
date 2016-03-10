package vn.edu.techkids.mahr.adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import vn.edu.techkids.mahr.R;
import vn.edu.techkids.mahr.enitity.Worker;
import vn.edu.techkids.mahr.fragment.WorkerListFragment.OnListFragmentInteractionListener;

import java.io.InputStream;
import java.util.ArrayList;

public class WorkerRecyclerViewAdapter extends RecyclerView.Adapter<WorkerRecyclerViewAdapter.ViewHolder> {

    /*private final List<Person> mValues;*/
    private final OnListFragmentInteractionListener mListener;
    private ArrayList<Worker> mWorkerArrayList;

    public WorkerRecyclerViewAdapter(/*List<Person> items, */OnListFragmentInteractionListener listener) {
        /*mValues = items;*/
        mListener = listener;
        mWorkerArrayList = Worker.getWorkerArrayList();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Worker worker = mWorkerArrayList.get(position);

        holder.txtName.setText(worker.getName());
        holder.txtAge.setText(String.valueOf(worker.getAge()));
        holder.txtExpersion.setText(worker.getExpertiseString());
        new DownloadImageTask(holder.imgViewPersonPhoto).execute(worker.getAvatar());

        /*
        holder.txtName.setText(worker.getName());
        holder.txtAge.setText(worker.getAge());
        holder.txtExpersion.setText(worker.getCode());*/

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    //mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mWorkerArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView txtName;
        TextView txtAge;
        TextView txtExpersion;
        ImageView imgViewPersonPhoto;

        public ViewHolder(View view) {
            super(view);
            cv = (CardView)view.findViewById(R.id.cv);
            txtName = (TextView) view.findViewById(R.id.person_name);
            txtAge = (TextView) view.findViewById(R.id.person_age);
            txtExpersion = (TextView) view.findViewById(R.id.person_expersion);
            (imgViewPersonPhoto) = (ImageView) view.findViewById(R.id.person_photo);
        }

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