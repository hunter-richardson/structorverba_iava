package com.structorverba.officia.tenores;

import androidx.annotation.*;
import com.structorverba.officia.conditores.multiplicia.*;
import com.structorverba.officia.lectores.LectorMultiplicibus;
import com.structorverba.officia.nuntii.Nuntius;
import com.structorverba.officia.verba.multiplicia.*;
import jakarta.ejb.*;
import org.apache.commons.lang3.ObjectUtils;
import org.xml.sax.Attributes;

import java.util.function.Supplier;

/**
 * Classis {@link TenorMultiplicibus} est v\u0101s classis {@link Tenor} classibus omnibus quibus classem {@link
 * VerbumMultiplex} extendit.
 * @param <Hoc> classis extenta classis {@link VerbumMultiplex}
 * @see ConditorMultiplicibus
 */
@SuppressWarnings("SpellCheckingInspection")
public abstract class TenorMultiplicibus <Hoc extends VerbumMultiplex <Hoc>> extends Tenor <Hoc> {
  /**
   * Valor hic est v\u0101s classis {@link ConditorMultiplicibus} class\u012B extent\u012B huius.
   */
  @NonNull protected final ConditorMultiplicibus <Hoc> conditor;

  /**
   * Officium hoc c\u014Dnstr\u016Bct\u014Drem rei classis huius perpetrat.
   * @param nuntius val\u014Drem {@link Tenor#nuntius} supplet.
   * @param cndtr   val\u014Drem {@link #conditor} supplet.
   */
  protected TenorMultiplicibus(@NonNull final Supplier <? extends Nuntius> nuntius,
                               @NonNull final Supplier <? extends ConditorMultiplicibus <Hoc>> cndtr) {
    super(nuntius);
    conditor = cndtr.get();
  }

  /**
   * Modus hic \u0113numer\u0101ti\u014Dn\u0113s pr\u014Dc\u0113dit l\u0113ct\u0101s \u0101 r\u0113bus classis {@link LectorMultiplicibus}
   * @param locus     valVrem hunc modus hic n\u014Dn \u016Btitur sed necess\u0101rium est ut r\u0113 classis <a
   *                  href="https://docs.oracle.com/javase/7/docs/api/org/xml/sax/helpers/DefaultHandler.html">DefaultHandler</a>
   *                  c\u014Dnsociet
   * @param loculus   val\u014Drem hunc modus hic n\u014Dn \u016Btitur sed necess\u0101rium est ut r\u0113 classis <a
   *                  href="https://docs.oracle.com/javase/7/docs/api/org/xml/sax/helpers/DefaultHandler.html">DefaultHandler</a>
   *                  c\u014Dnsociet
   * @param qualis    val\u014Drem hunc modus hic n\u014Dn \u016Btitur sed necess\u0101rium est ut r\u0113 classis <a
   *                  href="https://docs.oracle.com/javase/7/docs/api/org/xml/sax/helpers/DefaultHandler.html">DefaultHandler</a>
   *                  c\u014Dnsociet
   * @param attributa seri\u0113s val\u014Drum n\u014Dminumque sociVt\u014Drum
   * @see <a href="https://docs.oracle.com/javase/7/docs/api/org/xml/sax/helpers/DefaultHandler.html#startElement(java.lang.String,%20java.lang.String,%20java.lang.String,%20org.xml.sax.Attributes)">DefaultHandler.startElement</a>
   */
  @Override public final void startElement(@NonNull final String locus, @NonNull final String loculus,
                                           @NonNull final String qualis, @NonNull final Attributes attributa) {

    for (int i = 0; i < attributa.getLength(); i++) {
      nuntius.garrio("Tene\u014D adicere attrib\u016Btum novum:",
                     attributa.getLocalName(i), "est", attributa.getValue(i));
      conditor.allego(attributa.getLocalName(i), attributa.getValue(i));
    }
  }

  /**
   * Modus hic rem aptam classis {@link ConditorMultiplicibus} imperat restitui.
   * @param locus   val\u014Drem hunc modus hic n\u014Dn \u016Btitur sed necess\u0101rium est ut r\u0113 classis <a
   *                href="https://docs.oracle.com/javase/7/docs/api/org/xml/sax/helpers/DefaultHandler.html">DefaultHandler</a>
   *                c\u014Dnsociet
   * @param loculus val\u014Drem hunc modus hic n\u014Dn \u016Btitur sed necess\u0101rium est ut r\u0113 classis <a
   *                href="https://docs.oracle.com/javase/7/docs/api/org/xml/sax/helpers/DefaultHandler.html">DefaultHandler</a>
   *                c\u014Dnsociet
   * @param qualis  val\u014Drem hunc modus hic n\u014Dn \u016Btitur sed necess\u0101rium est ut r\u0113 classis <a
   *                href="https://docs.oracle.com/javase/7/docs/api/org/xml/sax/helpers/DefaultHandler.html">DefaultHandler</a>
   *                c\u014Dnsociet
   * @see <a href="https://docs.oracle.com/javase/7/docs/api/org/xml/sax/helpers/DefaultHandler.html#endElement(java.lang.String,%20java.lang.String,%20java.lang.String)">DefaultHandler.endElement</a>
   */
  @Override public final void endElement(@NonNull final String locus,
                                         @NonNull final String loculus, @NonNull final String qualis) {
    conditor.restituo();
  }

  /**
   * {@inheritDoc}
   * @see Tenor#series
   */
  @Override protected final void finiam() {
    hoc = conditor.condam();
    if (hoc == null) {
      nuntius.moneo("Pr\u014Dducti\u014D verb\u012B pr\u014Dcessimus n\u016Bllae f\u014Drmae.");
    } else {
      nuntius.garrio("Aggreg\u0101v\u012B verbum novum", hoc);
      series.add(hoc);
    }
  }

  /**
   * {@inheritDoc}
   * @param scriptio f\u014Drmam scriptam indendus
   * @see VerbumMultiplex#scriptio
   */
  @Override protected void scribo(@NonNull String scriptio) {
    conditor.ut(scriptio);
  }

  /**
   * Classis {@link TenorAdverbiis} est v\u0101s classis {@link Tenor} classi {@link Adverbium}
   * @see Adverbium
   * @see Nuntius.NuntiusTenoriAdverbiis
   * @see ConditorAdverbiis
   */
  @Singleton
  @DependsOn({ "ConditorAdverbiis", "NuntiusTenoriAdverbiis" })
  public static final class TenorAdverbiis extends TenorMultiplicibus <Adverbium> {
    @Nullable private static TenorAdverbiis instantia = null;

    /**
     * Valor hic viam rei classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull public static final Supplier <TenorAdverbiis> fac =
      () -> ObjectUtils.firstNonNull(instantia, instantia = new TenorAdverbiis());

    private TenorAdverbiis() {
      super(Nuntius.NuntiusTenoriAdverbiis.fac, ConditorAdverbiis.fac);
      nuntius.plurimumGarrio("Factus sum");
    }
  }

  /**
   * Classis {@link TenorNominibus} est v\u0101s classis {@link Tenor} classi {@link Nomen}
   * @see Nomen
   * @see Nuntius.NuntiusTenoriNominibus
   * @see ConditorNominibus
   */
  @Singleton
  @DependsOn({ "ConditorNominibus", "NuntiusTenoriNominibus" })
  public static final class TenorNominibus extends TenorMultiplicibus <Nomen> {
    @Nullable private static TenorNominibus instantia = null;

    /**
     * Valor hic viam rei classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull public static final Supplier <TenorNominibus> fac =
      () -> ObjectUtils.firstNonNull(instantia, instantia = new TenorNominibus());

    private TenorNominibus() {
      super(Nuntius.NuntiusTenoriNominibus.fac, ConditorNominibus.fac);
      nuntius.plurimumGarrio("Factus sum");
    }
  }

  /**
   * Classis {@link TenorAdiectivis} est v\u0101s classis {@link Tenor} classi {@link Adiectivum}
   * @see Adiectivum
   * @see Nuntius.NuntiusTenoriAdiectivis
   * @see ConditorAdiectivis
   */
  @Singleton
  @DependsOn({ "ConditorAdiectivis", "NuntiusTenoriAdiectivis" })
  public static final class TenorAdiectivis extends TenorMultiplicibus <Adiectivum> {
    @Nullable private static TenorAdiectivis instantia = null;

    /**
     * Valor hic viam rei classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull public static final Supplier <TenorAdiectivis> fac =
      () -> ObjectUtils.firstNonNull(instantia, instantia = new TenorAdiectivis());

    private TenorAdiectivis() {
      super(Nuntius.NuntiusTenoriAdiectivis.fac, ConditorAdiectivis.fac);
      nuntius.plurimumGarrio("Factus sum");
    }
  }

  /**
   * Classis {@link TenorPronominibus} est v\u0101s classis {@link Tenor} classi {@link Pronomen}
   * @see Pronomen
   * @see Nuntius.NuntiusTenoriPronominibus
   * @see ConditorPronominibus
   */
  @Singleton
  @DependsOn({ "ConditorPronominibus", "NuntiusTenoriPronominibus" })
  public static final class TenorPronominibus extends TenorMultiplicibus <Pronomen> {
    @Nullable private static TenorPronominibus instantia = null;

    /**
     * Valor hic viam rei classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull public static final Supplier <TenorPronominibus> fac =
      () -> ObjectUtils.firstNonNull(instantia, instantia = new TenorPronominibus());

    private TenorPronominibus() {
      super(Nuntius.NuntiusTenoriPronominibus.fac, ConditorPronominibus.fac);
      nuntius.plurimumGarrio("Factus sum");
    }
  }

  /**
   * Classis {@link TenorActis} est v\u0101s classis {@link Tenor} classi {@link Actus}
   * @see Actus
   * @see Nuntius.NuntiusTenoriActis
   * @see ConditorActis
   */
  @Singleton
  @DependsOn({ "ConditorActis", "NuntiusTenoriActis" })
  public static final class TenorActis extends TenorMultiplicibus <Actus> {
    @Nullable private static TenorActis instantia = null;

    /**
     * Valor hic viam rei classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull public static final Supplier <TenorActis> fac =
      () -> ObjectUtils.firstNonNull(instantia, instantia = new TenorActis());

    private TenorActis() {
      super(Nuntius.NuntiusTenoriActis.fac, ConditorActis.fac);
      nuntius.plurimumGarrio("Factus sum");
    }
  }
}
