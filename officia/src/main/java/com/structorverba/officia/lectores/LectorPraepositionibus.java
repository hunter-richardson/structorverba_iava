package officia.src.main.java.com.structorverba.officia.lectores;

import officia.src.main.java.com.structorverba.officia.miscella.*;
import officia.src.main.java.com.structorverba.officia.nuntii.Nuntius;
import officia.src.main.java.com.structorverba.officia.verba.VerbumSimplex;
import officia.src.main.java.com.structorverba.officia.enumerationes.*;

import org.apache.commons.lang3.*;
import org.jetbrains.annotations.*;

import java.io.*;
import java.nio.file.Path;
import java.util.function.*;
import java.util.stream.Stream;

import javax.ejb.*;

import lombok.Getter;

/**
 * Classis {@link LectorPraepositionibus} colliget data \u0101 sc\u0101p\u014D XML in
 * scrinium <a href="{@docRoot}/../src/main/resources">auxili\u0101r\u0113s</a>/praepositi\u014Dn\u0113s
 * r\u0113bus classis {@link VerbumSimplex.Praepositio} scr\u012Bbere. <br>
 * Dissimilis \u0101 ext\u0113nsi\u014Dnibus classis {@link Lector} est quod sc\u0101pum omne seriem
 * longa \u0113vent\u014Drum possibilium continet. Erg\u014D classem {@link Lector} n\u014Dn extendit. <br>
 * Sc\u0101pa quattuor sunt quae re\u012B huic intersunt ut sc\u0101pa singulus c\u0101su\u012B omn\u012B repraesent\u0101t\u014D:
 * {@link Casus#ABLATIVUS}QUE {@link Casus#ACCUSATIVUS}QUE {@link
 * Casus#GENITIVUS}QUE {@link Casus#VOCATIVUS}QUE.
 * @see <a href="{@docRoot}/../src/main/resources">auxili\u0101r\u0113s</a>/praepositi\u014Dn\u0113s/abl\u0101t\u012Bvus.data
 * @see <a href="{@docRoot}/../src/main/resources">auxili\u0101r\u0113s</a>/praepositi\u014Dn\u0113s/acc\u016Bs\u0101t\u012Bvus.data
 * @see <a href="{@docRoot}/../src/main/resources">auxili\u0101r\u0113s</a>/praepositi\u014Dn\u0113s/genit\u012Bvus.data
 * @see <a href="{@docRoot}/../src/main/resources">auxili\u0101r\u0113s</a>/praepositi\u014Dn\u0113s/voc\u0101t\u012Bvus.data
 * @see Nuntius.NuntiusLectoriPraepositionibus
 */
@SuppressWarnings({ "SpellCheckingInspection", "unused" })
@Singleton
@DependsOn("NuntiusLectoriPraepositionibus")
public final class LectorPraepositionibus extends Omnum {
  @Nullable private static LectorPraepositionibus instantia = null;

  /**
   * Valor hic viam re\u012B classis huiuc facit.
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
   */
  @NotNull public static final Supplier <LectorPraepositionibus> fac =
    () -> ObjectUtils.firstNonNull(instantia, instantia = new LectorPraepositionibus());

  @Getter(lazy = true)
  @NotNull private final Nuntius.NuntiusLectoriPraepositionibus nuntius =
    Nuntius.NuntiusLectoriPraepositionibus.fac.get();

  @NotNull private final BiPredicate <@NotNull String, @NotNull Casus> quaero = (verbum, casus) -> {
    final String nomen = Path.of(Categoria.PRAEPOSITIO.scriptio, String.format("%s.data", casus.scriptio)).toString();
    try (final BufferedReader pervidetio = new BufferedReader(new FileReader(nomen))) {
      nuntius.noto("Iam leg\u014D sc\u0101pum auxili\u0101rem", nomen);
      return pervidetio.lines().anyMatch(linea -> linea.trim().equals(Utilitas.minusculasScribo(verbum)));
    } catch (IOException e) {
      nuntius.terreo(e);
      return false;
    }
  };

  @NotNull private final BiFunction <@NotNull String, @NotNull Casus, VerbumSimplex.Praepositio> advenio =
    (verbum, casus) -> {
      final String nomen = Path.of(Categoria.PRAEPOSITIO.scriptio, String.format("%s.data", casus.scriptio)).toString();
      try (final BufferedReader pervidetio = new BufferedReader(new FileReader(Utilitas.auxilior(nomen)))) {
        nuntius.noto("Iam leg\u014D sc\u0101pum auxili\u0101rem", nomen);
        final String lemma = pervidetio.lines()
                                       .filter(linea -> linea.trim().equals(Utilitas.minusculasScribo(verbum)))
                                       .findFirst().orElse(StringUtils.EMPTY);
        if (StringUtils.isNotBlank(lemma)) {
          nuntius.garrio("Adven\u012B hoc:", lemma);
          return new VerbumSimplex.Praepositio(lemma);
        } else {
          nuntius.moneo("N\u012Bl adven\u012B verb\u014D", verbum);
          nuntius.garrio(Utilitas.Utilitas.primamCapitaneamScribo(Categoria.PRAEPOSITIO.scriptio.replaceLast('s', '\u012B')),
                           "ass\u016Bm\u0113tur");
          return VerbumSimplex.Praepositio.assume.get();
        }
      } catch (IOException e) {
        nuntius.terreo(e);
        nuntius.garrio(Utilitas.Utilitas.primamCapitaneamScribo(Categoria.PRAEPOSITIO.scriptio.replaceLast('s', '\u012B')),
                         "ass\u016Bm\u0113tur");
        return VerbumSimplex.Praepositio.assume.get();
      }
    };

  private LectorPraepositionibus() {
    nuntius.plurimumGarrio("Factus sum");
  }

  /**
   * Modus hic rem classis {@link VerbumSimplex.Praepositio} \u0101 sc\u0101po XML in scr\u012Bnium
   * <a href="{@docRoot}/../src/main/resources">auxili\u0101r\u0113s</a>/praeposition\u0113s con\u0101bitur adven\u012Bre.
   * @param verbum lemma praeposition\u012B quod r\u0113s haec con\u0101bitur adven\u012Bre
   * @return Rem classis {@link VerbumSimplex.Praepositio} quam valorem {@code verbum} quadrat. <br> Modus hic valorem
   *   {@link VerbumSimplex.Praepositio#assume} supplet s\u012B nihil valorem {@code verbum} quadrat.
   */
  @NotNull public VerbumSimplex.Praepositio adveniam(@NotNull final String verbum) {
    Casus casus = Stream.of(Casus.ABLATIVUS, Casus.ACCUSATIVUS, Casus.GENITIVUS, Casus.VOCATIVUS)
                        .filter(css -> quaero.test(verbum, css))
                        .findFirst().orElse(Casus.DERECTUS);
    if (Casus.DERECTUS.equals(casus)) {
      nuntius.moneo("N\u012Bl adven\u012B verb\u014D", verbum);
      nuntius.garrio(Utilitas.Utilitas.primamCapitaneamScribo(Categoria.PRAEPOSITIO.scriptio.replaceLast('s', '\u012B')),
                       "ass\u016Bm\u0113tur");
      return VerbumSimplex.Praepositio.assume.get();
    } else {
      return advenio.apply(verbum, casus);
    }
  }
}
