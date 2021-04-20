package net.strūctorverba.verba.multiplicia;

import lombok.*;
import lombok.experimental.Accessors;
import net.strūctorverba.conditōrēs.multiplicia.ConditōrPrōnōminibusConiūnctīvīs;
import net.strūctorverba.inventōrēs.InventorPrōnōminibusConiūnctīvīs;
import net.strūctorverba.lēctōrēs.LēctorMultiplicibus;
import net.strūctorverba.nūntiī.Nūntius;
import net.strūctorverba.tenōrēs.TenorMultiplicibus;
import net.strūctorverba.verba.*;
import net.strūctorverba.verba.disposita.Verba;
import net.strūctorverba.ēnumerātiōnēs.*;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.*;

import java.util.*;
import java.util.stream.*;

/**
 * Classis {@link PrōnōmenConiūnctīvum} repraesentat nōmina ut coniectēris. <br>
 * PrōnōminaConiūnctīva catēgoriam {@link Catēgoria#PRŌNŌMEN_CONIŪNCTĪVUM} ūtuntur et cōnservāta sunt in scrīniō <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>/prōnōminaConiūnctīva. <br>
 * Discrīmina prīmōria inter classibus hāc et {@link Prōnōmen} est haec modōs {@link Coniugiāle} dēfīnītōs dēdūcit.
 * @see LēctorMultiplicibus.LēctorPrōnōminibusConiūnctīvīs
 * @see TenorMultiplicibus.TenorPrōnōminibusConiūnctīvīs
 * @see InventorPrōnōminibusConiūnctīvīs
 * @see ConditōrPrōnōminibusConiūnctīvīs
 * @see Nūntius.NūntiusPrōnōminumConiūnctīvōrum
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection" })
public final class PrōnōmenConiūnctīvum extends Nōminālis <PrōnōmenConiūnctīvum> implements Coniugiāle {
  @Getter(lazy = true) @Accessors(fluent = true)
  private final @NotNull Nūntius.NūntiusPrōnōminumConiūnctīvōrum nūntius = Nūntius.NūntiusPrōnōminumConiūnctīvōrum.fac.get();

  @Builder(access = AccessLevel.PUBLIC, builderClassName = "Conditōr", builderMethodName = "conditōr", buildMethodName = "condam")
  private PrōnōmenConiūnctīvum(@NotNull final Speciālitās speciālitās, @NotNull final Genus genus,
                               @NotNull final Cāsus cāsus, @NotNull final Numerālis numerālis,
                               @NotNull final String fundāmen, @NotNull final String scrīptiō) {
    super(Catēgoria.PRŌNŌMEN_CONIŪNCTĪVUM, speciālitās, genus, cāsus, numerālis, fundāmen, scrīptiō);
    nūntius().plūsGarriō("Scrībor ut", scrīptiō);
  }

    /**
     * {@inheritDoc}
     * @param prīmus valor prīmus
     * @param secundus valor secundus
     * @param <Ille> classis quae valōrēs et {@code prīmus} et {@code secundus} quadrat
     * @return Seriēs classis {@link Verbum} quae valōrum et {@code prīmus} et huius et {@code secundus} ōrdine constat
     */
  public <Ille extends Verbum <Ille>> @NotNull LinkedList <Verbum <@Nullable ?>> coniugō(@Nullable final Ille prīmus,
                                                                                         @Nullable final Ille secundus) {
    nūntius().plūrimumGarriō("Scrībor ut", prīmus, this, secundus);
    return Stream.of(prīmus, this, secundus)
                 .filter(Objects::nonNull)
                 .filter(verbum -> StringUtils.isNotBlank(verbum.toString()))
                 .collect(Collectors.toCollection(LinkedList::new));
  }

    /**
     * {@inheritDoc}
     * @param prīmus valor prīmus
     * @param secundus valor secundus
     * @return Rēs classis {@link Verba} quae valōrum et {@code prīmus} et huius et {@code secundus} constat
     */
  public @NotNull Verba coniugō(@NotNull final Verba prīmus, @NotNull final Verba secundus) {
    nūntius().plūrimumGarriō("Scrībor ut", prīmus, this, secundus);
    prīmus.coniūnctīvumAllegōContinuōque(this, secundus);
    return prīmus;
  }

    /**
     * {@inheritDoc}
     * @param prīmus valor prīmus
     * @param secundus valor secundus
     * @return Rēs classis {@link Verba} quae valōrum et {@code prīmus} et huius et {@code secundus} constat
     */
  public @NotNull Verba coniugō(@NotNull final Verba prīmus, @NotNull final LinkedList <Verbum <@Nullable ?>> secundus) {
    prīmus.coniūnctīvumAllegōContinuōque(this, Verba.conditōr().seriēs(secundus).condam());
    return prīmus;
  }
}
