package com.structorverba.officia.verba.simplicia;

import androidx.annotation.NonNull;
import com.structorverba.officia.enumerationes.*;
import com.structorverba.officia.nuntii.Nuntius;
import com.structorverba.officia.quadriiugia.*;
import com.structorverba.officia.verba.Verbum;
import com.structorverba.officia.verba.interfacta.*;
import jakarta.ejb.DependsOn;
import lombok.*;
import org.apache.commons.lang3.StringUtils;

import java.util.function.BiFunction;

/**
 * Classis {@link Coniunctio} repraesentat coniūnctīva ut coniectēris. <br>
 * Rēs huius classis catēgoriam {@link Categoria#CONIUNCTIO} ūtuntur cōnservātaque sunt
 * in scrīniō <a href="{@docRoot}/../src/main/resources">auxiliāres</a>/coniūnctīva.
 * Haec classis classisque {@link Interiectio} ā cōnspectiōne programmātis StrūctorVerba est eaedem.
 * @see Lector.Coniunctionibus
 * @see Tenor.Coniunctionibus
 * @see Curator.Coniunctionibus
 * @see Nuntius.Verbis.Coniunctionibus
 */
@SuppressWarnings("SpellCheckingInspection")
@DependsOn("Nuntius.Verbis.Coniunctionibus")
public final class Coniunctio extends Verbum.Simplex<Coniunctio>
        implements Curabile<Coniunctio>, Legibile<Coniunctio>, Tenebile<Coniunctio> {
    @NonNull
    @Getter(lazy = true)
    private final Nuntius.Verbis.Coniunctionibus nuntius = Nuntius.Verbis.Coniunctionibus.faciendum.get();

    @Builder(access = AccessLevel.PUBLIC, toBuilder = true)
    private Coniunctio(@NonNull final String lemma) {
        super(Categoria.CONIUNCTIO, lemma);
        nuntius.plusGarrio("Scrībor ut", lemma);
    }

    /**
     * Hic modus verbum dē valōribus imputātīs dēclīnat.
     * */
    @NonNull public static BiFunction<Casus, Numeralis, String> declinatio =
            (casus, numeralis) -> "coniūnctiō".concat(switch (casus) {
                case NOMINATIVUS, VOCATIVUS, DERECTUS -> switch (numeralis) {
                    case SINGULARIS, NULLUS -> StringUtils.EMPTY;
                    case PLURALIS -> "nēs";
                };
                case GENITIVUS -> switch (numeralis) {
                    case SINGULARIS, NULLUS -> "nis";
                    case PLURALIS -> "num";
                };
                case ACCUSATIVUS -> switch (numeralis) {
                    case SINGULARIS, NULLUS -> "nem";
                    case PLURALIS -> "nēs";
                };
                case DATIVUS -> switch (numeralis) {
                    case SINGULARIS, NULLUS -> "nī";
                    case PLURALIS -> "nibus";
                };
                case ABLATIVUS, INSTRUMENTALIS, LOCATIVUS -> switch (numeralis) {
                    case SINGULARIS, NULLUS -> "ne";
                    case PLURALIS -> "nibus";
                };
            });
}
