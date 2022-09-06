# **Requirements Document**

<table>
  <tr>
    <td>Author</td>
    <td>Version </td>
    <td>Date</td>
    <td>Comments</td>
  </tr>
  <tr>
    <td>Team 71</td>
    <td>1.1</td>
    <td>10/13/2016</td>
    <td>Decomposed original requirements into more finite set
Adjusted extra requirements (added one, moved a few to future requirements)</td>
  </tr>
  <tr>
    <td>Team 71</td>
    <td>1.0</td>
    <td>10/05/2016</td>
    <td>Initial draft</td>
  </tr>
</table>


## **Original Requirements**

1. A grocery list consists of items the users want to buy at a grocery store. The application must allow users to add items to a list, delete items from a list, and change the quantity of items in the list (e.g., change from one to two pounds of apples).

    1. Allow users to add items to a list

    2. Allow users to delete items from a list

    3. Allow users to change the quantity of items in the list (e.g., change from one to two pounds of apples).

2. The application must contain a database (DB) of *items* and corresponding *item types*.

3. Users must be able to add items to a list by picking them from a hierarchical list, where the first level is the item type (e.g., cereal), and the second level is the name of the actual item (e.g., shredded wheat). After adding an item, users must be able to specify a quantity for that item.

    4. Users must be able to add items to a list by picking them from a hierarchical list, where the first level is the item type (e.g., cereal), and the second level is the name of the actual item (e.g., shredded wheat).

    5. After adding an item, users must be able to specify a quantity for that item.

4. Users must also be able to specify an item by typing its name. In this case, the application must look in its DB for items with similar names and ask the users, for each of them, whether that is the item they intended to add. If a match cannot be found, the application must ask the user to select a type for the item and then save the new item, together with its type, in its DB.

    6. Users must also be able to specify an item by typing its name. In this case, the application must look in its DB for items with similar names and ask the users, for each of them, whether that is the item they intended to add.

    7. If a match cannot be found, the application must ask the user to select a type for the item and then save the new item, together with its type, in its DB.

5. Lists must be saved automatically and immediately after they are modified.

6. Users must be able to check off items in a list (without deleting them).

7. Users must also be able to clear all the check-off marks in a list at once.

8. Check-off marks for a list are persistent and must also be saved immediately.

9. The application must present the items in a list grouped by type, so as to allow users to shop for a specific type of products at once (i.e., without having to go back and forth between aisles).

10. The application must support multiple lists at a time (e.g., "weekly grocery list", “monthly farmer’s market list”). Therefore, the application must provide the users with the ability to create, (rename, select, and delete lists.

    8. Provide the users with the ability to create lists

    9. Provide the users with the ability to rename lists

    10. Provide the users with the ability to select lists

    11. Provide the users with the ability to delete lists

11. The User Interface (UI) must be intuitive and responsive.

## **Extra Requirements**

1. **Functional:**

    1. Disallow adding an item to a list on two separate lines

    2. Instead of requiring a modal to pick quantity, default to 1 and allow the user to choose to change later

2. **Performance (Non-Functional):**

    3. Allow up to 1000 items in a grocery list

    4. Allow up to 10 separate grocery lists

    5. Uncheck all items within 10 seconds

3. **Possible Future Enhancements:**

    6. Allow user login and authentication

    7. Allow grocery lists stored against a user profile

    8. Allow user account creation and user account deletion

    9. Allow fingerprint login

    10. Allow checking all items within a item type

    11. Allow checking all items

    12. Collapsing the item types on the UI

    13. Price comparison by scanning the item barcodes

    14. Sort by checked/unchecked

    15. Filter checked/unchecked

    16. Quantity is configurable to either count or pounds (default count) for any item in the library (not as added to grocery list)

