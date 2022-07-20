package com.structorverba.officia.verba.constructores;

import androidx.annotation.NonNull;
import com.structorverba.officia.verba.*;
import com.structorverba.officia.verba.multiplicia.Multiplex;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.function.Function;

/**
 * Haec classis accessum officiīs extentōrum classis {@link Simplex} prōvidet
 * sīcut classis {@link Constructor} officiīs extentōrum classis {@link Multiplex}.
 * */
@SuppressWarnings("SpellCheckingInspection")
public final class ConstructorSimplicium {
    /**
     * Hic modus rem classis {@link Simplex.Coniunctio} construit
     * */
    @NonNull @Accessors(fluent = true) @Getter(value = AccessLevel.PUBLIC, lazy = true)
    private static final Function<String, Simplex.Coniunctio> coniunctionis =
            lemma -> Simplex.Coniunctio.builder().lemma(lemma).build();

    /**
     * Hic modus rem classis {@link Simplex.Interiectio} construit
     * */
    @NonNull @Accessors(fluent = true) @Getter(value = AccessLevel.PUBLIC, lazy = true)
    private static final Function<String, Simplex.Interiectio> interiectionis =
            lemma -> Simplex.Interiectio.builder().lemma(lemma).build();

    /**
     * Hic modus rem classis {@link Simplex.Praepositio} construit
     * */
    @NonNull @Accessors(fluent = true) @Getter(value = AccessLevel.PUBLIC, lazy = true)
    private static final Function<String, Simplex.Praepositio> praepositionis =
            lemma -> Simplex.Praepositio.builder().lemma(lemma).build();

    /**
     * Hic modus rem classis {@link Numerus} construit
     * */
    @NonNull @Accessors(fluent = true) @Getter(value = AccessLevel.PUBLIC, lazy = true)
    private static final Function<Short, Numerus> numeri =
            numerus -> Numerus.builder().numerus(numerus).build();

    /**
     * Hic modus rem classis {@link Simplex} construit
     * */
    @Nullable @Accessors(fluent = true) @Getter(value = AccessLevel.PUBLIC, lazy = true)
    private static final Function<Categoria, Function<String, Simplex>> verbi =
            (categoria, lemma) -> switch(categoria) {
                    case CONIUNCTIO  -> coniunctionis;
                    case INTERIECTIO -> interiectionis;
                    case PRAEPOSITIO -> praepositionis;
                    default          -> null;
                };
}
