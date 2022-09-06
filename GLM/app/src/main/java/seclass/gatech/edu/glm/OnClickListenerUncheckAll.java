package seclass.gatech.edu.glm;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import static java.lang.Integer.parseInt;

/**
 * Created by SamuelSmall on 10/16/2016.
 */

public class OnClickListenerUncheckAll  implements View.OnClickListener {
    private Context context;
    private int groceryListID;
    public OnClickListenerUncheckAll(int glID){
        this.groceryListID = glID;
    }
    public void onClick(View v) {
        context = v.getContext();

        GroceryListItemController glic = new GroceryListItemController((v.getContext()));
        glic.setAllItemsUnchecked(this.groceryListID);
        Toast.makeText(context, "All items unchecked", Toast.LENGTH_SHORT).show();
        Intent i= new Intent(context,DisplayGroceryListDetails.class);
        i.putExtra("glID", this.groceryListID).toString();

        context.startActivity(i);
    }

}
