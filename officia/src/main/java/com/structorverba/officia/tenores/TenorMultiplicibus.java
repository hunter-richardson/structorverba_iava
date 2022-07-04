package com.structorverba.officia.tenores;

import androidx.annotation.*;
import com.structorverba.officia.conditores.multiplicia.*;
import com.structorverba.officia.lectores.LectorMultiplicibus;
import com.structorverba.officia.miscella.Utilitas;
import com.structorverba.officia.nuntii.*;
import com.structorverba.officia.verba.multiplicia.*;
import jakarta.ejb.*;
import org.apache.commons.lang3.ObjectUtils;
import org.xml.sax.Attributes;

import java.util.*;
import java.util.function.*;

/**
 * Classis {@link TenorMultiplicibus} est vās classis {@link Tenor} classibus omnibus quibus classem {@link
 * VerbumMultiplex} extendit.
 * @param <Hoc> classis extenta classis {@link VerbumMultiplex}
 * @see ConditorMultiplicibus
 */
@SuppressWarnings("SpellCheckingInspection")
public abstract class TenorMultiplicibus <Hoc extends VerbumMultiplex <Hoc>> extends Tenor <Hoc> {
  /**
   * Valor hic est vās classis {@link ConditorMultiplicibus} classī extentī huius.
   */
  @NonNull protected final ConditorMultiplicibus <Hoc> conditor;

  /**
   * Officium hoc cōnstrūctōrem rei classis huius perpetrat.
   * @param nuntius valōrem {@link Tenor#nuntius} supplet.
   * @param cndtr   valōrem {@link #conditor} supplet.
   */
  protected TenorMultiplicibus(@NonNull final Supplier <? extends Nuntius> nuntius,
                               @NonNull final Supplier <? extends ConditorMultiplicibus <Hoc>> cndtr) {
    super(nuntius);
    conditor = cndtr.get();
  }

  /**
   * Modus hic ēnumerātiōnēs prōcēdit lēctās ā rēbus classis {@link LectorMultiplicibus}
   * @param locus     valVrem hunc modus hic nōn ūtitur sed necessārium est ut rē classis <a
   *                  href="https://docs.oracle.com/javase/7/docs/api/org/xml/sax/helpers/DefaultHandler.html">DefaultHandler</a>
   *                  cōnsociet
   * @param loculus   valōrem hunc modus hic nōn ūtitur sed necessārium est ut rē classis <a
   *                  href="https://docs.oracle.com/javase/7/docs/api/org/xml/sax/helpers/DefaultHandler.html">DefaultHandler</a>
   *                  cōnsociet
   * @param qualis    valōrem hunc modus hic nōn ūtitur sed necessārium est ut rē classis <a
   *                  href="https://docs.oracle.com/javase/7/docs/api/org/xml/sax/helpers/DefaultHandler.html">DefaultHandler</a>
   *                  cōnsociet
   * @param attributa seriēs valōrum nōminumque sociVtōrum
   * @see <a href="https://docs.oracle.com/javase/7/docs/api/org/xml/sax/helpers/DefaultHandler.html#startElement(java.lang.String,%20java.lang.String,%20java.lang.String,%20org.xml.sax.Attributes)">DefaultHandler.startElement</a>
   */
  @Override public final void startElement(@NonNull final String locus, @NonNull final String loculus,
                                           @NonNull final String qualis, @NonNull final Attributes attributa) {

    for (int i = 0; i < attributa.getLength(); i++) {
      nuntius.garrio("Teneō adicere attribūtum novum:",
                     attributa.getLocalName(i), "est", attributa.getValue(i));
      conditor.allegam(attributa.getLocalName(i), attributa.getValue(i));
    }
  }

  /**
   * Modus hic rem aptam classis {@link ConditorMultiplicibus} imperat restitui.
   * @param locus   valōrem hunc modus hic nōn ūtitur sed necessārium est ut rē classis <a
   *                href="https://docs.oracle.com/javase/7/docs/api/org/xml/sax/helpers/DefaultHandler.html">DefaultHandler</a>
   *                cōnsociet
   * @param loculus valōrem hunc modus hic nōn ūtitur sed necessārium est ut rē classis <a
   *                href="https://docs.oracle.com/javase/7/docs/api/org/xml/sax/helpers/DefaultHandler.html">DefaultHandler</a>
   *                cōnsociet
   * @param qualis  valōrem hunc modus hic nōn ūtitur sed necessārium est ut rē classis <a
   *                href="https://docs.oracle.com/javase/7/docs/api/org/xml/sax/helpers/DefaultHandler.html">DefaultHandler</a>
   *                cōnsociet
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
      nuntius.moneo("Prōductiō verbī prōcessimus nūllae fōrmae.");
    } else {
      nuntius.garrio("Aggregāvī verbum novum", hoc);
      series.add(hoc);
    }
  }

  /**
   * {@inheritDoc}
   * @param scriptio fōrmam scriptam indendus
   * @see VerbumMultiplex#scriptio
   */
  @Override protected void scribo(@NonNull String scriptio) {
    conditor.ut(scriptio);
  }

  @SuppressWarnings({"unchecked", "ConstantConditions"})
  @Nullable public final Hoc fortuitumReferam() {
    return series.stream().distinct().filter(Objects::nonNull)
            .reduce((BinaryOperator<Hoc>) Utilitas.invocaFortem).orElseGet(null);
  }


  /**
   * Modus hic valōrem {@link #series} per valōrem {@code quaestio} cōlat ut rem singulam prōdūcat.
   * @param quaestio quaestiō tentanda
   * @return valōrem {@link #series} valōrem {@code quaestio} percōlāta
   */
  @Nullable public final Hoc referam(Predicate<Hoc> quaestio) {
    return series.stream().distinct().filter(quaestio)
            .findFirst().orElse(null);
  }

  /**
   * Classis {@link TenorAdverbiis} est vās classis {@link Tenor} classi {@link Adverbium}
   * @see Adverbium
   * @see NuntiusTenoriAdverbiis
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
    @NonNull public static final Supplier <TenorAdverbiis> faciendum =
      () -> ObjectUtils.firstNonNull(instantia, instantia = new TenorAdverbiis());

    private TenorAdverbiis() {
      super(NuntiusTenoriAdverbiis.faciendum, ConditorAdverbiis.faciendum);
      nuntius.plurimumGarrio("Factus sum");
    }

    /**
     * Classis {@link NuntiusTenoriAdverbiis} est vās classis {@link Nuntius} classī {@link
     * TenorMultiplicibus.TenorAdverbiis}
     * @see TenorMultiplicibus.TenorAdverbiis
     */
    @Singleton
    private static final class NuntiusTenoriAdverbiis extends Nuntius {
      @Nullable private static NuntiusTenoriAdverbiis instantia = null;

      /**
       * Valor hic viam reī classis huiuc facit.
       * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
       */
      @NonNull private static final Supplier <NuntiusTenoriAdverbiis> faciendum =
              () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusTenoriAdverbiis());

      private NuntiusTenoriAdverbiis() {
        super(ParametriNuntii.para(TenorMultiplicibus.TenorAdverbiis.class));
      }
    }
  }

  /**
   * Classis {@link TenorNominibus} est vās classis {@link Tenor} classi {@link Nomen}
   * @see Nomen
   * @see NuntiusTenoriNominibus
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
    @NonNull public static final Supplier <TenorNominibus> faciendum =
      () -> ObjectUtils.firstNonNull(instantia, instantia = new TenorNominibus());

    private TenorNominibus() {
      super(NuntiusTenoriNominibus.faciendum, ConditorNominibus.faciendum);
      nuntius.plurimumGarrio("Factus sum");
    }

    /**
     * Classis {@link NuntiusTenoriNominibus} est vās classis {@link Nuntius} classī {@link
     * TenorMultiplicibus.TenorNominibus}
     * @see TenorMultiplicibus.TenorNominibus
     */
    @Singleton
    private static final class NuntiusTenoriNominibus extends Nuntius {
      @Nullable private static NuntiusTenoriNominibus instantia = null;

      /**
       * Valor hic viam reī classis huiuc facit.
       * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
       * @see TenorMultiplicibus.TenorNominibus
       */
      @NonNull private static final Supplier <NuntiusTenoriNominibus> faciendum =
              () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusTenoriNominibus());

      private NuntiusTenoriNominibus() {
        super(ParametriNuntii.para(TenorMultiplicibus.TenorNominibus.class));
      }
    }
  }

  /**
   * Classis {@link TenorAdiectivis} est vās classis {@link Tenor} classi {@link Adiectivum}
   * @see Adiectivum
   * @see NuntiusTenoriAdiectivis
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
    @NonNull public static final Supplier <TenorAdiectivis> faciendum =
      () -> ObjectUtils.firstNonNull(instantia, instantia = new TenorAdiectivis());

    private TenorAdiectivis() {
      super(NuntiusTenoriAdiectivis.faciendum, ConditorAdiectivis.faciendum);
      nuntius.plurimumGarrio("Factus sum");
    }

    /**
     * Classis {@link NuntiusTenoriAdiectivis} est vās classis {@link Nuntius} classī {@link
     * TenorMultiplicibus.TenorAdiectivis}
     * @see TenorMultiplicibus.TenorAdiectivis
     */
    @Singleton
    private static final class NuntiusTenoriAdiectivis extends Nuntius {
      @Nullable private static NuntiusTenoriAdiectivis instantia = null;

      /**
       * Valor hic viam reī classis huiuc facit.
       * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
       */
      @NonNull private static final Supplier <NuntiusTenoriAdiectivis> faciendum =
              () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusTenoriAdiectivis());

      private NuntiusTenoriAdiectivis() {
        super(ParametriNuntii.para(TenorMultiplicibus.TenorAdiectivis.class));
      }
    }
  }

  /**
   * Classis {@link TenorPronominibus} est vās classis {@link Tenor} classi {@link Pronomen}
   * @see Pronomen
   * @see NuntiusTenoriPronominibus
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
    @NonNull public static final Supplier <TenorPronominibus> faciendum =
      () -> ObjectUtils.firstNonNull(instantia, instantia = new TenorPronominibus());

    private TenorPronominibus() {
      super(NuntiusTenoriPronominibus.faciendum, ConditorPronominibus.faciendum);
      nuntius.plurimumGarrio("Factus sum");
    }

    /**
     * Classis {@link NuntiusTenoriPronominibus} est vās classis {@link Nuntius} classī {@link
     * TenorMultiplicibus.TenorPronominibus}
     * @see TenorMultiplicibus.TenorPronominibus
     */
    @Singleton
    private static final class NuntiusTenoriPronominibus extends Nuntius {
      @Nullable private static NuntiusTenoriPronominibus instantia = null;

      /**
       * Valor hic viam reī classis huiuc facit.
       * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
       */
      @NonNull private static final Supplier <NuntiusTenoriPronominibus> faciendum =
              () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusTenoriPronominibus());

      private NuntiusTenoriPronominibus() {
        super(ParametriNuntii.para(TenorMultiplicibus.TenorPronominibus.class));
      }
    }
  }

  /**
   * Classis {@link TenorActis} est vās classis {@link Tenor} classi {@link Actus}
   * @see Actus
   * @see NuntiusTenoriActis
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
    @NonNull public static final Supplier <TenorActis> faciendum =
      () -> ObjectUtils.firstNonNull(instantia, instantia = new TenorActis());

    private TenorActis() {
      super(NuntiusTenoriActis.faciendum, ConditorActis.faciendum);
      nuntius.plurimumGarrio("Factus sum");
    }
  }

  /**
   * Classis {@link NuntiusTenoriActis} est vās classis {@link Nuntius} classī {@link TenorMultiplicibus.TenorActis}
   * @see TenorMultiplicibus.TenorActis
   */
  @Singleton
  private static final class NuntiusTenoriActis extends Nuntius {
    @Nullable private static NuntiusTenoriActis instantia = null;

    /**
     * Valor hic viam reī classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull private static final Supplier <NuntiusTenoriActis> faciendum =
            () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusTenoriActis());

    private NuntiusTenoriActis() {
      super(ParametriNuntii.para(TenorMultiplicibus.TenorActis.class));
    }
  }
}
