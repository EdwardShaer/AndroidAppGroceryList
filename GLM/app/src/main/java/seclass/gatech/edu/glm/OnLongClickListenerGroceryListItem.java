package seclass.gatech.edu.glm;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.AdapterView.OnItemLongClickListener;
/**
 * Created by SamuelSmall on 10/16/2016.
 */

public class OnLongClickListenerGroceryListItem  implements View.OnLongClickListener{
    private Context context;
    private String id;

    private View v;
    public OnLongClickListenerGroceryListItem(View v){

        this.v=v;
    }

    @Override
    public boolean onLongClick(View v) {
        context = v.getContext();
        CheckBox checked = (CheckBox) v;
        final GroceryListItem item = (GroceryListItem) checked.getTag();
        id = Integer.toString(item.getItemId());
        final int glid = item.getGroceryListItemID();

        final CharSequence[] qty = { "0 (Delete)", "1", "2", "3", "4","5", "6", "7","8","9","Set quantity" };
        new AlertDialog.Builder(context).setTitle("Item Quantity")
                .setItems(qty, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int qtyKey) {
                        if(qtyKey==0) {

                            boolean deleteSuccessful = new GroceryListItemController(context).deleteGroceryListItem(item.getGroceryListID(), item.getItemId());
                            if(deleteSuccessful){
                                Toast.makeText(context, "Item deleted.", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(context, DisplayGroceryListDetails.class);
                                i.putExtra("glID",item.getGroceryListID());
                                context.startActivity(i);
                            }

                            dialog.dismiss();
                        }
                        else if(qtyKey==10)  {
                            editQuantity(Integer.parseInt(id),item.getGroceryListID());
                            boolean editSuccessful = new GroceryListItemController(context).updateGroceryListItemQuantity(Integer.parseInt(id), item.getGroceryListID(),qtyKey);
                            Toast.makeText(context, "Quantity was updated.", Toast.LENGTH_SHORT).show();

                        }
                        else {
                            boolean qtySuccessful = new GroceryListItemController(context).updateGroceryListItemQuantity(Integer.parseInt(id), item.getGroceryListID(), qtyKey);
                            if(qtySuccessful) {
                                Toast.makeText(context, "Quantity was updated.", Toast.LENGTH_SHORT).show();

                                Intent i = new Intent(context, DisplayGroceryListDetails.class);
                                i.putExtra("glID",item.getGroceryListID());
                                context.startActivity(i);
                            }
                            dialog.dismiss();
                        }
                    }
                }).show();

        return true;
    }
    public void editQuantity(final int itemId, final int groceryListId){
        final GroceryListItemController glic = new GroceryListItemController(context);
        final GroceryListItem gli = glic.getGroceryListItem(itemId, groceryListId);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View formElementsView = inflater.inflate(R.layout.grocery_list_item_quantity_form, null, false);
        final EditText editQty = (EditText) formElementsView.findViewById(R.id.qtyEdit);
        String startQty = Integer.toString(gli.getQuantity());
        editQty.setText(startQty);
        new AlertDialog.Builder(context)
                .setView(formElementsView)
                .setTitle("Change Quantity")
                .setPositiveButton("Save Changes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                GroceryListItem glItem = new GroceryListItem();
                                glItem.setGroceryListID(gli.getGroceryListID());
                                glItem.setItemName(gli.getItemName());
                                glItem.setItemType(gli.getItemType());
                                glItem.setItemId(gli.getItemId());
                                glItem.setCheckedState(gli.getCheckedState());
                                glItem.setQuantity(Integer.parseInt(editQty.getText().toString()));



                                boolean updateSuccessful = glic.updateGroceryListItemQuantity(glItem.getItemId(),glItem.getGroceryListID(),glItem.getQuantity());

                                if(updateSuccessful){
                                    Toast.makeText(context, "Quantity was updated.", Toast.LENGTH_SHORT).show();
                                    Intent i = new Intent(context, DisplayGroceryListDetails.class);
                                    i.putExtra("glID",gli.getGroceryListID());
                                    context.startActivity(i);
                                }

                                else{
                                    Toast.makeText(context, "Unable to update quantity.", Toast.LENGTH_SHORT).show();
                                }

                                dialog.cancel();
                            }

                        }).show();


    }

}
