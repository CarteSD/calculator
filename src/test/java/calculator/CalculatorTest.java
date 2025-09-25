package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class CalculatorTest {

    @Test
    void add_devrait_retourner_la_somme_de_deux_entiers() {
        // Given
        int opG = 5;
        int opD = 3;

        // When
        int result = Calculator.add(opG, opD);

        // Then
        assertThat(result).isEqualTo(8);
    }

    @Test
    void devide_devrait_retourner_le_quotient_de_deux_entiers() {
        // Given
        int opG = 10;
        int opD = 2;

        // When
        int result = Calculator.devide(opG, opD);

        // Then
        assertThat(result).isEqualTo(5);
    }

    @ParameterizedTest
    // Given
    @CsvSource({
            "0, 1",
            "1, 2",
            "-2, 2",
            "0, 0",
            "-1, -2"
    })
    void add_devrait_fonctionner_avec_plusieurs_valeurs(int opG, int opD) {
        // When
        int result = Calculator.add(opG, opD);

        // Then
        assertThat(result).isEqualTo(opG + opD);
    }

    @Test
    void ensembleChiffres_devrait_retourner_les_chiffres_dans_un_ensemble() {
        // Given
        int nombre = -498915042;

        // When
        var result = Calculator.ensembleChiffres(nombre);

        // Then
        assertThat(result).containsExactlyInAnyOrder(4, 8, 9, 1, 5, 0, 2);
    }
}