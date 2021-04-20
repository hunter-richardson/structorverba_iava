package net.strūctorverba.verba.disposita;

import lombok.*;
import lombok.experimental.Accessors;
import net.strūctorverba.mīscella.StrūctorVerba;
import net.strūctorverba.nūntiī.Nūntius;
import net.strūctorverba.verba.*;
import net.strūctorverba.verba.multiplicia.*;
import net.strūctorverba.ēnumerātiōnēs.*;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

/**
 * Classis {@link VerbaPraepositiōne} rēs classum {@link Nōminālis} et {@link VerbumSimplex.Praepositiō} conciliat. <br>
 * VerbaPraepositiōne catēgoriam {@link Catēgoria#VERBA_PRAEPOSITIŌNE} ūtuntur et sunt generātī statim quam cōnservātī in scrīnium <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>.
 * @see Nūntius.NūntiusVerbōrumPraepositiōnibus
 * @see StrūctorVerba
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection", "unused" })
public final class VerbaPraepositiōne extends VerbumMultiplex <VerbaPraepositiōne> {
  @Getter(lazy = true) @Accessors(fluent = true)
  private final @NotNull Nūntius.NūntiusVerbōrumPraepositiōnibus nūntius = Nūntius.NūntiusVerbōrumPraepositiōnibus.fac.get();

  private final @NotNull VerbumSimplex.Praepositiō praepositiō;
  private final @NotNull Nōminālis <?>             rēs;

  @Builder(access = AccessLevel.PUBLIC, builderClassName = "Conditōr", builderMethodName = "conditōr", buildMethodName = "condam")
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

  @Builder(access = AccessLevel.PUBLIC, builderClassName = "Conditōr", builderMethodName = "conditōr", buildMethodName = "condam")
  private VerbaPraepositiōne(@NotNull final Nōminālis <?> rēs) {
    super(Catēgoria.VERBA_PRAEPOSITIŌNE, rēs.fundāmen, rēs.toString());
    praepositiō = VerbumSimplex.Praepositiō.assūme.get();
    this.rēs = rēs;

    nūntius().plūsGarriō("Scrībor ut", toString());
  }

  /**
   * @param cltm valōrem {@link #encliticum} indicat.
   * @return Rem hanc
   */
  @SuppressWarnings("UnusedReturnValue")
  public @Override @NotNull VerbaPraepositiōne allege(@NotNull final Encliticum cltm) {
    encliticum = cltm;
    rēs.allege(encliticum);
    nūntius().plūrimumGarriō("Encliticum allēctum", encliticum);
    return this;
  }

  /**
   * @return Repraesentātiōnem scrīpta reī classis {@link Verbum}. <br>
   * Valōrem rēs classum {@link Nōminālis} et {@link VerbumSimplex.Praepositiō} addit.
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
}
