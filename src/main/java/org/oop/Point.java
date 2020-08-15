package org.oop;

public class Point {
    private double x;
    private double y;

    private double xDistance(Point p){
        return p.x - this.x;
    }

    private double yDistance(Point p){
        return p.y - this.y;
    }

    public double distance(Point p){
        double xDist = this.xDistance(p);
        double yDist = this.yDistance(p);
        return Math.sqrt(Math.pow(xDist, 2) + Math.pow(yDist, 2));
    }

    public double direction(Point p){
        double xDist = this.xDistance(p);
        double yDist = this.yDistance(p);
        return Math.atan2(yDist, xDist);
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
