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
@DependsOn("NūntiusInventōrīAdiectīvīs")
public final class InventorNōminibus extends Inventor <Nōmen> {
  private static @Nullable InventorNōminibus īnstantia = null;

  public static final @NotNull Supplier <InventorNōminibus> fac =
    () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new InventorNōminibus());

  private @NotNull Speciālitās speciālitās = Speciālitās.NŪLLUM;
  private @NotNull Genus       genus       = Genus.NŪLLUM;
  private @NotNull Numerāle    numerāle    = Numerāle.NŪLLUS;
  private @NotNull Cāsus       cāsus       = Cāsus.NŪLLUS;

  private InventorNōminibus( ) {
    super(Nūntius.NūntiusInventōrīNōminibus.fac);
  }

  public @Override @NotNull Predicate <@NotNull Nōmen> inquīram( ) {
    return nōmen -> speciālitās.equals(nōmen.speciālitās)
                    && genus.equals(nōmen.genus)
                    && cāsus.equals(nōmen.cāsus)
                    && numerāle.equals(nōmen.numerāle);
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
      nūntius.moneō(Nōmen.class.getSimpleName().replace("en", "ī"),
                    "inquīsītiō nōminī inopīnāta est ūsa:", illud.toString());
    }
  }
}