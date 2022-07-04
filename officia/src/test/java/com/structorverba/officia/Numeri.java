package com.structorverba.officia;

import androidx.annotation.NonNull;
import com.structorverba.officia.miscella.*;
import com.structorverba.officia.tentamina.Tentamen;
import com.structorverba.officia.verba.VerbumSimplex;
import lombok.Getter;
import org.apache.commons.lang3.Range;
import org.junit.jupiter.api.*;

import java.util.Random;

/**
 * Classis {@link Numeri} operātiōnēs mathēmaticās rērum classis {@link VerbumSimplex.Numerus} tentat.
 */
@SuppressWarnings({"SpellCheckingInspection", "FieldCanBeLocal", "NewClassNamingConvention"})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
final class Numeri extends Omne {
  @NonNull
  @Getter(lazy = true)
  private final StructorVerba structor = StructorVerba.faciendum.get();

  private final short NUMERUM_MAXIMUM = 3998;
  private final short XLII_NUMERUM    = 42;

  private final @NonNull String XLII_SCRIPTIO = "XLII";

  /**
   * Hic modus conversiōnem ā numerō reī classis {@link VerbumSimplex.Numerus} tentat. <br>
   * Scrīptiunculam {@code 42 = XLII} prōdūcat.
   */
  @Test @Order(1)
  public void conversionis() {
    System.out.println(new Tentamen.TentamenNumeraleConversionis(XLII_SCRIPTIO, XLII_NUMERUM)
                         .exsequar(structor.numeram(XLII_NUMERUM)));
  }

  /**
   * Hic modus reversiōnem ā rē classis {@link VerbumSimplex.Numerus} numerō tentat. <br>
   * Scrīptiunculam {@code XLII = 42} prōdūcat.
   */
  @Test @Order(2)
  public void reversionis() {
    System.out.println(new Tentamen.TentamenNumeraleReversionis(XLII_NUMERUM, XLII_SCRIPTIO)
                         .exsequar(structor.numeram(XLII_SCRIPTIO)));
  }

  /**
   * Hic modus conversiōnem ā numerō reī classis {@link VerbumSimplex.Numerus} atque reversiōnem versam tentat. <br>
   * Scrīptiunculās et {@code 42 = XLII} et {@code XLII = 42} dē numerō nescītō inter I et MMMCMXCIX prōdūcat.
   */
  @Test @Order(3)
  public void combinationis() {
    final short numerus = Integer.valueOf(new Random().ints(1, NUMERUM_MAXIMUM)
                                                      .distinct().findFirst().orElse(10)).shortValue();
    System.out.println(new Tentamen.TentamenNumeraleCombinationis(numerus)
                         .exsequar(structor.numeram(numerus)));
  }

  /**
   * Hic modus additiōnem rērum duārum classis {@link VerbumSimplex.Numerus}. <br>
   * Scrīptiunculās et {@code 17 = XVIII} et {@code 3 = III} et {@code 17 + 3 = 20 = XX} prōdūcat.
   */
  @Test @Order(4)
  public void additionis() {
    @NonNull final Range <Short> range = Range.between((short) 3, (short) 17);
    System.out.println(new Tentamen.TentamenMathematicum(range, '+')
                         .exsequar(structor.numeram(range.getMaximum())));
  }

  /**
   * Hic modus subtractiōnem rērum duārum classis {@link VerbumSimplex.Numerus}. <br>
   * Scrīptiunculās et {@code 12 = XII} et {@code 7 = VII} et {@code 12 - 7 = 5 = V} prōdūcat.
   */
  @Test @Order(5)
  public void subtractionis() {
    @NonNull final Range <Short> range = Range.between((short) 7, (short) 12);
    System.out.println(new Tentamen.TentamenMathematicum(range, '-')
                         .exsequar(structor.numeram(range.getMaximum())));
  }

  /**
   * Hic modus multiplicātiōnem rērum duārum classis {@link VerbumSimplex.Numerus}. <br>
   * Scrīptiunculās et {@code 3 = III} et {@code 2 = II} et {@code 3 * 2 = 6 = VI} prōdūcat.
   */
  @Test @Order(6)
  public void multiplicationis() {
    @NonNull final Range <Short> range = Range.between((short) 2, (short) 3);
    System.out.println(new Tentamen.TentamenMathematicum(range, '*')
                         .exsequar(structor.numeram(range.getMaximum())));
  }

  /**
   * Hic modus dīvīsiōnem rērum duārum classis {@link VerbumSimplex.Numerus}. <br>
   * Scrīptiunculās et {@code 18 = XVII} et {@code 6 = VI} et {@code 18 / 6 = 3 = III} prōdūcat.
   */
  @Test @Order(7)
  public void divisionis() {
    @NonNull final Range <Short> range = Range.between((short) 6, (short) 18);
    System.out.println(new Tentamen.TentamenMathematicum(range, '/')
                         .exsequar(structor.numeram(range.getMaximum())));
  }

  /**
   * Hic modus mānsiōnem rērum duārum classis {@link VerbumSimplex.Numerus}. <br>
   * Scrīptiunculās et {@code 12 = XII} et {@code 9 = IX} et {@code 12 % 9 = 3 = III} prōdūcat.
   */
  @Test @Order(8)
  public void mansionis() {
    @NonNull final Range <Short> range = Range.between((short) 9, (short) 12);
    System.out.println(new Tentamen.TentamenMathematicum(range, '%')
                         .exsequar(structor.numeram(range.getMaximum())));
  }
}
