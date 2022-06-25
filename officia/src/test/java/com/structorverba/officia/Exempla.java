package com.structorverba.officia;

import com.structorverba.officia.miscella.*;
import com.structorverba.officia.enumerationes.*;

import androidx.annotation.NonNull;
import com.structorverba.officia.verba.multiplicia.Actus;
import org.junit.jupiter.api.Test;

import lombok.Getter;

/**
 * Classis {@link Exempla} exemplum singulum \u016Bs\u016Bfructu\u0101ri\u012Bs iam d\0113m\u014Dnstrat. <br>
 * Exempla addit\u012Bcia posth\u0101c scr\u012Bbantur.
 */
@SuppressWarnings({ "SpellCheckingInspection", "FieldCanBeLocal" })
public final class Exempla extends Omne {
  @NonNull @Getter(lazy = true)
  private final StructorVerba structor = StructorVerba.fac.get();

  @NonNull private final String producta = "Ecce lingua Lat\u012Bna placet pr\u014Ddestque";

  /**
   * Modus hic exemplum tentat. <br>
   * Verba "Ecce lingua Lat\u012Bna placet pr\u014Ddestque" pr\u014Dd\u016Bcat.
   */
  @Test
  public void producta() {
    System.out.println(new Tentamen.TentamenVerbale(producta, "pr\u014Dducta")
                         .exsequar(structor.strue(structor.adveniam("ecce", Categoria.INTERIECTIO),
                                                  structor.adveniam("lingua", Categoria.NOMEN,
                                                                    Specialitas.COMMUNE, Genus.FEMININUM,
                                                                    Casus.NOMINATIVUS, Numeralis.SINGULARIS),
                                                  structor.adveniam("lat\u012Bnum", Categoria.ADIECTIVUM,
                                                                    Specialitas.PROPRIUM, Genus.FEMININUM,
                                                                    Casus.NOMINATIVUS, Numeralis.SINGULARIS),
                                                  structor.adveniam("plac\u0113re", Categoria.ACTUS,
                                                                    Modus.INDICATIVUS, Vox.ACTIVA, Tempus.PRAESENS,
                                                                    Numeralis.SINGULARIS, Persona.TERTIA),
                                         ((Actus) structor.adveniam("pr\u014Ddesse", Categoria.ACTUS,
                                                                    Modus.INDICATIVUS, Vox.ACTIVA, Tempus.PRAESENS,
                                                                    Numeralis.SINGULARIS, Persona.TERTIA))
                                                    .allego(Encliticum.CONIUGANS))));
  }
}
