
package methodoverloading;

public class MethodOverloading {

    public static void main(String[] args) {
        feetAndInchesToCm(6,0);
        feetAndInchesToCm(5,3);
        feetAndInchesToCm(10,2);
    }
    public static double feetAndInchesToCm(double feet, double inches) {

         if((feet <0) || ((inches <0) || (inches >12))) {
            System.out.println("Invalid feet or inches parameters");
            return -1;
        }

            double cm = feet * 30.48;
            cm += inches * 2.54;
            System.out.println(feet + " feet, " + inches + " inches = " + cm + " cm");
            return cm;
            
        
}
 public static double feetAndInchesToCm(double inches) {

        if(inches < 0) {
            return -1;
        }

        double feet = (int) inches / 12;
        double remainingInches = (int) inches % 12;
        System.out.println(inches + " inches is equal to " + feet + " feet and " + remainingInches + " inches");
        return feetAndInchesToCm(feet, remainingInches);
    }
}
