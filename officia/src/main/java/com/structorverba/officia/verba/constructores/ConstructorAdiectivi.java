package com.structorverba.officia.verba.constructores;

import androidx.annotation.*;
import com.structorverba.officia.enumerationes.*;
import com.structorverba.officia.verba.multiplicia.Adiectivum;
import org.apache.commons.lang3.StringUtils;

@SuppressWarnings("SpellCheckingInspection")
public class ConstructorAdiectivi extends Constructor<Adiectivum> {
    @NonNull
    private Specialitas specialitas = Specialitas.NULLUM;
    @NonNull private Genus genus = Genus.NULLUM;
    @NonNull private Casus casus = Casus.DERECTUS;
    @NonNull private Numeralis numeralis = Numeralis.NULLUS;
    @NonNull private Gradus gradus = Gradus.NULLUS;

    public void specialitas(@NonNull final Specialitas specialitas) {
        this.specialitas = specialitas;
    }

    public void genus(@NonNull final Genus genus) {
        this.genus = genus;
    }

    public void casus(@NonNull final Casus casus) {
        this.casus = casus;
    }

    public void numeralis(@NonNull final Numeralis numeralis) {
        this.numeralis = numeralis;
    }

    public void gradus(@NonNull final Gradus gradus) {
        this.gradus = gradus;
    }

    @Nullable
    @Override
    public Adiectivum build() {
        return paratus() ? Adiectivum.builder().lemma(lemma).specialitas(specialitas).genus(genus).casus(casus)
                                               .numeralis(numeralis).gradus(gradus).scriptio(scriptio).build()
                         : null;
    }

    /**
     * {@inheritDoc}
     * @see Specialitas#NULLUM
     * @see Genus#NULLUM
     * @see Casus#DERECTUS
     * @see Numeralis#NULLUS
     * @see Gradus#NULLUS
     */
    @Override public void restituo() {
        specialitas = Specialitas.NULLUM;
        genus = Genus.NULLUM;
        casus = Casus.DERECTUS;
        numeralis = Numeralis.NULLUS;
        gradus = Gradus.NULLUS;
        scriptio = StringUtils.EMPTY;
        lemma = StringUtils.EMPTY;
    }
}
