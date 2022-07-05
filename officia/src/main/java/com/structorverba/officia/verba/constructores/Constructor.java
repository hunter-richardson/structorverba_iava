package com.structorverba.officia.verba.constructores;

import androidx.annotation.*;
import org.apache.commons.lang3.StringUtils;

@SuppressWarnings("SpellCheckingInspection")
public abstract class Constructor<Hoc> {
    @NonNull
    protected String lemma     = StringUtils.EMPTY;
    @NonNull protected String scriptio  = StringUtils.EMPTY;

    protected Constructor() {  }

    public void lemma(@NonNull final String lemma) {
        this.lemma = lemma;
    }

    public void scriptio(@NonNull final String scriptio) {
        this.scriptio = scriptio;
    }

    public boolean paratus() {
        return StringUtils.isNoneBlank(lemma, scriptio);
    }

    @Nullable
    public abstract Hoc build();
    public abstract void restituo();
}
