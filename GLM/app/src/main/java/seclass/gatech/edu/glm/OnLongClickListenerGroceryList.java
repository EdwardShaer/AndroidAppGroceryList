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
 * Created by SamuelSmall on 10/9/2016.
 */

public class OnLongClickListenerGroceryList implements View.OnLongClickListener {

    private Context context;
    private String id;

    @Override
    public boolean onLongClick(View v) {
        context = v.getContext();
        id = v.getTag().toString();
        final CharSequence[] items = { "Change Name", "Delete List" };

        new AlertDialog.Builder(context).setTitle("Grocery List")
                .setItems(items, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        if(item==0)
                            editGroceryListName(Integer.parseInt(id));
                        else if (item == 1) {

                            boolean deleteSuccessful = new GroceryListController(context).delete(Integer.parseInt(id));

                            if (deleteSuccessful) {
                                Toast.makeText(context, "Grocery list was deleted.", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(context, "Unable to delete grocery list.", Toast.LENGTH_SHORT).show();
                            }
                        }
                        ((DisplayGroceryLists)getActivity(context)).readGroceryLists();
                        dialog.dismiss();

                    }
                }).show();
        return false;
    }
    public void editGroceryListName(final int groceryListId){
        final GroceryListController glc = new GroceryListController(context);
        GroceryList gl = glc.readSingleRecord(groceryListId);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View formElementsView = inflater.inflate(R.layout.grocerylist_create_form, null, false);
        final EditText editTextGroceryListName = (EditText) formElementsView.findViewById(R.id.editTextGroceryListName);

        editTextGroceryListName.setText(gl.getGroceryListName());
        new AlertDialog.Builder(context)
                .setView(formElementsView)
                .setTitle("Edit Grocery List Name")
                .setPositiveButton("Save Changes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                GroceryList gl = new GroceryList();
                                gl.setGroceryListId(groceryListId);
                                gl.setGroceryListName(editTextGroceryListName.getText().toString());
                                boolean updateSuccessful = glc.update(gl);

                                if(updateSuccessful){
                                    Toast.makeText(context, "Grocery list was updated.", Toast.LENGTH_SHORT).show();
                                }

                                else{
                                    Toast.makeText(context, "Unable to update grocery list.", Toast.LENGTH_SHORT).show();
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
