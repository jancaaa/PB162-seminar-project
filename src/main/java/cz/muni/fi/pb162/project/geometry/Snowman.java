package cz.muni.fi.pb162.project.geometry;

/**
 *
 * @author: Jana Zahradnickova,  UCO 433598
 * @version: 21. 10. 2015
 *
 */
public class Snowman {
    Circle bottomBall;
    Circle middleBall;
    Circle topBall;
    Circle leftHandBall;
    Circle rightHandBall;

    public Snowman(double radius, double reductionFactor) {

        if ((reductionFactor <= 0)||(reductionFactor > 1)){
             reductionFactor = 0.8;
        }

        this.bottomBall = new Circle(new Vertex2D(0,radius),radius);

        int middleBallCenterY = (int) (2*radius+radius*reductionFactor);
        double middleBallRadius = radius*reductionFactor;
        this.middleBall = new Circle (new Vertex2D(0,middleBallCenterY),middleBallRadius);

        int topBallCenterY = (int) (2*radius + 2*middleBallRadius + middleBallRadius*reductionFactor);
        double topBallRadius = middleBallRadius * reductionFactor;
        this.topBall = new Circle(new Vertex2D(0,topBallCenterY),topBallRadius);

        double handBallRadius = middleBallRadius/2;
        int leftHandBallCenterX = (int) (-(middleBallRadius+handBallRadius));
        int rightHandBallCenterX = (int)(middleBallRadius+handBallRadius);
        this.leftHandBall = new Circle(new Vertex2D(leftHandBallCenterX,middleBallCenterY),handBallRadius);
        this.rightHandBall = new Circle(new Vertex2D(rightHandBallCenterX,middleBallCenterY),handBallRadius);
    }

    public Circle getBottomBall() {
        return bottomBall;
    }

    public Circle getMiddleBall() {
        return middleBall;
    }

    public Circle getTopBall() {
        return topBall;
    }

    public Circle getLeftHandBall() {
        return leftHandBall;
    }

    public Circle getRightHandBall() {
        return rightHandBall;
    }
}


