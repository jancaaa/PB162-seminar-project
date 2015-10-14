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
        Vertex2D a = new Vertex2D(-100,0);
        Vertex2D b = new Vertex2D(0,100);
        Vertex2D c = new Vertex2D(100,-100);
        Triangle myTriangle = new Triangle(a,b,c);
        String output = myTriangle.toString();
        System.out.println(output);
    }
}
