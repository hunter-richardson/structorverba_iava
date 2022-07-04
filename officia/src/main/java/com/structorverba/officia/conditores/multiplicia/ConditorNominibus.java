package com.structorverba.officia.conditores.multiplicia;

import androidx.annotation.*;
import com.structorverba.officia.conditores.Conditor;
import com.structorverba.officia.enumerationes.*;
import com.structorverba.officia.nuntii.*;
import com.structorverba.officia.verba.Verbum;
import com.structorverba.officia.verba.multiplicia.Nomen;
import jakarta.ejb.*;
import org.apache.commons.lang3.*;

import java.util.function.Supplier;

/**
 * Classis {@link ConditorNominibus} est vās classis {@link Conditor} classī {@link Nomen}.
 * @see Nomen
 * @see NuntiusConditoriNominibus
 */
@SuppressWarnings("SpellCheckingInspection")
@Singleton
@DependsOn("NuntiusConditoriNominibus")
public final class ConditorNominibus extends ConditorMultiplicibus <Nomen> {
  @Nullable private static ConditorNominibus instantia = null;

  /**
   * Valor hic viam reī classis huiuc facit.
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
   */
  @NonNull public static final Supplier <ConditorNominibus> faciendum =
    () -> ObjectUtils.firstNonNull(instantia, instantia = new ConditorNominibus());

  private ConditorNominibus() {
    super(Categoria.NOMEN, NuntiusConditoriNominibus.faciendum, Nomen.ConstructorNominis::new);
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
      case Specialitas.pittacium -> ((Nomen.ConstructorNominis) constructor).specialitas(Specialitas.definiam(descriptor));
      case Genus.pittacium -> ((Nomen.ConstructorNominis) constructor).genus(Genus.definiam(descriptor));
      case Numeralis.pittacium -> ((Nomen.ConstructorNominis) constructor).numeralis(Numeralis.definiam(descriptor));
      case Persona.pittacium -> ((Nomen.ConstructorNominis) constructor).casus(Casus.definiam(descriptor));
      case Tempus.pittacium -> ((Nomen.ConstructorNominis) constructor).tempus(Tempus.definiam(descriptor));
      case pittaciumLemmae -> constructor.lemma(descriptor.trim());
      default -> {
        allectioDefecit(nomen, descriptor);
        return;
      }
    }

    allectioFinita(nomen, descriptor);
  }

  /**
   * Classis {@link NuntiusConditoriNominibus} est vās classis {@link Nuntius} classī {@link ConditorNominibus}
   * @see ConditorNominibus
   */
  @Singleton
  private static final class NuntiusConditoriNominibus extends Nuntius {
    @Nullable private static NuntiusConditoriNominibus instantia = null;

    /**
     * Valor hic viam reī classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull private static final Supplier <NuntiusConditoriNominibus> faciendum =
            () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusConditoriNominibus());

    private NuntiusConditoriNominibus() {
      super(ParametriNuntii.para(ConditorNominibus.class));
    }
  }
}
