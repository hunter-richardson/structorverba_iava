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
import net.strūctorverba.ēnumerātiōnēs.Catēgoria;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.*;

import java.util.function.Supplier;

/**
 * Classis {@link VerbumSimplex} repraesentat verbum aliquem quod fōrmam ūnam sōlum habet. <br>
 * Rēs classis {@link Inventor} rēbus classis huius absunt atque inūtilēs fuerint. <br>
 * @param <Hoc> Tabellā hāc classis {@link Hoc} extēnsiōnem aptam datīs petītīs repraesentat.
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspction" })
public abstract class VerbumSimplex <Hoc extends Verbum <Hoc>> extends Verbum <Hoc> {
  /**
   * Officium hoc cōnstrūctōrem reī classis huius perpetrat.
   * @param ctgr valōrem {@link #catēgoria} indicat.
   * @param fdmn valōrem {@link #fundāmen} indicat.
   */
  protected VerbumSimplex(@NotNull final Catēgoria ctgr, @NotNull final String fdmn) {
    super(ctgr, fdmn);
  }

  /**
   *
   * @return Repraesentātiōnem scrīpta reī classis {@link VerbumSimplex}. <br>
   * Sōlum valōrem {@link Verbum#fundāmen} potest referre cum fōrmā ūnā.
   */
  @Override @NotNull
  public String toString( ) {
    return fundāmen;
  }

  /**
   * Classis {@link Coniūnctīvum} repraesentat coniūnctīva ut coniectēris. <br>
   * Rēs classis huius catēgoriam {@link Catēgoria#CONIŪNCTĪVUM} ūtuntur et cōnservāta sunt in scrīniō <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>/coniūnctīva.
   * Classis haec classisque {@link Interiectiō} ā cōnspectiōne programmātis StrūctorVerba est eaedem.
   * @see LēctorSimplicibus.LēctorConiūnctīvīs
   * @see TenorSimplicibus.TenorConiūnctivīs
   * @see ConditōrSimplicibus.ConditōrConiūnctīvīs
   * @see Nūntius.NūntiusConiūnctīvōrum
   */
  public static final class Coniūnctīvum extends VerbumSimplex <Coniūnctīvum> {
    @Getter(lazy = true) @Accessors(fluent = true)
    @NotNull private final Nūntius.NūntiusConiūnctīvōrum nūntius = Nūntius.NūntiusConiūnctīvōrum.fac.get();

    @Builder(access = AccessLevel.PUBLIC, builderClassName = "Conditōr",
             builderMethodName = "conditōr", buildMethodName = "condam")
    private Coniūnctīvum(@NotNull final String fundāmen) {
      super(Catēgoria.CONIŪNCTĪVUM, fundāmen);
      nūntius().plūsGarriō("Scrībor ut", fundāmen);
    }
  }

  /**
   * Classis {@link Interiectiō} repraesentat interiectiōnem ut coniectēris. <br>
   * Rēs classis huius catēgoriam {@link Catēgoria#CONIŪNCTĪVUM} ūtuntur et cōnservāta sunt in scrīniō <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>/interiectiōnēs.
   * Classis haec classisque {@link Coniūnctīvum} ā cōnspectiōne programmātis StrūctorVerba est eaedem.
   * @see LēctorSimplicibus.LēctorInteriectiōnibus
   * @see TenorSimplicibus.TenorInteriectiōnibus
   * @see ConditōrSimplicibus.ConditōrInteriectiōnibus
   * @see Nūntius.NūntiusInteriectiōnum
   */
  public static final class Interiectiō extends VerbumSimplex <Interiectiō> {
    @Getter(lazy = true) @Accessors(fluent = true)
    @NotNull private final Nūntius.NūntiusInteriectiōnum nūntius = Nūntius.NūntiusInteriectiōnum.fac.get();

    @Builder(access = AccessLevel.PUBLIC, builderClassName = "Conditōr",
             builderMethodName = "conditōr", buildMethodName = "condam")
    private Interiectiō(@NotNull final String fundāmen) {
      super(Catēgoria.INTERIECTIŌ, fundāmen);
      nūntius().plūsGarriō("Scrībor ut", fundāmen);
    }
  }

  /**
   * Classis {@link Praepositiō} repraesentat praepositiōnēs ut coniectēris. <br>
   * Rēs classis huius catēgoriam {@link Catēgoria#PRAEPOSITIŌ} ūtuntur et cōnservāta sunt in scrīniō <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>/praepositiōnēs.
   * @see LēctorPraepositiōnibus
   * @see Nūntius.NūntiusPraepositiōnum
   */
  public static final class Praepositiō extends VerbumSimplex <Praepositiō> {
    @Getter(lazy = true) @Accessors(fluent = true)
    @NotNull private final Nūntius.NūntiusPraepositiōnum nūntius = Nūntius.NūntiusPraepositiōnum.fac.get();

    /**
     * Valor hic supplet rem classis {@link Praepositiō} quam praepositiōnem nūlla repraesentat.
     */
    @NotNull public static final Supplier<Praepositiō> assūme =
      () -> Praepositiō.conditōr().fundāmen(StringUtils.EMPTY).condam();

    @Builder(access = AccessLevel.PUBLIC, builderClassName = "Conditōr",
             builderMethodName = "conditōr", buildMethodName = "condam")
    private Praepositiō(@NotNull final String fundāmen) {
      super(Catēgoria.PRAEPOSITIŌ, fundāmen);
      nūntius().plūsGarriō("Scrībor ut", fundāmen);
    }
  }

  /**
   * Classis {@link Numerus} repraesentat numerōs ut coniectēris. <br>
   * Rēs classis huius catēgoriam {@link Catēgoria#NUMERUS} ūtuntur et data eīs nōn inveniet scrīnium <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>. <br>
   * Magis rēs classis huius ā numerīs classis <a href="https://docs.oracle.com/javase/8/docs/api/java/lang/Short.html">Short</a> per ūsum classis <a href="https://github.com/Chaosfirebolt/RomanNumeralConverter/blob/master/src/main/java/com/github/chaosfirebolt/converter/RomanInteger.java">RomanInteger</a> fīant.
   * @see Nūntius.NūntiusNumerōrum
   * @see <a href="https://github.com/Chaosfirebolt/RomanNumeralConverter/blob/master/src/main/java/com/github/chaosfirebolt/converter/RomanInteger.java">RomanInteger</a>
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/lang/Short.html">Short</a>
   */
  public static final class Numerus extends VerbumSimplex<Numerus> {
    @Getter(lazy = true) @Accessors(fluent = true)
    @NotNull private final Nūntius.NūntiusNumerōrum nūntius = Nūntius.NūntiusNumerōrum.fac.get();

    /**
     * Valor hic repraesentātiōnem numeriam tenet reī huic.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/lang/Short.html">Short</a>
     */
    public final short numerus;

    @Builder(access = AccessLevel.PUBLIC, builderClassName = "Conditōr",
             builderMethodName = "conditōr", buildMethodName = "condam")
    private Numerus(final short numerus) throws IllegalArgumentException {
      super(Catēgoria.NUMERUS, String.valueOf(numerus));
      this.numerus = Validator.range(Short.toUnsignedInt(numerus)).shortValue();
      nūntius().plūsGarriō("Scrībor ut", toString());
    }

    @NotNull private RomanInteger ostendam() throws IllegalArgumentException {
      return RomanInteger.parse(String.valueOf(numerus), IntegerType.ARABIC);
    }

    /**
     * @return Repraesentātiōnem scrīpta reī classis huic. <br>
     * Modus hic valōrem <a href="https://commons.apache.org/proper/commons-lang/apidocs/org/apache/commons/lang3/StringUtils.html#EMPTY">StringUtils.EMPTY</a> refert sī <a href="https://github.com/Chaosfirebolt/RomanNumeralConverter/blob/master/src/main/java/com/github/chaosfirebolt/converter/RomanInteger.java">RomanInteger</a> errōrem continuātur.
     * @see <a href="https://github.com/Chaosfirebolt/RomanNumeralConverter/blob/master/src/main/java/com/github/chaosfirebolt/converter/RomanInteger.java">RomanInteger</a>
     */
    @Override @NotNull
    public String toString() throws IllegalArgumentException {
      try {
        return Ūtilitās.capitāneāsScrībō(ostendam().toString());
      } catch (IllegalArgumentException e) {
        nūntius().terreō(e);
        return StringUtils.EMPTY;
      }
    }

    /**
     * @return Rem classis {@link Numerus} quae ēventum additiōnis cum valōre {@code alius} repraesentat. <br>
     * Modus hic valōrem {@code null} refert sī <a href="https://github.com/Chaosfirebolt/RomanNumeralConverter/blob/master/src/main/java/com/github/chaosfirebolt/converter/RomanInteger.java">RomanInteger</a> errōrem continuātur.
     * @param alius rēs classis {@link Numerus} ūsa additiōnī.
     * @see <a href="https://github.com/Chaosfirebolt/RomanNumeralConverter/blob/master/src/main/java/com/github/chaosfirebolt/converter/RomanInteger.java">RomanInteger</a>
     */
    @Nullable public Numerus addō(final @NotNull Numerus alius) {
      try {
        return new Numerus(ostendam().add(alius.ostendam()).getArabic().shortValue());
      } catch (IllegalArgumentException e) {
        nūntius().terreō(e);
        return null;
      }
    }

    /**
     * @return Rem classis {@link Numerus} quae ēventum subtractiōnis cum valōre {@code alius} repraesentat. <br>
     * Modus hic valōrem {@code null} refert sī <a href="https://github.com/Chaosfirebolt/RomanNumeralConverter/blob/master/src/main/java/com/github/chaosfirebolt/converter/RomanInteger.java">RomanInteger</a> errōrem continuātur.
     * @param alius rēs classis {@link Numerus} ūsa subtractiōnī.
     * @see <a href="https://github.com/Chaosfirebolt/RomanNumeralConverter/blob/master/src/main/java/com/github/chaosfirebolt/converter/RomanInteger.java">RomanInteger</a>
     */
    @Nullable public Numerus subtrahō(final @NotNull Numerus alius) {
      try {
        return new Numerus(ostendam().subtract(alius.ostendam()).getArabic().shortValue());
      } catch (IllegalArgumentException e) {
        nūntius().terreō(e);
        return null;
      }
    }

    /**
     * @return Rem classis {@link Numerus} quae ēventum multiplicātiōnis cum valōre {@code alius} repraesentat. <br>
     * Modus hic valōrem {@code null} refert sī <a href="https://github.com/Chaosfirebolt/RomanNumeralConverter/blob/master/src/main/java/com/github/chaosfirebolt/converter/RomanInteger.java">RomanInteger</a> errōrem continuātur.
     * @param alius rēs classis {@link Numerus} ūsa multiplicātiōnī.
     * @see <a href="https://github.com/Chaosfirebolt/RomanNumeralConverter/blob/master/src/main/java/com/github/chaosfirebolt/converter/RomanInteger.java">RomanInteger</a>
     */
    @Nullable public Numerus multiplicō(final @NotNull Numerus alius) {
      try {
        return new Numerus(ostendam().multiply(alius.ostendam()).getArabic().shortValue());
      } catch (IllegalArgumentException e) {
        nūntius().terreō(e);
        return null;
      }
    }

    /**
     * @return Rem classis {@link Numerus} quae ēventum dīvīsiōnis cum valōre {@code alius} repraesentat. <br>
     * Modus hic valōrem {@code null} refert sī <a href="https://github.com/Chaosfirebolt/RomanNumeralConverter/blob/master/src/main/java/com/github/chaosfirebolt/converter/RomanInteger.java">RomanInteger</a> errōrem continuātur.
     * @param alius rēs classis {@link Numerus} ūsa dīvīsiōnī.
     * @see <a href="https://github.com/Chaosfirebolt/RomanNumeralConverter/blob/master/src/main/java/com/github/chaosfirebolt/converter/RomanInteger.java">RomanInteger</a>
     */
    @Nullable public Numerus dīvidō(final @NotNull Numerus alius) {
      try {
        return new Numerus(ostendam().divide(alius.ostendam()).getArabic().shortValue());
      } catch (IllegalArgumentException e) {
        nūntius().terreō(e);
        return null;
      }
    }

    /**
     * @return Rem classis {@link Numerus} quae ēventum mānsiōnis cum valōre {@code alius} repraesentat. <br>
     * Modus hic valōrem {@code null} refert sī <a href="https://github.com/Chaosfirebolt/RomanNumeralConverter/blob/master/src/main/java/com/github/chaosfirebolt/converter/RomanInteger.java">RomanInteger</a> errōrem continuātur.
     * @param alius rēs classis {@link Numerus} ūsa mānsiōnī.
     * @see <a href="https://github.com/Chaosfirebolt/RomanNumeralConverter/blob/master/src/main/java/com/github/chaosfirebolt/converter/RomanInteger.java">RomanInteger</a>
     */
    @Nullable public Numerus maneō(final @NotNull Numerus alius) {
      try {
        return new Numerus(ostendam().remainder(alius.ostendam()).getArabic().shortValue());
      } catch (IllegalArgumentException e) {
        nūntius().terreō(e);
        return null;
      }
    }
  }
}
