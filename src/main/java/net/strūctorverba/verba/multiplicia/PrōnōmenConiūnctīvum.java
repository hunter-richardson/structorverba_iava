package net.strūctorverba.verba.multiplicia;

import lombok.*;
import lombok.experimental.Accessors;
import net.strūctorverba.nūntiī.*;
import net.strūctorverba.verba.*;
import net.strūctorverba.verba.disposita.Verba;
import net.strūctorverba.ēnumerātiōnēs.*;
import org.apache.commons.lang3.*;
import org.jetbrains.annotations.*;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.*;

/**
 * Classis {@link PrōnōmenConiūnctīvum} repraesentat nōmina ut coniectēris.
 * PrōnōminaConiūnctīva catēgoriam {@link Catēgoria#PRŌNŌMEN_CONIŪNCTĪVUM} ūtuntur et cōnservāta sunt in scrīniō <a href="../src/main/resources/prōnōminaConiūnctīva">prōnōminaConiūnctīva</a>.
 * Discrīmina prīmōria inter classibus hāc et {@link Prōnōmen} est haec modōs {@link Coniugiāle} dēfīnītōs dēdūcit.
 * @see LēctorMultiplicibus.LēctorPrōnōminibusConiūnctīvīs
 * @see TenorMultiplicibus.TenorPrōnōminibusConiūnctīvīs
 * @see InventorPrōnōminibusConiūnctīvīs
 * @see ConditōrPrōnōminibusConiūnctīvīs
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection" })
public final class PrōnōmenConiūnctīvum extends Nōminālis <PrōnōmenConiūnctīvum> implements Coniugiāle {
  @Getter(lazy = true) @Accessors(fluent = true)
  private final @NotNull NūntiusPrōnōminumConiūnctīvōrum nūntius = NūntiusPrōnōminumConiūnctīvōrum.fac.get();

  @Builder(builderClassName = "Conditōr", builderMethodName = "conditōr", buildMethodName = "condam")
  private PrōnōmenConiūnctīvum(@NotNull final Speciālitās speciālitās, @NotNull final Genus genus,
                               @NotNull final Cāsus cāsus, @NotNull final Numerāle numerāle,
                               @NotNull final String fundāmen, @NotNull final String scrīptiō) {
    super(Catēgoria.PRŌNŌMEN_CONIŪNCTĪVUM, speciālitās, genus, cāsus, numerāle, fundāmen, scrīptiō);
    nūntius().plūsGarriō("Scrībor ut", scrīptiō);
  }

    /**
     * {@inheritDoc}
     */
  public <Illud extends Verbum <Illud>> @NotNull LinkedList <Verbum <@Nullable ?>> coniugō(@Nullable final Illud prīma,
                                                                                           @Nullable final Illud secunda) {
    return Stream.of(prīma, this, secunda)
                 .filter(Objects::nonNull)
                 .filter(verbum -> StringUtils.isNotBlank(verbum.toString()))
                 .collect(Collectors.toCollection(LinkedList::new));
  }

    /**
     * {@inheritDoc}
     */
  public @NotNull Verba coniugō(@NotNull final Verba prīma, @NotNull final Verba secunda) {
    prīma.coniūnctīvumAllegōContinuōque(this, secunda);
    return prīma;
  }

    /**
     * {@inheritDoc}
     */
  public @NotNull Verba coniugō(@NotNull final Verba prīma, @NotNull final LinkedList <Verbum <@Nullable ?>> secunda) {
    prīma.coniūnctīvumAllegōContinuōque(this, Verba.conditōr().seriēs(secunda).condam());
    return prīma;
  }

  public static final class NūntiusPrōnōminumConiūnctīvōrum extends Nūntius {
    private static @Nullable NūntiusPrōnōminumConiūnctīvōrum īnstantia = null;

    public static final @NotNull Supplier <NūntiusPrōnōminumConiūnctīvōrum> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new NūntiusPrōnōminumConiūnctīvōrum());

    private NūntiusPrōnōminumConiūnctīvōrum() {
      super(ParametrīNūntiī.parā(PrōnōmenConiūnctīvum.Conditōr.class));
    }
  }
}
