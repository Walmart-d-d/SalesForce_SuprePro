package org.example.classes;

import org.example.enums.OppStatus;
import org.example.enums.ProductType;

public class Opportunity {
    private static int counter;
    private int id;
    private ProductType product;
    private Contact decisionMaker;
    private int quantity;
    private OppStatus status;


    public Opportunity(int id, ProductType product, Contact decisionMaker, int quantity, OppStatus status) {
        counter++;
        this.id = counter;
        setProduct(product);
        setDecisionMaker(decisionMaker);
        setQuantity(quantity);
        setStatus(status);
    }

    public int getId() {
        return id;
    }

    public ProductType getProduct() {
        return product;
    }

    public void setProduct(ProductType product) {
        this.product = product;
    }

    public Contact getDecisionMaker() {
        return decisionMaker;
    }

    public void setDecisionMaker(Contact decisionMaker) {
        this.decisionMaker = decisionMaker;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public OppStatus getStatus() {
        return status;
    }

    public void setStatus(OppStatus status) {
        this.status = status;
    }
}
