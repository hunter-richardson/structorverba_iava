package net.strūctorverba.lēctōrēs;

import lombok.Getter;
import lombok.experimental.Accessors;
import net.strūctorverba.mīscella.*;
import net.strūctorverba.nūntiī.Nūntius;
import net.strūctorverba.verba.VerbumSimplex;
import net.strūctorverba.ēnumerātiōnēs.*;
import org.apache.commons.lang3.*;
import org.jetbrains.annotations.*;

import javax.ejb.*;
import java.io.*;
import java.nio.file.Path;
import java.util.function.*;
import java.util.stream.Stream;

/**
 * Classis {@link LēctorPraepositiōnibus} colliget data ā scāpō XML in scrīnium <a
 * href="{@docRoot}/../src/main/resources">auxiliārēs</a>/praepositiōnēs rēbus classis {@link VerbumSimplex.Praepositiō}
 * scrībere. <br> Dissimilis ā extēnsiōnibus classis {@link Lēctor} est quod scāpum omne seriem longa ēventōrum
 * possibilium continet. Ergō classem {@link Lēctor} nōn extendit. <br> Scāpa quattuor sunt quae reī huic intersunt ut
 * scāpa singulus cāsuī omnī repraesentātō: {@link Cāsus#ABLĀTĪVUS} et {@link Cāsus#ACCŪSĀTĪVUS} et {@link
 * Cāsus#GENITĪVUS} et {@link Cāsus#VOCĀTĪVUS}.
 * @see <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>/praepositiōnēs/ablātīvus.data
 * @see <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>/praepositiōnēs/accūsātīvus.data
 * @see <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>/praepositiōnēs/genitīvus.data
 * @see <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>/praepositiōnēs/vocātīvus.data
 * @see Nūntius.NūntiusLēctōrīPraepositiōnibus
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection", "unused" })
@Singleton
@DependsOn("NūntiusLēctōrīPraepositiōnibus")
public final class LēctorPraepositiōnibus extends Omnum {
  @Nullable private static LēctorPraepositiōnibus īnstantia = null;

  /**
   * Valor hic viam reī classis huiuc facit.
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
   */
  @NotNull public static final Supplier <LēctorPraepositiōnibus> fac =
    ( ) -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new LēctorPraepositiōnibus());

  @Getter(lazy = true) @Accessors(fluent = true)
  @NotNull private final Nūntius.NūntiusLēctōrīPraepositiōnibus nūntius =
    Nūntius.NūntiusLēctōrīPraepositiōnibus.fac.get();

  @NotNull private final BiPredicate <@NotNull String, @NotNull Cāsus> quaerō = (verbum, cāsus) -> {
    final String nōmen = Path.of(Catēgoria.PRAEPOSITIŌ.scrīptiō, String.format("%s.data", cāsus.scrīptiō)).toString();
    try (final BufferedReader pervidētiō = new BufferedReader(new FileReader(nōmen))) {
      nūntius().notō("Iam legō scāpum auxiliārem", nōmen);
      return pervidētiō.lines().anyMatch(līnea -> līnea.trim().equals(Ūtilitās.minusculāsScrībō(verbum)));
    } catch (IOException e) {
      nūntius().terreō(e);
      return false;
    }
  };

  @NotNull private final BiFunction <@NotNull String, @NotNull Cāsus, VerbumSimplex.Praepositiō> adveniō =
    (verbum, cāsus) -> {
      final String nōmen = Path.of(Catēgoria.PRAEPOSITIŌ.scrīptiō, String.format("%s.data", cāsus.scrīptiō)).toString();
      try (final BufferedReader pervidētiō = new BufferedReader(new FileReader(Ūtilitās.auxilior(nōmen)))) {
        nūntius().notō("Iam legō scāpum auxiliārem", nōmen);
        final String fundāmen = pervidētiō.lines()
                                          .filter(līnea -> līnea.trim().equals(Ūtilitās.minusculāsScrībō(verbum)))
                                          .findFirst().orElse(StringUtils.EMPTY);
        if (StringUtils.isNotBlank(fundāmen)) {
          nūntius().garriō("Advenī hoc:", fundāmen);
          return VerbumSimplex.Praepositiō.conditōr().fundāmen(fundāmen).condam();
        } else {
          nūntius().moneō("Nihil advenī verbō", verbum);
          nūntius().garriō(String.format("%snī", VerbumSimplex.Praepositiō.class.getSimpleName()),
                           "assūmētur");
          return VerbumSimplex.Praepositiō.assūme.get();
        }
      } catch (IOException e) {
        nūntius().terreō(e);
        nūntius().garriō(String.format("%snī", VerbumSimplex.Praepositiō.class.getSimpleName()),
                         "assūmētur");
        return VerbumSimplex.Praepositiō.assūme.get();
      }
    };

  private LēctorPraepositiōnibus( ) {
    nūntius().plūrimumGarriō("Factus sum");
  }

  /**
   * Modus hic rem classis {@link VerbumSimplex.Praepositiō} ā scāpō XML in scrīnium <a
   * href="{@docRoot}/../src/main/resources">auxiliārēs</a>/praepositiōnēs cōnābitur advenīre.
   * @param verbum fundāmen praepositiōnī quod rēs haec cōnābitur advenīre
   * @return Rem classis {@link VerbumSimplex.Praepositiō} quam valōrem {@code verbum} quadrat. <br> Modus hic valōrem
   *   {@link VerbumSimplex.Praepositiō#assūme} supplet sī nihil valōrem {@code verbum} quadrat.
   */
  @NotNull public VerbumSimplex.Praepositiō adveniam(@NotNull final String verbum) {
    Cāsus cāsus = Stream.of(Cāsus.ABLĀTĪVUS, Cāsus.ACCŪSĀTĪVUS, Cāsus.GENITĪVUS, Cāsus.VOCĀTĪVUS)
                        .filter(css -> quaerō.test(verbum, css))
                        .findFirst().orElse(Cāsus.DĒRĒCTUS);
    if (Cāsus.DĒRĒCTUS.equals(cāsus)) {
      nūntius().moneō("Nihil advenī verbō", verbum);
      nūntius().garriō(String.format("%snī", VerbumSimplex.Praepositiō.class.getSimpleName()),
                       "assūmētur");
      return VerbumSimplex.Praepositiō.assūme.get();
    } else {
      return adveniō.apply(verbum, cāsus);
    }
  }
}
