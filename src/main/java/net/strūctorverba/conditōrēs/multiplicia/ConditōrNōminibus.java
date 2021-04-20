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
 * Classis {@link ConditōrNōminibus} est vās classis {@link Conditōr} classī {@link Nōmen}.
 * @see Nōmen
 * @see Nūntius.NūntiusConditōrīNōminibus
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection" })
@Singleton
@DependsOn("NūntiusConditōrīNōminibus")
public final class ConditōrNōminibus extends ConditōrMultiplicibus <Nōmen> {
  private static @Nullable ConditōrNōminibus īnstantia = null;

  /**
   * Valor hic viam reī classis huiuc facit.
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
   */
  public static final @NotNull Supplier <ConditōrNōminibus> fac =
    () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new ConditōrNōminibus());

  private @NotNull Speciālitās speciālitās = Speciālitās.NŪLLUM;
  private @NotNull Genus       genus       = Genus.NŪLLUM;
  private @NotNull Numerālis   numerālis   = Numerālis.NŪLLUS;
  private @NotNull Cāsus       cāsus       = Cāsus.NŪLLUS;

  private ConditōrNōminibus( ) {
    super(Nūntius.NūntiusConditōrīNōminibus.fac);
    nūntius.plūrimumGarriō("Factus sum");
  }

  /**
   * {@inheritDoc}
   * @return Rem novam classis {@link Nōmen}
   */
  public @Override @Nullable Nōmen condam( ) {
    if (StringUtils.isNoneBlank(fundāmen, scrīptiō)) {
      final Nōmen hoc = Nōmen.conditōr().fundāmen(fundāmen).speciālitās(speciālitās).genus(genus)
                             .cāsus(cāsus).numerālis(numerālis).scrīptiō(scrīptiō).condam();
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

  /**
   * {@inheritDoc}
   * @see Speciālitās#dēfīniam(String)
   * @see Genus#dēfīniam(String)
   * @see Cāsus#dēfīniam(String)
   * @see Numerālis#dēfīniam(String)
   * @see Verbum#fundāmen
   */
  public @Override void allegō(@NotNull final String nōmen, @NotNull final String dēscrīptor) {
    switch (nōmen) {
      case "speciālitās" -> speciālitās = Speciālitās.dēfīniam(dēscrīptor);
      case "genus" -> genus = Genus.dēfīniam(dēscrīptor);
      case "numerālis" -> numerālis = Numerālis.dēfīniam(dēscrīptor);
      case "cāsus" -> cāsus = Cāsus.dēfīniam(dēscrīptor);
      case "fundāmen" -> fundāmen = dēscrīptor.trim();
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
   * @see Cāsus#NŪLLUS
   * @see Numerālis#NŪLLUS
   */
  public @Override void restituō( ) {
    speciālitās = Speciālitās.NŪLLUM;
    genus = Genus.NŪLLUM;
    cāsus = Cāsus.NŪLLUS;
    numerālis = Numerālis.NŪLLUS;
    scrīptiō = StringUtils.EMPTY;
    nūntius.certiōrō("Restitūtus sum");
  }
}
