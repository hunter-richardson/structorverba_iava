package net.strūctorverba.tentāmina;

import net.strūctorverba.mīscella.Omnum;
import net.strūctorverba.mīscella.StrūctorVerba;
import net.strūctorverba.verba.multiplicia.Āctus;
import net.strūctorverba.ēnumerātiōnēs.Catēgoria;
import net.strūctorverba.ēnumerātiōnēs.Cāsus;
import net.strūctorverba.ēnumerātiōnēs.Encliticum;
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
 * Classis {@link Exempla} exemplum singulum ūsūfructuāriīs iam dēmōnstrat. <br> Exempla additīcia posthāc scrībantur.
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection", "FieldCanBeLocal" })
public final class Exempla extends Omnum {
  @NotNull @Getter(lazy = true)
  private final StrūctorVerba strūctor = StrūctorVerba.fac.get();

  @NotNull private final String prōducta = "Ecce lingua Latīna placet prōdestque";

  /**
   * Modus hic exemplum tentat. <br> Verba "Ecce lingua Latīna placet prōdestque" prōdūcat.
   */
  @Test
  public void prōducta( ) {
    System.out.println(new Tentāmen.TentāmenVerbāle(prōducta, "prōducta")
                         .exsequar(strūctor.strue(strūctor.adveniam("ecce", Catēgoria.INTERIECTIŌ),
                                                  strūctor.adveniam("lingua", Catēgoria.NŌMEN,
                                                                    Speciālitās.COMMŪNE, Genus.FĒMINĪNUM,
                                                                    Cāsus.NŌMINĀTĪVUS, Numerālis.SINGULĀRIS),
                                                  strūctor.adveniam("latīnus", Catēgoria.ADIECTĪVUM,
                                                                    Speciālitās.PROPRIUM, Genus.FĒMINĪNUM,
                                                                    Cāsus.NŌMINĀTĪVUS, Numerālis.SINGULĀRIS),
                                                  strūctor.adveniam("plācēre", Catēgoria.ĀCTUS,
                                                                    Modus.INDICĀTĪVUS, Vōx.ĀCTĪVA, Tempus.PRAESĒNS,
                                                                    Numerālis.SINGULĀRIS, Persōna.TERTIA),
                                         ((Āctus) strūctor.adveniam("prōdesse", Catēgoria.ĀCTUS,
                                                                    Modus.INDICĀTĪVUS, Vōx.ĀCTĪVA, Tempus.PRAESĒNS,
                                                                    Numerālis.SINGULĀRIS, Persōna.TERTIA))
                                                    .allegō(Encliticum.CONIUGĀNS))));
  }
}
