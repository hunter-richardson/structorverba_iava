package net.strūctorverba.verba;

import com.github.chaosfirebolt.converter.RomanInteger;
import com.github.chaosfirebolt.converter.constants.IntegerType;
import com.github.chaosfirebolt.converter.util.Validator;
import lombok.*;
import lombok.experimental.Accessors;
import net.strūctorverba.conditōrēs.ConditōrSimplicibus;
import net.strūctorverba.inventōrēs.Inventor;
import net.strūctorverba.lēctōrēs.*;
import net.strūctorverba.mīscella.Ūtilitās;
import net.strūctorverba.nūntiī.Nūntius;
import net.strūctorverba.tenōrēs.TenorSimplicibus;
import net.strūctorverba.verba.disposita.Verba;
import net.strūctorverba.ēnumerātiōnēs.Catēgoria;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.*;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.*;

/**
 * Classis {@link VerbumSimplex} repraesentat verbum aliquem quod fōrmam ūnam sōlum habent.
 * Rēs classis {@link Inventor} rēbus classis huius absunt atque inūtilēs fuerint.
 * @param <Hoc> Tabellā hāc classis {@link Hoc} extēnsiōnem aptam datīs petītīs repraesentat.
 * @see LēctorSimplicibus
 * @see TenorSimplicibus
 * @see ConditōrSimplicibus
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspction" })
public abstract class VerbumSimplex <Hoc extends Verbum <Hoc>> extends Verbum <Hoc> {
  /**
   * {@inheritDoc}
   */
  protected VerbumSimplex(@NotNull final Catēgoria ctgr, @NotNull final String fdmn) {
    super(ctgr, fdmn);
  }

  /**
   * @return repraesentātiōnem scrīpta reī classis {@link VerbumSimplex}. Sōlum valōrem {@link Verbum#fundāmen} potest referre cum fōrmā ūnā.
   */
  public @Override @NotNull String toString( ) {
    return fundāmen;
  }

  /**
   * Classis {@link Adverbium} repraesentat adverbia ut coniectēris.
   * Adverbia catēgoriam {@link Catēgoria#ADVERBIUM} ūtuntur et cōnservāta sunt in scrīniō <a href="../src/main/resources/adverbia">adverbia</a>.
   * @see LēctorSimplicibus.LēctorAdverbiīs
   * @see TenorSimplicibus.TenorAdverbiīs
   * @see ConditōrSimplicibus.ConditōrAdverbiīs
   * @see Nūntius.NūntiusAdverbiōrum
   */
  public static final class Adverbium extends VerbumSimplex <Adverbium> {
    @Getter(lazy = true) @Accessors(fluent = true)
    private final @NotNull Nūntius.NūntiusAdverbiōrum nūntius = Nūntius.NūntiusAdverbiōrum.fac.get();

    @Builder(builderClassName = "Conditōr", builderMethodName = "conditōr", buildMethodName = "condam")
    private Adverbium(@NotNull final String fundāmen) {
      super(Catēgoria.ADVERBIUM, fundāmen);
      nūntius().plūsGarriō("Scrībor ut", fundāmen);
    }
  }

  /**
   * Classis {@link Coniūnctīvum} repraesentat coniūnctīva ut coniectēris.
   * Coniūnctīva catēgoriam {@link Catēgoria#CONIŪNCTĪVUM} ūtuntur et cōnservāta sunt in scrīniō <a href="../src/main/resources/coniūnctīva">coniūnctīva</a>.
   * Prōpositīs programmātis huius classis haec differt classe {@link Adverbium} sōlum in quō classis haec modōs {@link Coniugiāle} dēfīnītōs dēdūcit.
   * @see LēctorSimplicibus.LēctorConiūnctīvīs
   * @see TenorSimplicibus.TenorConiūnctivīs
   * @see ConditōrSimplicibus.ConditōrConiūnctīvīs
   * @see Nūntius.NūntiusConiūnctīvōrum
   */
  public static final class Coniūnctīvum extends VerbumSimplex <Coniūnctīvum> implements Coniugiāle {
    @Getter(lazy = true) @Accessors(fluent = true)
    private final @NotNull Nūntius.NūntiusConiūnctīvōrum nūntius = Nūntius.NūntiusConiūnctīvōrum.fac.get();

    @Builder(builderClassName = "Conditōr", builderMethodName = "conditōr", buildMethodName = "condam")
    private Coniūnctīvum(@NotNull final String fundāmen) {
      super(Catēgoria.CONIŪNCTĪVUM, fundāmen);
      nūntius().plūsGarriō("Scrībor ut", fundāmen);
    }

    /**
     * {@inheritDoc}
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
     */
    public final @NotNull Verba coniugō(@NotNull final Verba prīmus, @NotNull final Verba secundus) {
      nūntius().plūrimumGarriō("Scrībor ut", prīmus, this, secundus);
      prīmus.coniūnctīvumAllegōContinuōque(this, secundus);
      return prīmus;
    }

    /**
     * {@inheritDoc}
     */
    public final @NotNull Verba coniugō(@NotNull final Verba prīmus,
                                        @NotNull final LinkedList <Verbum <@Nullable ?>> secundus) {
      prīmus.coniūnctīvumAllegōContinuōque(this, Verba.conditōr().seriēs(secundus).condam());
      return prīmus;
    }
  }

  /**
   * Classis {@link Praepositiō} repraesentat praepositiōnēs ut coniectēris.
   * Praepositiōnēs catēgoriam {@link Catēgoria#PRAEPOSITIŌ} ūtuntur et cōnservāta sunt in scrīniō <a href="../src/main/resources/praepositiōnēs">praepositiōnēs</a>.
   * @see LēctorPraepositiōnibus
   * @see Nūntius.NūntiusPraepositiōnum
   */
  public static final class Praepositiō extends VerbumSimplex <Praepositiō> {
    @Getter(lazy = true) @Accessors(fluent = true)
    private final @NotNull Nūntius.NūntiusPraepositiōnum nūntius = Nūntius.NūntiusPraepositiōnum.fac.get();

    public static final @NotNull Supplier<Praepositiō> assūme =
      () -> Praepositiō.conditōr().fundāmen(StringUtils.EMPTY).condam();

    @Builder(builderClassName = "Conditōr", builderMethodName = "conditōr", buildMethodName = "condam")
    private Praepositiō(@NotNull final String fundāmen) {
      super(Catēgoria.PRAEPOSITIŌ, fundāmen);
      nūntius().plūsGarriō("Scrībor ut", fundāmen);
    }
  }

  /**
   * Classis {@link Numerus} repraesentat numerōs ut coniectēris.
   * Numerī catēgoriam {@link Catēgoria#NUMERUM} ūtuntur et sunt generātī statim quam cōnservātī intrā scrīnium <a href="../src/main/resources">auxiliārēs</a>.
   * @see <a href="https://github.com/Chaosfirebolt/RomanNumeralConverter/blob/master/src/main/java/com/github/chaosfirebolt/converter/RomanInteger.java">RomanInteger</a>
   * @see Nūntius.NūntiusNumerōrum
   */
  public static final class Numerus extends VerbumSimplex<Numerus> {
    @Getter(lazy = true) @Accessors(fluent = true)
    private final @NotNull Nūntius.NūntiusNumerōrum nūntius = Nūntius.NūntiusNumerōrum.fac.get();

    /**
     * Valor hic repraesentātiōnem numeriam tenet reī classis {@link Numerus}.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/lang/Short.html">Short</a>
     */
    public final short numerus;

    @Builder(builderClassName = "Conditōr", builderMethodName = "conditōr", buildMethodName = "condam")
    private Numerus(final short numerus) throws IllegalArgumentException {
      super(Catēgoria.NUMERUM, String.valueOf(numerus));
      this.numerus = Validator.range(Short.toUnsignedInt(numerus)).shortValue();
      nūntius().plūsGarriō("Scrībor ut", toString());
    }

    private RomanInteger ostendam() throws IllegalArgumentException {
      return RomanInteger.parse(String.valueOf(numerus), IntegerType.ARABIC);
    }

    /**
     * @return repraesentātiōnem scrīpta reī classis {@link Numerus}.
     * @see <a href="https://github.com/Chaosfirebolt/RomanNumeralConverter/blob/master/src/main/java/com/github/chaosfirebolt/converter/RomanInteger.java">RomanInteger</a>
     */
    public @Override @NotNull String toString() throws IllegalArgumentException {
      try {
        return Ūtilitās.capitāneāsScrībō(ostendam().toString());
      } catch (IllegalArgumentException e) {
        nūntius().terreō(e);
        return StringUtils.EMPTY;
      }
    }

    /**
     * @return rem classis {@link Numerus} quae ēventum additiōnis cum valōre {@code alius} repraesentat.
     * @param alius Rēs classis {@link Numerus} ūsa additiōnī.
     * @see <a href="https://github.com/Chaosfirebolt/RomanNumeralConverter/blob/master/src/main/java/com/github/chaosfirebolt/converter/RomanInteger.java">RomanInteger</a>
     */
    public Numerus addō(final @NotNull Numerus alius) {
      try {
        return new Numerus(ostendam().add(alius.ostendam()).getArabic().shortValue());
      } catch (IllegalArgumentException e) {
        nūntius().terreō(e);
        return null;
      }
    }

    /**
     * @return rem classis {@link Numerus} quae ēventum subtractiōnis cum valōre {@code alius} repraesentat.
     * @param alius Rēs classis {@link Numerus} ūsa subtractiōnī.
     * @see <a href="https://github.com/Chaosfirebolt/RomanNumeralConverter/blob/master/src/main/java/com/github/chaosfirebolt/converter/RomanInteger.java">RomanInteger</a>
     */
    public Numerus subtrahō(final @NotNull Numerus alius) {
      try {
        return new Numerus(ostendam().subtract(alius.ostendam()).getArabic().shortValue());
      } catch (IllegalArgumentException e) {
        nūntius().terreō(e);
        return null;
      }
    }

    /**
     * @return rem classis {@link Numerus} quae ēventum multiplicātiōnis cum valōre {@code alius} repraesentat.
     * @param alius Rēs classis {@link Numerus} ūsa multiplicātiōnī.
     * @see <a href="https://github.com/Chaosfirebolt/RomanNumeralConverter/blob/master/src/main/java/com/github/chaosfirebolt/converter/RomanInteger.java">RomanInteger</a>
     */
    public Numerus multiplicō(final @NotNull Numerus alius) {
      try {
        return new Numerus(ostendam().multiply(alius.ostendam()).getArabic().shortValue());
      } catch (IllegalArgumentException e) {
        nūntius().terreō(e);
        return null;
      }
    }

    /**
     * @return rem classis {@link Numerus} quae ēventum dīvīsiōnis cum valōre {@code alius} repraesentat.
     * @param alius Rēs classis {@link Numerus} ūsa dīvīsiōnī.
     * @see <a href="https://github.com/Chaosfirebolt/RomanNumeralConverter/blob/master/src/main/java/com/github/chaosfirebolt/converter/RomanInteger.java">RomanInteger</a>
     */
    public Numerus dīvidō(final @NotNull Numerus alius) {
      try {
        return new Numerus(ostendam().divide(alius.ostendam()).getArabic().shortValue());
      } catch (IllegalArgumentException e) {
        nūntius().terreō(e);
        return null;
      }
    }

    /**
     * @return rem classis {@link Numerus} quae ēventum mānsiōnis cum valōre {@code alius} repraesentat.
     * @param alius Rēs classis {@link Numerus} ūsa mānsiōnī.
     * @see <a href="https://github.com/Chaosfirebolt/RomanNumeralConverter/blob/master/src/main/java/com/github/chaosfirebolt/converter/RomanInteger.java">RomanInteger</a>
     */
    public Numerus maneō(final @NotNull Numerus alius) {
      try {
        return new Numerus(ostendam().remainder(alius.ostendam()).getArabic().shortValue());
      } catch (IllegalArgumentException e) {
        nūntius().terreō(e);
        return null;
      }
    }
  }
}
