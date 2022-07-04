package com.structorverba.officia.conditores.multiplicia;

import androidx.annotation.*;
import com.structorverba.officia.conditores.Conditor;
import com.structorverba.officia.enumerationes.*;
import com.structorverba.officia.nuntii.Nuntius;
import com.structorverba.officia.verba.multiplicia.VerbumMultiplex;

import java.util.function.Supplier;

/**
 * Classis {@link ConditorMultiplicibus} est vās classis {@link Conditor} classibus omnibus quibus classem {@link
 * VerbumMultiplex} extendit.
 * @param <Hoc> classis extenta classis {@link VerbumMultiplex}
 */
@SuppressWarnings("SpellCheckingInspection")
public abstract class ConditorMultiplicibus <Hoc extends VerbumMultiplex <Hoc>> extends Conditor <Hoc> {
  /**
   * Valor hic reparesentātiōnem scrīpta lemmae dēsignat.
   */
  public static final @NonNull String pittaciumLemmae = "lemma";

  @NonNull protected final VerbumMultiplex.Constructor<Hoc> constructor;

  @Nullable protected Hoc hoc = null;

  /**
   * Officium hoc cōnstrūctōrem reī classis huius perpetrat.
   * @param nuntius valōrem {@link Conditor#nuntius} supplet.
   */
  public ConditorMultiplicibus(@NonNull final Categoria ctgr, @NonNull final Supplier <? extends Nuntius> nuntius,
                               @NonNull final Supplier<VerbumMultiplex.Constructor<Hoc>> cnstr) {
    super(ctgr, nuntius);
    constructor = cnstr.get();
  }

  /**
   * Modus hic {@link VerbumMultiplex.Constructor#scriptio(String)} invocat.
   * @param scrpt valōrem indendum
   */
  protected final void ut(@NonNull final String scrpt) {
    constructor.scriptio(scrpt);
    nuntius.garrio("Cōntrūctiōnī adiecī conditiōnem novam: scrīptu'st", scrpt);
  }

  @Override
  public final Hoc condam() {
    if(constructor.paratus()) {
      final Hoc hoc = constructor.build();
      refero(hoc);
      return hoc;
    } else {
      nuntius.moneo(categoria.declina(Casus.GENITIVUS, Numeralis.PLURALIS, true),
                    "prōductiō fōrmae nūllae prōcessit.");
      return null;
    }
  }

  protected final void allectioDefecit(@NonNull final String nomen, @NonNull final String descriptor) {
    nuntius.moneo(categoria.declina(Casus.GENITIVUS, Numeralis.PLURALIS, true),
                  "attribūta inopīnata ūsa'st", nomen, descriptor);
  }

  protected final void allectioFinita(@NonNull final String nomen, @NonNull final String descriptor) {
    nuntius.garrio("Cōntrūctiōnī adiēcī conditiōnem novam:", nomen, descriptor);
  }

  /**
   * Modus hic valōrem cognitum per valōre {@code nomen} cum valōre {@code descriptor} indit.
   * @param nomen      valōrem cognendum
   * @param descriptor valōrem indendum
   */
  protected abstract void allegam(@NonNull final String nomen, @NonNull final String descriptor);
}
