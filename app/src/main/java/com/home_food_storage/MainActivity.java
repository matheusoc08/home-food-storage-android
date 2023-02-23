package com.home_food_storage;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.home_food_storage.dao.DaoItemList;
import com.home_food_storage.dto.DtoItem;
import com.home_food_storage.shopping_list.EditItemActivity;
import com.home_food_storage.shopping_list.ItemListAdapter;
import com.home_food_storage.shopping_list.NewItemActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editTextSearchItem;
    TextView textViewMessageEmptyList;
    RecyclerView recyclerViewItemList;
    Button buttonNewItem, buttonSendStorage, buttonCleanList;
    ArrayList<DtoItem> arrayItemList;
    DaoItemList daoItemList = new DaoItemList(MainActivity.this);
    DtoItem dtoItem;

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
                daoItemList.clearList();
                updateList();
            }
        });

        buttonSendStorage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder msg = new AlertDialog.Builder(MainActivity.this);
                msg.setMessage("Tem certeza que deseja incluir os itens ao estoque?");
                msg.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Os itens comprados foram incluídos no estoque.", Toast.LENGTH_SHORT).show();
                    }
                });
                msg.setNegativeButton("Não", null);
                msg.show();
            }
        });
        
        recyclerViewItemList.addOnItemTouchListener(new RecyclerItemClickListener(MainActivity.this, recyclerViewItemList,
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Toast.makeText(MainActivity.this, "Clicou!", Toast.LENGTH_SHORT).show();

                        dtoItem = arrayItemList.get(position);

                        Intent intent = new Intent(MainActivity.this, EditItemActivity.class);
                        intent.putExtra("id", dtoItem.getItemId());
                        intent.putExtra("name", dtoItem.getItemName());
                        intent.putExtra("description", dtoItem.getItemDescription());
                        intent.putExtra("weight", dtoItem.getItemWeight()+"");
                        intent.putExtra("price", dtoItem.getItemPrice()+"");
                        intent.putExtra("quantity", dtoItem.getItemQuantity()+"");
                        intent.putExtra("bought", dtoItem.isItemBought());
                        startActivity(intent);
                    }
        
                    @Override
                    public void onLongItemClick(View view, int position) {
                        Toast.makeText(MainActivity.this, "Segurooou", Toast.LENGTH_SHORT).show();
        
                    }
        
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        
                    }
        }));

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
            buttonCleanList.setVisibility(View.INVISIBLE);
        }
        else{
            textViewMessageEmptyList.setVisibility(View.INVISIBLE);
            buttonSendStorage.setVisibility(View.VISIBLE);
            buttonCleanList.setVisibility(View.VISIBLE);
        }
    }
}