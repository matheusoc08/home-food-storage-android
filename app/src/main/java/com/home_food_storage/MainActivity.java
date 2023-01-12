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
    TextView textViewMessageEmptyList;
    RecyclerView recyclerViewItemList;
    Button buttonNewItem, buttonSendStorage, buttonCleanList;
    ArrayList<DtoItem> arrayItemList = new ArrayList<>();

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

        carregaLista();

        atualizarLista();

        buttonNewItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                carregaLista();
                atualizarLista();
            }
        });

        buttonCleanList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayItemList.clear();
                atualizarLista();
            }
        });
    }

    private void atualizarLista() {
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

    private void carregaLista(){
        arrayItemList.add(new DtoItem("Arroz", "Arroz", 5, 13.00, 2, true));
        arrayItemList.add(new DtoItem("Feijao", "Feijao", 1, 5.00, 5, true));
        arrayItemList.add(new DtoItem("Carne", "Carne", 1.5, 23.00, 1, true));
        arrayItemList.add(new DtoItem("Miojo", "Sabor frango", 0, 4.00, 2, false));
        arrayItemList.add(new DtoItem("Macarrão", "Espageti", 0.5, 3.00, 2, true));
        arrayItemList.add(new DtoItem("Caixa de chocolate", null, 0, 13.00, 2, false));
    }
}