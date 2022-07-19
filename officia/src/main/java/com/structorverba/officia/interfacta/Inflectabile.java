package com.structorverba.officia.interfacta;

import androidx.annotation.NonNull;
import com.structorverba.officia.enumerationes.Encliticum;
import com.structorverba.officia.verba.multiplicia.Multiplex;

/**
 * Haec interfactum est sessor classī parametrālis classis {@link Multiplex}.
 * Implētīs nec classem {@link Immutans} impleant.
 * @see Encliticum
 * */
@SuppressWarnings("SpellCheckingInspection")
public interface Inflectabile <Hoc extends Inflectabile<Hoc>> extends Inventabile<Hoc> {
    /**
     * Hic modus ūsūfructuāriōs licet valōrem {@link #encliticum} allegere.
     * @param encliticum valōrem {@link #encliticum} indicat
     * @return Hanc rem
     * @see Encliticum
     */
    @NonNull Hoc allegam(@NonNull Encliticum encliticum);

    /**
     * @return valōrem allēctum modō {@link #allegam(Encliticum)}
     */
    @SuppressWarnings("unused")
    @NonNull Encliticum encliticum();
}
