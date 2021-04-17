package net.strūctorverba.verba;

import com.github.chaosfirebolt.converter.RomanInteger;
import com.github.chaosfirebolt.converter.constants.IntegerType;
import com.github.chaosfirebolt.converter.util.Validator;
import lombok.*;
import lombok.experimental.Accessors;
import net.strūctorverba.conditōrēs.ConditōrSimplicibus;
import net.strūctorverba.inventōrēs.Inventor;
import net.strūctorverba.lēctōrēs.*;
import net.strūctorverba.nūntiī.*;
import net.strūctorverba.tenōrēs.TenorSimplibus;
import net.strūctorverba.verba.disposita.Verba;
import net.strūctorverba.ēnumerātiōnēs.*;
import org.apache.commons.lang3.*;
import org.jetbrains.annotations.*;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

/**
 * Classis {@link VerbumSimplex} repraesentat verbum aliquem quod fōrmam ūnam sōlum habent.
 * Rēs classis {@link Inventor} rēbus classis huius absunt atque inūtilēs fuerint.
 * @param <Hoc> Tabellā hāc classis {@link Hoc} extēnsiōnem aptam datīs petītīs repraesentat.
 * @see LēctorSimplicibus
 * @see TenorSimplibus
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
   * @return repraesentātiō scrīpta reī classis {@link VerbumSimplex}. Sōlum valōrem {@link Verbum#fundāmen} potest referre cum fōrmā ūnā.
   */
  public @Override @NotNull String toString( ) {
    return fundāmen;
  }

  /**
   * Classis {@link Adverbium} repraesentat adverbia ut coniectēris.
   * Adverbia catēgoriam {@link Catēgoria#ADVERBIUM} ūtuntur et cōnservāta sunt in scrīniō <a href="../src/main/resources/adverbia">adverbia</a>.
   * @see LēctorSimplicibus.LēctorAdverbiīs
   * @see TenorSimplibus.TenorAdverbiīs
   * @see ConditōrSimplicibus.ConditōrAdverbiīs
   */
  public static final class Adverbium extends VerbumSimplex <Adverbium> {
    @Getter(lazy = true) @Accessors(fluent = true)
    private final @NotNull NūntiusAdverbiōrum nūntius = NūntiusAdverbiōrum.fac.get();

    @Builder(builderClassName = "Conditōr", builderMethodName = "conditōr", buildMethodName = "condam")
    private Adverbium(@NotNull final String fundāmen) {
      super(Catēgoria.ADVERBIUM, fundāmen);
      nūntius().plūsGarriō("Scrībor ut", fundāmen);
    }

    public static final class NūntiusAdverbiōrum extends Nūntius {
      private static @Nullable NūntiusAdverbiōrum īnstantia = null;

      public static @NotNull Supplier<NūntiusAdverbiōrum> fac =
        () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new NūntiusAdverbiōrum());

      private NūntiusAdverbiōrum() {
        super(ParametrīNūntiī.parā(Adverbium.Conditōr.class));
      }
    }
  }

  /**
   * Classis {@link Coniūnctīvum} repraesentat coniūnctīva ut coniectēris.
   * Coniūnctīva catēgoriam {@link Catēgoria#CONIŪNCTĪVUM} ūtuntur et cōnservāta sunt in scrīniō <a href="../src/main/resources/coniūnctīva">coniūnctīva</a>.
   * Prōpositīs programmātis huius classis {@link Coniūnctīvum} differt classe {@link Adverbium} sōlum in quō classis {@link Coniūnctīvum} modōs {@link Coniugiāle} dēfīnītōs dēdūcit.
   * @see LēctorSimplicibus.LēctorConiūnctīvīs
   * @see TenorSimplibus.TenorConiūnctivīs
   * @see ConditōrSimplicibus.ConditōrConiūnctīvīs
   */
  public static final class Coniūnctīvum extends VerbumSimplex <Coniūnctīvum> implements Coniugiāle {
    @Getter(lazy = true) @Accessors(fluent = true)
    private final @NotNull NūntiusConiūnctīvōrum nūntius = NūntiusConiūnctīvōrum.fac.get();

    @Builder(builderClassName = "Conditōr", builderMethodName = "conditōr", buildMethodName = "condam")
    private Coniūnctīvum(@NotNull final String fundāmen) {
      super(Catēgoria.CONIŪNCTĪVUM, fundāmen);
      nūntius().plūsGarriō("Scrībor ut", fundāmen);
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
    public final @NotNull Verba coniugō(@NotNull final Verba prīma, @NotNull final Verba secunda) {
      prīma.coniūnctīvumAllegōContinuōque(this, secunda);
      return prīma;
    }

    /**
     * {@inheritDoc}
     */
    public final @NotNull Verba coniugō(@NotNull final Verba prīma,
                                        @NotNull final LinkedList <Verbum <@Nullable ?>> secunda) {
      prīma.coniūnctīvumAllegōContinuōque(this, Verba.conditōr().seriēs(secunda).condam());
      return prīma;
    }

    public static final class NūntiusConiūnctīvōrum extends Nūntius {
      private static @Nullable NūntiusConiūnctīvōrum īnstantia = null;

      public static @NotNull Supplier<NūntiusConiūnctīvōrum> fac =
        () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new NūntiusConiūnctīvōrum());

      private NūntiusConiūnctīvōrum() {
        super(ParametrīNūntiī.parā(Adverbium.Conditōr.class));
      }
    }
  }

  /**
   * Classis {@link Praepositiō} repraesentat praepositiōnēs ut coniectēris.
   * Praepositiōnēs catēgoriam {@link Catēgoria#PRAEPOSITIŌ} ūtuntur et cōnservāta sunt in scrīniō <a href="../src/main/resources/praepositiōnēs">praepositiōnēs</a>.
   * @see LēctorPraepositiōnibus
   */
  public static final class Praepositiō extends VerbumSimplex <Praepositiō> {
    @Getter(lazy = true) @Accessors(fluent = true)
    private final @NotNull NūntiusPraepositiōnum nūntius = NūntiusPraepositiōnum.fac.get();

    public static final @NotNull Supplier<Praepositiō> assūme =
      () -> Praepositiō.conditōr().fundāmen(StringUtils.EMPTY).condam();

    @Builder(builderClassName = "Conditōr", builderMethodName = "conditōr", buildMethodName = "condam")
    private Praepositiō(@NotNull final String fundāmen) {
      super(Catēgoria.PRAEPOSITIŌ, fundāmen);
      nūntius().plūsGarriō("Scrībor ut", fundāmen);
    }

    public static final class NūntiusPraepositiōnum extends Nūntius {
      private static @Nullable NūntiusPraepositiōnum īnstantia = null;

      public static @NotNull Supplier<NūntiusPraepositiōnum> fac =
        () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new NūntiusPraepositiōnum());

      private NūntiusPraepositiōnum( ) {
        super(ParametrīNūntiī.parā(Praepositiō.Conditōr.class));
      }
    }
  }

  /**
   * Classis {@link Numerus} repraesentat numerōs ut coniectēris.
   * Numerī catēgoriam {@link Catēgoria#NUMERUM} ūtuntur et sunt generātī statim quam cōnservātī intrā scrīnium <a href="../src/main/resources">auxiliārēs</a>.
   * @see <a href="https://github.com/Chaosfirebolt/RomanNumeralConverter/blob/master/src/main/java/com/github/chaosfirebolt/converter/RomanInteger.java">RomanInteger</a>
   */
  public static final class Numerus extends VerbumSimplex<Numerus> {
    @Getter(lazy = true) @Accessors(fluent = true)
    private final @NotNull NūntiusNumerōrum nūntius = NūntiusNumerōrum.fac.get();

    /**
     * Valor hic repraesentātiōnem numeriam tenet reī classis {@link Numerus}.
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
     * @return repraesentātiō scrīpta reī classis {@link Numerus}.
     * @throws IllegalArgumentException sī valor {@link #numerus} exit terminōs mathēmaticae quae sunt I et MMMCMXCIX.
     * @see <a href="https://github.com/Chaosfirebolt/RomanNumeralConverter/blob/master/src/main/java/com/github/chaosfirebolt/converter/RomanInteger.java">RomanInteger</a>
     */
    public @Override @NotNull String toString() throws IllegalArgumentException {
      return ostendam().toString();
    }

    /**
     * @return reī classis {@link Numerus} quae ēventum additiōnis cum rē {@code alius} repraesentat.
     * @param alius Rēs classis {@link Numerus} ūsa additiōnī.
     * @throws IllegalArgumentException sī valor {@link #numerus} aut huius aut valōris {@code alius} aut ēventī exit terminōs mathēmaticae quae sunt I et MMMCMXCIX.
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
     * @return reī classis {@link Numerus} quae ēventum subtractiōnis cum rē {@code alius} repraesentat.
     * @param alius Rēs classis {@link Numerus} ūsa subtractiōnī.
     * @throws IllegalArgumentException sī valor {@link #numerus} aut huius aut valōris {@code alius} aut ēventī exit terminōs mathēmaticae quae sunt I et MMMCMXCIX.
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
     * @return reī classis {@link Numerus} quae ēventum multiplicātiōnis cum rē {@code alius} repraesentat.
     * @param alius Rēs classis {@link Numerus} ūsa multiplicātiōnī.
     * @throws IllegalArgumentException sī valor {@link #numerus} aut huius aut valōris {@code alius} aut ēventī exit terminōs mathēmaticae quae sunt I et MMMCMXCIX.
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
     * @return reī classis {@link Numerus} quae ēventum dīvīsiōnis cum rē {@code alius} repraesentat.
     * @param alius Rēs classis {@link Numerus} ūsa dīvīsiōnī.
     * @throws IllegalArgumentException sī valor {@link #numerus} aut huius aut valōris {@code alius} aut ēventī exit terminōs mathēmaticae quae sunt I et MMMCMXCIX.
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
     * @return reī classis {@link Numerus} quae ēventum mānsiōnis cum rē {@code alius} repraesentat.
     * @param alius Rēs classis {@link Numerus} ūsa mānsiōnī.
     * @throws IllegalArgumentException sī valor {@link #numerus} aut huius aut valōris {@code alius} aut ēventī exit terminōs mathēmaticae quae sunt I et MMMCMXCIX.
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

    public static final class NūntiusNumerōrum extends Nūntius {
      private static @Nullable NūntiusNumerōrum īnstantia = null;

      public static final @NotNull Supplier<NūntiusNumerōrum> fac =
        () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new NūntiusNumerōrum());

      protected NūntiusNumerōrum() {
        super(ParametrīNūntiī.parā(Numerus.Conditōr.class));
      }
    }
  }
}
