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
@Singleton @DependsOn("NūntiusConditōrīPrōnōmibusConiūnctīvīs")
public final class ConditōrPrōnōminibusConiūnctīvīs extends ConditōrMultiplicibus <PrōnōmenConiūnctīvum> {
  private static @Nullable ConditōrPrōnōminibusConiūnctīvīs īnstantia = null;

  public static final @NotNull Supplier <ConditōrPrōnōminibusConiūnctīvīs> fac =
    () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new ConditōrPrōnōminibusConiūnctīvīs());

  private @NotNull Speciālitās speciālitās = Speciālitās.NŪLLUM;
  private @NotNull Genus     genus     = Genus.NŪLLUM;
  private @NotNull Numerālis numerālis = Numerālis.NŪLLUS;
  private @NotNull Cāsus     cāsus     = Cāsus.NŪLLUS;

  private ConditōrPrōnōminibusConiūnctīvīs( ) {
    super(Nūntius.NūntiusConditōrīPrōnōmibusConiūnctīvīs.fac);
  }


  public @Override @Nullable PrōnōmenConiūnctīvum condam( ) {
    if (StringUtils.isNoneBlank(fundāmen, scrīptiō)) {
      final PrōnōmenConiūnctīvum hoc = PrōnōmenConiūnctīvum.conditōr().fundāmen(fundāmen).speciālitās(speciālitās)
                                                           .genus(genus).cāsus(cāsus).numerālis(numerālis)
                                                           .scrīptiō(scrīptiō).condam();
      if(Objects.isNull(hoc)) {
        nūntius.moneō(PrōnōmenConiūnctīvum.class.getSimpleName()
                                                .replace("en", "inis")
                                                .replace("um", "ī"),
                      StringUtils.firstNonBlank(fundāmen, scrīptiō), "prōductiō fōrmae nūllae prōcessit.");
        return null;
      } else {
        nūntius.certiōrō(PrōnōmenConiūnctīvum.class.getSimpleName(), scrīptiō, "fīnītur prōdūcere.");
        return hoc;
      }
    } else {
      nūntius.moneō(PrōnōmenConiūnctīvum.class.getSimpleName()
                                              .replace("en", "inis")
                                              .replace("um", "ī"),
                    StringUtils.firstNonBlank(fundāmen, scrīptiō), "prōductiō fōrmae nūllae prōcessit.");
      return null;
    }
  }

  public @Override void allegō(@NotNull final String nōmen, @NotNull final String dēscrīptor) {
    switch (nōmen) {
      case "speciālitās" -> speciālitās = Speciālitās.dēfīniam(dēscrīptor, Speciālitās.NŪLLUM);
      case "genus" -> genus = Genus.dēfīniam(dēscrīptor, Genus.NŪLLUM);
      case "numerālis" -> numerālis = Numerālis.dēfīniam(dēscrīptor, Numerālis.NŪLLUS);
      case "cāsus" -> cāsus = Cāsus.dēfīniam(dēscrīptor, Cāsus.NŪLLUS);
      case "fundāmen" -> fundāmen = dēscrīptor.trim();
      default -> {
        nūntius.moneō(PrōnōmenConiūnctīvum.class.getSimpleName()
                                                .replace("um", "ō")
                                                .replace("en", "ī"),
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
    numerālis = Numerālis.NŪLLUS;
    nūntius.certiōrō(getClass().getSimpleName(), "est restitūtus.");
  }
}
