package net.strūctorverba.conditōrēs.multiplicia;

import net.strūctorverba.nūntiī.Nūntius;
import net.strūctorverba.verba.multiplicia.*;
import net.strūctorverba.ēnumerātiōnēs.*;
import org.apache.commons.lang3.*;
import org.jetbrains.annotations.*;

import javax.ejb.*;
import java.util.Objects;
import java.util.function.Supplier;

@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection" })
@Singleton
@DependsOn("NūntiusConditōrīNōminibus")
public final class ConditōrNōminibus extends ConditōrMultiplicibus <Nōmen> {
  private static @Nullable ConditōrNōminibus īnstantia = null;

  public static final @NotNull Supplier <ConditōrNōminibus> fac =
    () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new ConditōrNōminibus());

  private @NotNull Speciālitās speciālitās = Speciālitās.NŪLLUM;
  private @NotNull Genus       genus       = Genus.NŪLLUM;
  private @NotNull Numerāle    numerāle    = Numerāle.NŪLLUS;
  private @NotNull Cāsus       cāsus       = Cāsus.NŪLLUS;

  private ConditōrNōminibus( ) {
    super(Nūntius.NūntiusConditōrīNōminibus.fac);
  }

  public @Override @Nullable Nōmen condam( ) {
    if (StringUtils.isNoneBlank(fundāmen, scrīptiō)) {
      final Nōmen hoc = Nōmen.conditōr().fundāmen(fundāmen).speciālitās(speciālitās).genus(genus)
                             .cāsus(cāsus).numerāle(numerāle).scrīptiō(scrīptiō).condam();
      if(Objects.isNull(hoc)) {
        nūntius.moneō(Nōmen.class.getSimpleName().replace("en", "inis"),
                      StringUtils.firstNonBlank(fundāmen, scrīptiō), "prōductiō fōrmae nūllae prōcessit.");
        return null;
      } else {
        nūntius.certiōrō(Nōmen.class.getSimpleName(), scrīptiō, "fīnītur prōdūcere.");
        return hoc;
      }
    } else {
      nūntius.moneō(Nōmen.class.getSimpleName().replace("en", "inis"),
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
      case "fundāmen" -> fundāmen = dēscrīptor.trim();
      default -> {
        nūntius.moneō(Nōmen.class.getSimpleName().replace("en", "ī"),
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
    nūntius.certiōrō(getClass().getSimpleName(), "est restitūtus.");
  }
}
