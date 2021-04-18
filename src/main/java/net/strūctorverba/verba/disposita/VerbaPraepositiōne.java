package net.strūctorverba.verba.disposita;

import lombok.*;
import lombok.experimental.Accessors;
import net.strūctorverba.mīscella.StrūctorVerba;
import net.strūctorverba.nūntiī.*;
import net.strūctorverba.verba.*;
import net.strūctorverba.verba.multiplicia.*;
import net.strūctorverba.ēnumerātiōnēs.*;
import org.apache.commons.lang3.*;
import org.jetbrains.annotations.*;

import java.util.function.Supplier;

/**
 * Classis {@link VerbaPraepositiōne} rēs classum {@link Nōminālis} et {@link VerbumSimplex.Praepositiō} conciliat.
 * VerbaPraepositiōne catēgoriam {@link Catēgoria#VERBA_PRAEPOSITIŌNE} ūtuntur et sunt generātī statim quam cōnservātī intrā scrīnium <a href="../src/main/resources">auxiliārēs</a>.
 * @see StrūctorVerba
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection", "unused" })
public final class VerbaPraepositiōne extends VerbumMultiplex <VerbaPraepositiōne> {
  @Getter(lazy = true) @Accessors(fluent = true)
  private final @NotNull NūntiusVerbōrumPraepositiōnibus nūntius = NūntiusVerbōrumPraepositiōnibus.fac.get();

  private final @NotNull VerbumSimplex.Praepositiō praepositiō;
  private final @NotNull Nōminālis <?>             rēs;

  @Builder(builderClassName = "Conditōr", builderMethodName = "conditōr", buildMethodName = "condam")
  private VerbaPraepositiōne(@NotNull final Nōminālis <?> rēs,
                             @NotNull final VerbumSimplex.Praepositiō praepositiō) {
    super(Catēgoria.VERBA_PRAEPOSITIŌNE, rēs.fundāmen, rēs.toString());
    if ("aāeēhīoōuūyȳ".indexOf(rēs.fundāmen.charAt(0)) > -1) {
      switch (praepositiō.fundāmen) {
        case "ā" -> this.praepositiō = VerbumSimplex.Praepositiō.conditōr().fundāmen("ab").condam();
        case "ē" -> this.praepositiō = VerbumSimplex.Praepositiō.conditōr().fundāmen("ex").condam();
        default -> this.praepositiō = praepositiō;
      }
    } else {
      this.praepositiō = praepositiō;
    }

    this.rēs = rēs;
    this.rēs.allege(Encliticum.NŌLĒNS);

    nūntius().plūsGarriō("Scrībor ut", toString());
  }

  @Builder(builderClassName = "Conditōr", builderMethodName = "conditōr", buildMethodName = "condam")
  private VerbaPraepositiōne(@NotNull final Nōminālis <?> rēs) {
    super(Catēgoria.VERBA_PRAEPOSITIŌNE, rēs.fundāmen, rēs.toString());
    praepositiō = VerbumSimplex.Praepositiō.assūme.get();
    this.rēs = rēs;

    nūntius().plūsGarriō("Scrībor ut", toString());
  }

  @SuppressWarnings("UnusedReturnValue")
  public @Override @NotNull VerbaPraepositiōne allege(@NotNull final Encliticum cltm) {
    encliticum = cltm;
    rēs.allege(encliticum);
    return this;
  }

  /**
   * @return repraesentātiōnem scrīpta reī classis {@link Verbum}. Valōrem rēs classum {@link Nōminālis} et {@link VerbumSimplex.Praepositiō} addit.
   */
  public @Override @NotNull String toString( ) {
    if (StringUtils.isNotBlank(praepositiō.fundāmen)) {
      return String.format("%s %s", praepositiō.fundāmen, rēs);
    } else if (Encliticum.NŌLĒNS.equals(encliticum)) {
      return rēs.toString();
    } else {
      return String.format("%s%s", rēs, encliticum.scrīptiō);
    }
  }

  public static final class NūntiusVerbōrumPraepositiōnibus extends Nūntius {
    private static @Nullable NūntiusVerbōrumPraepositiōnibus īnstantia = null;

    public static final @NotNull Supplier <NūntiusVerbōrumPraepositiōnibus> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new NūntiusVerbōrumPraepositiōnibus());

    private NūntiusVerbōrumPraepositiōnibus() {
      super(ParametrīNūntiī.parā(VerbaPraepositiōne.Conditōr.class));
    }
  }
}
