package net.strūctorverba.verba.multiplicia;

import lombok.*;
import lombok.experimental.Accessors;
import net.strūctorverba.nūntiī.*;
import net.strūctorverba.ēnumerātiōnēs.*;
import org.apache.commons.lang3.ObjectUtils;
import org.jetbrains.annotations.*;

import java.util.function.Supplier;

@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection" })
public final class Adiectīvum extends Nōminālis <Adiectīvum> {
  @Getter(lazy = true) @Accessors(fluent = true)
  private final @NotNull NūntiusAdiectīvōrum nūntius = NūntiusAdiectīvōrum.fac.get();

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

