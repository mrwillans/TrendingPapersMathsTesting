import org.apache.commons.math3.fitting.PolynomialCurveFitter;
import org.apache.commons.math3.fitting.WeightedObservedPoints;

import java.util.Arrays;


public class ExponentialFit {


    public static void main(String[] args) {


        double[][] coords ={ {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14},{1, 1, 1, 1, 1, 1, 5, 5, 6, 7, 9, 18, 51, 100}};


        WeightedObservedPoints obs = new WeightedObservedPoints();
        obs.add(1,Math.log(1));
        obs.add(2,Math.log(1));
        obs.add(3,Math.log(1));
        obs.add(4,Math.log(1));
        obs.add(5,Math.log(1));
        obs.add(6,Math.log(1));
        obs.add(7,Math.log(5));
        obs.add(8,Math.log(5));
        obs.add(9,Math.log(6));
        obs.add(10,Math.log(7));
        obs.add(11,Math.log(9));
        obs.add(12,Math.log(18));
        obs.add(13,Math.log(51));
        obs.add(14,Math.log(100));



        PolynomialCurveFitter fitter = PolynomialCurveFitter.create(1);
        double[] coeff = fitter.fit(obs.toList());

        System.out.println("Equation of form ln(y) = ln(A) + bx");
        System.out.println("Gives parameters of y = Ae^(bx)");
        System.out.println("lnA, b" + Arrays.toString(coeff));

















    }

}
