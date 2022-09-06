package seclass.gatech.edu.glm;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Prashanta on 10/12/16.
 */
public class ItemTest {

    private Item item;
    private ItemType itemType;
    private ItemType itemType2;

    @Before
    public void setUp() throws Exception {
        itemType = new ItemType(55, "Fruit");
        item = new Item(35, "Apple", itemType);
        itemType2 = new ItemType(5, "Ice Cream");
    }

    @After
    public void tearDown() throws Exception {
        item = null;
        itemType = null;
        itemType2 = null;
    }

    @Test
    public void toStringTest() throws Exception {
        assertEquals("Apple || Fruit", item.getItemName() + " || " + itemType.getName());
    }

    @Test
    public void getItemTypeNameTest() throws Exception {
        assertEquals("Ice Cream", itemType2.getName());
    }

    @Test
    public void getItemTypeId() throws Exception {
        assertEquals(5, itemType2.getId());
    }

    @Test
    public void setItemType() throws Exception {
        item.setItemType(itemType2);
        //assertEquals(itemType2, item.getItemType());
        assertEquals(5, item.getItemType().getId());
    }

    @Test
    public void getItemType() throws Exception {
        //item.setItemType(itemType);
        assertEquals("Fruit", item.getItemType().getName());
    }

    @Test
    public void setItemId() throws Exception {
        item.setItemId(25);
        assertEquals(25, item.getItemId());
    }

    @Test
    public void getItemId() throws Exception {
        assertEquals(35, item.getItemId());
    }

    @Test
    public void setItemName() throws Exception {
        item.setItemName("Banana");
        assertEquals("Banana", item.getItemName());
    }

    @Test
    public void getItemName() throws Exception {
        assertEquals("Apple", item.getItemName());
    }
}