package com.structorverba.officia.verba.constructores;

import androidx.annotation.*;
import com.structorverba.officia.verba.multiplicia.VerbumMultiplex;
import org.apache.commons.lang3.StringUtils;

/**
 * Extēnsiōnēs huius classis rērum classis {@link VerbumMultiplex} extendae cōnstruunt.
 * @param <Hoc> Hāc tabellā classis {@link Hoc} extēnsiōnem aptam datīs petītīs repraesentat.
 * */
@SuppressWarnings("SpellCheckingInspection")
public abstract class Constructor<Hoc> {
    /**
     * Hic valor repraesentat fōrmam verbī cui rādīcēscit. <br>
     * Quoque nōminātur scāpum XML quō cōnservātum est.
     */
    @NonNull protected String lemma     = StringUtils.EMPTY;

    /**
     * Hic valor fōrmam fīnem verbī repraesentat. <br>
     * Condiciōnibus plūrimīs est ut ūsūfructuāriī petīvit.
     */
    @NonNull protected String scriptio  = StringUtils.EMPTY;

    protected Constructor() {  }

    /**
     * Hic modus valōrem {@link #lemma} induit.
     * @param lemma  Valor induendus
     * */
    public void lemma(@NonNull final String lemma) {
        this.lemma = lemma;
    }

    /**
     * Hic modus valōrem {@link #scriptio} induit.
     * @param scriptio  Valor induendus
     * */
    public void scriptio(@NonNull final String scriptio) {
        this.scriptio = scriptio;
    }

    /**
     * @return {@code true} sī cōnstrūctiō huius reī fīnīrī parāta'st; {@code false} aliter.
     * */
    public boolean paratus() {
        return StringUtils.isNoneBlank(lemma, scriptio);
    }

    /**
     * Hic modus cōnstrūctiōnem huius reī agit.
     * @return  Rem classis {@link Hoc} cum valōribus imputātīs.
     * @implNote  Classēs extendae valōrem {@code null} referendae sunt sī {@link #paratus()} valōrem {@code false} refert.
     * */
    @Nullable
    public abstract Hoc build();

    /**
     * Hic modus valōrēs imputātōs huius reī restituit.
     * */
    public abstract void restituo();
}
