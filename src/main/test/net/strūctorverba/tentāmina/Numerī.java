package net.strūctorverba.tentāmina;


import lombok.Getter;
import lombok.experimental.Accessors;
import net.strūctorverba.mīscella.StrūctorVerba;
import net.strūctorverba.verba.VerbumSimplex;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.*;
import org.junit.platform.commons.util.StringUtils;

/**
 * Classis {@link Numerī} operātiōnēs mathēmaticās rērum classis {@link VerbumSimplex.Numerus} tentat.
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection", "FieldCanBeLocal" })
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Numerī {
  @NotNull @Getter(lazy = true) @Accessors(fluent = true)
  private final StrūctorVerba strūctor = StrūctorVerba.fac.get();

  private final short NUMERUM_MAXIMUM = 3999;
  private final short XLII_NUMERUM    = 42;

  private final @NotNull String XLII_SCRĪPTIŌ = "XLII";

  /**
   * Modus hic conversiōnem ā numerō reī classis {@link VerbumSimplex.Numerus} tentat.
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
   * Modus hic reversiōnem ā rē classis {@link VerbumSimplex.Numerus} numerō tentat.
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
   * Modus hic conversiōnem ā numerō reī classis {@link VerbumSimplex.Numerus} atque reversiōnem versam tentat.
   * Scrīptiunculās et "42 = XLII" et "XLII = 42" dē numerō nescītō inter I et MMMCMXCIX prōdūcat.
   */
  @Test @Order(3)
  public void combīnātiōnis() {
    final short numerus = Integer.valueOf(Math.toIntExact(Math.round((NUMERUM_MAXIMUM + 1) * Math.random()))).shortValue();

    final VerbumSimplex.Numerus prīmus = strūctor().numerus(numerus);
    Assertions.assertNotNull(prīmus, String.format("Prōductō combīnātiōnis est relicta prōductiō numerī %d.", numerus));
    Assertions.assertTrue(StringUtils.isNotBlank(prīmus.toString()), "Numerum prōductum combīnātiōnis vacat.");

    final VerbumSimplex.Numerus secundus = strūctor().numerus(prīmus.toString());
    Assertions.assertNotNull(secundus, String.format("Prōductō combīnātiōnis est relicta prōductiō numerī %d.", numerus));
    Assertions.assertEquals(numerus, secundus.numerus,
                            "Numerum prōductum combīnātiōnis expectātiōne eius differt.");

    System.out.printf("%s = %d%n", prīmus, numerus);
    System.out.printf("%d = %s%n", numerus, secundus);
  }

  /**
   * Modus hic additiōnem rērum duārum classis {@link VerbumSimplex.Numerus}.
   * Scrīptiunculās et "17 = XVIII" et "3 = III" et "17 + 3 = 20 = XX" prōdūcat.
   */
  @Test @Order(4)
  public void additiōnis() {
    final short numerusPrīmus = 17;
    final short numerusSecundus = 3;
    final short expectātus = numerusPrīmus + numerusSecundus;

    final VerbumSimplex.Numerus prīmus = strūctor().numerus(numerusPrīmus);
    Assertions.assertNotNull(prīmus, String.format("Prōductō additiōnis est relicta prōductiō numerī %d.", numerusPrīmus));
    final VerbumSimplex.Numerus secundus = strūctor().numerus(numerusSecundus);
    Assertions.assertNotNull(secundus, String.format("Prōductō additiōnis est relicta prōductiō numerī %d.", numerusSecundus));
    final VerbumSimplex.Numerus ēventus = prīmus.addō(secundus);

    Assertions.assertNotNull(ēventus, String.format("Prōductō additiōnis est relicta prōductiō numerī %d.", expectātus));
    Assertions.assertTrue(StringUtils.isNotBlank(ēventus.toString()),
                          "Numerum prōductum additiōnis vacat.");
    Assertions.assertEquals(ēventus.numerus, expectātus,
                            "Numerum prōductum additiōnis expectātiōne eius differt.");

    System.out.printf("%d = %s%n", numerusPrīmus, prīmus);
    System.out.printf("%d = %s%n", numerusSecundus, secundus);
    System.out.printf("%d + %d = %d = %s%n", numerusPrīmus, numerusSecundus, expectātus, ēventus);
  }

  /**
   * Modus hic subtractiōnem rērum duārum classis {@link VerbumSimplex.Numerus}.
   * Scrīptiunculās et "12 = XII" et "7 = VII" et "12 - 7 = 5 = V" prōdūcat.
   */
  @Test @Order(5)
  public void subtractiōnis() {
    final short numerusPrīmus = 12;
    final short numerusSecundus = 7;
    final short expectātus = numerusPrīmus - numerusSecundus;

    final VerbumSimplex.Numerus prīmus = strūctor().numerus(numerusPrīmus);
    Assertions.assertNotNull(prīmus, String.format("Prōductō subtractiōnis est relicta prōductiō numerī %d.", numerusPrīmus));
    final VerbumSimplex.Numerus secundus = strūctor().numerus(numerusSecundus);
    Assertions.assertNotNull(secundus, String.format("Prōductō subtractiōnis est relicta prōductiō numerī %d.", numerusSecundus));

    final VerbumSimplex.Numerus ēventus = prīmus.subtrahō(secundus);
    Assertions.assertNotNull(ēventus, String.format("Prōductō subtractiōnis est relicta prōductiō numerī %d.", expectātus));
    Assertions.assertTrue(StringUtils.isNotBlank(ēventus.toString()),
                          "Numerum prōductum subtractiōnis vacat.");
    Assertions.assertEquals(ēventus.numerus, expectātus,
                            "Numerum prōductum subtractiōnis expectātiōne eius differt.");

    System.out.printf("%d = %s%n", numerusPrīmus, prīmus);
    System.out.printf("%d = %s%n", numerusSecundus, secundus);
    System.out.printf("%d - %d = %d = %s%n", numerusPrīmus, numerusSecundus, expectātus, ēventus);
  }

  /**
   * Modus hic multiplicātiōnem rērum duārum classis {@link VerbumSimplex.Numerus}.
   * Scrīptiunculās et "3 = III" et "2 = II" et "3 * 2 = 5 = VI" prōdūcat.
   */
  @Test @Order(6)
  public void multiplicātiōnis() {
    final short numerusPrīmus = 3;
    final short numerusSecundus = 2;
    final short expectātus = numerusPrīmus * numerusSecundus;

    final VerbumSimplex.Numerus prīmus = strūctor().numerus(numerusPrīmus);
    Assertions.assertNotNull(prīmus, String.format("Prōductō multiplicātiōnis est relicta prōductiō numerī %d.", numerusPrīmus));
    final VerbumSimplex.Numerus secundus = strūctor().numerus(numerusSecundus);
    Assertions.assertNotNull(secundus, String.format("Prōductō multiplicātiōnis est relicta prōductiō numerī %d.", numerusSecundus));
    final VerbumSimplex.Numerus ēventus = prīmus.multiplicō(secundus);

    Assertions.assertNotNull(ēventus, String.format("Prōductō multiplicātiōnis est relicta prōductiō numerī %d.", expectātus));
    Assertions.assertTrue(StringUtils.isNotBlank(ēventus.toString()),
                          "Numerum prōductum multiplicātiōnis vacat.");
    Assertions.assertEquals(ēventus.numerus, expectātus,
                            "Numerum prōductum multiplicātiōnis expectātiōne eius differt.");

    System.out.printf("%d = %s%n", numerusPrīmus, prīmus);
    System.out.printf("%d = %s%n", numerusSecundus, secundus);
    System.out.printf("%d * %d = %d = %s%n", numerusPrīmus, numerusSecundus, expectātus, ēventus);
  }

  /**
   * Modus hic dīvīsiōnem rērum duārum classis {@link VerbumSimplex.Numerus}.
   * Scrīptiunculās et "18 = XVII" et "6 = VI" et "18 / 6 = 3 = III" prōdūcat.
   */
  @Test @Order(7)
  public void dīvīsiōnis() {
    final short numerusPrīmus = 18;
    final short numerusSecundus = 6;
    final short expectātus = numerusPrīmus / numerusSecundus;

    final VerbumSimplex.Numerus prīmus = strūctor().numerus(numerusPrīmus);
    Assertions.assertNotNull(prīmus, String.format("Prōductō dīvīsiōnis est relicta prōductiō numerī %d.", numerusPrīmus));
    final VerbumSimplex.Numerus secundus = strūctor().numerus(numerusSecundus);
    Assertions.assertNotNull(secundus, String.format("Prōductō dīvīsiōnis est relicta prōductiō numerī %d.", numerusSecundus));
    final VerbumSimplex.Numerus ēventus = prīmus.dīvidō(secundus);

    Assertions.assertNotNull(ēventus, String.format("Prōductō dīvīsiōnis est relicta prōductiō numerī %d.", expectātus));
    Assertions.assertTrue(StringUtils.isNotBlank(ēventus.toString()),
                          "Numerum prōductum dīvīsiōnis vacat.");
    Assertions.assertEquals(ēventus.numerus, expectātus,
                            "Numerum prōductum dīvīsiōnis expectātiōne eius differt.");

    System.out.printf("%d = %s%n", numerusPrīmus, prīmus);
    System.out.printf("%d = %s%n", numerusSecundus, secundus);
    System.out.printf("%d / %d = %d = %s%n", numerusPrīmus, numerusSecundus, expectātus, ēventus);
  }

  /**
   * Modus hic mānsiōnem rērum duārum classis {@link VerbumSimplex.Numerus}.
   * Scrīptiunculās et "12 = XII" et "9 = IX" et "12 % 9 = 3 = III" prōdūcat.
   */
  @Test @Order(8)
  public void mānsiōnis() {
    final short numerusPrīmus = 12;
    final short numerusSecundus = 9;
    final short expectātus = numerusPrīmus % numerusSecundus;

    final VerbumSimplex.Numerus prīmus = strūctor().numerus(numerusPrīmus);
    Assertions.assertNotNull(prīmus, String.format("Prōductō mānsiōnis est relicta prōductiō numerī %d.", numerusPrīmus));
    final VerbumSimplex.Numerus secundus = strūctor().numerus(numerusSecundus);
    Assertions.assertNotNull(secundus, String.format("Prōductō mānsiōnis est relicta prōductiō numerī %d.", numerusSecundus));
    final VerbumSimplex.Numerus ēventus = prīmus.maneō(secundus);

    Assertions.assertNotNull(ēventus, String.format("Prōductō mānsiōnis est relicta prōductiō numerī %d.", expectātus));
    Assertions.assertTrue(StringUtils.isNotBlank(ēventus.toString()),
                          "Numerum prōductum mānsiōnis vacat.");
    Assertions.assertEquals(ēventus.numerus, expectātus,
                            "Numerum prōductum mānsiōnis expectātiōne eius differt.");

    System.out.printf("%d = %s%n", numerusPrīmus, prīmus);
    System.out.printf("%d = %s%n", numerusSecundus, secundus);
    System.out.printf("%d %% %d = %d = %s%n", numerusPrīmus, numerusSecundus, expectātus, ēventus);
  }
}
