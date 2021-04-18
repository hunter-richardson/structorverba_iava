package net.strūctorverba.inventōrēs;

import net.strūctorverba.nūntiī.Nūntius;
import net.strūctorverba.verba.multiplicia.Āctum;
import net.strūctorverba.ēnumerātiōnēs.*;
import org.apache.commons.lang3.ObjectUtils;
import org.jetbrains.annotations.*;

import javax.ejb.*;
import java.util.function.*;

@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection" })
@Singleton
@DependsOn("NūntiusInventōrīĀctīs")
public final class InventorĀctīs extends Inventor <Āctum> {
  private static @Nullable InventorĀctīs īnstantia = null;

  public static final @NotNull Supplier <InventorĀctīs> fac =
    () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new InventorĀctīs());

  private @NotNull Vōx      vōx      = Vōx.NŪLLA;
  private @NotNull Tempus   tempus   = Tempus.NŪLLUM;
  private @NotNull Numerāle numerāle = Numerāle.NŪLLUS;
  private @NotNull Persōna  persōna  = Persōna.NŪLLA;
  private @NotNull Modus    modus    = Modus.NŪLLUS;

  private InventorĀctīs( ) {
    super(Nūntius.NūntiusInventōrīĀctīs.fac);
  }

  public @Override @NotNull Predicate <@NotNull Āctum> inquīram( ) {
    return āctum -> modus.equals(āctum.modus)
                    && vōx.equals(āctum.vōx)
                    && tempus.equals(āctum.tempus)
                    && numerāle.equals(āctum.numerāle)
                    && persōna.equals(āctum.persōna);
  }

  public @Override void restituō( ) {
    vōx = Vōx.NŪLLA;
    tempus = Tempus.NŪLLUM;
    numerāle = Numerāle.NŪLLUS;
    persōna = Persōna.NŪLLA;
    modus = Modus.NŪLLUS;
    nūntius.certiōrō(getClass().getSimpleName(), "est restitūtus.");
  }


  protected @Override void allegam(@NotNull final Enum<@NotNull ?> illud) {
    if (illud instanceof Vōx) {
      vōx = Vōx.ut(illud, Vōx.NŪLLA);
      nūntius.garriō("Quastiōnī adiēcī conditiōnem novam:",
                     Vōx.class.getSimpleName(), "est", illud);
    } else if (illud instanceof Tempus) {
      tempus = Tempus.ut(illud, Tempus.NŪLLUM);
      nūntius.garriō("Quastiōnī adiēcī conditiōnem novam:",
                     Tempus.class.getSimpleName(), "est", illud);
    } else if (illud instanceof Numerāle) {
      numerāle = Numerāle.ut(illud, Numerāle.NŪLLUS);
      nūntius.garriō("Quastiōnī adiēcī conditiōnem novam:",
                     Numerāle.class.getSimpleName(), "est", illud);
    } else if (illud instanceof Persōna) {
      persōna = Persōna.ut(illud, Persōna.NŪLLA);
      nūntius.garriō("Quastiōnī adiēcī conditiōnem novam:",
                     Persōna.class.getSimpleName(), "est", illud);
    } else if (illud instanceof Modus) {
      modus = Modus.ut(illud, Modus.NŪLLUS);
      nūntius.garriō("Quastiōnī adiēcī conditiōnem novam:",
                     Modus.class.getSimpleName(), "est", illud);
    } else {
      nūntius.moneō(Āctum.class.getSimpleName().replace("um", "ō"),
                    "inquīsītiō inopīnāta est ūsa:", illud);
    }
  }
}