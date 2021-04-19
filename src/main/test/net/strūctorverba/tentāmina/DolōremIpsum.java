package net.strūctorverba.tentāmina;

import lombok.Getter;
import lombok.experimental.Accessors;
import net.strūctorverba.mīscella.*;
import net.strūctorverba.verba.*;
import net.strūctorverba.ēnumerātiōnēs.*;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.*;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.*;

import java.util.LinkedList;

/**
 * Classis {@link DolōremIpsum} versiōnem prīmam tentāminārum programmātī StrūctorVerba dēfīnit. <br>
 * Laudem Marcō Tulliō Cicerōnī cum parte dialogī Sōcraticus "Dē Fīnibus Bonōrum et Mālōrum" in librō prīmō sectiōne decimā versū duotrīcēsimō cōnstruat. <br>
 * Versūs ante triēntem prīmam incipit et post fīnālem fīnit. <br>
 * Pars illa est agnita poēmam istam "Lorem Ipsum" īnspīrāvisse.
 * @see <a href="http://www.thelatinlibrary.com/cicero/fin1.shtml#32">Dē Fīnibus Bonōrum et Mālōrum
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection", "FieldCanBeLocal" })
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public final class DolōremIpsum {
  @NotNull @Getter(lazy = true) @Accessors(fluent = true)
  private final StrūctorVerba strūctor = StrūctorVerba.fac.get();

  private final @NotNull String prōductaPrīma   = "Neque porrō quisquam est";
  private final @NotNull String prōductaSecunda = "Quī dolōrem ipsum quia dolor sit amet";
  private final @NotNull String prōductaTertia  = "Cōnsectētur adipīscī velit";
  private final @NotNull String prōductaQuārta  = "Sed quia nōnnumquam eius modī tempora incidunt ut labōre et dolōre magnam aliquam quaerat voluptātem";
  private final @NotNull String prōductaCūncta  = "Neque porrō quisquam est quī dolōrem ipsum quia dolor sit amet cōnsectētur adipīscī velit sed quia nōnnumquam eius modī tempora incidunt ut labōre et dolōre magnam aliquam quaerat voluptātem";

  /**
   * Modus hic partem prīmam tentat. <br>
   * Verba "Neque porrō quisquam est" prōdūcat.
   */
  @Test @Order(1)
  public void prīma( ) {
    Verbum <?>[] seriēs = {
      strūctor().adverbiumLege().adveniam("neque"),
      strūctor().adverbiumLege().adveniam("porrō"),
      strūctor().prōnōmenConiūnctīvumLege()
                .adveniam("quisquam",
                          Speciālitās.COMMŪNE, Genus.MASCULĪNUM, Cāsus.NŌMINĀTĪVUS, Numerālis.SINGULĀRIS),
      strūctor().āctumLege()
                .adveniam(Modus.INDICĀTĪVUS, Vōx.ĀCTĪVA, Tempus.PRAESĒNS, Numerālis.SINGULĀRIS, Persōna.TERTIA)
    };

    Assertions.assertTrue(ArrayUtils.isNotEmpty(seriēs), "Verba prōducta prīma vacant.");
    for (int index = 0; index < seriēs.length; index++) {
      Assertions.assertNotNull(seriēs[index],
                               String.format("Prōductā prīmā est relicta prōductiō verbī %s.",
                                             Ūtilitās
                                               .minusculāsScrībō(prōductaPrīma.split(String.valueOf(' '))[index])));
      Assertions.assertTrue(StringUtils.isNotBlank(seriēs[index].toString()),
                            String.format("Vacat prōductum verbum %s.",
                                          Ūtilitās.minusculāsScrībō(prōductaPrīma.split(String.valueOf(' '))[index])));
    }

    String haec = strūctor().strue(seriēs).toString();
    Assertions.assertEquals(prōductaPrīma, haec, "Verba prōducta prīma expectātiōne eius differt.");

    System.out.printf("Prōducta prīma: %s%n", haec);
  }

  /**
   * Modus hic partem secundam tentat. <br>
   * Verba "Quī dolōrem ipsum quia dolor sit amet" prōdūcat.
   */
  @Test @Order(2)
  public void secunda( ) {
    Verbum <?>[] seriēs = {
      strūctor().prōnōmenConiūnctīvumLege()
                .adveniam("quis",
                          Speciālitās.COMMŪNE, Genus.MASCULĪNUM, Cāsus.NŌMINĀTĪVUS, Numerālis.PLŪRĀLIS),
      strūctor().nōmenLege()
                .adveniam("dolor",
                          Speciālitās.COMMŪNE, Genus.MASCULĪNUM, Cāsus.ACCŪSĀTĪVUS, Numerālis.SINGULĀRIS),
      strūctor().prōnōmenConiūnctīvumLege()
                .adveniam("ipsum",
                          Speciālitās.COMMŪNE, Genus.MASCULĪNUM, Cāsus.NŌMINĀTĪVUS, Numerālis.SINGULĀRIS),
      strūctor().adverbiumLege().adveniam("quia"),
      strūctor().nōmenLege()
                .adveniam("dolor",
                          Speciālitās.COMMŪNE, Genus.MASCULĪNUM, Cāsus.NŌMINĀTĪVUS, Numerālis.SINGULĀRIS),
      strūctor().āctumLege()
                .adveniam(Modus.SUBIŪNCTĪVUS, Vōx.ĀCTĪVA, Tempus.PRAESĒNS, Numerālis.SINGULĀRIS, Persōna.TERTIA),
      strūctor().āctumLege()
                .adveniam("amāre",
                          Modus.SUBIŪNCTĪVUS, Vōx.ĀCTĪVA, Tempus.PRAESĒNS, Numerālis.SINGULĀRIS, Persōna.TERTIA)
    };

    Assertions.assertTrue(ArrayUtils.isNotEmpty(seriēs), "Verba prōducta secunda vacant.");
    for (int index = 0; index < seriēs.length; index++) {
      Assertions.assertNotNull(seriēs[index],
                               String.format("Prōductā secundā est relicta prōductiō verbī %s.",
                                             Ūtilitās.minusculāsScrībō(prōductaSecunda.split(String.valueOf(' '))[index])));
      Assertions.assertTrue(StringUtils.isNotBlank(seriēs[index].toString()),
                            String.format("Vacat prōductum verbum %s.",
                                          Ūtilitās.minusculāsScrībō(prōductaSecunda.split(String.valueOf(' '))[index])));
    }

    String haec = strūctor().strue(seriēs).toString();
    Assertions.assertEquals(prōductaSecunda, haec, "Verba prōducta secunda expectātiōne eius differt.");

    System.out.printf("Prōducta secunda: %s%n", haec);
  }

  /**
   * Modus hic partem tertiam tentat. <br>
   * Verba "Cōnsectētur adipīscī velit" prōdūcat.
   */
  @Test @Order(3)
  public void tertia( ) {
    Verbum <?>[] seriēs = {
      strūctor().āctumLege()
                .adveniam("cōnsectārī",
                          Modus.SUBIŪNCTĪVUS, Vōx.ĀCTĪVA, Tempus.PRAESĒNS, Numerālis.SINGULĀRIS, Persōna.TERTIA),
      strūctor().āctumLege()
                .adveniam("adipīscī",
                          Modus.ĪNFĪNĪTĪVUS, Vōx.ĀCTĪVA, Tempus.PRAESĒNS),
      strūctor().āctumLege()
                .adveniam("velle",
                          Modus.SUBIŪNCTĪVUS, Vōx.ĀCTĪVA, Tempus.PRAESĒNS, Numerālis.SINGULĀRIS, Persōna.TERTIA)
    };

    Assertions.assertTrue(ArrayUtils.isNotEmpty(seriēs), "Verba prōducta tertia vacant.");
    for (int index = 0; index < seriēs.length; index++) {
      Assertions.assertNotNull(seriēs[index],
                               String.format("Prōductā tertiā est relicta prōductiō verbī %s.",
                                             Ūtilitās.minusculāsScrībō(prōductaTertia.split(String.valueOf(' '))[index])));
      Assertions.assertTrue(StringUtils.isNotBlank(seriēs[index].toString()),
                            String.format("Vacat prōductum verbum %s.",
                                          Ūtilitās.minusculāsScrībō(prōductaTertia.split(String.valueOf(' '))[index])));
    }

    String haec = strūctor().strue(seriēs).toString();
    Assertions.assertEquals(prōductaTertia, haec, "Verba prōducta tertia expectātiōne eius differt.");

    System.out.printf("Prōducta tertia: %s%n", haec);
  }

  /**
   * Modus hic partem quārtam tentat. <br>
   * Verba "Sed quia nōnnumquam eius modī tempora incidunt ut labōre et dolōre magnam aliquam quaerat voluptātem" prōdūcat. <br>
   * Prīncipāliter tentat quod modī et {@link Coniugiāle#coniugō(Verbum, Verbum)} rēctē operat sī tentāmina trēs prīma prosperantur.
   */
  @Test @Order(4)
  public void quārta( ) {
    Verbum <?>[] seriēsPrīma = {
      strūctor().coniūnctīvumLege().adveniam("sed"),
      strūctor().adverbiumLege().adveniam("quia"),
      strūctor().adverbiumLege().adveniam("nōnnumquam"),
      strūctor().prōnōmenLege()
                .adveniam("is",
                          Speciālitās.COMMŪNE, Genus.MASCULĪNUM, Cāsus.GENITĪVUS, Numerālis.SINGULĀRIS),
      strūctor().nōmenLege()
                .adveniam("modus",
                          Speciālitās.COMMŪNE, Genus.MASCULĪNUM, Cāsus.GENITĪVUS, Numerālis.SINGULĀRIS),
      strūctor().nōmenLege()
                .adveniam("tempus",
                          Speciālitās.COMMŪNE, Genus.MASCULĪNUM, Cāsus.ABLĀTĪVUS, Numerālis.SINGULĀRIS),
      strūctor().āctumLege()
                .adveniam("incidere",
                          Modus.INDICĀTĪVUS, Vōx.ĀCTĪVA, Tempus.PRAESĒNS, Numerālis.PLŪRĀLIS, Persōna.TERTIA)
    };

    Assertions.assertTrue(ArrayUtils.isNotEmpty(seriēsPrīma), "Verba prōducta quārta vacant.");
    for (int index = 0; index < seriēsPrīma.length; index++) {
      final String[] parsQuārta = prōductaQuārta.split("ut")[0].split(String.valueOf(' '));
      Assertions.assertNotNull(seriēsPrīma[index],
                               String.format("Prōductā quārtā est relicta prōductiō verbī %s.",
                                             Ūtilitās.minusculāsScrībō(parsQuārta[index])));
      Assertions.assertTrue(StringUtils.isNotBlank(seriēsPrīma[index].toString()),
                            String.format("Vacat prōductum verbum %s.", Ūtilitās.minusculāsScrībō(parsQuārta[index])));
    }

    VerbumSimplex.Coniūnctīvum coniūnctīvum = strūctor().coniūnctīvumLege().adveniam("et");
    Assertions.assertNotNull(coniūnctīvum, "Prōductā quārta est relicta prōductiō verbī et.");
    Assertions.assertTrue(StringUtils.isNotBlank(coniūnctīvum.toString()), "Vacat prōductum verbum et.");

    LinkedList <Verbum <?>> seriēsSecunda = coniūnctīvum.coniugō(
      strūctor().nōmenLege()
                .adveniam("labor",
                          Speciālitās.COMMŪNE, Genus.MASCULĪNUM, Cāsus.ABLĀTĪVUS, Numerālis.SINGULĀRIS),
      strūctor().nōmenLege()
                .adveniam("dolor",
                          Speciālitās.COMMŪNE, Genus.MASCULĪNUM, Cāsus.ABLĀTĪVUS, Numerālis.SINGULĀRIS));
    Assertions.assertFalse(CollectionUtils.isNotEmpty(seriēsSecunda), "Verba prōducta quārta vacant.");
    seriēsSecunda.add(strūctor().adiectīvumLege()
                                .adveniam("magnus",
                                          Speciālitās.COMMŪNE, Genus.FĒMINĪNUM, Cāsus.ACCŪSĀTĪVUS, Numerālis.SINGULĀRIS));
    seriēsSecunda.add(strūctor().prōnōmenConiūnctīvumLege()
                                .adveniam("aliquis",
                                          Speciālitās.COMMŪNE, Genus.FĒMINĪNUM, Cāsus.ACCŪSĀTĪVUS, Numerālis.SINGULĀRIS));
    seriēsSecunda.add(strūctor().āctumLege()
                                .adveniam("quaerere",
                                          Modus.SUBIŪNCTĪVUS, Vōx.ĀCTĪVA, Tempus.PRAESĒNS, Numerālis.SINGULĀRIS, Persōna.TERTIA));
    seriēsSecunda.add(strūctor().adiectīvumLege()
                                .adveniam("voluptās",
                                          Speciālitās.COMMŪNE, Genus.FĒMINĪNUM, Cāsus.ACCŪSĀTĪVUS, Numerālis.SINGULĀRIS));

    for (int index = 0; index < seriēsSecunda.size(); index++) {
      final String[] parsQuārta = prōductaQuārta.split("ut")[1].split(String.valueOf(' '));
      Assertions.assertNotNull(seriēsSecunda.get(index), String.format("Prōductā quārtā est relicta prōductiō verbī %s.",
                                                                       Ūtilitās.minusculāsScrībō(parsQuārta[index])));
      Assertions.assertTrue(StringUtils.isNotBlank(seriēsSecunda.get(index).toString()),
                            String.format("Vacat prōductum verbum %s.", Ūtilitās.minusculāsScrībō(parsQuārta[index])));
    }

    VerbumSimplex.Coniūnctīvum coniūnctīvumSecundum = strūctor().coniūnctīvumLege().adveniam("ut");
    Assertions.assertNotNull(coniūnctīvumSecundum, "Prōductā quārtā est relicta prōductiō verbī ut.");
    Assertions.assertTrue(StringUtils.isNotBlank(coniūnctīvumSecundum.toString()),
                          "Vacat prōductum verbum ut.");

    String haec = coniūnctīvumSecundum.coniugō(strūctor().strue(seriēsPrīma),
                                               strūctor().strue(seriēsSecunda)).toString();
    Assertions.assertEquals(prōductaQuārta, haec, "Verba prōducta quārta expectātiōne eius differt.");

    System.out.printf("Prōducta quārta: %s%n", haec);
  }

  /**
   * Modus hic tentāmina omnēs praevia coniugat. <br>
   * Verba "Neque porrō quisquam est quī dolōrem ipsum quia dolor sit amet cōnsectētur adipīscī velit sed quia nōnnumquam eius modī tempora incidunt ut labōre et dolōre magnam aliquam quaerat voluptātem" prōdūcat. <br>
   * Aboriētur sī tentāminum aliquid praevium aborītur atque prosperābitur sī omnēs prosperantur.
   */
  @Test @Order(5)
  public void cūncta() {
    Verbum <?>[] seriēsPrīma = {
      strūctor().coniūnctīvumLege().adveniam("neque"),
      strūctor().adverbiumLege().adveniam("porrō"),
      strūctor().prōnōmenConiūnctīvumLege()
                .adveniam("quisquam",
                          Speciālitās.COMMŪNE, Genus.MASCULĪNUM, Cāsus.NŌMINĀTĪVUS, Numerālis.SINGULĀRIS),
      strūctor().āctumLege()
                .adveniam(Modus.INDICĀTĪVUS, Vōx.ĀCTĪVA, Tempus.PRAESĒNS, Numerālis.SINGULĀRIS, Persōna.TERTIA),
      strūctor().prōnōmenConiūnctīvumLege()
                .adveniam("quis",
                          Speciālitās.COMMŪNE, Genus.MASCULĪNUM, Cāsus.NŌMINĀTĪVUS, Numerālis.PLŪRĀLIS),
      strūctor().nōmenLege()
                .adveniam("dolor",
                          Speciālitās.COMMŪNE, Genus.MASCULĪNUM, Cāsus.ACCŪSĀTĪVUS, Numerālis.SINGULĀRIS),
      strūctor().prōnōmenConiūnctīvumLege()
                .adveniam("ipsum",
                          Speciālitās.COMMŪNE, Genus.MASCULĪNUM, Cāsus.NŌMINĀTĪVUS, Numerālis.SINGULĀRIS),
      strūctor().adverbiumLege().adveniam("quia"),
      strūctor().nōmenLege()
                .adveniam("dolor",
                          Speciālitās.COMMŪNE, Genus.MASCULĪNUM, Cāsus.NŌMINĀTĪVUS, Numerālis.SINGULĀRIS),
      strūctor().āctumLege()
                .adveniam(Modus.SUBIŪNCTĪVUS, Vōx.ĀCTĪVA, Tempus.PRAESĒNS, Numerālis.SINGULĀRIS, Persōna.TERTIA),
      strūctor().āctumLege()
                .adveniam("amāre",
                          Modus.SUBIŪNCTĪVUS, Vōx.ĀCTĪVA, Tempus.PRAESĒNS, Numerālis.SINGULĀRIS, Persōna.TERTIA),
      strūctor().āctumLege()
                .adveniam("cōnsectārī",
                          Modus.SUBIŪNCTĪVUS, Vōx.ĀCTĪVA, Tempus.PRAESĒNS, Numerālis.SINGULĀRIS, Persōna.TERTIA),
      strūctor().āctumLege()
                .adveniam("adipīscī",
                          Modus.ĪNFĪNĪTĪVUS, Vōx.ĀCTĪVA, Tempus.PRAESĒNS, Numerālis.SINGULĀRIS, Persōna.TERTIA),
      strūctor().āctumLege()
                .adveniam("velle",
                          Modus.SUBIŪNCTĪVUS, Vōx.ĀCTĪVA, Tempus.PRAESĒNS, Numerālis.SINGULĀRIS, Persōna.TERTIA),
      strūctor().coniūnctīvumLege().adveniam("sed"),
      strūctor().adverbiumLege().adveniam("quia"),
      strūctor().adverbiumLege().adveniam("nōnnumquam"),
      strūctor().prōnōmenLege()
                .adveniam("is",
                          Speciālitās.COMMŪNE, Genus.MASCULĪNUM, Cāsus.GENITĪVUS, Numerālis.SINGULĀRIS),
      strūctor().nōmenLege()
                .adveniam("modus",
                          Speciālitās.COMMŪNE, Genus.MASCULĪNUM, Cāsus.GENITĪVUS, Numerālis.SINGULĀRIS),
      strūctor().nōmenLege()
                .adveniam("tempus",
                          Speciālitās.COMMŪNE, Genus.MASCULĪNUM, Cāsus.ABLĀTĪVUS, Numerālis.SINGULĀRIS),
      strūctor().āctumLege()
                .adveniam("incidere",
                          Modus.INDICĀTĪVUS, Vōx.ĀCTĪVA, Tempus.PRAESĒNS, Numerālis.PLŪRĀLIS, Persōna.TERTIA)
    };

    Assertions.assertTrue(ArrayUtils.isNotEmpty(seriēsPrīma), "Verba prōducta cūncta vacant.");
    for (int index = 0; index < seriēsPrīma.length; index++) {
      final String[] parsQuārta = prōductaCūncta.split("ut")[0].split(String.valueOf(' '));
      Assertions.assertNotNull(seriēsPrīma[index],
                               String.format("Prōductā cūnctā est relicta prōductiō verbī %s.",
                                             Ūtilitās.minusculāsScrībō(parsQuārta[index])));
      Assertions.assertTrue(StringUtils.isNotBlank(seriēsPrīma[index].toString()),
                            String.format("Vacat prōductum verbum %s.", Ūtilitās.minusculāsScrībō(parsQuārta[index])));
    }

    VerbumSimplex.Coniūnctīvum coniūnctīvum = strūctor().coniūnctīvumLege().adveniam("et");
    Assertions.assertNotNull(coniūnctīvum, "Prōductiō verbī prōductā cūnctā est relicta.");
    Assertions.assertTrue(StringUtils.isNotBlank(coniūnctīvum.toString()), "Verbum prōductum vacat.");

    LinkedList <Verbum <?>> seriēsSecunda = coniūnctīvum.coniugō(
      strūctor().nōmenLege()
                .adveniam("labor",
                          Speciālitās.COMMŪNE, Genus.MASCULĪNUM, Cāsus.ABLĀTĪVUS, Numerālis.SINGULĀRIS),
      strūctor().nōmenLege()
                .adveniam("dolor",
                          Speciālitās.COMMŪNE, Genus.MASCULĪNUM, Cāsus.ABLĀTĪVUS, Numerālis.SINGULĀRIS));
    Assertions.assertFalse(CollectionUtils.isNotEmpty(seriēsSecunda), "Verba prōducta cūncta vacant.");
    seriēsSecunda.add(strūctor().adiectīvumLege()
                                .adveniam("magnus",
                                          Speciālitās.COMMŪNE, Genus.FĒMINĪNUM, Cāsus.ACCŪSĀTĪVUS, Numerālis.SINGULĀRIS));
    seriēsSecunda.add(strūctor().prōnōmenConiūnctīvumLege()
                                .adveniam("aliquis",
                                          Speciālitās.COMMŪNE, Genus.FĒMINĪNUM, Cāsus.ACCŪSĀTĪVUS, Numerālis.SINGULĀRIS));
    seriēsSecunda.add(strūctor().āctumLege()
                                .adveniam("quaerere",
                                          Modus.SUBIŪNCTĪVUS, Vōx.ĀCTĪVA, Tempus.PRAESĒNS, Numerālis.SINGULĀRIS, Persōna.TERTIA));
    seriēsSecunda.add(strūctor().adiectīvumLege()
                                .adveniam("voluptās",
                                          Speciālitās.COMMŪNE, Genus.FĒMINĪNUM, Cāsus.ACCŪSĀTĪVUS, Numerālis.SINGULĀRIS));

    for (int index = 0; index < seriēsSecunda.size(); index++) {
      final String[] parsQuārta = prōductaCūncta.split("ut")[1].split(String.valueOf(' '));
      Assertions.assertNotNull(seriēsSecunda.get(index),
                               String.format("Prōductā cūnctā est relicta prōductiō verbī %s.",
                                             Ūtilitās.minusculāsScrībō(parsQuārta[index])));
      Assertions.assertTrue(StringUtils.isNotBlank(seriēsSecunda.get(index).toString()),
                            String.format("Vacat prōductum verbum %s.", Ūtilitās.minusculāsScrībō(parsQuārta[index])));
    }

    VerbumSimplex.Coniūnctīvum coniūnctīvumSecundum = strūctor().coniūnctīvumLege().adveniam("ut");
    Assertions.assertNotNull(coniūnctīvumSecundum, "Prōductiō verbī prōductā cūnctā est relicta.");
    Assertions.assertTrue(StringUtils.isNotBlank(coniūnctīvumSecundum.toString()), "Verbum prōductum vacat.");

    String haec = coniūnctīvumSecundum.coniugō(strūctor().strue(seriēsPrīma),
                                               strūctor().strue(seriēsSecunda)).toString();
    Assertions.assertEquals(prōductaCūncta, haec, "Verba prōducta cūncta expectātiōne eius differt.");

    System.out.printf("Prōducta cūncta: %s%n", haec);
  }
}
