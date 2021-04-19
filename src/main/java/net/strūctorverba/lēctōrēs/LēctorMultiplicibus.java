package net.strūctorverba.lēctōrēs;

import net.strūctorverba.nūntiī.Nūntius;
import net.strūctorverba.inventōrēs.*;
import net.strūctorverba.tenōrēs.TenorMultiplicibus;
import net.strūctorverba.verba.multiplicia.*;
import net.strūctorverba.ēnumerātiōnēs.*;
import org.apache.commons.lang3.ObjectUtils;
import org.jetbrains.annotations.*;

import javax.ejb.*;
import java.util.function.Supplier;

/**
 * Classis {@link LēctorSimplicibus} est vās classis {@link Lēctor} classibus omnibus quibus classem {@link VerbumMultiplex} extendit.
 * @param <Hoc> classis extenta classis {@link VerbumMultiplex}
 * @see Inventor
 * @see TenorMultiplicibus
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection" })
public abstract class LēctorMultiplicibus <Hoc extends VerbumMultiplex <Hoc>> extends Lēctor <Hoc> {
  private final @NotNull Inventor <Hoc> inventor;

  /**
   * Officium hoc cōnstrūctōrem reī classis huius perpetrat.
   * @param catēgoria valōrem {@link Lēctor#catēgoria} indicat.
   * @param nūntius valōrem {@link Lēctor#nūntius} supplet.
   * @param tenor valōrem {@link Lēctor#tenor} supplet.
   * @param inventor valor hic colit ēventīs multīs possibilibus quibus {@link Lēctor#tenor} referat.
   */
  protected LēctorMultiplicibus(@NotNull final Catēgoria catēgoria,
                                @NotNull final Supplier <? extends Nūntius> nūntius,
                                @NotNull final Supplier <@NotNull ? extends TenorMultiplicibus <Hoc>> tenor,
                                @NotNull final Supplier <@NotNull ? extends Inventor <Hoc>> inventor) {
    super(catēgoria, nūntius, tenor);
    this.inventor = inventor.get();
  }

  /**
   * Modus hic ūtitur modus {@link Lēctor#legam(String)} rem classis {@link Hoc} ā valōre {@link Lēctor#tenor} advenīre.
   * @param fundāmen fundāmen verbō quod rēs haec cōnābitur advenīre
   * @param illa seriēs ēnumerātiōnum quam licet {@link #inventor} cōlere ēventīs lēctīs
   * @return rem classis {@link Hoc} quam valōrem {@code verbum} quadrat
   */
  public final @Nullable Hoc adveniam(@NotNull final String fundāmen, @NotNull final Enum <@NotNull ?>... illa) {
    legam(fundāmen);
    Hoc hoc = tenor.referō(inventor.allegō(illa).inquīram());
    inventor.restituō();
    if(hoc == null) {
      nūntius.moneō("Nihil advenī");
      return null;
    } else {
      nūntius.garriō("Advenī hoc:", hoc);
      return hoc;
    }
  }

  /**
   * Classis {@link LēctorNōminibus} est vās classis {@link Lēctor} classī {@link Nōmen}.
   * @see Catēgoria#NŌMEN
   * @see TenorMultiplicibus.TenorNōminibus
   * @see Nūntius.NūntiusLēctōrīNōminibus
   * @see InventorNōminibus
   */
  @Singleton @DependsOn({ "TenorNōminibus", "NūntiusLēctōrīNōminibus" })
  public static final class LēctorNōminibus extends LēctorMultiplicibus <Nōmen> {
    private static @Nullable LēctorNōminibus īnstantia = null;

    /**
     * Valor hic viam reī classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    public static final @NotNull Supplier <LēctorNōminibus> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new LēctorNōminibus());

    private LēctorNōminibus( ) {
      super(Catēgoria.NŌMEN, Nūntius.NūntiusLēctōrīNōminibus.fac,
            TenorMultiplicibus.TenorNōminibus.fac, InventorNōminibus.fac);
    }
  }

  /**
   * Classis {@link LēctorAdiectīvīs} est vās classis {@link Lēctor} classī {@link Adiectīvum}.
   * @see Catēgoria#ADIECTĪVUM
   * @see TenorMultiplicibus.TenorAdiectīvīs
   * @see Nūntius.NūntiusLēctōrīAdiectīvīs
   * @see InventorAdiectīvīs
   */
  @Singleton @DependsOn({ "TenorAdiectīvīs", "NūntiusLēctōrīAdiectīvīs" })
  public static final class LēctorAdiectīvīs extends LēctorMultiplicibus <Adiectīvum> {
    private static @Nullable LēctorAdiectīvīs īnstantia = null;

    /**
     * Valor hic viam reī classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    public static final @NotNull Supplier <LēctorAdiectīvīs> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new LēctorAdiectīvīs());

    private LēctorAdiectīvīs( ) {
      super(Catēgoria.ADIECTĪVUM, Nūntius.NūntiusLēctōrīAdiectīvīs.fac,
            TenorMultiplicibus.TenorAdiectīvīs.fac, InventorAdiectīvīs.fac);
    }

    /**
     * Modus hic cōnābitur advenīre rem classis {@link Adiectīvum} quam adiectīvum possessīvum repraesentat et valōrēs {@code illa} quadrat.
     * @param numerālis dēsignat adiectīvum possessīvum sīve singulāre (id est aut "meus" aut "tuus") sīve plūrāle (id est aut "noster" aut "vester") petitur
     * @param persōna persōnam adiectīvī petītī dēsignat
     * @param illa seriēs ēnumerātiōnum licent {@link #inventor} colere ēventīs lēctīs
     * @see <a href="../src/main/resources/adiectīvum/meus.xml">meus.xml</a>
     * @see <a href="../src/main/resources/adiectīvum/tuus.xml">tuus.xml</a>
     * @see <a href="../src/main/resources/adiectīvum/noster.xml">noster.xml</a>
     * @see <a href="../src/main/resources/adiectīvum/vester.xml">vester.xml</a>
     * @see Numerālis
     * @see Persōna
     */
    @SuppressWarnings("unused")
    public @Nullable Adiectīvum adveniam(final Numerālis numerālis, final Persōna persōna, final Enum<?>... illa) {
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
  @Singleton @DependsOn({ "TenorPrōnōminibus", "NūntiusLēctōrīPrōnōminibus" })
  public static final class LēctorPrōnōminibus extends LēctorMultiplicibus <Prōnōmen> {
    private static @Nullable LēctorPrōnōminibus īnstantia = null;

    /**
     * Valor hic viam reī classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    public static final @NotNull Supplier <LēctorPrōnōminibus> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new LēctorPrōnōminibus());

    private LēctorPrōnōminibus( ) {
      super(Catēgoria.PRŌNŌMEN, Nūntius.NūntiusLēctōrīPrōnōminibus.fac,
            TenorMultiplicibus.TenorPrōnōminibus.fac, InventorPrōnōminibus.fac);
    }

    /**
     * Modus hic cōnābitur advenīre rem classis {@link Prōnōmen} quam prōnōmen possessīvum repraesentat et valōrēs {@code illa} quadrat.
     * @param persōna persōnam prōnimis petītī dēsignat
     * @param illa seriēs ēnumerātiōnum licent {@link #inventor} colere ēventīs lēctīs
     * @see <a href="../src/main/resources/prōnōmina/ego.xml">ego.xml</a>
     * @see <a href="../src/main/resources/prōnōmina/tū.xml">tū.xml</a>
     * @see <a href="../src/main/resources/prōnōmina/is.xml">is.xml</a>
     * @see Persōna
     */
    @SuppressWarnings("unused")
    public @Nullable Prōnōmen adveniam(final Persōna persōna, final Enum<?>... illa) {
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
        return null;
      }
    }
  }


  /**
   * Classis {@link LēctorPrōnōminibusConiūnctīvīs} est vās classis {@link Lēctor} classī {@link PrōnōmenConiūnctīvum}.
   * @see Catēgoria#PRŌNŌMEN_CONIŪNCTĪVUM
   * @see TenorMultiplicibus.TenorPrōnōminibusConiūnctīvīs
   * @see Nūntius.NūntiusLēctōrīPrōnōminibusConiūnctīvīs
   * @see InventorPrōnōminibusConiūnctīvīs
   */
  @Singleton @DependsOn({ "TenorPrōnōmibusConiūnctīvīs", "NūntiusLēctōrīPrōnōminibusConiūnctīvīs" })
  public static final class LēctorPrōnōminibusConiūnctīvīs extends LēctorMultiplicibus <PrōnōmenConiūnctīvum> {
    private static @Nullable LēctorPrōnōminibusConiūnctīvīs īnstantia = null;

    /**
     * Valor hic viam reī classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    public static final @NotNull Supplier <LēctorPrōnōminibusConiūnctīvīs> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new LēctorPrōnōminibusConiūnctīvīs());

    private LēctorPrōnōminibusConiūnctīvīs( ) {
      super(Catēgoria.PRŌNŌMEN_CONIŪNCTĪVUM, Nūntius.NūntiusLēctōrīPrōnōminibusConiūnctīvīs.fac,
            TenorMultiplicibus.TenorPrōnōminibusConiūnctīvīs.fac, InventorPrōnōminibusConiūnctīvīs.fac);
    }
  }


  /**
   * Classis {@link LēctorĀctīs} est vās classis {@link Lēctor} classī {@link Āctum}.
   * @see Catēgoria#ĀCTUM
   * @see TenorMultiplicibus.TenorĀctīs
   * @see Nūntius.NūntiusLēctōrīĀctīs
   * @see InventorĀctīs
   */
  @Singleton @DependsOn({ "TenorĀctīs", "NūntiusLēctōrīĀctīs" })
  public static final class LēctorĀctīs extends LēctorMultiplicibus <Āctum> {
    private static @Nullable LēctorĀctīs īnstantia = null;

    /**
     * Valor hic viam reī classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    public static final @NotNull Supplier <LēctorĀctīs> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new LēctorĀctīs());

    private LēctorĀctīs( ) {
      super(Catēgoria.ĀCTUM, Nūntius.NūntiusLēctōrīĀctīs.fac,
            TenorMultiplicibus.TenorĀctīs.fac, InventorĀctīs.fac);
    }

    /**
     * Modus hic cōnābitur advenīre rem classis {@link Āctum} quam fōrma āctī "esse" repraesentat et valōrēs {@code illa} quadrat.
     * @param illa seriēs ēnumerātiōnum licent {@link #inventor} colere ēventīs lēctīs
     * @see <a href="../src/main/resources/ācta/esse.xml">esse.xml</a>
     */
    public @Nullable Āctum adveniam(@NotNull final Enum<?>... illa) {
      return adveniam("esse", illa);
    }
  }
}
