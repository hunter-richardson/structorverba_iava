package net.strūctorverba.inventōrēs;

import net.strūctorverba.nūntiī.Nūntius;
import net.strūctorverba.verba.multiplicia.*;
import net.strūctorverba.ēnumerātiōnēs.*;
import org.apache.commons.lang3.ObjectUtils;
import org.jetbrains.annotations.*;

import javax.ejb.*;
import java.util.function.*;

/**
 * Classis {@link InventorAdiectīvīs} est vās classis {@link Inventor} classī {@link Adiectīvum}.
 * @see Adiectīvum
 * @see Nūntius.NūntiusInventōrīAdiectīvīs
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection" })
@Singleton
@DependsOn("NūntiusInventōrīAdiectīvīs")
public final class InventorAdiectīvīs extends Inventor <Adiectīvum> {
  private static @Nullable InventorAdiectīvīs īnstantia = null;

  /**
   * Valor hic viam reī classis huiuc facit.
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
   */
  public static final @NotNull Supplier <InventorAdiectīvīs> fac =
    () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new InventorAdiectīvīs());

  private @NotNull Speciālitās speciālitās = Speciālitās.NŪLLUM;
  private @NotNull Genus       genus       = Genus.NŪLLUM;
  private @NotNull Numerālis   numerālis   = Numerālis.NŪLLUS;
  private @NotNull Cāsus       cāsus       = Cāsus.NŪLLUS;
  private @NotNull Gradus      gradus      = Gradus.NŪLLUS;

  private InventorAdiectīvīs( ) {
    super(Nūntius.NūntiusInventōrīAdiectīvīs.fac);
  }

  /**
   * @inheritDoc
   */
  public @Override @NotNull Predicate <@NotNull Adiectīvum> inquīram( ) {
    return adiectīvum -> speciālitās.equals(adiectīvum.speciālitās)
                         && genus.equals(adiectīvum.genus)
                         && cāsus.equals(adiectīvum.cāsus)
                         && numerālis.equals(adiectīvum.numerālis)
                         && gradus.equals(adiectīvum.gradus);
  }

  /**
   * @inheritDoc
   */
  public @Override void restituō( ) {
    speciālitās = Speciālitās.NŪLLUM;
    genus = Genus.NŪLLUM;
    numerālis = Numerālis.NŪLLUS;
    cāsus = Cāsus.NŪLLUS;
    gradus = Gradus.NŪLLUS;
    nūntius.certiōrō(getClass().getSimpleName(), "est restitūtus.");
  }

  /**
   * @inheritDoc
   * @see Speciālitās#ut(Enum, Speciālitās)
   * @see Genus#ut(Enum, Genus)
   * @see Numerālis#ut(Enum, Numerālis)
   * @see Cāsus#ut(Enum, Cāsus)
   * @see Gradus#ut(Enum, Gradus)
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
    } else if (illud instanceof Cāsus) {
      cāsus = Cāsus.ut(illud, Cāsus.NŪLLUS);
      nūntius.garriō("Quastiōnī adiēcī conditiōnem novam:",
                     Cāsus.class.getSimpleName(), "est", illud);
    } else if (illud instanceof Gradus) {
      gradus = Gradus.ut(illud, Gradus.NŪLLUS);
      nūntius.garriō("Quastiōnī adiēcī conditiōnem novam:",
                     Gradus.class.getSimpleName(), "est", illud);
    } else {
      nūntius.moneō(Adiectīvum.class.getSimpleName().replace("um", "ō"),
                    "inquīsītiō adiectīvō inopīnāta est ūsa:", illud.toString());
    }
  }
}