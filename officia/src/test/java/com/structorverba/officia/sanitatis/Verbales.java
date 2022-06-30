package com.structorverba.officia.sanitatis;

import androidx.annotation.*;
import com.structorverba.officia.enumerationes.Categoria;
import com.structorverba.officia.miscella.StructorVerba;
import com.structorverba.officia.nuntii.*;
import com.structorverba.officia.tentamina.Tentamen;
import jakarta.ejb.Singleton;
import lombok.Getter;
import org.apache.commons.lang3.ObjectUtils;
import org.junit.jupiter.api.*;

import java.util.function.Supplier;
import java.util.stream.Stream;

@SuppressWarnings({"NewClassNamingConvention", "SpellCheckingInspection"})
@TestMethodOrder(MethodOrderer.Random.class)
public class Verbales {
    @Getter(lazy = true)
    @NonNull private final NuntiusTentaminibusVerbalibus nuntius = NuntiusTentaminibusVerbalibus.fac.get();
    @NonNull
    @Getter(lazy = true)
    private final StructorVerba structor = StructorVerba.fac.get();

    @Test
    public void actusDeleatur() {
       System.out.println(new Tentamen.TentamenVerbi(structor.fortuitumLegam(Categoria.ACTUS)));
    }

    @Test
    public void adverbiumDeleatur() {
        System.out.println(new Tentamen.TentamenVerbi(structor.fortuitumLegam(Categoria.ADVERBIUM)));
    }

    @Test
    public void adiectivumDeleatur() {
        System.out.println(new Tentamen.TentamenVerbi(structor.fortuitumLegam(Categoria.ADIECTIVUM)));
    }

    @Test
    public void pronomenDeleatur() {
        System.out.println(new Tentamen.TentamenVerbi(structor.fortuitumLegam(Categoria.PRONOMEN)));
    }

    @Test
    public void nomenDeleatur() {
        System.out.println(new Tentamen.TentamenVerbi(structor.fortuitumLegam(Categoria.NOMEN)));
    }

    @Test
    public void praepositioDeleatur() {
        System.out.println(new Tentamen.TentamenVerbi(structor.fortuitumLegam(Categoria.PRAEPOSITIO)));
    }

    @Test
    public void numerusDeleatur() {
        System.out.println(new Tentamen.TentamenVerbi(structor.fortuitumLegam(Categoria.NUMERUS)));
    }

    @Test
    public void omnesDeleantur() {
        Stream.of(Categoria.values())
              .forEach(categoria -> System.out.println(new Tentamen.TentamenVerbi(structor.fortuitumLegam(categoria))));
    }

    /**
     * Classis {@link NuntiusTentaminibusVerbalibus} est v\u0101s classis {@link Nuntius} class\u012B {@link Verbales}}
     */
    @Singleton
    static final class NuntiusTentaminibusVerbalibus extends Nuntius {
        @Nullable
        static NuntiusTentaminibusVerbalibus instantia = null;

        /**
         * Valor hic viam re\u012B classis huiuc facit.
         * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
         */
        @NonNull static final Supplier<NuntiusTentaminibusVerbalibus> fac =
                () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusTentaminibusVerbalibus());

        NuntiusTentaminibusVerbalibus() {
            super(ParametriNuntii.para(Verbales.class));
        }
    }

}
