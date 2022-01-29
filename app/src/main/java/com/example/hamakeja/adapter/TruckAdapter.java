package com.example.hamakeja.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.hamakeja.R;
import com.example.hamakeja.model.Truck;

import java.util.List;

public class TruckAdapter extends RecyclerView.Adapter<TruckAdapter.ViewHolder> {
    private Context mContext;
    private List<Truck> mTruckList;


    public TruckAdapter(Context context, List<Truck> truckList) {
        mContext = context;
        mTruckList = truckList;

    }



    @NonNull
    @Override
    public TruckAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.truck_card, parent, false);
        return new ViewHolder(view);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView truckNumber;
        private TextView parkedLocation;
        private ImageView imageName;
        private TextView overallSize;
        private TextView carryingCapacity;
        private CardView cardView;
        private ImageView callButton;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            truckNumber = itemView.findViewById(R.id.truck_Number);
            parkedLocation = itemView.findViewById(R.id.parked_Location);
            imageName = itemView.findViewById(R.id.truck_Image);
            overallSize = itemView.findViewById(R.id.overall_Size);
            carryingCapacity = itemView.findViewById(R.id.carrying_Capacity);
            cardView = itemView.findViewById(R.id.truck_card);
            callButton = itemView.findViewById(R.id.call);

        }
    }
    @Override
    public void onBindViewHolder(@NonNull TruckAdapter.ViewHolder holder, int position) {
        final Truck currentTruck = mTruckList.get(position);

        holder.truckNumber.setText(currentTruck.getTruckNumber());
        holder.parkedLocation.setText(currentTruck.getParkedLocation());
        holder.overallSize.setText(currentTruck.getOverallSize());
        if (currentTruck.getImageName() == null) {
            holder.imageName.setVisibility(View.GONE);
        } else{
            holder.imageName.setVisibility(View.VISIBLE);
            Glide.with(mContext.getApplicationContext())
                    .load(currentTruck.getImageName())
                    .into(holder.imageName);
        }
        holder.carryingCapacity.setText(currentTruck.getCarryingCapacity());
        holder.callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callOwner(currentTruck);
            }
        });
        
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewTruck(currentTruck);
            }
        });
    }

    private void viewTruck(Truck currentTruck) {
    }

    private void callOwner(Truck currentTruck) {

    }
    public void clearAll(){
        mTruckList.clear();
        notifyDataSetChanged();
    }

    public void addAll(List<Truck> truckList) {
        mTruckList.clear();
        mTruckList.addAll(truckList);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mTruckList.size();
    }

}
