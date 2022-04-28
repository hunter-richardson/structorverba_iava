package officia.src.main.java.com.structorverba.officia.inventores;

import officia.src.main.java.com.structorverba.officia.lectores.LectorMultiplicibus;
import officia.src.main.java.com.structorverba.officia.nuntii.Nuntius;
import officia.src.main.java.com.structorverba.officia.verba.multiplicia.Actus;
import officia.src.main.java.com.structorverba.officia.enumerationes.*;

import org.apache.commons.lang3.ObjectUtils;
import org.jetbrains.annotations.*;

import javax.ejb.*;
import java.util.function.*;

/**
 * Classis {@link InventorActis} est v\u0101s classis {@link Inventor} class\u012B {@link Actus}.
 * @see Actus
 * @see Nuntius.NuntiusInventoriActis
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
  @NotNull public static final Supplier <InventorActis> fac =
    () -> ObjectUtils.firstNonNull(instantia, instantia = new InventorActis());

  @NotNull private Vox       vox       = Vox.NULLA;
  @NotNull private Tempus    tempus    = Tempus.INTEMPORALE;
  @NotNull private Numeralis numeralis = Numeralis.NULLUS;
  @NotNull private Persona   persona   = Persona.NULLA;
  @NotNull private Modus     modus     = Modus.NULLUS;

  private InventorActis() {
    super(Nuntius.NuntiusInventoriActis.fac);
    nuntius.plurimumGarrio("Factus sum");
  }

  /**
   * @return Quaesti\u014Dnem quam r\u0113s classis {@link LectorMultiplicibus.LectorActis} \u016Bt\u0101tur r\u0113s classis {@link Actus}
   *   perc\u014Dlere
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Predicate.html">Prediate</a>
   */
  @Override @NotNull
  public Predicate <@NotNull Actus> inquiram() {
    return actum -> modus.equals(actum.modus)
                    && vox.equals(actum.vox)
                    && tempus.equals(actum.tempus)
                    && numeralis.equals(actum.numeralis)
                    && persona.equals(actum.persona);
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
  @Override protected void allegam(@NotNull final Enum <@NotNull ?> illud) {
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
      nuntius.moneo(Actus.class.getSimpleName().replace("us", "\u014D"),
                    "inqu\u012Bs\u012Bti\u014D inop\u012Bn\u0101ta \u016Bsa'st:", illud);
    }
  }
}