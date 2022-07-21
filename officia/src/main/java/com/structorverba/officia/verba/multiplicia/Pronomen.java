package com.structorverba.officia.verba.multiplicia;

import androidx.annotation.NonNull;
import com.structorverba.officia.enumerationes.*;
import com.structorverba.officia.nuntii.Nuntius;
import com.structorverba.officia.quadriiugia.*;
import com.structorverba.officia.verba.Verbum;
import com.structorverba.officia.verba.interfacta.*;
import jakarta.ejb.DependsOn;
import lombok.*;

import java.util.function.BiFunction;

/**
 * Classis {@link Pronomen} repraesentat prōnōmina ut coniectēris. <br>
 * Rēs huius classis catēgoriam {@link Categoria#PRONOMEN} ūtuntur cōnservātaque sunt in
 * scrīniō <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>/prōnōmina.
 * @see Lector.Pronominibus
 * @see Tenor.Pronominibus
 * @see Inventor.Pronominibus
 * @see Curator.Pronominibus
 * @see Nuntius.Verbis.Pronominibus
 */
@SuppressWarnings("SpellCheckingInspection")
@DependsOn("Nuntius.Verbis.Pronominibus")
public final class Pronomen extends Verbum.Multiplex.Declinabile<Pronomen>
        implements Curabile<Pronomen>, Legibile<Pronomen>, Tenebile<Pronomen> {
  @NonNull @Getter(lazy = true)
  private final Nuntius.Verbis.Pronominibus nuntius = Nuntius.Verbis.Pronominibus.faciendum.get();

  @Builder(access = AccessLevel.PUBLIC, toBuilder = true)
  private Pronomen(@NonNull final Specialitas specialitas, @NonNull final Genus genus,
                   @NonNull final Casus casus, @NonNull final Numeralis numeralis,
                   @NonNull final String lemma, @NonNull final String scriptio) {
    super(Categoria.PRONOMEN, specialitas, genus, casus, numeralis, lemma, scriptio);
    nuntius.plusGarrio("Scrībor ut", scriptio);
  }

    /**
     * Hic modus verbum dē valōribus imputātīs dēclīnat.
     * */
  @NonNull public static BiFunction<Casus, Numeralis, String> declinatio =
          (casus, numeralis) -> "prō".concat(Nomen.declinatio.apply(casus, numeralis));
}
