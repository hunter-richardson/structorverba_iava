package net.strūctorverba.lēctōrēs;

import lombok.*;
import lombok.experimental.Accessors;
import net.strūctorverba.mīscella.Ūtilitās;
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
 * Classis {@link LēctorPraepositiōnibus} colliget datum ā scāpō XML in scrīnium <a href="../src/main/resources/praepositiōnēs">praepositiōnēs</a> rēbus classis {@link VerbumSimplex.Praepositiō} scrībere. <br>
 * Dissimilis ā extēnsiōnibus classis {@link Lēctor} est quod scāpum omne seriem longa ēventōrum possibilium continet. Ergō classem {@link Lēctor} nōn extendit. <br>
 * Scāpa quattuor sunt quae reī huic intersunt ut scāpa singulus cāsuī omnī repraesentātō: {@link Cāsus#ABLĀTĪVUS} et {@link Cāsus#ACCŪSĀTĪVUS} et {@link Cāsus#GENITĪVUS} et {@link Cāsus#VOCĀTĪVUS}.
 * @see <a href="../src/main/resources/praepositiōnēs/ablātīvus.data">ablātīvus.data</a>
 * @see <a href="../src/main/resources/praepositiōnēs/accūsātīvus.data">accūsātīvus.data</a>
 * @see <a href="../src/main/resources/praepositiōnēs/genitīvus.data">genitīvus.data</a>
 * @see <a href="../src/main/resources/praepositiōnēs/vocātīvus.data">vocātīvus.data</a>
 * @see Nūntius.NūntiusLēctōrīPraepositiōnibus
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection", "unused" })
@Singleton @DependsOn("NūntiusLēctōrīPraepositiōnibus")
public final class LēctorPraepositiōnibus {
  private static @Nullable LēctorPraepositiōnibus īnstantia = null;

  /**
   * Valor hic viam reī classis huiuc facit.
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
   */
  public static final @NotNull Supplier <LēctorPraepositiōnibus> fac =
    () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new LēctorPraepositiōnibus());

  @Getter(lazy = true) @Accessors(fluent = true)
  private final @NotNull Nūntius.NūntiusLēctōrīPraepositiōnibus nūntius = Nūntius.NūntiusLēctōrīPraepositiōnibus.fac.get();

  private final @NotNull BiPredicate<@NotNull String, @NotNull Cāsus> quaerō = (verbum, cāsus) -> {
    final String nōmen = Path.of(Catēgoria.PRAEPOSITIŌ.scrīptiō, String.format("%s.data", cāsus.scrīptiō)).toString();
    try (final BufferedReader pervidētiō = new BufferedReader(new FileReader(nōmen))) {
      nūntius().notō("Iam legō scāpum auxiliārem", nōmen);
      return pervidētiō.lines().anyMatch(līnea -> līnea.trim().equals(Ūtilitās.minusculāsScrībō(verbum)));
    } catch (IOException e) {
      nūntius().terreō(e);
      return false;
    }
  };

  private final @NotNull BiFunction<@NotNull String, @NotNull Cāsus, VerbumSimplex.Praepositiō> adveniō = (verbum, cāsus) -> {
    final String nōmen = Path.of(Catēgoria.PRAEPOSITIŌ.scrīptiō, String.format("%s.data", cāsus.scrīptiō)).toString();
    try (final BufferedReader pervidētiō = new BufferedReader(new FileReader(Ūtilitās.auxilior(nōmen)))) {
      nūntius().notō("Iam legō scāpum auxiliārem", nōmen);
      final String fundāmen = pervidētiō.lines()
                                        .filter(līnea -> līnea.trim().equals(Ūtilitās.minusculāsScrībō(verbum)))
                                        .findFirst().orElse(StringUtils.EMPTY);
      if(StringUtils.isNotBlank(fundāmen)) {
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

  private LēctorPraepositiōnibus() {
    nūntius().plūrimumGarriō("Factus sum");
  }

  /**
   * Modus hic rem classis {@link VerbumSimplex.Praepositiō} ā scāpō XML in scrīnium <a href="../src/main/resources/praepositiōnēs">praepositiōnēs</a> cōnābitur advenīre.
   * @param verbum fundāmen praepositiōnī quod rēs haec cōnābitur advenīre
   * @return rem classis {@link VerbumSimplex.Praepositiō} quam valōrem {@code verbum} quadrat
   */
  public @NotNull VerbumSimplex.Praepositiō adveniam(@NotNull final String verbum) {
   Cāsus cāsus = Stream.of(Cāsus.ABLĀTĪVUS, Cāsus.ACCŪSĀTĪVUS, Cāsus.GENITĪVUS, Cāsus.VOCĀTĪVUS)
                       .filter(css -> quaerō.test(verbum, css))
                       .findFirst().orElse(Cāsus.NŪLLUS);
   if(Cāsus.NŪLLUS.equals(cāsus)) {
     nūntius().moneō("Nihil advenī verbō", verbum);
     nūntius().garriō(String.format("%snī", VerbumSimplex.Praepositiō.class.getSimpleName()),
                      "assūmētur");
     return VerbumSimplex.Praepositiō.assūme.get();
   } else {
     return adveniō.apply(verbum, cāsus);
   }
  }
}
