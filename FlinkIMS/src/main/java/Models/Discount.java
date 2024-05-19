package Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Discount {
    private boolean enabled;
    private String discountType;
    private double discountValue;

    public Discount() {
    }

    public Discount(boolean enabled, String discountType, double discountValue) {
        this.enabled = enabled;
        this.discountType = discountType;
        this.discountValue = discountValue;
    }

    // Getters and setters...

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    public double getDiscountValue() {
        return discountValue;
    }

    public void setDiscountValue(double discountValue) {
        this.discountValue = discountValue;
    }

    @Override
    public String toString() {
        return "Discount{" +
                "enabled=" + enabled +
                ", discountType='" + discountType + '\'' +
                ", discountValue=" + discountValue +
                '}';
    }
}
