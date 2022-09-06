package seclass.gatech.edu.glm;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class DisplayGroceryLists extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_grocery_lists);
        Button buttonCreateGroceryList = (Button) findViewById(R.id.buttonCreateGroceryList);
        buttonCreateGroceryList.setOnClickListener(new OnClickListenerCreateGroceryList());
       // Button buttonOpenItemList = (Button) findViewById(R.id.buttonOpenItemList);
       // buttonOpenItemList.setOnClickListener(new OnClickListenerViewItemList());

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        //Calling readGroceryLists() to show the lists
        readGroceryLists();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_display_grocery_lists, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void readGroceryLists() {

        LinearLayout linearLayoutRecords = (LinearLayout) findViewById(R.id.linearLayoutRecords);
        linearLayoutRecords.removeAllViews();

        List<GroceryList> groceryLists = new GroceryListController(this).getAllGroceryLists();

        if (groceryLists.size() > 0) {

            for (GroceryList obj : groceryLists) {

                int id = obj.getGroceryListId();
                String groceryListName = obj.getGroceryListName();


                String textViewContents = groceryListName;

                TextView textViewGroceryList= new TextView(this);
                textViewGroceryList.setPadding(10, 30, 10, 30);
                textViewGroceryList.setText(textViewContents);
                textViewGroceryList.setTag(Integer.toString(id));
                textViewGroceryList.setOnClickListener(new OnClickListenerGroceryListDetails());
                textViewGroceryList.setOnLongClickListener(new OnLongClickListenerGroceryList());
                linearLayoutRecords.addView(textViewGroceryList);
            }

        }

        else {

            TextView locationItem = new TextView(this);
            locationItem.setPadding(8, 8, 8, 8);
            locationItem.setText("No records yet.");

            linearLayoutRecords.addView(locationItem);
        }

    }
}
