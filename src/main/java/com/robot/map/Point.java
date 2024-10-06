package com.robot.map;

public class Point {

    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return String.format("[%d, %d]", x, y);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Point)) {
            return false;
        }

        Point another = (Point) obj;
        return x == another.x && y == another.y;
    }
}