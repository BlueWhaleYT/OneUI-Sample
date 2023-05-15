package com.bluewhaleyt.oneuisample.ui.drawer;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bluewhaleyt.oneuisample.R;

public class DrawerListViewHolder extends RecyclerView.ViewHolder {

    private boolean isSeparator;

    private ImageView imgItemIcon;
    private TextView tvItemTitle;

    public DrawerListViewHolder(@NonNull View itemView, boolean isSeparator) {
        super(itemView);
        this.isSeparator = isSeparator;
        imgItemIcon = itemView.findViewById(R.id.drawer_item_icon);
        tvItemTitle = itemView.findViewById(R.id.drawer_item_title);
    }

    public boolean isSeparator() {
        return isSeparator;
    }

    public void setIcon(@DrawableRes int resId) {
        if (!isSeparator) imgItemIcon.setImageResource(resId);
    }

    public void setTitle(CharSequence title) {
        if (!isSeparator) tvItemTitle.setText(title);
    }

    public void setSelected(boolean selected) {
        if (!isSeparator) {
            itemView.setSelected(selected);
        }
    }

}
