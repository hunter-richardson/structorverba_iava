package com.structorverba.officia.conditores.multiplicia;

import androidx.annotation.*;
import com.structorverba.officia.conditores.Conditor;
import com.structorverba.officia.enumerationes.*;
import com.structorverba.officia.nuntii.*;
import com.structorverba.officia.verba.Verbum;
import com.structorverba.officia.verba.multiplicia.Adiectivum;
import jakarta.ejb.*;
import org.apache.commons.lang3.*;

import java.util.function.Supplier;

/**
 * Classis {@link ConditorAdiectivis} est vās classis {@link Conditor} classī {@link Adiectivum}.
 * @see Adiectivum
 * @see NuntiusConditoriAdiectivis
 */
@SuppressWarnings("SpellCheckingInspection")
@Singleton
@DependsOn("NuntiusConditoriAdiectivis")
public final class ConditorAdiectivis extends ConditorMultiplicibus <Adiectivum> {
  @Nullable private static ConditorAdiectivis instantia = null;

  /**
   * Valor hic viam rei classis huiuc facit.
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
   */
  @NonNull public static final Supplier <ConditorAdiectivis> faciendum =
    () -> ObjectUtils.firstNonNull(instantia, instantia = new ConditorAdiectivis());

  private ConditorAdiectivis() {
    super(Categoria.ADIECTIVUM, NuntiusConditoriAdiectivis.faciendum, Adiectivum.ConstructorAdiectivi::new);
    nuntius.plurimumGarrio("Factus sum");
  }

  /**
   * {@inheritDoc}
   * @see Specialitas#definiam(String)
   * @see Genus#definiam(String)
   * @see Casus#definiam(String)
   * @see Numeralis#definiam(String)
   * @see Gradus#definiam(String)
   * @see Verbum#lemma
   */
  @Override public void allegam(@NonNull final String nomen, @NonNull final String descriptor) {
    switch (nomen) {
      case Specialitas.pittacium -> ((Adiectivum.ConstructorAdiectivi) constructor).specialitas(Specialitas.definiam(descriptor));
      case Genus.pittacium -> ((Adiectivum.ConstructorAdiectivi) constructor).genus(Genus.definiam(descriptor));
      case Numeralis.pittacium -> ((Adiectivum.ConstructorAdiectivi) constructor).numeralis(Numeralis.definiam(descriptor));
      case Persona.pittacium -> ((Adiectivum.ConstructorAdiectivi) constructor).casus(Casus.definiam(descriptor));
      case Gradus.pittacium -> ((Adiectivum.ConstructorAdiectivi) constructor).gradus(Gradus.definiam(descriptor));
      case pittaciumLemmae -> constructor.lemma(descriptor.trim());
      default -> {
        allectioDefecit(nomen, descriptor);
        return;
      }
    }

    allectioFinita(nomen, descriptor);
  }

  /**
   * Classis {@link NuntiusConditoriAdiectivis} est vās classis {@link Nuntius} classī {@link ConditorAdiectivis}
   * @see ConditorAdiectivis
   */
  @Singleton
  private static final class NuntiusConditoriAdiectivis extends Nuntius {
    @Nullable private static NuntiusConditoriAdiectivis instantia = null;

    /**
     * Valor hic viam rei classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull private static final Supplier <NuntiusConditoriAdiectivis> faciendum =
            () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusConditoriAdiectivis());

    private NuntiusConditoriAdiectivis() {
      super(ParametriNuntii.para(ConditorAdiectivis.class));
    }
  }
}
