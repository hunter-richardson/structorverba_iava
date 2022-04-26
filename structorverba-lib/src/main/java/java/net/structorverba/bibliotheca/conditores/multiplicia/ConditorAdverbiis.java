package net.structorverba.bibliotheca.conditores.multiplicia;

import net.structorverba.bibliotheca.conditores.Conditōr;
import net.structorverba.bibliotheca.nuntii.Nūntius;
import net.structorverba.bibliotheca.verba.Verbum;
import net.structorverba.bibliotheca.verba.multiplicia.*;
import net.structorverba.bibliotheca.enumerationes.Gradus;
import org.apache.commons.lang3.*;
import org.jetbrains.annotations.*;

import java.util.Objects;
import java.util.function.Supplier;

/**
 * Classis {@link ConditōrAdverbiīs} est vās classis {@link Conditōr} classī {@link Adverbium}.
 * @see Adverbium
 * @see Nūntius.NūntiusConditōrīAdverbiīs
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection" })
public class ConditōrAdverbiīs extends ConditōrMultiplicibus <Adverbium> {
  @Nullable private static ConditōrAdverbiīs īnstantia = null;

  /**
   * Valor hic viam reī classis huiuc facit.
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
   */
  @NotNull public static final Supplier <ConditōrAdverbiīs> fac =
    ( ) -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new ConditōrAdverbiīs());

  @NotNull private Gradus gradus = Gradus.NŪLLUS;

  private ConditōrAdverbiīs( ) {
    super(Nūntius.NūntiusConditōrīAdverbiīs.fac);
    nūntius.plūrimumGarriō("Factus sum");
  }

  /**
   * {@inheritDoc}
   * @return Rem novam classis {@link Adiectīvum}. <br> Modus hid valōrem {@code null} refert sī nōn valet valor aliquis
   *   rēs haec continet.
   */
  @SuppressWarnings("ConstantConditions")
  @Override @Nullable
  public Adverbium condam( ) {
    if (Objects.nonNull(gradus)
        && StringUtils.isNoneBlank(lemma, scrīptiō)) {
      final Adverbium hoc = new Adverbium(gradus, lemma, scrīptiō);
      if (Objects.isNull(hoc)) {
        nūntius.moneō(Adverbium.class.getSimpleName().replace("um", "ī"),
                      StringUtils.firstNonBlank(lemma, scrīptiō), "prōductiō fōrmae nūllae prōcessit.");
        return null;
      } else {
        nūntius.certiōrō(Adverbium.class.getSimpleName(), scrīptiō, "fīnītur prōdūcere.");
        return hoc;
      }
    } else {
      nūntius.moneō(Adverbium.class.getSimpleName().replace("um", "ī"),
                    StringUtils.firstNonBlank(lemma, scrīptiō), "prōductiō fōrmae nūllae prōcessit.");
      return null;
    }
  }

  /**
   * {@inheritDoc}
   * @see Gradus#NŪLLUS
   */
  @Override public void restituō( ) {
    gradus = Gradus.NŪLLUS;
    scrīptiō = StringUtils.EMPTY;
  }

  /**
   * {@inheritDoc}
   * @see Gradus#dēfīniam(String)
   * @see Verbum#lemma
   */
  @Override public void allegō(@NotNull final String nōmen, @NotNull final String dēscrīptor) {
    switch (nōmen) {
      case "gradus" -> gradus = Gradus.dēfīniam(dēscrīptor);
      case "lemma" -> lemma = dēscrīptor.trim();
      default -> {
        nūntius.moneō(Adiectīvum.class.getSimpleName().replace("um", "ō"),
                      "Attribūta inopīnāta est ūsa:", nōmen, "est", dēscrīptor);
        return;
      }
    }

    nūntius.garriō("Cōntrūctiōnī adiēcī conditiōnem novam:", nōmen, "est", dēscrīptor);
  }
}
