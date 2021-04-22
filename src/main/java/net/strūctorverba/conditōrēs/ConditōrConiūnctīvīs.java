package net.strūctorverba.conditōrēs;

import lombok.Getter;
import lombok.experimental.Accessors;
import net.strūctorverba.nūntiī.Nūntius;
import net.strūctorverba.tenōrēs.Tenor;
import net.strūctorverba.verba.*;
import org.apache.commons.lang3.*;
import org.jetbrains.annotations.*;

import javax.ejb.*;
import java.util.Objects;
import java.util.function.*;

/**
 * Classis {@link ConditōrConiūnctīvīs} est vās classis {@link Tenor} classī {@link VerbumSimplex.Coniūnctīvum}.
 * @see VerbumSimplex.Coniūnctīvum
 * @see Nūntius.NūntiusConditōrīConiūnctivīs
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection" })
@Singleton @DependsOn("NūntiusConditōrīAdverbiīs")
public final class ConditōrConiūnctīvīs extends Conditōr <VerbumSimplex.Coniūnctīvum> {
  @Nullable private static ConditōrConiūnctīvīs īnstantia = null;

  @Getter(lazy = true) @Accessors(fluent = true)
  @NotNull private final Function <@NotNull String, VerbumSimplex.Coniūnctīvum> cōnstrūctor =
    fundāmen -> VerbumSimplex.Coniūnctīvum.conditōr().fundāmen(fundāmen).condam();

  /**
   * Valor hic viam reī classis huiuc facit.
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
   */
  @NotNull public static final Supplier <ConditōrConiūnctīvīs> fac =
    () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new ConditōrConiūnctīvīs());

  private ConditōrConiūnctīvīs( ) {
    super(Nūntius.NūntiusConditōrīConiūnctivīs.fac);
    nūntius.plūrimumGarriō("Factus sum");
  }

  /**
   * {@inheritDoc}
   */
  @Override @Nullable
  public final VerbumSimplex.Coniūnctīvum condam( ) {
    final VerbumSimplex.Coniūnctīvum hoc = StringUtils.isNotBlank(fundāmen) ? cōnstrūctor().apply(fundāmen)
                                                                            : null;
    referō(hoc);
    return hoc;
  }

  /**
   * Modus hic rem classis {@link VerbumSimplex.Coniūnctīvum} accipit et valōrī {@link ConditōrConiūnctīvīs#nūntius} ita refert.
   * @param hoc rem tentanda
   */
  protected void referō(@Nullable final VerbumSimplex.Coniūnctīvum hoc) {
    if (Objects.isNull(hoc)) {
      nūntius.certiōrō(VerbumSimplex.Coniūnctīvum.class.getSimpleName(), fundāmen, "fīnītur prōdūcere.");
    } else {
      nūntius.moneō(VerbumSimplex.Coniūnctīvum.class.getSimpleName().replace("um", "ī"),
                    "prōductiō fōrmae nūllae prōcessit.");
    }
  }
}
