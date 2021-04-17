package net.strūctorverba.verba;

import net.strūctorverba.conditōrēs.Conditōr;
import net.strūctorverba.inventōrēs.Inventor;
import net.strūctorverba.lēctōrēs.Lēctor;
import net.strūctorverba.tenōrēs.Tenor;
import net.strūctorverba.verba.multiplicia.VerbumMultiplex;
import net.strūctorverba.ēnumerātiōnēs.Catēgoria;
import net.strūctorverba.mīscella.Ūtilitās;
import org.jetbrains.annotations.NotNull;


/**
 * Classis {@link Verbum} repraesentat verba Latīna, fōrmās omnēs datī quās ūsūfructuāriī petunt.
 * Rem omnem classis huius rēs classis {@link Lēctor} colliget et rēs classis {@link Tenor} sēliget et rēs classis {@link Conditōr} tandem cōnstruet.
 * Rēs classis {@link Lēctor} colliget datum ā scāpō XML intrā scrīnium <a href="../src/main/resources">auxiliārēs</a>.
 * Rēs multiplicēs classis huius (quae classem {@link VerbumMultiplex} extendit) rēs classis {@link Inventor} quaestiōnibus ūtitur.
 * @param <Hoc> Tabellā hāc classis {@link Hoc} extēnsiōnem aptam datīs petītīs repraesentat.
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection" })
public abstract class Verbum <Hoc extends Verbum <Hoc>> {
  /**
   * Valor hic repraesentat fōrmam verbī cui rādīcēscit. Quoque nōminātur scāpum XML quō cōnservātum est.
   */
  public final @NotNull String fundāmen;

  /**
   * Valor hic extēnsiōnem classī huius reī huic dēsignat.
   * {@link Catēgoria#scrīptiō} quoque nōminātur scrīnium intrā quō scāpum eius cōnservātum est.
   * @see Catēgoria
   */
  public final @NotNull Catēgoria catēgoria;

  /**
   * Officium hoc cōnstrūctōrem reī classis huius perpetrat.
   * @param ctgr valōrem {@link #catēgoria} indicat.
   * @param fdmn valōrem {@link #fundāmen} indicat.
   */
  protected Verbum(@NotNull final Catēgoria ctgr, @NotNull final String fdmn) {
    catēgoria = ctgr;
    fundāmen = Ūtilitās.minusculāsScrībō(fdmn);
  }

  /**
   * @return repraesentātiōnem scrīpta reī classis {@link Verbum}.
   */
  public abstract @Override @NotNull String toString( );
}
