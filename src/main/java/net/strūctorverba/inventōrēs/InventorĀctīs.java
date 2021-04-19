package net.strūctorverba.inventōrēs;

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
  private static @Nullable InventorĀctīs īnstantia = null;

  /**
   * Valor hic viam reī classis huiuc facit.
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
   */
  public static final @NotNull Supplier <InventorĀctīs> fac =
    () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new InventorĀctīs());

  private @NotNull Vōx       vōx       = Vōx.NŪLLA;
  private @NotNull Tempus    tempus    = Tempus.NŪLLUM;
  private @NotNull Numerālis numerālis = Numerālis.NŪLLUS;
  private @NotNull Persōna   persōna   = Persōna.NŪLLA;
  private @NotNull Modus     modus     = Modus.NŪLLUS;

  private InventorĀctīs( ) {
    super(Nūntius.NūntiusInventōrīĀctīs.fac);
    nūntius.plūrimumGarriō("Factus sum");
  }

  /**
   * @inheritDoc
   */
  public @Override @NotNull Predicate <@NotNull Āctum> inquīram( ) {
    return āctum -> modus.equals(āctum.modus)
                    && vōx.equals(āctum.vōx)
                    && tempus.equals(āctum.tempus)
                    && numerālis.equals(āctum.numerālis)
                    && persōna.equals(āctum.persōna);
  }

  /**
   * @inheritDoc
   */
  public @Override void restituō( ) {
    vōx = Vōx.NŪLLA;
    tempus = Tempus.NŪLLUM;
    numerālis = Numerālis.NŪLLUS;
    persōna = Persōna.NŪLLA;
    modus = Modus.NŪLLUS;
    nūntius.certiōrō("Restitūtus sum");
  }

  /**
   * @inheritDoc
   * @see Vōx#ut(Enum)
   * @see Tempus#ut(Enum)
   * @see Numerālis#ut(Enum)
   * @see Persōna#ut(Enum)
   * @see Modus#ut(Enum)
   */
  protected @Override void allegam(@NotNull final Enum<@NotNull ?> illud) {
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