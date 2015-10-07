package cz.muni.fi.pb162.project.demo;

import cz.muni.fi.pb162.project.geometry.Triangle;
import cz.muni.fi.pb162.project.geometry.Vertex2D;

/**
 *
 * @author: Jana Zahradnickova,  UCO 433598
 * @version: 7. 10. 2015
 *
 */

public class Demo {
    public static void main(String[] args){
      //  System.out.println("Hello World!");
        Triangle myTriangle= new Triangle();
        Vertex2D pom= new Vertex2D();
        pom.setX(-100);
        pom.setY(0);

        myTriangle.setVertexA(pom);
        pom.setX(0);
        pom.setY(100);
        myTriangle.setVertexB(pom);
        pom.setX(100);
        pom.setY(-100);
        myTriangle.setVertexC(pom);
        String output = myTriangle.toString();
        System.out.println(output);
    }
}