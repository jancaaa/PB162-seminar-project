package cz.muni.fi.pb162.project.geometry;

/**
 * @author: Jana Zahradnickova,  UCO 433598
 * @version: 27. 10. 2015
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

    /**
     * Returns vertex at given index modulo number of indices.
     *
     * @param index vertex index
     * @return vertex at given index modulo number of indices
     * @throws IllegalArgumentException if index is negative
     */
    @Override
    public Vertex2D getVertex(int index) throws IllegalArgumentException {
        if (index < 0) {
            throw new IllegalArgumentException("Index is below zero!");
        } else {
            double x = getCenter().getX() - getRadius() * Math.cos(index * 2 * Math.PI / getNumVertices());
            double y = getCenter().getY() - getRadius() * Math.sin(index * 2 * Math.PI / getNumVertices());
            return new Vertex2D(x, y);
        }
    }

    /**
     * Returns number of vertices of the polygon.
     *
     * @return number of vertices
     */
    @Override
    public int getNumVertices() {
        return getNumEdges();
    }

    /**
     * Creates array of triangles dividing simple regular polygon.
     *
     * @return Array of triangles
     */
    public Triangle[] triangulate() {
        Triangle[] triangles = new Triangle[getNumEdges()];
        Vertex2D polygonCenter = getCenter();
        Vertex2D pom1;
        Vertex2D pom2;
        for (int i = 0; i < getNumEdges(); i++) {
            pom1 = getVertex(i);
            pom2 = getVertex(i + 1);
            triangles[i] = new Triangle(polygonCenter, pom1, pom2);
        }
        return triangles;
    }
}
