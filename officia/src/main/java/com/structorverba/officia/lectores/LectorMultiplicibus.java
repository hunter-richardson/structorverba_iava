package officia.src.main.java.com.structorverba.officia.lectores;

import officia.src.main.java.com.structorverba.officia.inventores.*;
import officia.src.main.java.com.structorverba.officia.nuntii.Nuntius;
import officia.src.main.java.com.structorverba.officia.tenores.TenorMultiplicibus;
import officia.src.main.java.com.structorverba.officia.verba.multiplicia.*;
import officia.src.main.java.com.structorverba.officia.enumerationes.*;

import org.apache.commons.lang3.ObjectUtils;
import org.jetbrains.annotations.*;

import java.util.function.Supplier;

import javax.ejb.*;

/**
 * Classis {@link LectorMultiplicibus} est v\u0101s classis {@link Lector} classibus omnibus quibus classem {@link
 * VerbumMultiplex} extendit.
 * @param <Hoc> classis extenta classis {@link VerbumMultiplex}
 * @see Inventor
 * @see TenorMultiplicibus
 */
@SuppressWarnings("SpellCheckingInspection")
public abstract class LectorMultiplicibus <Hoc extends VerbumMultiplex <Hoc>> extends Lector <Hoc> {
  @NotNull private final Inventor <Hoc> inventor;

  /**
   * Officium hoc c\u014Dnstr\u016Bct\u014Drem re\u012B classis huius perpetrat.
   * @param categoria val\u014Drem {@link Lector#categoria} indicat.
   * @param nuntius   val\u014Drem {@link Lector#nuntius} supplet.
   * @param tenor     val\u014Drem {@link Lector#tenor} supplet.
   * @param inventor  valor hic colit \u0113vent\u012Bs mult\u012Bs possibilibus quibus {@link Lector#tenor} referat.
   */
  protected LectorMultiplicibus(@NotNull final Categoria categoria,
                                @NotNull final Supplier <@NotNull ? extends Nuntius> nuntius,
                                @NotNull final Supplier <@NotNull ? extends TenorMultiplicibus <Hoc>> tenor,
                                @NotNull final Supplier <@NotNull ? extends Inventor <Hoc>> inventor) {
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
  @Nullable public final Hoc adveniam(@NotNull final String lemma, @NotNull final Enum <@NotNull ?>... illa) {
    legam(lemma);
    Hoc hoc = tenor.refero(inventor.allego(illa).inquiram());
    inventor.restituo();
    if (hoc == null) {
      nuntius.moneo("N\u012Bl adven\u012B");
      return null;
    } else {
      nuntius.garrio("Adven\u012B hoc:", hoc);
      return hoc;
    }
  }

  /**
   * Classis {@link LectorAdverbiis} est v\u0101s classis {@link Lector} class\u012B {@link Adverbium}.
   * @see Categoria#ADVERBIUM
   * @see TenorMultiplicibus.TenorAdverbiis
   * @see Nuntius.NuntiusLectoriAdverbiis
   */
  @Singleton
  @DependsOn({ "TenorAdverbiis", "NuntiusLectoriAdverbiis" })
  public static final class LectorAdverbiis extends LectorMultiplicibus <Adverbium> {
    @Nullable private static LectorAdverbiis instantia = null;

    /**
     * Valor hic viam re\u012B classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NotNull public static final Supplier <LectorAdverbiis> fac =
      ( ) -> ObjectUtils.firstNonNull(instantia, instantia = new LectorAdverbiis());

    private LectorAdverbiis() {
      super(Categoria.ADVERBIUM, Nuntius.NuntiusLectoriAdverbiis.fac,
            TenorMultiplicibus.TenorAdverbiis.fac, InventorAdverbiis.fac);
      nuntius.plurimumGarrio("Factus sum");
    }
  }

  /**
   * Classis {@link LectorNominibus} est v\u0101s classis {@link Lector} class\u012B {@link Nomen}.
   * @see Categoria#NOMEN
   * @see TenorMultiplicibus.TenorNominibus
   * @see Nuntius.NuntiusLectoriNominibus
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
    @NotNull public static final Supplier <LectorNominibus> fac =
      ( ) -> ObjectUtils.firstNonNull(instantia, instantia = new LectorNominibus());

    private LectorNominibus( ) {
      super(Categoria.NOMEN, Nuntius.NuntiusLectoriNominibus.fac,
            TenorMultiplicibus.TenorNominibus.fac, InventorNominibus.fac);
      nuntius.plurimumGarrio("Factus sum");
    }
  }

  /**
   * Classis {@link LectorAdiectivis} est v\u0101s classis {@link Lector} class\u012B {@link Adiectivum}.
   * @see Categoria#ADIECTIVUM
   * @see TenorMultiplicibus.TenorAdiectivis
   * @see Nuntius.NuntiusLectoriAdiectivis
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
    @NotNull public static final Supplier <LectorAdiectivis> fac =
      ( ) -> ObjectUtils.firstNonNull(instantia, instantia = new LectorAdiectivis());

    private LectorAdiectivis() {
      super(Categoria.ADIECTIVUM, Nuntius.NuntiusLectoriAdiectivis.fac,
            TenorMultiplicibus.TenorAdiectivis.fac, InventorAdiectivis.fac);
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
            case NULLUS -> throw new IllegalArgumentException(String.format("\u016Asus pr\u0101vus est \u0113numer\u0101ti\u014Dnis %s",
                                                                            Numeralis.NULLUS));
          };
          case SECUNDA -> switch (numeralis) {
            case SINGULARIS -> "tuum";
            case PLURALIS -> "vestrum";
            case NULLUS -> throw new IllegalArgumentException(String.format("\u016Asus pr\u0101vus est \u0113numer\u0101ti\u014Dnis %s",
                                                                            Numeralis.NULLUS));
          };
          case TERTIA -> "suum";
          case NULLA -> throw new IllegalArgumentException(String.format("\u016Asus pr\u0101vus est \u0113numer\u0101ti\u014Dnis %s",
                                                                         Persona.NULLA));
        }, illa);
      } catch (IllegalArgumentException e) {
        nuntius.terreo(e);
        nuntius.moneo("N\u012Bl adveni");
        return null;
      }
    }
  }

  /**
   * Classis {@link LectorPronominibus} est vas classis {@link Lector} class\u012B {@link Pronomen}.
   * @see Categoria#PRONOMEN
   * @see TenorMultiplicibus.TenorPronominibus
   * @see Nuntius.NuntiusLectoriPronominibus
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
    public static final @NotNull Supplier <LectorPronominibus> fac =
      ( ) -> ObjectUtils.firstNonNull(instantia, instantia = new LectorPronominibus());

    private LectorPronominibus( ) {
      super(Categoria.PRONOMEN, Nuntius.NuntiusLectoriPronominibus.fac,
            TenorMultiplicibus.TenorPronominibus.fac, InventorPronominibus.fac);
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
          case NULLA -> throw new IllegalArgumentException(String.format("\u016Asus pr\u0101vus est \u0113numer\u0101ti\u014Dnis %s",
                                                                         Numeralis.NULLUS));
        }, illa);
      } catch (IllegalArgumentException e) {
        nuntius.terreo(e);
        nuntius.moneo("N\u012Bl adven\u012B");
        return null;
      }
    }
  }

  /**
   * Classis {@link LectorActis} est v\u0101s classis {@link Lector} class\u012B {@link Actus}.
   * @see Categoria#ACTUS
   * @see TenorMultiplicibus.TenorActis
   * @see Nuntius.NuntiusLectoriActis
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
    public static final @NotNull Supplier <LectorActis> fac =
      ( ) -> ObjectUtils.firstNonNull(instantia, instantia = new LectorActis());

    private LectorActis( ) {
      super(Categoria.ACTUS, Nuntius.NuntiusLectoriActis.fac,
            TenorMultiplicibus.TenorActis.fac, InventorActis.fac);
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
    public @Nullable Actus adveniam(@NotNull final Enum <?>... illa) {
      return adveniam("esse", illa);
    }
  }
}
