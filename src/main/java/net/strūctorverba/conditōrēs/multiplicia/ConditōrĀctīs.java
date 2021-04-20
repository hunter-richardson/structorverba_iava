package net.strūctorverba.conditōrēs.multiplicia;

import net.strūctorverba.conditōrēs.Conditōr;
import net.strūctorverba.nūntiī.Nūntius;
import net.strūctorverba.verba.Verbum;
import net.strūctorverba.verba.multiplicia.*;
import net.strūctorverba.ēnumerātiōnēs.*;
import org.apache.commons.lang3.*;
import org.jetbrains.annotations.*;

import javax.ejb.*;
import java.util.Objects;
import java.util.function.Supplier;

/**
 * Classis {@link ConditōrĀctīs} est vās classis {@link Conditōr} classī {@link Āctum}.
 * @see Āctum
 * @see Nūntius.NūntiusConditōrīĀctīs
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection" })
@Singleton @DependsOn("NūntiusConditōrīĀctīs")
public final class ConditōrĀctīs extends ConditōrMultiplicibus <Āctum> {
  private static @Nullable ConditōrĀctīs īnstantia = null;

  /**
   * Valor hic viam reī classis huiuc facit.
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
   */
  public static final @NotNull Supplier <ConditōrĀctīs> fac =
    () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new ConditōrĀctīs());

  private @NotNull Modus     modus     = Modus.NŪLLUS;
  private @NotNull Vōx       vōx       = Vōx.NŪLLA;
  private @NotNull Tempus    tempus    = Tempus.NŪLLUM;
  private @NotNull Numerālis numerālis = Numerālis.NŪLLUS;
  private @NotNull Persōna   persōna   = Persōna.NŪLLA;

  private ConditōrĀctīs( ) {
    super(Nūntius.NūntiusConditōrīĀctīs.fac);
    nūntius.plūrimumGarriō("Factus sum");
  }

  /**
   * {@inheritDoc}
   * @return Rem novam classis {@link Āctum}
   */
  public @Override @Nullable Āctum condam( ) {
    if (StringUtils.isNoneBlank(fundāmen, scrīptiō)) {
      final Āctum hoc = Āctum.conditōr().fundāmen(fundāmen).modus(modus).vōx(vōx).tempus(tempus)
                             .numerālis(numerālis).persōna(persōna).scrīptiō(scrīptiō).condam();
      if(Objects.isNull(hoc)) {
        nūntius.moneō(Āctum.class.getSimpleName().replace("um", "ī"),
                      StringUtils.firstNonBlank(fundāmen, scrīptiō), "prōductiō fōrmae nūllae prōcessit.");
        return null;
      } else {
        nūntius.certiōrō(Āctum.class.getSimpleName(), scrīptiō, "fīnītur prōdūcere.");
        return hoc;
      }
    } else {
      nūntius.moneō(Āctum.class.getSimpleName().replace("um", "ī"),
                    StringUtils.firstNonBlank(fundāmen, scrīptiō), "prōductiō fōrmae nūllae prōcessit.");
      return null;
    }
  }

  /**
   * {@inheritDoc}
   * @see Modus#dēfīniam(String)
   * @see Vōx#dēfīniam(String)
   * @see Tempus#dēfīniam(String)
   * @see Numerālis#dēfīniam(String)
   * @see Persōna#dēfīniam(String)
   * @see Verbum#fundāmen
   */
  public @Override void allegō(@NotNull final String nōmen, @NotNull final String dēscrīptor) {
    switch (nōmen) {
      case "modus" -> modus = Modus.dēfīniam(dēscrīptor);
      case "vōx" -> vōx = Vōx.dēfīniam(dēscrīptor);
      case "tempus" -> tempus = Tempus.dēfīniam(dēscrīptor);
      case "numerālis" -> numerālis = Numerālis.dēfīniam(dēscrīptor);
      case "persōna" -> persōna = Persōna.dēfīniam(dēscrīptor);
      case "fundāmen" -> fundāmen = dēscrīptor.trim();
      default -> {
        nūntius.moneō(Āctum.class.getSimpleName().replace("um", "ō"),
                      "Attribūta inopīnāta est ūsa:", nōmen, "est", dēscrīptor);
        return;
      }
    }

    nūntius.garriō("Cōntrūctiōnī adiēcī conditiōnem novam:", nōmen, "est", dēscrīptor);
  }

  /**
   * {@inheritDoc}
   * @see Modus#NŪLLUS
   * @see Vōx#NŪLLA
   * @see Tempus#NŪLLUM
   * @see Numerālis#NŪLLUS
   * @see Persōna#NŪLLA
   */
  public @Override void restituō( ) {
    numerālis = Numerālis.NŪLLUS;
    persōna = Persōna.NŪLLA;
    tempus = Tempus.NŪLLUM;
    modus = Modus.NŪLLUS;
    vōx = Vōx.NŪLLA;
    scrīptiō = StringUtils.EMPTY;
    nūntius.certiōrō("Restitūtus sum");
  }
}
