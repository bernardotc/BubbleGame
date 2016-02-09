package com.example.BubbleGame;

/**
 * Created by bernardot on 2/9/16.
 */
public class Vector2d {
    // of course, also require the methods for adding
    // to these vectors

    public static void main(String[] args) {
        // main method for convenient testing
        Vector2d v = new Vector2d(10, 10);
        System.out.println(v.mag());
        v.normalise();
        System.out.println(v.mag());
    }

    public float x, y;

    public Vector2d() {
        this(0, 0);
    }

    public boolean equals(Object o) {
        if (o instanceof Vector2d) {
            Vector2d v = (Vector2d) o;
            return x == v.x && y == v.y;
        } else {
            return false;
        }
    }

    public Vector2d(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector2d(Vector2d v) {
        this.x = v.x;
        this.y = v.y;
    }

    public Vector2d copy() {
        return new Vector2d(x, y);
    }

    public void set(Vector2d v) {
        this.x = v.x;
        this.y = v.y;
    }

    public void set(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void zero() {
        x = 0;
        y = 0;
    }

    public String toString() {
        return x + " : " + y;
    }

    public Vector2d add(Vector2d v) {
        this.x += v.x;
        this.y += v.y;
        return this;
    }

    public Vector2d add(double x, double y) {
        this.x += x;
        this.y += y;
        return this;
    }

    public Vector2d add(Vector2d v, double w) {
        // weighted addition
        this.x += w * v.x;
        this.y += w * v.y;
        return this;
    }

    public Vector2d wrap(float w, float h) {
//        w = 2 * w;
//        h = 2 * h;
        x = (x + w) % w;
        y = (y + h) % h;
        return this;
    }

    public Vector2d subtract(Vector2d v) {
        this.x -= v.x;
        this.y -= v.y;
        return this;
    }

    public Vector2d subtract(double x, double y) {
        this.x -= x;
        this.y -= y;
        return this;
    }

    public Vector2d mul(double fac) {
        x *= fac;
        y *= fac;
        return this;
    }

    public void rotate(double theta) {
        // rotate this vector by the angle made to the horizontal by this line
        // theta is in radians
        float cosTheta = (float) Math.cos(theta);
        float sinTheta = (float) Math.sin(theta);

        float nx = x * cosTheta - y * sinTheta;
        float ny = x * sinTheta + y * cosTheta;

        x = nx;
        y = ny;
    }

    public float scalarProduct(Vector2d v) {
        return x * v.x + y * v.y;
    }

    public static float sqr(float x) {
        return x * x;
    }

    public float sqDist(Vector2d v) {
        return sqr(x - v.x) + sqr(y - v.y);
    }

    public float mag() {
        return (float) Math.sqrt(sqr(x) + sqr(y));
    }

    public float dist(Vector2d v) {
        return (float) Math.sqrt(sqDist(v));
    }

    public float dist(float vx, float vy) {
        return (float) Math.sqrt(sqr(x - vx) + sqr(y - vy));
    }

    public float theta() {
        return (float) (Math.atan2(y, x) * 180 / Math.PI + 90);
    }

    public float theta(Vector2d target) {
        return (float) (Math.atan2(target.y - y, target.x - x) * 180 / Math.PI + 90);
    }

    public void normalise() {
        double mag = mag();
        x /= mag;
        y /= mag;
    }
}

