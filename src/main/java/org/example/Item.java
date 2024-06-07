package org.example;

public class Item {
    private int value;
    private int weight;
    private int index;

    public Item(int value, int weight, int index) {
        this.value = value;
        this.weight = weight;
        this.index = index;
    }

    public int getValue() {
        return value;
    }

    public int getWeight() {
        return weight;
    }

    public int getIndex() {
        return index;
    }

    public double getValueToWeightRatio() {
        return (double) value / weight;
    }

    @Override
    public String toString() {
        return "Item{" +
                "value=" + value +
                ", weight=" + weight +
                ", index=" + index +
                '}';
    }
}
