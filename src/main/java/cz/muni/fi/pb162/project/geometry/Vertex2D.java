    package cz.muni.fi.pb162.project.geometry;

    /**
     *
     * @author: Jana Zahradnickova,  UCO 433598
     * @version: 7.10.2015
     *
     */

    /**
     * Represents vertex [X,Y]
     */
    public class Vertex2D {
        private double x;
        private double y;

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }

        public Vertex2D(double x, double y) {
            this.x = x;
            this.y = y;
        }

        /**
         * calculates the distance between the current and the specified vertex
         * @param vert - the second vertex
         * @return distance distance between the current and the specified vertex
         */
        public double distance (Vertex2D vert){
            if (vert == null)
                return -1.0;
            else

                return Math.sqrt(Math.pow(vert.getX()-this.getX(),2)+Math.pow((vert.getY()-this.getY()),2));
        }

        @Override
        public String toString() {
            return "["+ x + ", " + y + "]";
        }
    }
