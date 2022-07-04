package com.structorverba.officia.lectores;

import androidx.annotation.*;
import com.structorverba.officia.enumerationes.*;
import com.structorverba.officia.miscella.*;
import com.structorverba.officia.nuntii.*;
import com.structorverba.officia.verba.VerbumSimplex;
import jakarta.ejb.*;
import lombok.Getter;
import org.apache.commons.lang3.*;

import java.io.*;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.*;
import java.util.stream.Stream;

/**
 * Classis {@link LectorPraepositionibus} colliget data ā scāpō XML in
 * scrinium <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>/praepositiōnēs
 * rēbus classis {@link VerbumSimplex.Praepositio} scrībere. <br>
 * Dissimilis ā extēnsiōnibus classis {@link Lector} est quod scāpum omne seriem
 * longa ēventōrum possibilium continet. Ergō classem {@link Lector} nōn extendit. <br>
 * Scāpa quattuor sunt quae huic reī intersunt ut scāpa singulus cāsuī omnī repraesentātō:
 * {@link Casus#ABLATIVUS}QUE {@link Casus#ACCUSATIVUS}QUE {@link
 * Casus#GENITIVUS}QUE {@link Casus#VOCATIVUS}QUE.
 * @see <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>/praepositiōnēs/ablātīvus.data
 * @see <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>/praepositiōnēs/accūsātīvus.data
 * @see <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>/praepositiōnēs/genitīvus.data
 * @see <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>/praepositiōnēs/vocātīvus.data
 * @see NuntiusLectoriPraepositionibus
 */
@SuppressWarnings({ "SpellCheckingInspection", "unused" })
@Singleton
@DependsOn("NuntiusLectoriPraepositionibus")
public final class LectorPraepositionibus extends Omne {
  @Nullable private static LectorPraepositionibus instantia = null;

  /**
   * Hic valor viam reī huius classis facit.
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
   */
  @NonNull public static final Supplier <LectorPraepositionibus> faciendum =
    () -> ObjectUtils.firstNonNull(instantia, instantia = new LectorPraepositionibus());

  @Getter(lazy = true)
  @NonNull private final NuntiusLectoriPraepositionibus nuntius = NuntiusLectoriPraepositionibus.faciendum.get();

  @NonNull private final BiPredicate <String, Casus> quaesitus = (verbum, casus) -> {
    final String nomen = Paths.get(Categoria.PRAEPOSITIO.scriptio, String.format("%s.data", casus.scriptio)).toString();
    try (final BufferedReader pervidetio = new BufferedReader(new FileReader(nomen))) {
      nuntius.noto("Iam legō scāpum auxiliārem", nomen);
      return pervidetio.lines().anyMatch(linea -> linea.trim().equals(Utilitas.minusculasScribo(verbum)));
    } catch (IOException e) {
      nuntius.terreo(e);
      return false;
    }
  };

  @NonNull private final BiFunction <String, Casus, VerbumSimplex.Praepositio> adventus =
    (verbum, casus) -> {
      final String nomen = Paths.get(Categoria.PRAEPOSITIO.scriptio, String.format("%s.data", casus.scriptio)).toString();
      try (final BufferedReader pervidetio = new BufferedReader(new FileReader(Utilitas.auxilior(nomen)))) {
        nuntius.noto("Iam legō scāpum auxiliārem", nomen);
        final String lemma = pervidetio.lines().distinct()
                                       .filter(Objects::nonNull)
                                       .filter(linea -> linea.trim().equals(Utilitas.minusculasScribo(verbum)))
                                       .findFirst().orElse(StringUtils.EMPTY);
        if (StringUtils.isNotBlank(lemma)) {
          nuntius.garrio("Advenī hoc:", lemma);
          return VerbumSimplex.Praepositio.builder().lemma(lemma).build();
        } else {
          nuntius.moneo("Nīl advenī verbō", verbum);
          nuntius.garrio(Categoria.PRAEPOSITIO.declina(Casus.DATIVUS, Numeralis.SINGULARIS, true),
                         "assūmētur");
          return VerbumSimplex.Praepositio.assume.get();
        }
      } catch (IOException e) {
        nuntius.terreo(e);
        nuntius.garrio(Categoria.PRAEPOSITIO.declina(Casus.DATIVUS, Numeralis.SINGULARIS, true),
                       "assūmētur");
        return VerbumSimplex.Praepositio.assume.get();
      }
    };

  private LectorPraepositionibus() {
    nuntius.plurimumGarrio("Factus sum");
  }

  /**
   * Hic modus rem classis {@link VerbumSimplex.Praepositio} ā scāpo XML in scrīnium
   * <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>/praepositionēs conābitur advenīre.
   * @param verbum lemma praepositionī quod haec rēs conābitur advenīre
   * @return Rem classis {@link VerbumSimplex.Praepositio} quam valorem {@code verbum} quadrat. <br> Hic modus valorem
   *   {@link VerbumSimplex.Praepositio#assume} supplet sī nihil valorem {@code verbum} quadrat.
   */
  @NonNull public VerbumSimplex.Praepositio adveniam(@NonNull final String verbum) {
    Casus casus = Stream.of(Casus.ABLATIVUS, Casus.ACCUSATIVUS, Casus.GENITIVUS, Casus.VOCATIVUS)
                        .filter(css -> quaesitus.test(verbum, css))
                        .findFirst().orElse(Casus.DERECTUS);
    if (Casus.DERECTUS.equals(casus)) {
      nuntius.moneo("Nīl advenī verbō", verbum);
      nuntius.garrio(Categoria.PRAEPOSITIO.declina(Casus.DATIVUS, Numeralis.SINGULARIS, true),
                     "assūmētur");
      return VerbumSimplex.Praepositio.assume.get();
    } else {
      return adventus.apply(verbum, casus);
    }
  }

  @SuppressWarnings("unchecked")
  @NonNull public VerbumSimplex.Praepositio fortuitumLegam() {
    return fortuitumLegam(Stream.of(Casus.ABLATIVUS, Casus.ACCUSATIVUS, Casus.GENITIVUS, Casus.VOCATIVUS)
                                .reduce((BinaryOperator<Casus>) Utilitas.invocaFortem).orElse(Casus.DERECTUS));
  }

  @SuppressWarnings("unchecked")
  public VerbumSimplex.Praepositio fortuitumLegam(@NonNull final Casus casus) {
    if(Casus.DERECTUS.equals(casus)) {
      nuntius.moneo("Nīl advenī verbō");
      nuntius.garrio(Categoria.PRAEPOSITIO.declina(Casus.DATIVUS, Numeralis.SINGULARIS, true),
                     "assūmētur");
      return VerbumSimplex.Praepositio.assume.get();
    } else {
      final String nomen = Paths.get(Categoria.PRAEPOSITIO.scriptio, String.format("%s.data", casus.scriptio)).toString();
      try (final BufferedReader pervidetio = new BufferedReader(new FileReader(Utilitas.auxilior(nomen)))) {
        nuntius.noto("Iam legō scāpum auxiliārem", nomen);
        final String lemma = pervidetio.lines().distinct().filter(Objects::nonNull)
                                       .reduce((BinaryOperator<String>) Utilitas.invocaFortem)
                                       .orElse(StringUtils.EMPTY);
        if (StringUtils.isNotBlank(lemma)) {
          nuntius.garrio("Advenī hoc:", lemma);
          return VerbumSimplex.Praepositio.builder().lemma(lemma).build();
        } else {
          nuntius.moneo("Nīl advenī verbō");
          nuntius.garrio(Categoria.PRAEPOSITIO.declina(Casus.DATIVUS, Numeralis.SINGULARIS, true),
                         "assūmētur");
          return VerbumSimplex.Praepositio.assume.get();
        }
      } catch (IOException e) {
        nuntius.terreo(e);
        nuntius.garrio(Categoria.PRAEPOSITIO.declina(Casus.DATIVUS, Numeralis.SINGULARIS, true),
                       "assūmētur");
        return VerbumSimplex.Praepositio.assume.get();
      }
    }
  }

  /**
   * Classis {@link NuntiusLectoriPraepositionibus} est vās classis {@link Nuntius} classī {@link
   * LectorPraepositionibus}
   * @see LectorPraepositionibus
   */
  @Singleton
  private static final class NuntiusLectoriPraepositionibus extends Nuntius {
    @Nullable private static NuntiusLectoriPraepositionibus instantia = null;

    /**
     * Hic valor viam reī huius classis facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull private static final Supplier <NuntiusLectoriPraepositionibus> faciendum =
            () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusLectoriPraepositionibus());

    private NuntiusLectoriPraepositionibus() {
      super(ParametriNuntii.para(LectorPraepositionibus.class));
    }
  }
}
