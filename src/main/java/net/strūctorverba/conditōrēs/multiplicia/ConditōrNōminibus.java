package net.strūctorverba.conditōrēs.multiplicia;

import net.strūctorverba.conditōrēs.Conditōr;
import net.strūctorverba.nūntiī.Nūntius;
import net.strūctorverba.verba.Verbum;
import net.strūctorverba.verba.multiplicia.Nōmen;
import net.strūctorverba.ēnumerātiōnēs.Cāsus;
import net.strūctorverba.ēnumerātiōnēs.Genus;
import net.strūctorverba.ēnumerātiōnēs.Numerālis;
import net.strūctorverba.ēnumerātiōnēs.Speciālitās;
import net.strūctorverba.ēnumerātiōnēs.Tempus;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.function.Supplier;

import javax.ejb.DependsOn;
import javax.ejb.Singleton;

/**
 * Classis {@link ConditōrNōminibus} est vās classis {@link Conditōr} classī {@link Nōmen}.
 * @see Nōmen
 * @see Nūntius.NūntiusConditōrīNōminibus
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection" })
@Singleton
@DependsOn("NūntiusConditōrīNōminibus")
public final class ConditōrNōminibus extends ConditōrMultiplicibus <Nōmen> {
  @Nullable private static ConditōrNōminibus īnstantia = null;

  /**
   * Valor hic viam reī classis huiuc facit.
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
   */
  @NotNull public static final Supplier <ConditōrNōminibus> fac =
    ( ) -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new ConditōrNōminibus());

  @NotNull private Speciālitās speciālitās = Speciālitās.NŪLLUM;
  @NotNull private Genus       genus       = Genus.NŪLLUM;
  @NotNull private Numerālis   numerālis   = Numerālis.NŪLLUS;
  @NotNull private Cāsus       cāsus       = Cāsus.DĒRĒCTUS;
  @NotNull private Tempus      tempus      = Tempus.INTEMPORĀLE;

  private ConditōrNōminibus( ) {
    super(Nūntius.NūntiusConditōrīNōminibus.fac);
    nūntius.plūrimumGarriō("Factus sum");
  }

  /**
   * {@inheritDoc}
   * @return Rem novam classis {@link Nōmen}. <br> Modus hid valōrem {@code null} refert sī nōn valet valor aliquis rēs
   *   haec continet.
   */
  @Override @Nullable
  public Nōmen condam( ) {
    if (ObjectUtils.allNotNull(speciālitās, genus, cāsus, numerālis)
        && StringUtils.isNoneBlank(lemma, scrīptiō)) {
      final Nōmen hoc = new Nōmen(speciālitās, genus, cāsus, numerālis, tempus, lemma, scrīptiō);
      if (Objects.isNull(hoc)) {
        nūntius.moneō(Nōmen.class.getSimpleName().replace("en", "inis"),
                      StringUtils.firstNonBlank(lemma, scrīptiō), "prōductiō fōrmae nūllae prōcessit.");
        return null;
      } else {
        nūntius.certiōrō(Nōmen.class.getSimpleName(), scrīptiō, "fīnītur prōdūcere.");
        return hoc;
      }
    } else {
      nūntius.moneō(Nōmen.class.getSimpleName().replace("en", "inis"),
                    StringUtils.firstNonBlank(lemma, scrīptiō), "prōductiō fōrmae nūllae prōcessit.");
      return null;
    }
  }

  /**
   * {@inheritDoc}
   * @see Speciālitās#dēfīniam(String)
   * @see Genus#dēfīniam(String)
   * @see Cāsus#dēfīniam(String)
   * @see Numerālis#dēfīniam(String)
   * @see Tempus#dēfīniam(String)
   * @see Verbum#lemma
   */
  @Override public void allegō(@NotNull final String nōmen, @NotNull final String dēscrīptor) {
    switch (nōmen) {
      case "speciālitās" -> speciālitās = Speciālitās.dēfīniam(dēscrīptor);
      case "genus" -> genus = Genus.dēfīniam(dēscrīptor);
      case "numerālis" -> numerālis = Numerālis.dēfīniam(dēscrīptor);
      case "cāsus" -> cāsus = Cāsus.dēfīniam(dēscrīptor);
      case "tempus" -> tempus = Tempus.dēfīniam(dēscrīptor);
      case "lemma" -> lemma = dēscrīptor.trim();
      default -> {
        nūntius.moneō(Nōmen.class.getSimpleName().replace("en", "ī"),
                      "Attribūta inopīnāta est ūsa:", nōmen, "est", dēscrīptor);
        return;
      }
    }

    nūntius.garriō("Cōntrūctiōnī adiēcī conditiōnem novam:", nōmen, "est", dēscrīptor);
  }

  /**
   * {@inheritDoc}
   * @see Speciālitās#NŪLLUM
   * @see Genus#NŪLLUM
   * @see Cāsus#DĒRĒCTUS
   * @see Numerālis#NŪLLUS
   * @see Tempus#INTEMPORĀLE
   */
  @Override public void restituō( ) {
    speciālitās = Speciālitās.NŪLLUM;
    genus = Genus.NŪLLUM;
    cāsus = Cāsus.DĒRĒCTUS;
    numerālis = Numerālis.NŪLLUS;
    tempus = Tempus.INTEMPORĀLE;
    scrīptiō = StringUtils.EMPTY;
    nūntius.certiōrō("Restitūtus sum");
  }
}
