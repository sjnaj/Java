
/*
 * @Author: fengsc
 * @Date: 2022-02-25 20:56:00
 * @LastEditTime: 2022-03-22 10:13:47
 */
package geometry;

import java.util.Date;

public class GeometricObject {
    private String color;
    private boolean filled;
    private Date dateCreated;
    protected static int numberOfObjects = 0;

    public GeometricObject() {
        dateCreated = new Date();
        color = "white";
        numberOfObjects++;
    }

    public GeometricObject(String color, boolean filled) {
        dateCreated = new Date();
        this.color = color;
        this.filled = filled;
        numberOfObjects++;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public Date getDateCreated() {
        return dateCreated;
    }
    public void setDateCreated(Date dateCreated){
        this.dateCreated = dateCreated;
    }

    public String toString() {
        return "created on " + dateCreated + "\ncolor: " + color + " and filled: " + filled;
    }

    public int getNumberOfObjects() {
        return numberOfObjects;
    }
}
