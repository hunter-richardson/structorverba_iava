package net.strūctorverba.inventōrēs;

import net.strūctorverba.nūntiī.Nūntius;
import net.strūctorverba.verba.multiplicia.PrōnōmenConiūnctīvum;
import net.strūctorverba.ēnumerātiōnēs.*;
import org.apache.commons.lang3.ObjectUtils;
import org.jetbrains.annotations.*;

import javax.ejb.*;
import java.util.function.*;

@Singleton
@DependsOn("NūntiusInventōrīĀctīs")
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection" })
public final class InventorPrōnōminibusConiūnctīvīs extends Inventor <PrōnōmenConiūnctīvum> {
  private static @Nullable InventorPrōnōminibusConiūnctīvīs īnstantia = null;

  public static final @NotNull Supplier <InventorPrōnōminibusConiūnctīvīs> fac =
    () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new InventorPrōnōminibusConiūnctīvīs());

  private @NotNull Speciālitās speciālitās = Speciālitās.NŪLLUM;
  private @NotNull Genus       genus       = Genus.NŪLLUM;
  private @NotNull Numerāle    numerāle    = Numerāle.NŪLLUM;
  private @NotNull Cāsus       cāsus       = Cāsus.NŪLLUM;

  private InventorPrōnōminibusConiūnctīvīs( ) {
    super(Nūntius.NūntiusInventōrīPrōnōmibusConiūnctīvīs.fac);
  }


  public @Override @NotNull Predicate <@NotNull PrōnōmenConiūnctīvum> inquīram( ) {
    return prōnōmen -> speciālitās.equals(prōnōmen.speciālitās)
                       && genus.equals(prōnōmen.genus)
                       && cāsus.equals(prōnōmen.cāsus)
                       && numerāle.equals(prōnōmen.numerāle);
  }

  public @Override void restituō( ) {
    speciālitās = Speciālitās.COMMŪNE;
    genus = Genus.NŪLLUM;
    numerāle = Numerāle.NŪLLUM;
    cāsus = Cāsus.NŪLLUM;
    nūntius.certiōrō(getClass().getSimpleName(), "est restitūtus.");
  }

  protected @Override void allegam(@NotNull final Enum<@NotNull ?> illud) {
    if (illud instanceof Speciālitās) {
      speciālitās = Speciālitās.ut(illud, Speciālitās.NŪLLUM);
      nūntius.garriō("Quastiōnī adiēcī conditiōnem novam:",
                     Speciālitās.class.getSimpleName(), "est", illud);
    } else if (illud instanceof Genus) {
      genus = Genus.ut(illud, Genus.NŪLLUM);
      nūntius.garriō("Quastiōnī adiēcī conditiōnem novam:",
                     Genus.class.getSimpleName(), "est", illud);
    } else if (illud instanceof Numerāle) {
      numerāle = Numerāle.ut(illud, Numerāle.NŪLLUM);
      nūntius.garriō("Quastiōnī adiēcī conditiōnem novam:",
                     Numerāle.class.getSimpleName(), "est", illud);
    } else {
      nūntius.moneō(PrōnōmenConiūnctīvum.class.getSimpleName()
                                        .replace("um", "ō")
                                        .replace("en", "ī"),
                    "inquīsītiō inopīnāta est ūsa:", illud);
    }
  }
}