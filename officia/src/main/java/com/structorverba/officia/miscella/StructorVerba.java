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
  @NonNull public static final Supplier <StructorVerba> fac =
    () -> ObjectUtils.firstNonNull(instantia, instantia = new StructorVerba());

  @NonNull private final Range <Short> TRACTUS_NUMERORUM = Range.between(Integer.valueOf(1).shortValue(),
                                                                         Integer.valueOf(4000).shortValue());

  @Getter(value = AccessLevel.PUBLIC, lazy = true)
  @NonNull private final LectorMultiplicibus.LectorAdiectivis adiectiva =
    LectorMultiplicibus.LectorAdiectivis.fac.get();

  @Getter(value = AccessLevel.PUBLIC, lazy = true)
  @NonNull private final LectorMultiplicibus.LectorAdverbiis adverbia = LectorMultiplicibus.LectorAdverbiis.fac.get();

  @Getter(value = AccessLevel.PUBLIC, lazy = true)
  @NonNull private final LectorMultiplicibus.LectorPronominibus pronomina =
    LectorMultiplicibus.LectorPronominibus.fac.get();

  @Getter(value = AccessLevel.PUBLIC, lazy = true)
  @NonNull private final LectorMultiplicibus.LectorActis acti = LectorMultiplicibus.LectorActis.fac.get();

  @Getter(value = AccessLevel.PUBLIC, lazy = true)
  @NonNull private final LectorMultiplicibus.LectorNominibus nomina = LectorMultiplicibus.LectorNominibus.fac.get();

  @Getter(value = AccessLevel.PUBLIC, lazy = true)
  @NonNull private final LectorSimplicibus.LectorConiunctivis coniunctiva =
    LectorSimplicibus.LectorConiunctivis.fac.get();

  @Getter(value = AccessLevel.PUBLIC, lazy = true)
  @NonNull private final LectorSimplicibus.LectorInteriectionibus interiectiones =
    LectorSimplicibus.LectorInteriectionibus.fac.get();

  @Getter(value = AccessLevel.PUBLIC, lazy = true)
  @NonNull private final LectorPraepositionibus praepositiones = LectorPraepositionibus.fac.get();

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
    return switch (categoria) {
      case CONIUNCTIVUM -> (Hoc) coniunctiva.adveniam(lemma);
      case INTERIECTIO -> (Hoc) interiectiones.adveniam(lemma);
      case PRAEPOSITIO -> (Hoc) praepositiones.adveniam(lemma);
      default -> null;
    };
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
  @SuppressWarnings("ConstantConditions")
  @Nullable public <Hoc extends Verbum <Hoc>> Hoc adveniam(@NonNull final String lemma,
                                                           @NonNull final Categoria categoria,
                                                           @NonNull final Enum <?>... illa) {
    try {
      return (Hoc) (switch (categoria) {
        case ADIECTIVUM -> adiectiva;
        case ADVERBIUM -> adverbia;
        case ACTUS -> acti;
        case NOMEN -> nomina;
        case PRONOMEN -> pronomina;
        default -> null;
      }).adveniam(lemma, illa);
    } catch (NullPointerException e) {
      return adveniam(lemma, categoria);
    }
  }

  /**
   * @param series seri\u0113s r\u0113rum classis {@link Verbum}
   * @return Rem classis {@link Verba} \u016Bsa val\u014Drem {@code series}
   */
  @NonNull public Verba strue(@Nullable final Verbum <?>... series) {
    return new Verba().addo(series);
  }

  /**
   * @param numerus numerus mathematicus
   * @return Rem classis {@link VerbumSimplex.Numerus}
   */
  public @Nullable VerbumSimplex.Numerus numerus(final short numerus) {
    return TRACTUS_NUMERORUM.contains(numerus) ? new VerbumSimplex.Numerus(numerus)
                                               : null;
  }

  /**
   * @param scriptio repraesent\u0101ti\u014Dnem scr\u012Bpta numer\u012B math\u0113matic\u012B
   * @return Rem classis {@link VerbumSimplex.Numerus}
   */
  public @Nullable VerbumSimplex.Numerus numerus(final @NonNull String scriptio) {
    if (Patterns.ROMAN_PATTERN.matcher(scriptio).matches()) {
      final short numerus = Integer.valueOf(RomanInteger.parse(scriptio, IntegerType.ROMAN).getArabic()).shortValue();
      return TRACTUS_NUMERORUM.contains(numerus) ? new VerbumSimplex.Numerus(numerus) : null;
    } else {
      return null;
    }
  }
}
