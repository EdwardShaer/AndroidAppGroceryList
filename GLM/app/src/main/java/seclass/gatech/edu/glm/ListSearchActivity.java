package seclass.gatech.edu.glm;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by matthewhaggerty on 10/14/16.
 */

public class ListSearchActivity extends ListActivity {
    private ArrayAdapter<Item> arrayAdapterItem;
    private ListView lv;
    private List<Item> myResults;
    private Item myResult;

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_search_results_list);
        lv = (ListView) findViewById(android.R.id.list);
        final Context context = lv.getContext();
        final Intent intent = getIntent();
        // Get the intent, verify the action and get the query
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            final String query = intent.getStringExtra(SearchManager.QUERY);
            ItemController ic = new ItemController(this);
            myResults = ic.searchItems(query);
            //Toast.makeText(this, "Searching the following term: "+query+" yields this many results: "+myResults.size(), Toast.LENGTH_SHORT).show();
            if (myResults.size() > 0) {
                arrayAdapterItem = new ArrayAdapter<Item>(this, android.R.layout.simple_list_item_1, myResults);
                lv.setAdapter(arrayAdapterItem);
                ListView mylv = getListView();
                mylv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    final int glid = intent.getIntExtra("glID", 0);

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Item selectedItem = (Item) parent.getItemAtPosition(position);
                        String mySelectedItemName = selectedItem.getItemName();
                        int itemid = selectedItem.getItemId();
                        addItemToGroceryList(itemid, glid, context);
                        //Toast.makeText(getApplicationContext(),"Added Item: "+mySelectedItemName+" to your grocery list numbered: "+glid,Toast.LENGTH_SHORT).show();

                        Intent redirIntent = new Intent(context, DisplayGroceryListDetails.class);
                        redirIntent.putExtra("glID", Integer.toString(glid));

                        finish();
                        startActivity(redirIntent);
                        return;

                    }

                    public void addItemToGroceryList(final int itemId, final int groceryListId, Context ctx) {
                        final GroceryListItemController glic = new GroceryListItemController(ctx);
                        if (glic.createGroceryListItem(itemId, groceryListId)) {
                            Toast.makeText(ctx, "Item added to grocery list.", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(ctx, "Unable to add item to grocery list.", Toast.LENGTH_SHORT).show();
                        }
                    }

                });
            } else {
                final ItemType itemType = new ItemType();
                itemType.setId(13);
                itemType.setName("General");
                Item blankItem = new Item();
                blankItem.setItemName("NOT FOUND. Click to add " + query);
                blankItem.setItemType(itemType);
                myResults.add(blankItem);
                arrayAdapterItem = new ArrayAdapter<Item>(this, android.R.layout.simple_list_item_1, myResults);
                lv.setAdapter(arrayAdapterItem);
                ListView mylv = getListView();
                mylv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    final int glid = intent.getIntExtra("glID", 0);

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        //public Dialog onCreateDialog(Bundle savedInstanceState) {
                            final AdapterView<?> myparent = parent;
                            final int myposition = position;
                            ItemTypeController myITC = new ItemTypeController(context);
//                            String[] myStringArray = myITC.getAllItemTypeNames();
                            String[] myStringArray= new String[] {"Vegetables", "Fruit", "Dairy", "Frozen", "Bulk Foods", "Staples", "Drinks", "Kitchen  Cleaning", "Pets", "Baby", "Personal Care", "Meat", "Condiments", "General"};
                            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                            alertDialogBuilder.setTitle("Please choose the Item Category");
                            alertDialogBuilder.setItems(myStringArray, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    int idToUse = which + 1;
                                    final ItemType itemType = new ItemType();
                                    itemType.setId(idToUse);
                                    ItemTypeController myITC = new ItemTypeController(context);
                                    String myname = myITC.getItemTypeName(idToUse);
                                    itemType.setName(myname);
                                    Item selectedItem = (Item) myparent.getItemAtPosition(myposition);
                                    int itemid = selectedItem.getItemId();
                                    int itemTypeID = itemType.getId();
                                    int brandNewItemID;
                                    brandNewItemID = addNewItemToDB(itemid,itemTypeID,query,context);
                                    addNewItemToGroceryList(brandNewItemID,glid,context);

                                    //Prepare to close the dialog box and return to the grocery list details screen
                                    Intent redirIntent = new Intent(context, DisplayGroceryListDetails.class);
                                    redirIntent.putExtra("glID", Integer.toString(glid));
                                    finish();
                                    startActivity(redirIntent);
                                }
                            });
                        alertDialogBuilder.show();
                    }
                });
            }
        }
    }
    public int addNewItemToDB(final int itemId,final int itemTypeID, String query, Context myctx) {
        final ItemController ic = new ItemController(myctx);
        Item newItem = new Item();
        newItem.setItemName(query);
        ItemTypeController myITC = new ItemTypeController(myctx);
        ItemType myItemType = myITC.getItemType(itemTypeID);
        newItem.setItemType(myItemType);
        int newItemID=0;
        Toast.makeText(myctx,"I am about to add: "+newItem.getItemName()+" to the type: "+newItem.getItemTypeId()+": "+newItem.getItemTypeName(), Toast.LENGTH_LONG).show();
        newItemID=ic.createItem(newItem);
        if (newItemID>0) {
            Toast.makeText(myctx, "Item added to list", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(myctx, "Unable to add item to list.", Toast.LENGTH_SHORT).show();
        }
        return newItemID;
    }
    public void addNewItemToGroceryList(final int myItemID,final int groceryListId, Context myctx) {
        final GroceryListItemController glic = new GroceryListItemController(myctx);
        if (glic.createGroceryListItem(myItemID, groceryListId)) {
            Toast.makeText(myctx, "Item added to grocery list.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(myctx, "Unable to add item to grocery list.", Toast.LENGTH_SHORT).show();
        }
    }
}
