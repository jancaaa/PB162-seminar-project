package cz.muni.fi.pb162.project.demo;

import cz.muni.fi.pb162.project.geometry.Triangle;
import cz.muni.fi.pb162.project.geometry.Vertex2D;

/**
 *
 * @author: Jana Zahradnickova,  UCO 433598
 * @version: 7.10.2015
 *
 */


public class Demo {
    public static void main(String[] args){
      //  System.out.println("Hello World!");
        Triangle myTriangle= new Triangle();
        Vertex2D a = new Vertex2D();
        a.setX(-100);
        a.setY(0);

        myTriangle.setVertexA(a);

        Vertex2D b = new Vertex2D();
        b.setX(0);
        b.setY(100);
        myTriangle.setVertexB(b);

        Vertex2D c = new Vertex2D();
        c.setX(100);
        c.setY(-100);
        myTriangle.setVertexC(c);
        String output = myTriangle.toString();
        System.out.println(output);
    }
}
