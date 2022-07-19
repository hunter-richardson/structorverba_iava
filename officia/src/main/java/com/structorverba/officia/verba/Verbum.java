package com.structorverba.officia.verba;

import androidx.annotation.NonNull;
import com.structorverba.officia.curatores.Curator;
import com.structorverba.officia.inventores.Inventor;
import com.structorverba.officia.lectores.Lector;
import com.structorverba.officia.miscella.*;
import com.structorverba.officia.tenores.Tenor;
import com.structorverba.officia.verba.multiplicia.Multiplex;
import com.structorverba.officia.enumerationes.Categoria;

/**
 * Classis {@link Verbum} repraesentat verba Latīna, fōrmās omnēs
 * datōrum quās ūsūfructuāriī petunt. <br>
 * Rem omnem huius classis rēs classis {@link Lector} colliget
 * rēs classis {@link Tenor} sēliget rēsque classis {@link Curator} tandem cōnstruet. <br>
 * Rēs classis {@link Lector} colliget data ā scāpō XML intrā
 * scrīnium <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>. <br>
 * Rēs classis {@link Inventor} ūtitur cōlāre rēs
 * multiplicēs huius classis quae classem {@link Multiplex} extendit.
 * @param <Hoc> Hāc tabellā classis {@link Hoc} extēnsiōnem
 *             aptam datīs petītīs repraesentat.
 * @see Multiplex
 * @see Simplex
 */
@SuppressWarnings("SpellCheckingInspection")
public abstract class Verbum <Hoc extends Verbum <Hoc>> extends Omne implements Comparable<Verbum<?>> {
  /**
   * Hic valor repraesentat fōrmam verbī cui rādīcēscit. <br>
   * Quoque nōminātur scāpum XML quō cōnservātum est.
   */
  @NonNull
  public final String lemma;

  /**
   * Hic valor extentum classem reī huic dēsignat.
   * {@link Categoria#scriptio} quoque nōminātur scrīnium
   * intrā quō scāpum eius cōnservātum est.
   * @see Categoria
   */
  @SuppressWarnings("unused")
  @NonNull public final Categoria catagoria;

  /**
   * Hoc officium cōnstrūctōrem reī huius classis perpetrat.
   * @param ctgr valōrem {@link #catagoria} indicat.
   * @param lm valōrem {@link #lemma} indicat.
   */
  protected Verbum(@NonNull final Categoria ctgr, @NonNull final String lm) {
    catagoria = ctgr;
    lemma = Utilitas.minusculasScribo(lm);
  }

  /**
  * Hic modus modum {@link Comparable#compareTo(Object)} implit.
  * @return {@code 0} sī hoc valorque {@code aliud} sē aequant; valor negātīvus sī hoc minor'st quam valor {@code aliud};
  *         valor positīvus sī hoc maior'st quam valor {@code aliud}.
  * @see  Comparable#compareTo(Object)
  * */
  @Override
  public int compareTo(Verbum<?> aliud) {
    return toString().compareTo(aliud.toString());
  }

  /**
   * @return Repraesentātiōnem scrīpta reī classis {@link Verbum}.
   * @see Object#toString()
   */
  @Override @NonNull
  public abstract String toString();
}
