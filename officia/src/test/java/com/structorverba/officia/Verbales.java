package com.structorverba.officia;

import androidx.annotation.NonNull;
import com.structorverba.officia.enumerationes.Categoria;
import com.structorverba.officia.miscella.StructorVerba;
import com.structorverba.officia.tentamina.Tentamen;
import lombok.Getter;
import org.junit.jupiter.api.*;

import java.util.stream.Stream;

@SuppressWarnings({"NewClassNamingConvention", "SpellCheckingInspection"})
@TestMethodOrder(MethodOrderer.Random.class)
public class Verbales {
    @NonNull @Getter(lazy = true)
    private final StructorVerba structor = StructorVerba.faciendum.get();

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
}
