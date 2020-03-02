import org.apache.commons.math3.fitting.PolynomialCurveFitter;
import org.apache.commons.math3.fitting.WeightedObservedPoints;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class StraightLineFit {
    private static List<Double> calculateGradientCoordinates(List<Integer> readerCounts, double[] exponentialCoefficients) {
        List<Double> gradientCoordinates = new ArrayList<>();
        for (int i = 0; i<readerCounts.size(); i++) {
            double coordinate = ((i+1) * exponentialCoefficients[1]) + exponentialCoefficients[0];
            gradientCoordinates.add(coordinate);
        }
        return gradientCoordinates;
    }
    public static void main(String[] args) {


        double[][] coords = {{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14}, {1, 1, 1, 1, 1, 1, 5, 5, 6, 7, 9, 18, 51, 100}};


        WeightedObservedPoints obs = new WeightedObservedPoints();
//        obs.add(1, (1));
//        obs.add(2, (1));
        obs.add(1, (1));
        obs.add(2, (1));
        obs.add(3, (1));
        obs.add(4, (1));
        obs.add(5, (5));
        obs.add(6, (5));
        obs.add(7, (6));
        obs.add(8, (7));
        obs.add(9, (9));
        obs.add(10, (18));
        obs.add(11, (51));
        obs.add(12, (100));


        PolynomialCurveFitter fitter = PolynomialCurveFitter.create(1);
        double[] coeff = fitter.fit(obs.toList());

        System.out.println("Equation of form y=mx+c");
        System.out.println("c, m" + Arrays.toString(coeff));

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

        System.out.println(calculateGradientCoordinates(list, coeff));


    }


    }
