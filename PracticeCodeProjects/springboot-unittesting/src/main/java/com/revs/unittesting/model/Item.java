package com.revs.unittesting.model;

import jakarta.persistence.*;

@Entity
@Table(name = "stote_item")
public class Item {

    private String name;

    @Id
    @Column(name = "item_id")
    private int id;
    private int price;
    private int quantity;

    @Transient
    private int value;

    protected Item() {

    }

    public Item(int id, String name, int price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("Item[%d, %s, %d, %d]", this.id, this.name, this.price, this.quantity);
    }
}
