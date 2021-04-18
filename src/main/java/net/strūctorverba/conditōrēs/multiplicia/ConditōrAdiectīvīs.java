package net.strūctorverba.conditōrēs.multiplicia;

import net.strūctorverba.nūntiī.Nūntius;
import net.strūctorverba.verba.multiplicia.Adiectīvum;
import net.strūctorverba.ēnumerātiōnēs.*;
import org.apache.commons.lang3.*;
import org.jetbrains.annotations.*;

import javax.ejb.*;
import java.util.Objects;
import java.util.function.Supplier;

@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection" })
@Singleton
@DependsOn("NūntiusConditōrīAdiectīvīs")
public final class ConditōrAdiectīvīs extends ConditōrMultiplicibus <Adiectīvum> {
  private static @Nullable ConditōrAdiectīvīs īnstantia = null;

  public static final @NotNull Supplier <ConditōrAdiectīvīs> fac =
    () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new ConditōrAdiectīvīs());

  private @NotNull Speciālitās speciālitās = Speciālitās.NŪLLUM;
  private @NotNull Genus       genus       = Genus.NŪLLUM;
  private @NotNull Numerāle    numerāle    = Numerāle.NŪLLUS;
  private @NotNull Cāsus       cāsus       = Cāsus.NŪLLUS;
  private @NotNull Gradus      gradus      = Gradus.NŪLLUS;

  private ConditōrAdiectīvīs( ) {
    super(Nūntius.NūntiusConditōrīAdiectīvīs.fac);
  }

  public @Override @Nullable Adiectīvum condam( ) {
    if (StringUtils.isNoneBlank(fundāmen, scrīptiō)) {
      final Adiectīvum hoc = Adiectīvum.conditōr().fundāmen(fundāmen).speciālitās(speciālitās).genus(genus)
                                       .cāsus(cāsus).numerāle(numerāle).gradus(gradus).scrīptiō(scrīptiō).condam();
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

  public @Override void allegō(@NotNull final String nōmen, @NotNull final String dēscrīptor) {
    switch (nōmen) {
      case "speciālitās" -> speciālitās = Speciālitās.dēfīniam(dēscrīptor, Speciālitās.NŪLLUM);
      case "genus" -> genus = Genus.dēfīniam(dēscrīptor, Genus.NŪLLUM);
      case "numerāle" -> numerāle = Numerāle.dēfīniam(dēscrīptor, Numerāle.NŪLLUS);
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

  public @Override void restituō( ) {
    speciālitās = Speciālitās.NŪLLUM;
    genus = Genus.NŪLLUM;
    cāsus = Cāsus.NŪLLUS;
    numerāle = Numerāle.NŪLLUS;
    gradus = Gradus.NŪLLUS;
    nūntius.certiōrō(getClass().getSimpleName(), "est restitūtus.");
  }
}
