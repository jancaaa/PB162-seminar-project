package cz.muni.fi.pb162.project.geometry;

/**
 * @author: Jana Zahradnickova,  UCO 433598
 * @version: 9. 11. 2015
 */
public abstract class SimplePolygon implements Polygon {
    @Override
    public double getArea() {
        double area = 0;

        for (int i = 0; i < getNumVertices(); i++) {
            area = area + ((getVertex(i).getX() * getVertex(i + 1).getY()) - (getVertex(i + 1).getX() * getVertex(i).getY()));
        }
        return area * 0.5;
    }

    @Override
    public double getHeight() {
        Vertex2D max = getVertex(0);
        Vertex2D min = getVertex(0);

        for (int i = 1; i < getNumVertices(); i++) {
            if (getVertex(i).getY() > max.getY())
                max = getVertex(i);
            if (getVertex(i).getY() < min.getY())
                min = getVertex(i);
        }
        return max.getY() - min.getY();
    }

    @Override
    public double getWidth() {
        Vertex2D max = getVertex(0);
        Vertex2D min = getVertex(0);

        for (int i = 0; i < getNumVertices(); i++) {
            if (getVertex(i).getX() > max.getX())
                max = getVertex(i);
            if (getVertex(i).getX() < min.getX())
                min = getVertex(i);
        }
        return max.getX() - min.getX();
    }

    @Override
    public double getLength() {
        double length = 0;

        for (int i = 0; i < getNumVertices(); i++) {
            length = length + (getVertex(i).distance(getVertex(i + 1)));
        }
        length = length + (getVertex(0).distance(getVertex(getNumVertices())));
        return length;
    }

    @Override
    public String toString() {
        String verticesCoords = "";
        for (int i = 0; i < getNumVertices(); i++) {
            verticesCoords = verticesCoords + " [" + getVertex(i).getX() + ", " + getVertex(i).getY() + "]";
        }
        return "Polygon: vertices =" + verticesCoords;
    }
}
