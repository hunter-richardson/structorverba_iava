package com.structorverba.officia.curatores.multiplicia;

import androidx.annotation.*;
import com.structorverba.officia.curatores.Curator;
import com.structorverba.officia.enumerationes.*;
import com.structorverba.officia.nuntii.*;
import com.structorverba.officia.verba.Verbum;
import com.structorverba.officia.verba.constructores.ConstructorAdverbii;
import com.structorverba.officia.verba.multiplicia.Adverbium;
import jakarta.ejb.Singleton;
import org.apache.commons.lang3.ObjectUtils;

import java.util.function.Supplier;

/**
 * Classis {@link CuratorAdverbiis} est vās classis {@link Curator} classī {@link Adverbium}.
 * @see Adverbium
 * @see NuntiusConditoriAdverbiis
 */
@SuppressWarnings("SpellCheckingInspection")
public class CuratorAdverbiis extends CuratorMultiplicibus<Adverbium> {
  @Nullable private static CuratorAdverbiis instantia = null;

  /**
   * Hic valor viam reī huius classis facit.
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
   */
  @NonNull public static final Supplier <CuratorAdverbiis> faciendum =
    () -> ObjectUtils.firstNonNull(instantia, instantia = new CuratorAdverbiis());

  private CuratorAdverbiis() {
    super(Categoria.ADVERBIUM, NuntiusConditoriAdverbiis.faciendum, ConstructorAdverbii::new);
    nuntius.plurimumGarrio("Factus sum");
  }

  /**
   * {@inheritDoc}
   * @see Gradus#definiam(String)
   * @see Verbum#lemma
   */
  @Override public void allegam(@NonNull final String nomen, @NonNull final String descriptor) {
    switch (nomen) {
      case Gradus.pittacium -> ((ConstructorAdverbii) constructor).gradus(Gradus.definiam(descriptor));
      case pittaciumLemmae -> constructor.lemma(descriptor.trim());
      default -> {
        allectioDefecit(nomen, descriptor);
        return;
      }
    }

    allectioFinita(nomen, descriptor);
  }

  /**
   * Classis {@link NuntiusConditoriAdverbiis} est vās classis {@link Nuntius} classī {@link CuratorAdverbiis}
   * @see CuratorAdverbiis
   */
  @Singleton
  private static final class NuntiusConditoriAdverbiis extends Nuntius {
    @Nullable private static NuntiusConditoriAdverbiis instantia = null;

    /**
     * Hic valor viam reī huius classis facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull private static final Supplier <NuntiusConditoriAdverbiis> faciendum =
            () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusConditoriAdverbiis());

    private NuntiusConditoriAdverbiis() {
      super(ParametriNuntii.para(CuratorAdverbiis.class));
    }
  }
}
