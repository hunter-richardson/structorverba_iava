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
 * Classis {@link ConditōrĀctīs} est vās classis {@link Conditōr} classī {@link Āctus}.
 * @see Āctus
 * @see Nūntius.NūntiusConditōrīĀctīs
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection" })
@Singleton @DependsOn("NūntiusConditōrīĀctīs")
public final class ConditōrĀctīs extends ConditōrMultiplicibus <Āctus> {
  @Nullable private static ConditōrĀctīs īnstantia = null;

  /**
   * Valor hic viam reī classis huiuc facit.
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
   */
  @NotNull public static final Supplier <ConditōrĀctīs> fac =
    () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new ConditōrĀctīs());

  @NotNull private Modus     modus     = Modus.NŪLLUS;
  @NotNull private Vōx       vōx       = Vōx.NŪLLA;
  @NotNull private Tempus    tempus    = Tempus.INTEMPORĀLE;
  @NotNull private Numerālis numerālis = Numerālis.NŪLLUS;
  @NotNull private Persōna   persōna   = Persōna.NŪLLA;

  private ConditōrĀctīs( ) {
    super(Nūntius.NūntiusConditōrīĀctīs.fac);
    nūntius.plūrimumGarriō("Factus sum");
  }

  /**
   * {@inheritDoc}
   * @return Rem novam classis {@link Āctus}. <br>
   * Modus hid valōrem {@code null} refert sī nōn valet valor aliquis rēs haec continet.
   */
  @Override @Nullable
  public Āctus condam( ) {
    if (ObjectUtils.allNotNull(modus, vōx, tempus, numerālis, persōna, numerālis)
     && StringUtils.isNoneBlank(fundāmen, scrīptiō)) {
      final Āctus hoc = Āctus.conditōr().fundāmen(fundāmen).modus(modus).vōx(vōx).tempus(tempus)
                             .numerālis(numerālis).persōna(persōna).scrīptiō(scrīptiō).condam();
      if(Objects.isNull(hoc)) {
        nūntius.moneō(Āctus.class.getSimpleName().replace("us", "ī"),
                      StringUtils.firstNonBlank(fundāmen, scrīptiō), "prōductiō fōrmae nūllae prōcessit.");
        return null;
      } else {
        nūntius.certiōrō(Āctus.class.getSimpleName(), scrīptiō, "fīnītur prōdūcere.");
        return hoc;
      }
    } else {
      nūntius.moneō(Āctus.class.getSimpleName().replace("us", "ī"),
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
  @Override public void allegō(@NotNull final String nōmen, @NotNull final String dēscrīptor) {
    switch (nōmen) {
      case "modus" -> modus = Modus.dēfīniam(dēscrīptor);
      case "vōx" -> vōx = Vōx.dēfīniam(dēscrīptor);
      case "tempus" -> tempus = Tempus.dēfīniam(dēscrīptor);
      case "numerālis" -> numerālis = Numerālis.dēfīniam(dēscrīptor);
      case "persōna" -> persōna = Persōna.dēfīniam(dēscrīptor);
      case "fundāmen" -> fundāmen = dēscrīptor.trim();
      default -> {
        nūntius.moneō(Āctus.class.getSimpleName().replace("us", "ō"),
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
   * @see Tempus#INTEMPORĀLE
   * @see Numerālis#NŪLLUS
   * @see Persōna#NŪLLA
   */
  @Override public void restituō( ) {
    numerālis = Numerālis.NŪLLUS;
    persōna = Persōna.NŪLLA;
    tempus = Tempus.INTEMPORĀLE;
    modus = Modus.NŪLLUS;
    vōx = Vōx.NŪLLA;
    scrīptiō = StringUtils.EMPTY;
    nūntius.certiōrō("Restitūtus sum");
  }
}
