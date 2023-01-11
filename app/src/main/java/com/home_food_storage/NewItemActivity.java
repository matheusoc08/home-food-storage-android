package com.home_food_storage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewItemActivity extends AppCompatActivity {

    EditText editTextItemName, editTextItemDescription, editTextItemWeight, editTextItemQuantity, editTextItemPrice;
    Button buttonUpdateItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_item);

        editTextItemName = findViewById(R.id.editTextItemName);
        editTextItemDescription = findViewById(R.id.editTextItemDescription);
        editTextItemWeight = findViewById(R.id.editTextItemWeight);
        editTextItemQuantity = findViewById(R.id.editTextItemQuantity);
        editTextItemPrice = findViewById(R.id.editTextItemPrice);
        buttonUpdateItem = findViewById(R.id.buttonUpdateItem);

        buttonUpdateItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}