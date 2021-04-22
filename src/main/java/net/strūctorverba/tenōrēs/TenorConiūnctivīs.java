package net.strūctorverba.tenōrēs;

import lombok.Getter;
import lombok.experimental.Accessors;
import net.strūctorverba.conditōrēs.ConditōrConiūnctīvīs;
import net.strūctorverba.nūntiī.Nūntius;
import net.strūctorverba.verba.*;
import org.apache.commons.lang3.ObjectUtils;
import org.jetbrains.annotations.*;

import javax.ejb.*;
import java.util.Objects;
import java.util.function.Supplier;

/**
 * Classis {@link TenorConiūnctivīs} est vās classis {@link Tenor} classī {@link VerbumSimplex.Coniūnctīvum}
 * @see VerbumSimplex.Coniūnctīvum
 * @see Nūntius.NūntiusTenōrīConiūnctivīs
 * @see ConditōrConiūnctīvīs
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection" })
@Singleton @DependsOn({ "CondītōrConiūnctīvīs", "NūntiusTenōrīConiūnctivīs" })
public final class TenorConiūnctivīs extends Tenor <VerbumSimplex.Coniūnctīvum> {
  @Nullable private static TenorConiūnctivīs īnstantia = null;

  @Getter(lazy = true) @Accessors(fluent = true)
  @NotNull private final ConditōrConiūnctīvīs condītōr = ConditōrConiūnctīvīs.fac.get();

  /**
   * Valor hic viam reī classis huiuc facit.
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
   */
  @NotNull public static final Supplier <TenorConiūnctivīs> fac =
    () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new TenorConiūnctivīs());

  private TenorConiūnctivīs( ) {
    super(Nūntius.NūntiusTenōrīConiūnctivīs.fac);
    nūntius.plūrimumGarriō("Factus sum");
  }

  /**
   * {@inheritDoc}
   */
  @Override protected final void fīniam( ) {
    hoc = condītōr().condam();
    if (Objects.isNull(hoc)) {
      nūntius.moneō("Prōductiō verbī prōcessimus nūllae fōrmae.");
    }
  }

  /**
   * {@inheritDoc}
   * @param scrīptiō fōrmam scrīptam indendus
   * @see Verbum#fundāmen
   */
  @Override protected void scrībō(@NotNull String scrīptiō) {
    condītōr().funde(scrīptiō);
  }
}
