package com.home_food_storage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.ItemListHolder> {

    @NonNull
    @Override
    public ItemListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View listItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_adapter, parent, false);
        return new ItemListHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemListHolder holder, int position) {
        holder.textViewItemName.setText("item_list");
        holder.textViewItemPrice.setText("100,00");
        holder.textViewItemQuantity.setText("100");

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class ItemListHolder extends RecyclerView.ViewHolder{

        TextView textViewItemName, textViewItemPrice, textViewItemQuantity;
        CheckBox checkBoxItemBought;

        public ItemListHolder(@NonNull View itemView) {
            super(itemView);

            textViewItemName = itemView.findViewById(R.id.textViewItemName);
            textViewItemPrice = itemView.findViewById(R.id.textViewItemPrice);
            textViewItemQuantity = itemView.findViewById(R.id.textViewItemQuantity);
            checkBoxItemBought = itemView.findViewById(R.id.checkboxItemBought);

        }
    }


}
