package com.structorverba.officia.inventores;

import androidx.annotation.*;
import com.structorverba.officia.enumerationes.*;
import com.structorverba.officia.lectores.LectorMultiplicibus;
import com.structorverba.officia.nuntii.*;
import com.structorverba.officia.verba.multiplicia.Actus;
import jakarta.ejb.*;
import org.apache.commons.lang3.ObjectUtils;

import java.util.function.*;

/**
 * Classis {@link InventorActis} est v\u0101s classis {@link Inventor} class\u012B {@link Actus}.
 * @see Actus
 * @see NuntiusInventoriActis
 */
@SuppressWarnings("SpellCheckingInspection")
@Singleton
@DependsOn("NuntiusInventoriActis")
public final class InventorActis extends Inventor <Actus> {
  @Nullable private static InventorActis instantia = null;

  /**
   * Valor hic viam re\u012B classis huiuc facit.
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
   */
  @NonNull public static final Supplier <InventorActis> fac =
    () -> ObjectUtils.firstNonNull(instantia, instantia = new InventorActis());

  @NonNull private Vox       vox       = Vox.NULLA;
  @NonNull private Tempus    tempus    = Tempus.INTEMPORALE;
  @NonNull private Numeralis numeralis = Numeralis.NULLUS;
  @NonNull private Persona   persona   = Persona.NULLA;
  @NonNull private Modus     modus     = Modus.NULLUS;

  private InventorActis() {
    super(NuntiusInventoriActis.fac);
    nuntius.plurimumGarrio("Factus sum");
  }

  /**
   * @return Quaesti\u014Dnem quam r\u0113s classis {@link LectorMultiplicibus.LectorActis} \u016Bt\u0101tur r\u0113s classis {@link Actus}
   *   perc\u014Dlere
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Predicate.html">Prediate</a>
   */
  @Override @NonNull
  public Predicate <Actus> inquiram() {
    return actum -> modus.equals(actum.modus) &&
                    vox.equals(actum.vox) &&
                    tempus.equals(actum.tempus) &&
                    numeralis.equals(actum.numeralis) &&
                    persona.equals(actum.persona);
  }

  /**
   * {@inheritDoc}
   * @see Vox#NULLA
   * @see Tempus#INTEMPORALE
   * @see Numeralis#NULLUS
   * @see Persona#NULLA
   * @see Modus#NULLUS
   */
  @Override public void restituo() {
    vox = Vox.NULLA;
    tempus = Tempus.INTEMPORALE;
    numeralis = Numeralis.NULLUS;
    persona = Persona.NULLA;
    modus = Modus.NULLUS;
    nuntius.certioro("Restit\u016Btus sum");
  }

  /**
   * {@inheritDoc}
   * @param illud \u0113numer\u0101ti\u014Dnem indendam
   * @see Vox#ut(Enum)
   * @see Tempus#ut(Enum)
   * @see Numeralis#ut(Enum)
   * @see Persona#ut(Enum)
   * @see Modus#ut(Enum)
   */
  @Override protected void allegam(@NonNull final Enum <?> illud) {
    if (illud instanceof Vox) {
      vox = Vox.ut(illud);
      nuntius.garrio("Quaestion\u012B adi\u0113c\u012B conditi\u014Dnem novam:",
                     Vox.pittacium, illud);
    } else if (illud instanceof Tempus) {
      tempus = Tempus.ut(illud);
      nuntius.garrio("Quaestion\u012B adi\u0113c\u012B conditi\u014Dnem novam:",
                     Tempus.pittacium, illud);
    } else if (illud instanceof Numeralis) {
      numeralis = Numeralis.ut(illud);
      nuntius.garrio("Quaestion\u012B adi\u0113c\u012B conditi\u014Dnem novam:",
                     Numeralis.pittacium, illud);
    } else if (illud instanceof Persona) {
      persona = Persona.ut(illud);
      nuntius.garrio("Quaestion\u012B adi\u0113c\u012B conditi\u014Dnem novam:",
                     Persona.pittacium, illud);
    } else if (illud instanceof Modus) {
      modus = Modus.ut(illud);
      nuntius.garrio("Quaestion\u012B adi\u0113c\u012B conditi\u014Dnem novam:",
                     Modus.pittacium, illud);
    } else {
      nuntius.moneo("\u0102ct\u014D inqu\u012Bs\u012Bti\u014D inop\u012Bn\u0101ta \u016Bsa'st:", illud);
    }
  }

  /**
   * Classis {@link NuntiusInventoriActis} est v\u0101s classis {@link Nuntius} class\u012B {@link InventorActis}
   * @see InventorActis
   */
  @Singleton
  private static final class NuntiusInventoriActis extends Nuntius {
    @Nullable private static NuntiusInventoriActis instantia = null;

    /**
     * Valor hic viam re\u012B classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull private static final Supplier <NuntiusInventoriActis> fac =
            () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusInventoriActis());

    private NuntiusInventoriActis() {
      super(ParametriNuntii.para(InventorActis.class));
    }
  }
}