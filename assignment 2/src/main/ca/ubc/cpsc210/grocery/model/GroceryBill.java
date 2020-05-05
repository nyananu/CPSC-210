package ca.ubc.cpsc210.grocery.model;

import sun.security.util.Length;

import java.util.ArrayList;

// Represents a grocery bill having a list of line items
public class GroceryBill {
    ArrayList<LineItem> groceryBill;


    // EFFECTS: constructs an empty grocery bill
    public GroceryBill() {
        groceryBill = new ArrayList<LineItem>();
    }

    // MODIFIES: this
    // EFFECTS: adds a purchase to the grocery bill where item is the grocery item purchased
    // and quantity is the quantity of that item purchased; if item has previously been added
    // to this bill, quantity of item purchased is increased on previous entry, rather than
    // adding a new entry
    public void addPurchase(GroceryItem item, int quantity) {
        int i = 0;
        for (int j = 0; j < groceryBill.size(); j++) {
            groceryBill.get(j);
            // add to previously added item;
            if (item.getDescription().equals(groceryBill.get(j).getGroceryItem().getDescription())) {
                groceryBill.get(j).addQuantity(quantity);
                i = 1;
            }
        }
        //add new item
        if (i == 0) {
            groceryBill.add(new LineItem(item,quantity));
        }
    }

    // EFFECTS: returns total number of items purchased
    public int getTotalNumberOfItemsPurchased() {
        int totalPurchased = 0;
        for (int j = 0; j < groceryBill.size(); j++) {
            totalPurchased = totalPurchased + groceryBill.get(j).getQuantity();
        }
        return totalPurchased;
    }

    // EFFECTS: returns number of line items on this bill
    public int getNumLineItems() {
        return groceryBill.size();
    }

    // EFFECTS: returns total quantity of item purchased on this bill;
    // returns 0 if the item has not been added to bill
    public int getTotalQuantityOfItemPurchased(GroceryItem item) {
        int itemQty = 0;
        for (LineItem lineItem : groceryBill) {
            if (item == lineItem.getGroceryItem()) {
                itemQty = lineItem.getQuantity();
            }
        }
        return itemQty;
    }

    // EFFECTS: returns a string representing this bill where each
    // line item is recorded on a line of its own in the format
    // (quantity)x (item)
    // For example:
    // 2x cheesies @ $1.49
    // 4x red bull @ $2.99
    // 1x macaroni cheese @ $3.55
    public String toString() {
        String result = "";
        System.out.println("Grocery Bill: ");
        for (LineItem j : groceryBill) {
            String price = Integer.toString(j.getGroceryItem().getPrice());
            int strLength = price.length();
            result = result + (j.getQuantity() + "x " + (j.getGroceryItem().getDescription())
                    + " @ $" + price.substring(0,strLength - 2) + "." + price.substring(strLength - 2) + "\n");
        }
        return result;
    }
}
