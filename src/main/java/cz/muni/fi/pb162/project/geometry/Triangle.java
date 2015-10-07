package cz.muni.fi.pb162.project.geometry;

/**
 *
 * @author: Jana Zahradnickova,  UCO 433598
 * @version: 7.10.2015
 *
 */
public class Triangle {
    private Vertex2D A;
    private Vertex2D B;
    private Vertex2D C;

    public void setVertexA(Vertex2D vert) {
        A = vert;
    }

    public void setVertexB(Vertex2D vert) {
        B = vert;
    }

    public void setVertexC(Vertex2D vert) {
        C = vert;
    }

    public Vertex2D getVertexA() {
        return A;
    }

    public Vertex2D getVertexB() {
        return B;
    }

    public Vertex2D getVertexC() {
        return C;
    }

    @Override
    public String toString() {
        return "Triangle: verticales=" + A.toString()+ " " + B.toString() +" "+ C.toString();
    }
}
