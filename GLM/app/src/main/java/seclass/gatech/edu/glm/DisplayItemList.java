package seclass.gatech.edu.glm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;

import static java.lang.Integer.parseInt;
import static seclass.gatech.edu.glm.R.id.linearLayoutRecords;


public class DisplayItemList extends AppCompatActivity {
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    List<Item> listChildItems;
    HashMap<String, List<Item>> listDataChild;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_item_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        // preparing list data
        readItemList();
        //setup the listDataChild map for the adapter
        final List<String> itemNames = new ArrayList<>();
        for(List<Item> key : listDataChild.values() ){
            for(Item item : key){
                itemNames.add(item.getItemName());

            }
        }
        final Context context= expListView.getContext();
        final Intent intent = getIntent();
        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);
        expListView.setOnChildClickListener(new OnChildClickListener()
        {
            final int glid = intent.getIntExtra("glID", 0);


            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Item i = (Item) listAdapter.getChild(groupPosition,childPosition);
                int itemid = i.getItemId();

                addItemToGroceryList(itemid, glid, context);
                Intent redirIntent = new Intent(context,DisplayGroceryListDetails.class);
                redirIntent.putExtra("glID",glid);

                finish();
                startActivity(redirIntent);
                return true;
            }

            public void addItemToGroceryList(final int itemId,final int groceryListId, Context ctx) {
                final GroceryListItemController glic = new GroceryListItemController(ctx);
                if (glic.createGroceryListItem(itemId, groceryListId)) {
                    Toast.makeText(ctx, "Item added to grocery list.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ctx, "Unable to add item to grocery list.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // setting list adapter
        expListView.setAdapter(listAdapter);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

    public void readItemList() {
/**
 LinearLayout linearLayoutRecords = (LinearLayout) findViewById(R.id.linearLayoutItems);
 linearLayoutRecords.removeAllViews();
 **/

        List<ItemType> itemTypes=new ItemTypeController(this).getAllItemTypes();
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<Item>>();
        listChildItems = new ArrayList<Item>();
        if (itemTypes.size() > 0) {
            for (int i = 0; i < itemTypes.size(); i++) {
                List<Item> itemList = new ItemController(this).getAllItemsByType(i+1);
                ArrayList<Item> tmp = new ArrayList<>();
                for (int j = 0; j < itemList.size(); j++) {


                        tmp.add(itemList.get(j));



                }
                listChildItems = tmp;
                listDataChild.put(itemTypes.get(i).getName(), listChildItems);
                listDataHeader.add(itemTypes.get(i).getName());

            }


        }


               /*if(listDataHeader.contains(itemTypeName)&&obj.getItemType().getName() == itemTypeName){
                    int index = listDataHeader.indexOf(obj.getItemType().getName());

                    listChildItems.add(itemName);
                    listDataChild.put(listDataHeader.get(index),listChildItems);
                }
                else {
                   listDataHeader.add(itemTypeName);
                   int index = listDataHeader.indexOf(obj.getItemType().getName());
                   listChildItems.add(itemName);
                   listDataChild.put(listDataHeader.get(index),listChildItems);
               }*/
              /*  String textViewContents = itemName;

                TextView textViewItemList= new TextView(this);
                textViewItemList.setPadding(10, 30, 10, 30);
                textViewItemList.setText(textViewContents);
                textViewItemList.setTag(Integer.toString(id));
               // textViewItemList.setOnClickListener(new OnClickListenerGroceryListDetails());
               // textViewItemList.setOnLongClickListener(new OnLongClickListenerGroceryList());
                linearLayoutRecords.addView(textViewItemList);*/


        else {

            TextView locationItem = new TextView(this);
            locationItem.setPadding(8, 8, 8, 8);
            locationItem.setText("No records yet.");

            //     linearLayoutRecords.addView(locationItem);
        }
    }
}





