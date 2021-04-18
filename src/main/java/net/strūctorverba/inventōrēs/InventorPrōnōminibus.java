package net.strūctorverba.inventōrēs;

import net.strūctorverba.nūntiī.Nūntius;
import net.strūctorverba.verba.multiplicia.*;
import net.strūctorverba.ēnumerātiōnēs.*;
import org.apache.commons.lang3.ObjectUtils;
import org.jetbrains.annotations.*;

import javax.ejb.*;
import java.util.function.*;

@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection" })
@Singleton
@DependsOn("NūntiusInventōrīPrōnōminibus")
public final class InventorPrōnōminibus extends Inventor <Prōnōmen> {
  private static @Nullable InventorPrōnōminibus īnstantia = null;

  public static final @NotNull Supplier <InventorPrōnōminibus> fac =
    () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new InventorPrōnōminibus());

  private @NotNull Speciālitās speciālitās = Speciālitās.NŪLLUM;
  private @NotNull Genus       genus       = Genus.NŪLLUM;
  private @NotNull Numerāle    numerāle    = Numerāle.NŪLLUS;
  private @NotNull Cāsus       cāsus       = Cāsus.NŪLLUS;

  private InventorPrōnōminibus( ) {
    super(Nūntius.NūntiusInventōrīPrōnōminibus.fac);
  }

  public @Override @NotNull Predicate <@NotNull Prōnōmen> inquīram( ) {
    return prōnōmen -> speciālitās.equals(prōnōmen.speciālitās)
                       && genus.equals(prōnōmen.genus)
                       && cāsus.equals(prōnōmen.cāsus)
                       && numerāle.equals(prōnōmen.numerāle);
  }

  public @Override void restituō( ) {
    speciālitās = Speciālitās.NŪLLUM;
    genus = Genus.NŪLLUM;
    numerāle = Numerāle.NŪLLUS;
    cāsus = Cāsus.NŪLLUS;
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
      numerāle = Numerāle.ut(illud, Numerāle.NŪLLUS);
      nūntius.garriō("Quastiōnī adiēcī conditiōnem novam:",
                     Numerāle.class.getSimpleName(), "est", illud);
    } else if (illud instanceof Cāsus) {
      cāsus = Cāsus.ut(illud, Cāsus.NŪLLUS);
      nūntius.garriō("Quastiōnī adiēcī conditiōnem novam:",
                     Cāsus.class.getSimpleName(), "est", illud);
    } else {
      nūntius.moneō(Prōnōmen.class.getSimpleName().replace("en", "ī"),
                    "inquīsītiō inopīnāta est ūsa:", illud);
    }
  }
}