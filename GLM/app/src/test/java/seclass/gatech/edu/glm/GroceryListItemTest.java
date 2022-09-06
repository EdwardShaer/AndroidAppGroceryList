package seclass.gatech.edu.glm;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by Prashanta on 10/12/16.
 */
public class GroceryListItemTest {

    private GroceryListItem groceryListItem;
    private Item item;
    private ItemType itemType;

    @Before
    public void setUp() throws Exception {
        this.itemType = new ItemType(1, "Test Itemtype");
        this.item = new Item(1, "Test Item", itemType);
        groceryListItem = new GroceryListItem(item, 1);
    }

    @After
    public void tearDown() throws Exception {
        groceryListItem = null;
        item = null;
        itemType = null;
    }

    @Test
    public void toStringTest() throws Exception {
        groceryListItem.setGroceryListID(55);
        assertNotEquals(15, groceryListItem.getGroceryListID());
    }

    @Test
    public void getCheckedState() throws Exception {
        assertEquals(0, groceryListItem.getCheckedState());
    }

    @Test
    public void setCheckedState() throws Exception {
        groceryListItem.setCheckedState(1);
        assertEquals(1, groceryListItem.getCheckedState());
    }

    @Test
    public void getQuantity1() throws Exception {
        assertEquals(1, groceryListItem.getQuantity());
    }

    @Test
    public void getQuantity2() throws Exception {
        groceryListItem.setQuantity(55);
        assertEquals(55, groceryListItem.getQuantity());
    }

    @Test
    public void setQuantity1() throws Exception {
        groceryListItem.setQuantity(65);
        assertEquals(65, groceryListItem.getQuantity());
    }

    @Test
    public void setQuantity2() throws Exception {
        groceryListItem.setQuantity(655);
        assertNotEquals(65, groceryListItem.getQuantity());
    }

    @Test
    public void getGroceryListID1() throws Exception {
        assertEquals(1, groceryListItem.getGroceryListID());
    }

    @Test
    public void getGroceryListID2() throws Exception {
        groceryListItem.setGroceryListID(250);
        assertNotEquals(25, groceryListItem.getGroceryListID());
    }

    @Test
    public void setGroceryListID1() throws Exception {
        groceryListItem.setGroceryListID(15);
        assertEquals(15, groceryListItem.getGroceryListID());
    }

    @Test
    public void setGroceryListID2() throws Exception {
        groceryListItem.setGroceryListID(55);
        assertNotEquals(15, groceryListItem.getGroceryListID());
    }
}