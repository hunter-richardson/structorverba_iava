package officia.src.test.java.com.structorverba.officia;

import officia.src.main.java.com.structorverba.officia.enumerationes.*;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import lombok.Getter;

/**
 * Classis {@link DoloremIpsum} versi\u014Dnem pr\u012Bmam tent\u0101min\u0101rum programm\u0101t\u012B Str\u016BctorVerba d\u0113f\u012Bnit. <br>
 * Laudem Marc\u014D Tulli\u014D Cicer\u014Dn\u012B cum parte dialog\u012B S\u014Dcraticus "D\u0113 F\u012Bnibus Bon\u014Drum et M\u0101l\u014Drum"
 * in libr\u014D pr\u012Bm\u014D secti\u014Dne decim\u0101 vers\u016B duotr\u012Bc\u0113sim\u014D c\u014Dnstruat. <br>
 * Vers\u016Bs ante tri\u0113ntem pr\u012Bmam incipit et post f\u012Bn\u0101lem f\u012Bnit. <br>
 * Pars illa est agnita po\u0113mam istam "Lorem Ipsum" \u012Bnsp\u012Br\u0101visse.
 * @see <a href="http://www.thelatinlibrary.com/cicero/fin1.shtml#32">D\u0113 F\u012Bnibus Bon\u014Drum et Mal\u014Drum</a>
 * @see <a href="https://lipsum.com">"Lorem Ipsum"</a>
 */
@SuppressWarnings({ "SpellCheckingInspection", "FieldCanBeLocal" })
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
final class DoloremIpsum extends Omnum {
  @NotNull @Getter(lazy = true)
  private final StructorVerba structor = StructorVerba.fac.get();

  @NotNull private final String productaPrima   = "Neque porr\u014D quisquam est";
  @NotNull private final String productaSecunda = "Qui dol\u014Drem ipsum quia dolor sit amet";
  @NotNull private final String productaTertia  = "C\u014Dnsectetur adipisci velit";
  @NotNull private final String productaQuarta  = "Sed quia n\u014Dnnumquam eius modi tempora incidunt";
  @NotNull private final String productaQuinta  = "Ut lab\u014Dre et dol\u014Dre magnam aliquam quaerat voluptatem";
  @NotNull private final String productaCuncta  = String.join(' ', productaPrima, productaSecunda, productaTertia, productaQuarta, productaQuinta);

  /**
   * Modus hic partem pr\u012Bmam tentat. <br>
   * Verba "Neque porr\u014D quisquam est" pr\u014Dd\u016Bcat.
   */
  @Test @Order(1)
  public void prima( ) {
    System.out.println(new Tentamen.TentamenVerbale(productaPrima, "pr\u012Bma")
                         .exsequar(structor.strue(structor.adveniam("neque", Categoria.CONIUNCTIVUM),
                                                  structor.adveniam("porr\u014D", Categoria.ADVERBIUM),
                                                  structor.adveniam("quidquam", Categoria.PRONOMEN,
                                                                    Specialitas.COMMUNE, Genus.MASCULINUM,
                                                                    Casus.NOMINATIVUS, Numeralis.SINGULARIS),
                                                  structor.adveniam("esse", Categoria.ACTUS,
                                                                    Modus.INDICATIVUS, Vox.ACTIVA, Tempus.PRAESENS,
                                                                    Numeralis.SINGULARIS, Persona.TERTIA))));
  }

  /**
   * Modus hic partem secundam tentat. <br>
   * Verba "Qu\u012B dol\u014Drem ipsum quia dolor sit amet" pr\u014Dd\u016Bcat.
   */
  @Test @Order(2)
  public void secunda( ) {
    System.out.println(new Tentamen.TentamenVerbale(productaSecunda, "secunda")
                         .exsequar(structor.strue(structor.adveniam("quid", Categoria.PRONOMEN,
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
                                                  structor.adveniam("am\u0101re", Categoria.ACTUS,
                                                                    Modus.SUBIUNCTIVUS, Vox.ACTIVA, Tempus.PRAESENS,
                                                                    Numeralis.SINGULARIS, Persona.TERTIA))));
  }

  /**
   * Modus hic partem tertiam tentat. <br>
   * Verba "C\u014Dnsect\u0113tur adip\u012Bsc\u012B velit" pr\u014Dd\u016Bcat.
   */
  @Test @Order(3)
  public void tertia( ) {
    System.out.println(new Tentamen.TentamenVerbale(productaTertia, "tertia")
                         .exsequar(structor.strue(structor.adveniam("consect\u0101r\u012B", Categoria.ACTUS,
                                                                    Modus.SUBIUNCTIVUS, Vox.ACTIVA, Tempus.PRAESENS,
                                                                    Numeralis.SINGULARIS, Persona.TERTIA),
                                                  structor.adveniam("adip\u012Bsc\u012B", Categoria.ACTUS,
                                                                    Modus.INFINITIVUS, Vox.ACTIVA, Tempus.PRAESENS),
                                                  structor.adveniam("velle", Categoria.ACTUS,
                                                                    Modus.SUBIUNCTIVUS, Vox.ACTIVA, Tempus.PRAESENS,
                                                                    Numeralis.SINGULARIS, Persona.TERTIA))));
  }

  /**
   * Modus hic partem qu\u0101rtam tentat. <br>
   * Verba "Sed quia n\u014Dnnumquam eius mod\u012B tempora incidunt" pr\u014Dd\u016Bcat. <br>
   */
  @Test @Order(4)
  public void quarta( ) {
    System.out.println(new Tentamen.TentamenVerbale(productaQuarta, "qu\u0101rta")
                         .exsequar(structor.strue(structor.adveniam("sed", Categoria.CONIUNCTIVUM),
                                                  structor.adveniam("quia", Categoria.ADVERBIUM),
                                                  structor.adveniam("n\u014Dnnumquam", Categoria.ADVERBIUM),
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
   * Modus hic partem qu\u0101rtam tentat. <br>
   * Verba "Ut lab\u014Dre et dol\u014Dre magnam aliquam quaerat volupt\u0101tem" pr\u014Dd\u016Bcat.
   */
  @Test @Order(5)
  public void quinta( ) {
    System.out.println(new Tentamen.TentamenVerbale(productaQuinta, "qu\u012Bnta")
                         .exsequar(structor.strue(structor.adveniam("ut", Categoria.CONIUNCTIVUM),
                                                  structor.adveniam("labor", Categoria.NOMEN,
                                                                    Specialitas.COMMUNE, Genus.MASCULINUM,
                                                                    Casus.ABLATIVUS, Numeralis.SINGULARIS),
                                                  structor.adveniam("et", Categoria.CONIUNCTIVUM),
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
                                                  structor.adveniam("volupt\u0101s", Categoria.NOMEN,
                                                                    Specialitas.COMMUNE, Genus.FEMININUM,
                                                                    Casus.ACCUSATIVUS, Numeralis.SINGULARIS))));
  }

  /**
   * Modus hic tent\u0101mina omn\u0113s praevia coniugat. <br>
   * Verba "Neque porr\u014D quisquam est qu\u012B dol\u014Drem ipsum quia dolor sit amet c\u014Dnsect\u0113tur adip\u012Bsc\u012B velit sed quia n\u014Dnnumquam eius mod\u012B tempora incidunt ut lab\u014Dre et dol\u014Dre magnam aliquam quaerat voluptatem" pr\u014Dd\u016Bcat. <br>
   * Abori\u0113tur s\u012B tent\u0101minum aliquid praevium aboriuntur atque prosper\u0101bitur s\u012B omn\u0113s prosperantur.
   */
  @Test @Order(6)
  public void cuncta( ) {
    System.out.println(new Tentamen.TentamenVerbale(productaCuncta, "c\u016Bncta")
                         .exsequar(structor.strue(structor.adveniam("neque", Categoria.CONIUNCTIVUM),
                                                  structor.adveniam("porr\u014D", Categoria.ADVERBIUM),
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
                                                  structor.adveniam("am\u0101re", Categoria.ACTUS,
                                                                    Modus.SUBIUNCTIVUS, Vox.ACTIVA, Tempus.PRAESENS,
                                                                    Numeralis.SINGULARIS, Persona.TERTIA),
                                                  structor.adveniam("consect\u0101r\u012B", Categoria.ACTUS,
                                                                    Modus.SUBIUNCTIVUS, Vox.ACTIVA, Tempus.PRAESENS,
                                                                    Numeralis.SINGULARIS, Persona.TERTIA),
                                                  structor.adveniam("adip\u012Bsc\u012B", Categoria.ACTUS,
                                                                    Modus.INFINITIVUS, Vox.ACTIVA, Tempus.PRAESENS,
                                                                    Numeralis.SINGULARIS, Persona.TERTIA),
                                                  structor.adveniam("velle", Categoria.ACTUS,
                                                                    Modus.SUBIUNCTIVUS, Vox.ACTIVA, Tempus.PRAESENS,
                                                                    Numeralis.SINGULARIS, Persona.TERTIA),
                                                  structor.adveniam("sed", Categoria.CONIUNCTIVUM),
                                                  structor.adveniam("quia", Categoria.ADVERBIUM),
                                                  structor.adveniam("n\u014Dnnumquam", Categoria.ADVERBIUM),
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
                                                  structor.adveniam("ut", Categoria.CONIUNCTIVUM),
                                                  structor.adveniam("labor", Categoria.NOMEN,
                                                                    Specialitas.COMMUNE, Genus.MASCULINUM,
                                                                    Casus.ABLATIVUS, Numeralis.SINGULARIS),
                                                  structor.adveniam("et", Categoria.CONIUNCTIVUM),
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
                                                  structor.adveniam("volupt\u0101s", Categoria.NOMEN,
                                                                    Specialitas.COMMUNE, Genus.FEMININUM,
                                                                    Casus.ACCUSATIVUS, Numeralis.SINGULARIS))));
  }
}
