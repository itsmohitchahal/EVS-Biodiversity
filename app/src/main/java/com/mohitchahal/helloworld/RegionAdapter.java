package com.mohitchahal.helloworld;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RegionAdapter extends RecyclerView.Adapter<RegionAdapter.ViewHolder> {

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;

    private Context context;
    private List<Region> regions;

    public RegionAdapter(Context context, List<Region> regions) {
        this.context = context;
        this.regions = regions;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_region, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView, this);
        if (viewType == TYPE_HEADER) {
            viewHolder.provinceView.setTypeface(null, Typeface.BOLD);
            viewHolder.zoneView.setTypeface(null, Typeface.BOLD);
            viewHolder.areaView.setTypeface(null, Typeface.BOLD);
        }
        return new ViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Region region = regions.get(position);
        holder.provinceView.setText(region.province);
        holder.zoneView.setText(region.zone);
        holder.areaView.setText(region.area);
    }

    @Override
    public int getItemCount() {
        return this.regions.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_HEADER;
        } else {
            return TYPE_ITEM;
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final RegionAdapter adapter;
        private final TextView zoneView;
        private final TextView provinceView;
        private final TextView areaView;

        ViewHolder(@NonNull View itemView, RegionAdapter adapter) {
            super(itemView);

            this.adapter = adapter;
            this.zoneView = itemView.findViewById(R.id.text_zone);
            this.provinceView = itemView.findViewById(R.id.text_province);
            this.areaView = itemView.findViewById(R.id.text_area);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getLayoutPosition();
            if (position > 0) {
                Region region = regions.get(position);
                Intent intent = new Intent(context, BiodiversityActivity.class);
                intent.putExtra("region", region);
                context.startActivity(intent);
            }
        }
    }
}
