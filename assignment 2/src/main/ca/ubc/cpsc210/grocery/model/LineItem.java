package ca.ubc.cpsc210.grocery.model;

// Represents a line item on a grocery bill that has a grocery item and
// the quantity of that item purchased
public class LineItem {
    private GroceryItem groceryItem;
    private int quantity;

    // EFFECTS: constructs a grocery bill line item for the given item and quantity purchased
    public LineItem(GroceryItem item, int quantity) {
        this.groceryItem = item;
        this.quantity = quantity;
    }

    // EFFECTS: returns the quantity purchased on this line item
    public int getQuantity() {
        return quantity;
    }

    // EFFECTS: returns the grocery item purchased on this line item
    public GroceryItem getGroceryItem() {
        return groceryItem;
    }

    // REQUIRES: quantity > 0
    // MODIFIES: this
    // EFFECTS: adds numItems to quantity of items purchased on this line item
    public void addQuantity(int numItems) {
        this.quantity += numItems;
    }
}
