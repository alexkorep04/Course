package edu.project4.entities;


public class FractalImage {
    private Pixel[][] data;
    private int height;
    private int width;

    private FractalImage(Pixel[][] data, int width, int height) {
        this.data = data;
        this.height = height;
        this.width = width;
    }

    public static FractalImage createImage(int width, int height) {
        Pixel[][] data = new Pixel[width][height];
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                data[i][j] = new Pixel(0, 0, 0, 0, 0);
            }
        }
        return new FractalImage(data, width, height);
    }

    public Pixel getPixel(int x, int y) {
        if (isContains(x, y)) {
            return data[x][y];
        }
        return null;
    }

    public boolean isContains(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
