package seclass.gatech.edu.glm;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by Prashanta on 10/12/16.
 */
public class GroceryListTest {

    //https://coderanch.com/t/515213/JUnit-tests-Getters-Setters
    //http://stackoverflow.com/questions/21354311/junit-test-of-setters-and-getters-of-instance-variables

    private GroceryList groceryList;
    private GroceryListItem groceryListItem;
    private Item item;
    private ItemType itemType;

    @Before
    public void setUp() {
        //this constructor adds an ArrayList of type GroceryListItem
        groceryList = new GroceryList(6, 67, "Brunch");
        itemType = new ItemType(25, "Fruits");
        item = new Item(14, "Banana", itemType);
        groceryListItem = new GroceryListItem(55, item, 45);
        //gets the ArrayList of GroceryListItems and then adds an GroceryListItem to it
        groceryList.getGroceryListItems().add(groceryListItem);
    }

    @After
    public void tearDown() {
        groceryList = null;
        itemType = null;
        item = null;
        groceryListItem = null;
    }

    @Test
    public void getGroceryListItemsTest() {
        //System.out.println(groceryList.getGroceryListItems().size());
        assertEquals("Banana", groceryList.getGroceryListItems().get(0).getItemName());
        assertEquals(45, groceryList.getGroceryListItems().get(0).getGroceryListID());
    }

    @Test
    public void setGroceryListNameTest() throws Exception {
        GroceryListItem gli2 = new GroceryListItem(25, item, 36);
        ArrayList<GroceryListItem> groceryListItems2 = new ArrayList<>();
        groceryListItems2.add(gli2);
        groceryList.setGroceryListItems(groceryListItems2);
        //System.out.println(groceryList.getGroceryListItems().size());
        assertEquals(36, groceryList.getGroceryListItems().get(0).getGroceryListID());
    }

    @Test
    public void addItemToGroceryListTest() throws Exception {
        ItemType itemType2 = new ItemType(55, "Juice");
        Item item2 = new Item(99, "Orange Juice", itemType2);
        groceryList.addItemToGroceryList(item2);

        //System.out.println(groceryList.getGroceryListItems().size());

        assertEquals(2, groceryList.getGroceryListItems().size());

        //tests the itemID
        assertEquals(99, groceryList.getGroceryListItems().get(1).getItemId());
        //tests the itemName
        assertEquals("Orange Juice", groceryList.getGroceryListItems().get(1).getItemName());
        //tests the itemTypeID
        assertEquals(55, groceryList.getGroceryListItems().get(1).getItemTypeId());
        //tests the itemType
        assertEquals("Juice", groceryList.getGroceryListItems().get(1).getItemTypeName());
    }

    @Test
    public void clearCheckedItemsTest() throws Exception {
        //System.out.println(groceryList.getGroceryListItems().size());
        groceryList.clearCheckedItems();
        assertEquals(0, groceryList.getGroceryListItems().get(0).getCheckedState());
    }

    @Test
    public void getGroceryListNameTest1() throws Exception {
        assertEquals("Brunch", groceryList.getGroceryListName());
    }

    @Test
    public void getGroceryListNameTest2() throws Exception {
        assertNotEquals("Birthday", groceryList.getGroceryListName());
    }

    @Test
    public void setUserIdTest1() throws Exception {
        groceryList.setUserId(99);
        assertEquals(99, groceryList.getUserId());
    }

    @Test
    public void setUserIdTest2() throws Exception {
        groceryList.setUserId(55);
        assertNotEquals(99, groceryList.getUserId());
    }

    @Test
    public void getUserIdTest1() throws Exception {
        assertEquals(67, groceryList.getUserId());
    }

    @Test
    public void getUserIdTest2() throws Exception {
        assertNotEquals(25, groceryList.getUserId());
    }

    @Test
    public void setGroceryListIdTest1() throws Exception {
        groceryList.setGroceryListId(45);
        assertEquals(45, groceryList.getGroceryListId());
    }

    @Test
    public void setGroceryListIdTest2() throws Exception {
        groceryList.setGroceryListId(45);
        assertNotEquals(55, groceryList.getGroceryListId());
    }

    @Test
    public void getGroceryListIdTest1() throws Exception {
        groceryList.setGroceryListId(45);
        assertEquals(45, groceryList.getGroceryListId());
    }

    @Test
    public void getGroceryListIdTest2() throws Exception {
        groceryList.setGroceryListId(45);
        assertNotEquals(55, groceryList.getGroceryListId());
    }
}