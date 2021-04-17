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

@Singleton @SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection", "unused" })
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class StrūctorVerba {
  private static @Nullable StrūctorVerba īnstantia = null;

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

  public @NotNull LēctorMultiplicibus.LēctorAdiectīvīs adiectīvumLege( ) {
    return adiectīva();
  }

  public @NotNull LēctorSimplicibus.LēctorAdverbiīs adverbiumLege( ) {
    return adverbia();
  }

  public @NotNull LēctorSimplicibus.LēctorConiūnctīvīs coniūnctīvumLege( ) {
    return coniūnctīva();
  }

  public @NotNull LēctorMultiplicibus.LēctorNōminibus nōmenLege( ) {
    return nōmina();
  }

  public @NotNull LēctorMultiplicibus.LēctorPrōnōminibus prōnōmenLege( ) {
    return prōnōmina();
  }

  public @NotNull LēctorMultiplicibus.LēctorPrōnōminibusConiūnctīvīs prōnōmenConiūnctīvumLege( ) {
    return prōnōminaConiūnctīva();
  }

  public @NotNull LēctorPraepositiōnibus praepositiōnemLege( ) {
    return praepositiōnēs();
  }

  public @NotNull LēctorMultiplicibus.LēctorĀctīs āctumLege( ) {
    return ācta();
  }

  public @NotNull VerbaPraepositiōne verbaPraepositiōneStrue(@NotNull final Nōminālis <@NotNull ?> rēs) {
    return VerbaPraepositiōne.conditōr().rēs(rēs).condam();
  }

  public @NotNull VerbaPraepositiōne verbaPraepositiōneStrue(@NotNull final Nōminālis <@NotNull ?> rēs,
                                                    @NotNull final VerbumSimplex.Praepositiō praepositiō) {
    return VerbaPraepositiōne.conditōr().rēs(rēs).praepositiō(praepositiō).condam();
  }

  public @NotNull LinkedList <Verbum <@NotNull ?>> colligō(@NotNull final Collection <Verbum <@Nullable ?>> seriēs) {
    seriēs.removeIf(Objects::isNull);
    seriēs.removeIf(verbum -> StringUtils.isNotBlank(verbum.toString()));
    return new LinkedList <>(seriēs);
  }

  @SuppressWarnings("ConstantConditions")
  public @NotNull LinkedList <Verbum <@NotNull ?>> colligō(@NotNull final Verbum <@Nullable ?>[] seriēs) {
    return Stream.of(seriēs)
                 .filter(Objects::nonNull)
                 .filter(verbum -> StringUtils.isNotBlank(verbum.toString()))
                 .collect(Collectors.toCollection(LinkedList::new));
  }

  public @NotNull Verba strue(@NotNull final Verbum <@Nullable ?>[] verba) {
    return Verba.conditōr().seriēs(colligō(verba)).condam();
  }

  public @NotNull Verba strue(@NotNull final Collection <Verbum <@Nullable ?>> verba) {
    return Verba.conditōr().seriēs(verba).condam();
  }

  public @NotNull Verba strue(@NotNull final Verbum <@Nullable ?>[] verba,
                              @NotNull final Coniugiāle coniūnctīvum) {
    return Verba.conditōr().seriēs(colligō(verba)).coniūnctīvum(coniūnctīvum).condam();
  }

  public @NotNull Verba strue(@NotNull final Collection <Verbum <@Nullable ?>> verba,
                              @NotNull final VerbumSimplex.Coniūnctīvum coniūnctīvum) {
    return Verba.conditōr().seriēs(verba).coniūnctīvum(coniūnctīvum).condam();
  }

  public @NotNull Verba strue(@NotNull final Collection <Verbum <@Nullable ?>> prīma,
                              @NotNull final Coniugiāle coniūnctīvum, @NotNull final Verba secunda) {
    return Verba.conditōr().seriēs(prīma).coniūnctīvum(coniūnctīvum).continuāta(secunda).condam();
  }

  public @NotNull Verba strue(@NotNull final Collection <Verbum <@Nullable ?>> prīma,
                              @NotNull final Coniugiāle coniūnctīvum,
                              @NotNull final Collection <Verbum <@Nullable ?>> secunda) {
    return Verba.conditōr().seriēs(prīma).coniūnctīvum(coniūnctīvum).continuāta(strue(secunda)).condam();
  }

  public @Nullable VerbumSimplex.Numerus numerus(final short numerus) {
    return TRACTUS_NUMERŌRUM.contains(numerus) ? VerbumSimplex.Numerus.conditōr().numerus(numerus).condam()
                                               : null;
  }

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
