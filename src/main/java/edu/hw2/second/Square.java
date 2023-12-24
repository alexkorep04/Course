package edu.hw2.second;

public class Square extends Rectangle {
    public Square(int height) {
        super(height, height);
    }

    @Override
    public Rectangle setWidth(int width) {
        return new Square(width);
    }

    @Override
    public Rectangle setHeight(int width) {
        return new Square(width);
    }
}
