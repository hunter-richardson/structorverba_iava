package net.strūctorverba.tentāmina;

import net.strūctorverba.mīscella.Omnum;
import net.strūctorverba.mīscella.StrūctorVerba;
import net.strūctorverba.verba.multiplicia.Āctus;
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
import org.junit.Test;

import lombok.Getter;

/**
 * Classis {@link Carthāgō} versiōnem secundam tentāminārum programmātī StrūctorVerba dēfīnit.
 * Mārcō Porciō Catōnī Maiōrī laudat cum vehementī eius "cēterum cēnseō Carthāginem esse dēlendam".
 * */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection", "FieldCanBeLocal" })
public class Carthāgō extends Omnum {
  @NotNull @Getter(lazy = true)
  private final StrūctorVerba strūctor = StrūctorVerba.fac.get();

  @NotNull private final String prōducta = "Cēterum cēnseō Carthāginem esse dēlendam";

  /**
   * Modus hic tentāmen agit. <br> Verba "cēterum cēnseō Carthāginem esse dēlendam" prōdūcat
   * ut rēs classis {@link Āctus#participem(Vōx, Tempus, Genus, Cāsus, Numerālis)} tententur.
   */
  @Test @SuppressWarnings("ConstantConditions")
  public void dēleātur() {
    System.out.println(new Tentāmen.TentāmenVerbāle(prōducta, "prōducta")
                         .exsequar(strūctor.strue(strūctor.adveniam("cēterum", Catēgoria.ADVERBIUM),
                                                  strūctor.adveniam("cēnsēre", Catēgoria.ĀCTUS,
                                                                    Modus.INDICĀTĪVUS, Vōx.ĀCTĪVA, Tempus.PRAESĒNS,
                                                                    Numerālis.SINGULĀRIS, Persōna.PRĪMA),
                                                  strūctor.adveniam("Carthāgō", Catēgoria.NŌMEN,
                                                                    Speciālitās.PROPRIUM, Genus.FĒMINĪNUM,
                                                                    Cāsus.ACCŪSĀTĪVUS, Numerālis.SINGULĀRIS),
                                                  strūctor.adveniam("esse", Catēgoria.ĀCTUS,
                                                                    Modus.ĪNFĪNĪTĪVUS, Vōx.ĀCTĪVA, Tempus.PRAESĒNS),
                                         ((Āctus) strūctor.adveniam("dēlēre", Catēgoria.ĀCTUS,
                                                                    Modus.ĪNFĪNĪTĪVUS, Vōx.ĀCTĪVA, Tempus.PRAESĒNS))
                                                          .participem(Vōx.PASSĪVA, Tempus.FUTŪRUM,
                                                                      Genus.FĒMINĪNUM, Cāsus.ACCŪSĀTĪVUS,
                                                                      Numerālis.SINGULĀRIS))));
  }
}
