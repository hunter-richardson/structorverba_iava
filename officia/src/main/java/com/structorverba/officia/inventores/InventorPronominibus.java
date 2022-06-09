package com.structorverba.officia.inventores;

import com.structorverba.officia.lectores.LectorMultiplicibus;
import com.structorverba.officia.miscella.Utilitas;
import com.structorverba.officia.nuntii.Nuntius;
import com.structorverba.officia.verba.multiplicia.Pronomen;
import com.structorverba.officia.enumerationes.*;

import org.apache.commons.lang3.ObjectUtils;
import androidx.annotation.*;

import javax.ejb.*;
import java.util.function.*;

/**
 * Classis {@link InventorPronominibus} est v\u0113s classis {@link Inventor} class\u012B {@link Pronomen}.
 * @see Pronomen
 * @see Nuntius.NuntiusInventoriPronominibus
 */
@SuppressWarnings("SpellCheckingInspection")
@Singleton
@DependsOn("NuntiusInventoriPronominibus")
public final class InventorPronominibus extends Inventor <Pronomen> {
  @Nullable private static InventorPronominibus instantia = null;

  /**
   * Valor hic viam re\u012B classis huiuc facit.
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
   */
  @NonNull public static final Supplier <InventorPronominibus> fac =
    ( ) -> ObjectUtils.firstNonNull(instantia, instantia = new InventorPronominibus());

  @NonNull private Specialitas specialitas = Specialitas.NULLUM;
  @NonNull private Genus       genus       = Genus.NULLUM;
  @NonNull private Numeralis   numeralis   = Numeralis.NULLUS;
  @NonNull private Casus       casus       = Casus.DERECTUS;

  private InventorPronominibus( ) {
    super(Nuntius.NuntiusInventoriPronominibus.fac);
    nuntius.plurimumGarrio("Factus sum");
  }

  /**
   * @return Quaesti\u014Dnem quam r\u0113s classis {@link LectorMultiplicibus .LectorPronominibus} \u016Bt\u016Btur r\u0113s classis {@link
   *   Pronomen} perc\u014Dlere
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Predicate.html">Prediate</a>
   */
  @Override @NonNull
  public Predicate <@NonNull Pronomen> inquiram() {
    return pronomen -> specialitas.equals(pronomen.specialitas)
                       && genus.equals(pronomen.genus)
                       && casus.equals(pronomen.casus)
                       && numeralis.equals(pronomen.numeralis);
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
    nuntius.certioro("Restit\u016Btus sum");
  }

  /**
   * {@inheritDoc}
   * @param illud \u0113numer\u016Btionem indendam
   * @see Specialitas#ut(Enum)
   * @see Genus#ut(Enum)
   * @see Numeralis#ut(Enum)
   * @see Casus#ut(Enum)
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
    } else {
      nuntius.moneo(
        Utilitas.primamCapitaneamScribo(Categoria.PRONOMEN.scriptio.replaceLast('a', '\u012B')),
                    "inqu\u012Bs\u012Bti\u014D inop\u012Bn\u016Bta \u016Bsa'st:", illud);
    }
  }
}