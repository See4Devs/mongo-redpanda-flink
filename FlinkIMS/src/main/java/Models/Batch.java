package Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Batch {
    private String batchId;
    private String purchaseDate;
    private String expiryDate;
    private int currentStock;
    private Discount discount;

    public Batch() {
    }

    public Batch(String batchId, String purchaseDate, String expiryDate, int currentStock, Discount discount) {
        this.batchId = batchId;
        this.purchaseDate = purchaseDate;
        this.expiryDate = expiryDate;
        this.currentStock = currentStock;
        this.discount = discount;
    }

    // Getters and setters...

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public int getCurrentStock() {
        return currentStock;
    }

    public void setCurrentStock(int currentStock) {
        this.currentStock = currentStock;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Batch{" +
                "batchId='" + batchId + '\'' +
                ", purchaseDate='" + purchaseDate + '\'' +
                ", expiryDate='" + expiryDate + '\'' +
                ", currentStock=" + currentStock +
                ", discount=" + discount +
                '}';
    }
}
