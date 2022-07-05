package com.structorverba.officia.curatores.multiplicia;

import androidx.annotation.*;
import com.structorverba.officia.curatores.Curator;
import com.structorverba.officia.enumerationes.*;
import com.structorverba.officia.nuntii.*;
import com.structorverba.officia.verba.Verbum;
import com.structorverba.officia.verba.constructores.ConstructorPronominis;
import com.structorverba.officia.verba.multiplicia.Pronomen;
import jakarta.ejb.*;
import org.apache.commons.lang3.ObjectUtils;

import java.util.function.Supplier;

/**
 * Classis {@link CuratorPronominibus} est vās classis {@link Curator} classī {@link Pronomen}.
 * @see Pronomen
 * @see NuntiusConditoriPronominibus
 */
@SuppressWarnings("SpellCheckingInspection")
@Singleton
@DependsOn("NuntiusConditoriPronominibus")
public final class CuratorPronominibus extends CuratorMultiplicibus<Pronomen> {
  @Nullable private static CuratorPronominibus instantia = null;

  /**
   * Hic valor viam reī huius classis facit.
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
   */
  @NonNull public static final Supplier <CuratorPronominibus> faciendum =
    () -> ObjectUtils.firstNonNull(instantia, instantia = new CuratorPronominibus());

  private CuratorPronominibus() {
    super(Categoria.PRONOMEN, NuntiusConditoriPronominibus.faciendum, ConstructorPronominis::new);
    nuntius.plurimumGarrio("Factus sum");
  }

  /**
   * {@inheritDoc}
   * @see Specialitas#definiam(String)
   * @see Genus#definiam(String)
   * @see Casus#definiam(String)
   * @see Numeralis#definiam(String)
   * @see Verbum#lemma
   */
  @Override public void allegam(@NonNull final String nomen, @NonNull final String descriptor) {
    switch (nomen) {
      case Specialitas.pittacium -> ((ConstructorPronominis) constructor).specialitas(Specialitas.definiam(descriptor));
      case Genus.pittacium -> ((ConstructorPronominis) constructor).genus(Genus.definiam(descriptor));
      case Numeralis.pittacium -> ((ConstructorPronominis) constructor).numeralis(Numeralis.definiam(descriptor));
      case Persona.pittacium -> ((ConstructorPronominis) constructor).casus(Casus.definiam(descriptor));
      case pittaciumLemmae -> constructor.lemma(descriptor.trim());
      default -> {
        allectioDefecit(nomen, descriptor);
        return;
      }
    }

    allectioFinita(nomen, descriptor);
  }

  /**
   * Classis {@link NuntiusConditoriPronominibus} est vās classis {@link Nuntius} classī {@link CuratorPronominibus}
   * @see CuratorPronominibus
   */
  @Singleton
  private static final class NuntiusConditoriPronominibus extends Nuntius {
    @Nullable private static NuntiusConditoriPronominibus instantia = null;

    /**
     * Hic valor viam reī huius classis facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull private static final Supplier <NuntiusConditoriPronominibus> faciendum =
            () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusConditoriPronominibus());

    private NuntiusConditoriPronominibus() {
      super(ParametriNuntii.para(CuratorPronominibus.class));
    }
  }
}
