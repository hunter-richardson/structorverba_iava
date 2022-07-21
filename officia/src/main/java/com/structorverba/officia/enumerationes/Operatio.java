package com.structorverba.officia.enumerationes;

import androidx.annotation.NonNull;
import com.github.chaosfirebolt.converter.constants.IntegerType;
import com.structorverba.officia.verba.simplicia.Numerus;

import java.util.function.BiFunction;

/**
 * Hic ēnumerātiō operātiōnem mathēmaticam dēsignat cum rōmānāque arabicāque.
 * */
@SuppressWarnings("SpellCheckingInspection")
public enum Operatio {
    /**
     * Hic valor additiōnem indicat.
     * @see Math#addExact(int, int)
     * @see Numerus#addo(Numerus, Numerus)
     * */
    ADDITIO('+', Math::addExact, Numerus::addo),

    /**
     * Hic valor subtractiōnem indicat.
     * @see Math#subtractExact(int, int)
     * @see Numerus#subtraho(Numerus, Numerus)
     * */
    SUBTRACTIO('-', Math::subtractExact, Numerus::subtraho),

    /**
     * Hic valor multiplicātiōnem indicat.
     * @see Math#multiplyExact(int, int)
     * @see Numerus#multiplico(Numerus, Numerus)
     * */
    MULTIPLICIO('*', Math::multiplyExact, Numerus::multiplico),

    /**
     * Hic valor dīvīsiōnem indicat.
     * @see Math#floorDiv(int, int)
     * @see Numerus#divido(Numerus, Numerus)
     * */
    DIVISIO('/', Math::floorDiv, Numerus::divido),

    /**
     * Hic valor mānsiōnem indicat.
     * @see Math#floorMod(int, int)
     * @see Numerus#maneo(Numerus, Numerus)
     * */
    MANSIO('%', Math::floorMod, Numerus::maneo);

    /**
     * Hic valor symbolum continet quod operātiōnem cum arabicā mathēmaticā indicat.
     * */
    public final char symbolum;

    /**
     * Hic modus operātiōnem cum arabicā mathēmaticā agit.
     * */
    @NonNull public final BiFunction<Integer, Integer, Integer> arabicus;

    /**
     * Hic modus operātiōnem cum rōmānā mathēmaticā agit.
     * */
    @NonNull public final BiFunction<Numerus, Numerus, Numerus> romanus;

    Operatio(final char sblm, @NonNull final BiFunction<Integer, Integer, Integer> rbcs,
             @NonNull final BiFunction<Numerus, Numerus, Numerus> rmns) {
        symbolum = sblm;
        arabicus = rbcs;
        romanus = rmns;
    }

    /**
     * Hic modus utrum modum dēterminat.
     * @param lingua  Rēs classis {@link IntegerType} dēterminātūra
     * @return  Valōrem {@link #romanus} valōrī {@link IntegerType#ROMAN};
     *          valōrem {@link #arabicus} valōrī {@link IntegerType#ARABIC}
     * */
    @NonNull public final BiFunction<?,?,?> modus(@NonNull final IntegerType lingua) {
        return switch (lingua) {
            case ARABIC -> arabicus;
            case ROMAN -> romanus;
        };
    }
}
