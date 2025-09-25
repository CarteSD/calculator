package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

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
}