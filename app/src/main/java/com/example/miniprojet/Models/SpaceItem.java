package com.example.miniprojet.Models;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.example.miniprojet.Adapters.DrawerAdapter;

public class SpaceItem extends DrawerItem<SpaceItem.viewHolder> {
    private int spaeDp;
    public SpaceItem(int spaeDp) {
        this.spaeDp=spaeDp;
    }

    @Override
    public viewHolder createViewHolder(ViewGroup parent) {
        Context context=parent.getContext();
        View view=new View(context);
        int height=(int) (context.getResources().getDisplayMetrics().density*spaeDp);
        view.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,height
        ));
        return new viewHolder(view);
    }

    @Override
    public void bindViewHolder(viewHolder holder) {

    }

    @Override
    public boolean isSelectable() {
        return false;
    }

    public class viewHolder extends DrawerAdapter.ViewHolder{

        public viewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
