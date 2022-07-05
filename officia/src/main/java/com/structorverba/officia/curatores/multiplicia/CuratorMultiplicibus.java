package com.structorverba.officia.curatores.multiplicia;

import androidx.annotation.*;
import com.structorverba.officia.curatores.Curator;
import com.structorverba.officia.enumerationes.*;
import com.structorverba.officia.nuntii.Nuntius;
import com.structorverba.officia.verba.constructores.Constructor;
import com.structorverba.officia.verba.multiplicia.VerbumMultiplex;

import java.util.function.Supplier;

/**
 * Classis {@link CuratorMultiplicibus} est vās classis {@link Curator} classibus omnibus quibus classem {@link
 * VerbumMultiplex} extendit.
 * @param <Hoc> classis extenta classis {@link VerbumMultiplex}
 */
@SuppressWarnings("SpellCheckingInspection")
public abstract class CuratorMultiplicibus<Hoc extends VerbumMultiplex <Hoc>> extends Curator<Hoc> {
  /**
   * Hic valor reparesentātiōnem scrīpta lemmae dēsignat.
   */
  public static final @NonNull String pittaciumLemmae = "lemma";

  @NonNull protected final Constructor<Hoc> constructor;

  @Nullable protected Hoc hoc = null;

  /**
   * Hoc officium cōnstrūctōrem reī huius classis perpetrat.
   * @param nuntius valōrem {@link Curator#nuntius} supplet.
   */
  public CuratorMultiplicibus(@NonNull final Categoria ctgr, @NonNull final Supplier <? extends Nuntius> nuntius,
                              @NonNull final Supplier<Constructor<Hoc>> cnstr) {
    super(ctgr, nuntius);
    constructor = cnstr.get();
  }

  /**
   * Hic modus {@link Constructor#scriptio(String)} invocat.
   * @param scrpt valōrem indendum
   */
  public final void ut(@NonNull final String scrpt) {
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
  / * Hic modus hanc valōrem {@link Constructor} restituit.
    * @see  Constructor#restituo()
  / */
  public final void restituo() {
    constructor.restituo();
  }

  /**
   * Hic modus valōrem cognitum per valōre {@code nomen} cum valōre {@code descriptor} indit.
   * @param nomen      valōrem cognendum
   * @param descriptor valōrem indendum
   */
  public abstract void allegam(@NonNull final String nomen, @NonNull final String descriptor);
}
