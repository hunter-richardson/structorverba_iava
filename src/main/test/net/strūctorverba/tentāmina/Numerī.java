package net.strūctorverba.tentāmina;

import lombok.Getter;
import lombok.experimental.Accessors;
import net.strūctorverba.mīscella.*;
import net.strūctorverba.verba.VerbumSimplex;
import org.apache.commons.lang3.StringUtils;
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

  @NotNull private String perpetram(final short numerusPrīmus, final short numerusSecundus, final char operātiō) {
    final String labor = switch (operātiō) {
                           case '+' -> "additiōnis";
                           case '-' -> "subtractiōnis";
                           case '*' -> "multiplicātiōnis";
                           case '/' -> "dīvīsiōnis";
                           case '%' -> "mānsiōnis";
                           default -> StringUtils.EMPTY;
                         };
    if(StringUtils.isNotBlank(labor)) {
      final short expectātus = switch (operātiō) {
                                 case '+' -> (short) (numerusPrīmus + numerusSecundus);
                                 case '-' -> (short) (numerusPrīmus - numerusSecundus);
                                 case '*' -> (short) (numerusPrīmus * numerusSecundus);
                                 case '/' -> (short) (numerusPrīmus / numerusSecundus);
                                 case '%' -> (short) (numerusPrīmus % numerusSecundus);
                                 default -> (short) 0;
                               };

      final VerbumSimplex.Numerus prīmus = strūctor().numerus(numerusPrīmus);
      Assertions.assertNotNull(prīmus, String.format("Prōductō %s est relicta prōductiō numerī %d.", labor, numerusPrīmus));
      final VerbumSimplex.Numerus secundus = strūctor().numerus(numerusSecundus);
      Assertions.assertNotNull(secundus, String.format("Prōductō %s est relicta prōductiō numerī %d.", labor, numerusSecundus));

      final VerbumSimplex.Numerus ēventus = switch (operātiō) {
                                              case '+' -> prīmus.addō(secundus);
                                              case '-' -> prīmus.subtrahō(secundus);
                                              case '*' -> prīmus.multiplicō(secundus);
                                              case '/' -> prīmus.dīvidō(secundus);
                                              case '%' -> prīmus.maneō(secundus);
                                              default -> null;
                                            };

      Assertions.assertNotNull(ēventus, String.format("Prōductō %s est relicta prōductiō numerī %d.", labor, expectātus));
      Assertions.assertTrue(StringUtils.isNotBlank(ēventus.toString()),
                            String.format("Numerum prōductum %s vacat.", labor));

      return String.format("%d = %s%n%d = %s%n%d %c %d = %d = %s%n",
                           numerusPrīmus, prīmus, numerusSecundus, secundus,
                           numerusPrīmus, operātiō, numerusSecundus, expectātus, ēventus);
    } else {
      return StringUtils.EMPTY;
    }
  }

  /**
   * Modus hic conversiōnem ā numerō reī classis {@link VerbumSimplex.Numerus} tentat. <br>
   * Scrīptiunculam "42 = XLII" prōdūcat.
   */
  @Test @Order(1)
  public void conversiōnis() {
    final VerbumSimplex.Numerus numerus = strūctor().numerus(XLII_NUMERUM);
    Assertions.assertNotNull(numerus, String.format("Prōductā conversiōnis est relicta prōductiō numerī %s.", XLII_NUMERUM));
    Assertions.assertTrue(StringUtils.isNotBlank(numerus.toString()), "Numerum prōductum conversiōnis vacat.");
    Assertions.assertEquals(XLII_SCRĪPTIŌ, numerus.toString(),
                            "Numerum prōductum conversiōnis expectātiōne eius differt.");

    System.out.printf("%d = %s%n", XLII_NUMERUM, numerus);
  }

  /**
   * Modus hic reversiōnem ā rē classis {@link VerbumSimplex.Numerus} numerō tentat. <br>
   * Scrīptiunculam "XLII = 42" prōdūcat.
   */
  @Test @Order(2)
  public void reversiōnis() {
    final VerbumSimplex.Numerus numerus = strūctor().numerus(XLII_SCRĪPTIŌ);
    Assertions.assertNotNull(numerus, String.format("Prōductō reversiōnis est relicta prōductiō numerī %s.",
                                                    XLII_SCRĪPTIŌ));
    Assertions.assertEquals(XLII_NUMERUM, numerus.numerus,
                            "Numerum prōductum reversiōnis expectātiōne eius differt.");

    System.out.printf("%s = %d%n", XLII_SCRĪPTIŌ, numerus.numerus);
  }

  /**
   * Modus hic conversiōnem ā numerō reī classis {@link VerbumSimplex.Numerus} atque reversiōnem versam tentat. <br>
   * Scrīptiunculās et "42 = XLII" et "XLII = 42" dē numerō nescītō inter I et MMMCMXCIX prōdūcat.
   */
  @Test @Order(3)
  public void combīnātiōnis() {
    final short numerus = (short) Math.round((NUMERUM_MAXIMUM + 1) * Math.random() + 1);

    final VerbumSimplex.Numerus prīmus = strūctor().numerus(numerus);
    Assertions.assertNotNull(prīmus, String.format("Prōductō combīnātiōnis est relicta prōductiō numerī %d.", numerus));
    Assertions.assertTrue(StringUtils.isNotBlank(prīmus.toString()), "Numerum prōductum combīnātiōnis vacat.");

    final VerbumSimplex.Numerus secundus = strūctor().numerus(prīmus.toString());
    Assertions.assertNotNull(secundus, String.format("Prōductō combīnātiōnis est relicta prōductiō numerī %d.", numerus));
    Assertions.assertEquals(numerus, secundus.numerus,
                            "Numerum prōductum combīnātiōnis expectātiōne eius differt.");

    System.out.printf("%s = %d%n%d = %s%n", prīmus, numerus, numerus, secundus);
  }

  /**
   * Modus hic additiōnem rērum duārum classis {@link VerbumSimplex.Numerus}. <br>
   * Scrīptiunculās et <code>17 = XVIII</code> et <code>3 = III</code> et <code>17 + 3 = 20 = XX</code> prōdūcat.
   */
  @Test @Order(4)
  public void additiōnis() {
    System.out.println(perpetram((short) 17, (short) 3, '+'));
  }

  /**
   * Modus hic subtractiōnem rērum duārum classis {@link VerbumSimplex.Numerus}. <br>
   * Scrīptiunculās et <code>12 = XII</code> et <code>7 = VII</code> et <code>12 - 7 = 5 = V</code> prōdūcat.
   */
  @Test @Order(5)
  public void subtractiōnis() {
    System.out.println(perpetram((short) 12,(short) 7, '-'));
  }

  /**
   * Modus hic multiplicātiōnem rērum duārum classis {@link VerbumSimplex.Numerus}. <br>
   * Scrīptiunculās et <code>3 = III</code> et <code>2 = II</code> et <code>3 * 2 = 6 = VI</code> prōdūcat.
   */
  @Test @Order(6)
  public void multiplicātiōnis() {
    System.out.println(perpetram((short) 3,(short) 2, '*'));
  }

  /**
   * Modus hic dīvīsiōnem rērum duārum classis {@link VerbumSimplex.Numerus}. <br>
   * Scrīptiunculās et <code>18 = XVII</code> et <code>6 = VI</code> et <code>18 / 6 = 3 = III</code> prōdūcat.
   */
  @Test @Order(7)
  public void dīvīsiōnis() {
    System.out.println(perpetram((short) 18,(short) 6, '/'));
  }

  /**
   * Modus hic mānsiōnem rērum duārum classis {@link VerbumSimplex.Numerus}. <br>
   * Scrīptiunculās et <code>12 = XII</code> et <code>9 = IX</code> et <code>12 % 9 = 3 = III</code> prōdūcat.
   */
  @Test @Order(8)
  public void mānsiōnis() {
    System.out.println(perpetram((short) 12,(short) 9, '%'));
  }
}
