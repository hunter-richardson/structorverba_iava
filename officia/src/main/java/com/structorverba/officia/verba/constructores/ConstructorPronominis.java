package com.structorverba.officia.verba.constructores;

import androidx.annotation.*;
import com.structorverba.officia.enumerationes.*;
import com.structorverba.officia.verba.multiplicia.*;
import org.apache.commons.lang3.StringUtils;

@SuppressWarnings("SpellCheckingInspection")
public class ConstructorPronominis extends Constructor<Pronomen> {
    /**
     * Hic valor dēsignat utrum haec rēs repraesentat certum necne.
     * @see Specialitas
     */
    @NonNull
    private Specialitas specialitas = Specialitas.NULLUM;

    /**
     * Hic valor generem reī huius dēsignat.
     * @see Genus
     */
    @NonNull private Genus genus = Genus.NULLUM;

    /**
     * Hic valor cāsum reī huius dēsignat.
     * @see Casus
     */
    @NonNull private Casus casus = Casus.DERECTUS;

    /**
     * Hic valor numerum reī huius dēsignat.
     * @see Numeralis
     */
    @NonNull private Numeralis numeralis = Numeralis.NULLUS;

    /**
     * Hic modus valōrem {@link #specialitas} induit.
     * @param specialitas  Valor induendus
     * */
    public void specialitas(@NonNull final Specialitas specialitas) {
        this.specialitas = specialitas;
    }

    /**
     * Hic modus valōrem {@link #genus} induit.
     * @param genus  Valor induendus
     * */
    public void genus(@NonNull final Genus genus) {
        this.genus = genus;
    }

    /**
     * Hic modus valōrem {@link #casus} induit.
     * @param casus  Valor induendus
     * */
    public void casus(@NonNull final Casus casus) {
        this.casus = casus;
    }

    /**
     * Hic modus valōrem {@link #numeralis} induit.
     * @param numeralis  Valor induendus
     * */
    public void numeralis(@NonNull final Numeralis numeralis) {
        this.numeralis = numeralis;
    }

    /**
     * Hic modus cōnstrūctiōnem huius reī agit.
     * @return  Rem classis {@link Pronomen} cum valōribus imputātīs.
     * @implNote  Hic modus {@code null} refert sī {@link #paratus()} valōrem {@code false} refert.
     * */
    @Nullable @Override
    public Pronomen build() {
        return paratus() ? Pronomen.builder().lemma(lemma).specialitas(specialitas).genus(genus).casus(casus)
                                             .numeralis(numeralis).scriptio(scriptio).build()
                         : null;
    }

    /**
     * {@inheritDoc}
     * @see Specialitas#NULLUM
     * @see Genus#NULLUM
     * @see Casus#DERECTUS
     * @see Numeralis#NULLUS
     */
    @Override public void restituo() {
        specialitas = Specialitas.NULLUM;
        genus = Genus.NULLUM;
        casus = Casus.DERECTUS;
        numeralis = Numeralis.NULLUS;
        scriptio = StringUtils.EMPTY;
        lemma = StringUtils.EMPTY;
    }
}

