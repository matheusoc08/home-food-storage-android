package com.home_food_storage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editTextSearchItem;
    TextView textViewCleanList, textViewEmptyList;
    ListView listViewListItems;
    Button buttonNewItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextSearchItem = findViewById(R.id.editTextSearchItem);
        textViewCleanList = findViewById(R.id.textViewCleanList);
        textViewEmptyList = findViewById(R.id.textViewEmptyList);
        listViewListItems = findViewById(R.id.listViewListItems);
        buttonNewItem = findViewById(R.id.buttonNewItem);

        buttonNewItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}