package net.strūctorverba.tenōrēs;

import net.strūctorverba.conditōrēs.multiplicia.*;
import net.strūctorverba.lēctōrēs.LēctorMultiplicibus;
import net.strūctorverba.nūntiī.Nūntius;
import net.strūctorverba.verba.multiplicia.*;
import org.apache.commons.lang3.ObjectUtils;
import org.jetbrains.annotations.*;
import org.xml.sax.Attributes;

import javax.ejb.*;
import java.util.Objects;
import java.util.function.Supplier;

/**
 * Classis {@link TenorMultiplicibus} est vās classis {@link Tenor} classibus omnibus quibus classem {@link VerbumMultiplex} extendit.
 * @param <Hoc> classis extenta classis {@link VerbumMultiplex}
 * @see ConditōrMultiplicibus
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection" })
public abstract class TenorMultiplicibus <Hoc extends VerbumMultiplex <Hoc>> extends Tenor <Hoc> {
  /**
   * Valor hic est vās classis {@link ConditōrMultiplicibus} classī extentī huius.
   */
  protected final @NotNull ConditōrMultiplicibus <Hoc> condītōr;

  /**
   * Officium hoc cōnstrūctōrem reī classis huius perpetrat.
   * @param nūntius valōrem {@link Tenor#nūntius} supplet.
   * @param cndtr valōrem {@link #condītōr} supplet.
   */
  protected TenorMultiplicibus(@NotNull final Supplier <? extends Nūntius> nūntius,
                               @NotNull final Supplier <@NotNull ? extends ConditōrMultiplicibus <Hoc>> cndtr) {
    super(nūntius);
    condītōr = cndtr.get();
  }

  /**
   * Modus hic ēnumerātiōnēs prōcēdit lēctās ā rēbus classis {@link LēctorMultiplicibus}
   * @param locus valōrem hunc modus hic nōn ūtitur sed necessārium est rē classis <a href="https://docs.oracle.com/javase/7/docs/api/org/xml/sax/helpers/DefaultHandler.html">DefaultHandler</a> cōnsociāre
   * @param loculus valōrem hunc modus hic nōn ūtitur sed necessārium est rē classis <a href="https://docs.oracle.com/javase/7/docs/api/org/xml/sax/helpers/DefaultHandler.html">DefaultHandler</a> cōnsociāre
   * @param quālis valōrem hunc modus hic nōn ūtitur sed necessārium est rē classis <a href="https://docs.oracle.com/javase/7/docs/api/org/xml/sax/helpers/DefaultHandler.html">DefaultHandler</a> cōnsociāre
   * @param attribūta seriēs valōrum nōminumque sociātōrum
   * @see <a href="https://docs.oracle.com/javase/7/docs/api/org/xml/sax/helpers/DefaultHandler.html#startElement(java.lang.String,%20java.lang.String,%20java.lang.String,%20org.xml.sax.Attributes)">DefaultHandler.startElement</a>
   */
  public final @Override void startElement(@NotNull final String locus, @NotNull final String loculus,
                                           @NotNull final String quālis, @NotNull final Attributes attribūta) {

    for (int i = 0; i < attribūta.getLength(); i++) {
      nūntius.garriō("Teneō adicere attribūtum novum:",
                     attribūta.getLocalName(i), "est", attribūta.getValue(i));
      condītōr.allegō(attribūta.getLocalName(i), attribūta.getValue(i));
    }
  }

  /**
   * Modus hic rem aptam classis {@link ConditōrMultiplicibus} imperat restituī.
   * @param locus valōrem hunc modus hic nōn ūtitur sed necessārium est rē classis <a href="https://docs.oracle.com/javase/7/docs/api/org/xml/sax/helpers/DefaultHandler.html">DefaultHandler</a> cōnsociāre
   * @param loculus valōrem hunc modus hic nōn ūtitur sed necessārium est rē classis <a href="https://docs.oracle.com/javase/7/docs/api/org/xml/sax/helpers/DefaultHandler.html">DefaultHandler</a> cōnsociāre
   * @param quālis valōrem hunc modus hic nōn ūtitur sed necessārium est rē classis <a href="https://docs.oracle.com/javase/7/docs/api/org/xml/sax/helpers/DefaultHandler.html">DefaultHandler</a> cōnsociāre
   * @see <a href="https://docs.oracle.com/javase/7/docs/api/org/xml/sax/helpers/DefaultHandler.html#endElement(java.lang.String,%20java.lang.String,%20java.lang.String)">DefaultHandler.endElement</a>
   */
  public final @Override void endElement(@NotNull final String locus,
                                         @NotNull final String loculus, @NotNull final String quālis) {
    condītōr.restituō();
  }

  /**
   * @inheritDoc
   * @see Tenor#seriēs
   */
  protected final @Override void fīniam( ) {
    hoc = condītōr.condam();
    if (Objects.isNull(hoc)) {
      nūntius.moneō("Prōductiō verbī prōcessimus nūllae fōrmae.");
    } else {
      nūntius.garriō("Aggregāvī verbum novum", hoc);
      seriēs.add(hoc);
    }
  }

  /**
   * @inheritDoc
   * @see VerbumMultiplex#scrīptiō
   */
  protected @Override void scrībō(@NotNull String scrīptiō) {
    condītōr.ut(scrīptiō);
  }

  /**
   * Classis {@link TenorNōminibus} est vās classis {@link Tenor} classī {@link Nōmen}
   * @see Nōmen
   * @see Nūntius.NūntiusTenōrīNōminibus
   * @see ConditōrNōminibus
   */
  @Singleton @DependsOn({ "CondītōrNōminibus", "NūntiusTenōrīNōminibus" })
  public static final class TenorNōminibus extends TenorMultiplicibus <Nōmen> {
    private static @Nullable TenorNōminibus īnstantia = null;

    /**
     * Valor hic viam reī classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    public static @NotNull final Supplier <TenorNōminibus> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new TenorNōminibus());

    private TenorNōminibus( ) {
      super(Nūntius.NūntiusTenōrīNōminibus.fac, ConditōrNōminibus.fac);
    }
  }

  /**
   * Classis {@link TenorAdiectīvīs} est vās classis {@link Tenor} classī {@link Adiectīvum}
   * @see Adiectīvum
   * @see Nūntius.NūntiusTenōrīAdiectīvīs
   * @see ConditōrAdiectīvīs
   */
  @Singleton @DependsOn({ "CondītōrAdiectīvīs", "NūntiusTenōrīAdiectīvīs" })
  public static final class TenorAdiectīvīs extends TenorMultiplicibus <Adiectīvum> {
    private static @Nullable TenorAdiectīvīs īnstantia = null;

    /**
     * Valor hic viam reī classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    public static @NotNull final Supplier <TenorAdiectīvīs> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new TenorAdiectīvīs());

    private TenorAdiectīvīs( ) {
      super(Nūntius.NūntiusTenōrīAdiectīvīs.fac, ConditōrAdiectīvīs.fac);
    }
  }

  /**
   * Classis {@link TenorPrōnōminibus} est vās classis {@link Tenor} classī {@link Prōnōmen}
   * @see Prōnōmen
   * @see Nūntius.NūntiusTenōrīPrōnōminibus
   * @see ConditōrPrōnōminibus
   */
  @Singleton @DependsOn({ "CondītōrPrōnōminibus", "NūntiusTenōrīPrōnōminibus" })
  public static final class TenorPrōnōminibus extends TenorMultiplicibus <Prōnōmen> {
    private static @Nullable TenorPrōnōminibus īnstantia = null;

    /**
     * Valor hic viam reī classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    public static @NotNull final Supplier <TenorPrōnōminibus> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new TenorPrōnōminibus());

    private TenorPrōnōminibus( ) {
      super(Nūntius.NūntiusTenōrīPrōnōminibus.fac, ConditōrPrōnōminibus.fac);
    }
  }

  /**
   * Classis {@link TenorPrōnōminibusConiūnctīvīs} est vās classis {@link Tenor} classī {@link PrōnōmenConiūnctīvum}
   * @see PrōnōmenConiūnctīvum
   * @see Nūntius.NūntiusTenōrīPrōnōmibusConiūnctīvīs
   * @see ConditōrPrōnōminibusConiūnctīvīs
   */
  @Singleton @DependsOn({ "CondītōrPrōnōminiusConiūnctīvīs", "NūntiusTenōrīPrōnōmibusConiūnctīvīs" })
  public static final class TenorPrōnōminibusConiūnctīvīs extends TenorMultiplicibus <PrōnōmenConiūnctīvum> {
    private static @Nullable TenorPrōnōminibusConiūnctīvīs īnstantia = null;

    /**
     * Valor hic viam reī classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    public static @NotNull final Supplier <TenorPrōnōminibusConiūnctīvīs> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new TenorPrōnōminibusConiūnctīvīs());

    private TenorPrōnōminibusConiūnctīvīs( ) {
      super(Nūntius.NūntiusTenōrīPrōnōmibusConiūnctīvīs.fac, ConditōrPrōnōminibusConiūnctīvīs.fac);
    }
  }

  /**
   * Classis {@link TenorĀctīs} est vās classis {@link Tenor} classī {@link Āctum}
   * @see Āctum
   * @see Nūntius.NūntiusTenōrīĀctīs
   * @see ConditōrĀctīs
   */
  @Singleton @DependsOn({ "CondītōrĀctīs", "NūntiusTenōrīĀctīs" })
  public static final class TenorĀctīs extends TenorMultiplicibus <Āctum> {
    private static @Nullable TenorĀctīs īnstantia = null;

    /**
     * Valor hic viam reī classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    public static @NotNull final Supplier <TenorĀctīs> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new TenorĀctīs());

    private TenorĀctīs( ) {
      super(Nūntius.NūntiusTenōrīĀctīs.fac, ConditōrĀctīs.fac);
    }
  }
}
