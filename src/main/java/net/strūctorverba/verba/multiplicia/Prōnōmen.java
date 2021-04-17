package net.strūctorverba.verba.multiplicia;

import lombok.*;
import lombok.experimental.Accessors;
import net.strūctorverba.nūntiī.*;
import net.strūctorverba.ēnumerātiōnēs.*;
import org.apache.commons.lang3.ObjectUtils;
import org.jetbrains.annotations.*;

import java.util.function.Supplier;

/**
 * Classis {@link Prōnōmen} repraesentat nōmina ut coniectēris.
 * Prōnōmina catēgoriam {@link Catēgoria#PRŌNŌMEN} ūtuntur et cōnservāta sunt in scrīniō <a href="../src/main/resources/prōnōmina">prōnōmina</a>.
 * @see LēctorMultiplicibus.LēctorPrōnōminibus
 * @see TenorMultiplicibus.TenorPrōnōminibus
 * @see InventorPrōnōminibus
 * @see ConditōrPrōnōminibus
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection" })
public final class Prōnōmen extends Nōminālis <Prōnōmen> {
  @Getter(lazy = true) @Accessors(fluent = true)
  private final @NotNull NūntiusPrōnōminum nūntius = NūntiusPrōnōminum.fac.get();

  @Builder(builderClassName = "Conditōr", builderMethodName = "conditōr", buildMethodName = "condam")
  private Prōnōmen(@NotNull final Speciālitās speciālitās, @NotNull final Genus genus,
                   @NotNull final Cāsus cāsus, @NotNull final Numerāle numerāle,
                   @NotNull final String fundāmen, @NotNull final String scrīptiō) {
    super(Catēgoria.PRŌNŌMEN, speciālitās, genus, cāsus, numerāle, fundāmen, scrīptiō);
    nūntius().plūsGarriō("Scrībor ut", scrīptiō);
  }

  public static final class NūntiusPrōnōminum extends Nūntius {
    private static @Nullable NūntiusPrōnōminum īnstantia = null;

    public static final @NotNull Supplier <NūntiusPrōnōminum> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new NūntiusPrōnōminum());

    private NūntiusPrōnōminum() {
      super(ParametrīNūntiī.parā(Prōnōmen.Conditōr.class));
    }
  }
}
