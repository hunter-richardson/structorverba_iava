package com.structorverba.officia.verba.constructores;

import androidx.annotation.*;
import com.structorverba.officia.enumerationes.*;
import com.structorverba.officia.verba.multiplicia.*;
import org.apache.commons.lang3.StringUtils;

@SuppressWarnings("SpellCheckingInspection")
public final class ConstructorActi extends Constructor<Actus> {
    @NonNull
    private Modus modus = Modus.NULLUS;
    @NonNull private Vox vox = Vox.NULLA;
    @NonNull private Tempus tempus = Tempus.INTEMPORALE;
    @NonNull private Numeralis numeralis = Numeralis.NULLUS;
    @NonNull private Persona persona = Persona.NULLA;

    public void modus(@NonNull Modus modus) {
        this.modus = modus;
    }

    public void vox(@NonNull Vox vox) {
        this.vox = vox;
    }

    public void tempus(@NonNull Tempus tempus) {
        this.tempus = tempus;
    }

    public void numeralis(@NonNull Numeralis numeralis) {
        this.numeralis = numeralis;
    }

    public void persona(@NonNull Persona persona) {
        this.persona = persona;
    }

    /**
     * Hic modus cōnstrūctiōnem huius reī agit.
     * @return  Rem classis {@link Actus} cum valōribus imputātīs.
     * @implNote  Hic modus {@code null} refert sī {@link #paratus()} valōrem {@code false} refert.
     * */
    @Nullable @Override
    public Actus build() {
        return paratus() ? Actus.builder().lemma(lemma).modus(modus).vox(vox).tempus(tempus)
                                          .numeralis(numeralis).persona(persona).scriptio(scriptio).build()
                         : null;
    }

    /**
     * {@inheritDoc}
     * @see Modus#NULLUS
     * @see Vox#NULLA
     * @see Tempus#INTEMPORALE
     * @see Numeralis#NULLUS
     * @see Persona#NULLA
     */
    @Override public void restituo() {
        numeralis = Numeralis.NULLUS;
        persona = Persona.NULLA;
        tempus = Tempus.INTEMPORALE;
        modus = Modus.NULLUS;
        vox = Vox.NULLA;
        scriptio = StringUtils.EMPTY;
        lemma = StringUtils.EMPTY;
    }
}
