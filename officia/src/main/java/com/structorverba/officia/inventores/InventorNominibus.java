package com.structorverba.officia.inventores;

import androidx.annotation.*;
import com.structorverba.officia.enumerationes.*;
import com.structorverba.officia.lectores.LectorMultiplicibus;
import com.structorverba.officia.nuntii.*;
import com.structorverba.officia.verba.multiplicia.Nomen;
import jakarta.ejb.*;
import org.apache.commons.lang3.ObjectUtils;

import java.util.function.*;

/**
 * Classis {@link InventorNominibus} est vās classis {@link Inventor} classī {@link Nomen}.
 * @see Nomen
 * @see NuntiusInventoriNominibus
 */
@SuppressWarnings("SpellCheckingInspection")
@Singleton
@DependsOn("NuntiusInventoriAdiectivis")
public final class InventorNominibus extends Inventor <Nomen> {
  @Nullable private static InventorNominibus instantia = null;

  /**
   * Valor hic viam reī classis huiuc facit.
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
   */
  @NonNull public static final Supplier <InventorNominibus> faciendum =
    () -> ObjectUtils.firstNonNull(instantia, instantia = new InventorNominibus());

  @NonNull private Specialitas specialitas = Specialitas.NULLUM;
  @NonNull private Genus       genus       = Genus.NULLUM;
  @NonNull private Numeralis   numeralis   = Numeralis.NULLUS;
  @NonNull private Casus       casus       = Casus.DERECTUS;
  @NonNull private Tempus      tempus      = Tempus.INTEMPORALE;

  private InventorNominibus() {
    super(NuntiusInventoriNominibus.faciendum);
    nuntius.plurimumGarrio("Factus sum");
  }

  /**
   * @return Quaestionem quam rēs classis {@link LectorMultiplicibus.LectorNominibus} ūtātur rēs classis {@link Nomen}
   *   percolere
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Predicate.html">Prediate</a>
   */
  @Override @NonNull
  public Predicate <Nomen> inquiram() {
    return nomen -> specialitas.equals(nomen.specialitas) &&
                    genus.equals(nomen.genus) &&
                    casus.equals(nomen.casus) &&
                    numeralis.equals(nomen.numeralis) &&
                    tempus.equals(nomen.tempus);
  }

  /**
   * {@inheritDoc}
   * @see Specialitas#NULLUM
   * @see Genus#NULLUM
   * @see Numeralis#NULLUS
   * @see Casus#DERECTUS
   * @see Tempus#INTEMPORALE
   */
  @Override public void restituo() {
    specialitas = Specialitas.NULLUM;
    genus = Genus.NULLUM;
    numeralis = Numeralis.NULLUS;
    casus = Casus.DERECTUS;
    tempus = Tempus.INTEMPORALE;
    nuntius.certioro("Restitūtus sum");
  }

  /**
   * {@inheritDoc}
   * @param illud ēnumerātiōnem indendam
   * @see Specialitas#ut(Enum)
   * @see Genus#ut(Enum)
   * @see Numeralis#ut(Enum)
   * @see Casus#ut(Enum)
   * @see Tempus#ut(Enum)
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
    } else if (illud instanceof Tempus) {
      tempus = Tempus.ut(illud);
      nuntius.garrio("Quaestiōnī adiēcī conditiōnem novam:", Tempus.pittacium, illud);
    } else {
      nuntius.moneo(Categoria.NOMEN.declina(Casus.DATIVUS, Numeralis.SINGULARIS, true),
                    "inquīsītiō nōminī inopīnāta ūsa'st:", illud);
    }
  }

  /**
   * Classis {@link NuntiusInventoriNominibus} est vās classis {@link Nuntius} classī {@link InventorNominibus}
   * @see InventorNominibus
   */
  @Singleton
  private static final class NuntiusInventoriNominibus extends Nuntius {
    @Nullable private static NuntiusInventoriNominibus instantia = null;

    /**
     * Valor hic viam reī classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull private static final Supplier <NuntiusInventoriNominibus> faciendum =
            () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusInventoriNominibus());

    private NuntiusInventoriNominibus() {
      super(ParametriNuntii.para(InventorNominibus.class));
    }
  }
}
