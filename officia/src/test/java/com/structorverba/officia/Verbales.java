package com.structorverba.officia;

import androidx.annotation.NonNull;
import com.structorverba.officia.enumerationes.*;
import com.structorverba.officia.miscella.StructorVerba;
import com.structorverba.officia.tentamina.Tentamen;
import com.structorverba.officia.verba.*;
import com.structorverba.officia.verba.multiplicia.*;
import lombok.Getter;
import org.junit.jupiter.api.*;

import java.util.stream.Stream;

/**
 * Haec classis cōnstrūctiōnem rēbus extēnsiōnis cuiusque classis {@link Verbum} tentat.
 * Modus quisque proper modum {@link #omnesDeleantur()} rem fortuītam catēgoriae imputātae generat.
 * @see StructorVerba#fortuitumLegam(Categoria)
 * */
@SuppressWarnings({"NewClassNamingConvention", "SpellCheckingInspection"})
@TestMethodOrder(MethodOrderer.Random.class)
public class Verbales {
    @NonNull @Getter(lazy = true)
    private final StructorVerba structor = StructorVerba.faciendum.get();

    @NonNull @Getter(lazy = true)
    private final java.util.function.Consumer<Categoria> actio =
            categoria -> System.out.println(new Tentamen.TentamenVerbi(categoria.declina(Casus.NOMINATIVUS, Numeralis.SINGULARIS, false))
                                                        .exsequar(structor.fortuitumLegam(categoria)));

    /**
     * Hic modus cōnstrūctiōnem rēbus classis {@link Actus} tentat.
     * @see Categoria#ACTUS
     * */
    @Test
    public void actusDeleatur() {
       actio.accept(Categoria.ACTUS);
    }

    /**
     * Hic modus cōnstrūctiōnem rēbus classis {@link Adverbium} tentat.
     * @see Categoria#ADVERBIUM
     * */
    @Test
    public void adverbiumDeleatur() {
        actio.accept(Categoria.ADVERBIUM);
    }

    /**
     * Hic modus cōnstrūctiōnem rēbus classis {@link Adiectivum} tentat.
     * @see Categoria#ADIECTIVUM
     * */
    @Test
    public void adiectivumDeleatur() {
        actio.accept(Categoria.ADIECTIVUM);
    }

    /**
     * Hic modus cōnstrūctiōnem rēbus classis {@link Pronomen} tentat.
     * @see Categoria#PRONOMEN
     * */
    @Test
    public void pronomenDeleatur() {
        actio.accept(Categoria.PRONOMEN);
    }

    /**
     * Hic modus cōnstrūctiōnem rēbus classis {@link Nomen} tentat.
     * @see Categoria#NOMEN
     * */
    @Test
    public void nomenDeleatur() {
        actio.accept(Categoria.NOMEN);
    }

    /**
     * Hic modus cōnstrūctiōnem rēbus classis {@link VerbumSimplex.Praepositio} tentat.
     * @see Categoria#PRAEPOSITIO
     * */
    @Test
    public void praepositioDeleatur() {
        actio.accept(Categoria.PRAEPOSITIO);
    }

    /**
     * Hic modus cōnstrūctiōnem rēbus classis {@link VerbumSimplex.Coniunctio} tentat.
     * @see Categoria#CONIUNCTIO
     * */
    @Test
    public void coniuctioDeleatur() {
        actio.accept(Categoria.CONIUNCTIO);
    }

    /**
     * Hic modus cōnstrūctiōnem rēbus classis {@link VerbumSimplex.Interiectio} tentat.
     * @see Categoria#INTERIECTIO
     * */
    @Test
    public void interiectioDeleatur() {
        actio.accept(Categoria.INTERIECTIO);
    }

    /**
     * Hic modus cōnstrūctiōnem rēbus classis {@link VerbumSimplex.Numerus} tentat.
     * @see Categoria#NUMERUS
     * */
    @Test
    public void numerusDeleatur() {
        actio.accept(Categoria.NUMERUS);
    }

    /**
     * Hic modus cōnstrūctiōnem rēbus extēnsiōnis omnes classis {@link Verbum} tentat.
     * @see Categoria
     * */
    @Test
    public void omnesDeleantur() {
        Stream.of(Categoria.values()).forEach(actio);
    }
}
