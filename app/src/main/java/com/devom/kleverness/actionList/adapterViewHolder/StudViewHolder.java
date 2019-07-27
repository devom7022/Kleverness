package com.devom.kleverness.actionList.adapterViewHolder;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.RequestManager;
import com.devom.kleverness.actionList.R;
import com.devom.kleverness.actionList.model.Device;
import com.devom.kleverness.actionList.utils.ExpandAndCollapseViewUtil;

public class StudViewHolder extends RecyclerView.ViewHolder {
    private RequestManager requestManager;
    private CardView itemStud;
    public ImageView ivThumbnail, ivExpand;
    private TextView tvName;
    private ViewGroup collapseLayout;
    private Drawable drawable;
    public LinearLayout subContainerActions;

    private static final int DURATION = 300;

    public StudViewHolder(@NonNull View itemView, RequestManager requestManager) {
        super(itemView);
        this.requestManager = requestManager;
        ivThumbnail = itemView.findViewById(R.id.iv_thumbnail);
        itemStud = itemView.findViewById(R.id.item_stub);
        tvName = itemView.findViewById(R.id.tv_name);
        ivExpand = itemView.findViewById(R.id.iv_expand);
        collapseLayout = itemView.findViewById(R.id.collapse_layout);
        subContainerActions = itemView.findViewById(R.id.sub_container_actions);
    }

    public void bind(final Device device, int side) {
        chooseImage(device);

        requestManager
                .load(drawable)
                .centerCrop()
                .into(ivThumbnail);

        tvName.setText(device.getAliasDevice());

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

    public void expand(boolean isExpand) {
        if (isExpand) {
            ExpandAndCollapseViewUtil.expand(collapseLayout, DURATION);
        } else {
            ExpandAndCollapseViewUtil.collapse(collapseLayout, DURATION);
        }
    }
}