package com.structorverba.officia.interfacta;

import androidx.annotation.*;
import com.structorverba.officia.enumerationes.*;
import com.structorverba.officia.lectores.LectorMultiplicibus;
import com.structorverba.officia.verba.multiplicia.*;

/**
 * Classis {@link Declinabile} verbum aliquem coniugātumepraesentat.
 * @param <Hoc> Hāc tabellā classis {@link Hoc} extēnsiōnem aptam datīs petītīs repraesentat.
 * @see Actus
 */
@SuppressWarnings({"SpellCheckingInspection", "unused"})
public interface Coniugabile<Hoc extends Coniugabile<Hoc>> {
    /**
     * Hic modus rem classis {@link Adiectivum} ā parametrīs dēsignātīs advenit.
     * @param vox    valōrem {@link Actus#vox} indicat.
     * @param tempus  valōrem {@link Actus#tempus} indicat.
     * @param genus   valōrem {@link Declinabile#genus} indicat.
     * @param casus   valōrem {@link Declinabile#casus} indicat.
     * @param numeralis  valōrem {@link Declinabile#numeralis} indicat.
     * @return Rem classis {@link Adiectivum} quod parametra dēsignāta quadrat.
     * @see LectorMultiplicibus.LectorAdiectivis#adveniam(String, Enum[])
     * @see Modus#PARTICIPALIS
     */
    @Nullable Adiectivum participem(@NonNull Vox vox, @NonNull Tempus tempus, @NonNull Genus genus,
                                    @NonNull Casus casus, @NonNull Numeralis numeralis);

    /**
     * Hic modus rem classis {@link Adiectivum} ā parametrīs dēsignātīs advenit.
     * @param vox    valōrem {@link Actus#vox} indicat.
     * @param genus   valōrem {@link Declinabile#genus} indicat.
     * @param casus   valōrem {@link Declinabile#casus} indicat.
     * @param numeralis  valōrem {@link Declinabile#numeralis} indicat.
     * @return Rem classis {@link Adiectivum} quod parametra dēsignāta quadrat.
     * @see LectorMultiplicibus.LectorAdiectivis#adveniam(String, Enum[])
     * @see Modus#PARTICIPALIS
     * @see #participem(Vox, Tempus, Genus, Casus, Numeralis)
     */
    @Nullable Adiectivum participem(@NonNull Vox vox, @NonNull Genus genus,
                                    @NonNull Casus casus, @NonNull Numeralis numeralis);

    /**
     * Hic modus rem classis {@link Adiectivum} ā parametrīs dēsignātīs advenit.
     * @param tempus  valōrem {@link Actus#tempus} indicat.
     * @param genus   valōrem {@link Declinabile#genus} indicat.
     * @param casus   valōrem {@link Declinabile#casus} indicat.
     * @param numeralis  valōrem {@link Declinabile#numeralis} indicat.
     * @return Rem classis {@link Adiectivum} quod parametra dēsignāta quadrat.
     * @see LectorMultiplicibus.LectorAdiectivis#adveniam(String, Enum[])
     * @see Modus#PARTICIPALIS
     * @see #participem(Vox, Tempus, Genus, Casus, Numeralis)
     */
    @Nullable Adiectivum participem(@NonNull Tempus tempus, @NonNull Genus genus,
                                    @NonNull Casus casus, @NonNull Numeralis numeralis);

    /**
     * Hic modus rem classis {@link Adiectivum} ā parametrīs dēsignātīs advenit.
     * @param genus   valōrem {@link Declinabile#genus} indicat.
     * @param casus   valōrem {@link Declinabile#casus} indicat.
     * @param numeralis  valōrem {@link Declinabile#numeralis} indicat.
     * @return Rem classis {@link Adiectivum} quod parametra dēsignāta quadrat.
     * @see LectorMultiplicibus.LectorAdiectivis#adveniam(String, Enum[])
     * @see Modus#PARTICIPALIS
     * @see #participem(Vox, Tempus, Genus, Casus, Numeralis)
     */
    @Nullable Adiectivum participem(@NonNull Genus genus, @NonNull Casus casus, @NonNull Numeralis numeralis);

    /**
     * Hic modus rem classis {@link Nomen} ā parametrīs dēsignātīs advenit.
     * @param tempus  valōrem {@link Nomen#tempus} indicat.
     * @param casus   valōrem {@link Declinabile#casus} indicat.
     * @return Rem classis {@link Nomen} quod parametra dēsignāta quadrat.
     * @see LectorMultiplicibus.LectorNominibus#adveniam(String, Enum[])
     * @see Tempus#GERUNDIVUS
     * @see Tempus#SUPINUS
     * @see Genus#NEUTRUM
     * @see Specialitas#COMMUNE
     */
    @Nullable Nomen nominem(@NonNull Tempus tempus, @NonNull Casus casus);

    /**
     * Hic modus rem classis {@link Nomen} ā rē {@link Casus}
     * rēque {@link Tempus#GERUNDIVUS} dēsignātīs advenit.
     * @param casus   valōrem {@link Declinabile#casus} indicat.
     * @return Rem classis {@link Nomen} quod parametra dēsignāta quadrat.
     * @see Tempus#GERUNDIVUS
     * @see #nominem(Tempus, Casus)
     */
    @Nullable Nomen geram(@NonNull Casus casus);

    /**
     * Hic modus rem classis {@link Nomen} ā rē {@link Casus}
     * rēque {@link Tempus#SUPINUS} dēsignātīs advenit.
     * @param casus   valōrem {@link Declinabile#casus} indicat.
     * @return Rem classis {@link Nomen} quod parametra dēsignāta quadrat.
     * @see Tempus#SUPINUS
     * @see #nominem(Tempus, Casus)
     */
    @Nullable Nomen cubem(@NonNull Casus casus);
}
