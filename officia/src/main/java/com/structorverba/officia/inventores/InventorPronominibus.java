package com.structorverba.officia.inventores;

import androidx.annotation.*;
import com.structorverba.officia.enumerationes.*;
import com.structorverba.officia.lectores.LectorMultiplicibus;
import com.structorverba.officia.nuntii.*;
import com.structorverba.officia.verba.multiplicia.Pronomen;
import jakarta.ejb.*;
import org.apache.commons.lang3.ObjectUtils;

import java.util.function.*;

/**
 * Classis {@link InventorPronominibus} est vēs classis {@link Inventor} classī {@link Pronomen}.
 * @see Pronomen
 * @see NuntiusInventoriPronominibus
 */
@SuppressWarnings("SpellCheckingInspection")
@Singleton
@DependsOn("NuntiusInventoriPronominibus")
public final class InventorPronominibus extends Inventor <Pronomen> {
  @Nullable private static InventorPronominibus instantia = null;

  /**
   * Hic valor viam reī huius classis facit.
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
   */
  @NonNull public static final Supplier <InventorPronominibus> faciendum =
    () -> ObjectUtils.firstNonNull(instantia, instantia = new InventorPronominibus());

  @NonNull private Specialitas specialitas = Specialitas.NULLUM;
  @NonNull private Genus       genus       = Genus.NULLUM;
  @NonNull private Numeralis   numeralis   = Numeralis.NULLUS;
  @NonNull private Casus       casus       = Casus.DERECTUS;

  private InventorPronominibus() {
    super(NuntiusInventoriPronominibus.faciendum);
    nuntius.plurimumGarrio("Factus sum");
  }

  /**
   * @return Quaestiōnem quam rēs classis {@link LectorMultiplicibus.LectorPronominibus} ūtūtur rēs classis {@link
   *   Pronomen} percōlere
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Predicate.html">Prediate</a>
   */
  @Override @NonNull
  public Predicate <Pronomen> inquiram() {
    return pronomen -> specialitas.equals(pronomen.specialitas) &&
                       genus.equals(pronomen.genus) &&
                       casus.equals(pronomen.casus) &&
                       numeralis.equals(pronomen.numeralis);
  }

  /**
   * {@inheritDoc}
   * @see Specialitas#NULLUM
   * @see Genus#NULLUM
   * @see Numeralis#NULLUS
   * @see Casus#DERECTUS
   */
  @Override public void restituo() {
    specialitas = Specialitas.NULLUM;
    genus = Genus.NULLUM;
    numeralis = Numeralis.NULLUS;
    casus = Casus.DERECTUS;
    nuntius.certioro("Restitūtus sum");
  }

  /**
   * {@inheritDoc}
   * @param illud ēnumerūtionem indendam
   * @see Specialitas#ut(Enum)
   * @see Genus#ut(Enum)
   * @see Numeralis#ut(Enum)
   * @see Casus#ut(Enum)
   */
  @Override protected void allegam(@NonNull final Enum <?> illud) {
    if (illud instanceof Specialitas) {
      specialitas = Specialitas.ut(illud);
      nuntius.garrio("Quaestiōnī adiēcī conditiōnem novam:", Specialitas.pittacium, illud);
    } else if (illud instanceof Genus) {
      genus = Genus.ut(illud);
      nuntius.garrio("Quaestiōnī adiēcī conditiōnem novam:", Genus.pittacium, illud);
    } else if (illud instanceof Numeralis) {
      numeralis = Numeralis.ut(illud);
      nuntius.garrio("Quaestiōnī adiēcī conditiōnem novam:", Numeralis.pittacium, illud);
    } else if (illud instanceof Casus) {
      casus = Casus.ut(illud);
      nuntius.garrio("Quaestiōnī adiēcī conditiōnem novam:", Casus.pittacium, illud);
    } else {
      nuntius.moneo(Categoria.PRONOMEN.declina(Casus.DATIVUS, Numeralis.SINGULARIS, true),
                    "Prōnōminī inquīsītiō inopīnūta ūsa'st:", illud);
    }
  }

  /**
   * Classis {@link NuntiusInventoriPronominibus} est vās classis {@link Nuntius} classī {@link InventorPronominibus}
   * @see InventorPronominibus
   */
  @Singleton
  private static final class NuntiusInventoriPronominibus extends Nuntius {
    @Nullable private static NuntiusInventoriPronominibus instantia = null;

    /**
     * Hic valor viam reī huius classis facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull private static final Supplier <NuntiusInventoriPronominibus> faciendum =
            () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusInventoriPronominibus());

    private NuntiusInventoriPronominibus() {
      super(ParametriNuntii.para(InventorPronominibus.class));
    }
  }
}