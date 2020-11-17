package com.example.fatmancosmetic.Adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fatmancosmetic.Info.AmazingFatManInfo;
import com.example.fatmancosmetic.R;

import java.util.ArrayList;

public class AmazingFatManAdapter extends RecyclerView.Adapter<AmazingFatManAdapter.AmazingFatManViewHolder> {
    ArrayList<AmazingFatManInfo> amazingFatManLocations;

    public AmazingFatManAdapter(ArrayList<AmazingFatManInfo> amazingFatManLocations) {
        this.amazingFatManLocations = amazingFatManLocations;
    }

    @NonNull
    @Override
    public AmazingFatManViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.amazing_fatman_card_design, parent, false);
        AmazingFatManViewHolder amazingFatManViewHolder = new AmazingFatManViewHolder(view);
        return amazingFatManViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AmazingFatManViewHolder holder, int position) {
        try {
            AmazingFatManInfo amazingFatManInfo = amazingFatManLocations.get(position);
            holder.imageView.setImageResource(amazingFatManInfo.getImage());
            holder.title.setText(amazingFatManInfo.getTitle());
        } catch (Exception e) {
            Log.e("Exception: ", e.getMessage());
        }
    }

    @Override
    public int getItemCount() {
        return amazingFatManLocations.size();
    }

    public static class AmazingFatManViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView title;

        public AmazingFatManViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.amazing_fatman_image);
            title = itemView.findViewById(R.id.amazing_fatman_title);
        }
    }
}
