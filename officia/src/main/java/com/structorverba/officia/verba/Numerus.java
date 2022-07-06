package com.structorverba.officia.verba;

import androidx.annotation.*;
import androidx.annotation.NonNull;
import com.github.chaosfirebolt.converter.RomanInteger;
import com.github.chaosfirebolt.converter.constants.IntegerType;
import com.github.chaosfirebolt.converter.util.Validator;
import com.structorverba.officia.enumerationes.*;
import com.structorverba.officia.miscella.Utilitas;
import lombok.*;
import org.apache.commons.lang3.StringUtils;

/**
 * Classis {@link com.structorverba.officia.verba.Numerus} repraesentat numerōs ut coniectēris. <br>
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
    @Getter(lazy = true)
    @NonNull
    private final NuntiusNumerorum nuntius = NuntiusNumerorum.faciendum.get();

    @Builder(access = AccessLevel.PUBLIC, toBuilder = true)
    private Numerus(final short numerus) throws IllegalArgumentException {
        super(Categoria.NUMERUS, String.valueOf(numerus));
        this.numerus = Validator.range(Short.toUnsignedInt(numerus));
        nuntius.plusGarrio("Scrībor ut", toString());
    }

    public short numerus() {
        return Integer.valueOf(numerus).shortValue();
    }

    @NonNull
    private RomanInteger ostendam() throws IllegalArgumentException {
        return RomanInteger.parse(String.valueOf(numerus), IntegerType.ARABIC);
    }

    /**
     * @return Repraesentātiōnem scrīpta reī huius classis. <br>
     * Hic modus valōrem <a href="https://commons.apache.org/proper/commons-lang/apidocs/org/apache/commons/lang3/StringUtils.html#EMPTY">StringUtils.EMPTY</a>
     * refert sī <a href="https://github.com/Chaosfirebolt/RomanNumeralConverter/blob/master/src/main/java/com/github/chaosfirebolt/converter/RomanInteger.java">RomanInteger</a>
     * errōrem continuātur.
     * @see <a href="https://github.com/Chaosfirebolt/RomanNumeralConverter/blob/master/src/main/java/com/github/chaosfirebolt/converter/RomanInteger.java">RomanInteger</a>
     */
    @Override
    @NonNull
    public String toString() {
        try {
            return Utilitas.capitaneasScribo(ostendam().toString());
        } catch (IllegalArgumentException e) {
            nuntius.terreo(e);
            return StringUtils.EMPTY;
        }
    }

    /**
     * @param secundus rēs classis {@link com.structorverba.officia.verba.Numerus} ūsa additiōnī.
     * @return Rem classis {@link com.structorverba.officia.verba.Numerus} quae ēventum additiōnis cum valōre {@code secundus} repraesentat. <br>
     * @throws IllegalArgumentException sī <a href="https://github.com/Chaosfirebolt/RomanNumeralConverter/blob/master/src/main/java/com/github/chaosfirebolt/converter/RomanInteger.java">RomanInteger</a>
     *                                  errōrem continuātur.
     * @see <a href="https://github.com/Chaosfirebolt/RomanNumeralConverter/blob/master/src/main/java/com/github/chaosfirebolt/converter/RomanInteger.java">RomanInteger</a>
     */
    @NonNull
    static public com.structorverba.officia.verba.Numerus addo(@NonNull final com.structorverba.officia.verba.Numerus primus,
                                                               @NonNull final com.structorverba.officia.verba.Numerus secundus) throws IllegalArgumentException {
        return new com.structorverba.officia.verba.Numerus(Integer.valueOf(primus.ostendam().add(secundus.ostendam()).getArabic()).shortValue());
    }

    /**
     * @param secundus rēs classis {@link com.structorverba.officia.verba.Numerus} ūsa subtractiōnī.
     * @return Rem classis {@link com.structorverba.officia.verba.Numerus} quae ēventum subtractiōnis cum valōre {@code secundus} repraesentat. <br>
     * @throws IllegalArgumentException sī <a href="https://github.com/Chaosfirebolt/RomanNumeralConverter/blob/master/src/main/java/com/github/chaosfirebolt/converter/RomanInteger.java">RomanInteger</a>
     *                                  errōrem continuātur.
     * @see <a href="https://github.com/Chaosfirebolt/RomanNumeralConverter/blob/master/src/main/java/com/github/chaosfirebolt/converter/RomanInteger.java">RomanInteger</a>
     */
    @NonNull
    static public com.structorverba.officia.verba.Numerus subtraho(@NonNull final com.structorverba.officia.verba.Numerus primus,
                                                                   @NonNull final com.structorverba.officia.verba.Numerus secundus) throws IllegalArgumentException {
        return new com.structorverba.officia.verba.Numerus(Integer.valueOf(primus.ostendam().subtract(secundus.ostendam()).getArabic()).shortValue());
    }

    /**
     * @param secundus rēs classis {@link com.structorverba.officia.verba.Numerus} ūsa multiplicātiōnī.
     * @return Rem classis {@link com.structorverba.officia.verba.Numerus} quae ēventum multiplicātiōnis cum valōre {@code secundus} repraesentat. <br>
     * @throws IllegalArgumentException sī <a href="https://github.com/Chaosfirebolt/RomanNumeralConverter/blob/master/src/main/java/com/github/chaosfirebolt/converter/RomanInteger.java">RomanInteger</a>
     *                                  errōrem continuātur.
     * @see <a href="https://github.com/Chaosfirebolt/RomanNumeralConverter/blob/master/src/main/java/com/github/chaosfirebolt/converter/RomanInteger.java">RomanInteger</a>
     */
    @NonNull
    static public com.structorverba.officia.verba.Numerus multiplico(@NonNull final com.structorverba.officia.verba.Numerus primus,
                                                                     @NonNull final com.structorverba.officia.verba.Numerus secundus) throws IllegalArgumentException {
        return new com.structorverba.officia.verba.Numerus(Integer.valueOf(primus.ostendam().multiply(secundus.ostendam()).getArabic()).shortValue());
    }

    /**
     * @param secundus rēs classis {@link com.structorverba.officia.verba.Numerus} ūsa dīvīsiōnī.
     * @return Rem classis {@link com.structorverba.officia.verba.Numerus} quae ēventum dīvīsiōnis cum valōre {@code secundus} repraesentat. <br>
     * @throws IllegalArgumentException sī <a href="https://github.com/Chaosfirebolt/RomanNumeralConverter/blob/master/src/main/java/com/github/chaosfirebolt/converter/RomanInteger.java">RomanInteger</a>
     *                                  errōrem continuātur.
     * @see <a href="https://github.com/Chaosfirebolt/RomanNumeralConverter/blob/master/src/main/java/com/github/chaosfirebolt/converter/RomanInteger.java">RomanInteger</a>
     */
    @NonNull
    static public com.structorverba.officia.verba.Numerus divido(@NonNull final com.structorverba.officia.verba.Numerus primus,
                                                                 @NonNull final com.structorverba.officia.verba.Numerus secundus) throws IllegalArgumentException {
        return new com.structorverba.officia.verba.Numerus(Integer.valueOf(primus.ostendam().divide(secundus.ostendam()).getArabic()).shortValue());
    }

    /**
     * @param secundus rēs classis {@link com.structorverba.officia.verba.Numerus} ūsa mānsiōnī.
     * @return Rem classis {@link com.structorverba.officia.verba.Numerus} quae ēventum mānsiōnis cum valōre {@code secundus} repraesentat. <br>
     * @throws IllegalArgumentException sī <a href="https://github.com/Chaosfirebolt/RomanNumeralConverter/blob/master/src/main/java/com/github/chaosfirebolt/converter/RomanInteger.java">RomanInteger</a>
     *                                  errōrem continuātur.
     * @see <a href="https://github.com/Chaosfirebolt/RomanNumeralConverter/blob/master/src/main/java/com/github/chaosfirebolt/converter/RomanInteger.java">RomanInteger</a>
     */
    @NonNull
    static public com.structorverba.officia.verba.Numerus maneo(@NonNull final com.structorverba.officia.verba.Numerus primus,
                                                                @NonNull final com.structorverba.officia.verba.Numerus secundus) throws IllegalArgumentException {
        return new com.structorverba.officia.verba.Numerus(Integer.valueOf(primus.ostendam().remainder(secundus.ostendam()).getArabic()).shortValue());
    }

    /**
     * Hic modus operātiōnem mathēmaticam aptam agat.
     *
     * @param primus   rēs classis {@link com.structorverba.officia.verba.Numerus} ūsa operātiōnī.
     * @param secundus rēs classis {@link com.structorverba.officia.verba.Numerus} ūsa operātiōnī.
     * @param operatio indicat operātiōnem agendam
     * @see Operatio
     */
    @NonNull
    static public com.structorverba.officia.verba.Numerus agam(@NonNull final com.structorverba.officia.verba.Numerus primus, @NonNull final com.structorverba.officia.verba.Numerus secundus,
                                                               @NonNull final Operatio operatio) throws IllegalArgumentException {
        return operatio.romanus.apply(primus, secundus);
    }
}
