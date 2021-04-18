package net.strūctorverba.mīscella;

import com.github.chaosfirebolt.converter.RomanInteger;
import com.github.chaosfirebolt.converter.constants.*;
import lombok.*;
import lombok.experimental.Accessors;
import net.strūctorverba.lēctōrēs.*;
import net.strūctorverba.verba.*;
import net.strūctorverba.verba.disposita.*;
import net.strūctorverba.verba.multiplicia.Nōminālis;
import org.apache.commons.lang3.Range;
import org.apache.commons.lang3.*;
import org.jetbrains.annotations.*;

import javax.ejb.Singleton;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

/**
 * Classis {@link StrūctorVerba} accessum modīs omnibus programmātis StrūctorVerba prōvidet.
 * Sōlum reī classis huiuc accēdendus licēre ūsum plēnum programmātis ūsūfructuāriīs.
 * @see #fac
 */
@Singleton @SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection", "unused" })
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class StrūctorVerba {
  private static @Nullable StrūctorVerba īnstantia = null;

  /**
   * Valor hic viam reī classis huiuc facit.
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
   */
  public static final @NotNull Supplier <StrūctorVerba> fac =
    () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new StrūctorVerba());

  private final Range<Short> TRACTUS_NUMERŌRUM = Range.between(Integer.valueOf(1).shortValue(),
                                                               Integer.valueOf(4000).shortValue());

  @Getter(lazy = true) @Accessors(fluent = true)
  private final @NotNull LēctorMultiplicibus.LēctorAdiectīvīs adiectīva = LēctorMultiplicibus.LēctorAdiectīvīs.fac.get();

  @Getter(lazy = true) @Accessors(fluent = true)
  private final @NotNull LēctorSimplicibus.LēctorAdverbiīs adverbia = LēctorSimplicibus.LēctorAdverbiīs.fac.get();

  @Getter(lazy = true) @Accessors(fluent = true)
  private final @NotNull LēctorSimplicibus.LēctorConiūnctīvīs coniūnctīva = LēctorSimplicibus.LēctorConiūnctīvīs.fac.get();

  @Getter(lazy = true) @Accessors(fluent = true)
  private final @NotNull LēctorMultiplicibus.LēctorNōminibus nōmina = LēctorMultiplicibus.LēctorNōminibus.fac.get();

  @Getter(lazy = true) @Accessors(fluent = true)
  private final @NotNull LēctorPraepositiōnibus praepositiōnēs = LēctorPraepositiōnibus.fac.get();

  @Getter(lazy = true) @Accessors(fluent = true)
  private final @NotNull LēctorMultiplicibus.LēctorPrōnōminibus prōnōmina = LēctorMultiplicibus.LēctorPrōnōminibus.fac.get();

  @Getter(lazy = true) @Accessors(fluent = true)
  private final @NotNull LēctorMultiplicibus.LēctorPrōnōminibusConiūnctīvīs prōnōminaConiūnctīva = LēctorMultiplicibus.LēctorPrōnōminibusConiūnctīvīs.fac.get();

  @Getter(lazy = true) @Accessors(fluent = true)
  private final @NotNull LēctorMultiplicibus.LēctorĀctīs ācta = LēctorMultiplicibus.LēctorĀctīs.fac.get();

  /**
   * @return rem classis {@link LēctorMultiplicibus.LēctorAdiectīvīs}
   */
  public @NotNull LēctorMultiplicibus.LēctorAdiectīvīs adiectīvumLege( ) {
    return adiectīva();
  }

  /**
   * @return rem classis {@link LēctorSimplicibus.LēctorAdverbiīs}
   */
  public @NotNull LēctorSimplicibus.LēctorAdverbiīs adverbiumLege( ) {
    return adverbia();
  }

  /**
   * @return rem classis {@link LēctorSimplicibus.LēctorConiūnctīvīs}
   */
  public @NotNull LēctorSimplicibus.LēctorConiūnctīvīs coniūnctīvumLege( ) {
    return coniūnctīva();
  }

  /**
   * @return rem classis {@link LēctorMultiplicibus.LēctorNōminibus}
   */
  public @NotNull LēctorMultiplicibus.LēctorNōminibus nōmenLege( ) {
    return nōmina();
  }

  /**
   * @return rem classis {@link LēctorMultiplicibus.LēctorPrōnōminibus}
   */
  public @NotNull LēctorMultiplicibus.LēctorPrōnōminibus prōnōmenLege( ) {
    return prōnōmina();
  }

  /**
   * @return rem classis {@link LēctorMultiplicibus.LēctorPrōnōminibusConiūnctīvīs}
   */
  public @NotNull LēctorMultiplicibus.LēctorPrōnōminibusConiūnctīvīs prōnōmenConiūnctīvumLege( ) {
    return prōnōminaConiūnctīva();
  }

  /**
   * @return rem classis {@link LēctorPraepositiōnibus}
   */
  public @NotNull LēctorPraepositiōnibus praepositiōnemLege( ) {
    return praepositiōnēs();
  }

  /**
   * @return rem classis {@link LēctorMultiplicibus.LēctorĀctīs}
   */
  public @NotNull LēctorMultiplicibus.LēctorĀctīs āctumLege( ) {
    return ācta();
  }

  /**
   * @param rēs rēs classis {@link Nōminālis}
   * @return rem classis {@link VerbaPraepositiōne} ūsa valōrem {@code rēs}
   */
  public @NotNull VerbaPraepositiōne verbaPraepositiōneStrue(@NotNull final Nōminālis <@NotNull ?> rēs) {
    return VerbaPraepositiōne.conditōr().rēs(rēs).condam();
  }

  /**
   * @param rēs rēs classis {@link Nōminālis}
   * @param praepositiō rēs classis {@link VerbumSimplex.Praepositiō}
   * @return rem classis {@link VerbaPraepositiōne} ūsa valōrēs {@code rēs} et {@code praepositiō}
   */
  public @NotNull VerbaPraepositiōne verbaPraepositiōneStrue(@NotNull final Nōminālis <@NotNull ?> rēs,
                                                             @NotNull final VerbumSimplex.Praepositiō praepositiō) {
    return VerbaPraepositiōne.conditōr().rēs(rēs).praepositiō(praepositiō).condam();
  }

  /**
   * @param seriēs seriēs rērum classis {@link Verbum} effingendus
   * @return effigiēs valōris {@code seriēs}
   */
  public @NotNull LinkedList <Verbum <@NotNull ?>> colligō(@NotNull final Collection <Verbum <@Nullable ?>> seriēs) {
    seriēs.removeIf(Objects::isNull);
    seriēs.removeIf(verbum -> StringUtils.isNotBlank(verbum.toString()));
    return new LinkedList <>(seriēs);
  }

  /**
   * @param seriēs seriēs rērum classis {@link Verbum} effingendus
   * @return effigiēs valōris {@code seriēs}
   */
  @SuppressWarnings("ConstantConditions")
  public @NotNull LinkedList <Verbum <@NotNull ?>> colligō(@NotNull final Verbum <@Nullable ?>[] seriēs) {
    return Stream.of(seriēs)
                 .filter(Objects::nonNull)
                 .filter(verbum -> StringUtils.isNotBlank(verbum.toString()))
                 .collect(Collectors.toCollection(LinkedList::new));
  }

  /**
   * @param seriēs seriēs rērum classis {@link Verbum}
   * @return rem classis {@link Verba} ūsa valōrem {@code seriēs}
   */
  public @NotNull Verba strue(@NotNull final Verbum <@Nullable ?>[] seriēs) {
    return Verba.conditōr().seriēs(colligō(seriēs)).condam();
  }

  /**
   * @param seriēs seriēs rērum classis {@link Verbum}
   * @return rem classis {@link Verba} ūsa valōrem {@code seriēs}
   */
  public @NotNull Verba strue(@NotNull final Collection <Verbum <@Nullable ?>> seriēs) {
    return Verba.conditōr().seriēs(seriēs).condam();
  }

  /**
   * @param seriēs seriēs rērum classis {@link Verbum}
   * @param coniūnctīvum rēs classis {@link Coniugiāle}
   * @return rem classis {@link Verba} ūsa valōrem {@code seriēs} et {@code coniūnctīvum}
   */
  public @NotNull Verba strue(@NotNull final Verbum <@Nullable ?>[] seriēs,
                              @NotNull final Coniugiāle coniūnctīvum) {
    return Verba.conditōr().seriēs(colligō(seriēs)).coniūnctīvum(coniūnctīvum).condam();
  }

  /**
   * @param seriēs seriēs rērum classis {@link Verbum}
   * @param coniūnctīvum rēs classis {@link Coniugiāle}
   * @return rem classis {@link Verba} ūsa valōrem {@code seriēs} et {@code coniūnctīvum}
   */
  public @NotNull Verba strue(@NotNull final Collection <Verbum <@Nullable ?>> seriēs,
                              @NotNull final VerbumSimplex.Coniūnctīvum coniūnctīvum) {
    return Verba.conditōr().seriēs(seriēs).coniūnctīvum(coniūnctīvum).condam();
  }

  /**
   * @param prīma seriēs rērum classis {@link Verbum}
   * @param coniūnctīvum rēs classis {@link Coniugiāle}
   * @param secunda rēs classis {@link Verba} ūsa continuāre prīmae
   * @return rem classis {@link Verba} ūsa valōrem {@code seriēs} et {@code coniūnctīvum}
   */
  public @NotNull Verba strue(@NotNull final Collection <Verbum <@Nullable ?>> prīma,
                              @NotNull final Coniugiāle coniūnctīvum, @NotNull final Verba secunda) {
    return Verba.conditōr().seriēs(prīma).coniūnctīvum(coniūnctīvum).continuāta(secunda).condam();
  }

  /**
   * @param prīma seriēs rērum classis {@link Verbum}
   * @param coniūnctīvum rēs classis {@link Coniugiāle}
   * @param secunda rēs classis {@link Verba} ūsa continuāre prīmae
   * @return rem classis {@link Verba} ūsa valōrem {@code seriēs} et {@code coniūnctīvum}
   */
  public @NotNull Verba strue(@NotNull final Collection <Verbum <@Nullable ?>> prīma,
                              @NotNull final Coniugiāle coniūnctīvum,
                              @NotNull final Collection <Verbum <@Nullable ?>> secunda) {
    return Verba.conditōr().seriēs(prīma).coniūnctīvum(coniūnctīvum).continuāta(strue(secunda)).condam();
  }

  /**
   * @param numerus numerus mathēmaticus
   * @return rem classis {@link VerbumSimplex.Numerus}
   */
  public @Nullable VerbumSimplex.Numerus numerus(final short numerus) {
    return TRACTUS_NUMERŌRUM.contains(numerus) ? VerbumSimplex.Numerus.conditōr().numerus(numerus).condam()
                                               : null;
  }

  /**
   * @param scrīptiō repraesentātiōnem scrīpta numerī mathēmaticī
   * @return rem classis {@link VerbumSimplex.Numerus}
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
