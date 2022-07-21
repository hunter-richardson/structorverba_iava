package com.structorverba.officia.verba.simplicia;

import androidx.annotation.NonNull;
import com.structorverba.officia.quadriiugia.Lector;
import com.structorverba.officia.enumerationes.*;
import com.structorverba.officia.nuntii.Nuntius;
import com.structorverba.officia.verba.*;
import com.structorverba.officia.verba.interfacta.*;
import jakarta.ejb.DependsOn;
import lombok.*;
import org.apache.commons.lang3.StringUtils;

import java.util.function.*;

/**
 * Classis {@link Praepositio} repraesentat praepositiōnēs ut coniecteris. <br>
 * Rēs huius classis catēgoriam {@link Categoria#PRAEPOSITIO} ūtuntur cōnservātaque sunt in
 * scrīniō <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>/praepositiōnēs.
 * Haec classisque {@link Numerus} est extenta sōla classis {@link Verbum} quod classēs {@link Curabile} et {@link Legibile} et {@link Tenebile} nōn implet.
 * @see Lector.Praepositionibus
 * @see Nuntius.Verbis.Praepositionibus
 */
@SuppressWarnings("SpellCheckingInspection")
@DependsOn("Nuntius.Verbis.Praepositionibus")
public final class Praepositio extends Verbum.Simplex<Praepositio> implements Curabile<Praepositio> {
    /**
     * Hic valor supplet rem classis {@link Praepositio} quam praepositiōnem nūlla repraesentat.
     */
    @NonNull
    public static final Supplier<Praepositio> assume =
            () -> Praepositio.builder().build();
    @NonNull @Getter(lazy = true)
    private final Nuntius.Verbis.Praepositionibus nuntius = Nuntius.Verbis.Praepositionibus.faciendum.get();

    @Builder(access = AccessLevel.PUBLIC, toBuilder = true)
    private Praepositio(@NonNull final String lemma) {
        super(Categoria.PRAEPOSITIO, lemma);
        nuntius.plusGarrio("Scrībor ut", lemma);
    }

    /**
     * Hic modus verbum dē valōribus imputātīs dēclīnat.
     * */
    @NonNull public static BiFunction<Casus, Numeralis, String> declinatio =
            (casus, numeralis) -> "praepositiō".concat(switch (casus) {
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
                    case SINGULARIS, NULLUS ->  "nī";
                    case PLURALIS -> "nibus";
                };
                case ABLATIVUS, INSTRUMENTALIS, LOCATIVUS -> switch (numeralis) {
                    case SINGULARIS, NULLUS -> "ne";
                    case PLURALIS -> "nibus";
                };
            });
}
