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

    public Vertex2D getVertexA() {
        return vertexA;
    }

    public Vertex2D getVertexB() {
        return vertexB;
    }

    public Vertex2D getVertexC() {
        return vertexA;
    }

    public Triangle(Vertex2D vertexA, Vertex2D vertexB, Vertex2D vertexC) {
        this.vertexA = vertexA;
        this.vertexB = vertexB;
        this.vertexC = vertexC;
    }

    @Override
    public String toString() {
        if (vertexA==null || vertexB == null || vertexC == null)
            return "INVALID TRIANGLE";
        else
            return "Triangle: vertices=" + vertexA.toString()+ " " + vertexB.toString() +" "+ vertexC.toString();
    }

    /**
     * isDivided determine if the triangle is divided or not
     * @return true - is divided, false - is not divided
     */
    public boolean isDivided(){
        return (t1!=null && t2!=null && t3!=null);
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
        Vertex2D sa = new Vertex2D((vertexB.getX() + vertexC.getX())/2,(vertexB.getY() + vertexC.getY())/2);
        Vertex2D sb = new Vertex2D((vertexA.getX() + vertexC.getX())/2,(vertexA.getY() + vertexC.getY())/2);
        Vertex2D sc = new Vertex2D((vertexA.getX() + vertexB.getX())/2, (vertexA.getY() + vertexC.getY())/2);

        t1 = new Triangle(this.vertexA,sc,sb);
        t2 = new Triangle(sc,this.vertexB,sa);
        t3 = new Triangle(sb,sa,vertexC);

        return true;
    }

    /**
     *
     * @return
     */
    public boolean isEquilateral(){
        double a = this.vertexB.distance(this.vertexC);
        double b = this.vertexA.distance(this.vertexC);
        double c = this.vertexA.distance(this.vertexB);


            return Math.abs(a-b)<0.001 && Math.abs(b-c)<0.001 && Math.abs(a-c)<0.001;
    }

}