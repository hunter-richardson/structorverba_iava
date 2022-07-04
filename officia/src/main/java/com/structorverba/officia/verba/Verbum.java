package com.structorverba.officia.verba;

import androidx.annotation.NonNull;
import com.structorverba.officia.conditores.Conditor;
import com.structorverba.officia.inventores.Inventor;
import com.structorverba.officia.lectores.Lector;
import com.structorverba.officia.miscella.*;
import com.structorverba.officia.tenores.Tenor;
import com.structorverba.officia.verba.multiplicia.VerbumMultiplex;
import com.structorverba.officia.enumerationes.Categoria;

/**
 * Classis {@link Verbum} repraesentat verba Latīna, fōrmās omnēs
 * datōrum quās ūsūfructuāriī petunt. <br>
 * Rem omnem classis huius rēs classis {@link Lector} colliget
 * rēs classis {@link Tenor} sēliget rēsque classis {@link Conditor} tandem cōnstruet. <br>
 * Rēs classis {@link Lector} colliget data ā scāpō XML intrā
 * scrīnium <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>. <br>
 * Rēs classis {@link Inventor} ūtitur cōlāre rēs
 * multiplicēs classis huius quae classem {@link VerbumMultiplex} extendit.
 * @param <Hoc> Tabellā hāc classis {@link Hoc} extēnsiōnem
 *             aptam datīs petītīs repraesentat.
 */
@SuppressWarnings("SpellCheckingInspection")
public abstract class Verbum <Hoc extends Verbum <Hoc>> extends Omne {
  /**
   * Valor hic repraesentat fōrmam verbī cui rādīcēscit. <br>
   * Quoque nōminātur scāpum XML quō cōnservātum est.
   */
  @NonNull
  public final String lemma;

  /**
   * Valor hic extēnsiōnem classī huic reī huic dēsignat.
   * {@link Categoria#scriptio} quoque nōminātur scrīnium
   * intrā quō scāpum eius cōnservātum est.
   * @see Categoria
   */
  @SuppressWarnings("unused")
  @NonNull public final Categoria catagoria;

  /**
   * Officium hoc cōnstrūctōrem reī classis huius perpetrat.
   * @param ctgr valōrem {@link #catagoria} indicat.
   * @param lm valōrem {@link #lemma} indicat.
   */
  protected Verbum(@NonNull final Categoria ctgr, @NonNull final String lm) {
    catagoria = ctgr;
    lemma = Utilitas.minusculasScribo(lm);
  }

  /**
   * @return Repraesentātiōnem scrīpta reī classis {@link Verbum}.
   */
  @Override @NonNull
  public abstract String toString();
}
