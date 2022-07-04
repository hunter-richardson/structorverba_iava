package com.structorverba.officia;

import com.structorverba.officia.miscella.*;
import com.structorverba.officia.tentamina.Tentamen;
import com.structorverba.officia.verba.multiplicia.Actus;
import com.structorverba.officia.enumerationes.*;

import androidx.annotation.NonNull;
import org.junit.jupiter.api.Test;

import lombok.Getter;

/**
 * Classis {@link Carthago} versiōnem secundam tentāminārum programmātī StrūctorVerba dēfīnit.
 * Mārcō Porciō Catōnī Maiōrī laudat cum vehementī eius "cēterum cēnseō Carthāginem esse dēlendam".
 * */
@SuppressWarnings({"SpellCheckingInspection", "FieldCanBeLocal", "NewClassNamingConvention"})
public class Carthago extends Omne {
  @NonNull @Getter(lazy = true)
  private final StructorVerba structor = StructorVerba.faciendum.get();

  @NonNull private final String producta = "Cēterum cēnseō Carthāginem esse dēlendam";

  /**
   * Hic modus tentāmen agit. <br> Verba "cēterum cēnseō Carthāginem esse dēlendam" prōdūcat
   * ut rēs classis {@link Actus#participem(Vox, Tempus, Genus, Casus, Numeralis)} tententur.
   */
  @Test @SuppressWarnings("ConstantConditions")
  public void deleatur() {
    System.out.println(new Tentamen.TentamenVerbale(producta, "prōducta")
                         .exsequar(structor.strue(structor.adveniam("cēterum", Categoria.ADVERBIUM),
                                                  structor.adveniam("cēnsēre", Categoria.ACTUS,
                                                                    Modus.INDICATIVUS, Vox.ACTIVA, Tempus.PRAESENS,
                                                                    Numeralis.SINGULARIS, Persona.PRIMA),
                                                  structor.adveniam("carthāgō", Categoria.NOMEN,
                                                                    Specialitas.PROPRIUM, Genus.FEMININUM,
                                                                    Casus.ACCUSATIVUS, Numeralis.SINGULARIS),
                                                  structor.adveniam("esse", Categoria.ACTUS,
                                                                    Modus.INFINITIVUS, Vox.ACTIVA, Tempus.PRAESENS),
                                         ((Actus) structor.adveniam("dēlēre", Categoria.ACTUS,
                                                                    Modus.INFINITIVUS, Vox.ACTIVA, Tempus.PRAESENS))
                                                          .participem(Vox.PASSIVA, Tempus.FUTURUM,
                                                                      Genus.FEMININUM, Casus.ACCUSATIVUS,
                                                                      Numeralis.SINGULARIS))));
  }
}
