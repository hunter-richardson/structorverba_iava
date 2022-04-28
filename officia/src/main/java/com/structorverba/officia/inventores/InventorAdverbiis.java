package officia.src.main.java.com.structorverba.officia.inventores;

import com.structorverba.lectores.LectorMultiplicibus;
import com.structorverba.nuntii.Nuntius;
import com.structorverba.verba.multiplicia.Adverbium;
import com.structorverba.enumerationes.Gradus;

import org.apache.commons.lang3.ObjectUtils;
import org.jetbrains.annotations.*;

import javax.ejb.*;
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
  @NotNull public static final Supplier <InventorAdverbiis> fac =
    ( ) -> ObjectUtils.firstNonNull(instantia, instantia = new InventorAdverbiis());

  @NotNull private Gradus gradus = Gradus.NULLUS;

  private InventorAdverbiis() {
    super(Nuntius.NuntiusInventoriAdverbiis.fac);
    nuntius.plurimumGarrio("Factus sum");
  }

  /**
   * @return Quaesti\u012Bnem quam r\u0113s classis {@link LectorMultiplicibus.LectorAdverbiis} ut\u0101tur r\u0113s classis {@link
   *   Adverbium} perc\u012Blere
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Predicate.html">Prediate</a>
   */
  @Override @NotNull
  public Predicate <@NotNull Adverbium> inquiram() {
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
  @Override protected void allegam(Enum <@NotNull ?> illud) {
    gradus = Gradus.ut(illud);
  }
}
