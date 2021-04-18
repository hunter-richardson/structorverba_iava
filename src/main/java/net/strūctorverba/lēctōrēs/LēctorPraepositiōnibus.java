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

@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection", "unused" })
@Singleton @DependsOn("NūntiusLēctōrīPraepositiōnibus")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class LēctorPraepositiōnibus {
  private static @Nullable LēctorPraepositiōnibus īnstantia = null;

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
        nūntius().moneō("Nihil advenī");
        nūntius().moneō(String.format("%snī", VerbumSimplex.Praepositiō.class.getSimpleName()),
                        "assūmētur");
        return VerbumSimplex.Praepositiō.assūme.get();
      }
    } catch (IOException e) {
      nūntius().terreō(e);
      nūntius().moneō(String.format("%snī", VerbumSimplex.Praepositiō.class.getSimpleName()),
                      "assūmētur");
      return VerbumSimplex.Praepositiō.assūme.get();
    }
  };

  public @NotNull VerbumSimplex.Praepositiō adveniam(@NotNull final String verbum) {
   Cāsus cāsus = Stream.of(Cāsus.ABLĀTĪVUS, Cāsus.ACCŪSĀTĪVUS, Cāsus.GENITĪVUS, Cāsus.VOCĀTĪVUS)
                       .filter(css -> quaerō.test(verbum, css))
                       .findFirst().orElse(Cāsus.NŪLLUS);
   if(Cāsus.NŪLLUS.equals(cāsus)) {
     nūntius().moneō("Nihil advenī");
     nūntius().moneō(String.format("%snī", VerbumSimplex.Praepositiō.class.getSimpleName()),
                     "assūmētur");
     return VerbumSimplex.Praepositiō.assūme.get();
   } else {
     return adveniō.apply(verbum, cāsus);
   }
  }
}
