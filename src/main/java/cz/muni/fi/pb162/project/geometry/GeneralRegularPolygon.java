package cz.muni.fi.pb162.project.geometry;

/**
 *
 * @author: Jana Zahradnickova,  UCO 433598
 * @version: 27. 10. 2015
 *
 */
public class GeneralRegularPolygon implements RegularPolygon, Colored {
    private Vertex2D center;
    private int numEdges;
    private double edgeLength;
    private String color;

    public GeneralRegularPolygon(Vertex2D center, int numEdges, double edgeLength) {
        this.center = center;
        this.numEdges = numEdges;
        this.edgeLength = edgeLength;
        setColor("black");
    }

    @Override
    public int getNumEdges() {
        return numEdges;
    }

    @Override
    public double getEdgeLength() {
        return edgeLength;
    }

    @Override
    public Vertex2D getCenter() {
        return center;
    }

    /**
     * Returns radius of the minimum bounding circle.
     *
     * @return radius of the minimum bounding circle
     */
    @Override
    public double getRadius() {
        return edgeLength / (2 * Math.sin(Math.PI / numEdges));
    }

    @Override
    public double getArea() {
        return 0.5 * numEdges * getRadius() * getRadius() * Math.sin((2 * Math.PI) / numEdges);
    }

    @Override
    public double getWidth() {
        return 2 * getRadius();
    }

    @Override
    public double getHeight() {
        return getWidth();
    }

    @Override
    public double getLength() {
        return numEdges * edgeLength;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return numEdges + "-gon: center=[" + center.getX() +
                ", " + center.getY() +
                "], edge length=" + getEdgeLength() +
                ", color=" + getColor();
    }
}
