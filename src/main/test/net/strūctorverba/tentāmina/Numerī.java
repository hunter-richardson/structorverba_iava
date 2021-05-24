package net.strūctorverba.tentāmina;

import lombok.Getter;
import lombok.experimental.Accessors;
import net.strūctorverba.mīscella.*;
import net.strūctorverba.verba.VerbumSimplex;
import org.apache.commons.lang3.Range;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.*;

/**
 * Classis {@link Numerī} operātiōnēs mathēmaticās rērum classis {@link VerbumSimplex.Numerus} tentat.
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection", "FieldCanBeLocal" })
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Numerī extends Omnum {
  @NotNull @Getter(lazy = true) @Accessors(fluent = true)
  private final StrūctorVerba strūctor = StrūctorVerba.fac.get();

  private final short NUMERUM_MAXIMUM = 3998;
  private final short XLII_NUMERUM    = 42;

  private final @NotNull String XLII_SCRĪPTIŌ = "XLII";

  /**
   * Modus hic conversiōnem ā numerō reī classis {@link VerbumSimplex.Numerus} tentat. <br> Scrīptiunculam {@code 42 =
   * XLII} prōdūcat.
   */
  @Test @Order(1)
  public void conversiōnis( ) {
    System.out.println(new Tentāmen.TentāmenNumerāleConversiōnis(XLII_SCRĪPTIŌ, XLII_NUMERUM)
                         .exsequar(strūctor().numerus(XLII_NUMERUM)));
  }

  /**
   * Modus hic reversiōnem ā rē classis {@link VerbumSimplex.Numerus} numerō tentat. <br> Scrīptiunculam {@code XLII =
   * 42} prōdūcat.
   */
  @Test @Order(2)
  public void reversiōnis( ) {
    System.out.println(new Tentāmen.TentāmenNumerāleReversiōnis(XLII_NUMERUM, XLII_SCRĪPTIŌ)
                         .exsequar(strūctor().numerus(XLII_SCRĪPTIŌ)));
  }

  /**
   * Modus hic conversiōnem ā numerō reī classis {@link VerbumSimplex.Numerus} atque reversiōnem versam tentat. <br>
   * Scrīptiunculās et {@code 42 = XLII} et {@code XLII = 42} dē numerō nescītō inter I et MMMCMXCIX prōdūcat.
   */
  @Test @Order(3)
  public void combīnātiōnis( ) {
    final short numerus = (short) Math.round((NUMERUM_MAXIMUM + 1) * Math.random() + 1);
    System.out.println(new Tentāmen.TentāmenNumerāleCombīnātiōnis(numerus)
                         .exsequar(strūctor().numerus(numerus)));
  }

  /**
   * Modus hic additiōnem rērum duārum classis {@link VerbumSimplex.Numerus}. <br> Scrīptiunculās et {@code 17 = XVIII}
   * et {@code 3 = III} et {@code 17 + 3 = 20 = XX} prōdūcat.
   */
  @Test @Order(4)
  public void additiōnis( ) {
    @NotNull final Range <Short> range = Range.between((short) 3, (short) 17);
    System.out.println(new Tentāmen.TentāmenMathēmaticum(range, '+')
                         .exsequar(strūctor().numerus(range.getMaximum())));
  }

  /**
   * Modus hic subtractiōnem rērum duārum classis {@link VerbumSimplex.Numerus}. <br> Scrīptiunculās et {@code 12 = XII}
   * et {@code 7 = VII} et {@code 12 - 7 = 5 = V} prōdūcat.
   */
  @Test @Order(5)
  public void subtractiōnis( ) {
    @NotNull final Range <Short> range = Range.between((short) 7, (short) 12);
    System.out.println(new Tentāmen.TentāmenMathēmaticum(range, '-')
                         .exsequar(strūctor().numerus(range.getMaximum())));
  }

  /**
   * Modus hic multiplicātiōnem rērum duārum classis {@link VerbumSimplex.Numerus}. <br> Scrīptiunculās et {@code 3 =
   * III} et {@code 2 = II} et {@code 3 * 2 = 6 = VI} prōdūcat.
   */
  @Test @Order(6)
  public void multiplicātiōnis( ) {
    @NotNull final Range <Short> range = Range.between((short) 2, (short) 3);
    System.out.println(new Tentāmen.TentāmenMathēmaticum(range, '*')
                         .exsequar(strūctor().numerus(range.getMaximum())));
  }

  /**
   * Modus hic dīvīsiōnem rērum duārum classis {@link VerbumSimplex.Numerus}. <br> Scrīptiunculās et {@code 18 = XVII}
   * et {@code 6 = VI} et {@code 18 / 6 = 3 = III} prōdūcat.
   */
  @Test @Order(7)
  public void dīvīsiōnis( ) {
    @NotNull final Range <Short> range = Range.between((short) 6, (short) 18);
    System.out.println(new Tentāmen.TentāmenMathēmaticum(range, '/')
                         .exsequar(strūctor().numerus(range.getMaximum())));
  }

  /**
   * Modus hic mānsiōnem rērum duārum classis {@link VerbumSimplex.Numerus}. <br> Scrīptiunculās et {@code 12 = XII} et
   * {@code 9 = IX} et {@code 12 % 9 = 3 = III} prōdūcat.
   */
  @Test @Order(8)
  public void mānsiōnis( ) {
    @NotNull final Range <Short> range = Range.between((short) 9, (short) 12);
    System.out.println(new Tentāmen.TentāmenMathēmaticum(range, '%')
                         .exsequar(strūctor().numerus(range.getMaximum())));
  }
}
