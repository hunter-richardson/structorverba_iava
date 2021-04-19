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
  private static @Nullable ConditōrAdiectīvīs īnstantia = null;

  /**
   * Valor hic viam reī classis huiuc facit.
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
   */
  public static final @NotNull Supplier <ConditōrAdiectīvīs> fac =
    () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new ConditōrAdiectīvīs());

  private @NotNull Speciālitās speciālitās = Speciālitās.NŪLLUM;
  private @NotNull Genus       genus       = Genus.NŪLLUM;
  private @NotNull Numerālis   numerālis   = Numerālis.NŪLLUS;
  private @NotNull Cāsus       cāsus       = Cāsus.NŪLLUS;
  private @NotNull Gradus      gradus      = Gradus.NŪLLUS;

  private ConditōrAdiectīvīs( ) {
    super(Nūntius.NūntiusConditōrīAdiectīvīs.fac);
  }

  /**
   * @inheritDoc
   */
  public @Override @Nullable Adiectīvum condam( ) {
    if (StringUtils.isNoneBlank(fundāmen, scrīptiō)) {
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
   * @inheritDoc
   * @see Speciālitās#dēfīniam(String, Speciālitās)
   * @see Genus#dēfīniam(String, Genus)
   * @see Cāsus#dēfīniam(String, Cāsus)
   * @see Numerālis#dēfīniam(String, Numerālis)
   * @see Gradus#dēfīniam(String, Gradus)
   * @see Verbum#fundāmen
   */
  public @Override void allegō(@NotNull final String nōmen, @NotNull final String dēscrīptor) {
    switch (nōmen) {
      case "speciālitās" -> speciālitās = Speciālitās.dēfīniam(dēscrīptor, Speciālitās.NŪLLUM);
      case "genus" -> genus = Genus.dēfīniam(dēscrīptor, Genus.NŪLLUM);
      case "numerālis" -> numerālis = Numerālis.dēfīniam(dēscrīptor, Numerālis.NŪLLUS);
      case "cāsus" -> cāsus = Cāsus.dēfīniam(dēscrīptor, Cāsus.NŪLLUS);
      case "gradus" -> gradus = Gradus.dēfīniam(dēscrīptor, Gradus.NŪLLUS);
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
   * @inheritDoc
   * @see Speciālitās#NŪLLUM
   * @see Genus#NŪLLUM
   * @see Cāsus#NŪLLUS
   * @see Numerālis#NŪLLUS
   * @see Gradus#NŪLLUS
   */
  public @Override void restituō( ) {
    speciālitās = Speciālitās.NŪLLUM;
    genus = Genus.NŪLLUM;
    cāsus = Cāsus.NŪLLUS;
    numerālis = Numerālis.NŪLLUS;
    gradus = Gradus.NŪLLUS;
    scrīptiō = StringUtils.EMPTY;
    nūntius.certiōrō(getClass().getSimpleName(), "est restitūtus.");
  }
}
