package net.strūctorverba.inventōrēs;

import net.strūctorverba.lēctōrēs.LēctorMultiplicibus;
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
    nūntius.plūrimumGarriō("Factus sum");
  }

  /**
   * @return Quaestiōnem quam rēs classis {@link LēctorMultiplicibus.LēctorPrōnōminibusConiūnctīvīs} ūtātur rēs classis {@link PrōnōmenConiūnctīvum} percōlere
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Predicate.html">Prediate</a>
   */
  public @Override @NotNull Predicate <@NotNull PrōnōmenConiūnctīvum> inquīram( ) {
    return prōnōmen -> speciālitās.equals(prōnōmen.speciālitās)
                       && genus.equals(prōnōmen.genus)
                       && cāsus.equals(prōnōmen.cāsus)
                       && numerālis.equals(prōnōmen.numerālis);
  }

  /**
   * {@inheritDoc}
   */
  public @Override void restituō( ) {
    speciālitās = Speciālitās.NŪLLUM;
    genus = Genus.NŪLLUM;
    numerālis = Numerālis.NŪLLUS;
    cāsus = Cāsus.NŪLLUS;
    nūntius.certiōrō("Restitūtus sum");
  }

  /**
   * {@inheritDoc}
   * @param illud ēnumerātiōnem indendam
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
    } else {
      nūntius.moneō(PrōnōmenConiūnctīvum.class.getSimpleName()
                                        .replace("um", "ō")
                                        .replace("en", "ī"),
                    "inquīsītiō inopīnāta est ūsa:", illud);
    }
  }
}