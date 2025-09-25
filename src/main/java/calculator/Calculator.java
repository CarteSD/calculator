package calculator;

import java.util.HashSet;
import java.util.Set;

public class Calculator {
    public static int add(int opG, int opD) {
        return opG + opD;
    }

    public static int devide(int opG, int opD) {
        return opG / opD;
    }

    public static Set<Integer> ensembleChiffres(int pNombre) {
        Set<Integer> chiffres = new HashSet<>();
        int number = Math.abs(pNombre);

        while (number > 0) {
            chiffres.add(number % 10);
            number /= 10;
        }

        if (pNombre == 0) {
            chiffres.add(0);
        }

        return chiffres;
    }
}
