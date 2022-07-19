package com.structorverba.officia.miscella;

import androidx.annotation.NonNull;
import androidx.annotation.*;
import com.github.chaosfirebolt.converter.RomanInteger;
import com.github.chaosfirebolt.converter.constants.*;
import com.structorverba.officia.nuntii.*;
import com.structorverba.officia.verba.Numerus;
import com.structorverba.officia.verba.constructores.ConstructorSimplicium;
import jakarta.ejb.*;
import lombok.*;
import org.apache.commons.lang3.*;

import java.util.Random;
import java.util.function.Supplier;

@SuppressWarnings("SpellCheckingInspection")
@Singleton @DependsOn("NuntiusNumeratori")
public class Numerator extends Omne {
    @Nullable private static Numerator instantia = null;

    @NonNull public static Supplier<Numerator> faciendum =
            () -> ObjectUtils.firstNonNull(instantia, instantia = new Numerator());

    @NonNull @Getter(value = AccessLevel.PRIVATE, lazy = true)
    private final NuntiusNumeratori nuntius = NuntiusNumeratori.faciendum.get();

    @NonNull @Getter(value = AccessLevel.PRIVATE, lazy = true)
    private final Range<Short> TRACTUS_NUMERORUM = Range.between(Numerus.MINUMUM, Numerus.MAXIMUM);

    /**
     * Hic modus fōrmam temere sēligit.
     * @return Rem classis {@link Numerus} fortuītam
     * @see Random#ints()
     * @implNote  Valōrem {@code X} refert sī fūnctiō fortis dēficit.
     * */
    @Nullable public Numerus fortuitumNumeram() {
        return fortuitumNumeram(TRACTUS_NUMERORUM);
    }

    /**
     * Hic modus fōrmam temere sēligit.
     * @param tractus numerōs possibilēs fīnit.
     * @return Rem classis {@link Numerus} fortuītam
     * @see Random#ints()
     * @implNote  Valōrem {@code X} refert sī fūnctiō fortis dēficit.
     * */
    @Nullable public Numerus fortuitumNumeram(@NonNull final Range<Short> tractus) {
        return numeram(Integer.valueOf(new Random().ints(Math.max(tractus.getMinimum(), TRACTUS_NUMERORUM.getMinimum()),
                                                         Math.min(tractus.getMaximum(), TRACTUS_NUMERORUM.getMaximum()))
                                                   .distinct().findFirst().orElse(10)).shortValue());
    }

    /**
     * @param numerus numerus mathematicus
     * @return Rem classis {@link Numerus}
     * Hic modus valōrem {@code null} refert sī <a href="https://github.com/Chaosfirebolt/RomanNumeralConverter/blob/master/src/main/java/com/github/chaosfirebolt/converter/RomanInteger.java">RomanInteger</a>
     * errōrem continuātur.
     */
    @Nullable public Numerus numeram(final short numerus) {
        if(TRACTUS_NUMERORUM.contains(numerus)) {
            try {
                return ConstructorSimplicium.numeri().apply(numerus);
            } catch (IllegalArgumentException e) {
                nuntius.terreo(e);
                return null;
            }
        } else {
            return null;
        }
    }

    /**
     * @param scriptio repraesentātiōnem scrīpta numerī mathēmaticī
     * @return Rem classis {@link Numerus}
     * Hic modus valōrem {@code null} refert sī <a href="https://github.com/Chaosfirebolt/RomanNumeralConverter/blob/master/src/main/java/com/github/chaosfirebolt/converter/RomanInteger.java">RomanInteger</a>
     * errōrem continuātur.
     */
    @Nullable public Numerus numeram(final @NonNull String scriptio) {
        if (Patterns.ROMAN_PATTERN.matcher(scriptio).matches()) {
            final short valor = Integer.valueOf(RomanInteger.parse(scriptio, IntegerType.ROMAN).getArabic()).shortValue();
            return numeram(valor);
        } else {
            return null;
        }
    }

    @Singleton private static class NuntiusNumeratori extends Nuntius {
        @Nullable private static NuntiusNumeratori instantia = null;

        /**
         * Hic valor viam reī huius classis facit.
         * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
         */
        @NonNull public static final Supplier<NuntiusNumeratori> faciendum =
                () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusNumeratori());

        private NuntiusNumeratori() {
            super(ParametriNuntii.para(Numerator.class));
        }
    }
}
