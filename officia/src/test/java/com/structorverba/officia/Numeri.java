package com.structorverba.officia;

import androidx.annotation.NonNull;
import com.structorverba.officia.miscella.*;
import com.structorverba.officia.verba.VerbumSimplex;

import org.apache.commons.lang3.Range;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import lombok.Getter;

/**
 * Classis {@link Numeri} oper\u0101ti\u014Dn\u0113s math\u0113matic\u0101s r\u0113rum classis {@link VerbumSimplex.Numerus} tentat.
 */
@SuppressWarnings({ "SpellCheckingInspection", "FieldCanBeLocal" })
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
final class Numeri extends Omne {
  @NonNull
  @Getter(lazy = true)
  private final StructorVerba structor = StructorVerba.fac.get();

  private final short NUMERUM_MAXIMUM = 3998;
  private final short XLII_NUMERUM    = 42;

  private final @NonNull String XLII_SCRIPTIO = "XLII";

  /**
   * Modus hic conversi\u014Dnem \u0101 numer\u014D re\u012B classis {@link VerbumSimplex.Numerus} tentat. <br>
   * Scr\u012Bptiunculam {@code 42 = XLII} pr\u014Dd\u016Bcat.
   */
  @Test @Order(1)
  public void conversionis( ) {
    System.out.println(new Tentamen.TentamenNumeraleConversionis(XLII_SCRIPTIO, XLII_NUMERUM)
                         .exsequar(structor.numerus(XLII_NUMERUM)));
  }

  /**
   * Modus hic reversi\u014Dnem \u0101 r\u0113 classis {@link VerbumSimplex.Numerus} numer\u014D tentat. <br>
   * Scr\u012Bptiunculam {@code XLII = 42} pr\u014Dd\u016Bcat.
   */
  @Test @Order(2)
  public void reversionis( ) {
    System.out.println(new Tentamen.TentamenNumeraleReversionis(XLII_NUMERUM, XLII_SCRIPTIO)
                         .exsequar(structor.numerus(XLII_SCRIPTIO)));
  }

  /**
   * Modus hic conversi\u014Dnem \u0101 numer\u014D re\u012B classis {@link VerbumSimplex.Numerus} atque reversi\u014Dnem versam tentat. <br>
   * Scr\u012Bptiuncul\u0101s et {@code 42 = XLII} et {@code XLII = 42} d\u0113 numer\u014D nesc\u012Bt\u014D inter I et MMMCMXCIX pr\u014Dd\u016Bcat.
   */
  @Test @Order(3)
  public void combinationis( ) {
    final short numerus = (short) Math.round((NUMERUM_MAXIMUM + 1) * Math.random() + 1);
    System.out.println(new Tentamen.TentamenNumeraleCombinationis(numerus)
                         .exsequar(structor.numerus(numerus)));
  }

  /**
   * Modus hic additi\u014Dnem r\u0113rum du\u0101rum classis {@link VerbumSimplex.Numerus}. <br>
   * Scr\u012Bptiuncul\u0101s et {@code 17 = XVIII} et {@code 3 = III} et {@code 17 + 3 = 20 = XX} pr\u014Dd\u016Bcat.
   */
  @Test @Order(4)
  public void additionis( ) {
    @NonNull final Range <Short> range = Range.between((short) 3, (short) 17);
    System.out.println(new Tentamen.TentamenMathēmaticum(range, '+')
                         .exsequar(structor.numerus(range.getMaximum())));
  }

  /**
   * Modus hic subtracti\u014Dnem r\u0113rum du\u0101rum classis {@link VerbumSimplex.Numerus}. <br>
   * Scr\u012Bptiuncul\u0101s et {@code 12 = XII} et {@code 7 = VII} et {@code 12 - 7 = 5 = V} pr\u014Dd\u016Bcat.
   */
  @Test @Order(5)
  public void subtractionis( ) {
    @NonNull final Range <Short> range = Range.between((short) 7, (short) 12);
    System.out.println(new Tentamen.TentamenMathēmaticum(range, '-')
                         .exsequar(structor.numerus(range.getMaximum())));
  }

  /**
   * Modus hic multiplic\u0101ti\u014Dnem r\u0113rum du\u0101rum classis {@link VerbumSimplex.Numerus}. <br>
   * Scr\u012Bptiuncul\u0101s et {@code 3 = III} et {@code 2 = II} et {@code 3 * 2 = 6 = VI} pr\u014Dd\u016Bcat.
   */
  @Test @Order(6)
  public void multiplicationis( ) {
    @NonNull final Range <Short> range = Range.between((short) 2, (short) 3);
    System.out.println(new Tentamen.TentamenMathēmaticum(range, '*')
                         .exsequar(structor.numerus(range.getMaximum())));
  }

  /**
   * Modus hic d\u012Bv\u012Bsi\u014Dnem r\u0113rum du\u0101rum classis {@link VerbumSimplex.Numerus}. <br>
   * Scr\u012Bptiuncul\u0101s et {@code 18 = XVII} et {@code 6 = VI} et {@code 18 / 6 = 3 = III} pr\u014Dd\u016Bcat.
   */
  @Test @Order(7)
  public void divisionis( ) {
    @NonNull final Range <Short> range = Range.between((short) 6, (short) 18);
    System.out.println(new Tentamen.TentamenMathēmaticum(range, '/')
                         .exsequar(structor.numerus(range.getMaximum())));
  }

  /**
   * Modus hic m\u0101nsi\u014Dnem r\u0113rum du\u0101rum classis {@link VerbumSimplex.Numerus}. <br>
   * Scr\u012Bptiuncul\u0101s et {@code 12 = XII} et {@code 9 = IX} et {@code 12 % 9 = 3 = III} pr\u014Dd\u016Bcat.
   */
  @Test @Order(8)
  public void mansionis( ) {
    @NonNull final Range <Short> range = Range.between((short) 9, (short) 12);
    System.out.println(new Tentamen.TentamenMathēmaticum(range, '%')
                         .exsequar(structor.numerus(range.getMaximum())));
  }
}
