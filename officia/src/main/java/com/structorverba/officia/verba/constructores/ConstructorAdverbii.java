package com.structorverba.officia.verba.constructores;

import androidx.annotation.*;
import com.structorverba.officia.enumerationes.Gradus;
import com.structorverba.officia.verba.multiplicia.Adverbium;
import org.apache.commons.lang3.StringUtils;

@SuppressWarnings("SpellCheckingInspection")
public class ConstructorAdverbii  extends Constructor<Adverbium> {
    /**
     * Hic valor potentiam reī huius dēsignat.
     * @see Gradus
     */
    @NonNull private Gradus gradus = Gradus.NULLUS;

    /**
     * Hic modus valōrem {@link #gradus} induit.
     * @param gradus  Valor induendus
     * */
    public void gradus(@NonNull Gradus gradus) {
        this.gradus = gradus;
    }

    /**
     * Hic modus cōnstrūctiōnem huius reī agit.
     * @return  Rem classis {@link Adverbium} cum valōribus imputātīs.
     * @implNote  Hic modus {@code null} refert sī {@link #paratus()} valōrem {@code false} refert.
     * */
    @Nullable @Override
    public Adverbium build() {
        return paratus() ? Adverbium.builder().lemma(lemma).scriptio(scriptio).gradus(gradus).build()
                         : null;
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
