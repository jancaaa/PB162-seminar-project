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
    private Vertex2D A;
    private Vertex2D B;
    private Vertex2D C;

    //subtriangles
    private Triangle T1=null;
    private Triangle T2=null;
    private Triangle T3=null;

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

    /**
     * isDivided determine if the triangle is divided or not
     * @return true - is divided, false - is not divided
     */
    public boolean isDivided(){
        return (T1!=null && T2!=null && T3!=null);
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
                return T1;
            }
            case 1:{
                return T2;
            }
            case 2:{
                return T3;
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
        Vertex2D SA = new Vertex2D();
        SA.setX((B.getX()+C.getX())/2);
        SA.setY((B.getY()+C.getY())/2);

        Vertex2D SB = new Vertex2D();
        SB.setX((A.getX()+C.getX())/2);
        SB.setY((A.getY()+C.getY())/2);

        Vertex2D SC = new Vertex2D();
        SC.setX((A.getX()+B.getX())/2);
        SC.setY((A.getY()+B.getY())/2);

        T1 = new Triangle();
        T2 = new Triangle();
        T3 = new Triangle();

        T1.setVertexA(A);
        T1.setVertexB(SC);
        T1.setVertexC(SB);

        T2.setVertexA(SC);
        T2.setVertexB(B);
        T2.setVertexC(SA);

        T3.setVertexA(SB);
        T3.setVertexB(SA);
        T3.setVertexC(C);

        return true;
    }

}