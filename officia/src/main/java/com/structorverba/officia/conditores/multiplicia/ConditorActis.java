package com.structorverba.officia.conditores.multiplicia;

import androidx.annotation.*;
import com.structorverba.officia.conditores.Conditor;
import com.structorverba.officia.enumerationes.*;
import com.structorverba.officia.nuntii.*;
import com.structorverba.officia.verba.Verbum;
import com.structorverba.officia.verba.multiplicia.Actus;
import jakarta.ejb.*;
import org.apache.commons.lang3.*;

import java.util.function.Supplier;


/**
 * Classis {@link ConditorActis} est vās classis {@link Conditor} classī {@link Actus}.
 * @see Actus
 * @see NuntiusConditoriActis
 */
@SuppressWarnings("SpellCheckingInspection")
@Singleton
@DependsOn("NuntiusConditoriActis")
public final class ConditorActis extends ConditorMultiplicibus <Actus> {
  @Nullable private static ConditorActis instantia = null;

  /**
   * Valor hic viam reī classis huiuc facit.
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
   */
  @NonNull public static final Supplier <ConditorActis> faciendum =
    () -> ObjectUtils.firstNonNull(instantia, instantia = new ConditorActis());

  private ConditorActis() {
    super(Categoria.ACTUS, NuntiusConditoriActis.faciendum, Actus.ConstructorActi::new);
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
      case Modus.pittacium -> ((Actus.ConstructorActi) constructor).modus(Modus.definiam(descriptor));
      case Vox.pittacium -> ((Actus.ConstructorActi) constructor).vox(Vox.definiam(descriptor));
      case Tempus.pittacium -> ((Actus.ConstructorActi) constructor).tempus(Tempus.definiam(descriptor));
      case Numeralis.pittacium -> ((Actus.ConstructorActi) constructor).numeralis(Numeralis.definiam(descriptor));
      case Persona.pittacium -> ((Actus.ConstructorActi) constructor).persona(Persona.definiam(descriptor));
      case pittaciumLemmae -> constructor.lemma(descriptor.trim());
      default -> {
        allectioDefecit(nomen, descriptor);
        return;
      }
    }

    allectioFinita(nomen, descriptor);
  }

  /**
   * Classis {@link NuntiusConditoriActis} est vās classis {@link Nuntius} classī {@link ConditorActis}
   * @see ConditorActis
   */
  @Singleton
  private static final class NuntiusConditoriActis extends Nuntius {
    @Nullable private static NuntiusConditoriActis instantia = null;

    /**
     * Valor hic viam reī classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull private static final Supplier <NuntiusConditoriActis> faciendum =
            () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusConditoriActis());

    private NuntiusConditoriActis() {
      super(ParametriNuntii.para(ConditorActis.class));
    }
  }
}
