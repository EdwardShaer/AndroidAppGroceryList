package seclass.gatech.edu.glm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by SamuelSmall on 10/3/2016.
 */

public class UserController extends GroceryListAppDBHandler {

    public UserController(Context context) {
        super(context);
    }

    //Create new User
    public boolean createUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_USERNAME, user.getName());
        boolean createSuccessful = db.insert(TABLE_USERS, null, values)>0;
        db.close();
        return createSuccessful;
    }
    //Get (read) a single user
    public User getUser(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_USERS, new String[] { KEY_USER_ID, COLUMN_USERNAME},
                KEY_USER_ID + "=?", new String[] {String.valueOf(id)}, null, null, null, null);
        if(cursor != null)
            cursor.moveToFirst();
        User user = new User(Integer.parseInt(cursor.getString(0)),cursor.getString(1));
        cursor.close();
        db.close();
        return user;
    }
    //Update a single user (change name)
    public int updateUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_USERNAME, user.getName());
        return db.update(TABLE_USERS, values, KEY_USER_ID+" = ?",
                new String[] {String.valueOf(user.getId()) });

    }

    //Delete a single user
    public void deleteUser(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_USERS, KEY_USER_ID + " = ?",
                new String[] { String.valueOf(id)});
        db.close();
    }

}
