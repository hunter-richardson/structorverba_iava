package net.strūctorverba.conditōrēs.multiplicia;

import net.strūctorverba.conditōrēs.Conditōr;
import net.strūctorverba.nūntiī.Nūntius;
import net.strūctorverba.verba.Verbum;
import net.strūctorverba.verba.multiplicia.Adiectīvum;
import net.strūctorverba.ēnumerātiōnēs.*;
import org.apache.commons.lang3.*;
import org.jetbrains.annotations.*;

import javax.ejb.*;
import java.util.Objects;
import java.util.function.Supplier;

/**
 * Classis {@link ConditōrAdiectīvīs} est vās classis {@link Conditōr} classī {@link Adiectīvum}.
 * @see Adiectīvum
 * @see Nūntius.NūntiusConditōrīAdiectīvīs
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection" })
@Singleton
@DependsOn("NūntiusConditōrīAdiectīvīs")
public final class ConditōrAdiectīvīs extends ConditōrMultiplicibus <Adiectīvum> {
  @Nullable private static ConditōrAdiectīvīs īnstantia = null;

  /**
   * Valor hic viam reī classis huiuc facit.
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
   */
  @NotNull public static final Supplier <ConditōrAdiectīvīs> fac =
    () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new ConditōrAdiectīvīs());

  @NotNull private Speciālitās speciālitās = Speciālitās.NŪLLUM;
  @NotNull private Genus       genus       = Genus.NŪLLUM;
  @NotNull private Numerālis   numerālis   = Numerālis.NŪLLUS;
  @NotNull private Cāsus       cāsus       = Cāsus.DĒRĒCTUS;
  @NotNull private Gradus      gradus      = Gradus.NŪLLUS;

  private ConditōrAdiectīvīs( ) {
    super(Nūntius.NūntiusConditōrīAdiectīvīs.fac);
    nūntius.plūrimumGarriō("Factus sum");
  }

  /**
   * {@inheritDoc}
   * @return Rem novam classis {@link Adiectīvum}. <br>
   * Modus hid valōrem {@code null} refert sī nōn valet valor aliquis rēs haec continet.
   */
  @Override @Nullable
  public Adiectīvum condam( ) {
    if (ObjectUtils.allNotNull(speciālitās, genus, cāsus, numerālis, gradus)
     && StringUtils.isNoneBlank(fundāmen, scrīptiō)) {
      final Adiectīvum hoc = Adiectīvum.conditōr().fundāmen(fundāmen).speciālitās(speciālitās).genus(genus)
                                       .cāsus(cāsus).numerālis(numerālis).gradus(gradus).scrīptiō(scrīptiō).condam();
      if(Objects.isNull(hoc)) {
        nūntius.moneō(Adiectīvum.class.getSimpleName().replace("um", "ī"),
                      StringUtils.firstNonBlank(fundāmen, scrīptiō), "prōductiō fōrmae nūllae prōcessit.");
        return null;
      } else {
        nūntius.certiōrō(Adiectīvum.class.getSimpleName(), scrīptiō, "fīnītur prōdūcere.");
        return hoc;
      }
    } else {
      nūntius.moneō(Adiectīvum.class.getSimpleName().replace("um", "ī"),
                    StringUtils.firstNonBlank(fundāmen, scrīptiō), "prōductiō fōrmae nūllae prōcessit.");
      return null;
    }
  }

  /**
   * {@inheritDoc}
   * @see Speciālitās#dēfīniam(String)
   * @see Genus#dēfīniam(String)
   * @see Cāsus#dēfīniam(String)
   * @see Numerālis#dēfīniam(String)
   * @see Gradus#dēfīniam(String)
   * @see Verbum#fundāmen
   */
  @Override public void allegō(@NotNull final String nōmen, @NotNull final String dēscrīptor) {
    switch (nōmen) {
      case "speciālitās" -> speciālitās = Speciālitās.dēfīniam(dēscrīptor);
      case "genus" -> genus = Genus.dēfīniam(dēscrīptor);
      case "numerālis" -> numerālis = Numerālis.dēfīniam(dēscrīptor);
      case "cāsus" -> cāsus = Cāsus.dēfīniam(dēscrīptor);
      case "gradus" -> gradus = Gradus.dēfīniam(dēscrīptor);
      case "fundāmen" -> fundāmen = dēscrīptor.trim();
      default -> {
        nūntius.moneō(Adiectīvum.class.getSimpleName().replace("um", "ō"),
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
   * @see Gradus#NŪLLUS
   */
  @Override public void restituō( ) {
    speciālitās = Speciālitās.NŪLLUM;
    genus = Genus.NŪLLUM;
    cāsus = Cāsus.DĒRĒCTUS;
    numerālis = Numerālis.NŪLLUS;
    gradus = Gradus.NŪLLUS;
    scrīptiō = StringUtils.EMPTY;
    nūntius.certiōrō("Restitūtus sum");
  }
}
