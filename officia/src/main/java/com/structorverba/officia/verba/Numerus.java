package com.structorverba.officia.verba;

import androidx.annotation.*;
import androidx.annotation.NonNull;
import com.github.chaosfirebolt.converter.RomanInteger;
import com.github.chaosfirebolt.converter.constants.IntegerType;
import com.github.chaosfirebolt.converter.util.Validator;
import com.structorverba.officia.enumerationes.*;
import com.structorverba.officia.miscella.Utilitas;
import lombok.*;
import org.apache.commons.lang3.*;

/**
 * Classis {@link Numerus} repraesentat numerōs ut coniectēris. <br>
 * Rēs huius classis catēgoriam {@link Categoria#NUMERUS} ūtuntur dataque eīs nōn
 * inveniet scrīnium <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>.
 * <br> Magis rēs huius classis ā numerīs classis <a href="https://docs.oracle.com/javase/8/docs/api/java/lang/Short.html">Short</a>
 * per ūsum classis <a href="https://github.com/Chaosfirebolt/RomanNumeralConverter/blob/master/src/main/java/com/github/chaosfirebolt/converter/RomanInteger.java">RomanInteger</a>
 * fīant.
 *
 * @see NuntiusNumerorum
 * @see <a href="https://github.com/Chaosfirebolt/RomanNumeralConverter/blob/master/src/main/java/com/github/chaosfirebolt/converter/RomanInteger.java">RomanInteger</a>
 * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/lang/Short.html">Short</a>
 */
@SuppressWarnings("SpellCheckingInspection")
public final class Numerus extends VerbumSimplex<Numerus> {
    /**
     * Hic valor numerum maximum possibilem repraesentat.
     */
    public static final short MINUMUM = 1;

    /**
     * Hic valor numerum minumum possibilem repraesentat.
     */
    public static final short MAXIMUM = 3999;

    /**
     * Hic valor repraesentātiōnem numeriam huic reī tenet.
     */
    @IntRange(from = MINUMUM, to = MAXIMUM)
    private final int numerus;

    @NonNull @Getter(lazy = true)
    private static final NuntiusNumerorum nuntius = NuntiusNumerorum.faciendum.get();

    @Builder(access = AccessLevel.PUBLIC, toBuilder = true)
    private Numerus(final short numerus) throws IllegalArgumentException {
        super(Categoria.NUMERUS, String.valueOf(numerus));
        this.numerus = Validator.range(Short.toUnsignedInt(numerus));
        nuntius.plusGarrio("Scrībor ut", toString());
    }

    public short numerus() {
        return Integer.valueOf(numerus).shortValue();
    }

    @Nullable private RomanInteger ostendam() {
        try {
            return RomanInteger.parse(String.valueOf(numerus), IntegerType.ARABIC);
        } catch (IllegalArgumentException e) {
            nuntius.terreo(e);
            return null;
        }
    }

    /**
     * @return Repraesentātiōnem scrīpta reī huius classis. <br>
     * Hic modus valōrem <a href="https://commons.apache.org/proper/commons-lang/apidocs/org/apache/commons/lang3/StringUtils.html#EMPTY">StringUtils.EMPTY</a>
     * refert sī <a href="https://github.com/Chaosfirebolt/RomanNumeralConverter/blob/master/src/main/java/com/github/chaosfirebolt/converter/RomanInteger.java">RomanInteger</a>
     * errōrem continuātur.
     * @see <a href="https://github.com/Chaosfirebolt/RomanNumeralConverter/blob/master/src/main/java/com/github/chaosfirebolt/converter/RomanInteger.java">RomanInteger</a>
     */
    @Override @NonNull
    public String toString() {
        try {
            final RomanInteger numerus = ostendam();
            return numerus == null ? StringUtils.EMPTY
                                   : Utilitas.capitaneasScribo(numerus.toString());
        } catch (IllegalArgumentException e) {
            nuntius.terreo(e);
            return StringUtils.EMPTY;
        }
    }

    /**
     * @param primus rēs classis {@link Numerus} ūsa additiōnī.
     * @param secundus rēs classis {@link Numerus} ūsa additiōnī.
     * @return Rem classis {@link Numerus} quae ēventum additiōnis cum valōre {@code secundus} repraesentat. <br>
     * Hic modus valōrem {@code null} refert sī <a href="https://github.com/Chaosfirebolt/RomanNumeralConverter/blob/master/src/main/java/com/github/chaosfirebolt/converter/RomanInteger.java">RomanInteger</a>
     *                                  errōrem continuātur.
     * @see <a href="https://github.com/Chaosfirebolt/RomanNumeralConverter/blob/master/src/main/java/com/github/chaosfirebolt/converter/RomanInteger.java">RomanInteger</a>
     */
    @SuppressWarnings("ConstantConditions")
    @Nullable static public Numerus addo(@NonNull final Numerus primus,
                                         @NonNull final Numerus secundus) throws IllegalArgumentException {
        final RomanInteger tertius = primus.ostendam(),
                           quartus = secundus.ostendam();
        try {
            return ObjectUtils.allNotNull(tertius, quartus) ? new Numerus(Integer.valueOf(tertius.add(quartus).getArabic()).shortValue())
                                                            : null;
        } catch(IllegalArgumentException e) {
            nuntius.terreo(e);
            return null;
        }
    }

    /**
     * @param primus rēs classis {@link Numerus} ūsa subtractiōnī.
     * @param secundus rēs classis {@link Numerus} ūsa subtractiōnī.
     * @return Rem classis {@link Numerus} quae ēventum subtractiōnis cum valōre {@code secundus} repraesentat. <br>
     * Hic modus valōrem {@code null} refert sī <a href="https://github.com/Chaosfirebolt/RomanNumeralConverter/blob/master/src/main/java/com/github/chaosfirebolt/converter/RomanInteger.java">RomanInteger</a>
     *                                  errōrem continuātur.
     * @see <a href="https://github.com/Chaosfirebolt/RomanNumeralConverter/blob/master/src/main/java/com/github/chaosfirebolt/converter/RomanInteger.java">RomanInteger</a>
     */
    @SuppressWarnings("ConstantConditions")
    @Nullable static public Numerus subtraho(@NonNull final Numerus primus,
                                             @NonNull final Numerus secundus) throws IllegalArgumentException {
        final RomanInteger tertius = primus.ostendam(),
                           quartus = secundus.ostendam();
        try {
            return ObjectUtils.allNotNull(tertius, quartus) ? new Numerus(Integer.valueOf(tertius.subtract(quartus).getArabic()).shortValue())
                                                            : null;
        } catch (IllegalArgumentException e) {
            nuntius.terreo(e);
            return null;
        }
    }

    /**
     * @param primus rēs classis {@link Numerus} ūsa multiplicātiōnī.
     * @param secundus rēs classis {@link Numerus} ūsa multiplicātiōnī.
     * @return Rem classis {@link Numerus} quae ēventum multiplicātiōnis cum valōre {@code secundus} repraesentat. <br>
     * Hic modus valōrem {@code null} refert sī <a href="https://github.com/Chaosfirebolt/RomanNumeralConverter/blob/master/src/main/java/com/github/chaosfirebolt/converter/RomanInteger.java">RomanInteger</a>
     *                                  errōrem continuātur.
     * @see <a href="https://github.com/Chaosfirebolt/RomanNumeralConverter/blob/master/src/main/java/com/github/chaosfirebolt/converter/RomanInteger.java">RomanInteger</a>
     */
    @SuppressWarnings("ConstantConditions")
    @Nullable static public Numerus multiplico(@NonNull final Numerus primus,
                                               @NonNull final Numerus secundus) throws IllegalArgumentException {
        final RomanInteger tertius = primus.ostendam(),
                           quartus = secundus.ostendam();
        try {
            return ObjectUtils.allNotNull(tertius, quartus) ? new Numerus(Integer.valueOf(tertius.multiply(quartus).getArabic()).shortValue())
                                                            : null;
        } catch (IllegalArgumentException e) {
            nuntius.terreo(e);
            return null;
        }
    }

    /**
     * @param primus rēs classis {@link Numerus} ūsa dīvīsiōnī.
     * @param secundus rēs classis {@link Numerus} ūsa dīvīsiōnī.
     * @return Rem classis {@link Numerus} quae ēventum dīvīsiōnis cum valōre {@code secundus} repraesentat. <br>
     * Hic modus valōrem {@code null} refert sī <a href="https://github.com/Chaosfirebolt/RomanNumeralConverter/blob/master/src/main/java/com/github/chaosfirebolt/converter/RomanInteger.java">RomanInteger</a>
     *                                  errōrem continuātur.
     * @see <a href="https://github.com/Chaosfirebolt/RomanNumeralConverter/blob/master/src/main/java/com/github/chaosfirebolt/converter/RomanInteger.java">RomanInteger</a>
     */
    @SuppressWarnings("ConstantConditions")
    @Nullable static public Numerus divido(@NonNull final Numerus primus,
                                           @NonNull final Numerus secundus) throws IllegalArgumentException {
        final RomanInteger tertius = primus.ostendam(),
                           quartus = secundus.ostendam();
        try {
            return ObjectUtils.allNotNull(tertius, quartus) ? new Numerus(Integer.valueOf(tertius.divide(quartus).getArabic()).shortValue())
                                                            : null;
        } catch (IllegalArgumentException e) {
            nuntius.terreo(e);
            return null;
        }
    }

    /**
     * @param primus rēs classis {@link Numerus} ūsa mānsiōnī.
     * @param secundus rēs classis {@link Numerus} ūsa mānsiōnī.
     * @return Rem classis {@link Numerus} quae ēventum mānsiōnis cum valōre {@code secundus} repraesentat. <br>
     * Hic modus valōrem {@code null} refert sī <a href="https://github.com/Chaosfirebolt/RomanNumeralConverter/blob/master/src/main/java/com/github/chaosfirebolt/converter/RomanInteger.java">RomanInteger</a>
     *                                  errōrem continuātur.
     * @see <a href="https://github.com/Chaosfirebolt/RomanNumeralConverter/blob/master/src/main/java/com/github/chaosfirebolt/converter/RomanInteger.java">RomanInteger</a>
     */
    @SuppressWarnings("ConstantConditions")
    @Nullable static public Numerus maneo(@NonNull final Numerus primus,
                                          @NonNull final Numerus secundus) throws IllegalArgumentException {
        final RomanInteger tertius = primus.ostendam(),
                           quartus = secundus.ostendam();
        try {
            return ObjectUtils.allNotNull(tertius, quartus) ? new Numerus(Integer.valueOf(tertius.remainder(quartus).getArabic()).shortValue())
                                                            : null;
        } catch(IllegalArgumentException e) {
            nuntius.terreo(e);
            return null;
        }
    }

    /**
     * Hic modus operātiōnem mathēmaticam aptam agat.
     *
     * @param primus   rēs classis {@link Numerus} ūsa operātiōnī.
     * @param secundus rēs classis {@link Numerus} ūsa operātiōnī.
     * @param operatio indicat operātiōnem agendam
     * @see Operatio
     */
    @Nullable static public Numerus agam(@NonNull final Numerus primus, @NonNull final Numerus secundus,
                                         @NonNull final Operatio operatio) throws IllegalArgumentException {
        return operatio.romanus.apply(primus, secundus);
    }
}
