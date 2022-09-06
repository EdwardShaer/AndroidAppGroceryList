package seclass.gatech.edu.glm;

import java.util.ArrayList;

/**
 * Created by SamuelSmall on 10/2/2016.
 */

public class GroceryList {
    private int id;
    private String name;
    private int userId;
    private ArrayList<GroceryListItem> groceryListItems;

    public GroceryList()
    {

    }
    public GroceryList(int userId, String name)
    {
        this.userId = userId;
        this.name = name;
        this.groceryListItems = new ArrayList<GroceryListItem>();
    }
    public GroceryList(int id, int userId, String name)
    {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.groceryListItems = new ArrayList<GroceryListItem>();
    }
    public void setGroceryListName(String name) {
        this.name = name;
    }
    public String getGroceryListName() {
        return name;
    }
    public void setUserId(int id)
    {
        this.userId = id;
    }
    public int getUserId(){
        return this.userId;
    }
    public int getGroceryListId(){
        return this.id;
    }
    public void setGroceryListId(int id) {this.id = id;}
    public void addItemToGroceryList(Item item) {
        GroceryListItem g = new GroceryListItem(item,getGroceryListId());
        this.groceryListItems.add(g);
    }
    public ArrayList<GroceryListItem> getGroceryListItems() {
        return this.groceryListItems;
    }
    public void setGroceryListItems(ArrayList<GroceryListItem>gListItems){
        this.groceryListItems = gListItems;
    }
    public void clearCheckedItems()
    {
        for(GroceryListItem gItem : this.groceryListItems){
            if(gItem.getCheckedState()==1)
                gItem.setCheckedState(0);
        }
    }
}
