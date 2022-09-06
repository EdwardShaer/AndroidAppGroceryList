package seclass.gatech.edu.glm;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by SamuelSmall on 10/16/2016.
 */

public class GroceryListItemAdapter extends ArrayAdapter<GroceryListItem> {

        List<GroceryListItem> groceryListItems = null;
        Context context;

        public GroceryListItemAdapter(Context context, List<GroceryListItem> itemList) {
                super(context, R.layout.grocery_list_item_row, itemList);

                this.context = context;
                this.groceryListItems = itemList;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
                CheckBox checked = null;
                GroceryListItem tmp = new GroceryListItem();
                if (convertView == null) {
                        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
                        convertView = inflater.inflate(R.layout.grocery_list_item_row, parent, false);
                        TextView name = (TextView) convertView.findViewById(R.id.groceryListItemName);


                        checked = (CheckBox) convertView.findViewById(R.id.groceryListItemChecked);
                        convertView.setTag(checked);
                        tmp = (GroceryListItem) checked.getTag();
                        if(tmp!=null)
                                convertView.setTag(R.id.groceryListItemName,tmp.getItemId());

                        checked.setOnLongClickListener(new OnLongClickListenerGroceryListItem(convertView));
                        checked.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                        CheckBox checked = (CheckBox) v;
                                        GroceryListItem item = (GroceryListItem) checked.getTag();
                                        item.setCheckedState(checked.isChecked() == true ? 1 : 0);


                                        GroceryListItemController glic = new GroceryListItemController((v.getContext()));
                                        glic.updateGroceryListCheckedState(item);
                                        Intent redirIntent = new Intent(context,DisplayGroceryListDetails.class);
                                        redirIntent.putExtra("glID",item.getGroceryListID());


                                        context.startActivity(redirIntent);
                                        Toast.makeText(
                                                v.getContext(), "Item checked: " + checked.getText() + " is " + checked.isChecked(), Toast.LENGTH_LONG)
                                                .show();

                                }
                        });


                } else {
                        checked = (CheckBox) convertView.getTag();
                        tmp = (GroceryListItem) checked.getTag();
                        convertView.setTag(R.id.groceryListItemName,tmp.getItemId());

                }
                GroceryListItem current = groceryListItems.get(position);
                checked.setText(current.getItemType().getName()+" - "+current.getItemName()+" ("+current.getQuantity()+")");
                checked.setChecked(current.getCheckedState() == 1 ? true : false);
                checked.setTag(current);

                return convertView;


        }
}