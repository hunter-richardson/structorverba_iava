package officia.src.main.java.com.structorverba.officia.inventores;

import officia.src.main.java.com.structorverba.officia.lectores.LectorMultiplicibus;
import officia.src.main.java.com.structorverba.officia.nuntii.Nuntius;
import officia.src.main.java.com.structorverba.officia.verba.multiplicia.Pronomen;
import officia.src.main.java.com.structorverba.officia.enumerationes.*;

import org.apache.commons.lang3.ObjectUtils;
import org.jetbrains.annotations.*;

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
  @NotNull public static final Supplier <InventorPronominibus> fac =
    ( ) -> ObjectUtils.firstNonNull(instantia, instantia = new InventorPronominibus());

  @NotNull private Specialitas specialitas = Specialitas.NULLUM;
  @NotNull private Genus       genus       = Genus.NULLUM;
  @NotNull private Numeralis   numeralis   = Numeralis.NULLUS;
  @NotNull private Casus       casus       = Casus.DERECTUS;

  private InventorPronominibus( ) {
    super(Nuntius.NuntiusInventoriPronominibus.fac);
    nuntius.plurimumGarrio("Factus sum");
  }

  /**
   * @return Quaesti\u014Dnem quam r\u0113s classis {@link LectorMultiplicibus .LectorPronominibus} \u016Bt\u016Btur r\u0113s classis {@link
   *   Pronomen} perc\u014Dlere
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Predicate.html">Prediate</a>
   */
  @Override @NotNull
  public Predicate <@NotNull Pronomen> inquiram() {
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
  @Override protected void allegam(@NotNull final Enum <@NotNull ?> illud) {
    if (illud instanceof Specialitas) {
      specialitas = Specialitas.ut(illud);
      nuntius.garrio("Quaesti\u014Dn\u012B adi\u0113c\u012B conditi\u014Dnem novam:",
                     Specialitas.class.getSimpleName(), "est", illud);
    } else if (illud instanceof Genus) {
      genus = Genus.ut(illud);
      nuntius.garrio("Quaesti\u014Dn\u012B adi\u0113c\u012B conditi\u014Dnem novam:",
                     Genus.class.getSimpleName(), "est", illud);
    } else if (illud instanceof Numeralis) {
      numeralis = Numeralis.ut(illud);
      nuntius.garrio("Quaesti\u014Dn\u012B adi\u0113c\u012B conditi\u014Dnem novam:",
                     Numeralis.class.getSimpleName(), "est", illud);
    } else if (illud instanceof Casus) {
      casus = Casus.ut(illud);
      nuntius.garrio("Quaesti\u014Dn\u012B adi\u0113c\u012B conditi\u014Dnem novam:",
                     Casus.class.getSimpleName(), "est", illud);
    } else {
      nuntius.moneo(Pronomen.class.getSimpleName().replace("en", '\u012B'),
                    "inqu\u012Bs\u012Bti\u014D inop\u012Bn\u016Bta est \u016Bsa:", illud);
    }
  }
}