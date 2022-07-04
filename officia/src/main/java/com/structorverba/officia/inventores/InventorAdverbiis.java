package com.structorverba.officia.inventores;

import androidx.annotation.*;
import com.structorverba.officia.enumerationes.*;
import com.structorverba.officia.lectores.LectorMultiplicibus;
import com.structorverba.officia.nuntii.*;
import com.structorverba.officia.verba.multiplicia.Adverbium;
import jakarta.ejb.*;
import org.apache.commons.lang3.ObjectUtils;

import java.util.function.*;

/**
 * Classis {@link InventorAdverbiis} est vās classis {@link Inventor} classī {@link Adverbium}.
 * @see Adverbium
 * @see NuntiusInventoriAdverbiis
 */
@SuppressWarnings("SpellCheckingInspection")
@Singleton
@DependsOn("NuntiusInventoriAdverbiis")
public class InventorAdverbiis extends Inventor <Adverbium> {
  @Nullable private static InventorAdverbiis instantia = null;

  /**
   * Valor hic viam reī classis huiuc facit.
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
   */
  @NonNull public static final Supplier <InventorAdverbiis> faciendum =
    () -> ObjectUtils.firstNonNull(instantia, instantia = new InventorAdverbiis());

  @NonNull private Gradus gradus = Gradus.NULLUS;

  private InventorAdverbiis() {
    super(NuntiusInventoriAdverbiis.faciendum);
    nuntius.plurimumGarrio("Factus sum");
  }

  /**
   * @return Quaestiīnem quam rēs classis {@link LectorMultiplicibus.LectorAdverbiis} ūtātur rēs classis {@link
   *   Adverbium} percīlere
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Predicate.html">Prediate</a>
   */
  @Override @NonNull
  public Predicate <Adverbium> inquiram() {
    return adverbium -> gradus.equals(adverbium.gradus);
  }

  /**
   * Modus hic rem hanc restituit.
   * @see Gradus#NULLUS
   */
  @Override public void restituo() {
    gradus = Gradus.NULLUS;
  }

  /**
   * Modus hic ēnumerātiīnem singulum {@code illud} reī huic indit.
   * @param illud ēnumerātiīnem indendam
   * @see Gradus#ut(Enum)
   */
  @Override protected void allegam(Enum <?> illud) {
    if (illud instanceof Gradus) {
      gradus = Gradus.ut(illud);
      nuntius.garrio("Quaestiōnī adiēcī conditiōnem novam:", Gradus.pittacium, illud);
    } else {
      nuntius.moneo(Categoria.ADVERBIUM.declina(Casus.DATIVUS, Numeralis.SINGULARIS, true),
                    "inquīsītiō adiectīvō inopīnāta ūsa'st:", illud);
    }
  }

  /**
   * Classis {@link NuntiusInventoriAdverbiis} est vās classis {@link Nuntius} classī {@link InventorNominibus}
   * @see InventorNominibus
   */
  @Singleton
  private static final class NuntiusInventoriAdverbiis extends Nuntius {
    @Nullable private static NuntiusInventoriAdverbiis instantia = null;

    /**
     * Valor hic viam reī classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull private static final Supplier <NuntiusInventoriAdverbiis> faciendum =
            () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusInventoriAdverbiis());

    private NuntiusInventoriAdverbiis() {
      super(ParametriNuntii.para(InventorAdverbiis.class));
    }
  }
}
