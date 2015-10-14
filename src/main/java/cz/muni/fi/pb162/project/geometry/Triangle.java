package cz.muni.fi.pb162.project.geometry;

/**
 *
 * @author: Jana Zahradnickova,  UCO 433598
 * @version: 7.10.2015
 *
 */

/**
 * Represents triangle ABC.
 */
public class Triangle {
    //vertices
    private Vertex2D vertexA;
    private Vertex2D vertexB;
    private Vertex2D vertexC;

    //subtriangles
    private Triangle t1=null;
    private Triangle t2=null;
    private Triangle t3=null;

    public void setVertexA(Vertex2D vert) {
        vertexA = vert;
    }

    public void setVertexB(Vertex2D vert) {
        vertexB = vert;
    }

    public void setVertexC(Vertex2D vert) {
        vertexC = vert;
    }

    public Vertex2D getVertexA() {
        return vertexA;
    }

    public Vertex2D getVertexB() {
        return vertexB;
    }

    public Vertex2D getVertexC() {
        return vertexA;
    }

    @Override
    public String toString() {
        return "Triangle: vertices=" + vertexA.toString()+ " " + vertexB.toString() +" "+ vertexC.toString();
    }

    /**
     * isDivided determine if the triangle is divided or not
     * @return true - is divided, false - is not divided
     */
    public boolean isDivided(){
        return (t1!=null && t2!=null && t3!=null);
        /*
        if (T1==null && T2==null && T3==null){
            return false;
        }
        else{
            return true;
        }
        */
    }

    /**
     * Return i. subtriangle.
     * @param i subtriangle serial number (range: 0 .. 2)
     * @return subtriangle or null if i is not in range
     */
    public Triangle getSubTriangle(int i){
        if (!isDivided())
            return null;
        switch (i){
            case 0:{
                return t1;
            }
            case 1:{
                return t2;
            }
            case 2:{
                return t3;
            }
        }
        return null;
    }

    /**
     * Divide triangle to three subtriangles
     * @return true - triangle is divided, false - triangle is already divided
     */
    public boolean divide(){
        if (isDivided())
            return false;

        //middles of edges
        Vertex2D sa = new Vertex2D();
        sa.setX((vertexB.getX() + vertexC.getX())/2);
        sa.setY((vertexB.getY() + vertexC.getY())/2);

        Vertex2D sb = new Vertex2D();
        sb.setX((vertexA.getX() + vertexC.getX())/2);
        sb.setY((vertexA.getY() + vertexC.getY())/2);

        Vertex2D sc = new Vertex2D();
        sc.setX((vertexA.getX() + vertexB.getX())/2);
        sc.setY((vertexA.getY() + vertexC.getY())/2);

        t1 = new Triangle();
        t2 = new Triangle();
        t3 = new Triangle();

        t1.setVertexA(vertexA);
        t1.setVertexB(sc);
        t1.setVertexC(sb);

        t2.setVertexA(sc);
        t2.setVertexB(vertexB);
        t2.setVertexC(sa);

        t3.setVertexA(sb);
        t3.setVertexB(sa);
        t3.setVertexC(vertexC);

        return true;
    }

}