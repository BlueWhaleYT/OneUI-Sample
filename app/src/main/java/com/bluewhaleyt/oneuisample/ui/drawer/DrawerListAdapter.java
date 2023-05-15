package com.bluewhaleyt.oneuisample.ui.drawer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bluewhaleyt.oneuisample.R;
import com.bluewhaleyt.oneuisample.ui.fragment.FragmentInfo;

import java.util.List;

public class DrawerListAdapter extends RecyclerView.Adapter<DrawerListViewHolder> {

    private Context context;
    private List<Fragment> listFragment;
    private DrawerListener listener;
    private int selectedPos;

    public interface DrawerListener {
        boolean onDrawerItemSelected(int position);
    }

    public DrawerListAdapter(@NonNull Context context, List<Fragment> fragments, @Nullable DrawerListener listener) {
        this.context = context;
        this.listFragment = fragments;
        this.listener = listener;
    }

    @NonNull
    @Override
    public DrawerListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        var inflater = LayoutInflater.from(context);
        var isSeparator = viewType == 0;

        var view = inflater.inflate(isSeparator
                        ? R.layout.drawer_layout_list_separator
                        : R.layout.drawer_layout_list_item, parent, false
        );

        return new DrawerListViewHolder(view, isSeparator);
    }

    @Override
    public void onBindViewHolder(@NonNull DrawerListViewHolder holder, int position) {
        if (!holder.isSeparator()) {
            var fragment = listFragment.get(position);
            if (fragment instanceof FragmentInfo) {
                holder.setIcon(((FragmentInfo) fragment).getIconResId());
                holder.setTitle(((FragmentInfo) fragment).getTitle());
            }
            holder.setSelected(position == selectedPos);
            holder.itemView.setOnClickListener(v -> {
                var itemPos = holder.getBindingAdapterPosition();
                var result = false;
                if (listener != null) result = listener.onDrawerItemSelected(itemPos);
                if (result) setSelectedItem(itemPos);
            });
        }
    }

    @Override
    public int getItemCount() {
        return listFragment.size();
    }

    @Override
    public int getItemViewType(int position) {
        return (listFragment.get(position) == null) ? 0 : 1;
    }

    public void setSelectedItem(int position) {
        this.selectedPos = position;
        notifyItemRangeChanged(0, getItemCount());
    }
}
