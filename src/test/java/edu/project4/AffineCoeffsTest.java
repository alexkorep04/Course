package edu.project4;

import static org.assertj.core.api.Assertions.*;
import edu.project4.entities.AffineCoeffs;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AffineCoeffsTest {
    @Test
    @DisplayName("Test creating of affine coefficients")
    public void testCoeffs() {
        AffineCoeffs affineCoeffs = AffineCoeffs.create();
        double a = affineCoeffs.a();
        double b = affineCoeffs.b();
        double c = affineCoeffs.c();
        double d = affineCoeffs.d();
        double e = affineCoeffs.e();
        double f = affineCoeffs.f();

        boolean response = (a * a + d * d < 1)
            && (b * b + e * e < 1)
            && (a * a + b * b + d * d + e * e < 1 + (a * e - b * d) * (a * e - b * d));

        assertThat(response).isTrue();
    }
}
