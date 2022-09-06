package seclass.gatech.edu.glm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matthew Haggerty on 10/8/2016.
 */

public class ItemTypeController extends GroceryListAppDBHandler {

    public ItemTypeController(Context context) {
        super(context);
    }

    //Create a new Item Type (NOT USED BY UI OR USERS)

    // Read a single Item Type
    public ItemType getItemType(int id) {
//        String sql = "SELECT * FROM itemtypes where itemtype_id = "+id;
        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery(sql, null);

        Cursor cursor = db.query(TABLE_ITEMTYPES, new String[]{KEY_ID, COLUMN_ITEMTYPENAME},
                KEY_ID + "=?", new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

//        int myid = Integer.parseInt(cursor.getString(cursor.getColumnIndex("itemtype_id")));
//        String itemName = cursor.getString(cursor.getColumnIndex("itemtypename"));
        ItemType type = new ItemType();
        type.setId(Integer.parseInt(cursor.getString(0)));
        type.setName(cursor.getString(1));

        cursor.close();
        db.close();
        return type;
    }

    //Get the Name of an ItemType 
    public String getItemTypeName(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_ITEMTYPES, new String[]{COLUMN_ITEMTYPENAME}, KEY_ID + "=?", new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        String myItemTypeName = cursor.getString(0);
        cursor.close();
        db.close();
        return myItemTypeName;
    }

    //Get the ID for a given ItemType name
    public int getItemTypeID(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_ITEMTYPES, new String[] { KEY_ID},COLUMN_ITEMTYPENAME + "=?", new String[] {name}, null, null, null, null);
        if(cursor != null)
        cursor.moveToFirst();
        int myItemTypeID = Integer.parseInt(cursor.getString(0));
        cursor.close();
        db.close();
        return myItemTypeID;
    }

    //Read all Item Types
    public List<ItemType> getAllItemTypes(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_ITEMTYPES, new String[] { KEY_ID, COLUMN_ITEMTYPENAME},null, null, null, null, null, null);
        ArrayList<ItemType> myTypes = new ArrayList<>();
        if (cursor.moveToFirst()) {
            for (int i = 0; i < cursor.getCount(); i++) {
                myTypes.add(new ItemType(Integer.parseInt(cursor.getString(0)), cursor.getString(1)));
                cursor.moveToNext();
            }
        }
        cursor.close();
        db.close();
        return myTypes;
    }

    //Read all Item Type Names
    public String[] getAllItemTypeNames(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_ITEMTYPES, new String[] { COLUMN_ITEMTYPENAME},null, null, null, null, null, null);
        String[] typeNames = null;
        if (cursor.moveToFirst()) {
            for (int i = 0; i < cursor.getCount(); i++) {
                typeNames[i] = cursor.getString(0);
                cursor.moveToNext();
            }
        }
        cursor.close();
        db.close();
        return typeNames;
    }

    //Update an Item Type (NOT USED BY UI OR USERS)
    // Delete an Item Type (NOT USED BY UI OR USERS) } 
}