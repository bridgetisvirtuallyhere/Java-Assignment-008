public class InfiniteSeries {

    public static int factorial(int n){
        int fact = 1;
        for(int i=n; i>1; i--) {
            fact *=i;
        }
        return fact;
    }
    public static double myExp(int n, double x) {  //Write a method called myExp
        double e = 0;
        for(int i=0; i<=n; i++) { //that takes x and n as parameters
            double en = (Math.pow(x,i)/factorial(i));
            e+=en;
        } //and estimates en by adding the first n terms of this series.
        return e;
    }

    public static double solution(int n, double x) {
        double e = 0;
        double numerator = 1;
        double denominator = 1;
        for(int i=1; i<=n; i++) { //that takes x and n as parameters
            numerator*=x;
            denominator*=i;
            e+=numerator/denominator;
        } //and estimates en by adding the first n terms of this series.
        return e+1;
    }

    public static double check(int n, double x, CheckMethod cm){
        System.out.printf("%f %f %f",x, cm.eMethod(n, x), Math.exp(x));
        return x;
    }

    public static void main(String[] args) {
        /*
        System.out.print("Factorial: ");
        System.out.println(factorial(5));
        System.out.print("My Expansion: ");
        System.out.println(myExp(5,5));
        System.out.print("Compared to the simplified solution: ");
        System.out.println(solution(5,5));
         */
        System.out.println(check(10,1, InfiniteSeries::solution));
        System.out.println(check(10,1, InfiniteSeries::myExp));
    }


}

interface CheckMethod {
    double eMethod(int n, double x);
}
