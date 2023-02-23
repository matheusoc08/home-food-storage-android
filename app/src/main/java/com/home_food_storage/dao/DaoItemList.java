package com.home_food_storage.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.home_food_storage.dto.DtoItem;

import java.util.ArrayList;

public class DaoItemList extends SQLiteOpenHelper {

    private final String TABLE = "LIST_TB";

    public DaoItemList(@Nullable Context context) {
        super(context, "LIST_TB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String command = "CREATE TABLE " + TABLE + "(" +
                "ITEM_ID INTEGER PRIMARY KEY," +
                "ITEM_NAME VARCHAR(30)," +
                "ITEM_DESCRIPTION VARCHAR(100)," +
                "ITEM_WEIGHT DECIMAL(8,2)," +
                "ITEM_PRICE DECIMAL(8,2)," +
                "ITEM_QUANTITY INTEGER," +
                "ITEM_BOUGHT BOOLEAN);";

        sqLiteDatabase.execSQL(command);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }

    public long insertItem(DtoItem dtoItem){
        ContentValues values = new ContentValues();
        values.put("ITEM_NAME", dtoItem.getItemName());
        values.put("ITEM_DESCRIPTION", dtoItem.getItemDescription());
        values.put("ITEM_WEIGHT", dtoItem.getItemWeight());
        values.put("ITEM_PRICE", dtoItem.getItemPrice());
        values.put("ITEM_QUANTITY", dtoItem.getItemQuantity());
        values.put("ITEM_BOUGHT", dtoItem.isItemBought());

        return getWritableDatabase().insert(TABLE, null, values);
    }

    public ArrayList<DtoItem> listItems(){
        String command = "SELECT " +
                "ITEM_ID," +
                "ITEM_NAME," +
                "ITEM_DESCRIPTION," +
                "ITEM_WEIGHT," +
                "ITEM_PRICE," +
                "ITEM_QUANTITY," +
                "ITEM_BOUGHT " +
                "FROM " + TABLE;

        Cursor cursor = getWritableDatabase().rawQuery(command, null);
        ArrayList<DtoItem> fullItemsList = new ArrayList<>();

        while(cursor.moveToNext()){
            DtoItem dtoItem = new DtoItem();
            dtoItem.setItemId(cursor.getInt(0));
            dtoItem.setItemName(cursor.getString(1));
            dtoItem.setItemDescription(cursor.getString(2));
            dtoItem.setItemWeight(cursor.getDouble(3));
            dtoItem.setItemPrice(cursor.getDouble(4));
            dtoItem.setItemQuantity(cursor.getInt(5));
            dtoItem.setItemBought(cursor.getInt(6) > 0);

            fullItemsList.add(dtoItem);
        }

        return fullItemsList;
    }

    public long updateItem(DtoItem dtoItem){
        ContentValues values = new ContentValues();
        values.put("ITEM_NAME", dtoItem.getItemName());
        values.put("ITEM_DESCRIPTION", dtoItem.getItemDescription());
        values.put("ITEM_WEIGHT", dtoItem.getItemWeight());
        values.put("ITEM_PRICE", dtoItem.getItemPrice());
        values.put("ITEM_QUANTITY", dtoItem.getItemQuantity());
        values.put("ITEM_BOUGHT", dtoItem.isItemBought());

        String id = "ITEM_ID=?";
        String[] args = {dtoItem.getItemId()+""};

        return getWritableDatabase().update(TABLE, values, id, args);
    }

    public long deleteItem(int idItem){
        String id = "ITEM_ID=?";
        String[] args = {idItem+""};

        return getWritableDatabase().delete(TABLE, id, args);
    }

    public int clearList(){
        return getWritableDatabase().delete(TABLE, null, null);
    }
}
