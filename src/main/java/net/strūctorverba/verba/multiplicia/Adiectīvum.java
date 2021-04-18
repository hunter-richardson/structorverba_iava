package net.strūctorverba.verba.multiplicia;

import lombok.*;
import lombok.experimental.Accessors;
import net.strūctorverba.conditōrēs.multiplicia.ConditōrAdiectīvīs;
import net.strūctorverba.inventōrēs.InventorAdiectīvīs;
import net.strūctorverba.lēctōrēs.LēctorMultiplicibus;
import net.strūctorverba.nūntiī.*;
import net.strūctorverba.tenōrēs.TenorMultiplicibus;
import net.strūctorverba.ēnumerātiōnēs.*;
import org.apache.commons.lang3.ObjectUtils;
import org.jetbrains.annotations.*;

import java.util.function.Supplier;

/**
 * Classis {@link Adiectīvum} repraesentat adiectīva ut coniectēris.
 * Adiectīva catēgoriam {@link Catēgoria#NŌMEN} ūtuntur et cōnservāta sunt in scrīniō <a href="../src/main/resources/adiectīva">adiectīva</a>.
 * Discrīmina prīmōria inter classibus hāc et {@link Prōnōmen} est huius valor {@link #gradus}.
 * @see LēctorMultiplicibus.LēctorAdiectīvīs
 * @see TenorMultiplicibus.TenorAdiectīvīs
 * @see InventorAdiectīvīs
 * @see ConditōrAdiectīvīs
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection" })
public final class Adiectīvum extends Nōminālis <Adiectīvum> {
  @Getter(lazy = true) @Accessors(fluent = true)
  private final @NotNull NūntiusAdiectīvōrum nūntius = NūntiusAdiectīvōrum.fac.get();

  /**
   * Valor hic potentiam reī huius dēsignat.
   * @see Gradus
   */
  public final @NotNull Gradus gradus;

  @Builder(builderClassName = "Conditōr", builderMethodName = "conditōr", buildMethodName = "condam")
  private Adiectīvum(@NotNull final Speciālitās speciālitās, @NotNull final Genus genus,
                     @NotNull final Cāsus cāsus, @NotNull final Numerāle numerāle,
                     @NotNull final Gradus gradus, @NotNull final String fundāmen,
                     @NotNull final String scrīptiō) {
    super(Catēgoria.ADIECTĪVUM, speciālitās, genus, cāsus, numerāle, fundāmen, scrīptiō);
    this.gradus = gradus;
    nūntius().plūsGarriō("Scrībor ut", scrīptiō);
  }

  public static final class NūntiusAdiectīvōrum extends Nūntius {
    private static @Nullable NūntiusAdiectīvōrum īnstantia = null;

    public static final @NotNull Supplier <NūntiusAdiectīvōrum> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new NūntiusAdiectīvōrum());

    private NūntiusAdiectīvōrum() {
      super(ParametrīNūntiī.parā(Āctum.Conditōr.class));
    }
  }
}

