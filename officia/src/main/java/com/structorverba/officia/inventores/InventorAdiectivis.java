package com.structorverba.officia.inventores;

import androidx.annotation.*;
import com.structorverba.officia.enumerationes.*;
import com.structorverba.officia.lectores.LectorMultiplicibus;
import com.structorverba.officia.nuntii.*;
import com.structorverba.officia.verba.multiplicia.Adiectivum;
import jakarta.ejb.*;
import org.apache.commons.lang3.ObjectUtils;

import java.util.function.*;

/**
 * Classis {@link InventorAdiectivis} est v\u0101s classis {@link Inventor} class\u012B {@link Adiectivum}.
 * @see Adiectivum
 * @see NuntiusInventoriAdiectivis
 */
@SuppressWarnings("SpellCheckingInspection")
@Singleton
@DependsOn("NuntiusInventoriAdiectivis")
public final class InventorAdiectivis extends Inventor <Adiectivum> {
  @Nullable private static InventorAdiectivis instantia = null;

  /**
   * Valor hic viam re\u012B classis huiuc facit.
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
   */
  @NonNull public static final Supplier <InventorAdiectivis> faciendum =
    () -> ObjectUtils.firstNonNull(instantia, instantia = new InventorAdiectivis());

  @NonNull private Specialitas specialitas = Specialitas.NULLUM;
  @NonNull private Genus       genus       = Genus.NULLUM;
  @NonNull private Numeralis   numeralis   = Numeralis.NULLUS;
  @NonNull private Casus       casus       = Casus.DERECTUS;
  @NonNull private Gradus      gradus      = Gradus.NULLUS;

  private InventorAdiectivis() {
    super(NuntiusInventoriAdiectivis.faciendum);
    nuntius.plurimumGarrio("Factus sum");
  }

  /**
   * @return Quaesti\u014Dnem quam r\u0113s classis {@link LectorMultiplicibus.LectorAdiectivis} ut\u0101tur r\u0113s classis {@link
   *   Adiectivum} perc\u014Dlere
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Predicate.html">Prediate</a>
   */
  @Override @NonNull
  public Predicate <Adiectivum> inquiram() {
    return adiectivum -> specialitas.equals(adiectivum.specialitas) &&
                         genus.equals(adiectivum.genus) &&
                         casus.equals(adiectivum.casus) &&
                         numeralis.equals(adiectivum.numeralis) &&
                         gradus.equals(adiectivum.gradus);
  }

  /**
   * {@inheritDoc}
   * @see Specialitas#NULLUM
   * @see Genus#NULLUM
   * @see Numeralis#NULLUS
   * @see Casus#DERECTUS
   * @see Gradus#NULLUS
   */
  @Override public void restituo() {
    specialitas = Specialitas.NULLUM;
    genus = Genus.NULLUM;
    numeralis = Numeralis.NULLUS;
    casus = Casus.DERECTUS;
    gradus = Gradus.NULLUS;
    nuntius.certioro("Restit\u016Btus sum");
  }

  /**
   * {@inheritDoc}
   * @param illud \u0113numer\u0101ti\u014Dnem indendam
   * @see Specialitas#ut(Enum)
   * @see Genus#ut(Enum)
   * @see Numeralis#ut(Enum)
   * @see Casus#ut(Enum)
   * @see Gradus#ut(Enum)
   */
  @Override protected void allegam(@NonNull final Enum <?> illud) {
    if (illud instanceof Specialitas) {
      specialitas = Specialitas.ut(illud);
      nuntius.garrio("Quaesti\u014Dn\u012B adi\u0113c\u012B conditi\u014Dnem novam:",
                     Specialitas.pittacium, illud);
    } else if (illud instanceof Genus) {
      genus = Genus.ut(illud);
      nuntius.garrio("Quaesti\u014Dn\u012B adi\u0113c\u012B conditi\u014Dnem novam:",
                     Genus.pittacium, illud);
    } else if (illud instanceof Numeralis) {
      numeralis = Numeralis.ut(illud);
      nuntius.garrio("Quaesti\u014Dn\u012B adi\u0113c\u012B conditi\u014Dnem novam:",
                     Numeralis.pittacium, illud);
    } else if (illud instanceof Casus) {
      casus = Casus.ut(illud);
      nuntius.garrio("Quaesti\u014Dn\u012B adi\u0113c\u012B conditi\u014Dnem novam:",
                     Casus.pittacium, illud);
    } else if (illud instanceof Gradus) {
      gradus = Gradus.ut(illud);
      nuntius.garrio("Quaesti\u014Dn\u012B adi\u0113c\u012B conditi\u014Dnem novam:",
                     Gradus.pittacium, illud);
    } else {
      nuntius.moneo("Adiect\u012Bv\u014D inqu\u012Bs\u012Bti\u014D adiect\u012Bv\u014D inop\u012Bn\u0101ta \u016Bsa'st:",
                    illud);
    }
  }

  /**
   * Classis {@link NuntiusInventoriAdiectivis} est v\u0101s classis {@link Nuntius} class\u012B {@link InventorAdiectivis}
   * @see InventorAdiectivis
   */
  @Singleton
  private static final class NuntiusInventoriAdiectivis extends Nuntius {
    @Nullable private static NuntiusInventoriAdiectivis instantia = null;

    /**
     * Valor hic viam re\u012B classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull private static final Supplier <NuntiusInventoriAdiectivis> faciendum =
            () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusInventoriAdiectivis());

    private NuntiusInventoriAdiectivis() {
      super(ParametriNuntii.para(InventorAdiectivis.class));
    }
  }
}