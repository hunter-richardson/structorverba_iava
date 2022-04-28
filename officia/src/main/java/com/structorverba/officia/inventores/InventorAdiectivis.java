package officia.src.main.java.com.structorverba.officia.inventores;

import officia.src.main.java.com.structorverba.officia.lectores.LectorMultiplicibus;
import officia.src.main.java.com.structorverba.officia.nuntii.Nuntius;
import officia.src.main.java.com.structorverba.officia.verba.multiplicia.Adiectivum;
import officia.src.main.java.com.structorverba.officia.enumerationes.*;

import org.apache.commons.lang3.ObjectUtils;
import org.jetbrains.annotations.*;

import javax.ejb.*;
import java.util.function.*;

/**
 * Classis {@link InventorAdiectivis} est v\u0101s classis {@link Inventor} class\u012B {@link Adiectivum}.
 * @see Adiectivum
 * @see Nuntius.NuntiusInventoriAdiectivis
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
  @NotNull public static final Supplier <InventorAdiectivis> fac =
    ( ) -> ObjectUtils.firstNonNull(instantia, instantia = new InventorAdiectivis());

  @NotNull private Specialitas specialitas = Specialitas.NULLUM;
  @NotNull private Genus       genus       = Genus.NULLUM;
  @NotNull private Numeralis   numeralis   = Numeralis.NULLUS;
  @NotNull private Casus       casus       = Casus.DERECTUS;
  @NotNull private Gradus      gradus      = Gradus.NULLUS;

  private InventorAdiectivis( ) {
    super(Nuntius.NuntiusInventoriAdiectivis.fac);
    nuntius.plurimumGarrio("Factus sum");
  }

  /**
   * @return Quaesti\u014Dnem quam r\u0113s classis {@link LectorMultiplicibus.LectorAdiectivis} ut\u0101tur r\u0113s classis {@link
   *   Adiectivum} perc\u014Dlere
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Predicate.html">Prediate</a>
   */
  @Override @NotNull
  public Predicate <@NotNull Adiectivum> inquiram() {
    return adiectivum -> specialitas.equals(adiectivum.specialitas)
                         && genus.equals(adiectivum.genus)
                         && casus.equals(adiectivum.casus)
                         && numeralis.equals(adiectivum.numeralis)
                         && gradus.equals(adiectivum.gradus);
  }

  /**
   * {@inheritDoc}
   * @see Specialitas#NULLUM
   * @see Genus#NULLUM
   * @see Numeralis#NULLUS
   * @see Casus#DERECTUS
   * @see Gradus#NULLUS
   */
  @Override public void restituo( ) {
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
  @Override protected void allegam(@NotNull final Enum <@NotNull ?> illud) {
    if (illud instanceof Specialitas) {
      specialitas = Specialitas.ut(illud);
      nuntius.garrio("Quasti\u014Dn\u012B adi\u0113c\u012B conditi\u014Dnem novam:",
                     Specialitas.class.getSimpleName(), "est", illud);
    } else if (illud instanceof Genus) {
      genus = Genus.ut(illud);
      nuntius.garrio("Quasti\u014Dn\u012B adi\u0113c\u012B conditi\u014Dnem novam:",
                     Genus.class.getSimpleName(), "est", illud);
    } else if (illud instanceof Numeralis) {
      numeralis = Numeralis.ut(illud);
      nuntius.garrio("Quasti\u014Dn\u012B adi\u0113c\u012B conditi\u014Dnem novam:",
                     Numeralis.class.getSimpleName(), "est", illud);
    } else if (illud instanceof Casus) {
      casus = Casus.ut(illud);
      nuntius.garrio("Quasti\u014Dn\u012B adi\u0113c\u012B conditi\u014Dnem novam:",
                     Casus.class.getSimpleName(), "est", illud);
    } else if (illud instanceof Gradus) {
      gradus = Gradus.ut(illud);
      nuntius.garrio("Quasti\u014Dn\u012B adi\u0113c\u012B conditi\u014Dnem novam:",
                     Gradus.class.getSimpleName(), "est", illud);
    } else {
      nuntius.moneo(Adiectivum.class.getSimpleName().replace("um", '\u014D'),
                    "inqu\u012Bs\u012Bti\u014D adiect\u012Bv\u014D inop\u012Bn\u0101ta est \u016Bsa:", illud.toString());
    }
  }
}