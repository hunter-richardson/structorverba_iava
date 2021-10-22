package net.strūctorverba.inventōrēs;

import net.strūctorverba.lēctōrēs.LēctorMultiplicibus;
import net.strūctorverba.nūntiī.Nūntius;
import net.strūctorverba.verba.multiplicia.Nōmen;
import net.strūctorverba.ēnumerātiōnēs.Cāsus;
import net.strūctorverba.ēnumerātiōnēs.Genus;
import net.strūctorverba.ēnumerātiōnēs.Numerālis;
import net.strūctorverba.ēnumerātiōnēs.Speciālitās;
import net.strūctorverba.ēnumerātiōnēs.Tempus;

import org.apache.commons.lang3.ObjectUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Predicate;
import java.util.function.Supplier;

import javax.ejb.DependsOn;
import javax.ejb.Singleton;

/**
 * Classis {@link InventorNōminibus} est vās classis {@link Inventor} classī {@link Nōmen}.
 * @see Nōmen
 * @see Nūntius.NūntiusInventōrīNōminibus
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection" })
@Singleton
@DependsOn("NūntiusInventōrīAdiectīvīs")
public final class InventorNōminibus extends Inventor <Nōmen> {
  @Nullable private static InventorNōminibus īnstantia = null;

  /**
   * Valor hic viam reī classis huiuc facit.
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
   */
  @NotNull public static final Supplier <InventorNōminibus> fac =
    ( ) -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new InventorNōminibus());

  @NotNull private Speciālitās speciālitās = Speciālitās.NŪLLUM;
  @NotNull private Genus       genus       = Genus.NŪLLUM;
  @NotNull private Numerālis   numerālis   = Numerālis.NŪLLUS;
  @NotNull private Cāsus       cāsus       = Cāsus.DĒRĒCTUS;
  @NotNull private Tempus      tempus      = Tempus.INTEMPORĀLE;

  private InventorNōminibus( ) {
    super(Nūntius.NūntiusInventōrīNōminibus.fac);
    nūntius.plūrimumGarriō("Factus sum");
  }

  /**
   * @return Quaestiōnem quam rēs classis {@link LēctorMultiplicibus .LēctorNōminibus} ūtātur rēs classis {@link Nōmen}
   *   percōlere
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Predicate.html">Prediate</a>
   */
  @Override @NotNull
  public Predicate <@NotNull Nōmen> inquīram( ) {
    return nōmen -> speciālitās.equals(nōmen.speciālitās)
                    && genus.equals(nōmen.genus)
                    && cāsus.equals(nōmen.cāsus)
                    && numerālis.equals(nōmen.numerālis)
                    && tempus.equals(nōmen.tempus);
  }

  /**
   * {@inheritDoc}
   * @see Speciālitās#NŪLLUM
   * @see Genus#NŪLLUM
   * @see Numerālis#NŪLLUS
   * @see Cāsus#DĒRĒCTUS
   * @see Tempus#INTEMPORĀLE
   */
  @Override public void restituō( ) {
    speciālitās = Speciālitās.NŪLLUM;
    genus = Genus.NŪLLUM;
    numerālis = Numerālis.NŪLLUS;
    cāsus = Cāsus.DĒRĒCTUS;
    tempus = Tempus.INTEMPORĀLE;
    nūntius.certiōrō("Restitūtus sum");
  }

  /**
   * {@inheritDoc}
   * @param illud ēnumerātiōnem indendam
   * @see Speciālitās#ut(Enum)
   * @see Genus#ut(Enum)
   * @see Numerālis#ut(Enum)
   * @see Cāsus#ut(Enum)
   * @see Tempus#ut(Enum)
   */
  @Override protected void allegam(@NotNull final Enum <@NotNull ?> illud) {
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
    } else if (illud instanceof Tempus) {
      tempus = Tempus.ut(illud);
      nūntius.garriō("Quastiōnī adiēcī conditiōnem novam:",
                     Tempus.class.getSimpleName(), "est", illud);
    } else {
      nūntius.moneō(Nōmen.class.getSimpleName().replace("en", "ī"),
                    "inquīsītiō nōminī inopīnāta est ūsa:", illud.toString());
    }
  }
}
