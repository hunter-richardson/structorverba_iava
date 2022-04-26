package net.structorverba.bibliotheca.inventores;

import net.structorverba.bibliotheca.lectores.LēctorMultiplicibus;
import net.structorverba.bibliotheca.nuntii.Nūntius;
import net.structorverba.bibliotheca.verba.multiplicia.Adiectīvum;
import net.structorverba.bibliotheca.enumerationes.*;

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
  @Nullable private static InventorAdiectīvīs īnstantia = null;

  /**
   * Valor hic viam reī classis huiuc facit.
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
   */
  @NotNull public static final Supplier <InventorAdiectīvīs> fac =
    ( ) -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new InventorAdiectīvīs());

  @NotNull private Speciālitās speciālitās = Speciālitās.NŪLLUM;
  @NotNull private Genus       genus       = Genus.NŪLLUM;
  @NotNull private Numerālis   numerālis   = Numerālis.NŪLLUS;
  @NotNull private Cāsus       cāsus       = Cāsus.DĒRĒCTUS;
  @NotNull private Gradus      gradus      = Gradus.NŪLLUS;

  private InventorAdiectīvīs( ) {
    super(Nūntius.NūntiusInventōrīAdiectīvīs.fac);
    nūntius.plūrimumGarriō("Factus sum");
  }

  /**
   * @return Quaestiōnem quam rēs classis {@link LēctorMultiplicibus.LēctorAdiectīvīs} ūtātur rēs classis {@link
   *   Adiectīvum} percōlere
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Predicate.html">Prediate</a>
   */
  @Override @NotNull
  public Predicate <@NotNull Adiectīvum> inquīram( ) {
    return adiectīvum -> speciālitās.equals(adiectīvum.speciālitās)
                         && genus.equals(adiectīvum.genus)
                         && cāsus.equals(adiectīvum.cāsus)
                         && numerālis.equals(adiectīvum.numerālis)
                         && gradus.equals(adiectīvum.gradus);
  }

  /**
   * {@inheritDoc}
   * @see Speciālitās#NŪLLUM
   * @see Genus#NŪLLUM
   * @see Numerālis#NŪLLUS
   * @see Cāsus#DĒRĒCTUS
   * @see Gradus#NŪLLUS
   */
  @Override public void restituō( ) {
    speciālitās = Speciālitās.NŪLLUM;
    genus = Genus.NŪLLUM;
    numerālis = Numerālis.NŪLLUS;
    cāsus = Cāsus.DĒRĒCTUS;
    gradus = Gradus.NŪLLUS;
    nūntius.certiōrō("Restitūtus sum");
  }

  /**
   * {@inheritDoc}
   * @param illud ēnumerātiōnem indendam
   * @see Speciālitās#ut(Enum)
   * @see Genus#ut(Enum)
   * @see Numerālis#ut(Enum)
   * @see Cāsus#ut(Enum)
   * @see Gradus#ut(Enum)
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
    } else if (illud instanceof Gradus) {
      gradus = Gradus.ut(illud);
      nūntius.garriō("Quastiōnī adiēcī conditiōnem novam:",
                     Gradus.class.getSimpleName(), "est", illud);
    } else {
      nūntius.moneō(Adiectīvum.class.getSimpleName().replace("um", "ō"),
                    "inquīsītiō adiectīvō inopīnāta est ūsa:", illud.toString());
    }
  }
}