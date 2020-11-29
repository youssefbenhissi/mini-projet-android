package com.example.miniprojet.Models;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.miniprojet.Adapters.DrawerAdapter;
import com.example.miniprojet.R;

public class SimplItem extends DrawerItem<SimplItem.ViewHolder> {
    private int selectedItemIconTint;
    private int selectedItemTextTint;
    private int normalItemIconTint;
    private int normalItemTextTint;
    private Drawable icon;
    private String title;
    public SimplItem(Drawable icon,String title){
        this.icon = icon;
        this.title=title;
    }
    @Override
    public ViewHolder createViewHolder(ViewGroup parent) {
        LayoutInflater layoutInflater= LayoutInflater.from(parent.getContext());
        View v=layoutInflater.inflate(R.layout.item_option,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void bindViewHolder(ViewHolder holder) {
        holder.title.setText(title);
        holder.icon.setImageDrawable(icon);
        //holder.title.setText(isChecked?selectedItemTextTint:normalItemTextTint);
        holder.icon.setColorFilter(isChecked ? selectedItemIconTint : normalItemIconTint);
    }
    public SimplItem  withSeectedIconTint( int SelectedItemIconTint){
        this.selectedItemIconTint=selectedItemIconTint;
        return this;
    }
    public SimplItem withSelectedTextTint(int selectedItemTextTint){
        this.selectedItemTextTint=selectedItemTextTint;
        return this;
    }
    public SimplItem withIconTint(int normalItemIconTint){
        this.normalItemIconTint=normalItemIconTint;
        return this;

    }
    public SimplItem withTextTint(int normalTextTint){
        this.normalItemTextTint=normalTextTint;
        return this;
    }
    static class ViewHolder extends DrawerAdapter.ViewHolder {
        private ImageView icon;
        private TextView title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.icon);
            title = itemView.findViewById(R.id.title);
        }
    }
}
