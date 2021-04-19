package net.strūctorverba.inventōrēs;

import net.strūctorverba.nūntiī.Nūntius;
import net.strūctorverba.verba.multiplicia.PrōnōmenConiūnctīvum;
import net.strūctorverba.ēnumerātiōnēs.*;
import org.apache.commons.lang3.ObjectUtils;
import org.jetbrains.annotations.*;

import javax.ejb.*;
import java.util.function.*;

/**
 * Classis {@link InventorPrōnōminibusConiūnctīvīs} est vās classis {@link Inventor} classī {@link PrōnōmenConiūnctīvum}.
 * @see PrōnōmenConiūnctīvum
 * @see Nūntius.NūntiusInventōrīPrōnōmibusConiūnctīvīs
 */
@Singleton
@DependsOn("NūntiusInventōrīĀctīs")
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection" })
public final class InventorPrōnōminibusConiūnctīvīs extends Inventor <PrōnōmenConiūnctīvum> {
  private static @Nullable InventorPrōnōminibusConiūnctīvīs īnstantia = null;

  /**
   * Valor hic viam reī classis huiuc facit.
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
   */
  public static final @NotNull Supplier <InventorPrōnōminibusConiūnctīvīs> fac =
    () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new InventorPrōnōminibusConiūnctīvīs());

  private @NotNull Speciālitās speciālitās = Speciālitās.NŪLLUM;
  private @NotNull Genus       genus       = Genus.NŪLLUM;
  private @NotNull Numerālis   numerālis   = Numerālis.NŪLLUS;
  private @NotNull Cāsus       cāsus       = Cāsus.NŪLLUS;

  private InventorPrōnōminibusConiūnctīvīs( ) {
    super(Nūntius.NūntiusInventōrīPrōnōmibusConiūnctīvīs.fac);
  }

  /**
   * @inheritDoc
   */
  public @Override @NotNull Predicate <@NotNull PrōnōmenConiūnctīvum> inquīram( ) {
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
   * @see Speciālitās#ut(Enum, Speciālitās)
   * @see Genus#ut(Enum, Genus)
   * @see Numerālis#ut(Enum, Numerālis)
   * @see Cāsus#ut(Enum, Cāsus)
   */
  protected @Override void allegam(@NotNull final Enum<@NotNull ?> illud) {
    if (illud instanceof Speciālitās) {
      speciālitās = Speciālitās.ut(illud, Speciālitās.NŪLLUM);
      nūntius.garriō("Quastiōnī adiēcī conditiōnem novam:",
                     Speciālitās.class.getSimpleName(), "est", illud);
    } else if (illud instanceof Genus) {
      genus = Genus.ut(illud, Genus.NŪLLUM);
      nūntius.garriō("Quastiōnī adiēcī conditiōnem novam:",
                     Genus.class.getSimpleName(), "est", illud);
    } else if (illud instanceof Numerālis) {
      numerālis = Numerālis.ut(illud, Numerālis.NŪLLUS);
      nūntius.garriō("Quastiōnī adiēcī conditiōnem novam:",
                     Numerālis.class.getSimpleName(), "est", illud);
    } else {
      nūntius.moneō(PrōnōmenConiūnctīvum.class.getSimpleName()
                                        .replace("um", "ō")
                                        .replace("en", "ī"),
                    "inquīsītiō inopīnāta est ūsa:", illud);
    }
  }
}