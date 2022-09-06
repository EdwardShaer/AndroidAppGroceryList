package seclass.gatech.edu.glm;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

/**
 * Created by SamuelSmall on 10/9/2016.
 */

public class OnClickListenerGroceryListDetails implements View.OnClickListener {
    private Context context;
    private String id;
    @Override
    public void onClick(View v) {
        context = v.getContext();
        id = v.getTag().toString();
        Toast.makeText(context, "Click received. GroceryListid="+id, Toast.LENGTH_SHORT).show();
        Intent i= new Intent(context,DisplayGroceryListDetails.class);
        i.putExtra("glID", Integer.parseInt(id));
        context.startActivity(i);
    }
}
