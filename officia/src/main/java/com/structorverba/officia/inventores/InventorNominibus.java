package officia.src.main.java.com.structorverba.officia.inventores;

import officia.src.main.java.com.structorverba.officia.lectores.LectorMultiplicibus;
import officia.src.main.java.com.structorverba.officia.nuntii.Nuntius;
import officia.src.main.java.com.structorverba.officia.verba.multiplicia.Nomen;
import officia.src.main.java.com.structorverba.officia.enumerationes.*;

import org.apache.commons.lang3.ObjectUtils;
import org.jetbrains.annotations.*;

import java.util.function.*;

import javax.ejb.*;

/**
 * Classis {@link InventorNominibus} est v\u0101s classis {@link Inventor} class\u012B {@link Nomen}.
 * @see Nomen
 * @see Nuntius.NuntiusInventoriNominibus
 */
@SuppressWarnings("SpellCheckingInspection")
@Singleton
@DependsOn("NuntiusInventoriAdiectivis")
public final class InventorNominibus extends Inventor <Nomen> {
  @Nullable private static InventorNominibus instantia = null;

  /**
   * Valor hic viam re\u012B classis huiuc facit.
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
   */
  @NotNull public static final Supplier <InventorNominibus> fac =
    ( ) -> ObjectUtils.firstNonNull(instantia, instantia = new InventorNominibus());

  @NotNull private Specialitas specialitas = Specialitas.NULLUM;
  @NotNull private Genus       genus       = Genus.NULLUM;
  @NotNull private Numeralis   numeralis   = Numeralis.NULLUS;
  @NotNull private Casus       casus       = Casus.DERECTUS;
  @NotNull private Tempus      tempus      = Tempus.INTEMPORALE;

  private InventorNominibus() {
    super(Nuntius.NuntiusInventoriNominibus.fac);
    nuntius.plurimumGarrio("Factus sum");
  }

  /**
   * @return Quaestionem quam r\u0113s classis {@link LectorMultiplicibus.LectorNominibus} \u016Bt\u0101tur r\u0113s classis {@link Nomen}
   *   percolere
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Predicate.html">Prediate</a>
   */
  @Override @NotNull
  public Predicate <@NotNull Nomen> inquiram() {
    return nomen -> specialitas.equals(nomen.specialitas)
                    && genus.equals(nomen.genus)
                    && casus.equals(nomen.casus)
                    && numeralis.equals(nomen.numeralis)
                    && tempus.equals(nomen.tempus);
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
    nuntius.certioro("Restit\u016Btus sum");
  }

  /**
   * {@inheritDoc}
   * @param illud \u0113numer\u0101ti\u014Dnem indendam
   * @see Specialitas#ut(Enum)
   * @see Genus#ut(Enum)
   * @see Numeralis#ut(Enum)
   * @see Casus#ut(Enum)
   * @see Tempus#ut(Enum)
   */
  @Override protected void allegam(@NotNull final Enum <@NotNull ?> illud) {
    if (illud instanceof Specialitas) {
      specialitas = Specialitas.ut(illud);
      nuntius.garrio("Quaesti\u014Dn\u012B adi\u0113c\u012B conditi\u014Dnem novam:",
                     Specialitas.class.getSimpleName(), illud);
    } else if (illud instanceof Genus) {
      genus = Genus.ut(illud);
      nuntius.garrio("Quaesti\u014Dn\u012B adi\u0113c\u012B conditi\u014Dnem novam:",
                     Genus.class.getSimpleName(), illud);
    } else if (illud instanceof Numeralis) {
      numeralis = Numeralis.ut(illud);
      nuntius.garrio("Quaesti\u014Dn\u012B adi\u0113c\u012B conditi\u014Dnem novam:",
                     Numeralis.class.getSimpleName(), illud);
    } else if (illud instanceof Casus) {
      casus = Casus.ut(illud);
      nuntius.garrio("Quaesti\u014Dn\u012B adi\u0113c\u012B conditi\u014Dnem novam:",
                     Casus.class.getSimpleName(), illud);
    } else if (illud instanceof Tempus) {
      tempus = Tempus.ut(illud);
      nuntius.garrio("Quaesti\u014Dn\u012B adi\u0113c\u012B conditi\u014Dnem novam:",
                     Tempus.class.getSimpleName(), illud);
    } else {
      nuntius.moneo(Nomen.class.getSimpleName().replace("en", "\u012B"),
                    "inqu\u012Bs\u012Bti\u014D n\u014Dmin\u012B inop\u012Bn\u0101ta \u016Bsa'st:",
                    illud);
    }
  }
}
