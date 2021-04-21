package net.strūctorverba.tentāmina;

import lombok.Getter;
import lombok.experimental.Accessors;
import net.strūctorverba.mīscella.*;
import net.strūctorverba.verba.disposita.Verba;
import net.strūctorverba.ēnumerātiōnēs.*;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.*;

/**
 * Classis {@link DolōremIpsum} versiōnem prīmam tentāminārum programmātī StrūctorVerba dēfīnit. <br>
 * Laudem Marcō Tulliō Cicerōnī cum parte dialogī Sōcraticus "Dē Fīnibus Bonōrum et Mālōrum" in librō prīmō sectiōne decimā versū duotrīcēsimō cōnstruat. <br>
 * Versūs ante triēntem prīmam incipit et post fīnālem fīnit. <br>
 * Pars illa est agnita poēmam istam "Lorem Ipsum" īnspīrāvisse.
 * @see <a href="http://www.thelatinlibrary.com/cicero/fin1.shtml#32">Dē Fīnibus Bonōrum et Mālōrum</a>
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection", "FieldCanBeLocal" })
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public final class DolōremIpsum extends Omnum {
  @NotNull @Getter(lazy = true) @Accessors(fluent = true)
  private final StrūctorVerba strūctor = StrūctorVerba.fac.get();

  @NotNull private final String prōductaPrīma   = "Neque porrō quisquam est";
  @NotNull private final String prōductaSecunda = "Quī dolōrem ipsum quia dolor sit amet";
  @NotNull private final String prōductaTertia  = "Cōnsectētur adipīscī velit";
  @NotNull private final String prōductaQuārta  = "Sed quia nōnnumquam eius modī tempora incidunt";
  @NotNull private final String prōductaQuīnta  = "Ut labōre et dolōre magnam aliquam quaerat voluptātem";
  @NotNull private final String prōductaCūncta  = "Neque porrō quisquam est quī dolōrem ipsum quia dolor sit amet cōnsectētur adipīscī velit sed quia nōnnumquam eius modī tempora incidunt ut labōre et dolōre magnam aliquam quaerat voluptātem";

  /**
   * Modus hic partem prīmam tentat. <br>
   * Verba "Neque porrō quisquam est" prōdūcat.
   */
  @Test @Order(1)
  public void prīma( ) {
    final Verba verba = strūctor().strue(strūctor().adveniam("neque", Catēgoria.CONIŪNCTĪVUM),
                                         strūctor().adveniam("porrō", Catēgoria.ADVERBIUM),
                                         strūctor().adveniam("quisquam", Catēgoria.PRŌNŌMEN,
                                                             Speciālitās.COMMŪNE, Genus.MASCULĪNUM, Cāsus.NŌMINĀTĪVUS, Numerālis.SINGULĀRIS),
                                         strūctor().adveniam("esse", Catēgoria.ĀCTUM,
                                                             Modus.INDICĀTĪVUS, Vōx.ĀCTĪVA, Tempus.PRAESĒNS,
                                                             Numerālis.SINGULĀRIS, Persōna.TERTIA));
    Assertions.assertNotNull(verba, "Verba prōducta prīma vacant.");
    Assertions.assertTrue(CollectionUtils.isNotEmpty(verba.seriēs),
                          "Verba prōducta prīma vacant.");
    for (int index = 0; index < verba.seriēs.size(); index++) {
      Assertions.assertNotNull(verba.seriēs.get(index),
                               String.format("Prōductā prīmā est relicta prōductiō verbī %s.",
                                             Ūtilitās.minusculāsScrībō(prōductaPrīma.split(String.valueOf(' '))[index])));
      Assertions.assertTrue(StringUtils.isNotBlank(verba.seriēs.get(index).toString()),
                            String.format("Vacat prōductum verbum %s.",
                                          Ūtilitās.minusculāsScrībō(prōductaPrīma.split(String.valueOf(' '))[index])));
    }

    Assertions.assertEquals(prōductaPrīma, verba.toString(),
                            "Verba prōducta prīma expectātiōne eius differt.");
    System.out.printf("Prōducta prīma: %s%n", verba);
  }

  /**
   * Modus hic partem secundam tentat. <br>
   * Verba "Quī dolōrem ipsum quia dolor sit amet" prōdūcat.
   */
  @Test @Order(2)
  public void secunda( ) {
    final Verba verba = strūctor().strue(strūctor().adveniam("quis", Catēgoria.PRŌNŌMEN,
                                                             Speciālitās.COMMŪNE, Genus.MASCULĪNUM,
                                                             Cāsus.NŌMINĀTĪVUS, Numerālis.PLŪRĀLIS),
                                         strūctor().adveniam("dolor", Catēgoria.NŌMEN,
                                                             Speciālitās.COMMŪNE, Genus.MASCULĪNUM,
                                                             Cāsus.ACCŪSĀTĪVUS, Numerālis.SINGULĀRIS),
                                         strūctor().adveniam("ipsum", Catēgoria.PRŌNŌMEN,
                                                             Speciālitās.COMMŪNE, Genus.MASCULĪNUM,
                                                             Cāsus.NŌMINĀTĪVUS, Numerālis.SINGULĀRIS),
                                         strūctor().adveniam("quia", Catēgoria.ADVERBIUM),
                                         strūctor().adveniam("dolor", Catēgoria.NŌMEN,
                                                             Speciālitās.COMMŪNE, Genus.MASCULĪNUM,
                                                             Cāsus.NŌMINĀTĪVUS, Numerālis.SINGULĀRIS),
                                         strūctor().adveniam("esse", Catēgoria.ĀCTUM,
                                                             Modus.SUBIŪNCTĪVUS, Vōx.ĀCTĪVA, Tempus.PRAESĒNS,
                                                             Numerālis.SINGULĀRIS, Persōna.TERTIA),
                                         strūctor().adveniam("amāre", Catēgoria.ĀCTUM,
                                                             Modus.SUBIŪNCTĪVUS, Vōx.ĀCTĪVA, Tempus.PRAESĒNS,
                                                             Numerālis.SINGULĀRIS, Persōna.TERTIA));
    Assertions.assertNotNull(verba, "Verba prōducta secunda vacant.");
    Assertions.assertTrue(CollectionUtils.isNotEmpty(verba.seriēs),
                          "Verba prōducta secunda vacant.");
    for (int index = 0; index < verba.seriēs.size(); index++) {
      Assertions.assertNotNull(verba.seriēs.get(index),
                               String.format("Prōductā secundā est relicta prōductiō verbī %s.",
                                             Ūtilitās.minusculāsScrībō(prōductaSecunda.split(String.valueOf(' '))[index])));
      Assertions.assertTrue(StringUtils.isNotBlank(verba.seriēs.get(index).toString()),
                            String.format("Vacat prōductum verbum %s.",
                                          Ūtilitās.minusculāsScrībō(prōductaSecunda.split(String.valueOf(' '))[index])));
    }

    Assertions.assertEquals(prōductaSecunda, verba.toString(),
                            "Verba prōducta secunda expectātiōne eius differt.");
    System.out.printf("Prōducta secunda: %s%n", verba);
  }

  /**
   * Modus hic partem tertiam tentat. <br>
   * Verba "Cōnsectētur adipīscī velit" prōdūcat.
   */
  @Test @Order(3)
  public void tertia( ) {
    final Verba verba = strūctor().strue(strūctor().adveniam("cōnsectārī", Catēgoria.ĀCTUM,
                                                             Modus.SUBIŪNCTĪVUS, Vōx.ĀCTĪVA, Tempus.PRAESĒNS,
                                                             Numerālis.SINGULĀRIS, Persōna.TERTIA),
                                         strūctor().adveniam("adipīscī", Catēgoria.ĀCTUM,
                                                             Modus.ĪNFĪNĪTĪVUS, Vōx.ĀCTĪVA, Tempus.PRAESĒNS),
                                         strūctor().adveniam("velle", Catēgoria.ĀCTUM,
                                                             Modus.SUBIŪNCTĪVUS, Vōx.ĀCTĪVA, Tempus.PRAESĒNS,
                                                             Numerālis.SINGULĀRIS, Persōna.TERTIA));

    Assertions.assertNotNull(verba, "Verba prōducta tertia vacant.");
    Assertions.assertTrue(CollectionUtils.isNotEmpty(verba.seriēs),
                          "Verba prōducta tertia vacant.");
    for (int index = 0; index < verba.seriēs.size(); index++) {
      Assertions.assertNotNull(verba.seriēs.get(index),
                               String.format("Prōductā tertiā est relicta prōductiō verbī %s.",
                                             Ūtilitās.minusculāsScrībō(prōductaTertia.split(String.valueOf(' '))[index])));
      Assertions.assertTrue(StringUtils.isNotBlank(verba.seriēs.get(index).toString()),
                            String.format("Vacat prōductum verbum %s.",
                                          Ūtilitās.minusculāsScrībō(prōductaTertia.split(String.valueOf(' '))[index])));
    }

    Assertions.assertEquals(prōductaTertia, verba.toString(),
                            "Verba prōducta tertia expectātiōne eius differt.");
    System.out.printf("Prōducta tertia: %s%n", verba);
  }

  /**
   * Modus hic partem quārtam tentat. <br>
   * Verba "Sed quia nōnnumquam eius modī tempora incidunt" prōdūcat. <br>
   */
  @Test @Order(4)
  public void quārta( ) {
    final Verba verba = strūctor().strue(strūctor().adveniam("sed", Catēgoria.CONIŪNCTĪVUM),
                                         strūctor().adveniam("quia", Catēgoria.ADVERBIUM),
                                         strūctor().adveniam("nōnnumquam", Catēgoria.ADVERBIUM),
                                         strūctor().adveniam("is", Catēgoria.PRŌNŌMEN,
                                                             Speciālitās.COMMŪNE, Genus.MASCULĪNUM,
                                                             Cāsus.GENITĪVUS, Numerālis.SINGULĀRIS),
                                         strūctor().adveniam("modus", Catēgoria.NŌMEN,
                                                             Speciālitās.COMMŪNE, Genus.MASCULĪNUM,
                                                             Cāsus.GENITĪVUS, Numerālis.SINGULĀRIS),
                                         strūctor().adveniam("tempus", Catēgoria.NŌMEN,
                                                             Speciālitās.COMMŪNE, Genus.MASCULĪNUM,
                                                             Cāsus.ABLĀTĪVUS, Numerālis.SINGULĀRIS),
                                         strūctor().adveniam("incidere", Catēgoria.ĀCTUM,
                                                             Modus.INDICĀTĪVUS, Vōx.ĀCTĪVA, Tempus.PRAESĒNS,
                                                             Numerālis.PLŪRĀLIS, Persōna.TERTIA));

    Assertions.assertNotNull(verba, "Verba prōducta quārta vacant.");
    Assertions.assertTrue(CollectionUtils.isNotEmpty(verba.seriēs),
                          "Verba prōducta quārta vacant.");
    for (int index = 0; index < verba.seriēs.size(); index++) {
      Assertions.assertNotNull(verba.seriēs.get(index),
                               String.format("Prōductā quārtā est relicta prōductiō verbī %s.",
                                             Ūtilitās.minusculāsScrībō(prōductaQuārta.split(String.valueOf(' '))[index])));
      Assertions.assertTrue(StringUtils.isNotBlank(verba.seriēs.get(index).toString()),
                            String.format("Vacat prōductum verbum %s.",
                                          Ūtilitās.minusculāsScrībō(prōductaQuārta.split(String.valueOf(' '))[index])));
    }

    Assertions.assertEquals(prōductaQuārta, verba.toString(),
                            "Verba prōducta quārta expectātiōne eius differt.");
    System.out.printf("Prōducta quārta: %s%n", verba);
  }

  /**
   * Modus hic partem quārtam tentat. <br>
   * Verba "Ut labōre et dolōre magnam aliquam quaerat voluptātem" prōdūcat. <br>
   */
  @Test @Order(5)
  public void quīnta( ) {
    final Verba verba = strūctor().strue(strūctor().adveniam("ut", Catēgoria.CONIŪNCTĪVUM),
                                         strūctor().adveniam("labor", Catēgoria.NŌMEN,
                                                             Speciālitās.COMMŪNE, Genus.MASCULĪNUM,
                                                             Cāsus.ABLĀTĪVUS, Numerālis.SINGULĀRIS),
                                         strūctor().adveniam("et", Catēgoria.CONIŪNCTĪVUM),
                                         strūctor().adveniam("dolor", Catēgoria.NŌMEN,
                                                             Speciālitās.COMMŪNE, Genus.MASCULĪNUM,
                                                             Cāsus.ABLĀTĪVUS, Numerālis.SINGULĀRIS),
                                         strūctor().adveniam("magnus", Catēgoria.ADIECTĪVUM,
                                                             Speciālitās.COMMŪNE, Genus.FĒMINĪNUM,
                                                             Cāsus.ACCŪSĀTĪVUS, Numerālis.SINGULĀRIS),
                                         strūctor().adveniam("aliquis", Catēgoria.PRŌNŌMEN,
                                                             Speciālitās.COMMŪNE, Genus.FĒMINĪNUM,
                                                             Cāsus.ACCŪSĀTĪVUS, Numerālis.SINGULĀRIS),
                                         strūctor().adveniam("quaerere", Catēgoria.ĀCTUM,
                                                             Modus.SUBIŪNCTĪVUS, Vōx.ĀCTĪVA, Tempus.PRAESĒNS,
                                                             Numerālis.SINGULĀRIS, Persōna.TERTIA),
                                         strūctor().adveniam("voluptās", Catēgoria.NŌMEN,
                                                             Speciālitās.COMMŪNE, Genus.FĒMINĪNUM,
                                                             Cāsus.ACCŪSĀTĪVUS, Numerālis.SINGULĀRIS));

    Assertions.assertNotNull(verba, "Verba prōducta quīnta vacant.");
    Assertions.assertTrue(CollectionUtils.isNotEmpty(verba.seriēs),
                          "Verba prōducta quīnta vacant.");
    for (int index = 0; index < verba.seriēs.size(); index++) {
      Assertions.assertNotNull(verba.seriēs.get(index),
                               String.format("Prōductā quīntā est relicta prōductiō verbī %s.",
                                             Ūtilitās.minusculāsScrībō(prōductaQuīnta.split(String.valueOf(' '))[index])));
      Assertions.assertTrue(StringUtils.isNotBlank(verba.seriēs.get(index).toString()),
                            String.format("Vacat prōductum verbum %s.",
                                          Ūtilitās.minusculāsScrībō(prōductaQuīnta.split(String.valueOf(' '))[index])));
    }

    Assertions.assertEquals(prōductaQuīnta, verba.toString(),
                            "Verba prōducta quīnta expectātiōne eius differt.");
    System.out.printf("Prōducta quīnta: %s%n", verba);
  }

  /**
   * Modus hic tentāmina omnēs praevia coniugat. <br>
   * Verba "Neque porrō quisquam est quī dolōrem ipsum quia dolor sit amet cōnsectētur adipīscī velit sed quia nōnnumquam eius modī tempora incidunt ut labōre et dolōre magnam aliquam quaerat voluptātem" prōdūcat. <br>
   * Aboriētur sī tentāminum aliquid praevium aboriuntur atque prosperābitur sī omnēs prosperantur.
   */
  @Test @Order(6)
  public void cūncta() {
    final Verba verba = strūctor().strue(strūctor().adveniam("neque", Catēgoria.CONIŪNCTĪVUM),
                                         strūctor().adveniam("porrō", Catēgoria.ADVERBIUM),
                                         strūctor().adveniam("quisquam", Catēgoria.PRŌNŌMEN,
                                                             Speciālitās.COMMŪNE, Genus.MASCULĪNUM,
                                                             Cāsus.NŌMINĀTĪVUS, Numerālis.SINGULĀRIS),
                                         strūctor().adveniam("esse", Catēgoria.ĀCTUM,
                                                             Modus.INDICĀTĪVUS, Vōx.ĀCTĪVA, Tempus.PRAESĒNS,
                                                             Numerālis.SINGULĀRIS, Persōna.TERTIA),
                                         strūctor().adveniam("quis", Catēgoria.PRŌNŌMEN,
                                                             Speciālitās.COMMŪNE, Genus.MASCULĪNUM,
                                                             Cāsus.NŌMINĀTĪVUS, Numerālis.PLŪRĀLIS),
                                         strūctor().adveniam("dolor", Catēgoria.NŌMEN,
                                                             Speciālitās.COMMŪNE, Genus.MASCULĪNUM,
                                                             Cāsus.ACCŪSĀTĪVUS, Numerālis.SINGULĀRIS),
                                         strūctor().adveniam("ipsum", Catēgoria.PRŌNŌMEN,
                                                             Speciālitās.COMMŪNE, Genus.MASCULĪNUM,
                                                             Cāsus.NŌMINĀTĪVUS, Numerālis.SINGULĀRIS),
                                         strūctor().adveniam("quia", Catēgoria.ADVERBIUM),
                                         strūctor().adveniam("dolor", Catēgoria.NŌMEN,
                                                             Speciālitās.COMMŪNE, Genus.MASCULĪNUM,
                                                             Cāsus.NŌMINĀTĪVUS, Numerālis.SINGULĀRIS),
                                         strūctor().adveniam("esse", Catēgoria.ĀCTUM,
                                                             Modus.SUBIŪNCTĪVUS, Vōx.ĀCTĪVA, Tempus.PRAESĒNS,
                                                             Numerālis.SINGULĀRIS, Persōna.TERTIA),
                                         strūctor().adveniam("amāre", Catēgoria.ĀCTUM,
                                                             Modus.SUBIŪNCTĪVUS, Vōx.ĀCTĪVA, Tempus.PRAESĒNS,
                                                             Numerālis.SINGULĀRIS, Persōna.TERTIA),
                                         strūctor().adveniam("cōnsectārī", Catēgoria.ĀCTUM,
                                                             Modus.SUBIŪNCTĪVUS, Vōx.ĀCTĪVA, Tempus.PRAESĒNS,
                                                             Numerālis.SINGULĀRIS, Persōna.TERTIA),
                                         strūctor().adveniam("adipīscī", Catēgoria.ĀCTUM,
                                                             Modus.ĪNFĪNĪTĪVUS, Vōx.ĀCTĪVA, Tempus.PRAESĒNS,
                                                             Numerālis.SINGULĀRIS, Persōna.TERTIA),
                                         strūctor().adveniam("velle", Catēgoria.ĀCTUM,
                                                             Modus.SUBIŪNCTĪVUS, Vōx.ĀCTĪVA, Tempus.PRAESĒNS,
                                                             Numerālis.SINGULĀRIS, Persōna.TERTIA),
                                         strūctor().adveniam("sed", Catēgoria.CONIŪNCTĪVUM),
                                         strūctor().adveniam("quia", Catēgoria.ADVERBIUM),
                                         strūctor().adveniam("nōnnumquam", Catēgoria.ADVERBIUM),
                                         strūctor().adveniam("is", Catēgoria.PRŌNŌMEN,
                                                             Speciālitās.COMMŪNE, Genus.MASCULĪNUM,
                                                             Cāsus.GENITĪVUS, Numerālis.SINGULĀRIS),
                                         strūctor().adveniam("modus", Catēgoria.NŌMEN,
                                                             Speciālitās.COMMŪNE, Genus.MASCULĪNUM,
                                                             Cāsus.GENITĪVUS, Numerālis.SINGULĀRIS),
                                         strūctor().adveniam("tempus", Catēgoria.NŌMEN,
                                                             Speciālitās.COMMŪNE, Genus.MASCULĪNUM,
                                                             Cāsus.ABLĀTĪVUS, Numerālis.SINGULĀRIS),
                                         strūctor().adveniam("incidere", Catēgoria.ĀCTUM,
                                                             Modus.INDICĀTĪVUS, Vōx.ĀCTĪVA, Tempus.PRAESĒNS,
                                                             Numerālis.PLŪRĀLIS, Persōna.TERTIA),
                                         strūctor().adveniam("ut", Catēgoria.CONIŪNCTĪVUM),
                                         strūctor().adveniam("labor", Catēgoria.NŌMEN,
                                                             Speciālitās.COMMŪNE, Genus.MASCULĪNUM,
                                                             Cāsus.ABLĀTĪVUS, Numerālis.SINGULĀRIS),
                                         strūctor().adveniam("et", Catēgoria.CONIŪNCTĪVUM),
                                         strūctor().adveniam("dolor", Catēgoria.NŌMEN,
                                                             Speciālitās.COMMŪNE, Genus.MASCULĪNUM,
                                                             Cāsus.ABLĀTĪVUS, Numerālis.SINGULĀRIS),
                                         strūctor().adveniam("magnus", Catēgoria.ADIECTĪVUM,
                                                             Speciālitās.COMMŪNE, Genus.FĒMINĪNUM,
                                                             Cāsus.ACCŪSĀTĪVUS, Numerālis.SINGULĀRIS),
                                         strūctor().adveniam("aliquis", Catēgoria.PRŌNŌMEN,
                                                             Speciālitās.COMMŪNE, Genus.FĒMINĪNUM,
                                                             Cāsus.ACCŪSĀTĪVUS, Numerālis.SINGULĀRIS),
                                         strūctor().adveniam("quaerere", Catēgoria.ĀCTUM,
                                                             Modus.SUBIŪNCTĪVUS, Vōx.ĀCTĪVA, Tempus.PRAESĒNS,
                                                             Numerālis.SINGULĀRIS, Persōna.TERTIA),
                                         strūctor().adveniam("voluptās", Catēgoria.NŌMEN,
                                                             Speciālitās.COMMŪNE, Genus.FĒMINĪNUM,
                                                             Cāsus.ACCŪSĀTĪVUS, Numerālis.SINGULĀRIS));

    Assertions.assertNotNull(verba, "Verba prōducta cūncta vacant.");
    Assertions.assertTrue(CollectionUtils.isNotEmpty(verba.seriēs), "Verba prōducta cūncta vacant.");
    for (int index = 0; index < verba.seriēs.size(); index++) {
      Assertions.assertNotNull(verba.seriēs.get(index),
                               String.format("Prōductā cūnctā est relicta prōductiō verbī %s.",
                                             Ūtilitās.minusculāsScrībō(prōductaCūncta.split(String.valueOf(' '))[index])));
      Assertions.assertTrue(StringUtils.isNotBlank(verba.seriēs.get(index).toString()),
                            String.format("Vacat prōductum verbum %s.",
                                          Ūtilitās.minusculāsScrībō(prōductaCūncta.split(String.valueOf(' '))[index])));
    }

    Assertions.assertEquals(prōductaCūncta, verba.toString(),
                            "Verba prōducta cūncta expectātiōne eius differt.");
    System.out.printf("Prōducta cūncta: %s%n", verba);
  }
}
