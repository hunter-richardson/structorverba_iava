package com.structorverba.officia.miscella;

import androidx.annotation.NonNull;
import androidx.annotation.*;
import com.github.chaosfirebolt.converter.RomanInteger;
import com.github.chaosfirebolt.converter.constants.*;
import com.structorverba.officia.enumerationes.Categoria;
import com.structorverba.officia.lectores.*;
import com.structorverba.officia.verba.*;
import com.structorverba.officia.verba.multiplicia.VerbumMultiplex;
import jakarta.ejb.Singleton;
import lombok.*;
import org.apache.commons.lang3.*;

import java.util.*;
import java.util.function.Supplier;

/**
 * Classis {@link StructorVerba} accessum mod\u012Bs omnibus programm\u0101tis Str\u016BctorVerba pr\u014Dvidet. <br>
 * S\u014Dlum re\u012B classis huiuc acc\u0113dendus lic\u0113re \u016Bsum pl\u0113num programm\u0101tis \u016Bs\u016Bfructu\u0101ri\u012Bs.
 */
@SuppressWarnings({ "SpellCheckingInspection", "unused" })
@Singleton
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class StructorVerba extends Omne {
  @Nullable private static StructorVerba instantia = null;

  /**
   * Valor hic viam re\u012B classis huiuc facit.
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
   */
  @NonNull public static final Supplier <StructorVerba> faciendum =
    () -> ObjectUtils.firstNonNull(instantia, instantia = new StructorVerba());

  @Getter(value = AccessLevel.PRIVATE, lazy = true)
  @NonNull private final Range <Short> TRACTUS_NUMERORUM = Range.between(Integer.valueOf(1).shortValue(),
                                                                         Integer.valueOf(4000).shortValue());

  @Getter(value = AccessLevel.PRIVATE, lazy = true)
  @NonNull private final LectorMultiplicibus.LectorAdiectivis adiectiva =
    LectorMultiplicibus.LectorAdiectivis.faciendum.get();

  @Getter(value = AccessLevel.PRIVATE, lazy = true)
  @NonNull private final LectorMultiplicibus.LectorAdverbiis adverbia = LectorMultiplicibus.LectorAdverbiis.faciendum.get();

  @Getter(value = AccessLevel.PRIVATE, lazy = true)
  @NonNull private final LectorMultiplicibus.LectorPronominibus pronomina =
    LectorMultiplicibus.LectorPronominibus.faciendum.get();

  @Getter(value = AccessLevel.PRIVATE, lazy = true)
  @NonNull private final LectorMultiplicibus.LectorActis acti = LectorMultiplicibus.LectorActis.faciendum.get();

  @Getter(value = AccessLevel.PRIVATE, lazy = true)
  @NonNull private final LectorMultiplicibus.LectorNominibus nomina = LectorMultiplicibus.LectorNominibus.faciendum.get();

  @Getter(value = AccessLevel.PRIVATE, lazy = true)
  @NonNull private final LectorSimplicibus.LectorConiunctivis coniunctiva =
    LectorSimplicibus.LectorConiunctivis.faciendum.get();

  @Getter(value = AccessLevel.PRIVATE, lazy = true)
  @NonNull private final LectorSimplicibus.LectorInteriectionibus interiectiones =
    LectorSimplicibus.LectorInteriectionibus.faciendum.get();

  @Getter(value = AccessLevel.PRIVATE, lazy = true)
  @NonNull private final LectorPraepositionibus praepositiones = LectorPraepositionibus.faciendum.get();

  /**
   * Modus hic rem apta classis {@link Lector} val\u014Dr\u012B {@code categoria} s\u0113ligit val\u014Drem {@code lemma} immittit.
   * Val\u014Drem {@code null} refert s\u012B rem n\u016Blla classis {@link Lector} valorem {@code categoria} quadrat.
   * @param lemma  valor {@link Verbum#lemma} immittendus
   * @param categoria valor tentendus
   * @param <Hoc>     classis extenta classis {@link VerbumSimplex}
   * @return rem classis {@link Hoc}
   * @see Categoria
   * @see #adveniam(String, Categoria, Enum[])
   */
  @SuppressWarnings("unchecked")
  @Nullable public <Hoc extends Verbum <Hoc>> Hoc adveniam(@NonNull final String lemma,
                                                           @NonNull final Categoria categoria) {
    try {
      return (Hoc) switch (categoria) {
        case NUMERUS -> numeram(lemma);
        case PRAEPOSITIO -> praepositiones.adveniam(lemma);
        default -> Objects.requireNonNull(switch (categoria) {
          case CONIUNCTIVUM -> coniunctiva;
          case INTERIECTIO -> interiectiones;
          default -> null;
        }).adveniam(lemma);
      };
    } catch (NullPointerException e) {
      return null;
    }
  }

  /**
   * Modus hic rem apta classis {@link LectorMultiplicibus} val\u014Dr\u012B {@code categoria} s\u0113ligit val\u014Dr\u0113s {@code
   * lemma}que {@code illa}que immittit. <br> Val\u014Dr\u0113s {@code lemma}que {@code illa}que mod\u014D {@link #adveniam(String,
   * Categoria)} immittit s\u012B rem n\u016Blla classis {@link LectorMultiplicibus} val\u014Drem {@code categoria} quadrat.
   * @param lemma  valor {@link Verbum#lemma} immittendus
   * @param categoria valor tentendus
   * @param illa      val\u014Dr\u0113s immittend\u012B
   * @param <Hoc>     classis extenta classis {@link VerbumMultiplex}
   * @return rem classis {@link Hoc}
   * @see Categoria
   */
  @SuppressWarnings("unchecked")
  @Nullable public <Hoc extends Verbum <Hoc>> Hoc adveniam(@NonNull final String lemma,
                                                           @NonNull final Categoria categoria,
                                                           @NonNull final Enum <?>... illa) {
    return (Hoc) switch (categoria) {
      case PRAEPOSITIO -> praepositiones.adveniam(lemma);
      case NUMERUS ->  numeram(lemma);
      case CONIUNCTIVUM, INTERIECTIO -> (switch (categoria) {
        case CONIUNCTIVUM -> coniunctiva;
        case INTERIECTIO -> interiectiones;
        default -> null;
      }).adveniam(lemma);
      case ACTUS, ADIECTIVUM, ADVERBIUM, NOMEN, PRONOMEN -> (switch (categoria) {
        case ACTUS -> acti;
        case ADIECTIVUM -> adiectiva;
        case ADVERBIUM -> adverbia;
        case NOMEN -> nomina;
        case PRONOMEN -> pronomina;
        default -> null;
      }).adveniam(lemma, illa);
    };
  }

  @SuppressWarnings("unchecked")
  @Nullable public <Hoc extends Verbum<Hoc>> Hoc fortuitumLegam(@NonNull final Categoria categoria) {
    return (Hoc) switch (categoria) {
      case NUMERUS -> fortuitumNumeram();
      case PRAEPOSITIO -> praepositiones.fortuitumLegam();
      case ACTUS, ADIECTIVUM, ADVERBIUM, CONIUNCTIVUM, INTERIECTIO, NOMEN, PRONOMEN -> (switch (categoria) {
        case ACTUS -> acti;
        case ADIECTIVUM -> adiectiva;
        case ADVERBIUM -> adverbia;
        case CONIUNCTIVUM -> coniunctiva;
        case INTERIECTIO -> interiectiones;
        case NOMEN -> nomina;
        case PRONOMEN -> pronomina;
        default -> null;
      }).fortuitumLegam();
    };
  }

  @Nullable public <Hoc extends Verbum<Hoc>> Hoc fortuitumLegam(@NonNull final String lemma,
                                                                @NonNull final Categoria categoria) {
    try {
      return (Hoc) Objects.requireNonNull(switch (categoria) {
        case ACTUS -> acti;
        case ADIECTIVUM -> adiectiva;
        case ADVERBIUM -> adverbia;
        case NOMEN -> nomina;
        case PRONOMEN -> pronomina;
        default -> null;
      }).fortuitumLegam(lemma);
    } catch (NullPointerException e) {
      return null;
    }
  }

  /**
   * @param series seri\u0113s r\u0113rum classis {@link Verbum}
   * @return Rem classis {@link Verba} \u016Bsa val\u014Drem {@code series}
   */
  @NonNull public Verba strue(@Nullable final Verbum <?>... series) {
    return new Verba().addo(series);
  }

  @NonNull public VerbumSimplex.Numerus fortuitumNumeram() {
    return VerbumSimplex.Numerus.builder().numerus(Integer.valueOf(new Random().ints(TRACTUS_NUMERORUM.getMinimum(),
                                                                                     TRACTUS_NUMERORUM.getMaximum())
                                                                               .distinct().findFirst().orElse(10)).shortValue())
                                .build();
  }

  /**
   * @param numerus numerus mathematicus
   * @return Rem classis {@link VerbumSimplex.Numerus}
   */
  public @Nullable VerbumSimplex.Numerus numeram(final short numerus) {
    return TRACTUS_NUMERORUM.contains(numerus) ? VerbumSimplex.Numerus.builder().numerus(numerus).build()
                                               : null;
  }

  /**
   * @param scriptio repraesent\u0101ti\u014Dnem scr\u012Bpta numer\u012B math\u0113matic\u012B
   * @return Rem classis {@link VerbumSimplex.Numerus}
   */
  public @Nullable VerbumSimplex.Numerus numeram(final @NonNull String scriptio) {
    if (Patterns.ROMAN_PATTERN.matcher(scriptio).matches()) {
      final short numerus = Integer.valueOf(RomanInteger.parse(scriptio, IntegerType.ROMAN).getArabic()).shortValue();
      return TRACTUS_NUMERORUM.contains(numerus) ? VerbumSimplex.Numerus.builder().numerus(numerus).build()
                                                 : null;
    } else {
      return null;
    }
  }
}
