package seclass.gatech.edu.glm;

/**
 * Created by SamuelSmall on 10/2/2016.
 */

public class Item {
    private int id;
    private String name;
    private ItemType itemType;

    public Item()
    {

    }
    public Item(String name, ItemType itemType) {
        this.name = name;
        this.itemType = itemType;
    }
    public Item(int id, String name, ItemType itemType)
    {
        this.id = id;
        this.name = name;
        this.itemType = itemType;
    }

    public void setItemId(int id) {
        this.id=id;
    }
    public int getItemId() {
        return id;
    }
    public void setItemName(String name) {
        this.name = name;
    }
    public String getItemName() {
        return name;
    }
    public ItemType getItemType(){
        return itemType;
    }
    public String getItemTypeName(){
        return itemType.getName();
    }
    public void setItemType(ItemType itemType)
    {
        this.itemType = itemType;
    }
    public int getItemTypeId() {return this.itemType.getId();}

    public String toString() {
        return this.getItemName();
//        return this.getItemName()+" || "+this.getItemTypeName();
    }

}
