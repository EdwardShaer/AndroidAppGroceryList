package seclass.gatech.edu.glm;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by SamuelSmall on 10/7/2016.
 */

public class OnClickListenerCreateGroceryList  implements View.OnClickListener {

    @Override
    public void onClick(View view) {

        final Context context = view.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View formElementsView = inflater.inflate(R.layout.grocerylist_create_form, null, false);
        final EditText editTextGroceryListName = (EditText) formElementsView.findViewById(R.id.editTextGroceryListName);

        new AlertDialog.Builder(context)
                .setView(formElementsView)
                .setTitle("Create Grocery List")
                .setPositiveButton("Create",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                String groceryListName = editTextGroceryListName.getText().toString();
                                GroceryList gl = new GroceryList();
                                gl.setGroceryListName(groceryListName);
                                boolean createSuccessful = new GroceryListController(context).createGroceryList(gl);
                                if(createSuccessful){
                                    Toast.makeText(context, "Grocery list was saved.", Toast.LENGTH_SHORT).show();

                                }else{
                                    Toast.makeText(context, "Unable to save grocery list.", Toast.LENGTH_SHORT).show();
                                }

                                ((DisplayGroceryLists)getActivity(context)).readGroceryLists();
                                dialog.cancel();
                            }

                        }).show();

    }
    private Activity getActivity(Context context) {

        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity)context;
            }
            context = ((ContextWrapper)context).getBaseContext();
        }
        return null;
    }

}
