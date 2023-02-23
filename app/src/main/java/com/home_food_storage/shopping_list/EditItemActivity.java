package com.home_food_storage.shopping_list;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.home_food_storage.MainActivity;
import com.home_food_storage.R;
import com.home_food_storage.dao.DaoItemList;
import com.home_food_storage.dto.DtoItem;

public class EditItemActivity extends AppCompatActivity {

    EditText editTextItemName, editTextItemDescription, editTextItemWeight, editTextItemQuantity, editTextItemPrice;
//    CheckBox checkBoxItemBought;
    int itemId;
    Button buttonUpdateItem, buttonDeleteItem;
    DaoItemList daoItemList = new DaoItemList(EditItemActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        editTextItemName = findViewById(R.id.editTextItemName);
        editTextItemDescription = findViewById(R.id.editTextItemDescription);
        editTextItemWeight = findViewById(R.id.editTextItemWeight);
        editTextItemQuantity = findViewById(R.id.editTextItemQuantity);
        editTextItemPrice = findViewById(R.id.editTextItemPrice);
        buttonUpdateItem = findViewById(R.id.buttonUpdateItem);
        buttonDeleteItem = findViewById(R.id.buttonDeleteItem);
        //checkBoxItemBought = findViewById(R.id.checkboxItemBought);

        Bundle bundle = getIntent().getExtras();
        itemId = bundle.getInt("id");
        editTextItemName.setText(bundle.getString("name"));
        editTextItemDescription.setText(bundle.getString("description"));
        editTextItemWeight.setText(bundle.getString("weight"));
        editTextItemPrice.setText(bundle.getString("price"));
        editTextItemQuantity.setText(bundle.getString("quantity"));

        buttonUpdateItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder msg = new AlertDialog.Builder(EditItemActivity.this);
                msg.setMessage("Tem certeza que quer atualizar este item?");
                msg.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        try {
                            DtoItem dtoItem = new DtoItem(
                                    editTextItemName.getText().toString(),
                                    editTextItemDescription.getText().toString(),
                                    Double.parseDouble(editTextItemWeight.getText().toString()),
                                    Double.parseDouble(editTextItemPrice.getText().toString()),
                                    Integer.parseInt(editTextItemQuantity.getText().toString()),
                                    bundle.getBoolean("bought")
                            );
                            dtoItem.setItemId(itemId);

                            long affectedLines = daoItemList.updateItem(dtoItem);

                            if(affectedLines > 0) {
                                Toast.makeText(EditItemActivity.this, "Item alterado com sucesso!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(EditItemActivity.this, MainActivity.class);
                                startActivity(intent);
                            }
                            else{
                                Toast.makeText(EditItemActivity.this, "Falha ao alterar. Tente novamente.", Toast.LENGTH_SHORT).show();
                            }
                        }
                        catch(Exception e){
                            Toast.makeText(EditItemActivity.this, "Falha ao alterar. Erro:" + e.toString(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
                msg.setNegativeButton("Não", null);
                msg.show();
            }
        });

        buttonDeleteItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder msg = new AlertDialog.Builder(EditItemActivity.this);
                msg.setMessage("Tem certeza que deseja remover este item?");
                msg.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        
                        long affectedLines = daoItemList.deleteItem(itemId);
                        
                        if(affectedLines > 0) {
                            Toast.makeText(EditItemActivity.this, "Item removido.", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(EditItemActivity.this, MainActivity.class);
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(EditItemActivity.this, "Erro. Tente novamente.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                msg.setNegativeButton("Não", null);
                msg.show();
            }
        });
    }
}