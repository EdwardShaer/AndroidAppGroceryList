package seclass.gatech.edu.glm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.SyncStateContract;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

/**
 * Created by SamuelSmall on 10/6/2016.
 */

public class GroceryListItemController extends GroceryListAppDBHandler {
    public GroceryListItemController(Context context) {
        super(context);
    }

    //Add a new item to the grocery list
    public boolean createGroceryListItem(int itemId, int groceryListId) {

        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "SELECT * FROM grocerylistitems where grocerylist_id = "+groceryListId+" AND "+
                "item_id = "+itemId;
        Cursor c = db.rawQuery(sql,null);
        if(c.getCount()>0){
            int newQty = c.getColumnIndex("grocerylistitemquantity");
            newQty++;
            int glid = c.getColumnIndex("grocerylist_id");
            updateGroceryListItemQuantity(itemId, glid, newQty);
            db.close();
            return true;
        }

        ContentValues values = new ContentValues();
        values.put(KEY_ITEM_ID, itemId);
        values.put(KEY_GROCERYLIST_ID, groceryListId);
        values.put(COLUMN_GROCERYLISTITEMCHECKED, 0);
        values.put(COLUMN_GROCERYLISTITEMQUANTITY, 1);
        boolean createSuccessful = db.insert(TABLE_GROCERYLISTITEMS, null, values)>0;
        db.close();
        return createSuccessful;
    }
    public List<GroceryListItem> getAllGroceryItemsByList(int groceryListId) {
        List<GroceryListItem> itemList = new ArrayList<>();

        String sql = "SELECT * FROM grocerylistitems where grocerylist_id = "+groceryListId;


        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if(cursor.moveToFirst())

        {
            do {
                String itemId = cursor.getString(cursor.getColumnIndex("item_id"));
                String sql2 = "SELECT * FROM items where id = " +itemId;

                Cursor itemCursor = db.rawQuery(sql2,null);
                GroceryListItem tmp = new GroceryListItem();
                if(itemCursor.moveToFirst()){
                    do {
                        String itemTypeId = itemCursor.getString(itemCursor.getColumnIndex(KEY_ITEMTYPE_ID));

                        String sql3 = "SELECT * from itemtypes where id = "+itemTypeId;
                        Cursor itemTypeCursor = db.rawQuery(sql3,null);
                        if(itemTypeCursor.moveToFirst()){
                            do{
                                int itID = Integer.parseInt(itemTypeCursor.getString(itemTypeCursor.getColumnIndex("id")));
                                String itemTypeName = itemTypeCursor.getString(itemTypeCursor.getColumnIndex("itemtypename"));
                                ItemType iType = new ItemType();
                                iType.setId(itID);
                                iType.setName(itemTypeName);

                                tmp.setItemId(Integer.parseInt(itemCursor.getString(itemCursor.getColumnIndex("id"))));
                                tmp.setItemName(itemCursor.getString(itemCursor.getColumnIndex("itemname")));
                                tmp.setItemType(iType);

                            }while(itemTypeCursor.moveToNext());
                        }
                        itemTypeCursor.close();
                        String sql4 = "SELECT * from grocerylistitems where item_id = "+tmp.getItemId();
                        Cursor gliCursor = db.rawQuery(sql4,null);
                        if(gliCursor.moveToFirst()){
                            do{
                                tmp.setCheckedState(Integer.parseInt(gliCursor.getString(gliCursor.getColumnIndex("grocerylistitemchecked"))));
                                tmp.setQuantity(Integer.parseInt(gliCursor.getString(gliCursor.getColumnIndex("grocerylistitemquantity"))));
                            }while(gliCursor.moveToNext());
                        }
                        GroceryListItem gli = new GroceryListItem();

                        gli.setGroceryListID(groceryListId);
                        gli.setItemType(tmp.getItemType());
                        gli.setItemId(tmp.getItemId());
                        gli.setItemName(tmp.getItemName());
                        gli.setCheckedState(tmp.getCheckedState());
                        gli.setQuantity((tmp.getQuantity()));
                        itemList.add(gli);
                    }while(itemCursor.moveToNext());
                }
                itemCursor.close();
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        Collections.sort(itemList);
        return itemList;
    }
    //Get (read) a single groceryListItem
    public GroceryListItem getGroceryListItem(int id, int glid) {
        GroceryListItem glItem = new GroceryListItem();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_GROCERYLISTITEMS, new String[] { KEY_ITEM_ID, KEY_GROCERYLIST_ID, COLUMN_GROCERYLISTITEMQUANTITY },
                KEY_ITEM_ID + "=?" +" AND "+KEY_GROCERYLIST_ID + "=?", new String[] {valueOf(id), valueOf(glid)}, null, null, null, null);
        if(cursor != null)
            cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            Cursor itemCursor = db.query(TABLE_ITEMS, new String[] { KEY_ID, COLUMN_ITEMNAME, KEY_ITEMTYPE_ID },
                    KEY_ID + "=?", new String[] {valueOf(parseInt(cursor.getString(0)))}, null, null, null, null);
            if(itemCursor!= null)
                itemCursor.moveToFirst();
            Cursor itemTypeCursor = db.query(TABLE_ITEMTYPES, new String[] { KEY_ID, COLUMN_ITEMTYPENAME},
                    KEY_ID + "=?", new String[] {valueOf(parseInt(itemCursor.getString(2)))}, null, null, null, null);
            if(itemTypeCursor!= null)
                itemTypeCursor.moveToFirst();
            ItemType itemType = new ItemType(parseInt(itemTypeCursor.getString(0)), itemTypeCursor.getString(1));
            Item item = new Item(parseInt(cursor.getString(0)),itemCursor.getString(1), itemType);
            GroceryListItem gli = new GroceryListItem(item, parseInt(cursor.getString(1)));
            gli.setQuantity(parseInt(cursor.getString(2)));

            itemCursor.close();
            itemTypeCursor.close();
            glItem = gli;
            cursor.moveToNext();
        }



        cursor.close();

        db.close();
        return glItem;
    }



    public boolean updateGroceryListItemQuantity(int itemId, int glid, int qty)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "UPDATE grocerylistitems SET "+COLUMN_GROCERYLISTITEMQUANTITY+" = "+qty+" WHERE item_id = "+itemId+" AND grocerylist_id="+glid;
        Cursor c = db.rawQuery(sql,null);
        c.moveToFirst();
        c.close();

        return true;
    }

    //Update a single groceryListItem (change quantity, checked state)
    public int setAllItemsUnchecked(int glid) {
        SQLiteDatabase db = this.getWritableDatabase();

        String sql = "UPDATE grocerylistitems SET "+COLUMN_GROCERYLISTITEMCHECKED+" = 0 WHERE grocerylist_id = "+glid+
                " and "+COLUMN_GROCERYLISTITEMCHECKED+" = 1";
        Cursor c= db.rawQuery(sql, null);

        c.moveToFirst();
        c.close();


        return 0;

    }
    //Update a single groceryListItem (change quantity, checked state)
    public int updateGroceryListCheckedState(GroceryListItem gli) {
        SQLiteDatabase db = this.getWritableDatabase();

        int checkedState = gli.getCheckedState();



        String sql = "UPDATE grocerylistitems SET "+COLUMN_GROCERYLISTITEMCHECKED+" = "+checkedState+" WHERE item_id = "+gli.getItemId()+" AND grocerylist_id = "+gli.getGroceryListID();
        Cursor c= db.rawQuery(sql, null);

        c.moveToFirst();
        c.close();


     return 0;

    }

    //Delete a single groceryListItem
    public boolean deleteGroceryListItem(int glid, int itemid) {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            db.execSQL("DELETE FROM grocerylistitems WHERE grocerylist_id = " + glid+ " AND item_id = "+itemid+";");

            db.close();
            return true;
        }
        catch(Exception e){
            return false;
        }

    }
}
