package net.strūctorverba.verba;

import net.strūctorverba.conditōrēs.Conditōr;
import net.strūctorverba.inventōrēs.Inventor;
import net.strūctorverba.lēctōrēs.Lēctor;
import net.strūctorverba.mīscella.*;
import net.strūctorverba.tenōrēs.Tenor;
import net.strūctorverba.verba.multiplicia.VerbumMultiplex;
import net.strūctorverba.ēnumerātiōnēs.Catēgoria;
import org.jetbrains.annotations.NotNull;

/**
 * Classis {@link Verbum} repraesentat verba Latīna, fōrmās omnēs datōrum quās ūsūfructuāriī petunt. <br>
 * Rem omnem classis huius rēs classis {@link Lēctor} colliget et rēs classis {@link Tenor} sēliget et rēs classis {@link Conditōr} tandem cōnstruet. <br>
 * Rēs classis {@link Lēctor} colliget data ā scāpō XML intrā scrīnium <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>. <br>
 * Rēs classis {@link Inventor} ūtitur cōlāre rēs multiplicēs classis huius quae classem {@link VerbumMultiplex} extendit.
 * @param <Hoc> Tabellā hāc classis {@link Hoc} extēnsiōnem aptam datīs petītīs repraesentat.
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection" })
public abstract class Verbum <Hoc extends Verbum <Hoc>> extends Omnum {
  /**
   * Valor hic repraesentat fōrmam verbī cui rādīcēscit. Quoque nōminātur scāpum XML quō cōnservātum est.
   */
  @NotNull public final String fundāmen;

  /**
   * Valor hic extēnsiōnem classī huic reī huic dēsignat.
   * {@link Catēgoria#scrīptiō} quoque nōminātur scrīnium intrā quō scāpum eius cōnservātum est.
   * @see Catēgoria
   */
  @NotNull public final Catēgoria catēgoria;

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
   * @return Repraesentātiōnem scrīpta reī classis {@link Verbum}.
   */
  @Override @NotNull
  public abstract String toString( );
}
