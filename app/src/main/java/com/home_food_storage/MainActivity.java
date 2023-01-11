package com.home_food_storage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editTextSearchItem;
    TextView textViewCleanList, textViewMessageEmptyList;
    RecyclerView recyclerViewItemList;
    Button buttonNewItem;
    ArrayList<DtoItem> arrayItemList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextSearchItem = findViewById(R.id.editTextSearchItem);
        textViewCleanList = findViewById(R.id.textViewCleanList);
        textViewMessageEmptyList = findViewById(R.id.textViewMessageEmptyList);
        recyclerViewItemList = findViewById(R.id.recyclerViewItemList);
        buttonNewItem = findViewById(R.id.buttonNewItem);

        ItemListAdapter adapter = new ItemListAdapter();
        recyclerViewItemList.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerViewItemList.setAdapter(adapter);

        checkEmptyList();

        buttonNewItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    public void checkEmptyList(){
        if(arrayItemList.isEmpty()){
            textViewMessageEmptyList.setVisibility(View.VISIBLE);
        }
        else{
            textViewMessageEmptyList.setVisibility(View.INVISIBLE);
        }
    }
}