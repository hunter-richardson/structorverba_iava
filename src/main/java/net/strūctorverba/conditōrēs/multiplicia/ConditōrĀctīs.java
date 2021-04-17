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
@Singleton @DependsOn("NūntiusConditōrīĀctīs")
public final class ConditōrĀctīs extends ConditōrMultiplicibus <Āctum> {
  private static @Nullable ConditōrĀctīs īnstantia = null;

  public static final @NotNull Supplier <ConditōrĀctīs> fac =
    () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new ConditōrĀctīs());

  private @NotNull Modus    modus    = Modus.NŪLLUM;
  private @NotNull Vōx      vōx      = Vōx.NŪLLUM;
  private @NotNull Tempus   tempus   = Tempus.NŪLLUM;
  private @NotNull Numerāle numerāle = Numerāle.NŪLLUM;
  private @NotNull Persōna  persōna  = Persōna.NŪLLUM;

  private ConditōrĀctīs( ) {
    super(Nūntius.NūntiusConditōrīĀctīs.fac);
  }

  public @Override @Nullable Āctum condam( ) {
    if (StringUtils.isNoneBlank(fundāmen, scrīptiō)) {
      final Āctum hoc = Āctum.conditōr().fundāmen(fundāmen).modus(modus).vōx(vōx).tempus(tempus)
                             .numerāle(numerāle).persōna(persōna).scrīptiō(scrīptiō).condam();
      if(Objects.isNull(hoc)) {
        nūntius.moneō(Āctum.class.getSimpleName().replace("um", "ī"),
                      StringUtils.firstNonBlank(fundāmen, scrīptiō), "prōductiō fōrmae nūllae prōcessit.");
        return null;
      } else {
        nūntius.certiōrō(Āctum.class.getSimpleName(), scrīptiō, "fīnītur prōdūcere.");
        return Āctum.conditōr().fundāmen(fundāmen).modus(modus).vōx(vōx).tempus(tempus)
                    .numerāle(numerāle).persōna(persōna).scrīptiō(scrīptiō).condam();
      }
    } else {
      nūntius.moneō(Āctum.class.getSimpleName().replace("um", "ī"),
                    StringUtils.firstNonBlank(fundāmen, scrīptiō), "prōductiō fōrmae nūllae prōcessit.");
      return null;
    }
  }

  public @Override void allegō(@NotNull final String nōmen, @NotNull final String dēscrīptor) {
    switch (nōmen) {
      case "modus" -> modus = Modus.dēfīniam(dēscrīptor, Modus.NŪLLUM);
      case "vōx" -> vōx = Vōx.dēfīniam(dēscrīptor, Vōx.NŪLLUM);
      case "tempus" -> tempus = Tempus.dēfīniam(dēscrīptor, Tempus.NŪLLUM);
      case "numerāle" -> numerāle = Numerāle.dēfīniam(dēscrīptor, Numerāle.NŪLLUM);
      case "persōna" -> persōna = Persōna.dēfīniam(dēscrīptor, Persōna.NŪLLUM);
      case "fundāmen" -> fundāmen = dēscrīptor.trim();
      default -> {
        nūntius.moneō(Āctum.class.getSimpleName().replace("um", "ō"),
                      "Attribūta inopīnāta est ūsa:", nōmen, "est", dēscrīptor);
        return;
      }
    }

    nūntius.garriō("Cōntrūctiōnī adiēcī conditiōnem novam:", nōmen, "est", dēscrīptor);
  }

  public @Override void restituō( ) {
    numerāle = Numerāle.NŪLLUM;
    persōna = Persōna.NŪLLUM;
    tempus = Tempus.NŪLLUM;
    modus = Modus.NŪLLUM;
    vōx = Vōx.NŪLLUM;
    nūntius.certiōrō(getClass().getSimpleName(), "est restitūtus.");
  }
}
