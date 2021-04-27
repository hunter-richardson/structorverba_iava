package net.strūctorverba.tentāmina;

import lombok.Getter;
import lombok.experimental.Accessors;
import net.strūctorverba.mīscella.*;
import net.strūctorverba.verba.Verba;
import net.strūctorverba.verba.multiplicia.Āctum;
import net.strūctorverba.ēnumerātiōnēs.*;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

/**
 * Classis {@link Exempla} exemplum singulum ūsūfructuāriīs iam dēmōnstrat. <br>
 * Exempla additīcia posthāc scrībantur.
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection", "FieldCanBeLocal" })
public class Exempla extends Omnum {
  @NotNull @Getter(lazy = true) @Accessors(fluent = true)
  private final StrūctorVerba strūctor = StrūctorVerba.fac.get();

  @NotNull private final String prōducta = "Ecce lingua Latīna placet prōdestque";

  /**
   * Modus hic exemplum tentat. <br>
   * Verba "Ecce lingua Latīna placet prōdestque" prōdūcat.
   */
  @Test
  public void prōducta() {
    final Āctum prōdest = strūctor().adveniam("prōdesse", Catēgoria.ĀCTUM,
                                              Modus.INDICĀTĪVUS, Vōx.ĀCTĪVA, Tempus.PRAESĒNS,
                                              Numerālis.SINGULĀRIS, Persōna.TERTIA);
    Assertions.assertNotNull(prōdest, "Verba prōducta vacant.");

    final Verba verba = strūctor().strue(strūctor().adveniam("ecce", Catēgoria.INTERIECTIŌ),
                                         strūctor().adveniam("lingua", Catēgoria.NŌMEN,
                                                             Speciālitās.COMMŪNE, Genus.FĒMINĪNUM,
                                                             Cāsus.NŌMINĀTĪVUS, Numerālis.SINGULĀRIS),
                                         strūctor().adveniam("latīnus", Catēgoria.ADIECTĪVUM,
                                                             Speciālitās.PROPRIUM, Genus.FĒMINĪNUM,
                                                             Cāsus.NŌMINĀTĪVUS, Numerālis.SINGULĀRIS),
                                         strūctor().adveniam("plācēre", Catēgoria.ĀCTUM,
                                                             Modus.INDICĀTĪVUS, Vōx.ĀCTĪVA, Tempus.PRAESĒNS,
                                                             Numerālis.SINGULĀRIS, Persōna.TERTIA),
                                         prōdest.allegō(Encliticum.CONIUGĀNS));
    Assertions.assertNotNull(verba, "Verba prōducta vacant.");
    Assertions.assertTrue(CollectionUtils.isNotEmpty(verba.seriēs),
                          "Verba prōducta vacant.");

    for (int index = 0; index < verba.seriēs.size(); index++) {
      Assertions.assertNotNull(verba.seriēs.get(index),
                               String.format("Prōductā est relicta prōductiō verbī %s.",
                                             Ūtilitās.minusculāsScrībō(prōducta.split(String.valueOf(' '))[index])));
      Assertions.assertTrue(StringUtils.isNotBlank(verba.seriēs.get(index).toString()),
                            String.format("Vacat prōductum verbum %s.",
                                          Ūtilitās.minusculāsScrībō(prōducta.split(String.valueOf(' '))[index])));
    }

    Assertions.assertEquals(prōducta, verba.toString(),
                            "Verba prōducta expectātiōne eius differt.");
    System.out.printf("Prōducta: %s%n", verba);
  }
}
