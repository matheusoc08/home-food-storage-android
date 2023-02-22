package com.home_food_storage.shopping_list;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.home_food_storage.R;

public class EditItemActivity extends AppCompatActivity {

    EditText editTextItemName, editTextItemDescription, editTextItemWeight, editTextItemQuantity, editTextItemPrice;
    Button buttonAddItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        editTextItemName = findViewById(R.id.editTextItemName);
        editTextItemDescription = findViewById(R.id.editTextItemDescription);
        editTextItemWeight = findViewById(R.id.editTextItemWeight);
        editTextItemQuantity = findViewById(R.id.editTextItemQuantity);
        editTextItemPrice = findViewById(R.id.editTextItemPrice);
        buttonAddItem = findViewById(R.id.buttonUpdateItem);

        buttonAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}