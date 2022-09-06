package seclass.gatech.edu.glm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SamuelSmall on 10/7/2016.
 */

public class GroceryListController extends GroceryListAppDBHandler {
    public GroceryListController(Context context) {
        super(context);
    }
    //Create new Item
    public boolean createGroceryList(GroceryList gl) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_GROCERYLISTNAME, gl.getGroceryListName());
        boolean createSuccessful = db.insert(TABLE_GROCERYLISTS, null, values)>0;
        db.close();
        return createSuccessful;
    }
    public GroceryList readSingleRecord(int groceryListId) {

        GroceryList gl = null;

        String sql = "SELECT * FROM grocerylists WHERE id = " + groceryListId;

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {

            int id = Integer.parseInt(cursor.getString(cursor.getColumnIndex("id")));
            String name = cursor.getString(cursor.getColumnIndex("grocerylistname"));


            gl = new GroceryList();
            gl.setGroceryListId(id);
            gl.setGroceryListName(name);

        }

        cursor.close();
        db.close();

        return gl;

    }
    public List<GroceryList> getAllGroceryLists() {

        List<GroceryList> groceryLists = new ArrayList<>();

        String sql = "SELECT * FROM grocerylists ORDER BY id DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            do {

                int id = Integer.parseInt(cursor.getString(cursor.getColumnIndex("id")));
                String groceryListName = cursor.getString(cursor.getColumnIndex("grocerylistname"));


                GroceryList gl = new GroceryList();
                gl.setGroceryListId(id);
                gl.setGroceryListName(groceryListName);

                groceryLists.add(gl);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return groceryLists;
    }
    public boolean update(GroceryList gl) {

        ContentValues values = new ContentValues();

        values.put("grocerylistname", gl.getGroceryListName());


        String where = "id = ?";

        String[] whereArgs = { Integer.toString(gl.getGroceryListId()) };

        SQLiteDatabase db = this.getWritableDatabase();

        boolean updateSuccessful = db.update("grocerylists", values, where, whereArgs) > 0;
        db.close();

        return updateSuccessful;

    }
    public boolean delete(int id) {
        boolean deleteSuccessful = false;

        SQLiteDatabase db = this.getWritableDatabase();
        deleteSuccessful = db.delete("grocerylists", "id ='" + id + "'", null) > 0;
        db.close();

        return deleteSuccessful;

    }
}
