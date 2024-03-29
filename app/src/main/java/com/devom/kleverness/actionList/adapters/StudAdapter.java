package com.devom.kleverness.actionList.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.RequestManager;
import com.devom.kleverness.actionList.R;
import com.devom.kleverness.actionList.adapterViewHolder.StudViewHolder;
import com.devom.kleverness.actionList.model.Device;

import java.util.ArrayList;
import java.util.List;

public class StudAdapter extends RecyclerView.Adapter<StudViewHolder> {

    private int side;
    private RequestManager requestManager;
    private List<Device> citizenList = new ArrayList<>();
    private StudAdapterView view;

    public StudAdapter(RequestManager requestManager) {
        this.requestManager = requestManager;
    }

    @NonNull
    @Override
    public StudViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_stud, parent, false);
        return new StudViewHolder(view, requestManager);
    }

    @Override
    public void onBindViewHolder(@NonNull StudViewHolder holder, int pos) {
        final Device localItem = citizenList.get(pos);

        holder.bind(localItem, getSide());

        holder.ivThumbnail.setOnClickListener(v -> {
            localItem.setIsOn(!localItem.getIsOn());
            holder.chooseImage(localItem);
            notifyItemChanged(pos);

        });

    }

    @Override
    public int getItemCount() {
        return null != citizenList ? citizenList.size() : 0;
    }

    public void setView(StudAdapterView view, int sideX, int colums) {
        this.view = view;
        this.side = sideX / colums;
    }

    private int getSide() {
        return this.side;
    }

    public void setData(List<Device> citizenList) {
        this.citizenList.clear();
        this.citizenList.addAll(citizenList);
        notifyDataSetChanged();
    }

    public void change(int pos) {
        notifyItemChanged(pos);
    }

}