package com.structorverba.officia.miscella;

import androidx.annotation.NonNull;
import androidx.annotation.*;
import com.structorverba.officia.enumerationes.Categoria;
import com.structorverba.officia.quadriiugia.*;
import com.structorverba.officia.verba.*;
import com.structorverba.officia.verba.simplicia.Numerus;
import jakarta.ejb.Singleton;
import lombok.*;
import org.apache.commons.lang3.*;

import java.util.Objects;
import java.util.function.Supplier;

/**
 * Classis {@link Structor} accessum modīs omnibus programmātis StrūctorVerba prōvidet. <br>
 * Sōlum reī huius classis accēdendus licēre ūsum plēnum programmātis ūsūfructuāriīs.
 */
@SuppressWarnings({ "SpellCheckingInspection", "unused" })
@Singleton
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Structor extends Omne {
  @Nullable private static Structor instantia = null;

  /**
   * Hic valor viam reī huius classis facit.
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
   */
  @NonNull public static final Supplier <Structor> faciendum =
    () -> ObjectUtils.firstNonNull(instantia, instantia = new Structor());

  @NonNull @Getter(value = AccessLevel.PRIVATE, lazy = true)
  private final Lector.Adiectivis adiectiva =
          Lector.Adiectivis.faciendum.get();

  @NonNull @Getter(value = AccessLevel.PRIVATE, lazy = true)
  private final Lector.Adverbiis adverbia = Lector.Adverbiis.faciendum.get();

  @NonNull @Getter(value = AccessLevel.PRIVATE, lazy = true)
  private final Lector.Pronominibus pronomina =
          Lector.Pronominibus.faciendum.get();

  @NonNull @Getter(value = AccessLevel.PRIVATE, lazy = true)
  private final Lector.Actis acti = Lector.Actis.faciendum.get();

  @NonNull @Getter(value = AccessLevel.PRIVATE, lazy = true)
  private final Lector.Nominibus nomina = Lector.Nominibus.faciendum.get();

  @NonNull @Getter(value = AccessLevel.PRIVATE, lazy = true)
  private final Lector.Coniunctionibus coniunctiones = Lector.Coniunctionibus.faciendum.get();

  @NonNull @Getter(value = AccessLevel.PRIVATE, lazy = true)
  private final Lector.Interiectionibus interiectiones = Lector.Interiectionibus.faciendum.get();

  @NonNull @Getter(value = AccessLevel.PRIVATE, lazy = true)
  private final Lector.Praepositionibus praepositiones = Lector.Praepositionibus.faciendum.get();

  @NonNull @Getter(value = AccessLevel.PRIVATE, lazy = true)
  private final Curator.Numeris numerator = Curator.Numeris.faciendum.get();

  /**
   * Hic modus rem apta classis {@link Lector} valōrī {@code categoria} sēligit valōrem {@code lemma} immittit.
   * Valōrem {@code null} refert sī rem nūlla classis {@link Lector} valorem {@code categoria} quadrat.
   * @param lemma  valor {@link Verbum#lemma} immittendus
   * @param categoria valor tentendus
   * @param <Hoc>     classis extenta classis {@link Verbum.Simplex}
   * @return rem classis {@link Hoc}
   * @see Categoria
   * @see #adveniam(String, Categoria, Enum[])
   * @see Lector.Simplicibus#adveniam(String)
   * @see Curator.Numeris#numeram(String)
   */
  @Nullable public <Hoc extends Verbum <Hoc>> Hoc adveniam(@NonNull final String lemma,
                                                           @NonNull final Categoria categoria) {
    if(Categoria.inflectabile(categoria)) {
      return null;
    } else {
      return (Hoc) switch (categoria) {
        case NUMERUS -> numerator.numeram(lemma);
        case PRAEPOSITIO -> praepositiones.adveniam(lemma);
        default -> Objects.requireNonNull(switch (categoria) {
          case CONIUNCTIO -> coniunctiones;
          case INTERIECTIO -> interiectiones;
          default -> null;
        }).adveniam(lemma);
      };
    }
  }

  /**
   * Hic modus rem apta classis {@link Lector.Multiplicibus} valōrī {@code categoria} sēligit valōrēs {@code
   * lemma}que {@code illa}que immittit. <br> Valōrēs {@code lemma}que {@code illa}que modō {@link #adveniam(String,
   * Categoria)} immittit sī rem nūlla classis {@link Lector.Multiplicibus} valōrem {@code categoria} quadrat.
   * @param lemma  valor {@link Verbum#lemma} immittendus
   * @param categoria valor tentendus
   * @param illa      valōrēs immittendī
   * @param <Hoc>     classis extenta classis {@link Verbum.Multiplex}
   * @return rem classis {@link Hoc}
   * @see Categoria
   * @see Lector.Simplicibus#adveniam(String)
   * @see Lector.Multiplicibus#adveniam(String, Enum[])
   * @see Curator.Numeris#numeram(String)
   */
  @SuppressWarnings("ConstantConditions")
  @Nullable public <Hoc extends Verbum <Hoc>> Hoc adveniam(@NonNull final String lemma,
                                                           @NonNull final Categoria categoria,
                                                           @NonNull final Enum <?>... illa) {
    if(Categoria.inflectabile(categoria)) {
      return (Hoc) (switch (categoria) {
        case ACTUS -> acti;
        case ADIECTIVUM -> adiectiva;
        case ADVERBIUM -> adverbia;
        case NOMEN -> nomina;
        case PRONOMEN -> pronomina;
        default -> null;
      }).adveniam(lemma, illa);
    } else if (Categoria.singulaScapis(categoria)) {
      return (Hoc) switch (categoria) {
        case PRAEPOSITIO -> praepositiones.adveniam(lemma);
        case NUMERUS ->  numerator.numeram(lemma);
        default -> null;
      };
    } else {
      return (Hoc) (switch (categoria) {
          case CONIUNCTIO -> coniunctiones;
          case INTERIECTIO -> interiectiones;
          default -> null;
        }).adveniam(lemma);
    }
  }

  /**
   * Hic modus fōrmam temere sēligit.
   * @param categoria  Rēs classis {@link Categoria} quae extēnsiōnem referendam classis {@link Verbum} repraesentat.
   * @return Rem classis {@link Verbum} fortuītam cum valōribus imputātīs
   * @see Lector#fortuitumLegam()
   * @see Lector.Praepositionibus#fortuitumLegam()
   * @see Curator.Numeris#fortuitumNumeram()
   * */
  @SuppressWarnings("ConstantConditions")
  @Nullable public <Hoc extends Verbum<Hoc>> Hoc fortuitumLegam(@NonNull final Categoria categoria) {
    if(Categoria.singulaScapis(categoria)) {
      return (Hoc) (switch (categoria) {
        case ACTUS -> acti;
        case ADIECTIVUM -> adiectiva;
        case ADVERBIUM -> adverbia;
        case CONIUNCTIO -> coniunctiones;
        case INTERIECTIO -> interiectiones;
        case NOMEN -> nomina;
        case PRONOMEN -> pronomina;
        default -> null;
      }).fortuitumLegam();
    } else {
      return (Hoc) switch (categoria) {
        case NUMERUS -> numerator.fortuitumNumeram();
        case PRAEPOSITIO -> praepositiones.fortuitumLegam();
        default -> null;
      };
    }
  }

  /**
   * Hic modus fōrmam temere sēligit.
   * @param categoria  Rēs classis {@link Categoria} quae extēnsiōnem referendam classis {@link Verbum} repraesentat.
   * @param lemma  Lemma reī referenda
   * @return Rem classis {@link Verbum} fortuītam cum valōribus imputātīs
   * @see Lector#fortuitumLegam()
   * @see Lector.Multiplicibus#fortuitumLegam(String)
   * @see Lector.Praepositionibus#fortuitumLegam()
   * @see Curator.Numeris#fortuitumNumeram()
   * */
  @SuppressWarnings("ConstantConditions")
  @Nullable public <Hoc extends Verbum<Hoc>> Hoc fortuitumLegam(@NonNull final String lemma,
                                                                @NonNull final Categoria categoria) {
    if(Categoria.inflectabile(categoria)) {
        return (Hoc) (switch (categoria) {
          case ACTUS -> acti;
          case ADIECTIVUM -> adiectiva;
          case ADVERBIUM -> adverbia;
          case NOMEN -> nomina;
          case PRONOMEN -> pronomina;
          default -> null;
        }).fortuitumLegam(lemma);
    } else if(Categoria.singulaScapis(categoria)) {
      return (Hoc) (Objects.requireNonNull(switch (categoria) {
        case CONIUNCTIO -> coniunctiones;
        case INTERIECTIO -> interiectiones;
        default -> null;
      })).fortuitumLegam();
    } else {
      return (Hoc) switch (categoria) {
        case NUMERUS -> numerator.fortuitumNumeram();
        case PRAEPOSITIO -> praepositiones.fortuitumLegam();
        default -> null;
      };
    }
  }

  /**
   * @param series seriēs rērum classis {@link Verbum}
   * @return Rem classis {@link Verba} ūsa valōrem {@code series}
   */
  @NonNull public Verba strue(@Nullable final Verbum <?>... series) {
    return new Verba().addo(series);
  }

  /**
   * Hic modus fōrmam temere sēligit.
   * @return Rem classis {@link Numerus} fortuītam
   * @see Curator.Numeris#fortuitumNumeram()
   * @implNote  Valōrem {@code X} refert sī fūnctiō fortis dēficit.
   * */
  @Nullable public Numerus fortuitumNumeram() {
    return numerator.fortuitumNumeram();
  }

  /**
   * Hic modus fōrmam temere sēligit.
   * @return Rem classis {@link Numerus} fortuītam
   * @see Curator.Numeris#fortuitumNumeram(Range)
   * @implNote  Valōrem {@code X} refert sī fūnctiō fortis dēficit.
   * */
  @Nullable public Numerus fortuitumNumeram(@NonNull final Range<Short> tractus) {
    return numerator.fortuitumNumeram(tractus);
  }

  /**
   * @param numerus numerus mathematicus
   * @return Rem classis {@link Numerus}
   * Hic modus valōrem {@code null} refert sī <a href="https://github.com/Chaosfirebolt/RomanNumeralConverter/blob/master/src/main/java/com/github/chaosfirebolt/converter/RomanInteger.java">RomanInteger</a>
   * errōrem continuātur.
   * @see Curator.Numeris#numeram(short)
   */
  @Nullable public Numerus numeram(final short numerus) {
    return numerator.numeram(numerus);
    }

  /**
   * @param scriptio numerus mathematicus
   * @return Rem classis {@link Numerus}
   * Hic modus valōrem {@code null} refert sī <a href="https://github.com/Chaosfirebolt/RomanNumeralConverter/blob/master/src/main/java/com/github/chaosfirebolt/converter/RomanInteger.java">RomanInteger</a>
   * errōrem continuātur.
   * @see Curator.Numeris#numeram(String)
   */
  @Nullable public Numerus numeram(@NonNull final String scriptio) {
    return numerator.numeram(scriptio);
  }
}
