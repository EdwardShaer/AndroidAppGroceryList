package seclass.gatech.edu.glm;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Prashanta on 10/12/16.
 */
public class UserTest {

    private User user;
    private ArrayList<GroceryList> groceryLists = new ArrayList<GroceryList>();
    private GroceryList groceryList;

    @Before
    public void setUp() throws Exception {
        user = new User(7, "Tom");
        groceryList = new GroceryList(5, 12, "Weekly");
        groceryLists.add(groceryList);
        user.setGroceryLists(groceryLists);
    }

    @After
    public void tearDown() throws Exception {
        user = null;
        groceryList = null;
        groceryLists = null;
    }

    @Test
    public void deleteListTest() throws Exception {
        //After deletion the list will have 0 groceryList item
        user.deleteList(0);
        assertEquals(0, groceryLists.size());
    }

    @Test
    public void deleteListTest2() throws Exception {
        /*the use has one GroceryList item from setUp and now one is added
        so the size of teh groceryLists now is 3*/
        for (int i = 1; i < 3; i++) {
            GroceryList gl1 = new GroceryList(34 + 2*i, 35 + 3*i, "Farmers Market " + i);
            user.saveList(gl1);
        }
        user.deleteList(0); //this makes the size 0 now
        assertEquals(2, groceryLists.size());
        /**
         * after the deletion of the first element the second moves to first position and the
         * third one moves to the second position
         */
        assertEquals(36, user.getList(0).getGroceryListId());
        assertEquals("Farmers Market 1", user.getList(0).getGroceryListName());
        assertEquals(38, user.getList(0).getUserId());

        assertEquals(38, user.getList(1).getGroceryListId());
        assertEquals("Farmers Market 2", user.getList(1).getGroceryListName());
        assertEquals(41, user.getList(1).getUserId());
    }

    //Hacky test
    @Test
    public void getListTest() throws Exception {
        //use the array index for parameter of getList
        assertEquals(12, user.getList(0).getUserId());
        assertEquals(5, user.getList(0).getGroceryListId());
    }

    @Test
    public void saveListTest() throws Exception {
        GroceryList gl = new GroceryList(34, 35, "Farmers Market");
        user.saveList(gl);
        /*the use has one GroceryList item from setUp and now one is added
        so the size of teh groceryLists now is 2*/
        assertEquals(2, groceryLists.size());

        //test the grocery list id
        assertEquals(34, user.getList(1).getGroceryListId());

        /**
         * the use has one GroceryList item from setUp and now one is added
         * so the size of teh groceryList now is 4
         */
        for (int i = 1; i < 3; i++) {
            GroceryList gl1 = new GroceryList(34, 35, "Farmers Market");
            user.saveList(gl1);
        }
        assertEquals(4, groceryLists.size());
    }

    @Test
    public void getGroceryListsTest() throws Exception {
        assertEquals(12, user.getGroceryLists().get(0).getUserId());
    }

    @Test
    public void setGroceryListsTest() throws Exception {
        GroceryList groceryList1 = new GroceryList(5, 22, "Weekly");
        groceryLists.add(groceryList1);
        user.setGroceryLists(groceryLists);
        assertEquals(22, user.getGroceryLists().get(1).getUserId());
    }

    @Test
    public void setIdTest() throws Exception {
        user.setId(9);
        assertEquals(9, user.getId());
    }

    @Test
    public void setNameTest() throws Exception {
        user.setName("Mat");
        assertEquals("Mat", user.getName());
    }

    @Test
    public void getIdTest() throws Exception {
        assertEquals(7, user.getId());
    }

    @Test
    public void getNameTest() throws Exception {
        assertEquals("Tom", user.getName());
    }
}