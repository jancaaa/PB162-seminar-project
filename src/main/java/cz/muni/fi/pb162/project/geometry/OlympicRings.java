package cz.muni.fi.pb162.project.geometry;

/**
 *
 * @author: Jana Zahradnickova,  UCO 433598
 * @version: 28. 10. 2015
 *
 */
public class OlympicRings {
    private Circle redRing;
    private Circle blackRing;
    private Circle blueRing;
    private Circle greenRing;
    private Circle yellowRing;

    public OlympicRings(Vertex2D blackCenter, double radius) {
        double firstLineY = blackCenter.getY();
        double secondLineY = firstLineY - radius;
        double space = radius/6; //space between 2 rings

        this.blackRing = new Circle(blackCenter, radius);
        blackRing.setColor("black");

        this.redRing = generateCircle(blackCenter.getX() + 2 * radius + space, firstLineY, radius);
        redRing.setColor("red");

        this.blueRing = generateCircle(blackCenter.getX() - 2 * radius - space, firstLineY, radius);
        blueRing.setColor("blue");

        this.greenRing = generateCircle(blackCenter.getX()+radius+space/2,secondLineY,radius);
        greenRing.setColor("green");

        this.yellowRing = generateCircle(blackCenter.getX()-radius-space/2,secondLineY,radius);
        yellowRing.setColor("yellow");
    }

    private Circle generateCircle(double x, double y, double radius) {
        return new Circle(new Vertex2D(x, y), radius);
    }

    public Circle getRedRing() {
        return redRing;
    }

    public Circle getBlackRing() {
        return blackRing;
    }

    public Circle getBlueRing() {
        return blueRing;
    }

    public Circle getGreenRing() {
        return greenRing;
    }

    public Circle getYellowRing() {
        return yellowRing;
    }
}

