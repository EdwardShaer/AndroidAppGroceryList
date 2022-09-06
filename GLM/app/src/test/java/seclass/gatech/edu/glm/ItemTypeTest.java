package seclass.gatech.edu.glm;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Prashanta on 10/12/16.
 */
public class ItemTypeTest {

    private ItemType itemType;

    @Before
    public void setUp() throws Exception {
        itemType = new ItemType(5, "Oats");
    }

    @After
    public void tearDown() throws Exception {
        itemType = null;
    }

    @Test
    public void setId() throws Exception {
        itemType.setId(25);
        assertEquals(25, itemType.getId());
    }

    @Test
    public void setName() throws Exception {
        itemType.setName("Cheerios");
        assertEquals("Cheerios", itemType.getName());
    }

    @Test
    public void getId() throws Exception {
        assertEquals(5, itemType.getId());
    }

    @Test
    public void getName() throws Exception {
        assertEquals("Oats", itemType.getName());
    }

}