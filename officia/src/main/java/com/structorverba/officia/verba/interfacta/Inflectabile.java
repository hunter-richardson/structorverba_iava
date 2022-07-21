package com.structorverba.officia.verba.interfacta;

import androidx.annotation.NonNull;
import com.structorverba.officia.enumerationes.Encliticum;
import com.structorverba.officia.verba.Verbum;

/**
 * Haec interfactum est sessor classī parametrālis classis {@link Verbum.Multiplex}.
 * Implētīs nōn classem {@link Immutans} impleant.
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
