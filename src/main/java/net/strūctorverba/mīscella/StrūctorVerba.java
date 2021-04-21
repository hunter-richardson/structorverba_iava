package net.strūctorverba.mīscella;

import com.github.chaosfirebolt.converter.RomanInteger;
import com.github.chaosfirebolt.converter.constants.*;
import lombok.Getter;
import lombok.experimental.Accessors;
import net.strūctorverba.lēctōrēs.*;
import net.strūctorverba.nūntiī.Nūntius;
import net.strūctorverba.verba.*;
import net.strūctorverba.verba.disposita.*;
import net.strūctorverba.verba.multiplicia.Nōminālis;
import org.apache.commons.lang3.Range;
import org.apache.commons.lang3.*;
import org.jetbrains.annotations.*;

import javax.ejb.Singleton;
import java.util.Objects;
import java.util.function.Supplier;

/**
 * Classis {@link StrūctorVerba} accessum modīs omnibus programmātis StrūctorVerba prōvidet. <br>
 * Sōlum reī classis huiuc accēdendus licēre ūsum plēnum programmātis ūsūfructuāriīs.
 */
@Singleton @SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection", "unused" })
public final class StrūctorVerba {
  @Nullable private static StrūctorVerba īnstantia = null;

  /**
   * Valor hic viam reī classis huiuc facit.
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
   */
  @NotNull public static final Supplier <StrūctorVerba> fac =
    () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new StrūctorVerba());

  private final Range<Short> TRACTUS_NUMERŌRUM = Range.between(Integer.valueOf(1).shortValue(),
                                                               Integer.valueOf(4000).shortValue());

  private StrūctorVerba() {
    Thread.currentThread().setUncaughtExceptionHandler(Nūntius.NūntiusErrōribus.fac.get());
  }

  @Getter(lazy = true) @Accessors(fluent = true)
  @NotNull private final LēctorMultiplicibus.LēctorAdiectīvīs adiectīva = LēctorMultiplicibus.LēctorAdiectīvīs.fac.get();

  @Getter(lazy = true) @Accessors(fluent = true)
  @NotNull private final LēctorSimplicibus.LēctorAdverbiīs adverbia = LēctorSimplicibus.LēctorAdverbiīs.fac.get();

  @Getter(lazy = true) @Accessors(fluent = true)
  @NotNull private final LēctorSimplicibus.LēctorConiūnctīvīs coniūnctīva = LēctorSimplicibus.LēctorConiūnctīvīs.fac.get();

  @Getter(lazy = true) @Accessors(fluent = true)
  @NotNull private final LēctorMultiplicibus.LēctorNōminibus nōmina = LēctorMultiplicibus.LēctorNōminibus.fac.get();

  @Getter(lazy = true) @Accessors(fluent = true)
  @NotNull private final LēctorPraepositiōnibus praepositiōnēs = LēctorPraepositiōnibus.fac.get();

  @Getter(lazy = true) @Accessors(fluent = true)
  @NotNull private final LēctorMultiplicibus.LēctorPrōnōminibus prōnōmina = LēctorMultiplicibus.LēctorPrōnōminibus.fac.get();

  @Getter(lazy = true) @Accessors(fluent = true)
  @NotNull private final LēctorMultiplicibus.LēctorPrōnōminibusConiūnctīvīs prōnōminaConiūnctīva = LēctorMultiplicibus.LēctorPrōnōminibusConiūnctīvīs.fac.get();

  @Getter(lazy = true) @Accessors(fluent = true)
  @NotNull private final LēctorMultiplicibus.LēctorĀctīs ācta = LēctorMultiplicibus.LēctorĀctīs.fac.get();

  /**
   * @return Rem classis {@link LēctorMultiplicibus.LēctorAdiectīvīs}
   */
  @NotNull public LēctorMultiplicibus.LēctorAdiectīvīs adiectīvumLege( ) {
    return adiectīva();
  }

  /**
   * @return Rem classis {@link LēctorSimplicibus.LēctorAdverbiīs}
   */
  @NotNull public LēctorSimplicibus.LēctorAdverbiīs adverbiumLege( ) {
    return adverbia();
  }

  /**
   * @return Rem classis {@link LēctorSimplicibus.LēctorConiūnctīvīs}
   */
  @NotNull public LēctorSimplicibus.LēctorConiūnctīvīs coniūnctīvumLege( ) {
    return coniūnctīva();
  }

  /**
   * @return Rem classis {@link LēctorMultiplicibus.LēctorNōminibus}
   */
  @NotNull public LēctorMultiplicibus.LēctorNōminibus nōmenLege( ) {
    return nōmina();
  }

  /**
   * @return Rem classis {@link LēctorMultiplicibus.LēctorPrōnōminibus}
   */
  @NotNull public LēctorMultiplicibus.LēctorPrōnōminibus prōnōmenLege( ) {
    return prōnōmina();
  }

  /**
   * @return Rem classis {@link LēctorMultiplicibus.LēctorPrōnōminibusConiūnctīvīs}
   */
  @NotNull public LēctorMultiplicibus.LēctorPrōnōminibusConiūnctīvīs prōnōmenConiūnctīvumLege( ) {
    return prōnōminaConiūnctīva();
  }

  /**
   * @return Rem classis {@link LēctorPraepositiōnibus}
   */
  @NotNull public LēctorPraepositiōnibus praepositiōnemLege( ) {
    return praepositiōnēs();
  }

  /**
   * @return Rem classis {@link LēctorMultiplicibus.LēctorĀctīs}
   */
  @NotNull public LēctorMultiplicibus.LēctorĀctīs āctumLege( ) {
    return ācta();
  }

  /**
   * @param rēs rēs classis {@link Nōminālis}
   * @return Rem classis {@link VerbaPraepositiōne} ūsa valōrem {@code rēs}
   */
  @NotNull public VerbaPraepositiōne verbaPraepositiōneStrue(@NotNull final Nōminālis <@NotNull ?> rēs) {
    return VerbaPraepositiōne.conditōr().rēs(rēs).condam();
  }

  /**
   * @param rēs rēs classis {@link Nōminālis}
   * @param praepositiō rēs classis {@link VerbumSimplex.Praepositiō}
   * @return Rem classis {@link VerbaPraepositiōne} ūsa valōrēs {@code rēs} et {@code praepositiō}
   */
  @NotNull public VerbaPraepositiōne verbaPraepositiōneStrue(@NotNull final Nōminālis <@NotNull ?> rēs,
                                                             @NotNull final VerbumSimplex.Praepositiō praepositiō) {
    return VerbaPraepositiōne.conditōr().rēs(rēs).praepositiō(praepositiō).condam();
  }

  /**
   * @param seriēs seriēs rērum classis {@link Verbum}
   * @return Rem classis {@link Verba} ūsa valōrem {@code seriēs}
   */
  @NotNull public Verba strue(@Nullable final Verbum <?>... seriēs) {
    return Objects.isNull(seriēs) ? new Verba()
                                  : new Verba().addō(seriēs);
  }

  /**
   * @param numerus numerus mathēmaticus
   * @return Rem classis {@link VerbumSimplex.Numerus}
   */
  public @Nullable VerbumSimplex.Numerus numerus(final short numerus) {
    return TRACTUS_NUMERŌRUM.contains(numerus) ? VerbumSimplex.Numerus.conditōr().numerus(numerus).condam()
                                               : null;
  }

  /**
   * @param scrīptiō repraesentātiōnem scrīpta numerī mathēmaticī
   * @return Rem classis {@link VerbumSimplex.Numerus}
   */
  public @Nullable VerbumSimplex.Numerus numerus(final @NotNull String scrīptiō) {
    if(Patterns.ROMAN_PATTERN.matcher(scrīptiō).matches()) {
      final short numerus = RomanInteger.parse(scrīptiō, IntegerType.ROMAN).getArabic().shortValue();
      if(TRACTUS_NUMERŌRUM.contains(numerus)) {
        return VerbumSimplex.Numerus.conditōr().numerus(numerus).condam();
      } else {
        return null;
      }
    } else {
      return null;
    }
  }
}
