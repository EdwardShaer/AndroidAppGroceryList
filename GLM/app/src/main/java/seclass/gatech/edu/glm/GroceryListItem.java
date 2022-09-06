package seclass.gatech.edu.glm;

/**
 * Created by SamuelSmall on 10/2/2016.
 */

public class GroceryListItem extends Item implements Comparable {
    private int id;
    private int groceryListID;
    private int quantity;
    private int itemChecked = 0;

    public GroceryListItem()
    {

    }
    public GroceryListItem(Item item, int groceryListID) {
        super(item.getItemId(), item.getItemName(), item.getItemType());
        this.quantity=1;
        this.groceryListID = groceryListID;
    }
    public GroceryListItem(int id, Item item, int groceryListID) {
        super(item.getItemId(), item.getItemName(), item.getItemType());
        this.id = id;
        this.quantity = 1;
        this.groceryListID = groceryListID;
    }
    public int getCheckedState() {
        return this.itemChecked;
    }
    public void setCheckedState(int checkedState){
        this.itemChecked = checkedState;
    }
    public int getQuantity(){
        return this.quantity;
    }
    public void setQuantity(int q)
    {
        this.quantity = q;
    }
    public int getGroceryListID()
    {
        return this.groceryListID;
    }
    public void setGroceryListID(int id)
    {
        this.groceryListID = id;
    }
    public int getGroceryListItemID() {return this.id;}


    @Override
    public int compareTo(Object o) {
        GroceryListItem itemA = (GroceryListItem) o;
        int compareType=itemA.getItemTypeId()+1;
        int comparedTo = this.getItemTypeId()+1;
        /* For Ascending order, reverse for descending*/
        return comparedTo-compareType;
    }

    @Override
    public String toString() {
       return this.getItemName();
    }
}
