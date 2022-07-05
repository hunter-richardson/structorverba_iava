package com.structorverba.officia.curatores.multiplicia;

import androidx.annotation.*;
import com.structorverba.officia.curatores.Curator;
import com.structorverba.officia.enumerationes.*;
import com.structorverba.officia.nuntii.*;
import com.structorverba.officia.verba.Verbum;
import com.structorverba.officia.verba.constructores.ConstructorNominis;
import com.structorverba.officia.verba.multiplicia.Nomen;
import jakarta.ejb.*;
import org.apache.commons.lang3.ObjectUtils;

import java.util.function.Supplier;

/**
 * Classis {@link CuratorNominibus} est vās classis {@link Curator} classī {@link Nomen}.
 * @see Nomen
 * @see NuntiusConditoriNominibus
 */
@SuppressWarnings("SpellCheckingInspection")
@Singleton
@DependsOn("NuntiusConditoriNominibus")
public final class CuratorNominibus extends CuratorMultiplicibus<Nomen> {
  @Nullable private static CuratorNominibus instantia = null;

  /**
   * Hic valor viam reī huius classis facit.
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
   */
  @NonNull public static final Supplier <CuratorNominibus> faciendum =
    () -> ObjectUtils.firstNonNull(instantia, instantia = new CuratorNominibus());

  private CuratorNominibus() {
    super(Categoria.NOMEN, NuntiusConditoriNominibus.faciendum, ConstructorNominis::new);
    nuntius.plurimumGarrio("Factus sum");
  }

  /**
   * {@inheritDoc}
   * @see Specialitas#definiam(String)
   * @see Genus#definiam(String)
   * @see Casus#definiam(String)
   * @see Numeralis#definiam(String)
   * @see Tempus#definiam(String)
   * @see Verbum#lemma
   */
  @Override public void allegam(@NonNull final String nomen, @NonNull final String descriptor) {
    switch (nomen) {
      case Specialitas.pittacium -> ((ConstructorNominis) constructor).specialitas(Specialitas.definiam(descriptor));
      case Genus.pittacium -> ((ConstructorNominis) constructor).genus(Genus.definiam(descriptor));
      case Numeralis.pittacium -> ((ConstructorNominis) constructor).numeralis(Numeralis.definiam(descriptor));
      case Persona.pittacium -> ((ConstructorNominis) constructor).casus(Casus.definiam(descriptor));
      case Tempus.pittacium -> ((ConstructorNominis) constructor).tempus(Tempus.definiam(descriptor));
      case pittaciumLemmae -> constructor.lemma(descriptor.trim());
      default -> {
        allectioDefecit(nomen, descriptor);
        return;
      }
    }

    allectioFinita(nomen, descriptor);
  }

  /**
   * Classis {@link NuntiusConditoriNominibus} est vās classis {@link Nuntius} classī {@link CuratorNominibus}
   * @see CuratorNominibus
   */
  @Singleton
  private static final class NuntiusConditoriNominibus extends Nuntius {
    @Nullable private static NuntiusConditoriNominibus instantia = null;

    /**
     * Hic valor viam reī huius classis facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull private static final Supplier <NuntiusConditoriNominibus> faciendum =
            () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusConditoriNominibus());

    private NuntiusConditoriNominibus() {
      super(ParametriNuntii.para(CuratorNominibus.class));
    }
  }
}
