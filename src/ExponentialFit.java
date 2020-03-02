import org.apache.commons.math3.fitting.PolynomialCurveFitter;
import org.apache.commons.math3.fitting.WeightedObservedPoints;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class ExponentialFit {

    private static List<Double> calculateExponentialCoordinates(List<Integer> readerCounts, double[] exponentialCoefficients) {
        List<Double> exponentialCoordinates = new ArrayList<>();
        for (int i = 0; i<readerCounts.size(); i++) {
            double coordinate = exponentialCoefficients[0] * Math.exp((i+1) * exponentialCoefficients[1]);
            exponentialCoordinates.add(coordinate);
        }
        return exponentialCoordinates;
    }
    public static void main(String[] args) {


        double[][] coords ={ {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14},{1, 1, 1, 1, 1, 1, 5, 5, 6, 7, 9, 18, 51, 100}};


        WeightedObservedPoints obs = new WeightedObservedPoints();
//        obs.add(1,Math.log(1));
//        obs.add(2,Math.log(1));
        obs.add(1,Math.log(1));
        obs.add(2,Math.log(1));
        obs.add(3,Math.log(1));
        obs.add(4,Math.log(1));
        obs.add(5,Math.log(5));
        obs.add(6,Math.log(5));
        obs.add(7, Math.log((6)));
        obs.add(8, Math.log((7)));
        obs.add(9, Math.log((9)));
        obs.add(10, Math.log((18)));
        obs.add(11, Math.log((51)));
        obs.add(12, Math.log((100)));


        PolynomialCurveFitter fitter = PolynomialCurveFitter.create(1);
        double[] coeff = fitter.fit(obs.toList());
        coeff[0]=Math.exp(coeff[0]);

        System.out.println("Equation of form ln(y) = ln(A) + bx");
        System.out.println("Gives parameters of y = Ae^(bx)");
        System.out.println("A, b" + Arrays.toString(coeff));

    List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(5);
        list.add(5);
    list.add(6);
        list.add(7);
        list.add(9);
        list.add(18);
        list.add(51);
        list.add(100);

     List<Double> x = calculateExponentialCoordinates(list, coeff);
        System.out.println(Arrays.toString(x.toArray()));














    }

}
