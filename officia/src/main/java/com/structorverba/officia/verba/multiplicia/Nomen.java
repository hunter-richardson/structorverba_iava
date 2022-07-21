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
 * Classis {@link Nomen} repraesentat nōmina ut coniectēris. <br>
 * Rēs huius classis catēgoriam {@link Categoria#NOMEN} ūtuntur cōnservātaque sunt in
 * scrīniō <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>/nōmina.
 * @see Lector.Nominibus
 * @see Tenor.Nominibus
 * @see Inventor.Nominibus
 * @see Curator.Nominibus
 * @see Nuntius.Verbis.Nominibus
 */
@SuppressWarnings("SpellCheckingInspection")
@DependsOn("Nuntius.Verbis.Nominibus")
public final class Nomen extends Verbum.Multiplex.Declinabile<Nomen>
        implements Curabile<Nomen>, Legibile<Nomen>, Tenebile<Nomen> {
  /**
   * Hic valor tempus reī huius dēsignat.
   * @see Modus
   */
  @NonNull public final Tempus tempus;

  @NonNull @Getter(lazy = true)
  private final Nuntius.Verbis.Nominibus nuntius = Nuntius.Verbis.Nominibus.faciendum.get();

  @Builder(access = AccessLevel.PUBLIC, toBuilder = true)
  private Nomen(@NonNull final Specialitas specialitas, @NonNull final Genus genus,
                @NonNull final Casus casus, @NonNull final Numeralis numeralis,
                @NonNull final Tempus tempus, @NonNull final String lemma,
                @NonNull final String scriptio) {
    super(Categoria.NOMEN, specialitas, genus, casus, numeralis, lemma, scriptio);
    this.tempus = tempus;
    nuntius.plusGarrio("Scrībor ut", scriptio);
  }

    /**
     * Hic modus verbum dē valōribus imputātīs dēclīnat.
     * */
  @NonNull public static BiFunction<Casus, Numeralis, String> declinatio =
          (casus, numeralis) -> "nōm".concat(switch (casus) {
            case NOMINATIVUS, ACCUSATIVUS, VOCATIVUS, DERECTUS -> switch (numeralis) {
              case SINGULARIS, NULLUS -> "en";
              case PLURALIS -> "ina";
            };
            case GENITIVUS -> switch (numeralis) {
              case SINGULARIS, NULLUS -> "inis";
              case PLURALIS -> "inum";
            };
            case DATIVUS -> switch (numeralis) {
              case SINGULARIS, NULLUS -> "inī";
              case PLURALIS -> "inibus";
            };
            case ABLATIVUS, INSTRUMENTALIS, LOCATIVUS -> switch (numeralis) {
              case SINGULARIS, NULLUS -> "ine";
              case PLURALIS -> "inibus";
            };
          });
}
