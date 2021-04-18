package net.strūctorverba.tentāmina;


import lombok.Getter;
import lombok.experimental.Accessors;
import net.strūctorverba.mīscella.StrūctorVerba;
import net.strūctorverba.verba.VerbumSimplex;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.*;
import org.junit.platform.commons.util.StringUtils;

@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection", "FieldCanBeLocal" })
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Numerī {
  @NotNull @Getter(lazy = true) @Accessors(fluent = true)
  private final StrūctorVerba strūctor = StrūctorVerba.fac.get();

  private final short NUMERUM_MAXIMUM = 3999;
  private final short XLII_NUMERUM    = 42;

  private final @NotNull String XLII_SCRĪPTIŌ = "XLII";

  @Test @Order(1)
  public void conversiōnis() {
    final VerbumSimplex.Numerus numerus = strūctor().numerus(XLII_NUMERUM);
    Assertions.assertNotNull(numerus, String.format("Prōductā conversiōnis est relicta prōductiō numerī %s.", XLII_NUMERUM));
    Assertions.assertTrue(StringUtils.isNotBlank(numerus.toString()), "Numerum prōductum conversiōnis vacat.");
    Assertions.assertEquals(XLII_SCRĪPTIŌ, numerus.toString(),
                            "Numerum prōductum conversiōnis expectātiōne eius differt.");

    System.out.printf("%d = %s%n", XLII_NUMERUM, numerus);
  }

  @Test @Order(2)
  public void reversiōnis() {
    final VerbumSimplex.Numerus numerus = strūctor().numerus(XLII_SCRĪPTIŌ);
    Assertions.assertNotNull(numerus, String.format("Prōductō reversiōnis est relicta prōductiō numerī %s.",
                                                    XLII_SCRĪPTIŌ));
    Assertions.assertEquals(XLII_NUMERUM, numerus.numerus,
                            "Numerum prōductum reversiōnis expectātiōne eius differt.");

    System.out.printf("%s = %d%n", XLII_SCRĪPTIŌ, numerus.numerus);
  }

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

  @Test @Order(8)
  public void mānsiōnis() {
    final short numerusPrīmus = 6;
    final short numerusSecundus = 18;
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
