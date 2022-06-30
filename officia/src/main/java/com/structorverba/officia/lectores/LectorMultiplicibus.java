package com.structorverba.officia.lectores;

import androidx.annotation.*;
import com.structorverba.officia.enumerationes.*;
import com.structorverba.officia.inventores.*;
import com.structorverba.officia.miscella.Utilitas;
import com.structorverba.officia.nuntii.*;
import com.structorverba.officia.tenores.TenorMultiplicibus;
import com.structorverba.officia.verba.multiplicia.*;
import jakarta.ejb.*;
import org.apache.commons.lang3.ObjectUtils;

import java.io.IOException;
import java.util.function.Supplier;

/**
 * Classis {@link LectorMultiplicibus} est v\u0101s classis {@link Lector} classibus omnibus quibus classem {@link
 * VerbumMultiplex} extendit.
 * @param <Hoc> classis extenta classis {@link VerbumMultiplex}
 * @see Inventor
 * @see TenorMultiplicibus
 */
@SuppressWarnings("SpellCheckingInspection")
public abstract class LectorMultiplicibus <Hoc extends VerbumMultiplex <Hoc>> extends Lector <Hoc> {
  @NonNull private final Inventor <Hoc> inventor;

  /**
   * Officium hoc c\u014Dnstr\u016Bct\u014Drem re\u012B classis huius perpetrat.
   * @param categoria val\u014Drem {@link Lector#categoria} indicat.
   * @param nuntius   val\u014Drem {@link Lector#nuntius} supplet.
   * @param tenor     val\u014Drem {@link Lector#tenor} supplet.
   * @param inventor  valor hic colit \u0113vent\u012Bs mult\u012Bs possibilibus quibus {@link Lector#tenor} referat.
   */
  protected LectorMultiplicibus(@NonNull final Categoria categoria,
                                @NonNull final Supplier <? extends Nuntius> nuntius,
                                @NonNull final Supplier <? extends TenorMultiplicibus <Hoc>> tenor,
                                @NonNull final Supplier <? extends Inventor <Hoc>> inventor) {
    super(categoria, nuntius, tenor);
    this.inventor = inventor.get();
  }

  /**
   * Modus hic \u016Btitur modus {@link Lector#legam(String)} ut rem classis {@link Hoc} \u0101 val\u014Dre {@link Lector#tenor}
   * adveniat.
   * @param lemma lemma verb\u014D quod r\u0113s haec c\u014Dn\u0101bitur adven\u012Bre
   * @param illa     seri\u0113s \u0113numer\u0101ti\u014Dnum quam licet {@link #inventor} c\u014Dlere \u0113vent\u012Bs l\u0113ct\u012Bs
   * @return Rem classis {@link Hoc} quam val\u014Drem {@code verbum} quadrat. <br>
   * Modus hic val\u014Drem {@code null} refert s\u012B n\u012Bl quadrat val\u014Drem {@code verbum}.
   */
  @Nullable public final Hoc adveniam(@NonNull final String lemma, @NonNull final Enum <?>... illa) {
    legam(lemma);
    final Hoc hoc = ((TenorMultiplicibus<Hoc>) tenor).referam(inventor.allego(illa).inquiram());
    inventor.restituo();
    if (hoc == null) {
      nuntius.moneo("N\u012Bl adven\u012B");
    } else {
      nuntius.garrio("Adven\u012B hoc:", hoc);
    }
    return hoc;
  }

  @Nullable public Hoc fortuitumLegam() {
    try {
      return fortuitumLegam(Utilitas.fortuitumLegam(categoria));
    } catch (IOException e) {
      nuntius.terreo(e);
      return null;
    }
  }

  @Nullable public Hoc fortuitumLegam(@NonNull final String lemma) {
    legam(lemma);
    final Hoc hoc = ((TenorMultiplicibus<Hoc>) tenor).fortuitumReferam();
    if (hoc == null) {
      nuntius.moneo("N\u012Bl adven\u012B");
    } else {
      nuntius.garrio("Adven\u012B hoc:", hoc);
    }
    return hoc;
  }

  /**
   * Classis {@link LectorAdverbiis} est v\u0101s classis {@link Lector} class\u012B {@link Adverbium}.
   * @see Categoria#ADVERBIUM
   * @see TenorMultiplicibus.TenorAdverbiis
   * @see NuntiusLectoriAdverbiis
   */
  @Singleton
  @DependsOn({ "TenorAdverbiis", "NuntiusLectoriAdverbiis" })
  public static final class LectorAdverbiis extends LectorMultiplicibus <Adverbium> {
    @Nullable private static LectorAdverbiis instantia = null;

    /**
     * Valor hic viam re\u012B classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull public static final Supplier <LectorAdverbiis> faciendum =
      () -> ObjectUtils.firstNonNull(instantia, instantia = new LectorAdverbiis());

    private LectorAdverbiis() {
      super(Categoria.ADVERBIUM, NuntiusLectoriAdverbiis.faciendum,
            TenorMultiplicibus.TenorAdverbiis.faciendum, InventorAdverbiis.faciendum);
      nuntius.plurimumGarrio("Factus sum");
    }

    /**
     * Classis {@link NuntiusLectoriAdverbiis} est v\u0101s classis {@link Nuntius} class\u012B {@link LectorMultiplicibus.LectorAdverbiis}
     * @see LectorMultiplicibus.LectorAdverbiis
     */
    @Singleton
    private static final class NuntiusLectoriAdverbiis extends Nuntius {
      @Nullable private static NuntiusLectoriAdverbiis instantia = null;

      /**
       * Valor hic viam re\u012Bclassis huiuc facit.
       * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
       */
      @NonNull private static final Supplier <NuntiusLectoriAdverbiis> faciendum =
              () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusLectoriAdverbiis());

      private NuntiusLectoriAdverbiis() {
        super(ParametriNuntii.para(LectorMultiplicibus.LectorAdverbiis.class));
      }
    }
  }

  /**
   * Classis {@link LectorNominibus} est v\u0101s classis {@link Lector} class\u012B {@link Nomen}.
   * @see Categoria#NOMEN
   * @see TenorMultiplicibus.TenorNominibus
   * @see NuntiusLectoriNominibus
   * @see InventorNominibus
   */
  @Singleton
  @DependsOn({ "TenorNominibus", "NuntiusLectoriNominibus" })
  public static final class LectorNominibus extends LectorMultiplicibus <Nomen> {
    @Nullable private static LectorNominibus instantia = null;

    /**
     * Valor hic viam rei classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull public static final Supplier <LectorNominibus> faciendum =
      () -> ObjectUtils.firstNonNull(instantia, instantia = new LectorNominibus());

    private LectorNominibus() {
      super(Categoria.NOMEN, NuntiusLectoriNominibus.faciendum,
            TenorMultiplicibus.TenorNominibus.faciendum, InventorNominibus.faciendum);
      nuntius.plurimumGarrio("Factus sum");
    }

    /**
     * Classis {@link NuntiusLectoriNominibus} est v\u0101s classis {@link Nuntius} class\u012B {@link
     * LectorMultiplicibus.LectorNominibus}
     * @see LectorMultiplicibus.LectorNominibus
     */
    @Singleton
    private static final class NuntiusLectoriNominibus extends Nuntius {
      @Nullable private static NuntiusLectoriNominibus instantia = null;

      /**
       * Valor hic viam re\u012B classis huiuc facit.
       * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
       */
      @NonNull private static final Supplier <NuntiusLectoriNominibus> faciendum =
              () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusLectoriNominibus());

      private NuntiusLectoriNominibus() {
        super(ParametriNuntii.para(LectorMultiplicibus.LectorNominibus.class));
      }
    }
  }

  /**
   * Classis {@link LectorAdiectivis} est v\u0101s classis {@link Lector} class\u012B {@link Adiectivum}.
   * @see Categoria#ADIECTIVUM
   * @see TenorMultiplicibus.TenorAdiectivis
   * @see NuntiusLectoriAdiectivis
   * @see InventorAdiectivis
   */
  @Singleton
  @DependsOn({ "TenorAdiectivis", "NuntiusLectoriAdiectivis" })
  public static final class LectorAdiectivis extends LectorMultiplicibus <Adiectivum> {
    @Nullable private static LectorAdiectivis instantia = null;

    /**
     * Valor hic viam re\u012B classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull public static final Supplier <LectorAdiectivis> faciendum =
      () -> ObjectUtils.firstNonNull(instantia, instantia = new LectorAdiectivis());

    private LectorAdiectivis() {
      super(Categoria.ADIECTIVUM, NuntiusLectoriAdiectivis.faciendum,
            TenorMultiplicibus.TenorAdiectivis.faciendum, InventorAdiectivis.faciendum);
      nuntius.plurimumGarrio("Factus sum");
    }

    /**
     * Modus hic c\u014Dn\u0101bitur adven\u012Bre rem classis {@link Adiectivum} quam adiect\u012Bvum possess\u012Bvum repraesentat val\u014Dr\u0113sque
     * {@code illa} quadrat.
     * @param numeralis d\u0113signat adiect\u012Bvum possess\u012Bvum s\u012Bve singul\u0101re (id est aut {@code meum} aut {@code tuum}) s\u012Bve
     *                  pl\u016Br\u0101le (id est aut {@code nostrum} aut {@code vestrum}) petitur
     * @param persona   pers\u014Dnam adiect\u012Bv\u012B pet\u012Bt\u012B d\u0113signat
     * @param illa      seri\u0113s \u0113numer\u0101ti\u014Dnum licent {@link #inventor} colere \u0113vent\u012Bs l\u0113ct\u012Bs
     * @return rem classis {@link Adiectivum} quam val\u014Dr\u0113s {@code numeralis}que {@code persona}que {@code illa}que
     *   quadrat. <br> Modus hic valorem {@code null} refert s\u012B nihil valor\u0113s {@code numeralis}que {@code persona}que
     *   {@code illa}que quadrat.
     * @see <a href="{@docRoot}/../src/main/resources">auxili\u0101r\u0113s</a>/adiect\u012Bva/meum.xml
     * @see <a href="{@docRoot}/../src/main/resources">auxili\u0101r\u0113s</a>/adiect\u012Bva/tuum.xml
     * @see <a href="{@docRoot}/../src/main/resources">auxili\u0101r\u0113s</a>/adiect\u012Bva/nostrum.xml
     * @see <a href="{@docRoot}/../src/main/resources">auxili\u0101r\u0113s</a>/adiect\u012Bva/vestrum.xml
     * @see Numeralis
     * @see Persona
     * @see #adveniam(String, Enum[])
     */
    @SuppressWarnings("unused")
    @Nullable public Adiectivum adveniam(final Numeralis numeralis, final Persona persona, final Enum <?>... illa) {
      try {
        return adveniam(switch (persona) {
          case PRIMA -> switch (numeralis) {
            case SINGULARIS -> "meum";
            case PLURALIS -> "nostrum";
            case NULLUS -> throw new IllegalArgumentException(String.format("\u016Asus pr\u0101vu'st %s %s",
                                                                            Numeralis.pittacium,
                                                                            numeralis));
          };
          case SECUNDA -> switch (numeralis) {
            case SINGULARIS -> "tuum";
            case PLURALIS -> "vestrum";
            case NULLUS -> throw new IllegalArgumentException(String.format("\u016Asus pr\u0101vu'st %s %s",
                                                                            Numeralis.pittacium, numeralis));
          };
          case TERTIA -> "suum";
          case NULLA -> throw new IllegalArgumentException(String.format("\u016Asus pr\u0101vu'st %se %s",
                                                                         Persona.pittacium, persona));
        }, illa);
      } catch (IllegalArgumentException e) {
        nuntius.terreo(e);
        nuntius.moneo("N\u012Bl adveni");
        return null;
      }
    }

    /**
     * Classis {@link NuntiusLectoriAdiectivis} est v\u0101s classis {@link Nuntius} class\u012B {@link
     * LectorMultiplicibus.LectorAdiectivis}
     * @see LectorMultiplicibus.LectorAdiectivis
     */
    @Singleton
    private static final class NuntiusLectoriAdiectivis extends Nuntius {
      @Nullable private static NuntiusLectoriAdiectivis instantia = null;

      /**
       * Valor hic viam re\u012B classis huiuc facit.
       * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
       */
      @NonNull private static final Supplier <NuntiusLectoriAdiectivis> faciendum =
              () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusLectoriAdiectivis());

      private NuntiusLectoriAdiectivis() {
        super(ParametriNuntii.para(LectorMultiplicibus.LectorAdiectivis.class));
      }
    }
  }

  /**
   * Classis {@link LectorPronominibus} est vas classis {@link Lector} class\u012B {@link Pronomen}.
   * @see Categoria#PRONOMEN
   * @see TenorMultiplicibus.TenorPronominibus
   * @see NuntiusLectoriPronominibus
   * @see InventorPronominibus
   */
  @Singleton
  @DependsOn({ "TenorPronominibus", "NuntiusLectoriPronominibus" })
  public static final class LectorPronominibus extends LectorMultiplicibus <Pronomen> {
    private static @Nullable LectorPronominibus instantia = null;

    /**
     * Valor hic viam rei classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    public static final @NonNull Supplier <LectorPronominibus> faciendum =
      () -> ObjectUtils.firstNonNull(instantia, instantia = new LectorPronominibus());

    private LectorPronominibus() {
      super(Categoria.PRONOMEN, NuntiusLectoriPronominibus.faciendum,
            TenorMultiplicibus.TenorPronominibus.faciendum, InventorPronominibus.faciendum);
      nuntius.plurimumGarrio("Factus sum");
    }

    /**
     * Modus hic c\u014Dn\u0101bitur adven\u012Bre rem classis {@link Pronomen} quam pr\u014Dn\u014Dmen possess\u012Bvum repraesentat val\u014Dr\u0113sque
     * {@code illa} quadrat.
     * @param persona pers\u014Dnam pr\u014Dnimis pet\u012Bt\u012B d\u0113signat
     * @param illa    seri\u0113s \u0113numer\u0101ti\u014Dnum licent {@link #inventor} colere \u0113vent\u012Bs l\u0113ct\u012Bs
     * @return rem classis {@link Pronomen} quam val\u014Dr\u0113s {@code persona}que {@code illa}que quadrat. <br> Modus hic
     *   valorem {@code null} refert s\u012B nihil val\u014Dr\u0113s {@code persona}que {@code illa}que quadrat.
     * @see <a href="{@docRoot}/../src/main/resources">auxili\u0101r\u0113s</a>/pr\u014Dn\u014Dmina/ego.xml
     * @see <a href="{@docRoot}/../src/main/resources">auxili\u0101r\u0113s</a>/pr\u014Dn\u014Dmina/t\u016B.xml
     * @see <a href="{@docRoot}/../src/main/resources">auxili\u0101r\u0113s</a>/pr\u014Dn\u014Dmina/id.xml
     * @see Persona
     */
    @SuppressWarnings("unused")
    public @Nullable Pronomen adveniam(final Persona persona, final Enum <?>... illa) {
      try {
        return adveniam(switch (persona) {
          case PRIMA -> "ego";
          case SECUNDA -> "t\u016B";
          case TERTIA -> "id";
          case NULLA -> throw new IllegalArgumentException(String.format("\u016Asus pr\u0101vu'st %se %s",
                                                                         Persona.pittacium, persona));
        }, illa);
      } catch (IllegalArgumentException e) {
        nuntius.terreo(e);
        nuntius.moneo("N\u012Bl adven\u012B");
        return null;
      }
    }

    /**
     * Classis {@link NuntiusLectoriPronominibus} est v\u0101s classis {@link Nuntius} class\u012B {@link
     * LectorMultiplicibus.LectorPronominibus}
     * @see LectorMultiplicibus.LectorPronominibus
     */
    @Singleton
    private static final class NuntiusLectoriPronominibus extends Nuntius {
      @Nullable private static NuntiusLectoriPronominibus instantia = null;

      /**
       * Valor hic viam re\u012B classis huiuc facit.
       * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
       */
      @NonNull private static final Supplier <NuntiusLectoriPronominibus> faciendum =
              () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusLectoriPronominibus());

      private NuntiusLectoriPronominibus() {
        super(ParametriNuntii.para(LectorMultiplicibus.LectorPronominibus.class));
      }
    }
  }

  /**
   * Classis {@link LectorActis} est v\u0101s classis {@link Lector} class\u012B {@link Actus}.
   * @see Categoria#ACTUS
   * @see TenorMultiplicibus.TenorActis
   * @see NuntiusLectoriActis
   * @see InventorActis
   */
  @Singleton
  @DependsOn({ "TenorActis", "NuntiusLectoriActis" })
  public static final class LectorActis extends LectorMultiplicibus <Actus> {
    private static @Nullable LectorActis instantia = null;

    /**
     * Valor hic viam rei classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    public static final @NonNull Supplier <LectorActis> faciendum =
      () -> ObjectUtils.firstNonNull(instantia, instantia = new LectorActis());

    private LectorActis() {
      super(Categoria.ACTUS, NuntiusLectoriActis.faciendum,
            TenorMultiplicibus.TenorActis.faciendum, InventorActis.faciendum);
      nuntius.plurimumGarrio("Factus sum");
    }

    /**
     * Modus hic c\u014Dn\u0101bitur adven\u012Bre rem classis {@link Actus} quam f\u014Drma \u0101ct\u012B "esse" repraesentat val\u014Dr\u0113s {@code
     * illa} quadrat.
     * @param illa seri\u0113s \u0113numer\u0101ti\u014Dnum licent {@link #inventor} colere \u0113vent\u012Bs l\u0113ct\u012Bs. <br>
     *            Modus hic val\u014Drem {@code null} refert s\u012B nihil val\u014Dr\u0113s {@code illa} quadrat.
     * @return rem classis {@link Actus} quam val\u014Drem {@code illa} quadrat
     * @see <a href="{@docRoot}/../src/main/resources">auxili\u0101r\u0113s</a>/\u0101cta/esse.xml
     */
    @SuppressWarnings("unused")
    public @Nullable Actus adveniam(@NonNull final Enum <?>... illa) {
      return adveniam("esse", illa);
    }
  }

  /**
   * Classis {@link NuntiusLectoriActis} est v\u0101s classis {@link Nuntius} class\u012B {@link LectorMultiplicibus.LectorActis}
   * @see LectorMultiplicibus.LectorActis
   */
  @Singleton
  private static final class NuntiusLectoriActis extends Nuntius {
    @Nullable private static NuntiusLectoriActis instantia = null;

    /**
     * Valor hic viam re\u012B classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull private static final Supplier <NuntiusLectoriActis> faciendum =
            () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusLectoriActis());

    private NuntiusLectoriActis() {
      super(ParametriNuntii.para(LectorMultiplicibus.LectorActis.class));
    }
  }
}
