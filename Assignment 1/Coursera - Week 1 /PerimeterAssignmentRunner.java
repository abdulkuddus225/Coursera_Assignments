import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int counter = 0;
        
        for(Point point: s.getPoints()){
            counter += 1;
        }
        
        return counter;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        double averagelength = 0.0;
        double totalsides = getPerimeter(s);
        int numberofsides = getNumPoints(s) ;
        averagelength = totalsides / numberofsides;
        return averagelength;
    }

    public double getLargestSide(Shape s) {
        // Put code here
        Point prevPoint = s.getLastPoint();
        
        double largestSide = 0;
        
        for (Point currPoint : s.getPoints()){
            
            double sideLength = prevPoint.distance(currPoint);
            if (sideLength > largestSide){
                
                largestSide = sideLength;
            }
        }
        
        return largestSide;
    }

    public double getLargestX(Shape s) {
        // Put code here
        double largestX = 0;
        
        for (Point currPoint : s.getPoints()){
            if (currPoint.getX() > largestX) {
                largestX = currPoint.getX();
            }
        }
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        double largestPerimeter = 0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f); 
            Shape s = new Shape(fr);
            double length = getPerimeter(s);
            if (length > largestPerimeter){
                largestPerimeter = length;
            }
        }
        
        return largestPerimeter;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        double largestPerimeter = 0;
        File largestPerimeterFile = null;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f); 
            Shape s = new Shape(fr);
            double length = getPerimeter(s);
            if (length > largestPerimeter){
                largestPerimeter = length;
                largestPerimeterFile = f;
                
            }
        }
        return largestPerimeterFile.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        System.out.println("Number of points = " + getNumPoints(s));
        System.out.println("Average Length of sides = " + getAverageLength(s));
        System.out.print("Largest Side = " + getLargestSide(s));
        System.out.print("Largest X-Coordinate = " + getLargestX(s));
        
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        double largestPerimeter = getLargestPerimeterMultipleFiles();
        System.out.println("The file with largest perimeter is " + largestPerimeter);
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        String largestPerimeterFile = getFileWithLargestPerimeter();
        System.out.println("File name of the file with largest perimeter is " + largestPerimeterFile);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
