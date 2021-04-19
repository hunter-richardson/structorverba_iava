package net.strūctorverba.inventōrēs;

import net.strūctorverba.nūntiī.Nūntius;
import net.strūctorverba.verba.multiplicia.*;
import net.strūctorverba.ēnumerātiōnēs.*;
import org.apache.commons.lang3.ObjectUtils;
import org.jetbrains.annotations.*;

import javax.ejb.*;
import java.util.function.*;

/**
 * Classis {@link InventorPrōnōminibus} est vās classis {@link Inventor} classī {@link Prōnōmen}.
 * @see Prōnōmen
 * @see Nūntius.NūntiusInventōrīPrōnōminibus
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection" })
@Singleton
@DependsOn("NūntiusInventōrīPrōnōminibus")
public final class InventorPrōnōminibus extends Inventor <Prōnōmen> {
  private static @Nullable InventorPrōnōminibus īnstantia = null;

  /**
   * Valor hic viam reī classis huiuc facit.
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
   */
  public static final @NotNull Supplier <InventorPrōnōminibus> fac =
    () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new InventorPrōnōminibus());

  private @NotNull Speciālitās speciālitās = Speciālitās.NŪLLUM;
  private @NotNull Genus       genus       = Genus.NŪLLUM;
  private @NotNull Numerālis   numerālis   = Numerālis.NŪLLUS;
  private @NotNull Cāsus       cāsus       = Cāsus.NŪLLUS;

  private InventorPrōnōminibus( ) {
    super(Nūntius.NūntiusInventōrīPrōnōminibus.fac);
  }

  /**
   * @inheritDoc
   */
  public @Override @NotNull Predicate <@NotNull Prōnōmen> inquīram( ) {
    return prōnōmen -> speciālitās.equals(prōnōmen.speciālitās)
                       && genus.equals(prōnōmen.genus)
                       && cāsus.equals(prōnōmen.cāsus)
                       && numerālis.equals(prōnōmen.numerālis);
  }

  /**
   * @inheritDoc
   */
  public @Override void restituō( ) {
    speciālitās = Speciālitās.NŪLLUM;
    genus = Genus.NŪLLUM;
    numerālis = Numerālis.NŪLLUS;
    cāsus = Cāsus.NŪLLUS;
    nūntius.certiōrō(getClass().getSimpleName(), "est restitūtus.");
  }

  /**
   * @inheritDoc
   * @see Speciālitās#ut(Enum)
   * @see Genus#ut(Enum)
   * @see Numerālis#ut(Enum)
   * @see Cāsus#ut(Enum)
   */
  protected @Override void allegam(@NotNull final Enum<@NotNull ?> illud) {
    if (illud instanceof Speciālitās) {
      speciālitās = Speciālitās.ut(illud);
      nūntius.garriō("Quastiōnī adiēcī conditiōnem novam:",
                     Speciālitās.class.getSimpleName(), "est", illud);
    } else if (illud instanceof Genus) {
      genus = Genus.ut(illud);
      nūntius.garriō("Quastiōnī adiēcī conditiōnem novam:",
                     Genus.class.getSimpleName(), "est", illud);
    } else if (illud instanceof Numerālis) {
      numerālis = Numerālis.ut(illud);
      nūntius.garriō("Quastiōnī adiēcī conditiōnem novam:",
                     Numerālis.class.getSimpleName(), "est", illud);
    } else if (illud instanceof Cāsus) {
      cāsus = Cāsus.ut(illud);
      nūntius.garriō("Quastiōnī adiēcī conditiōnem novam:",
                     Cāsus.class.getSimpleName(), "est", illud);
    } else {
      nūntius.moneō(Prōnōmen.class.getSimpleName().replace("en", "ī"),
                    "inquīsītiō inopīnāta est ūsa:", illud);
    }
  }
}