package com.structorverba.officia;

import com.structorverba.officia.enumerationes.*;

import androidx.annotation.NonNull;
import com.structorverba.officia.miscella.Omne;
import com.structorverba.officia.miscella.Structor;
import com.structorverba.officia.tentamina.Tentamen;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import lombok.Getter;

/**
 * Classis {@link DoloremIpsum} versiōnem prīmam tentāminārum programmātī StrūctorVerba dēfīnit. <br>
 * Laudem Marcō Tulliō Cicerōnī cum parte dialogī Sōcraticus "Dē Fīnibus Bonōrum et Mālōrum"
 * in librō prīmō sectiōne decimā versū duotrīcēsimō cōnstruat. <br>
 * Versūs ante triēntem prīmam incipit et post fīnālem fīnit. <br>
 * Pars illa est agnita poēmam istam "Lorem Ipsum" īnspīrāvisse.
 * @see <a href="http://www.thelatinlibrary.com/cicero/fin1.shtml#32">Dē Fīnibus Bonōrum et Malōrum</a>
 * @see <a href="https://lipsum.com">"Lorem Ipsum"</a>
 */
@SuppressWarnings({"SpellCheckingInspection", "FieldCanBeLocal", "NewClassNamingConvention"})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
final class DoloremIpsum extends Omne {
  @NonNull @Getter(lazy = true)
  private final Structor structor = Structor.faciendum.get();

  @NonNull private final String productaPrima   = "Neque porrō quisquam est";
  @NonNull private final String productaSecunda = "Qui dolōrem ipsum quia dolor sit amet";
  @NonNull private final String productaTertia  = "Cōnsectetur adipisci velit";
  @NonNull private final String productaQuarta  = "Sed quia nōnnumquam eius modi tempora incidunt";
  @NonNull private final String productaQuinta  = "Ut labōre et dolōre magnam aliquam quaerat voluptatem";
  @NonNull private final String productaCuncta  = String.join(" ", productaPrima, productaSecunda, productaTertia, productaQuarta, productaQuinta);

  /**
   * Hic modus partem prīmam tentat. <br>
   * Verba "Neque porrō quisquam est" prōdūcat.
   */
  @Test @Order(1)
  public void prima() {
    System.out.println(new Tentamen.Verbale(productaPrima, "prīma")
                         .exsequar(structor.strue(structor.adveniam("neque", Categoria.CONIUNCTIO),
                                                  structor.adveniam("porrō", Categoria.ADVERBIUM),
                                                  structor.adveniam("quidquam", Categoria.PRONOMEN,
                                                                    Specialitas.COMMUNE, Genus.MASCULINUM,
                                                                    Casus.NOMINATIVUS, Numeralis.SINGULARIS),
                                                  structor.adveniam("esse", Categoria.ACTUS,
                                                                    Modus.INDICATIVUS, Vox.ACTIVA, Tempus.PRAESENS,
                                                                    Numeralis.SINGULARIS, Persona.TERTIA))));
  }

  /**
   * Hic modus partem secundam tentat. <br>
   * Verba "Quī dolōrem ipsum quia dolor sit amet" prōdūcat.
   */
  @Test @Order(2)
  public void secunda() {
    System.out.println(new Tentamen.Verbale(productaSecunda, "secunda")
                         .exsequar(structor.strue(structor.adveniam("quod", Categoria.PRONOMEN,
                                                                    Specialitas.COMMUNE, Genus.MASCULINUM,
                                                                    Casus.NOMINATIVUS, Numeralis.PLURALIS),
                                                  structor.adveniam("dolor", Categoria.NOMEN,
                                                                    Specialitas.COMMUNE, Genus.MASCULINUM,
                                                                    Casus.ACCUSATIVUS, Numeralis.SINGULARIS),
                                                  structor.adveniam("ipsum", Categoria.PRONOMEN,
                                                                    Specialitas.COMMUNE, Genus.MASCULINUM,
                                                                    Casus.NOMINATIVUS, Numeralis.SINGULARIS),
                                                  structor.adveniam("quia", Categoria.ADVERBIUM),
                                                  structor.adveniam("dolor", Categoria.NOMEN,
                                                                    Specialitas.COMMUNE, Genus.MASCULINUM,
                                                                    Casus.NOMINATIVUS, Numeralis.SINGULARIS),
                                                  structor.adveniam("esse", Categoria.ACTUS,
                                                                    Modus.SUBIUNCTIVUS, Vox.ACTIVA, Tempus.PRAESENS,
                                                                    Numeralis.SINGULARIS, Persona.TERTIA),
                                                  structor.adveniam("amāre", Categoria.ACTUS,
                                                                    Modus.SUBIUNCTIVUS, Vox.ACTIVA, Tempus.PRAESENS,
                                                                    Numeralis.SINGULARIS, Persona.TERTIA))));
  }

  /**
   * Hic modus partem tertiam tentat. <br>
   * Verba "Cōnsectētur adipīscī velit" prōdūcat.
   */
  @Test @Order(3)
  public void tertia() {
    System.out.println(new Tentamen.Verbale(productaTertia, "tertia")
                         .exsequar(structor.strue(structor.adveniam("consectārī", Categoria.ACTUS,
                                                                    Modus.SUBIUNCTIVUS, Vox.ACTIVA, Tempus.PRAESENS,
                                                                    Numeralis.SINGULARIS, Persona.TERTIA),
                                                  structor.adveniam("adipīscī", Categoria.ACTUS,
                                                                    Modus.INFINITIVUS, Vox.ACTIVA, Tempus.PRAESENS),
                                                  structor.adveniam("velle", Categoria.ACTUS,
                                                                    Modus.SUBIUNCTIVUS, Vox.ACTIVA, Tempus.PRAESENS,
                                                                    Numeralis.SINGULARIS, Persona.TERTIA))));
  }

  /**
   * Hic modus partem quārtam tentat. <br>
   * Verba "Sed quia nōnnumquam eius modī tempora incidunt" prōdūcat. <br>
   */
  @Test @Order(4)
  public void quarta() {
    System.out.println(new Tentamen.Verbale(productaQuarta, "quārta")
                         .exsequar(structor.strue(structor.adveniam("sed", Categoria.CONIUNCTIO),
                                                  structor.adveniam("quia", Categoria.ADVERBIUM),
                                                  structor.adveniam("nōnnumquam", Categoria.ADVERBIUM),
                                                  structor.adveniam("id", Categoria.PRONOMEN,
                                                                    Specialitas.COMMUNE, Genus.MASCULINUM,
                                                                    Casus.GENITIVUS, Numeralis.SINGULARIS),
                                                  structor.adveniam("modus", Categoria.NOMEN,
                                                                    Specialitas.COMMUNE, Genus.MASCULINUM,
                                                                    Casus.GENITIVUS, Numeralis.SINGULARIS),
                                                  structor.adveniam("tempus", Categoria.NOMEN,
                                                                    Specialitas.COMMUNE, Genus.MASCULINUM,
                                                                    Casus.ABLATIVUS, Numeralis.SINGULARIS),
                                                  structor.adveniam("incidere", Categoria.ACTUS,
                                                                    Modus.INDICATIVUS, Vox.ACTIVA, Tempus.PRAESENS,
                                                                    Numeralis.PLURALIS, Persona.TERTIA))));
  }

  /**
   * Hic modus partem quintam tentat. <br>
   * Verba "Ut labōre et dolōre magnam aliquam quaerat voluptātem" prōdūcat.
   */
  @Test @Order(5)
  public void quinta() {
    System.out.println(new Tentamen.Verbale(productaQuinta, "quīnta")
                         .exsequar(structor.strue(structor.adveniam("ut", Categoria.CONIUNCTIO),
                                                  structor.adveniam("labor", Categoria.NOMEN,
                                                                    Specialitas.COMMUNE, Genus.MASCULINUM,
                                                                    Casus.ABLATIVUS, Numeralis.SINGULARIS),
                                                  structor.adveniam("et", Categoria.CONIUNCTIO),
                                                  structor.adveniam("dolor", Categoria.NOMEN,
                                                                    Specialitas.COMMUNE, Genus.MASCULINUM,
                                                                    Casus.ABLATIVUS, Numeralis.SINGULARIS),
                                                  structor.adveniam("magnum", Categoria.ADIECTIVUM,
                                                                    Specialitas.COMMUNE, Genus.FEMININUM,
                                                                    Casus.ACCUSATIVUS, Numeralis.SINGULARIS),
                                                  structor.adveniam("aliquid", Categoria.PRONOMEN,
                                                                    Specialitas.COMMUNE, Genus.FEMININUM,
                                                                    Casus.ACCUSATIVUS, Numeralis.SINGULARIS),
                                                  structor.adveniam("quaerere", Categoria.ACTUS,
                                                                    Modus.SUBIUNCTIVUS, Vox.ACTIVA, Tempus.PRAESENS,
                                                                    Numeralis.SINGULARIS, Persona.TERTIA),
                                                  structor.adveniam("voluptās", Categoria.NOMEN,
                                                                    Specialitas.COMMUNE, Genus.FEMININUM,
                                                                    Casus.ACCUSATIVUS, Numeralis.SINGULARIS))));
  }

  /**
   * Hic modus tentāmina omnēs praevia coniugat. <br>
   * Verba "Neque porrō quisquam est quī dolōrem ipsum quia dolor sit amet cōnsectētur adipīscī velit sed quia nōnnumquam eius modī tempora incidunt ut labōre et dolōre magnam aliquam quaerat voluptatem" prōdūcat. <br>
   * Aboriētur sī tentāminum aliquid praevium aboriuntur atque prosperābitur sī omnēs prosperantur.
   */
  @Test @Order(6)
  public void cuncta() {
    System.out.println(new Tentamen.Verbale(productaCuncta, "cūncta")
                         .exsequar(structor.strue(structor.adveniam("neque", Categoria.CONIUNCTIO),
                                                  structor.adveniam("porrō", Categoria.ADVERBIUM),
                                                  structor.adveniam("quidquam", Categoria.PRONOMEN,
                                                                    Specialitas.COMMUNE, Genus.MASCULINUM,
                                                                    Casus.NOMINATIVUS, Numeralis.SINGULARIS),
                                                  structor.adveniam("esse", Categoria.ACTUS,
                                                                    Modus.INDICATIVUS, Vox.ACTIVA, Tempus.PRAESENS,
                                                                    Numeralis.SINGULARIS, Persona.TERTIA),
                                                  structor.adveniam("quid", Categoria.PRONOMEN,
                                                                    Specialitas.COMMUNE, Genus.MASCULINUM,
                                                                    Casus.NOMINATIVUS, Numeralis.PLURALIS),
                                                  structor.adveniam("dolor", Categoria.NOMEN,
                                                                    Specialitas.COMMUNE, Genus.MASCULINUM,
                                                                    Casus.ACCUSATIVUS, Numeralis.SINGULARIS),
                                                  structor.adveniam("ipsum", Categoria.PRONOMEN,
                                                                    Specialitas.COMMUNE, Genus.MASCULINUM,
                                                                    Casus.NOMINATIVUS, Numeralis.SINGULARIS),
                                                  structor.adveniam("quia", Categoria.ADVERBIUM),
                                                  structor.adveniam("dolor", Categoria.NOMEN,
                                                                    Specialitas.COMMUNE, Genus.MASCULINUM,
                                                                    Casus.NOMINATIVUS, Numeralis.SINGULARIS),
                                                  structor.adveniam("esse", Categoria.ACTUS,
                                                                    Modus.SUBIUNCTIVUS, Vox.ACTIVA, Tempus.PRAESENS,
                                                                    Numeralis.SINGULARIS, Persona.TERTIA),
                                                  structor.adveniam("amāre", Categoria.ACTUS,
                                                                    Modus.SUBIUNCTIVUS, Vox.ACTIVA, Tempus.PRAESENS,
                                                                    Numeralis.SINGULARIS, Persona.TERTIA),
                                                  structor.adveniam("consectārī", Categoria.ACTUS,
                                                                    Modus.SUBIUNCTIVUS, Vox.ACTIVA, Tempus.PRAESENS,
                                                                    Numeralis.SINGULARIS, Persona.TERTIA),
                                                  structor.adveniam("adipīscī", Categoria.ACTUS,
                                                                    Modus.INFINITIVUS, Vox.ACTIVA, Tempus.PRAESENS,
                                                                    Numeralis.SINGULARIS, Persona.TERTIA),
                                                  structor.adveniam("velle", Categoria.ACTUS,
                                                                    Modus.SUBIUNCTIVUS, Vox.ACTIVA, Tempus.PRAESENS,
                                                                    Numeralis.SINGULARIS, Persona.TERTIA),
                                                  structor.adveniam("sed", Categoria.CONIUNCTIO),
                                                  structor.adveniam("quia", Categoria.ADVERBIUM),
                                                  structor.adveniam("nōnnumquam", Categoria.ADVERBIUM),
                                                  structor.adveniam("id", Categoria.PRONOMEN,
                                                                    Specialitas.COMMUNE, Genus.MASCULINUM,
                                                                    Casus.GENITIVUS, Numeralis.SINGULARIS),
                                                  structor.adveniam("modus", Categoria.NOMEN,
                                                                    Specialitas.COMMUNE, Genus.MASCULINUM,
                                                                    Casus.GENITIVUS, Numeralis.SINGULARIS),
                                                  structor.adveniam("tempus", Categoria.NOMEN,
                                                                    Specialitas.COMMUNE, Genus.MASCULINUM,
                                                                    Casus.ABLATIVUS, Numeralis.SINGULARIS),
                                                  structor.adveniam("incidere", Categoria.ACTUS,
                                                                    Modus.INDICATIVUS, Vox.ACTIVA, Tempus.PRAESENS,
                                                                    Numeralis.PLURALIS, Persona.TERTIA),
                                                  structor.adveniam("ut", Categoria.CONIUNCTIO),
                                                  structor.adveniam("labor", Categoria.NOMEN,
                                                                    Specialitas.COMMUNE, Genus.MASCULINUM,
                                                                    Casus.ABLATIVUS, Numeralis.SINGULARIS),
                                                  structor.adveniam("et", Categoria.CONIUNCTIO),
                                                  structor.adveniam("dolor", Categoria.NOMEN,
                                                                    Specialitas.COMMUNE, Genus.MASCULINUM,
                                                                    Casus.ABLATIVUS, Numeralis.SINGULARIS),
                                                  structor.adveniam("magnum", Categoria.ADIECTIVUM,
                                                                    Specialitas.COMMUNE, Genus.FEMININUM,
                                                                    Casus.ACCUSATIVUS, Numeralis.SINGULARIS),
                                                  structor.adveniam("aliquid", Categoria.PRONOMEN,
                                                                    Specialitas.COMMUNE, Genus.FEMININUM,
                                                                    Casus.ACCUSATIVUS, Numeralis.SINGULARIS),
                                                  structor.adveniam("quaerere", Categoria.ACTUS,
                                                                    Modus.SUBIUNCTIVUS, Vox.ACTIVA, Tempus.PRAESENS,
                                                                    Numeralis.SINGULARIS, Persona.TERTIA),
                                                  structor.adveniam("voluptās", Categoria.NOMEN,
                                                                    Specialitas.COMMUNE, Genus.FEMININUM,
                                                                    Casus.ACCUSATIVUS, Numeralis.SINGULARIS))));
  }
}
