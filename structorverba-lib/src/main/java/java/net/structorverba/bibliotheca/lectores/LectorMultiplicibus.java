package net.strūctorverba.bibliotheca.lectores;

import net.strūctorverba.bibliotheca.inventores.*;
import net.strūctorverba.bibliotheca.nuntii.Nūntius;
import net.strūctorverba.bibliotheca.tenores.TenorMultiplicibus;
import net.strūctorverba.bibliotheca.verba.multiplicia.*;
import net.strūctorverba.bibliotheca.enumerationes.*;

import org.apache.commons.lang3.ObjectUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

import javax.ejb.DependsOn;
import javax.ejb.Singleton;

/**
 * Classis {@link LēctorMultiplicibus} est vās classis {@link Lēctor} classibus omnibus quibus classem {@link
 * VerbumMultiplex} extendit.
 * @param <Hoc> classis extenta classis {@link VerbumMultiplex}
 * @see Inventor
 * @see TenorMultiplicibus
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection" })
public abstract class LēctorMultiplicibus <Hoc extends VerbumMultiplex <Hoc>> extends Lēctor <Hoc> {
  @NotNull private final Inventor <Hoc> inventor;

  /**
   * Officium hoc cōnstrūctōrem reī classis huius perpetrat.
   * @param catēgoria valōrem {@link Lēctor#catēgoria} indicat.
   * @param nūntius   valōrem {@link Lēctor#nūntius} supplet.
   * @param tenor     valōrem {@link Lēctor#tenor} supplet.
   * @param inventor  valor hic colit ēventīs multīs possibilibus quibus {@link Lēctor#tenor} referat.
   */
  protected LēctorMultiplicibus(@NotNull final Catēgoria catēgoria,
                                @NotNull final Supplier <@NotNull ? extends Nūntius> nūntius,
                                @NotNull final Supplier <@NotNull ? extends TenorMultiplicibus <Hoc>> tenor,
                                @NotNull final Supplier <@NotNull ? extends Inventor <Hoc>> inventor) {
    super(catēgoria, nūntius, tenor);
    this.inventor = inventor.get();
  }

  /**
   * Modus hic ūtitur modus {@link Lēctor#legam(String)} ut rem classis {@link Hoc} ā valōre {@link Lēctor#tenor}
   * adveniat.
   * @param lemma lemma verbō quod rēs haec cōnābitur advenīre
   * @param illa     seriēs ēnumerātiōnum quam licet {@link #inventor} cōlere ēventīs lēctīs
   * @return Rem classis {@link Hoc} quam valōrem {@code verbum} quadrat. <br> Modus hic valōrem {@code null} refert sī
   *   nihil quadrat valōrem {@code verbum}.
   */
  @Nullable public final Hoc adveniam(@NotNull final String lemma, @NotNull final Enum <@NotNull ?>... illa) {
    legam(lemma);
    Hoc hoc = tenor.referō(inventor.allegō(illa).inquīram());
    inventor.restituō();
    if (hoc == null) {
      nūntius.moneō("Nihil advenī");
      return null;
    } else {
      nūntius.garriō("Advenī hoc:", hoc);
      return hoc;
    }
  }

  /**
   * Classis {@link LēctorAdverbiīs} est vās classis {@link Lēctor} classī {@link Adverbium}.
   * @see Catēgoria#ADVERBIUM
   * @see TenorMultiplicibus.TenorAdverbiīs
   * @see Nūntius.NūntiusLēctōrīAdverbiīs
   */
  @Singleton
  @DependsOn({ "TenorAdverbiīs", "NūntiusLēctōrīAdverbiīs" })
  public static final class LēctorAdverbiīs extends LēctorMultiplicibus <Adverbium> {
    @Nullable private static LēctorAdverbiīs īnstantia = null;

    /**
     * Valor hic viam reī classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NotNull public static final Supplier <LēctorAdverbiīs> fac =
      ( ) -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new LēctorAdverbiīs());

    private LēctorAdverbiīs( ) {
      super(Catēgoria.ADVERBIUM, Nūntius.NūntiusLēctōrīAdverbiīs.fac,
            TenorMultiplicibus.TenorAdverbiīs.fac, InventorAdverbiīs.fac);
      nūntius.plūrimumGarriō("Factus sum");
    }
  }

  /**
   * Classis {@link LēctorNōminibus} est vās classis {@link Lēctor} classī {@link Nōmen}.
   * @see Catēgoria#NŌMEN
   * @see TenorMultiplicibus.TenorNōminibus
   * @see Nūntius.NūntiusLēctōrīNōminibus
   * @see InventorNōminibus
   */
  @Singleton
  @DependsOn({ "TenorNōminibus", "NūntiusLēctōrīNōminibus" })
  public static final class LēctorNōminibus extends LēctorMultiplicibus <Nōmen> {
    @Nullable private static LēctorNōminibus īnstantia = null;

    /**
     * Valor hic viam reī classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NotNull public static final Supplier <LēctorNōminibus> fac =
      ( ) -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new LēctorNōminibus());

    private LēctorNōminibus( ) {
      super(Catēgoria.NŌMEN, Nūntius.NūntiusLēctōrīNōminibus.fac,
            TenorMultiplicibus.TenorNōminibus.fac, InventorNōminibus.fac);
      nūntius.plūrimumGarriō("Factus sum");
    }
  }

  /**
   * Classis {@link LēctorAdiectīvīs} est vās classis {@link Lēctor} classī {@link Adiectīvum}.
   * @see Catēgoria#ADIECTĪVUM
   * @see TenorMultiplicibus.TenorAdiectīvīs
   * @see Nūntius.NūntiusLēctōrīAdiectīvīs
   * @see InventorAdiectīvīs
   */
  @Singleton
  @DependsOn({ "TenorAdiectīvīs", "NūntiusLēctōrīAdiectīvīs" })
  public static final class LēctorAdiectīvīs extends LēctorMultiplicibus <Adiectīvum> {
    @Nullable private static LēctorAdiectīvīs īnstantia = null;

    /**
     * Valor hic viam reī classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NotNull public static final Supplier <LēctorAdiectīvīs> fac =
      ( ) -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new LēctorAdiectīvīs());

    private LēctorAdiectīvīs( ) {
      super(Catēgoria.ADIECTĪVUM, Nūntius.NūntiusLēctōrīAdiectīvīs.fac,
            TenorMultiplicibus.TenorAdiectīvīs.fac, InventorAdiectīvīs.fac);
      nūntius.plūrimumGarriō("Factus sum");
    }

    /**
     * Modus hic cōnābitur advenīre rem classis {@link Adiectīvum} quam adiectīvum possessīvum repraesentat valōrēsque
     * {@code illa} quadrat.
     * @param numerālis dēsignat adiectīvum possessīvum sīve singulāre (id est aut {@code meus} aut {@code tuus}) sīve
     *                  plūrāle (id est aut {@code noster} aut {@code vester}) petitur
     * @param persōna   persōnam adiectīvī petītī dēsignat
     * @param illa      seriēs ēnumerātiōnum licent {@link #inventor} colere ēventīs lēctīs
     * @return rem classis {@link Adiectīvum} quam valōrēs {@code numerālis}que {@code persōna}que {@code illa}que
     *   quadrat. <br> Modus hic valōrem {@code null} refert sī nihil valōrēs {@code numerālis}que {@code persōna}que
     *   {@code illa}que quadrat.
     * @see <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>/adiectīva/meum.xml
     * @see <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>/adiectīva/tuum.xml
     * @see <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>/adiectīva/nostrum.xml
     * @see <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>/adiectīva/vestrum.xml
     * @see Numerālis
     * @see Persōna
     * @see #adveniam(String, Enum[])
     */
    @SuppressWarnings("unused")
    @Nullable public Adiectīvum adveniam(final Numerālis numerālis, final Persōna persōna, final Enum <?>... illa) {
      try {
        return adveniam(switch (persōna) {
          case PRĪMA -> switch (numerālis) {
            case SINGULĀRIS -> "meus";
            case PLŪRĀLIS -> "noster";
            case NŪLLUS -> throw new IllegalArgumentException(String.format("Ūsus prāvus est ēnumerātiōnis %s",
                                                                            Numerālis.NŪLLUS));
          };
          case SECUNDA -> switch (numerālis) {
            case SINGULĀRIS -> "tuus";
            case PLŪRĀLIS -> "vester";
            case NŪLLUS -> throw new IllegalArgumentException(String.format("Ūsus prāvus est ēnumerātiōnis %s",
                                                                            Numerālis.NŪLLUS));
          };
          case TERTIA -> "suus";
          case NŪLLA -> throw new IllegalArgumentException(String.format("Ūsus prāvus est ēnumerātiōnis %s",
                                                                         Persōna.NŪLLA));
        }, illa);
      } catch (IllegalArgumentException e) {
        nūntius.terreō(e);
        nūntius.moneō("Nihil advenī");
        return null;
      }
    }
  }

  /**
   * Classis {@link LēctorPrōnōminibus} est vās classis {@link Lēctor} classī {@link Prōnōmen}.
   * @see Catēgoria#PRŌNŌMEN
   * @see TenorMultiplicibus.TenorPrōnōminibus
   * @see Nūntius.NūntiusLēctōrīPrōnōminibus
   * @see InventorPrōnōminibus
   */
  @Singleton
  @DependsOn({ "TenorPrōnōminibus", "NūntiusLēctōrīPrōnōminibus" })
  public static final class LēctorPrōnōminibus extends LēctorMultiplicibus <Prōnōmen> {
    private static @Nullable LēctorPrōnōminibus īnstantia = null;

    /**
     * Valor hic viam reī classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    public static final @NotNull Supplier <LēctorPrōnōminibus> fac =
      ( ) -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new LēctorPrōnōminibus());

    private LēctorPrōnōminibus( ) {
      super(Catēgoria.PRŌNŌMEN, Nūntius.NūntiusLēctōrīPrōnōminibus.fac,
            TenorMultiplicibus.TenorPrōnōminibus.fac, InventorPrōnōminibus.fac);
      nūntius.plūrimumGarriō("Factus sum");
    }

    /**
     * Modus hic cōnābitur advenīre rem classis {@link Prōnōmen} quam prōnōmen possessīvum repraesentat valōrēsque
     * {@code illa} quadrat.
     * @param persōna persōnam prōnimis petītī dēsignat
     * @param illa    seriēs ēnumerātiōnum licent {@link #inventor} colere ēventīs lēctīs
     * @return rem classis {@link Prōnōmen} quam valōrēs {@code persōna}que {@code illa}que quadrat. <br> Modus hic
     *   valōrem {@code null} refert sī nihil valōrēs {@code persōna}que {@code illa}que quadrat.
     * @see <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>/prōnōmina/ego.xml
     * @see <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>/prōnōmina/tū.xml
     * @see <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>/prōnōmina/id.xml
     * @see Persōna
     */
    @SuppressWarnings("unused")
    public @Nullable Prōnōmen adveniam(final Persōna persōna, final Enum <?>... illa) {
      try {
        return adveniam(switch (persōna) {
          case PRĪMA -> "ego";
          case SECUNDA -> "tū";
          case TERTIA -> "is";
          case NŪLLA -> throw new IllegalArgumentException(String.format("Ūsus prāvus est ēnumerātiōnis %s",
                                                                         Numerālis.NŪLLUS));
        }, illa);
      } catch (IllegalArgumentException e) {
        nūntius.terreō(e);
        nūntius.moneō("Niihil advenī");
        return null;
      }
    }
  }

  /**
   * Classis {@link LēctorĀctīs} est vās classis {@link Lēctor} classī {@link Āctus}.
   * @see Catēgoria#ĀCTUS
   * @see TenorMultiplicibus.TenorĀctīs
   * @see Nūntius.NūntiusLēctōrīĀctīs
   * @see InventorĀctīs
   */
  @Singleton
  @DependsOn({ "TenorĀctīs", "NūntiusLēctōrīĀctīs" })
  public static final class LēctorĀctīs extends LēctorMultiplicibus <Āctus> {
    private static @Nullable LēctorĀctīs īnstantia = null;

    /**
     * Valor hic viam reī classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    public static final @NotNull Supplier <LēctorĀctīs> fac =
      ( ) -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new LēctorĀctīs());

    private LēctorĀctīs( ) {
      super(Catēgoria.ĀCTUS, Nūntius.NūntiusLēctōrīĀctīs.fac,
            TenorMultiplicibus.TenorĀctīs.fac, InventorĀctīs.fac);
      nūntius.plūrimumGarriō("Factus sum");
    }

    /**
     * Modus hic cōnābitur advenīre rem classis {@link Āctus} quam fōrma āctī "esse" repraesentat valōrēs {@code
     * illa} quadrat.
     * @param illa seriēs ēnumerātiōnum licent {@link #inventor} colere ēventīs lēctīs. <br> Modus hic valōrem {@code
     *             null} refert sī nihil valōrēs {@code illa} quadrat.
     * @return rem classis {@link Āctus} quam valōrem {@code illa} quadrat
     * @see <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>/ācta/esse.xml
     */
    @SuppressWarnings("unused")
    public @Nullable Āctus adveniam(@NotNull final Enum <?>... illa) {
      return adveniam("esse", illa);
    }
  }
}
