package com.example.tibur.bicyclecontentprovider.bicycle;

import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.util.ColorGenerator;
import com.example.tibur.bicyclecontentprovider.R;
import com.example.tibur.bicyclecontentprovider.bicycle.data.BicycleContract;

public class BicycleRecyclerViewAdapter extends RecyclerView.Adapter<BicycleRecyclerViewAdapter.ViewHolder> {

    Cursor cursor;

    public void setCursor(Cursor cursor) {
        this.cursor = cursor;
    }

    public BicycleRecyclerViewAdapter() {
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_bicycle, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        cursor.moveToPosition(position);
        String model = cursor.getString(cursor.getColumnIndex(BicycleContract.MODEL));
        holder.mModel.setText(model);
        holder.mYear.setText(cursor.getString(cursor.getColumnIndex(BicycleContract.YEAR)));

        ColorGenerator generator = ColorGenerator.MATERIAL;
        TextDrawable drawable = TextDrawable.builder().buildRound(
                model.substring(0,1),
                generator.getColor(model));

        holder.mImageView.setImageDrawable(drawable);
    }

    @Override
    public int getItemCount() {
        if(cursor == null) return 0;
        return cursor.getCount();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mModel;
        public final TextView mYear;
        public final ImageView mImageView;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mModel = view.findViewById(R.id.textViewModel);
            mYear = view.findViewById(R.id.textViewYear);
            mImageView = view.findViewById(R.id.imageView);
        }
    }
}
