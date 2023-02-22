package com.home_food_storage.shopping_list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.home_food_storage.R;
import com.home_food_storage.dto.DtoItem;

import java.util.ArrayList;

public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.ItemListHolder> {

    ArrayList<DtoItem> arrayListItem = new ArrayList<>();
    public ItemListAdapter(ArrayList<DtoItem> arrayListItem){
        this.arrayListItem = arrayListItem;
    }

    @NonNull
    @Override
    public ItemListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View listItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_adapter, parent, false);
        return new ItemListHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemListHolder holder, int position) {
        holder.textViewItemName.setText(arrayListItem.get(position).getItemName());
        holder.textViewItemPrice.setText(arrayListItem.get(position).getItemPrice()+"");
        holder.textViewItemQuantity.setText(arrayListItem.get(position).getItemQuantity()+"");
        holder.checkBoxItemBought.setChecked(arrayListItem.get(position).isItemBought());
    }

    @Override
    public int getItemCount() {
        return arrayListItem.size();
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
