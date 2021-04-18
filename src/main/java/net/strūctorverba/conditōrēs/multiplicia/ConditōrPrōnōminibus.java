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
@DependsOn("NūntiusConditōrīPrōnōminibus")
public final class ConditōrPrōnōminibus extends ConditōrMultiplicibus <Prōnōmen> {
  private static @Nullable ConditōrPrōnōminibus īnstantia = null;

  public static final @NotNull Supplier <ConditōrPrōnōminibus> fac =
    () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new ConditōrPrōnōminibus());

  private @NotNull Speciālitās speciālitās = Speciālitās.NŪLLUM;
  private @NotNull Genus       genus       = Genus.NŪLLUM;
  private @NotNull Numerāle    numerāle    = Numerāle.NŪLLUS;
  private @NotNull Cāsus       cāsus       = Cāsus.NŪLLUS;

  private ConditōrPrōnōminibus( ) {
    super(Nūntius.NūntiusConditōrīPrōnōminibus.fac);
  }

  public @Override @Nullable Prōnōmen condam( ) {
    if (StringUtils.isNoneBlank(fundāmen, scrīptiō)) {
      final Prōnōmen hoc = Prōnōmen.conditōr().fundāmen(fundāmen).speciālitās(speciālitās).genus(genus)
                                   .cāsus(cāsus).numerāle(numerāle).scrīptiō(scrīptiō).condam();
      if(Objects.isNull(hoc)) {
        nūntius.moneō(Prōnōmen.class.getSimpleName().replace("en", "inis"),
                      StringUtils.firstNonBlank(fundāmen, scrīptiō), "prōductiō fōrmae nūllae prōcessit.");
        return null;
      } else {
        nūntius.certiōrō(Prōnōmen.class.getSimpleName(), scrīptiō, "fīnītur prōdūcere.");
        return hoc;
      }
    } else {
      nūntius.moneō(Prōnōmen.class.getSimpleName().replace("en", "inis"),
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
        nūntius.moneō(Prōnōmen.class.getSimpleName().replace("en", "ī"),
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
