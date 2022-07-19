package com.structorverba.officia;

import com.structorverba.officia.miscella.*;
import com.structorverba.officia.enumerationes.*;

import androidx.annotation.NonNull;
import com.structorverba.officia.tentamina.Tentamen;
import com.structorverba.officia.verba.multiplicia.Actus;
import org.junit.jupiter.api.Test;

import lombok.Getter;

/**
 * Classis {@link Exempla} exemplum singulum ūsūfructuāriīs iam dēmōnstrat. <br>
 * Exempla additīcia posthāc scrībantur.
 */
@SuppressWarnings({"SpellCheckingInspection", "FieldCanBeLocal", "NewClassNamingConvention"})
public final class Exempla extends Omne {
  @NonNull @Getter(lazy = true)
  private final StructorVerba structor = StructorVerba.faciendum.get();

  @NonNull private final String producta = "Ecce lingua Latīna placet prōdestque";

  /**
   * Hic modus exemplum tentat. <br>
   * Verba "Ecce lingua Latīna placet prōdestque" prōdūcat.
   */
  @Test
  public void producta() {
    //noinspection ConstantConditions
    System.out.println(new Tentamen.TentamenVerbale(producta, "prōducta")
                         .exsequar(structor.strue(structor.adveniam("ecce", Categoria.INTERIECTIO),
                                                  structor.adveniam("lingua", Categoria.NOMEN,
                                                                    Specialitas.COMMUNE, Genus.FEMININUM,
                                                                    Casus.NOMINATIVUS, Numeralis.SINGULARIS),
                                                  structor.adveniam("latīnum", Categoria.ADIECTIVUM,
                                                                    Specialitas.PROPRIUM, Genus.FEMININUM,
                                                                    Casus.NOMINATIVUS, Numeralis.SINGULARIS),
                                                  structor.adveniam("placēre", Categoria.ACTUS,
                                                                    Modus.INDICATIVUS, Vox.ACTIVA, Tempus.PRAESENS,
                                                                    Numeralis.SINGULARIS, Persona.TERTIA),
                                         ((Actus) structor.adveniam("prōdesse", Categoria.ACTUS,
                                                                    Modus.INDICATIVUS, Vox.ACTIVA, Tempus.PRAESENS,
                                                                    Numeralis.SINGULARIS, Persona.TERTIA))
                                                    .allegam(Encliticum.CONIUGANS))));
  }
}
