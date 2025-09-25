package calculator;

import java.util.HashSet;
import java.util.Set;

public class Calculator {
    public static int add(int opG, int opD) {
        if ((opD > 0 && opG > Integer.MAX_VALUE - opD) || (opD < 0 && opG < Integer.MIN_VALUE - opD)) {
            throw new IllegalArgumentException("integer overflow");
        }
        return opG + opD;
    }

    public static int devide(int opG, int opD) {
        if (opD == 0) {
            throw new IllegalArgumentException("Division by zero is not allowed.");
        }
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
