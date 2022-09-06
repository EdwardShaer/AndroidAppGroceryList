package seclass.gatech.edu.glm;

import java.util.ArrayList;

/**
 * Created by SamuelSmall on 10/2/2016.
 */

public class User {
    private int id;
    private String name;
    private ArrayList<GroceryList> groceryLists;

    public User()
    {

    }
    public User(int id, String name)
    {
        this.id = id;
        this.name = name;
    }
    public User(int id, String name, ArrayList<GroceryList> groceryLists)
    {
        this.id = id;
        this.name = name;
        this.groceryLists = groceryLists;
    }
    public User(String name)
    {
        this.name = name;
        this.groceryLists = new ArrayList<GroceryList>();
    }
    public void setId(int id) {this.id=id;}
    public void setName(String name) {this.name = name;}
    public void setGroceryLists(ArrayList<GroceryList> groceryLists) { this.groceryLists = groceryLists;}
    public int getId() {return id;}
    public String getName() {return name;}
    public ArrayList<GroceryList> getGroceryLists() { return groceryLists; }

    public GroceryList getList(int groceryListId)
    {
        return this.groceryLists.get(groceryListId);
    }
        public void saveList(GroceryList g)
    {
        this.groceryLists.add(g);
    }
    public void deleteList(int groceryListId)
    {
        this.groceryLists.remove(groceryListId);
    }
}
