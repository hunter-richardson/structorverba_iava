package com.structorverba.officia.curatores.multiplicia;

import androidx.annotation.*;
import com.structorverba.officia.curatores.Curator;
import com.structorverba.officia.enumerationes.*;
import com.structorverba.officia.nuntii.*;
import com.structorverba.officia.verba.Verbum;
import com.structorverba.officia.verba.constructores.ConstructorAdiectivi;
import com.structorverba.officia.verba.multiplicia.Adiectivum;
import jakarta.ejb.*;
import org.apache.commons.lang3.ObjectUtils;

import java.util.function.Supplier;

/**
 * Classis {@link CuratorAdiectivis} est vās classis {@link Curator} classī {@link Adiectivum}.
 * @see Adiectivum
 * @see NuntiusConditoriAdiectivis
 */
@SuppressWarnings("SpellCheckingInspection")
@Singleton
@DependsOn("NuntiusConditoriAdiectivis")
public final class CuratorAdiectivis extends CuratorMultiplicibus<Adiectivum> {
  @Nullable private static CuratorAdiectivis instantia = null;

  /**
   * Hic valor viam rei huius classis facit.
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
   */
  @NonNull public static final Supplier <CuratorAdiectivis> faciendum =
    () -> ObjectUtils.firstNonNull(instantia, instantia = new CuratorAdiectivis());

  private CuratorAdiectivis() {
    super(Categoria.ADIECTIVUM, NuntiusConditoriAdiectivis.faciendum, ConstructorAdiectivi::new);
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
      case Specialitas.pittacium -> ((ConstructorAdiectivi) constructor).specialitas(Specialitas.definiam(descriptor));
      case Genus.pittacium -> ((ConstructorAdiectivi) constructor).genus(Genus.definiam(descriptor));
      case Numeralis.pittacium -> ((ConstructorAdiectivi) constructor).numeralis(Numeralis.definiam(descriptor));
      case Persona.pittacium -> ((ConstructorAdiectivi) constructor).casus(Casus.definiam(descriptor));
      case Gradus.pittacium -> ((ConstructorAdiectivi) constructor).gradus(Gradus.definiam(descriptor));
      case pittaciumLemmae -> constructor.lemma(descriptor.trim());
      default -> {
        allectioDefecit(nomen, descriptor);
        return;
      }
    }

    allectioFinita(nomen, descriptor);
  }

  /**
   * Classis {@link NuntiusConditoriAdiectivis} est vās classis {@link Nuntius} classī {@link CuratorAdiectivis}
   * @see CuratorAdiectivis
   */
  @Singleton
  private static final class NuntiusConditoriAdiectivis extends Nuntius {
    @Nullable private static NuntiusConditoriAdiectivis instantia = null;

    /**
     * Hic valor viam rei huius classis facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull private static final Supplier <NuntiusConditoriAdiectivis> faciendum =
            () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusConditoriAdiectivis());

    private NuntiusConditoriAdiectivis() {
      super(ParametriNuntii.para(CuratorAdiectivis.class));
    }
  }
}
