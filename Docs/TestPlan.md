


## **1 Testing Strategy**

### **1.1 Overall strategy**

The Grocery List Manager ® is tested through manual and automatic testing methods. The following areas highlight the testing approach:

    1. Unit Testing - As code is added, JUnit tests will be incorporated that run against the specific code they have developed for that portion of the application. The developer will employ Test Driven Development (TDD) such that they will first write the test case and later develop code to ensure the functionality is met and all tests have passed.

    2. Integration - For some key, complex functions, the developers will expand upon the single class JUnit tests to examine class interdependencies and database interactions. For example, the method of adding a new item (which would also add this to the grocery list) incorporates the database interaction and multiple classes.

    3. System - Perform manual system tests based on test cases.

    4. Regression - Incrementally test the application by rerunning all JUnit tests and manual test cases to catch regressions early and often.

### **1.2 Test Selection**

The test strategy will use both black-box and and white-box techniques. The white box testing will focus more on unit tests, while the black box testing will focus on system tests. While Performance Testing is very important to the application, it is expected to manually test performance with manually run test cases since the application is not judged to be at a high risk of performance issues.

    1. Black Box tests

        1. Manually run system test cases

    2. White Box tests

        2. JUnit tests

    3. Performance tests

        3. Manually run system test cases

### **1.3 Adequacy Criterion**

We want to make sure the testing covers all critical aspects of the system. While we will not plan to test 100% of the code, we want to have a good functional and structural coverage. The following table identifies the requirements and their test coverage through manual test cards and automated JUnit tests:

<table>
  <tr>
    <td>#</td>
    <td>Requirement Text</td>
    <td>Test Card</td>
    <td>JUnit Test</td>
  </tr>
  <tr>
    <td>1</td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>1.1</td>
    <td>Allow users to add items to a list</td>
    <td>D</td>
    <td></td>
  </tr>
  <tr>
    <td>1.2</td>
    <td>Allow users to delete items from a list</td>
    <td>G</td>
    <td></td>
  </tr>
  <tr>
    <td>1.3</td>
    <td>Allow users to change the quantity of items in the list (e.g., change from one to two pounds of apples)</td>
    <td>H</td>
    <td></td>
  </tr>
  <tr>
    <td>2</td>
    <td>The application must contain a database (DB) of items and corresponding item types</td>
    <td>N/A</td>
    <td></td>
  </tr>
  <tr>
    <td>3</td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>3.1</td>
    <td>Users must be able to add items to a list by picking them from a hierarchical list, where the first level is the item type (e.g., cereal), and the second level is the name of the actual item (e.g., shredded wheat).</td>
    <td>D</td>
    <td></td>
  </tr>
  <tr>
    <td>3.2</td>
    <td>After adding an item, users must be able to specify a quantity for that item.</td>
    <td>H</td>
    <td></td>
  </tr>
  <tr>
    <td>4</td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>4.1</td>
    <td>Users must also be able to specify an item by typing its name. In this case, the application must look in its DB for items with similar names and ask the users, for each of them, whether that is the item they intended to add.</td>
    <td>E</td>
    <td></td>
  </tr>
  <tr>
    <td>4.2</td>
    <td>If a match cannot be found, the application must ask the user to select a type for the item and then save the new item, together with its type, in its DB.</td>
    <td>F</td>
    <td></td>
  </tr>
  <tr>
    <td>5</td>
    <td>Lists must be saved automatically and immediately after they are modified.</td>
    <td>N</td>
    <td></td>
  </tr>
  <tr>
    <td>6</td>
    <td>Users must be able to check off items in a list (without deleting them).</td>
    <td>I</td>
    <td></td>
  </tr>
  <tr>
    <td>7</td>
    <td>Users must also be able to clear all the check-off marks in a list at once.</td>
    <td>J, K</td>
    <td></td>
  </tr>
  <tr>
    <td>8</td>
    <td>Check-off marks for a list are persistent and must also be saved immediately</td>
    <td>N</td>
    <td></td>
  </tr>
  <tr>
    <td>9</td>
    <td>The application must present the items in a list grouped by type, so as to allow users to shop for a specific type of products at once (i.e., without having to go back and forth between aisles).</td>
    <td>L</td>
    <td></td>
  </tr>
  <tr>
    <td>10.1</td>
    <td>Provide the users with the ability to create lists</td>
    <td>A</td>
    <td></td>
  </tr>
  <tr>
    <td>10.2</td>
    <td>Provide the users with the ability to rename lists</td>
    <td>B</td>
    <td></td>
  </tr>
  <tr>
    <td>10.3</td>
    <td>Provide the users with the ability to select lists</td>
    <td>L</td>
    <td></td>
  </tr>
  <tr>
    <td>10.4</td>
    <td>Provide the users with the ability to delete lists</td>
    <td>C</td>
    <td></td>
  </tr>
  <tr>
    <td>11</td>
    <td>The User Interface (UI) must be intuitive and responsive.</td>
    <td>M</td>
    <td></td>
  </tr>
</table>


### **1.4 Bug Tracking**

We plan to use a common Trello project to track bugs. Bugs will stand out separately from other user stories and feature improvements, as we will use a distinct color (RED) to highlight these. We will link bugs to their original user story for traceability.

### **1.5 Technology**

JUnit is the primary technology used for testing the application. The JUnit tests will be written as a white box test against particular methods of a class. The JUnit tests will incorporate individual class tests, as well as tests that will utilize the SqLite database calls.

Other technologies considered, but ultimately rejected included:

* Espresso

* Dumpsys

* Cucumber

## **2 Test Cases**

The following table of test cases provide each test’s purpose and the steps necessary to perform the test. Later versions will fill in the expected result, the actual result (to be filled later), pass/fail information (to be filled later), and any additional relevant information.

### Black Box Manual Tests

The following list is comprised of test cards. Each test card represents a distinct feature within the application.

1. Add a Grocery List Test Card

<table>
  <tr>
    <td>Test Step</td>
    <td>Expected Result</td>
    <td>Actual Result</td>
    <td>Result</td>
  </tr>
  <tr>
    <td>Open the application to view the list of grocery lists</td>
    <td>No grocery lists are displayed</td>
    <td>Default list "test" is displayed</td>
    <td>F</td>
  </tr>
  <tr>
    <td>Add a grocery list named “Test”</td>
    <td>Toast message saying grocery list “Test” has been created</td>
    <td>Toast message received</td>
    <td>P</td>
  </tr>
  <tr>
    <td>Open the application to view the list of grocery lists</td>
    <td>Only a single grocery list is displayed named “Test”</td>
    <td>Newly created “Test” grocery list is present</td>
    <td>P</td>
  </tr>
</table>


2. Rename a Grocery List Test Card

<table>
  <tr>
    <td>Test Step</td>
    <td>Expected Result</td>
    <td>Actual Result</td>
    <td>Result</td>
  </tr>
  <tr>
    <td>Open the application to view the list of grocery lists (create a new list if none are present)</td>
    <td>See any previously generated grocery lists, or if none then see no grocery lists displayed</td>
    <td>Grocery lists are displayed</td>
    <td>P</td>
  </tr>
  <tr>
    <td>Open the grocery list and ensure items are added to the list, record number of items, their checked state, and their quantity</td>
    <td>N/A</td>
    <td>Not yet tested</td>
    <td>F</td>
  </tr>
  <tr>
    <td>Rename the grocery list by appending "renamed" to the end of the current list name</td>
    <td>* Toast message confirms the grocery list is renamed
* Updated grocery list name shows up on list of grocery list</td>
    <td>* Toast message received
* “Testrenamed” grocery list shows up</td>
    <td>P</td>
  </tr>
  <tr>
    <td>Open the grocery list and ensure items, quantity, and checked state matches</td>
    <td>* All items remain
* All quantities are the same
* All checked states are the same</td>
    <td>Not yet tested</td>
    <td>F</td>
  </tr>
</table>


3. Delete a Grocery List Test Card

<table>
  <tr>
    <td>Test Step</td>
    <td>Expected Result</td>
    <td>Actual Result</td>
    <td>Result</td>
  </tr>
  <tr>
    <td>Open the application to view the list of grocery lists (create a new list if none are present)</td>
    <td>See any previously generated grocery lists, or if none then see no grocery lists displayed</td>
    <td>Grocery lists are displayed</td>
    <td>P</td>
  </tr>
  <tr>
    <td>Open the grocery list and ensure at least one item is added to the list, record the name of this item</td>
    <td>N/A</td>
    <td>Not yet tested</td>
    <td>F</td>
  </tr>
  <tr>
    <td>Delete the grocery list</td>
    <td>* A toast message confirms the deletion
* The list of grocery lists no longer shows this grocery list</td>
    <td>* Toast message shows
* Deleted list is no longer displayed</td>
    <td>P</td>
  </tr>
  <tr>
    <td>Open a separate grocery list or create a new one, attempt to add the recorded item to this list to ensure it is still a valid list item </td>
    <td>* The item may be added to the grocery list (meaning deleting it from one list only deleted the grocery list item, not the item)</td>
    <td>Not yet tested</td>
    <td>F</td>
  </tr>
</table>


4. Adding a Grocery List Item (Exact Match) Test Card

<table>
  <tr>
    <td>Test Step</td>
    <td>Expected Result</td>
    <td>Actual Result</td>
    <td>Result</td>
  </tr>
  <tr>
    <td>Open the application and create a new blank grocery list, then open it</td>
    <td>No items are displayed</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Select the search function to add an item to the list, start typing the value of a known, pre-populated item: "Apples"</td>
    <td>The term “Apples” shows up in the search results</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Select the matching item to add it to the list</td>
    <td>* The list is updated with the newly added item
* The newly added item shows a quantity of 1
* A toast message confirms your addition</td>
    <td></td>
    <td></td>
  </tr>
</table>


5. Adding a Grocery List Item (Similar Match) Test Card

<table>
  <tr>
    <td>Test Step</td>
    <td>Expected Result</td>
    <td>Actual Result</td>
    <td>Result</td>
  </tr>
  <tr>
    <td>Open the application and create a new blank grocery list, then open it</td>
    <td>No items are displayed</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Start typing the value of a known, pre-populated item that appears in two item names: "Baking"</td>
    <td>At least two items display: “Baking Soda” and “Baking Powder”</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Select the one of the matching items to add it to the list</td>
    <td>* The list is updated with the newly added item
* The newly added item shows a quantity of 1
* A toast message confirms your addition</td>
    <td></td>
    <td></td>
  </tr>
</table>


6. Adding a New Item to Database Test Card

<table>
  <tr>
    <td>Test Step</td>
    <td>Expected Result</td>
    <td>Actual Result</td>
    <td>Result</td>
  </tr>
  <tr>
    <td>Open the application and create a new blank grocery list, then open it</td>
    <td>No items are displayed</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Start typing the value of a known, non-existing item that you know is not in the database (trying something like "12345678".</td>
    <td>* See the term “No matching results”
* See a note “Do you want to add 12345678 to the set of items?”</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>User is able to select the item type for the to-be-added item</td>
    <td>See drop down showing item types to be selected</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>User is able to save their addition</td>
    <td>* A toast message appears telling the user their item is saved
* The item is added to the grocery list
* The item is saved, allowing adding to another list</td>
    <td></td>
    <td></td>
  </tr>
</table>


7. Deleting an Item from Grocery List Test Card

<table>
  <tr>
    <td>Test Step</td>
    <td>Expected Result</td>
    <td>Actual Result</td>
    <td>Result</td>
  </tr>
  <tr>
    <td>Open the application and open a grocery list with at least one item added</td>
    <td>The item(s) are displayed for that grocery list</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Select an item and long press</td>
    <td>See options to act on the grocery list item</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Select the delete command</td>
    <td>* The item is removed from the grocery list 
* A toast message confirms this removal</td>
    <td></td>
    <td></td>
  </tr>
</table>


8. Change Quantity of Items on Grocery List Test Card

<table>
  <tr>
    <td>Test Step</td>
    <td>Expected Result</td>
    <td>Actual Result</td>
    <td>Result</td>
  </tr>
  <tr>
    <td>Open the application and open a grocery list with at least one item added</td>
    <td>The item(s) are displayed for that grocery list</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Select an item and long press</td>
    <td>See options to act on the grocery list item</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Select the change quantity command and increase the count by 1</td>
    <td>* The quantity is increased by 1
* A toast message confirms this removal</td>
    <td></td>
    <td></td>
  </tr>
</table>


9. Check off an Item on Grocery List Test Card

<table>
  <tr>
    <td>Test Step</td>
    <td>Expected Result</td>
    <td>Actual Result</td>
    <td>Result</td>
  </tr>
  <tr>
    <td>Open the application and open a grocery list with at least one item added</td>
    <td>The item(s) are displayed for that grocery list</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Check off an item</td>
    <td>* The check box turns from the unchecked to checked state</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Leave the grocery list item, and open it back up</td>
    <td>* The checked state remains</td>
    <td></td>
    <td></td>
  </tr>
</table>


10. Uncheck an Item on Grocery List Test Card

<table>
  <tr>
    <td>Test Step</td>
    <td>Expected Result</td>
    <td>Actual Result</td>
    <td>Result</td>
  </tr>
  <tr>
    <td>Open the application and open a grocery list with at least one item added</td>
    <td>The item(s) are displayed for that grocery list</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Check off an item</td>
    <td>* The check box turns from the unchecked to checked state</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Leave the grocery list item, and open it back up</td>
    <td>* The checked state remains</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Uncheck an item</td>
    <td>* The check box turns from the checked to unchecked state</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Leave the grocery list item, and open it back up</td>
    <td>* The unchecked state remains</td>
    <td></td>
    <td></td>
  </tr>
</table>


11. Uncheck all Items on Grocery List Test Card

<table>
  <tr>
    <td>Test Step</td>
    <td>Expected Result</td>
    <td>Actual Result</td>
    <td>Result</td>
  </tr>
  <tr>
    <td>Open the application and open a grocery list with at least three item added</td>
    <td>The item(s) are displayed for that grocery list</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Manually check off two but not three of the items</td>
    <td>* Two items are in the checked state</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Click the uncheck all items button</td>
    <td>* All three items show unchecked</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Manually check off all three items </td>
    <td>* Two items are in the checked state</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Click the uncheck all items button</td>
    <td>* All three items show unchecked</td>
    <td></td>
    <td></td>
  </tr>
</table>


12. View a Grocery List Test Card

<table>
  <tr>
    <td>Test Step</td>
    <td>Expected Result</td>
    <td>Actual Result</td>
    <td>Result</td>
  </tr>
  <tr>
    <td>Open the application and create a new blank grocery list, then open it</td>
    <td>No items are displayed</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Add 6 items, two from each of three item types (e.g., 2 fruit, 2 vegetables, 3 meat)</td>
    <td>All 6 items are displayed</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Ensure the items are grouped by item type</td>
    <td>* The two items from the first item type are grouped together
* The two items from the second item type are grouped together
* The two items from the third item type are grouped together</td>
    <td></td>
    <td></td>
  </tr>
</table>


13. Performance / Feedback Test Card

<table>
  <tr>
    <td>Test Step</td>
    <td>Expected Result</td>
    <td>Actual Result</td>
    <td>Result</td>
  </tr>
  <tr>
    <td>Open the application and create a grocery list</td>
    <td>The grocery list is created within 3 seconds</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Search for an item</td>
    <td>The search results are presented within 3 seconds</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Add an item to the grocery list</td>
    <td>The item is added and grocery list updated within 3 seconds</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Change the quantity of an item</td>
    <td>The grocery list is updated within 3 seconds</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Remove an item from the grocery list</td>
    <td>The item is removed and grocery list updated within 3 seconds</td>
    <td></td>
    <td></td>
  </tr>
</table>


14. Data Persistence Test Card

<table>
  <tr>
    <td>Test Step</td>
    <td>Expected Result</td>
    <td>Actual Result</td>
    <td>Result</td>
  </tr>
  <tr>
    <td>Open the application and create a grocery list</td>
    <td>The grocery list displays on the list of grocery lists</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Close the application, then reopen to view the list of grocery lists</td>
    <td>Your newly added list remains</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Add an item to the grocery list</td>
    <td>The grocery list displays the newly added item</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Close the application, then reopen and open the grocery list</td>
    <td>Your newly added item is on the grocery list</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Change the quantity of the added item</td>
    <td>The grocery list displays the updated quantity</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Close the application, then reopen and open the grocery list</td>
    <td>Your newly updated quantity is on the grocery list</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Search for an item that doesn’t match, and add the item to the database</td>
    <td>The item is searchable when adding to a new grocery list</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Close the application, then reopen and open the grocery list to search for the item</td>
    <td>Your newly added item displays on the search results</td>
    <td></td>
    <td></td>
  </tr>
</table>


15. Attempt to Add Grocery List with Duplicate Name Test Card

<table>
  <tr>
    <td>Test Step</td>
    <td>Expected Result</td>
    <td>Actual Result</td>
    <td>Result</td>
  </tr>
  <tr>
    <td>Open the application to view the list of grocery lists</td>
    <td>No grocery lists are displayed</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Add a grocery list named "Test"</td>
    <td>Toast message saying grocery list “Test” has been created</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Open the application to view the list of grocery lists</td>
    <td>Only a single grocery list is displayed named “Test”</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Add a second grocery list named “Test”</td>
    <td>This should work - allowed to have duplicate names</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Open the application to view the list of grocery lists</td>
    <td>Both grocery lists is displayed named “Test”</td>
    <td></td>
    <td></td>
  </tr>
</table>


16. Attempt to Add Grocery List Item Twice Test Card

<table>
  <tr>
    <td>Test Step</td>
    <td>Expected Result</td>
    <td>Actual Result</td>
    <td>Result</td>
  </tr>
  <tr>
    <td>Open the application and create a new blank grocery list, then open it</td>
    <td>No items are displayed</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Select the search function to add an item to the list, start typing the value of a known, pre-populated item: "Apples"</td>
    <td>The term “Apples” shows up in the search results</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Select the matching item to add it to the list</td>
    <td>* The list is updated with the newly added item
* The newly added item shows a quantity of 1
* A toast message confirms your addition</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Select the search function to add an item to the list, start typing the value of a known, pre-populated item: “Apples”</td>
    <td>The term “Apples” shows up in the search results</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Select the matching item to add it to the list</td>
    <td>* The existing item’s quantity is updated
* The item “apples” shows up once in the grocery list</td>
    <td></td>
    <td></td>
  </tr>
</table>


### White Box JUnit Tests

<table>
  <tr>
    <td>Purpose</td>
    <td>Steps</td>
    <td>Expected Result</td>
    <td>Pass/Fail</td>
    <td>Tester Name</td>
  </tr>
  <tr>
    <td>Handle invalid GroceryList names</td>
    <td>getList(listThatDoesntExist)</td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Handle invalid GroceryList names</td>
    <td>deleteList(listThatDoesntExist)</td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Properly handle correct names</td>
    <td>getList(listThatDoesExist)</td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Properly handle correct names</td>
    <td>getList(listThatDoesExist)</td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Can't have two lists of same name</td>
    <td>List1.setListName(x), then List2.setListName(x)</td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Function works</td>
    <td>List1.setListName(x) for valid x</td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Function works</td>
    <td>getListName() from any List when Name has been changed</td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Function works</td>
    <td>getListName() from any List when Name has NOT been changed</td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Invalid parameter test</td>
    <td>addItem(ItemDoesntExist)</td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Invalid parameter test</td>
    <td>removeItem(ItemDoesntExist)</td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>No negative quantities</td>
    <td>run setQuantity(-1) </td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>No bug when nothing is checked</td>
    <td>uncheckAllListItems() when nothing is checked</td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Function works</td>
    <td>uncheckAllListItems() when something is checked</td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Function works</td>
    <td>getQuantity() when quantity > 0</td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Function works</td>
    <td>getQuantity() when quantity == 0</td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Function works</td>
    <td>getCheckedState() when unchecked</td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Function works</td>
    <td>getCheckedState() when checked</td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Invalid parameter test</td>
    <td>setQuantity(x) where x is negative</td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Special parameter test</td>
    <td>setQuantity(x) where x is 0</td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Function works</td>
    <td>setQuantity(x) where x is positive</td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Function works</td>
    <td>toggleChecked(item) where item is checked</td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Function works</td>
    <td>toggleChecked(item) where item is unchecked</td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Function works</td>
    <td>getItemName()</td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Function works</td>
    <td>setItemName(newName) then getItemName()</td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Invalid parameter test</td>
    <td>setItemName(anythingWeDontWant)</td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Function works</td>
    <td>getItemType()</td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Function works</td>
    <td>setItemType(ValidType) then getItemType()</td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Invalid parameter test</td>
    <td>setItemType(TypeThatDoesntExist)</td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Function works</td>
    <td>setItemTypeName(valid String) then getItemTypeName()</td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Invalid parameter test</td>
    <td>setItemTypeName(int)</td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Function works</td>
    <td>getItemTypeName()</td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>HighLevelAppTesting-Registration</td>
    <td>Register with invalid username</td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>HighLevelAppTesting-Registration</td>
    <td>Register with valid username and invalid password</td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>HighLevelAppTesting-Registration</td>
    <td>Register with valid both</td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>HighLevelAppTesting-Login</td>
    <td>Sign in with invalid username</td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>HighLevelAppTesting-Login</td>
    <td>Sign in with valid username and invalid password</td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>HighLevelAppTesting-Login</td>
    <td>Sign in with valid both</td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>HighLevelAppTesting-Logout</td>
    <td>Logout and make sure system inaccessible without login</td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>HighLevelAppTesting-Operations</td>
    <td>Choose a grocery list item with Quantity 0</td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>HighLevelAppTesting-Operations</td>
    <td>Choose a grocery list item with Quantity > 0</td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>HighLevelAppTesting-Operations</td>
    <td>Delete and item</td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>HighLevelAppTesting-Operations</td>
    <td>Update a Quantity to a valid number</td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>HighLevelAppTesting-Operations</td>
    <td>Update a Quantity to an invalid number</td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>HighLevelAppTesting-Operations</td>
    <td>Add an item to a list</td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>HighLevelAppTesting-Operations</td>
    <td>Uncheck a single list item</td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>HighLevelAppTesting-Op+A34:A47erations</td>
    <td>Uncheck all list items</td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
</table>


