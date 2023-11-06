package ru.otus;

public class Car {
    private Size size;

    public Car(Size size) {
        this.size = size;
    }

    public Car(){ size = Size.MIDDLE;}

    public void setSize(Size size) {
        this.size = size;
    }
}
