package seclass.gatech.edu.glm;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;

/**
 * Created by SamuelSmall on 10/2/2016.
 */

public class GroceryListAppDBHandler  extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "groceryListAppDB.db";
    public GroceryListAppDBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public static final String TABLE_GROCERYLISTS = "grocerylists";
    public static final String TABLE_ITEMS = "items";
    public static final String TABLE_ITEMTYPES = "itemtypes";
    public static final String TABLE_GROCERYLISTITEMS = "grocerylistitems";
    public static final String TABLE_USERS = "users";

    public static final String KEY_ID = "id";

   //User Table - colunns
    public static final String COLUMN_USERNAME = "username";

    //ItemType Table - columns
    public static final String COLUMN_ITEMTYPENAME = "itemtypename";

    //Item Table - columns
    public static final String COLUMN_ITEMNAME = "itemname";
    public static final String KEY_ITEMTYPE_ID = "itemtype_id";
    //GroceryList Table - columns
    public static final String COLUMN_GROCERYLISTNAME = "grocerylistname";
    public static final String KEY_USER_ID = "user_id";

    //GroceryListItem Table - columns
    public static final String COLUMN_GROCERYLISTITEMQUANTITY = "grocerylistitemquantity";
    public static final String COLUMN_GROCERYLISTITEMCHECKED = "grocerylistitemchecked";
    public static final String KEY_ITEM_ID = "item_id";
    public static final String KEY_GROCERYLIST_ID = "grocerylist_id";
    public static final String KEY_GROCERYLISTITEM_ID = "grocerylistitem_id";



    public GroceryListAppDBHandler(Context context, String name,
                       SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }
    private static final String CREATE_TABLE_USERS = "CREATE TABLE "
            + TABLE_USERS + "(" + KEY_ID + " INTEGER PRIMARY KEY," + COLUMN_USERNAME
            + " TEXT)";
    private static final String CREATE_TABLE_ITEMTYPES = "CREATE TABLE "
            + TABLE_ITEMTYPES + "(" + KEY_ID + " INTEGER PRIMARY KEY," + COLUMN_ITEMTYPENAME
            + " TEXT)";
    private static final String CREATE_TABLE_ITEMS = "CREATE TABLE "
            + TABLE_ITEMS + "(" + KEY_ID + " INTEGER PRIMARY KEY," + COLUMN_ITEMNAME
            + " TEXT," + KEY_ITEMTYPE_ID + " INTEGER)";
    private static final String CREATE_TABLE_GROCERYLISTITEMS = "CREATE TABLE "
            + TABLE_GROCERYLISTITEMS + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_ITEM_ID+" INTEGER," + COLUMN_GROCERYLISTITEMQUANTITY +" INTEGER,"
            + KEY_GROCERYLIST_ID+" INTEGER,"+ COLUMN_GROCERYLISTITEMCHECKED + " INTEGER)";
    private static final String CREATE_TABLE_GROCERYLISTS = "CREATE TABLE "
            + TABLE_GROCERYLISTS+ "(" + KEY_ID + " INTEGER PRIMARY KEY," + COLUMN_GROCERYLISTNAME
            + " TEXT,"+KEY_USER_ID+" INTEGER)";

    private void LoadItemTypes(SQLiteDatabase db ){
        //SQLiteDatabase db = this.getWritableDatabase();
        String[] myTypes={"Vegetables", "Fruit", "Dairy", "Frozen", "Bulk Foods", "Staples", "Drinks", "Kitchen  Cleaning", "Pets", "Baby", "Personal Care", "Meat", "Condiments", "General"};
        int stringLength = myTypes.length;
        for (int i=0; i<stringLength; i++) {
            ContentValues values = new ContentValues();
            values.put(COLUMN_ITEMTYPENAME, myTypes[i]);
            db.insert(TABLE_ITEMTYPES, null, values);
        }
       // db.close();
    }
    private void LoadGroceryListItems(SQLiteDatabase db ){
        //SQLiteDatabase db = this.getWritableDatabase();
        //Load Vegetables
        String[] myItems={"Broccoli", "Carrots", "Cauliflower", "Chilis", "Cilantro", "Corn", "Cucumber", "Garlic", "Ginger", "Greens", "Lettuce", "Mushrooms", "Onions", "Parsley", "Peppers", "Potatoes", "Spinach", "Squash", "Tomatoes", "Zucchini"};
        int stringLength = myItems.length;
        for (int i=0; i<stringLength; i++) {
            ContentValues values = new ContentValues();
            values.put(COLUMN_ITEMNAME, myItems[i]);
            values.put(KEY_ITEMTYPE_ID, 1);
            db.insert(TABLE_ITEMS, null, values);
        }

        //Load Fruit
        String[] myItems1={"Apples","Avocado","Bananas","Berries","Grapefruit","Grapes","Kiwi Fruit","Lemons","Limes","Melon","Oranges","Peaches","Pears","Plums"};
        int stringLength1 = myItems1.length;
        for (int i=0; i<stringLength1; i++) {
            ContentValues values = new ContentValues();
            values.put(COLUMN_ITEMNAME, myItems1[i]);
            values.put(KEY_ITEMTYPE_ID, 2);
            db.insert(TABLE_ITEMS, null, values);
        }
       // db.close();

        //Load Dairy
        String[] myItems2={"Butter","Cheese","Cottage Cheese","Cream Cheese","Creamer","Eggs","Margarine","Milk","Parmesan cheese","Sour Cream","Yogurt"};
        int stringLength2 = myItems2.length;
        for (int i=0; i<stringLength2; i++) {
            ContentValues values = new ContentValues();
            values.put(COLUMN_ITEMNAME, myItems2[i]);
            values.put(KEY_ITEMTYPE_ID, 3);
            db.insert(TABLE_ITEMS, null, values);
        }
        //db.close();

        //Load Frozen
        String[] myItems3={"Frozen Corn","Frozen Peaches","Frozen Peas","Frozen Blueberries","Frozen Spinach","Frozen Rolls","Ice Cream","Steamable Vegetables"};
        int stringLength3 = myItems3.length;
        for (int i=0; i<stringLength3; i++) {
            ContentValues values = new ContentValues();
            values.put(COLUMN_ITEMNAME, myItems3[i]);
            values.put(KEY_ITEMTYPE_ID, 4);
            db.insert(TABLE_ITEMS, null, values);
        }
        //db.close();

        //Load Bulk Foods
        String[] myItems4={"Basmati Rice","Black beans","Brown rice","Bulgar wheat","Chickpeas","Couscous","Kidney beans","Lentils","Oatmeal","Pasta","Quinoa","Raisins","Raw nuts","Raw seeds"};
        int stringLength4 = myItems4.length;
        for (int i=0; i<stringLength4; i++) {
            ContentValues values = new ContentValues();
            values.put(COLUMN_ITEMNAME, myItems4[i]);
            values.put(KEY_ITEMTYPE_ID, 5);
            db.insert(TABLE_ITEMS, null, values);
        }
        //db.close();

        //Load Staples
        String[] myItems5={"Baking powder","Baking soda","Balsamic vinegar","Bread flour","Honey","Maple syrup","Mustard","Olive Oil","Peanut butter","Yeast"};
        int stringLength5 = myItems5.length;
        for (int i=0; i<stringLength5; i++) {
            ContentValues values = new ContentValues();
            values.put(COLUMN_ITEMNAME, myItems5[i]);
            values.put(KEY_ITEMTYPE_ID, 6);
            db.insert(TABLE_ITEMS, null, values);
        }
        //db.close();

        //Load Drinks
        String[] myItems6={"Beer","Coffee","Cola","Tea","Water","Wine"};
        int stringLength6 = myItems6.length;
        for (int i=0; i<stringLength6; i++) {
            ContentValues values = new ContentValues();
            values.put(COLUMN_ITEMNAME, myItems6[i]);
            values.put(KEY_ITEMTYPE_ID, 7);
            db.insert(TABLE_ITEMS, null, values);
        }
       // db.close();

        //Load Kitchen / Cleaning
        String[] myItems7={"Baggies","Dish soap","Dryer sheets","Foil","Garbage bags","Laundry detergent","Plastic wrap"};
        int stringLength7 = myItems7.length;
        for (int i=0; i<stringLength7; i++) {
            ContentValues values = new ContentValues();
            values.put(COLUMN_ITEMNAME, myItems7[i]);
            values.put(KEY_ITEMTYPE_ID, 8);
            db.insert(TABLE_ITEMS, null, values);
        }
        //db.close();

        //Load Pets
        String[] myItems8={"Cat food","Cat litter","Dog food","Pet shampoo","Dog bones"};
        int stringLength8 = myItems8.length;
        for (int i=0; i<stringLength8; i++) {
            ContentValues values = new ContentValues();
            values.put(COLUMN_ITEMNAME, myItems8[i]);
            values.put(KEY_ITEMTYPE_ID, 9);
            db.insert(TABLE_ITEMS, null, values);
        }
       // db.close();

        //Load Baby
        String[] myItems9={"Baby food","Diaper cream","Diapers","Formula","Wipes"};
        int stringLength9 = myItems9.length;
        for (int i=0; i<stringLength9; i++) {
            ContentValues values = new ContentValues();
            values.put(COLUMN_ITEMNAME, myItems9[i]);
            values.put(KEY_ITEMTYPE_ID, 10);
            db.insert(TABLE_ITEMS, null, values);
        }
        //db.close();

        //Load Personal Care
        String[] myItems10={"Body wash","Conditioner","Condoms","Deodorant","Facial cleanser","Facial tissue","Floss","Hand soap","Lotion","Q-Tips","Razors","Shampoo","Shaving cream","Soap","Toilet paper","Toothpaste"};
        int stringLength10 = myItems10.length;
        for (int i=0; i<stringLength10; i++) {
            ContentValues values = new ContentValues();
            values.put(COLUMN_ITEMNAME, myItems10[i]);
            values.put(KEY_ITEMTYPE_ID, 11);
            db.insert(TABLE_ITEMS, null, values);
        }
        //db.close();

        //Load Meat
        String[] myItems11={"Beef Ground","Beef Roast","Beef Steaks","Beef Ribs","Chicken Breast with bone","Chicken Breast boneless","Chicken Legs","Chicken Thighs","Chicken Wings","Chicken Whole"};
        int stringLength11 = myItems11.length;
        for (int i=0; i<stringLength11; i++) {
            ContentValues values = new ContentValues();
            values.put(COLUMN_ITEMNAME, myItems11[i]);
            values.put(KEY_ITEMTYPE_ID, 12);
            db.insert(TABLE_ITEMS, null, values);
        }
        //db.close();

        //Load Condiments
        String[] myItems12={"Brown Sugar","Catsup","Cinnamon","Garlic Powder","Garlic Salt","Ginger","Honey","Horseradish","Jelly","Mayonnaise","Mustard (Brown)","Mustard (yellow)","Nutmeg","Olive Oil","Oregano","Paprika","Parsley","Peanut Butter","Pepper","Salad Dressings","Salsa (hot/med/mild)","Salt","Soy Sauce","Syrup","Vegetable Oil","White Sugar","Worchestershire"};
        int stringLength12 = myItems12.length;
        for (int i=0; i<stringLength12; i++) {
            ContentValues values = new ContentValues();
            values.put(COLUMN_ITEMNAME, myItems12[i]);
            values.put(KEY_ITEMTYPE_ID, 13);
            db.insert(TABLE_ITEMS, null, values);
        }
       // db.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USERS);
        db.execSQL(CREATE_TABLE_ITEMTYPES);
        db.execSQL(CREATE_TABLE_ITEMS);
        db.execSQL(CREATE_TABLE_GROCERYLISTITEMS);
        db.execSQL(CREATE_TABLE_GROCERYLISTS);
        LoadItemTypes(db);
        LoadGroceryListItems(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_GROCERYLISTITEMS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ITEMS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ITEMTYPES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_GROCERYLISTS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);

        onCreate(db);
    }

    /**
     * CRUD OPERATIONS FOR EACH OBJECT
     * --Consider refactoring into another class/classes/pattern
     */




}
