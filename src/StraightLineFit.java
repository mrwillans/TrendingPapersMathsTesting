import org.apache.commons.math3.fitting.PolynomialCurveFitter;
import org.apache.commons.math3.fitting.WeightedObservedPoints;

import java.util.Arrays;


public class StraightLineFit {

    public static void main(String[] args) {


        double[][] coords = {{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14}, {1, 1, 1, 1, 1, 1, 5, 5, 6, 7, 9, 18, 51, 100}};


        WeightedObservedPoints obs = new WeightedObservedPoints();
        obs.add(1, (1));
        obs.add(2, (1));
        obs.add(3, (1));
        obs.add(4, (1));
        obs.add(5, (1));
        obs.add(6, (1));
        obs.add(7, (5));
        obs.add(8, (5));
        obs.add(9, (6));
        obs.add(10, (7));
        obs.add(11, (9));
        obs.add(12, (18));
        obs.add(13, (51));
        obs.add(14, (100));


        PolynomialCurveFitter fitter = PolynomialCurveFitter.create(1);
        double[] coeff = fitter.fit(obs.toList());

        System.out.println("Equation of form y=mx+c");
        System.out.println("c, m" + Arrays.toString(coeff));


    }


    }
