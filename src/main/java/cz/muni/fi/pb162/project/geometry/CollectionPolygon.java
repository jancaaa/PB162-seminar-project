package cz.muni.fi.pb162.project.geometry;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List; // Vzdy List: new ArrayList<>(); Set: new HashSet<>();

/**
 * @author: Jana Zahradnickova,  UCO 433598
 * @version: 24. 11. 2015
 */
public class CollectionPolygon extends SimplePolygon {
    private List<Vertex2D> vertices;


    public CollectionPolygon(Vertex2D[] array) throws NullPointerException {
        if (array == null)
            throw new NullPointerException("array is null!");

        vertices = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null)
                throw new NullPointerException("item of array is null!");
            this.vertices.add(array[i]);
        }
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
        if (index < 0)
            throw new IllegalArgumentException("Index<0!");
        else
            return vertices.get(index % getNumVertices());
    }

    /**
     * Returns number of vertices of the polygon.
     *
     * @return number of vertices
     */
    @Override
    public int getNumVertices() {
        return vertices.size();
    }

    public Collection<Vertex2D> getVertices() {
        return Collections.unmodifiableList(this.vertices);
    }

    /**
     * Inverts polygon stored in list
     *
     * @return inverted polygon
     */
    public CollectionPolygon invert() {
        List<Vertex2D> inverseVertices = new ArrayList<>(getVertices());
        Collections.reverse(inverseVertices);
        return new CollectionPolygon(inverseVertices.toArray(new Vertex2D[vertices.size()]));
    }

    /**
     * Removes most left vertex (or vertices if they all have the same x-coord) of polygon
     *
     * @return List of removed vertices
     */
    public Collection<Vertex2D> removeLeftmostVertices() {
        List<Vertex2D> removedVertices = new ArrayList<>();
        double min = getVertex(0).getX();

        //search the most left vertex (vertex with minimal x-coord)
        for (int i = 0; i < getNumVertices(); i++) {
            if (getVertex(i).getX() < min) {
                min = getVertex(i).getX();
            }
        }

        for (int i = 0; i < getNumVertices(); i++) {
            if (getVertex(i).getX() == min) {
                removedVertices.add(getVertex(i)); //add to list of removed vertices
            }
        }
        this.vertices.removeAll(removedVertices); //remove vertices from polygon
        return removedVertices;
    }
}
