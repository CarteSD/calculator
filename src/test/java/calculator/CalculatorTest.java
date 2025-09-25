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

    @Test
    void add_devrait_lever_exception_pour_debordement() {
        // Given
        int opG = Integer.MAX_VALUE;
        int opD = 1;

        // When
        Throwable thrown = catchThrowable(() -> Calculator.add(opG, opD));

        // Then
        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("integer overflow");
    }

    @Test
    void add_devrait_lever_exception_pour_sous_debordement() {
        // Given
        int opG = Integer.MIN_VALUE;
        int opD = -1;

        // When
        Throwable thrown = catchThrowable(() -> Calculator.add(opG, opD));

        // Then
        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("integer overflow");
    }

    @Test
    void devide_devrait_lever_exception_pour_diviseur_nul() {
        // Given
        int opG = 10;
        int opD = 0;

        // When
        Throwable thrown = catchThrowable(() -> Calculator.devide(opG, opD));

        // Then
        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Division by zero is not allowed.");
    }

    @Test
    void ensembleChiffres_devrait_retourner_0_quand_le_nombre_est_0() {
        // Given
        int nombre = 0;

        // When
        var result = Calculator.ensembleChiffres(nombre);

        // Then
        assertThat(result).containsExactlyInAnyOrder(0);
    }
}