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
 * Classis {@link Adverbium} repraesentat adverbia ut coniectēris. <br>
 * Rēs huius classis catēgoriam {@link Categoria#ADVERBIUM} ūtuntur cōnservātaque sunt in
 * scrīnio <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>/adverbia.
 * @see Lector.Adverbiis
 * @see Tenor.Adverbiis
 * @see Inventor.Adverbiis
 * @see Curator.Adverbiis
 * @see Nuntius.Verbis.Adverbiis
 */
@SuppressWarnings("SpellCheckingInspection")
@DependsOn("Nuntius.Verbis.Adverbiis")
public class Adverbium extends Verbum.Multiplex<Adverbium>
        implements Curabile<Adverbium>, Legibile<Adverbium>, Tenebile<Adverbium> {
  /**
   * Hic valor potentiam reī huius dēsignat.
   * @see Gradus
   */
  @NonNull public final Gradus gradus;
  @NonNull @Getter(lazy = true)
  private final Nuntius.Verbis.Adverbiis nuntius = Nuntius.Verbis.Adverbiis.faciendum.get();

  @Builder(access = AccessLevel.PUBLIC, toBuilder = true)
  private Adverbium(@NonNull final Gradus gradus, @NonNull final String lemma,
                    @NonNull final String scriptio) {
    super(Categoria.ADIECTIVUM, lemma, scriptio);
    this.gradus = gradus;
    nuntius.plusGarrio("Scrībor ut", scriptio);
  }

    /**
     * Hic modus verbum dē valōribus imputātīs dēclīnat.
     * */
  @NonNull public static BiFunction<Casus, Numeralis, String> declinatio =
          (casus, numeralis) -> "adverbi".concat(switch (casus) {
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
