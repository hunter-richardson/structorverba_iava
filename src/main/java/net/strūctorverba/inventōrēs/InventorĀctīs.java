package net.strūctorverba.inventōrēs;

import net.strūctorverba.lēctōrēs.LēctorMultiplicibus;
import net.strūctorverba.nūntiī.Nūntius;
import net.strūctorverba.verba.multiplicia.Āctum;
import net.strūctorverba.ēnumerātiōnēs.*;
import org.apache.commons.lang3.ObjectUtils;
import org.jetbrains.annotations.*;

import javax.ejb.*;
import java.util.function.*;

/**
 * Classis {@link InventorĀctīs} est vās classis {@link Inventor} classī {@link Āctum}.
 * @see Āctum
 * @see Nūntius.NūntiusInventōrīĀctīs
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection" })
@Singleton
@DependsOn("NūntiusInventōrīĀctīs")
public final class InventorĀctīs extends Inventor <Āctum> {
  @Nullable private static InventorĀctīs īnstantia = null;

  /**
   * Valor hic viam reī classis huiuc facit.
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
   */
  @NotNull public static final Supplier <InventorĀctīs> fac =
    () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new InventorĀctīs());

  @NotNull private Vōx       vōx       = Vōx.NŪLLA;
  @NotNull private Tempus    tempus    = Tempus.NŪLLUM;
  @NotNull private Numerālis numerālis = Numerālis.NŪLLUS;
  @NotNull private Persōna   persōna   = Persōna.NŪLLA;
  @NotNull private Modus     modus     = Modus.NŪLLUS;

  private InventorĀctīs( ) {
    super(Nūntius.NūntiusInventōrīĀctīs.fac);
    nūntius.plūrimumGarriō("Factus sum");
  }

  /**
   * @return Quaestiōnem quam rēs classis {@link LēctorMultiplicibus.LēctorĀctīs} ūtātur rēs classis {@link Āctum} percōlere
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Predicate.html">Prediate</a>
   */
  @Override @NotNull
  public Predicate <@NotNull Āctum> inquīram( ) {
    return āctum -> modus.equals(āctum.modus)
                    && vōx.equals(āctum.vōx)
                    && tempus.equals(āctum.tempus)
                    && numerālis.equals(āctum.numerālis)
                    && persōna.equals(āctum.persōna);
  }

  /**
   * {@inheritDoc}
   * @see Vōx#NŪLLA
   * @see Tempus#NŪLLUM
   * @see Numerālis#NŪLLUS
   * @see Persōna#NŪLLA
   * @see Modus#NŪLLUS
   */
  @Override public void restituō( ) {
    vōx = Vōx.NŪLLA;
    tempus = Tempus.NŪLLUM;
    numerālis = Numerālis.NŪLLUS;
    persōna = Persōna.NŪLLA;
    modus = Modus.NŪLLUS;
    nūntius.certiōrō("Restitūtus sum");
  }

  /**
   * {@inheritDoc}
   * @param illud ēnumerātiōnem indendam
   * @see Vōx#ut(Enum)
   * @see Tempus#ut(Enum)
   * @see Numerālis#ut(Enum)
   * @see Persōna#ut(Enum)
   * @see Modus#ut(Enum)
   */
  @Override protected void allegam(@NotNull final Enum<@NotNull ?> illud) {
    if (illud instanceof Vōx) {
      vōx = Vōx.ut(illud);
      nūntius.garriō("Quastiōnī adiēcī conditiōnem novam:",
                     Vōx.class.getSimpleName(), "est", illud);
    } else if (illud instanceof Tempus) {
      tempus = Tempus.ut(illud);
      nūntius.garriō("Quastiōnī adiēcī conditiōnem novam:",
                     Tempus.class.getSimpleName(), "est", illud);
    } else if (illud instanceof Numerālis) {
      numerālis = Numerālis.ut(illud);
      nūntius.garriō("Quastiōnī adiēcī conditiōnem novam:",
                     Numerālis.class.getSimpleName(), "est", illud);
    } else if (illud instanceof Persōna) {
      persōna = Persōna.ut(illud);
      nūntius.garriō("Quastiōnī adiēcī conditiōnem novam:",
                     Persōna.class.getSimpleName(), "est", illud);
    } else if (illud instanceof Modus) {
      modus = Modus.ut(illud);
      nūntius.garriō("Quastiōnī adiēcī conditiōnem novam:",
                     Modus.class.getSimpleName(), "est", illud);
    } else {
      nūntius.moneō(Āctum.class.getSimpleName().replace("um", "ō"),
                    "inquīsītiō inopīnāta est ūsa:", illud);
    }
  }
}