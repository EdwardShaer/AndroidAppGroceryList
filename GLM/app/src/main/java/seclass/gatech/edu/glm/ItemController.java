package seclass.gatech.edu.glm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SamuelSmall on 10/6/2016.
 */

public class ItemController extends GroceryListAppDBHandler {

    public ItemController(Context context) {
        super(context);
    }

    //Create new Item
    public int createItem(Item item) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ITEMNAME, item.getItemName());
        values.put(KEY_ITEMTYPE_ID, item.getItemTypeId());
//        boolean createSuccessful = db.insert(TABLE_ITEMS, null, values) > 0;
        long createdLID = db.insert(TABLE_ITEMS, null, values);
        db.close();
        int createdID = (int) createdLID;
        return createdID;
    }

    //Get (read) all items
    //Order by ItemType
    public List<Item> getAllItems() {
    List<Item> itemList = new ArrayList<>();

    String sql = "SELECT * FROM items";

    SQLiteDatabase db = this.getWritableDatabase();
    Cursor cursor = db.rawQuery(sql, null);

    if(cursor.moveToFirst())

    {
        do {

            int id = Integer.parseInt(cursor.getString(cursor.getColumnIndex("id")));
            String itemName = cursor.getString(cursor.getColumnIndex("itemname"));
            ItemType itemType = new ItemType();
            String itemTypeSQL = "Select * from itemtypes where id = "+cursor.getColumnIndex("itemtype_id");
            Cursor itCursor = db.rawQuery(itemTypeSQL,null);
            if(itCursor.moveToFirst()){
                do{
                    itemType.setId(Integer.parseInt(itCursor.getString(itCursor.getColumnIndex("id"))));
                    itemType.setName(itCursor.getString(itCursor.getColumnIndex("itemtypename")));
                } while (itCursor.moveToNext());
            }

            itCursor.close();
            Item item = new Item();
            item.setItemId(id);
            item.setItemName(itemName);
            item.setItemType(itemType);
            itemList.add(item);

        } while (cursor.moveToNext());
    }

    cursor.close();

    db.close();

    return itemList;
}
    public List<Item> getAllItemsByType(int itemTypeId) {
        List<Item> itemList = new ArrayList<>();

        String sql = "SELECT * FROM items where itemtype_id = "+itemTypeId;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if(cursor.moveToFirst())

        {
            do {

                int id = Integer.parseInt(cursor.getString(cursor.getColumnIndex("id")));
                String itemName = cursor.getString(cursor.getColumnIndex("itemname"));
                ItemType itemType = new ItemType();
                String itemTypeSQL = "Select * from itemtypes where id = "+cursor.getColumnIndex("itemtype_id");
                Cursor itCursor = db.rawQuery(itemTypeSQL,null);
                if(itCursor.moveToFirst()){
                    do{
                        itemType.setId(Integer.parseInt(itCursor.getString(itCursor.getColumnIndex("id"))));
                        itemType.setName(itCursor.getString(itCursor.getColumnIndex("itemtypename")));
                    } while (itCursor.moveToNext());
                }

                itCursor.close();
                Item item = new Item();
                item.setItemId(id);
                item.setItemName(itemName);
                item.setItemType(itemType);
                itemList.add(item);

            } while (cursor.moveToNext());
        }

        cursor.close();

        db.close();

        return itemList;
    }
    //Get (read) a single item
    public Item getItem(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_ITEMS, new String[] { KEY_ID, COLUMN_ITEMNAME, KEY_ITEMTYPE_ID},
                KEY_ID + "=?", new String[] {String.valueOf(id)}, null, null, null, null);
        if(cursor != null)
            cursor.moveToFirst();
        Item item = new Item();
        item.setItemId(Integer.parseInt(cursor.getString(0)));
        item.setItemName(cursor.getString(1));
        //need to search through the itemtype table
        Cursor cursor2 = db.query(TABLE_ITEMTYPES, new String[] { KEY_ITEMTYPE_ID, COLUMN_ITEMTYPENAME},
                KEY_ITEMTYPE_ID +"=?", new String[] {String.valueOf(cursor.getString(2))}, null, null, null, null);
        if(cursor2!= null)
            cursor.moveToFirst();
        ItemType it = new ItemType(Integer.parseInt(cursor2.getString(0)),cursor2.getString(1));

        item.setItemType(it);

        cursor.close();
        cursor2.close();
        db.close();
        return item;
    }

    //Update a single item (change name, itemtype)
    public int updateItem(Item item) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ITEMNAME, item.getItemName());
        values.put(KEY_ITEMTYPE_ID, getItem(item.getItemId()).getItemType().getId());
        return db.update(TABLE_ITEMS, values, KEY_ID+" = ?",
                new String[] {String.valueOf(item.getItemId()) });

    }

    //Delete a single item
    public void deleteItem(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_ITEMS, KEY_ID + " = ?",
                new String[] { String.valueOf(id)});
        db.close();
    }

    public List<Item> searchItems(String searchParam) {
        List<Item> mySearchResults = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_ITEMS, new String[] { KEY_ID, COLUMN_ITEMNAME,KEY_ITEMTYPE_ID},
                               COLUMN_ITEMNAME + " LIKE ?", new String[]{"%"+ searchParam+ "%" }, null, null, KEY_ITEMTYPE_ID, null);
        if (cursor.moveToFirst()) {
               for (int i = 0; i < cursor.getCount(); i++) {
                       int itemID = Integer.parseInt(cursor.getString(0));
                       String itemName = cursor.getString(1);
                       int itemTypeID = Integer.parseInt(cursor.getString(2));
                       ItemType itemType = new ItemType();
                       String itemTypeSQL = "Select * from itemtypes where id = "+(itemTypeID+1)+" ORDER BY id DESC";
                       Cursor itCursor = db.rawQuery(itemTypeSQL,null);
                       if(itCursor.moveToFirst()){
                           do{
                               itemType.setId(Integer.parseInt(itCursor.getString(itCursor.getColumnIndex("id"))));
                               itemType.setName(itCursor.getString(itCursor.getColumnIndex("itemtypename")));
                           } while (itCursor.moveToNext());
                       }

                       itCursor.close();
                       Item item = new Item();
                       item.setItemId(itemID);
                       item.setItemName(itemName);
                       item.setItemType(itemType);
                       mySearchResults.add(item);

                       cursor.moveToNext();
               }
        }
        cursor.close();
        db.close();
        return mySearchResults;
    }
}
