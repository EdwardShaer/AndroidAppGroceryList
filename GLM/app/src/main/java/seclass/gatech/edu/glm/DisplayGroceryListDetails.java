package seclass.gatech.edu.glm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DisplayGroceryListDetails extends AppCompatActivity {
    public int groceryListId;
    private ListView lv;
    private TextView listItem = null;
    private Button viewList;
    private Button back_to_grocery_lists;
    private ArrayAdapter<GroceryListItem> arrayAdapter;
    private CheckBox checkBoxUncheckAll;

    int getGroceryListId(){ return this.groceryListId;}

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();

            int glid = intent.getIntExtra("glID",0);
            this.groceryListId = intent.getIntExtra("glID",0);

        setContentView(R.layout.activity_display_grocery_list_details);

        viewList = (Button) findViewById(R.id.buttonOpenItemList);
        viewList.setOnClickListener(new OnClickListenerViewItemList(this.groceryListId));
        checkBoxUncheckAll = (CheckBox) findViewById(R.id.checkBoxCheckAll);
        checkBoxUncheckAll.setOnClickListener(new OnClickListenerUncheckAll(this.groceryListId));
        back_to_grocery_lists = (Button) findViewById(R.id.back_to_grocery_list_button);
        back_to_grocery_lists.setOnClickListener(new OnClickListenerBackToGroceryLists());

        lv = (ListView) findViewById(R.id.groceryListItems);



        readGroceryListDetails(this.groceryListId);

        //Search Buttons
        Button searchButton = (Button) findViewById(R.id.search_button);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent redirIntent = new Intent(v.getContext(),DisplayGroceryListDetails.class);
                redirIntent.putExtra("GLid",groceryListId);
                onSearchRequested();
                //startActivity(i);
                //DisplayGroceryListDetails.super.startActivity(i);

            }
        });

    }
    @Override
    public void startActivity(Intent intent) {
        // check if search intent
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            intent.putExtra("glID", groceryListId);
        }
        DisplayGroceryListDetails.super.startActivity(intent);
    }
    public void readGroceryListDetails(int id) {


        GroceryList gl = new GroceryListController(this).readSingleRecord(this.groceryListId);

        int glID = id;
        GroceryListItemController glic = new GroceryListItemController(this);

        List<GroceryListItem> grocListItems = glic.getAllGroceryItemsByList(glID);
        if(grocListItems==null){
            Toast.makeText(this, "No items in "+gl.getGroceryListName(), Toast.LENGTH_SHORT).show();
        }
        else if(!grocListItems.isEmpty()){
            arrayAdapter  = new GroceryListItemAdapter(this,grocListItems);

            lv.setAdapter(arrayAdapter);

        }

        else
            Toast.makeText(this, "List empty.", Toast.LENGTH_SHORT).show();
    }
}
