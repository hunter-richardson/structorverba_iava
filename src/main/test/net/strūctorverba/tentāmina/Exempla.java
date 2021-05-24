package net.strūctorverba.tentāmina;

import lombok.Getter;
import lombok.experimental.Accessors;
import net.strūctorverba.mīscella.*;
import net.strūctorverba.verba.multiplicia.Āctus;
import net.strūctorverba.ēnumerātiōnēs.*;
import org.jetbrains.annotations.NotNull;
import org.junit.Test;

/**
 * Classis {@link Exempla} exemplum singulum ūsūfructuāriīs iam dēmōnstrat. <br> Exempla additīcia posthāc scrībantur.
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection", "FieldCanBeLocal" })
public class Exempla extends Omnum {
  @NotNull @Getter(lazy = true) @Accessors(fluent = true)
  private final StrūctorVerba strūctor = StrūctorVerba.fac.get();

  @NotNull private final String prōducta = "Ecce lingua Latīna placet prōdestque";

  /**
   * Modus hic exemplum tentat. <br> Verba "Ecce lingua Latīna placet prōdestque" prōdūcat.
   */
  @Test @SuppressWarnings("ConstantConditions")
  public void prōducta( ) {
    System.out.println(new Tentāmen.TentāmenVerbāle(prōducta, "prōducta")
                         .exsequar(strūctor().strue(strūctor().adveniam("ecce", Catēgoria.INTERIECTIŌ),
                                                    strūctor().adveniam("lingua", Catēgoria.NŌMEN,
                                                                        Speciālitās.COMMŪNE, Genus.FĒMINĪNUM,
                                                                        Cāsus.NŌMINĀTĪVUS, Numerālis.SINGULĀRIS),
                                                    strūctor().adveniam("latīnus", Catēgoria.ADIECTĪVUM,
                                                                        Speciālitās.PROPRIUM, Genus.FĒMINĪNUM,
                                                                        Cāsus.NŌMINĀTĪVUS, Numerālis.SINGULĀRIS),
                                                    strūctor().adveniam("plācēre", Catēgoria.ĀCTUS,
                                                                        Modus.INDICĀTĪVUS, Vōx.ĀCTĪVA, Tempus.PRAESĒNS,
                                                                        Numerālis.SINGULĀRIS, Persōna.TERTIA),
                                           ((Āctus) strūctor().adveniam("prōdesse", Catēgoria.ĀCTUS,
                                                                        Modus.INDICĀTĪVUS, Vōx.ĀCTĪVA, Tempus.PRAESĒNS,
                                                                        Numerālis.SINGULĀRIS, Persōna.TERTIA))
                                                      .allegō(Encliticum.CONIUGĀNS))));
  }
}
