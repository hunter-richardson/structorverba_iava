package officia.src.main.java.com.structorverba.officia.tenores;

import officia.src.main.java.com.structorverba.officia.conditores.Conditor;
import officia.src.main.java.com.structorverba.officia.lectores.*;
import officia.src.main.java.com.structorverba.officia.miscella.Omnum;
import officia.src.main.java.com.structorverba.officia.nuntii.Nuntius;
import officia.src.main.java.com.structorverba.officia.verba.Verbum;

import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.*;
import org.xml.sax.helpers.DefaultHandler;

import java.util.*;
import java.util.function.*;

/**
 * Classis {@link Tenor} data l\u0113cta \u0101 r\u0113bus classis {@link Lector} s\u0113liget re\u012Bque aptae classis {@link Conditor}
 * praebet.
 * @param <Hoc> classis extenta classis {@link Verbum}
 * @see Omnum
 * @see <a href="https://docs.oracle.com/javase/7/docs/api/org/xml/sax/helpers/DefaultHandler.html">DefaultHandler</a>
 */
@SuppressWarnings("SpellCheckingInspection")
public abstract class Tenor <Hoc extends Verbum <Hoc>> extends DefaultHandler {
  /**
   * Valor hic est v\u0101s classis {@link Nuntius} class\u012B extent\u012B huius.
   */
  @NotNull protected final Nuntius nuntius;
  /**
   * Valor hic seriem r\u0113rum classis {@link Hoc} praebend\u0101rum ad r\u0113 classis {@link LectorMultiplicibus} tenet.
   */
  protected final @NotNull List <@NotNull Hoc> series = new ArrayList <>();
  /**
   * Valor hic rem classis {@link Hoc} tenet c\u014Dnstruenumque \u0101 re\u012B aptae classis {@link Conditor} praebendumque ad r\u0113
   * classis {@link Lector}.
   */
  @Nullable protected Hoc hoc;

  /**
   * Officium hoc c\u014Dnstr\u016Bct\u014Drem re\u012B classis huius perpetrat.
   * @param nts val\u014Drem {@link #nuntius} supplet.
   */
  protected Tenor(@NotNull final Supplier <@NotNull ? extends Nuntius> nts) {
    Thread.currentThread().setUncaughtExceptionHandler(Nuntius.NuntiusErroribus.fac.get());
    nuntius = nts.get();
  }

  /**
   * @return Val\u014Drem {@link #hoc}
   */
  @Nullable public Hoc refero() {
    return hoc;
  }

  /**
   * Modus hic val\u014Drem {@link #series} per val\u014Drem {@code quaestio} c\u014Dlat ut rem singulam pr\u014Dd\u016Bcat.
   * @param quaestio quaesti\u014D tentanda
   * @return val\u014Drem {@link #series} val\u014Drem {@code quaestio} perc\u014Dl\u0101ta
   */
  public final @Nullable Hoc refero(Predicate <@NotNull Hoc> quaestio) {
    return series.stream().filter(quaestio)
                 .findFirst().orElse(null);
  }

  /**
   * Modus hic f\u014Drmam scr\u012Bptam pr\u014Dv\u012Bsam \u0101 r\u0113 classis <a href="https://docs.oracle.com/en/java/javase/11/docs/api/java.xml/org/xml/sax/XMLReader.html">XMLReader</a>
   * pr\u014Dc\u0113dit.
   * @param litterae litterae pr\u014Dv\u012Bsae
   * @param incepta  positi\u014D incepta in val\u014Drem {@code litterae}
   * @param longitia longitia val\u014Dris {@code litterae} \u016Btend\u012B
   * @see <a href="https://docs.oracle.com/javase/7/docs/api/org/xml/sax/helpers/DefaultHandler.html#characters(char[],%20int,%20int)">DefaultHandler.characters</a>
   */
  @Override public final void characters(final char[] litterae, final int incepta, final int longitia) {
    String forma = new String(litterae, incepta, longitia).trim();
    if (StringUtils.isNotBlank(forma)) {
      nuntius.garrio("Verbum illu'st", forma);
      scribo(forma);
      finiam();
    } else {
      nuntius.moneo("Pr\u014Dducti\u014D verb\u012B pr\u014Dcessimus n\u016Bllae f\u014Drmae.");
    }
  }

  /**
   * Modus hic rem aptam classis {@link Conditor} imperat ut f\u014Drmam scr\u012Bptam re\u012B pr\u014Dductae classis {@link Hoc} indat.
   * @param scripti\u014D f\u014Drmam scr\u012Bptam indendus
   * @see #characters(char[], int, int)
   */
  protected abstract void scribo(@NotNull final String scriptio);

  /**
   * Modus hic rem aptam classis {@link Conditor} imperat c\u014Dnstr\u016Bcti\u014Dnem re\u012Bpr\u014Dductae classis {@link Hoc} f\u012Bn\u012Bre.
   */
  protected abstract void finiam();
}
