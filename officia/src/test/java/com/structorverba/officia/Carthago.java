package com.structorverba.officia;

import com.structorverba.officia.miscella.*;
import com.structorverba.officia.verba.multiplicia.Actus;
import com.structorverba.officia.enumerationes.*;

import androidx.annotation.NonNull;
import org.junit.jupiter.api.Test;

import lombok.Getter;

/**
 * Classis {@link Carthago} versi\u014Dnem secundam tent\u0101min\u0101rum programm\u0101t\u012B Str\u016BctorVerba d\u0113f\u012Bnit.
 * M\u0101rc\u014D Porci\u014D Cat\u014Dn\u012B Mai\u014Dr\u012B laudat cum vehement\u012B eius "c\u0113terum c\u0113nse\u014D Carth\u0101ginem esse d\u0113lendam".
 * */
@SuppressWarnings({ "SpellCheckingInspection", "FieldCanBeLocal" })
public class Carthago extends Omne {
  @NonNull @Getter(lazy = true)
  private final StructorVerba structor = StructorVerba.fac.get();

  @NonNull private final String producta = "C\u0113terum c\u0113nse\u014D Carth\u0101ginem esse d\u0113lendam";

  /**
   * Modus hic tent\u0101men agit. <br> Verba "c\u0113terum c\u0113nse\u014D Carth\u0101ginem esse d\u0113lendam" pr\u014Dd\u016Bcat
   * ut r\u0113s classis {@link Actus#participem(Vox, Tempus, Genus, Casus, Numeralis)} tententur.
   */
  @Test @SuppressWarnings("ConstantConditions")
  public void deleatur() {
    System.out.println(new Tentamen.TentamenVerbale(producta, "pr\u014Dducta")
                         .exsequar(structor.strue(structor.adveniam("c\u0113terum", Categoria.ADVERBIUM),
                                                  structor.adveniam("c\u0113ns\u0113re", Categoria.ACTUS,
                                                                    Modus.INDICATIVUS, Vox.ACTIVA, Tempus.PRAESENS,
                                                                    Numeralis.SINGULARIS, Persona.PRIMA),
                                                  structor.adveniam("carth\u0101g\u014D", Categoria.NOMEN,
                                                                    Specialitas.PROPRIUM, Genus.FEMININUM,
                                                                    Casus.ACCUSATIVUS, Numeralis.SINGULARIS),
                                                  structor.adveniam("esse", Categoria.ACTUS,
                                                                    Modus.INFINITIVUS, Vox.ACTIVA, Tempus.PRAESENS),
                                         ((Actus) structor.adveniam("d\u0113l\u0113re", Categoria.ACTUS,
                                                                    Modus.INFINITIVUS, Vox.ACTIVA, Tempus.PRAESENS))
                                                          .participem(Vox.PASSIVA, Tempus.FUTURUM,
                                                                      Genus.FEMININUM, Casus.ACCUSATIVUS,
                                                                      Numeralis.SINGULARIS))));
  }
}
