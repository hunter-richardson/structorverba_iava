package com.structorverba.officia.curatores.multiplicia;

import androidx.annotation.*;
import com.structorverba.officia.curatores.Curator;
import com.structorverba.officia.enumerationes.*;
import com.structorverba.officia.nuntii.*;
import com.structorverba.officia.verba.Verbum;
import com.structorverba.officia.verba.constructores.ConstructorActi;
import com.structorverba.officia.verba.multiplicia.Actus;
import jakarta.ejb.*;
import org.apache.commons.lang3.ObjectUtils;

import java.util.function.Supplier;


/**
 * Classis {@link CuratorActis} est vās classis {@link Curator} classī {@link Actus}.
 * @see Actus
 * @see NuntiusConditoriActis
 */
@SuppressWarnings("SpellCheckingInspection")
@Singleton
@DependsOn("NuntiusConditoriActis")
public final class CuratorActis extends CuratorMultiplicibus<Actus> {
  @Nullable private static CuratorActis instantia = null;

  /**
   * Hic valor viam reī huius classis facit.
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
   */
  @NonNull public static final Supplier <CuratorActis> faciendum =
    () -> ObjectUtils.firstNonNull(instantia, instantia = new CuratorActis());

  private CuratorActis() {
    super(Categoria.ACTUS, NuntiusConditoriActis.faciendum, ConstructorActi::new);
    nuntius.plurimumGarrio("Factus sum");
  }

  /**
   * {@inheritDoc}
   * @see Modus#definiam(String)
   * @see Vox#definiam(String)
   * @see Tempus#definiam(String)
   * @see Numeralis#definiam(String)
   * @see Persona#definiam(String)
   * @see Verbum#lemma
   */
  @Override public void allegam(@NonNull final String nomen, @NonNull final String descriptor) {
    switch (nomen) {
      case Modus.pittacium -> ((ConstructorActi) constructor).modus(Modus.definiam(descriptor));
      case Vox.pittacium -> ((ConstructorActi) constructor).vox(Vox.definiam(descriptor));
      case Tempus.pittacium -> ((ConstructorActi) constructor).tempus(Tempus.definiam(descriptor));
      case Numeralis.pittacium -> ((ConstructorActi) constructor).numeralis(Numeralis.definiam(descriptor));
      case Persona.pittacium -> ((ConstructorActi) constructor).persona(Persona.definiam(descriptor));
      case pittaciumLemmae -> constructor.lemma(descriptor.trim());
      default -> {
        allectioDefecit(nomen, descriptor);
        return;
      }
    }

    allectioFinita(nomen, descriptor);
  }

  /**
   * Classis {@link NuntiusConditoriActis} est vās classis {@link Nuntius} classī {@link CuratorActis}
   * @see CuratorActis
   */
  @Singleton
  private static final class NuntiusConditoriActis extends Nuntius {
    @Nullable private static NuntiusConditoriActis instantia = null;

    /**
     * Hic valor viam reī huius classis facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull private static final Supplier <NuntiusConditoriActis> faciendum =
            () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusConditoriActis());

    private NuntiusConditoriActis() {
      super(ParametriNuntii.para(CuratorActis.class));
    }
  }
}
