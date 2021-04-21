package net.strūctorverba.inventōrēs;

import net.strūctorverba.lēctōrēs.LēctorMultiplicibus;
import net.strūctorverba.nūntiī.Nūntius;
import net.strūctorverba.verba.multiplicia.Adverbium;
import net.strūctorverba.ēnumerātiōnēs.*;
import org.apache.commons.lang3.ObjectUtils;
import org.jetbrains.annotations.*;

import javax.ejb.*;
import java.util.function.*;

/**
 * Classis {@link InventorAdverbiīs} est vās classis {@link Inventor} classī {@link Adverbium}.
 * @see Adverbium
 * @see Nūntius.NūntiusInventōrīAdverbiīs
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection" })
@Singleton
@DependsOn("NūntiusInventōrīAdverbiīs")
public class InventorAdverbiīs extends Inventor<Adverbium> {
  @Nullable private static InventorAdverbiīs īnstantia = null;

  /**
   * Valor hic viam reī classis huiuc facit.
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
   */
  @NotNull public static final Supplier <InventorAdverbiīs> fac =
    () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new InventorAdverbiīs());

  @NotNull private Gradus gradus = Gradus.NŪLLUS;

  private InventorAdverbiīs( ) {
    super(Nūntius.NūntiusInventōrīAdverbiīs.fac);
    nūntius.plūrimumGarriō("Factus sum");
  }

  /**
   * @return Quaestiōnem quam rēs classis {@link LēctorMultiplicibus.LēctorAdverbiīs} ūtātur rēs classis {@link Adverbium}
   *   percōlere
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Predicate.html">Prediate</a>
   */
  @Override @NotNull
  public Predicate <@NotNull Adverbium> inquīram( ) {
    return adverbium -> gradus.equals(adverbium.gradus);
  }

  /**
   * Modus hic rem hanc restituit.
   * @see Gradus#NŪLLUS
   */
  @Override public void restituō( ) {
    gradus = Gradus.NŪLLUS;
  }

  /**
   * Modus hic ēnumerātiōnem singulum {@code illud} reī huic indit.
   * @param illud ēnumerātiōnem indendam
   * @see Gradus#ut(Enum)
   */
  @Override protected void allegam(Enum <@NotNull ?> illud) {
    gradus = Gradus.ut(illud);
  }
}
