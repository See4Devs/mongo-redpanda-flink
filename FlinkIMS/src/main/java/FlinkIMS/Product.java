package FlinkIMS;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import Models.Batch;
import Models.Supplier;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(value={"_id"}, ignoreUnknown = true)
public class Product {
    @JsonProperty("_id")
    private String id;
    private String itemId;
    private String itemName;
    private String itemType;
    private Supplier supplier;
    private double unitPrice;
    private String unitOfMeasure;
    private boolean perishable;
    private int reorderPoint;
    private int reorderQuantity;
    private List<Batch> batches;
    private Map<String, Object> additionalProperties = new LinkedHashMap<>();

    public Product() {
    }

    public Product(String id, String itemId, String itemName, String itemType, Supplier supplier, double unitPrice, String unitOfMeasure, boolean perishable, int reorderPoint, int reorderQuantity, List<Batch> batches) {
        this.id = id;
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemType = itemType;
        this.supplier = supplier;
        this.unitPrice = unitPrice;
        this.unitOfMeasure = unitOfMeasure;
        this.perishable = perishable;
        this.reorderPoint = reorderPoint;
        this.reorderQuantity = reorderQuantity;
        this.batches = batches;
    }

    // Getters and setters...

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public boolean isPerishable() {
        return perishable;
    }

    public void setPerishable(boolean perishable) {
        this.perishable = perishable;
    }

    public int getReorderPoint() {
        return reorderPoint;
    }

    public void setReorderPoint(int reorderPoint) {
        this.reorderPoint = reorderPoint;
    }

    public int getReorderQuantity() {
        return reorderQuantity;
    }

    public void setReorderQuantity(int reorderQuantity) {
        this.reorderQuantity = reorderQuantity;
    }

    public List<Batch> getBatches() {
        return batches;
    }

    public void setBatches(List<Batch> batches) {
        this.batches = batches;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Product.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("itemId");
        sb.append('=');
        sb.append(((this.itemId == null)?"<null>":this.itemId));
        sb.append(',');
        sb.append("itemName");
        sb.append('=');
        sb.append(((this.itemName == null)?"<null>":this.itemName));
        sb.append(',');
        sb.append("itemType");
        sb.append('=');
        sb.append(((this.itemType == null)?"<null>":this.itemType));
        sb.append(',');
        sb.append("supplier");
        sb.append('=');
        sb.append(((this.supplier == null)?"<null>":this.supplier));
        sb.append(',');
        sb.append("unitPrice");
        sb.append('=');
        sb.append(this.unitPrice);
        sb.append(',');
        sb.append("unitOfMeasure");
        sb.append('=');
        sb.append(((this.unitOfMeasure == null)?"<null>":this.unitOfMeasure));
        sb.append(',');
        sb.append("perishable");
        sb.append('=');
        sb.append(this.perishable);
        sb.append(',');
        sb.append("reorderPoint");
        sb.append('=');
        sb.append(this.reorderPoint);
        sb.append(',');
        sb.append("reorderQuantity");
        sb.append('=');
        sb.append(this.reorderQuantity);
        sb.append(',');
        sb.append("batches");
        sb.append('=');
        sb.append(((this.batches == null)?"<null>":this.batches));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }
}
