package com.example.demo_m14.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo_m14.R;
import com.example.demo_m14.models.PlanetModel;

import java.util.List;

public class PlanetAdapter extends RecyclerView.Adapter<PlanetAdapter.PlanetViewHolder> {

    private List<PlanetModel> data;

    public PlanetAdapter(List<PlanetModel> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public PlanetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_planet,
                        parent,
                        false);
        return new PlanetViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PlanetViewHolder holder, int position) {
        holder.setData(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class PlanetViewHolder extends  RecyclerView.ViewHolder {

        private ImageView imgView;
        private TextView tvName;
        private TextView tvTotalMoon;
        public PlanetViewHolder(@NonNull View itemView) {
            super(itemView);

            imgView = itemView.findViewById(R.id.imgView);
            tvName = itemView.findViewById(R.id.tvName);
            tvTotalMoon = itemView.findViewById(R.id.tvTotalMoon);
        }

        public  void setData(PlanetModel item) {
            imgView.setImageResource(item.getImg());
            tvName.setText(item.getName());
            tvTotalMoon.setText(item.getTotalMoon());
        }
    }
}
