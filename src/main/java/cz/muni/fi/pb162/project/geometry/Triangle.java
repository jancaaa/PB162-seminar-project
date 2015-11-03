package cz.muni.fi.pb162.project.geometry;

/**
 * @author: Jana Zahradnickova,  UCO 433598
 * @version: 7.10.2015
 */

/**
 * Represents triangle ABC.
 */
public class Triangle implements Solid {

    //vertices
    private Vertex2D vertexA;
    private Vertex2D vertexB;
    private Vertex2D vertexC;

    //subtriangles
    private Triangle t1 = null;
    private Triangle t2 = null;
    private Triangle t3 = null;

    public static final double EPS = 0.001;

    public Vertex2D getVertexA() {
        return vertexA;
    }

    public Vertex2D getVertexB() {
        return vertexB;
    }

    public Vertex2D getVertexC() {
        return vertexC;
    }

    public Triangle(Vertex2D vertexA, Vertex2D vertexB, Vertex2D vertexC) {
        this.vertexA = vertexA;
        this.vertexB = vertexB;
        this.vertexC = vertexC;
    }

    public Triangle(Vertex2D vertexA, Vertex2D vertexB, Vertex2D vertexC, int depth) {
        this(vertexA, vertexB, vertexC);
        this.divide(depth);

    }

    @Override
    public String toString() {
        if (vertexA == null || vertexB == null || vertexC == null)
            return "INVALID TRIANGLE";
        else
            return "Triangle: vertices=" + vertexA.toString() + " " + vertexB.toString() + " " + vertexC.toString();
    }

    /**
     * Determines if the triangle is divided or not
     *
     * @return true - is divided, false - is not divided
     */
    public boolean isDivided() {
        return (t1 != null && t2 != null && t3 != null);
    }

    /**
     * Return i. subtriangle.
     *
     * @param i subtriangle serial number (range: 0 .. 2)
     * @return subtriangle or null if i is not in range
     */
    public Triangle getSubTriangle(int i) {
        if (!isDivided())
            return null;
        switch (i) {
            case 0: {
                return t1;
            }
            case 1: {
                return t2;
            }
            case 2: {
                return t3;
            }
        }
        return null;
    }

    /**
     * Divides triangle to three subtriangles - creates Sierpinski triangle
     *
     * @param depth - the number of divisions
     * @return true - triangle is divided, false - can not divide the triangle, depth =<0
     */
    public boolean divide(int depth) {
        if (depth > 0) {
            //middles of edges
            Vertex2D sa = new Vertex2D((vertexB.getX() + vertexC.getX()) / 2, (vertexB.getY() + vertexC.getY()) / 2);
            Vertex2D sb = new Vertex2D((vertexA.getX() + vertexC.getX()) / 2, (vertexA.getY() + vertexC.getY()) / 2);
            Vertex2D sc = new Vertex2D((vertexA.getX() + vertexB.getX()) / 2, (vertexA.getY() + vertexB.getY()) / 2);

            t1 = new Triangle(this.vertexA, sc, sb);
            t2 = new Triangle(sc, this.vertexB, sa);
            t3 = new Triangle(sb, sa, vertexC);

            t1.divide(depth - 1);
            t2.divide(depth - 1);
            t3.divide(depth - 1);
            return true;
        } else
            return false;
    }

    /**
     * Determines if the triangle is an equilateral triangle
     *
     * @return true - is equilateral, false - is not equilateral
     */
    public boolean isEquilateral() {
        double a = this.vertexB.distance(this.vertexC);
        double b = this.vertexA.distance(this.vertexC);
        double c = this.vertexA.distance(this.vertexB);
        return (Math.abs(a - b) < EPS && Math.abs(b - c) < EPS && Math.abs(a - c) < EPS);
    }

    @Override
    public double getArea() {
        double a = this.vertexB.distance(this.vertexC);
        double b = this.vertexA.distance(this.vertexC);
        double c = this.vertexA.distance(this.vertexB);
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public double getWidth() {
        double pom1 = vertexA.getX();
        double pom2 = vertexB.getX();
        double pom3 = vertexC.getX();
        double maxX;
        double minX;
        maxX = Math.max(Math.max(pom1, pom2), pom3);
        minX = Math.min(Math.min(pom1, pom2), pom3);
        return maxX - minX;
    }

    @Override
    public double getHeight() {
        double pom1 = vertexA.getY();
        double pom2 = vertexB.getY();
        double pom3 = vertexC.getY();
        double maxY;
        double minY;
        maxY = Math.max(Math.max(pom1, pom2), pom3);
        minY = Math.min(Math.min(pom1, pom2), pom3);
        return maxY - minY;
    }

    @Override
    public double getLength() { //obvod
        double a = this.vertexB.distance(this.vertexC);
        double b = this.vertexA.distance(this.vertexC);
        double c = this.vertexA.distance(this.vertexB);
        return a + b + c;
    }
}