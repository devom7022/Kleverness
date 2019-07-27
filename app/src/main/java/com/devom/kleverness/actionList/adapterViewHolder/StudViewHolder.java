package com.devom.kleverness.actionList.adapterViewHolder;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.RequestManager;
import com.devom.kleverness.actionList.R;
import com.devom.kleverness.actionList.model.Device;

public class StudViewHolder extends RecyclerView.ViewHolder {
    private RequestManager requestManager;
    private CardView itemStud;
    public ImageView ivThumbnail, ivExpand;
    private TextView tvName;

    private Drawable drawable;

    public StudViewHolder(@NonNull View itemView, RequestManager requestManager) {
        super(itemView);
        this.requestManager = requestManager;
        ivThumbnail = itemView.findViewById(R.id.iv_thumbnail);
        itemStud = itemView.findViewById(R.id.item_citizen);
        tvName = itemView.findViewById(R.id.tv_name);
        ivExpand = itemView.findViewById(R.id.iv_expand);
    }

    public void bind(final Device device, int side) {
        chooseImage(device);

        requestManager
                .load(drawable)
                .centerCrop()
                .into(ivThumbnail);

        tvName.setText(device.getAliasDevice());

        /*ivThumbnail.setOnClickListener(v -> {
            device.setIsOn(!device.getIsOn());
            chooseImage(device);
        });*/

        ViewGroup.LayoutParams paramsItem = itemStud.getLayoutParams();
        paramsItem.height = side;

    }

    public void chooseImage(Device device) {
        switch (device.getIcon().getName()) {
            case "icn_switch_3g":
                if (device.getIsOn()) {
                    drawable = itemView.getResources().getDrawable(R.drawable.icn_switch_3g_on);
                } else {
                    drawable = itemView.getResources().getDrawable(R.drawable.icn_switch_3g_off);
                }

                break;
            case "icn_dimmer_1g_1":
                if (device.getIsOn()) {
                    drawable = itemView.getResources().getDrawable(R.drawable.icn_dimmer_1g_1_on);
                } else {
                    drawable = itemView.getResources().getDrawable(R.drawable.icn_dimmer_1g_1_off);
                }

                break;
            case "icn_outlet_1g":
                if (device.getIsOn()) {
                    drawable = itemView.getResources().getDrawable(R.drawable.icn_outlet_1g_on);
                } else {
                    drawable = itemView.getResources().getDrawable(R.drawable.icn_outlet_1g_off);
                }

                break;
        }
    }
}