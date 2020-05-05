package ca.ubc.cpsc210.grocery.model;

// Represents a grocery item having a description and a price in cents
public class GroceryItem {
    private String description;
    private int price;

    // EFFECTS: constructs a grocery item with description and price (in cents)
    public GroceryItem(String description, int price) {
        this.description = description;
        this.price = price;
    }

    // EFFECTS: returns description of this grocery item
    public String getDescription() {
        return description;
    }

    // EFFECTS: returns price (in cents) of this grocery item
    public int getPrice() {
        return price;
    }
}
