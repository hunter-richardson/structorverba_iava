package com.structorverba.officia.verba.constructores;

import androidx.annotation.*;
import com.structorverba.officia.enumerationes.Gradus;
import com.structorverba.officia.verba.multiplicia.Adverbium;
import org.apache.commons.lang3.StringUtils;

@SuppressWarnings("SpellCheckingInspection")
public class ConstructorAdverbii  extends Constructor<Adverbium> {
    @NonNull
    private Gradus gradus = Gradus.NULLUS;

    public void gradus(@NonNull Gradus gradus) {
        this.gradus = gradus;
    }

    @Nullable
    @Override
    public Adverbium build() {
        return paratus() ? Adverbium.builder().lemma(lemma).scriptio(scriptio).gradus(gradus).build() : null;
    }

    /**
     * {@inheritDoc}
     * @see @Gradus#NULLUS
     */
    @Override public void restituo() {
        gradus = Gradus.NULLUS;
        scriptio = StringUtils.EMPTY;
        lemma = StringUtils.EMPTY;
    }
}
