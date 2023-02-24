package com.home_food_storage.shopping_list;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.home_food_storage.MainActivity;
import com.home_food_storage.R;
import com.home_food_storage.dao.DaoItemList;
import com.home_food_storage.dto.DtoItem;

public class NewItemActivity extends AppCompatActivity {

    EditText editTextItemName, editTextItemDescription, editTextItemWeight, editTextItemQuantity, editTextItemPrice;
    Button buttonAddItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_item);

        editTextItemName = findViewById(R.id.editTextItemName);
        editTextItemDescription = findViewById(R.id.editTextItemDescription);
        editTextItemWeight = findViewById(R.id.editTextItemWeight);
        editTextItemQuantity = findViewById(R.id.editTextItemQuantity);
        editTextItemPrice = findViewById(R.id.editTextItemPrice);
        buttonAddItem = findViewById(R.id.buttonAddItem);

        buttonAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DaoItemList daoItemList = new DaoItemList(NewItemActivity.this);

                DtoItem dtoItem = new DtoItem(
                        editTextItemName.getText().toString(),
                        editTextItemDescription.getText().toString(),
                        Double.parseDouble(editTextItemWeight.getText().toString()),
                        Double.parseDouble(editTextItemPrice.getText().toString()),
                        Integer.parseInt(editTextItemQuantity.getText().toString()),
                        false
                );

                try {
                    long affectedLines = daoItemList.insertItem(dtoItem);

                    if(affectedLines != 0){
                        Toast.makeText(NewItemActivity.this, "Item incluído.", Toast.LENGTH_SHORT).show();

                        editTextItemName.setText("");
                        editTextItemDescription.setText("");
                        editTextItemWeight.setText("");
                        editTextItemQuantity.setText("");
                        editTextItemPrice.setText("");
                    }
                    else{
                        Toast.makeText(NewItemActivity.this, "Erro! Tente novamente.", Toast.LENGTH_SHORT).show();
                    }
                }
                catch (Exception e){
                    Toast.makeText(NewItemActivity.this, "Falha inesperada: " + e.toString(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}