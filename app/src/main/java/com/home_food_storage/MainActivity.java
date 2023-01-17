package com.home_food_storage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editTextSearchItem;
    TextView textViewMessageEmptyList;
    RecyclerView recyclerViewItemList;
    Button buttonNewItem, buttonSendStorage, buttonCleanList;
    ArrayList<DtoItem> arrayItemList = new ArrayList<>();
    DaoItemList daoItemList = new DaoItemList(MainActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextSearchItem = findViewById(R.id.editTextSearchItem);
        textViewMessageEmptyList = findViewById(R.id.textViewMessageEmptyList);
        recyclerViewItemList = findViewById(R.id.recyclerViewItemList);
        buttonNewItem = findViewById(R.id.buttonNewItem);
        buttonSendStorage = findViewById(R.id.buttonSendStorage);
        buttonCleanList = findViewById(R.id.buttonCleanList);

        buttonNewItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NewItemActivity.class);
                startActivity(intent);
            }
        });

        buttonCleanList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayItemList.clear();
                updateList();
            }
        });

        updateList();
    }

    public void updateList() {
        arrayItemList = daoItemList.listItems();

        ItemListAdapter adapter = new ItemListAdapter(arrayItemList);
        recyclerViewItemList.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerViewItemList.setAdapter(adapter);
        checkEmptyList();
    }

    private void checkEmptyList(){
        if(arrayItemList.isEmpty()){
            textViewMessageEmptyList.setVisibility(View.VISIBLE);
            buttonSendStorage.setVisibility(View.INVISIBLE);
        }
        else{
            textViewMessageEmptyList.setVisibility(View.INVISIBLE);
            buttonSendStorage.setVisibility(View.VISIBLE);
        }
    }
}