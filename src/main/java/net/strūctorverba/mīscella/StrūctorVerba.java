package net.strūctorverba.mīscella;

import com.github.chaosfirebolt.converter.RomanInteger;
import com.github.chaosfirebolt.converter.constants.IntegerType;
import com.github.chaosfirebolt.converter.constants.Patterns;

import net.strūctorverba.lēctōrēs.Lēctor;
import net.strūctorverba.lēctōrēs.LēctorMultiplicibus;
import net.strūctorverba.lēctōrēs.LēctorPraepositiōnibus;
import net.strūctorverba.lēctōrēs.LēctorSimplicibus;
import net.strūctorverba.verba.Verba;
import net.strūctorverba.verba.Verbum;
import net.strūctorverba.verba.VerbumSimplex;
import net.strūctorverba.verba.multiplicia.VerbumMultiplex;
import net.strūctorverba.ēnumerātiōnēs.Catēgoria;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.Range;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.function.Supplier;

import javax.ejb.Singleton;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Classis {@link StrūctorVerba} accessum modīs omnibus programmātis StrūctorVerba prōvidet. <br> Sōlum reī classis
 * huiuc accēdendus licēre ūsum plēnum programmātis ūsūfructuāriīs.
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection", "unused" })
@Singleton
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class StrūctorVerba extends Omnum {
  @Nullable private static StrūctorVerba īnstantia = null;

  /**
   * Valor hic viam reī classis huiuc facit.
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
   */
  @NotNull public static final Supplier <StrūctorVerba> fac =
    ( ) -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new StrūctorVerba());

  @NotNull private final Range <Short> TRACTUS_NUMERŌRUM = Range.between(Integer.valueOf(1).shortValue(),
                                                                         Integer.valueOf(4000).shortValue());

  @Getter(value = AccessLevel.PUBLIC, lazy = true)
  @NotNull private final LēctorMultiplicibus.LēctorAdiectīvīs adiectīva =
    LēctorMultiplicibus.LēctorAdiectīvīs.fac.get();

  @Getter(value = AccessLevel.PUBLIC, lazy = true)
  @NotNull private final LēctorMultiplicibus.LēctorAdverbiīs adverbia = LēctorMultiplicibus.LēctorAdverbiīs.fac.get();

  @Getter(value = AccessLevel.PUBLIC, lazy = true)
  @NotNull private final LēctorMultiplicibus.LēctorPrōnōminibus prōnōmina =
    LēctorMultiplicibus.LēctorPrōnōminibus.fac.get();

  @Getter(value = AccessLevel.PUBLIC, lazy = true)
  @NotNull private final LēctorMultiplicibus.LēctorĀctīs āctī = LēctorMultiplicibus.LēctorĀctīs.fac.get();

  @Getter(value = AccessLevel.PUBLIC, lazy = true)
  @NotNull private final LēctorMultiplicibus.LēctorNōminibus nōmina = LēctorMultiplicibus.LēctorNōminibus.fac.get();

  @Getter(value = AccessLevel.PUBLIC, lazy = true)
  @NotNull private final LēctorSimplicibus.LēctorConiūnctīvīs coniūnctīva =
    LēctorSimplicibus.LēctorConiūnctīvīs.fac.get();

  @Getter(value = AccessLevel.PUBLIC, lazy = true)
  @NotNull private final LēctorSimplicibus.LēctorInteriectiōnibus interiectiōnēs =
    LēctorSimplicibus.LēctorInteriectiōnibus.fac.get();

  @Getter(value = AccessLevel.PUBLIC, lazy = true)
  @NotNull private final LēctorPraepositiōnibus praepositiōnēs = LēctorPraepositiōnibus.fac.get();

  /**
   * Modus hic rem apta classis {@link Lēctor} valōrī {@code catēgoria} sēligit valōrem {@code lemma} immittit.
   * Valōrem {@code null} refert sī rem nūlla classis {@link Lēctor} valōrem {@code catēgoria} quadrat.
   * @param lemma  valōrem {@link Verbum#lemma} immittendus
   * @param catēgoria valor tentendus
   * @param <Hoc>     classis extenta classis {@link VerbumSimplex}
   * @return rem classis {@link Hoc}
   * @see Catēgoria
   * @see #adveniam(String, Catēgoria, Enum[])
   */
  @SuppressWarnings("unchecked")
  @Nullable public <Hoc extends Verbum <Hoc>> Hoc adveniam(@NotNull final String lemma,
                                                           @NotNull final Catēgoria catēgoria) {
    return switch (catēgoria) {
      case CONIŪNCTĪVUM -> (Hoc) coniūnctīva.adveniam(lemma);
      case INTERIECTIŌ -> (Hoc) interiectiōnēs.adveniam(lemma);
      case PRAEPOSITIŌ -> (Hoc) praepositiōnēs.adveniam(lemma);
      default -> null;
    };
  }

  /**
   * Modus hic rem apta classis {@link LēctorMultiplicibus} valōrī {@code catēgoria} sēligit valōrēs {@code
   * lemma}que {@code illa}que immittit. <br> Valōrēs {@code lemma}que {@code illa}que modō {@link #adveniam(String,
   * Catēgoria)} immittit sī rem nūlla classis {@link LēctorMultiplicibus} valōrem {@code catēgoria} quadrat.
   * @param lemma  valōrem {@link Verbum#lemma} immittendus
   * @param catēgoria valor tentendus
   * @param illa      valōrēs immittendī
   * @param <Hoc>     classis extenta classis {@link VerbumMultiplex}
   * @return rem classis {@link Hoc}
   * @see Catēgoria
   */
  @SuppressWarnings("ConstantConditions")
  @Nullable public <Hoc extends Verbum <Hoc>> Hoc adveniam(@NotNull final String lemma,
                                                           @NotNull final Catēgoria catēgoria,
                                                           @NotNull final Enum <@NotNull ?>... illa) {
    try {
      return (Hoc) (switch (catēgoria) {
        case ADIECTĪVUM -> adiectīva;
        case ADVERBIUM -> adverbia;
        case ĀCTUS -> āctī;
        case NŌMEN -> nōmina;
        case PRŌNŌMEN -> prōnōmina;
        default -> null;
      }).adveniam(lemma, illa);
    } catch (NullPointerException e) {
      return adveniam(lemma, catēgoria);
    }
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
    return TRACTUS_NUMERŌRUM.contains(numerus) ? new VerbumSimplex.Numerus(numerus)
                                               : null;
  }

  /**
   * @param scrīptiō repraesentātiōnem scrīpta numerī mathēmaticī
   * @return Rem classis {@link VerbumSimplex.Numerus}
   */
  public @Nullable VerbumSimplex.Numerus numerus(final @NotNull String scrīptiō) {
    if (Patterns.ROMAN_PATTERN.matcher(scrīptiō).matches()) {
      final short numerus = RomanInteger.parse(scrīptiō, IntegerType.ROMAN).getArabic().shortValue();
      if (TRACTUS_NUMERŌRUM.contains(numerus)) {
        return new VerbumSimplex.Numerus(numerus);
      } else {
        return null;
      }
    } else {
      return null;
    }
  }
}
