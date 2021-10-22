package net.strūctorverba.tentāmina;

import net.strūctorverba.mīscella.Omnum;
import net.strūctorverba.mīscella.StrūctorVerba;
import net.strūctorverba.ēnumerātiōnēs.Catēgoria;
import net.strūctorverba.ēnumerātiōnēs.Cāsus;
import net.strūctorverba.ēnumerātiōnēs.Genus;
import net.strūctorverba.ēnumerātiōnēs.Modus;
import net.strūctorverba.ēnumerātiōnēs.Numerālis;
import net.strūctorverba.ēnumerātiōnēs.Persōna;
import net.strūctorverba.ēnumerātiōnēs.Speciālitās;
import net.strūctorverba.ēnumerātiōnēs.Tempus;
import net.strūctorverba.ēnumerātiōnēs.Vōx;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import lombok.Getter;

/**
 * Classis {@link DolōremIpsum} versiōnem prīmam tentāminārum programmātī StrūctorVerba dēfīnit. <br> Laudem Marcō
 * Tulliō Cicerōnī cum parte dialogī Sōcraticus "Dē Fīnibus Bonōrum et Mālōrum" in librō prīmō sectiōne decimā versū
 * duotrīcēsimō cōnstruat. <br> Versūs ante triēntem prīmam incipit et post fīnālem fīnit. <br> Pars illa est agnita
 * poēmam istam "Lorem Ipsum" īnspīrāvisse.
 * @see <a href="http://www.thelatinlibrary.com/cicero/fin1.shtml#32">Dē Fīnibus Bonōrum et Mālōrum</a>
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection", "FieldCanBeLocal" })
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
final class DolōremIpsum extends Omnum {
  @NotNull @Getter(lazy = true)
  private final StrūctorVerba strūctor = StrūctorVerba.fac.get();

  @NotNull private final String prōductaPrīma   = "Neque porrō quisquam est";
  @NotNull private final String prōductaSecunda = "Quī dolōrem ipsum quia dolor sit amet";
  @NotNull private final String prōductaTertia  = "Cōnsectētur adipīscī velit";
  @NotNull private final String prōductaQuārta  = "Sed quia nōnnumquam eius modī tempora incidunt";
  @NotNull private final String prōductaQuīnta  = "Ut labōre et dolōre magnam aliquam quaerat voluptātem";
  @NotNull private final String prōductaCūncta  = "Neque porrō quisquam est " +
                                                  "quī dolōrem ipsum quia dolor sit amet " +
                                                  "cōnsectētur adipīscī velit " +
                                                  "sed quia nōnnumquam eius modī tempora incidunt " +
                                                  "ut labōre et dolōre magnam aliquam quaerat voluptātem";

  /**
   * Modus hic partem prīmam tentat. <br> Verba "Neque porrō quisquam est" prōdūcat.
   */
  @Test @Order(1)
  public void prīma( ) {
    System.out.println(new Tentāmen.TentāmenVerbāle(prōductaPrīma, "prīma")
                         .exsequar(strūctor.strue(strūctor.adveniam("neque", Catēgoria.CONIŪNCTĪVUM),
                                                  strūctor.adveniam("porrō", Catēgoria.ADVERBIUM),
                                                  strūctor.adveniam("quisquam", Catēgoria.PRŌNŌMEN,
                                                                    Speciālitās.COMMŪNE, Genus.MASCULĪNUM,
                                                                    Cāsus.NŌMINĀTĪVUS, Numerālis.SINGULĀRIS),
                                                  strūctor.adveniam("esse", Catēgoria.ĀCTUS,
                                                                    Modus.INDICĀTĪVUS, Vōx.ĀCTĪVA, Tempus.PRAESĒNS,
                                                                    Numerālis.SINGULĀRIS, Persōna.TERTIA))));
  }

  /**
   * Modus hic partem secundam tentat. <br> Verba "Quī dolōrem ipsum quia dolor sit amet" prōdūcat.
   */
  @Test @Order(2)
  public void secunda( ) {
    System.out.println(new Tentāmen.TentāmenVerbāle(prōductaSecunda, "secunda")
                         .exsequar(strūctor.strue(strūctor.adveniam("quis", Catēgoria.PRŌNŌMEN,
                                                                    Speciālitās.COMMŪNE, Genus.MASCULĪNUM,
                                                                    Cāsus.NŌMINĀTĪVUS, Numerālis.PLŪRĀLIS),
                                                  strūctor.adveniam("dolor", Catēgoria.NŌMEN,
                                                                    Speciālitās.COMMŪNE, Genus.MASCULĪNUM,
                                                                    Cāsus.ACCŪSĀTĪVUS, Numerālis.SINGULĀRIS),
                                                  strūctor.adveniam("ipsum", Catēgoria.PRŌNŌMEN,
                                                                    Speciālitās.COMMŪNE, Genus.MASCULĪNUM,
                                                                    Cāsus.NŌMINĀTĪVUS, Numerālis.SINGULĀRIS),
                                                  strūctor.adveniam("quia", Catēgoria.ADVERBIUM),
                                                  strūctor.adveniam("dolor", Catēgoria.NŌMEN,
                                                                    Speciālitās.COMMŪNE, Genus.MASCULĪNUM,
                                                                    Cāsus.NŌMINĀTĪVUS, Numerālis.SINGULĀRIS),
                                                  strūctor.adveniam("esse", Catēgoria.ĀCTUS,
                                                                    Modus.SUBIŪNCTĪVUS, Vōx.ĀCTĪVA, Tempus.PRAESĒNS,
                                                                    Numerālis.SINGULĀRIS, Persōna.TERTIA),
                                                  strūctor.adveniam("amāre", Catēgoria.ĀCTUS,
                                                                    Modus.SUBIŪNCTĪVUS, Vōx.ĀCTĪVA, Tempus.PRAESĒNS,
                                                                    Numerālis.SINGULĀRIS, Persōna.TERTIA))));
  }

  /**
   * Modus hic partem tertiam tentat. <br> Verba "Cōnsectētur adipīscī velit" prōdūcat.
   */
  @Test @Order(3)
  public void tertia( ) {
    System.out.println(new Tentāmen.TentāmenVerbāle(prōductaTertia, "tertia")
                         .exsequar(strūctor.strue(strūctor.adveniam("cōnsectārī", Catēgoria.ĀCTUS,
                                                                    Modus.SUBIŪNCTĪVUS, Vōx.ĀCTĪVA, Tempus.PRAESĒNS,
                                                                    Numerālis.SINGULĀRIS, Persōna.TERTIA),
                                                  strūctor.adveniam("adipīscī", Catēgoria.ĀCTUS,
                                                                    Modus.ĪNFĪNĪTĪVUS, Vōx.ĀCTĪVA, Tempus.PRAESĒNS),
                                                  strūctor.adveniam("velle", Catēgoria.ĀCTUS,
                                                                    Modus.SUBIŪNCTĪVUS, Vōx.ĀCTĪVA, Tempus.PRAESĒNS,
                                                                    Numerālis.SINGULĀRIS, Persōna.TERTIA))));
  }

  /**
   * Modus hic partem quārtam tentat. <br> Verba "Sed quia nōnnumquam eius modī tempora incidunt" prōdūcat. <br>
   */
  @Test @Order(4)
  public void quārta( ) {
    System.out.println(new Tentāmen.TentāmenVerbāle(prōductaQuārta, "quārta")
                         .exsequar(strūctor.strue(strūctor.adveniam("sed", Catēgoria.CONIŪNCTĪVUM),
                                                  strūctor.adveniam("quia", Catēgoria.ADVERBIUM),
                                                  strūctor.adveniam("nōnnumquam", Catēgoria.ADVERBIUM),
                                                  strūctor.adveniam("is", Catēgoria.PRŌNŌMEN,
                                                                    Speciālitās.COMMŪNE, Genus.MASCULĪNUM,
                                                                    Cāsus.GENITĪVUS, Numerālis.SINGULĀRIS),
                                                  strūctor.adveniam("modus", Catēgoria.NŌMEN,
                                                                    Speciālitās.COMMŪNE, Genus.MASCULĪNUM,
                                                                    Cāsus.GENITĪVUS, Numerālis.SINGULĀRIS),
                                                  strūctor.adveniam("tempus", Catēgoria.NŌMEN,
                                                                    Speciālitās.COMMŪNE, Genus.MASCULĪNUM,
                                                                    Cāsus.ABLĀTĪVUS, Numerālis.SINGULĀRIS),
                                                  strūctor.adveniam("incidere", Catēgoria.ĀCTUS,
                                                                    Modus.INDICĀTĪVUS, Vōx.ĀCTĪVA, Tempus.PRAESĒNS,
                                                                    Numerālis.PLŪRĀLIS, Persōna.TERTIA))));
  }

  /**
   * Modus hic partem quārtam tentat. <br> Verba "Ut labōre et dolōre magnam aliquam quaerat voluptātem" prōdūcat. <br>
   */
  @Test @Order(5)
  public void quīnta( ) {
    System.out.println(new Tentāmen.TentāmenVerbāle(prōductaQuīnta, "quīnta")
                         .exsequar(strūctor.strue(strūctor.adveniam("ut", Catēgoria.CONIŪNCTĪVUM),
                                                  strūctor.adveniam("labor", Catēgoria.NŌMEN,
                                                                    Speciālitās.COMMŪNE, Genus.MASCULĪNUM,
                                                                    Cāsus.ABLĀTĪVUS, Numerālis.SINGULĀRIS),
                                                  strūctor.adveniam("et", Catēgoria.CONIŪNCTĪVUM),
                                                  strūctor.adveniam("dolor", Catēgoria.NŌMEN,
                                                                    Speciālitās.COMMŪNE, Genus.MASCULĪNUM,
                                                                    Cāsus.ABLĀTĪVUS, Numerālis.SINGULĀRIS),
                                                  strūctor.adveniam("magnus", Catēgoria.ADIECTĪVUM,
                                                                    Speciālitās.COMMŪNE, Genus.FĒMINĪNUM,
                                                                    Cāsus.ACCŪSĀTĪVUS, Numerālis.SINGULĀRIS),
                                                  strūctor.adveniam("aliquis", Catēgoria.PRŌNŌMEN,
                                                                    Speciālitās.COMMŪNE, Genus.FĒMINĪNUM,
                                                                    Cāsus.ACCŪSĀTĪVUS, Numerālis.SINGULĀRIS),
                                                  strūctor.adveniam("quaerere", Catēgoria.ĀCTUS,
                                                                    Modus.SUBIŪNCTĪVUS, Vōx.ĀCTĪVA, Tempus.PRAESĒNS,
                                                                    Numerālis.SINGULĀRIS, Persōna.TERTIA),
                                                  strūctor.adveniam("voluptās", Catēgoria.NŌMEN,
                                                                    Speciālitās.COMMŪNE, Genus.FĒMINĪNUM,
                                                                    Cāsus.ACCŪSĀTĪVUS, Numerālis.SINGULĀRIS))));
  }

  /**
   * Modus hic tentāmina omnēs praevia coniugat. <br> Verba "Neque porrō quisquam est quī dolōrem ipsum quia dolor sit
   * amet cōnsectētur adipīscī velit sed quia nōnnumquam eius modī tempora incidunt ut labōre et dolōre magnam aliquam
   * quaerat voluptātem" prōdūcat. <br> Aboriētur sī tentāminum aliquid praevium aboriuntur atque prosperābitur sī omnēs
   * prosperantur.
   */
  @Test @Order(6)
  public void cūncta( ) {
    System.out.println(new Tentāmen.TentāmenVerbāle(prōductaCūncta, "cūncta")
                         .exsequar(strūctor.strue(strūctor.adveniam("neque", Catēgoria.CONIŪNCTĪVUM),
                                                  strūctor.adveniam("porrō", Catēgoria.ADVERBIUM),
                                                  strūctor.adveniam("quisquam", Catēgoria.PRŌNŌMEN,
                                                                    Speciālitās.COMMŪNE, Genus.MASCULĪNUM,
                                                                    Cāsus.NŌMINĀTĪVUS, Numerālis.SINGULĀRIS),
                                                  strūctor.adveniam("esse", Catēgoria.ĀCTUS,
                                                                    Modus.INDICĀTĪVUS, Vōx.ĀCTĪVA, Tempus.PRAESĒNS,
                                                                    Numerālis.SINGULĀRIS, Persōna.TERTIA),
                                                  strūctor.adveniam("quis", Catēgoria.PRŌNŌMEN,
                                                                    Speciālitās.COMMŪNE, Genus.MASCULĪNUM,
                                                                    Cāsus.NŌMINĀTĪVUS, Numerālis.PLŪRĀLIS),
                                                  strūctor.adveniam("dolor", Catēgoria.NŌMEN,
                                                                    Speciālitās.COMMŪNE, Genus.MASCULĪNUM,
                                                                    Cāsus.ACCŪSĀTĪVUS, Numerālis.SINGULĀRIS),
                                                  strūctor.adveniam("ipsum", Catēgoria.PRŌNŌMEN,
                                                                    Speciālitās.COMMŪNE, Genus.MASCULĪNUM,
                                                                    Cāsus.NŌMINĀTĪVUS, Numerālis.SINGULĀRIS),
                                                  strūctor.adveniam("quia", Catēgoria.ADVERBIUM),
                                                  strūctor.adveniam("dolor", Catēgoria.NŌMEN,
                                                                    Speciālitās.COMMŪNE, Genus.MASCULĪNUM,
                                                                    Cāsus.NŌMINĀTĪVUS, Numerālis.SINGULĀRIS),
                                                  strūctor.adveniam("esse", Catēgoria.ĀCTUS,
                                                                    Modus.SUBIŪNCTĪVUS, Vōx.ĀCTĪVA, Tempus.PRAESĒNS,
                                                                    Numerālis.SINGULĀRIS, Persōna.TERTIA),
                                                  strūctor.adveniam("amāre", Catēgoria.ĀCTUS,
                                                                    Modus.SUBIŪNCTĪVUS, Vōx.ĀCTĪVA, Tempus.PRAESĒNS,
                                                                    Numerālis.SINGULĀRIS, Persōna.TERTIA),
                                                  strūctor.adveniam("cōnsectārī", Catēgoria.ĀCTUS,
                                                                    Modus.SUBIŪNCTĪVUS, Vōx.ĀCTĪVA, Tempus.PRAESĒNS,
                                                                    Numerālis.SINGULĀRIS, Persōna.TERTIA),
                                                  strūctor.adveniam("adipīscī", Catēgoria.ĀCTUS,
                                                                    Modus.ĪNFĪNĪTĪVUS, Vōx.ĀCTĪVA, Tempus.PRAESĒNS,
                                                                    Numerālis.SINGULĀRIS, Persōna.TERTIA),
                                                  strūctor.adveniam("velle", Catēgoria.ĀCTUS,
                                                                    Modus.SUBIŪNCTĪVUS, Vōx.ĀCTĪVA, Tempus.PRAESĒNS,
                                                                    Numerālis.SINGULĀRIS, Persōna.TERTIA),
                                                  strūctor.adveniam("sed", Catēgoria.CONIŪNCTĪVUM),
                                                  strūctor.adveniam("quia", Catēgoria.ADVERBIUM),
                                                  strūctor.adveniam("nōnnumquam", Catēgoria.ADVERBIUM),
                                                  strūctor.adveniam("is", Catēgoria.PRŌNŌMEN,
                                                                    Speciālitās.COMMŪNE, Genus.MASCULĪNUM,
                                                                    Cāsus.GENITĪVUS, Numerālis.SINGULĀRIS),
                                                  strūctor.adveniam("modus", Catēgoria.NŌMEN,
                                                                    Speciālitās.COMMŪNE, Genus.MASCULĪNUM,
                                                                    Cāsus.GENITĪVUS, Numerālis.SINGULĀRIS),
                                                  strūctor.adveniam("tempus", Catēgoria.NŌMEN,
                                                                    Speciālitās.COMMŪNE, Genus.MASCULĪNUM,
                                                                    Cāsus.ABLĀTĪVUS, Numerālis.SINGULĀRIS),
                                                  strūctor.adveniam("incidere", Catēgoria.ĀCTUS,
                                                                    Modus.INDICĀTĪVUS, Vōx.ĀCTĪVA, Tempus.PRAESĒNS,
                                                                    Numerālis.PLŪRĀLIS, Persōna.TERTIA),
                                                  strūctor.adveniam("ut", Catēgoria.CONIŪNCTĪVUM),
                                                  strūctor.adveniam("labor", Catēgoria.NŌMEN,
                                                                    Speciālitās.COMMŪNE, Genus.MASCULĪNUM,
                                                                    Cāsus.ABLĀTĪVUS, Numerālis.SINGULĀRIS),
                                                  strūctor.adveniam("et", Catēgoria.CONIŪNCTĪVUM),
                                                  strūctor.adveniam("dolor", Catēgoria.NŌMEN,
                                                                    Speciālitās.COMMŪNE, Genus.MASCULĪNUM,
                                                                    Cāsus.ABLĀTĪVUS, Numerālis.SINGULĀRIS),
                                                  strūctor.adveniam("magnus", Catēgoria.ADIECTĪVUM,
                                                                    Speciālitās.COMMŪNE, Genus.FĒMINĪNUM,
                                                                    Cāsus.ACCŪSĀTĪVUS, Numerālis.SINGULĀRIS),
                                                  strūctor.adveniam("aliquis", Catēgoria.PRŌNŌMEN,
                                                                    Speciālitās.COMMŪNE, Genus.FĒMINĪNUM,
                                                                    Cāsus.ACCŪSĀTĪVUS, Numerālis.SINGULĀRIS),
                                                  strūctor.adveniam("quaerere", Catēgoria.ĀCTUS,
                                                                    Modus.SUBIŪNCTĪVUS, Vōx.ĀCTĪVA, Tempus.PRAESĒNS,
                                                                    Numerālis.SINGULĀRIS, Persōna.TERTIA),
                                                  strūctor.adveniam("voluptās", Catēgoria.NŌMEN,
                                                                    Speciālitās.COMMŪNE, Genus.FĒMINĪNUM,
                                                                    Cāsus.ACCŪSĀTĪVUS, Numerālis.SINGULĀRIS))));
  }
}
