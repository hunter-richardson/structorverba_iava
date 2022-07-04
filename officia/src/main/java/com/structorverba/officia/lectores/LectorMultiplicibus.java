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
 * Classis {@link LectorMultiplicibus} est vās classis {@link Lector} classibus omnibus quibus classem {@link
 * VerbumMultiplex} extendit.
 * @param <Hoc> classis extenta classis {@link VerbumMultiplex}
 * @see Inventor
 * @see TenorMultiplicibus
 */
@SuppressWarnings("SpellCheckingInspection")
public abstract class LectorMultiplicibus <Hoc extends VerbumMultiplex <Hoc>> extends Lector <Hoc> {
  @NonNull private final Inventor <Hoc> inventor;

  /**
   * Hoc officium cōnstrūctōrem reī huius classis perpetrat.
   * @param categoria Valōrem {@link Lector#categoria} indicat.
   * @param nuntius   Valōrem {@link Lector#nuntius} supplet.
   * @param tenor     Valōrem {@link Lector#tenor} supplet.
   * @param inventor  Hic valor colit ēventīs multīs possibilibus quibus {@link Lector#tenor} referat.
   */
  protected LectorMultiplicibus(@NonNull final Categoria categoria,
                                @NonNull final Supplier <? extends Nuntius> nuntius,
                                @NonNull final Supplier <? extends TenorMultiplicibus <Hoc>> tenor,
                                @NonNull final Supplier <? extends Inventor <Hoc>> inventor) {
    super(categoria, nuntius, tenor);
    this.inventor = inventor.get();
  }

  /**
   * Hic modus ūtitur modus {@link Lector#legam(String)} ut rem classis {@link Hoc} ā valōre {@link Lector#tenor}
   * adveniat.
   * @param lemma lemma verbō quod haec rēs cōnābitur advenīre
   * @param illa     seriēs ēnumerātiōnum quam licet {@link #inventor} cōlere ēventīs lēctīs
   * @return Rem classis {@link Hoc} quam valōrem {@code verbum} quadrat. <br>
   * Hic modus valōrem {@code null} refert sī nīl quadrat valōrem {@code verbum}.
   */
  @Nullable public final Hoc adveniam(@NonNull final String lemma, @NonNull final Enum <?>... illa) {
    legam(lemma);
    final Hoc hoc = ((TenorMultiplicibus<Hoc>) tenor).referam(inventor.allego(illa).inquiram());
    inventor.restituo();
    if (hoc == null) {
      nuntius.moneo("Nīl advenī");
    } else {
      nuntius.garrio("Advenī hoc:", hoc);
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
      nuntius.moneo("Nīl advenī");
    } else {
      nuntius.garrio("Advenī hoc:", hoc);
    }
    return hoc;
  }

  /**
   * Classis {@link LectorAdverbiis} est vās classis {@link Lector} classī {@link Adverbium}.
   * @see Categoria#ADVERBIUM
   * @see TenorMultiplicibus.TenorAdverbiis
   * @see NuntiusLectoriAdverbiis
   */
  @Singleton
  @DependsOn({ "TenorAdverbiis", "NuntiusLectoriAdverbiis" })
  public static final class LectorAdverbiis extends LectorMultiplicibus <Adverbium> {
    @Nullable private static LectorAdverbiis instantia = null;

    /**
     * Hic valor viam reī huius classis facit.
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
     * Classis {@link NuntiusLectoriAdverbiis} est vās classis {@link Nuntius} classī {@link LectorMultiplicibus.LectorAdverbiis}
     * @see LectorMultiplicibus.LectorAdverbiis
     */
    @Singleton
    private static final class NuntiusLectoriAdverbiis extends Nuntius {
      @Nullable private static NuntiusLectoriAdverbiis instantia = null;

      /**
       * Hic valor viam reīhuius classis facit.
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
   * Classis {@link LectorNominibus} est vās classis {@link Lector} classī {@link Nomen}.
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
     * Hic valor viam rei huius classis facit.
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
     * Classis {@link NuntiusLectoriNominibus} est vās classis {@link Nuntius} classī {@link
     * LectorMultiplicibus.LectorNominibus}
     * @see LectorMultiplicibus.LectorNominibus
     */
    @Singleton
    private static final class NuntiusLectoriNominibus extends Nuntius {
      @Nullable private static NuntiusLectoriNominibus instantia = null;

      /**
       * Hic valor viam reī huius classis facit.
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
   * Classis {@link LectorAdiectivis} est vās classis {@link Lector} classī {@link Adiectivum}.
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
     * Hic valor viam reī huius classis facit.
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
     * Hic modus cōnābitur advenīre rem classis {@link Adiectivum} quam adiectīvum possessīvum repraesentat valōrēsque
     * {@code illa} quadrat.
     * @param numeralis dēsignat adiectīvum possessīvum sīve singulāre (id est aut {@code meum} aut {@code tuum}) sīve
     *                  plūrāle (id est aut {@code nostrum} aut {@code vestrum}) petitur
     * @param persona   persōnam adiectīvī petītī dēsignat
     * @param illa      seriēs ēnumerātiōnum licent {@link #inventor} colere ēventīs lēctīs
     * @return rem classis {@link Adiectivum} quam valōrēs {@code numeralis}que {@code persona}que {@code illa}que
     *   quadrat. <br> Hic modus valorem {@code null} refert sī nihil valorēs {@code numeralis}que {@code persona}que
     *   {@code illa}que quadrat.
     * @see <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>/adiectīva/meum.xml
     * @see <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>/adiectīva/tuum.xml
     * @see <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>/adiectīva/nostrum.xml
     * @see <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>/adiectīva/vestrum.xml
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
            case NULLUS -> throw new IllegalArgumentException(String.format("\u016Asus prāvu'st %s %s",
                                                                            Numeralis.pittacium,
                                                                            numeralis));
          };
          case SECUNDA -> switch (numeralis) {
            case SINGULARIS -> "tuum";
            case PLURALIS -> "vestrum";
            case NULLUS -> throw new IllegalArgumentException(String.format("\u016Asus prāvu'st %s %s",
                                                                            Numeralis.pittacium, numeralis));
          };
          case TERTIA -> "suum";
          case NULLA -> throw new IllegalArgumentException(String.format("\u016Asus prāvu'st %se %s",
                                                                         Persona.pittacium, persona));
        }, illa);
      } catch (IllegalArgumentException e) {
        nuntius.terreo(e);
        nuntius.moneo("Nīl adveni");
        return null;
      }
    }

    /**
     * Classis {@link NuntiusLectoriAdiectivis} est vās classis {@link Nuntius} classī {@link
     * LectorMultiplicibus.LectorAdiectivis}
     * @see LectorMultiplicibus.LectorAdiectivis
     */
    @Singleton
    private static final class NuntiusLectoriAdiectivis extends Nuntius {
      @Nullable private static NuntiusLectoriAdiectivis instantia = null;

      /**
       * Hic valor viam reī huius classis facit.
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
   * Classis {@link LectorPronominibus} est vas classis {@link Lector} classī {@link Pronomen}.
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
     * Hic valor viam rei huius classis facit.
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
     * Hic modus cōnābitur advenīre rem classis {@link Pronomen} quam prōnōmen possessīvum repraesentat valōrēsque
     * {@code illa} quadrat.
     * @param persona persōnam prōnimis petītī dēsignat
     * @param illa    seriēs ēnumerātiōnum licent {@link #inventor} colere ēventīs lēctīs
     * @return rem classis {@link Pronomen} quam valōrēs {@code persona}que {@code illa}que quadrat. <br> Hic modus
     *   valorem {@code null} refert sī nihil valōrēs {@code persona}que {@code illa}que quadrat.
     * @see <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>/prōnōmina/ego.xml
     * @see <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>/prōnōmina/tū.xml
     * @see <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>/prōnōmina/id.xml
     * @see Persona
     */
    @SuppressWarnings("unused")
    public @Nullable Pronomen adveniam(final Persona persona, final Enum <?>... illa) {
      try {
        return adveniam(switch (persona) {
          case PRIMA -> "ego";
          case SECUNDA -> "tū";
          case TERTIA -> "id";
          case NULLA -> throw new IllegalArgumentException(String.format("\u016Asus prāvu'st %se %s",
                                                                         Persona.pittacium, persona));
        }, illa);
      } catch (IllegalArgumentException e) {
        nuntius.terreo(e);
        nuntius.moneo("Nīl advenī");
        return null;
      }
    }

    /**
     * Classis {@link NuntiusLectoriPronominibus} est vās classis {@link Nuntius} classī {@link
     * LectorMultiplicibus.LectorPronominibus}
     * @see LectorMultiplicibus.LectorPronominibus
     */
    @Singleton
    private static final class NuntiusLectoriPronominibus extends Nuntius {
      @Nullable private static NuntiusLectoriPronominibus instantia = null;

      /**
       * Hic valor viam reī huius classis facit.
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
   * Classis {@link LectorActis} est vās classis {@link Lector} classī {@link Actus}.
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
     * Hic valor viam rei huius classis facit.
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
     * Hic modus cōnābitur advenīre rem classis {@link Actus} quam fōrma āctī "esse" repraesentat valōrēs {@code
     * illa} quadrat.
     * @param illa seriēs ēnumerātiōnum licent {@link #inventor} colere ēventīs lēctīs. <br>
     *            Hic modus valōrem {@code null} refert sī nihil valōrēs {@code illa} quadrat.
     * @return rem classis {@link Actus} quam valōrem {@code illa} quadrat
     * @see <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>/ācta/esse.xml
     */
    @SuppressWarnings("unused")
    public @Nullable Actus adveniam(@NonNull final Enum <?>... illa) {
      return adveniam("esse", illa);
    }
  }

  /**
   * Classis {@link NuntiusLectoriActis} est vās classis {@link Nuntius} classī {@link LectorMultiplicibus.LectorActis}
   * @see LectorMultiplicibus.LectorActis
   */
  @Singleton
  private static final class NuntiusLectoriActis extends Nuntius {
    @Nullable private static NuntiusLectoriActis instantia = null;

    /**
     * Hic valor viam reī huius classis facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull private static final Supplier <NuntiusLectoriActis> faciendum =
            () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusLectoriActis());

    private NuntiusLectoriActis() {
      super(ParametriNuntii.para(LectorMultiplicibus.LectorActis.class));
    }
  }
}
