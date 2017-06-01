package entity;

/**
 * Created by: csanches on 01/06/2017.
 */
public class Map {

    final private int width;
    final private int height;

    public Map(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
