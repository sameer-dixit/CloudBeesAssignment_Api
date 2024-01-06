package api_assignment;

import java.util.Date;

public class Purchase {
    private String from;
    private String to;
    private User user;
    private double pricePaid;
    private Date purchaseDate;

    public Purchase(String from, String to, User user, double pricePaid) {
        this.from = from;
        this.to = to;
        this.user = user;
        this.pricePaid = pricePaid;
        this.purchaseDate = new Date(); // Current date and time
    }

    // Getters and setters (not shown here for brevity)

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public User getUser() {
        return user;
    }

    public double getPricePaid() {
        return pricePaid;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }
}
