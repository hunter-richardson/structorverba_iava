package com.structorverba.officia.inventores;

import androidx.annotation.*;
import com.structorverba.officia.enumerationes.*;
import com.structorverba.officia.lectores.LectorMultiplicibus;
import com.structorverba.officia.miscella.Utilitas;
import com.structorverba.officia.nuntii.Nuntius;
import com.structorverba.officia.verba.multiplicia.Adverbium;
import jakarta.ejb.*;
import org.apache.commons.lang3.ObjectUtils;

import java.util.function.*;

/**
 * Classis {@link InventorAdverbiis} est v\u0101s classis {@link Inventor} class\u012B {@link Adverbium}.
 * @see Adverbium
 * @see Nuntius.NuntiusInventoriAdverbiis
 */
@SuppressWarnings("SpellCheckingInspection")
@Singleton
@DependsOn("NuntiusInventoriAdverbiis")
public class InventorAdverbiis extends Inventor <Adverbium> {
  @Nullable private static InventorAdverbiis instantia = null;

  /**
   * Valor hic viam re\u012B classis huiuc facit.
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
   */
  @NonNull public static final Supplier <InventorAdverbiis> fac =
    () -> ObjectUtils.firstNonNull(instantia, instantia = new InventorAdverbiis());

  @NonNull private Gradus gradus = Gradus.NULLUS;

  private InventorAdverbiis() {
    super(Nuntius.NuntiusInventoriAdverbiis.fac);
    nuntius.plurimumGarrio("Factus sum");
  }

  /**
   * @return Quaesti\u012Bnem quam r\u0113s classis {@link LectorMultiplicibus.LectorAdverbiis} ut\u0101tur r\u0113s classis {@link
   *   Adverbium} perc\u012Blere
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
   * Modus hic \u0113numer\u0101ti\u012Bnem singulum {@code illud} re\u012B huic indit.
   * @param illud \u0113numer\u0101ti\u012Bnem indendam
   * @see Gradus#ut(Enum)
   */
  @Override protected void allegam(Enum <?> illud) {
    if (illud instanceof Gradus) {
      gradus = Gradus.ut(illud);
      nuntius.garrio("Quaesti\u014Dn\u012B adi\u0113c\u012B conditi\u014Dnem novam:",
                     Gradus.pittacium, illud);
    } else {
      nuntius.moneo(Utilitas.primamCapitaneamScribo(Categoria.ADVERBIUM.scriptio.replace('a', '\u014D')),
                    "inqu\u012Bs\u012Bti\u014D adiect\u012Bv\u014D inop\u012Bn\u0101ta \u016Bsa'st:", illud);
    }
  }
}
