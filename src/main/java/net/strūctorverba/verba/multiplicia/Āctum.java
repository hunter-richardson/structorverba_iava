package net.strūctorverba.verba.multiplicia;

import lombok.*;
import lombok.experimental.Accessors;
import net.strūctorverba.lēctōrēs.LēctorMultiplicibus;
import net.strūctorverba.mīscella.Ūtilitās;
import net.strūctorverba.nūntiī.*;
import net.strūctorverba.ēnumerātiōnēs.*;
import org.apache.commons.lang3.ObjectUtils;
import org.jetbrains.annotations.*;

import java.util.Objects;
import java.util.function.Supplier;

@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection", "unused" })
public final class Āctum extends VerbumMultiplex <Āctum> {
  @Getter(lazy = true) @Accessors(fluent = true)
  private final @NotNull LēctorMultiplicibus.LēctorAdiectīvīs adiectīva = LēctorMultiplicibus.LēctorAdiectīvīs.fac.get();

  @Getter(lazy = true) @Accessors(fluent = true)
  private final @NotNull LēctorMultiplicibus.LēctorĀctīs ācta = LēctorMultiplicibus.LēctorĀctīs.fac.get();

  @Getter(lazy = true) @Accessors(fluent = true)
  private final @NotNull NūntiusĀctōrum nūntius = NūntiusĀctōrum.fac.get();

  public final @NotNull Modus    modus;
  public final @NotNull Vōx      vōx;
  public final @NotNull Tempus   tempus;
  public final @NotNull Numerāle numerāle;
  public final @NotNull Persōna  persōna;

  @Builder(builderClassName = "Conditōr", builderMethodName = "conditōr", buildMethodName = "condam")
  private Āctum(@NotNull final Modus modus, @NotNull final Vōx vōx, @NotNull final Tempus tempus,
                @NotNull final Numerāle numerāle, @NotNull final Persōna persōna,
                @NotNull final String fundāmen, @NotNull final String scrīptiō) {
    super(Catēgoria.ĀCTUM, fundāmen, Ūtilitās.minusculāsScrībō(scrīptiō));
    this.modus = modus;
    this.vōx = vōx;
    this.tempus = tempus;
    this.numerāle = numerāle;
    this.persōna = persōna;
    nūntius().plūsGarriō("Scrībor ut", scrīptiō);
  }

  public @Nullable Adiectīvum participem(@NotNull final Vōx vx, @NotNull final Tempus tmps,
                                         @NotNull final Speciālitās spclt, @NotNull final Genus gns,
                                         @NotNull final Cāsus css, @NotNull final Numerāle nmrl) {
    if(Modus.PARTICIPIUM.equals(modus)
       && vōx.equals(vx)
       && tempus.equals(tmps)) {
      return adiectīva().adveniam(toString(), spclt, gns, css, nmrl, Gradus.NŌRMĀlE);
    } else {
      Āctum alium = ācta().adveniam(fundāmen, Modus.PARTICIPIUM, vx, tmps);
      return Objects.isNull(alium) ? null
                                   : adiectīva().adveniam(alium.toString(), spclt, gns, css, nmrl, Gradus.NŌRMĀlE);
    }
  }

  public @Nullable Adiectīvum participem(@NotNull final Vōx vx, @NotNull final Speciālitās spclt,
                                         @NotNull final Genus gns, @NotNull final Cāsus css,
                                         @NotNull final Numerāle nmrl) {
    return participem(vx, tempus, spclt, gns, css, nmrl);
  }

  public @Nullable Adiectīvum participem(@NotNull final Tempus tmps, @NotNull final Speciālitās spclt,
                                         @NotNull final Genus gns, @NotNull final Cāsus css,
                                         @NotNull final Numerāle nmrl) {
    return participem(vōx, tmps, spclt, gns, css, nmrl);
  }

  public @Nullable Adiectīvum participem(@NotNull final Speciālitās spclt, @NotNull final Genus gns,
                                         @NotNull final Cāsus css, @NotNull final Numerāle nmrl) {
    return participem(vōx, tempus, spclt, gns, css, nmrl);
  }

  public static final class NūntiusĀctōrum extends Nūntius {
    private static @Nullable Āctum.NūntiusĀctōrum īnstantia = null;

    public static final @NotNull Supplier<NūntiusĀctōrum> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new NūntiusĀctōrum());

    private NūntiusĀctōrum( ) {
      super(ParametrīNūntiī.parā(Āctum.Conditōr.class));
    }
  }
}
