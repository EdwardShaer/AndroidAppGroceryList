package seclass.gatech.edu.glm;

import android.content.Context;
import android.content.Intent;
import android.view.View;

/**
 * Created by SamuelSmall on 10/16/2016.
 */

public class OnClickListenerBackToGroceryLists implements View.OnClickListener {
    private Context context;


    @Override
    public void onClick(View v) {
        context = v.getContext();


        Intent i= new Intent(context,DisplayGroceryLists.class);

        context.startActivity(i);
    }
}
