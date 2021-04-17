package net.strūctorverba.verba.multiplicia;

import lombok.*;
import lombok.experimental.Accessors;
import net.strūctorverba.nūntiī.*;
import net.strūctorverba.ēnumerātiōnēs.*;
import org.apache.commons.lang3.ObjectUtils;
import org.jetbrains.annotations.*;

import java.util.function.Supplier;

/**
 * Classis {@link Nōmen} repraesentat nōmina ut coniectēris.
 * Nōmina catēgoriam {@link Catēgoria#NŌMEN} ūtuntur et cōnservāta sunt in scrīniō <a href="../src/main/resources/nōmina">nōmina</a>.
 * @see LēctorMultiplicibus.LēctorNōminibus
 * @see TenorMultiplicibus.TenorNōminibus
 * @see InventorNōminibus
 * @see ConditōrNōminibus
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection" })
public final class Nōmen extends Nōminālis <Nōmen> {
  @Getter(lazy = true) @Accessors(fluent = true)
  private final @NotNull NūntiusNōminum nūntius = NūntiusNōminum.fac.get();

  @Builder(builderClassName = "Conditōr", builderMethodName = "conditōr", buildMethodName = "condam")
  private Nōmen(@NotNull final Speciālitās speciālitās, @NotNull final Genus genus,
                @NotNull final Cāsus cāsus, @NotNull final Numerāle numerāle,
                @NotNull final String fundāmen, @NotNull final String scrīptiō) {
    super(Catēgoria.NŌMEN, speciālitās, genus, cāsus, numerāle, fundāmen, scrīptiō);
    nūntius().plūsGarriō("Scrībor ut", scrīptiō);
  }

  public static final class NūntiusNōminum extends Nūntius {
    private static @Nullable NūntiusNōminum īnstantia = null;

    public static final @NotNull Supplier <NūntiusNōminum> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new NūntiusNōminum());

    private NūntiusNōminum( ) {
      super(ParametrīNūntiī.parā(Nōmen.Conditōr.class));
    }
  }
}
