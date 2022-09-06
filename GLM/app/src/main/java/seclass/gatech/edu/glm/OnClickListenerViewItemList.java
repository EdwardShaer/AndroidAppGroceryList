package seclass.gatech.edu.glm;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

/**
 * Created by SamuelSmall on 10/12/2016.
 */

public class OnClickListenerViewItemList implements View.OnClickListener {
    private Context context;
    private int groceryListID;
    public OnClickListenerViewItemList(int glID){
        this.groceryListID = glID;
    }

    @Override
    public void onClick(View v) {
        context = v.getContext();


        Intent i= new Intent(context,DisplayItemList.class);
        i.putExtra("glID", this.getGroceryListId());
        context.startActivity(i);
    }
    public int getGroceryListId() {
        return groceryListID;
    }
}
