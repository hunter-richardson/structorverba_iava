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
 * Classis {@link Adiectivum} repraesentat adiectīva ut coniectēris. <br>
 * Rēs huius classis catēgoriam {@link Categoria#NOMEN} ūtuntur cōnservātaque sunt in scrīniō
 * <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>/adiectīva. <br>
 * Discrīmina prīmōria inter hīs classibus classeque {@link Pronomen} est huius valor {@link #gradus}.
 * @see Lector.Adiectivis
 * @see Tenor.Adiectivis
 * @see Inventor.Adiectivis
 * @see Curator.Adiectivis
 * @see Nuntius.Verbis.Adiectivis
 */
@SuppressWarnings("SpellCheckingInspection")
@DependsOn("Nuntius.Verbis.Adiectivis")
public final class Adiectivum extends Verbum.Multiplex.Declinabile<Adiectivum>
        implements Curabile<Adiectivum>, Legibile<Adiectivum>, Tenebile<Adiectivum> {
  /**
   * Hic valor potentiam reī huius dēsignat.
   * @see Gradus
   */
  @NonNull public final Gradus gradus;
  @NonNull @Getter(lazy = true)
  private final Nuntius.Verbis.Adiectivis nuntius = Nuntius.Verbis.Adiectivis.faciendum.get();

  @Builder(access = AccessLevel.PUBLIC, toBuilder = true)
  private Adiectivum(@NonNull final Specialitas specialitas, @NonNull final Genus genus,
                     @NonNull final Casus casus, @NonNull final Numeralis numeralis,
                     @NonNull final Gradus gradus, @NonNull final String lemma,
                     @NonNull final String scriptio) {
    super(Categoria.ADIECTIVUM, specialitas, genus, casus, numeralis, lemma, scriptio);
    this.gradus = gradus;
    nuntius.plusGarrio("Scrībor ut", scriptio);
  }

    /**
     * Hic modus verbum dē valōribus imputātīs dēclīnat.
     * */
  @NonNull public static BiFunction<Casus, Numeralis, String> declinatio =
          (casus, numeralis) -> "adiectīv".concat(switch (casus) {
            case NOMINATIVUS, ACCUSATIVUS, VOCATIVUS, DERECTUS -> switch (numeralis) {
              case SINGULARIS, NULLUS -> "um";
              case PLURALIS -> "a";
            };
            case GENITIVUS -> switch (numeralis) {
              case SINGULARIS, NULLUS -> "ī";
              case PLURALIS -> "ōrum";
            };
            case DATIVUS, ABLATIVUS, INSTRUMENTALIS, LOCATIVUS -> switch (numeralis) {
              case SINGULARIS, NULLUS -> "ō";
              case PLURALIS -> "īs";
            };
          });
}
