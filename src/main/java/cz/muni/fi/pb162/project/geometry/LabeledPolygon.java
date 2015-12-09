package cz.muni.fi.pb162.project.geometry;

import java.util.*;

/**
 * @author: Jana Zahradnickova,  UCO 433598
 * @version: 9. 12. 2015
 */
public class LabeledPolygon extends SimplePolygon {
    private SortedMap<String, Vertex2D> vertices = new TreeMap<>();

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
            throw new IllegalArgumentException("Index is below zero!");
        index = index % getNumVertices();
        int i = 0;
        for (Map.Entry<String, Vertex2D> v : vertices.entrySet()) {
            if (i == index) {
                return v.getValue();
            }
            i++;
        }
        return null;
    }

    /**
     * Returns vertex with given label.
     *
     * @param label label (key) of required vertex
     * @return vertex from map which has given label
     * @throws IllegalArgumentException - given label do not exist in map
     */
    public Vertex2D getVertex(String label) {
        if (!vertices.containsKey(label))
            throw new IllegalArgumentException("label do not exist!");

        return vertices.get(label);
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

    /**
     * Returns set of all labels from map.
     *
     * @return set of labels
     */
    public Set<String> getLabels() {
        return Collections.unmodifiableSet(this.vertices.keySet());
    }

    /**
     * Returns collection of all labels with given coords from map
     *
     * @param vert coords of vertex
     * @return collection of labels
     */
    public Collection<String> getLabels(Vertex2D vert) {
        SortedSet<String> labels = new TreeSet<>();

        for (String label : vertices.keySet()) {
            if (vertices.get(label).equals(vert)) {
                labels.add(label);
            }
        }
        return Collections.unmodifiableCollection(labels);
    }

    /**
     * Adds given vertex with specified label (key) to map.
     *
     * @param label key of given vertex
     * @param vert  vertex to store in map with specified label (key)
     * @throws NullPointerException - label or vert is null
     */
    public void addVertex(String label, Vertex2D vert) {
        if (label == null || vert == null)
            throw new NullPointerException("label or vert is null!");

        vertices.put(label, vert);
    }

    /**
     * Gets native sorted vertices.
     *
     * @return sorted vertices
     */
    public Collection<Vertex2D> getSortedVertices() {
        SortedSet<Vertex2D> sortedVertices = new TreeSet<>();
        sortedVertices.addAll(vertices.values());
        return Collections.unmodifiableCollection(sortedVertices);
    }

    /**
     * Gets sorted vertices using comparator.
     *
     * @param comparator comparator of Vertex2D
     * @return sorted vertices
     */
    public Collection<Vertex2D> getSortedVertices(Comparator<Vertex2D> comparator) {
        SortedSet<Vertex2D> sortedVertices = new TreeSet<>(comparator);
        sortedVertices.addAll(vertices.values());
        return Collections.unmodifiableSortedSet(sortedVertices);
    }

    /**
     * Returns set of vertices which are duplicated (several times under different names)
     *
     * @return set of duplicated vertices
     */
    public Set<Vertex2D> duplicateVertices() {
        Set<Vertex2D> temp = new HashSet<>();
        Set<Vertex2D> duplicities = new HashSet<>();

        for (Vertex2D v : vertices.values()) {
            if (temp.contains(v)) {
                duplicities.add(v);
            } else {
                temp.add(v);
            }
        }
        return Collections.unmodifiableSet(duplicities);

    }
}
