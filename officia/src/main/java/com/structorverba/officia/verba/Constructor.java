package com.structorverba.officia.verba;

import androidx.annotation.NonNull;
import androidx.annotation.*;
import com.github.chaosfirebolt.converter.constants.Patterns;
import com.structorverba.officia.enumerationes.*;
import com.structorverba.officia.miscella.Omne;
import com.structorverba.officia.quadriiugia.Curator;
import com.structorverba.officia.verba.interfacta.*;
import com.structorverba.officia.verba.multiplicia.*;
import com.structorverba.officia.verba.simplicia.*;
import jakarta.ejb.Singleton;
import lombok.*;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.*;

import java.util.function.*;

/**
 * Haec classis rēbus aditīs classis {@link Curator} officiīs extentōrum classis {@link Verba} licet.
 * @see <a href="https://projectlombok.org/api/lombok/Builder.html">Builder</a>
 * */
@SuppressWarnings("SpellCheckingInspection")
public abstract class Constructor<Hoc extends Curabile<Hoc>> extends Omne {
    @NonNull @Accessors(fluent = true) @Getter(value = AccessLevel.PUBLIC, lazy = true)
    private static final Function<Categoria, Constructor<?>> verbi =
            categoria -> (Constructor<?>) switch (categoria) {
                case ACTUS       -> Acti.faciendum;
                case ADIECTIVUM  -> Adiectivi.faciendum;
                case ADVERBIUM   -> Adverbii.faciendum;
                case NOMEN       -> Nominis.faciendum;
                case PRONOMEN    -> Pronominis.faciendum;
                case CONIUNCTIO  -> Coniunctionis.faciendum;
                case INTERIECTIO -> Interiectionis.faciendum;
                case PRAEPOSITIO -> Praepositionis.faciendum;
                case NUMERUS     -> Numeri.faciendum;
            };

    /**
     * Hic valor repraesentat fōrmam verbī cui rādīcēscit. <br>
     * Quoque nōminātur scāpum XML quō cōnservātum est.
     */
    @NonNull protected String lemma     = StringUtils.EMPTY;

    protected Constructor() {  }

    /**
     * Hic modus valōrem {@link #lemma} induit.
     * @param lemma  Valor induendus
     * */
    public Constructor<Hoc> lemma(@NonNull final String lemma) {
        this.lemma = lemma;
        return this;
    }

    /**
     * @return {@code true} sī cōnstrūctiō huius reī fīnīrī parāta'st; {@code false} aliter.
     * */
    public boolean paratus() {
        return StringUtils.isNotBlank(lemma);
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
    public void restituo() {
        lemma = StringUtils.EMPTY;
    }

    /**
     * Classis {@link Constructor.Coniunctionis} est vās classis {@link Constructor} classī {@link Coniunctio}.
     */
    @Singleton public static final class Coniunctionis extends Constructor<Coniunctio> {
        @Nullable private static Coniunctionis instantia = null;

        @NonNull public static Supplier<Coniunctionis> faciendum =
                () -> ObjectUtils.firstNonNull(instantia, instantia = new Coniunctionis());

        /**
         * Hic modus cōnstrūctiōnem huius reī agit.
         * @return  Rem classis {@link Coniunctio} cum valōribus imputātīs.
         * @implNote  Hic modus {@code null} refert sī {@link #paratus()} valōrem {@code false} refert.
         * */
        @Nullable @Override public Coniunctio build() {
            return Coniunctio.builder().lemma(lemma).build();
        }
    }

    /**
     * Classis {@link Constructor.Interiectionis} est vās classis {@link Constructor} classī {@link Interiectio}.
     */
    @Singleton public static final class Interiectionis extends Constructor<Interiectio> {
        @Nullable private static Interiectionis instantia = null;

        @NonNull public static Supplier<Interiectionis> faciendum =
                () -> ObjectUtils.firstNonNull(instantia, instantia = new Interiectionis());

        /**
         * Hic modus cōnstrūctiōnem huius reī agit.
         * @return  Rem classis {@link Interiectio} cum valōribus imputātīs.
         * @implNote  Hic modus {@code null} refert sī {@link #paratus()} valōrem {@code false} refert.
         * */
        @Nullable @Override public Interiectio build() {
            return Interiectio.builder().lemma(lemma).build();
        }
    }

    /**
     * Classis {@link Constructor.Praepositionis} est vās classis {@link Constructor} classī {@link Praepositio}.
     */
    @Singleton public static final class Praepositionis extends Constructor<Praepositio> {
        @Nullable private static Praepositionis instantia = null;

        @NonNull public static Supplier<Praepositionis> faciendum =
                () -> ObjectUtils.firstNonNull(instantia, instantia = new Praepositionis());

        /**
         * Hic modus cōnstrūctiōnem huius reī agit.
         * @return  Rem classis {@link Praepositio} cum valōribus imputātīs.
         * @implNote  Hic modus {@code null} refert sī {@link #paratus()} valōrem {@code false} refert.
         * */
        @Nullable @Override public Praepositio build() {
            return Praepositio.builder().lemma(lemma).build();
        }
    }

    /**
     * Classis {@link Constructor.Numeri} est vās classis {@link Constructor} classī {@link Numerus}.
     */
    @Singleton public static final class Numeri extends Constructor<Numerus> {
        @Nullable private static Numeri instantia = null;

        @NonNull public static Supplier<Numeri> faciendum =
                () -> ObjectUtils.firstNonNull(instantia, instantia = new Numeri());

        @NonNull @Getter(value = AccessLevel.PRIVATE, lazy = true)
        private final Range<Short> TRACTUS_NUMERORUM = Range.between(Numerus.MINUMUM, Numerus.MAXIMUM);
        @NonNull private Lingua lingua   = Lingua.NULLA;
                 private short  numerus  = 0;

        /**
         * Hic modus valōrem {@link Numerus#numerus()} induit.
         * @param numerus  Valor induendus
         * */
        public Numeri numerus(final short numerus) {
            this.numerus = numerus;
            lingua = Lingua.ROMANA;
            return this;
        }

        /**
         * Hic modus valōrem {@link #lemma} induit.
         * @param lemma  Valor induendus
         * */
        public Numeri lemma(@NonNull final String lemma) {
            this.lemma = lemma;
            lingua = Lingua.ARABICA;
            return this;
        }

        /**
         * @return {@code true} sī cōnstrūctiō huius reī fīnīrī parāta'st; {@code false} aliter.
         * */
        public boolean paratus() {
            return switch (lingua) {
                case ARABICA -> TRACTUS_NUMERORUM.contains(numerus);
                case ROMANA  -> Patterns.ROMAN_PATTERN.matcher(lemma).matches();
                case NULLA   -> false;
            };
        }

        /**
         * Hic modus cōnstrūctiōnem huius reī agit.
         * @return  Rem classis {@link Numerus} cum valōribus imputātīs.
         * @implNote  Classēs extendae valōrem {@code null} referendae sunt sī {@link #paratus()} valōrem {@code false} refert.
         * */
        @Nullable public Numerus build() throws IllegalArgumentException {
            return paratus() ? switch (lingua) {
                case ARABICA -> Numerus.builder().numerus(numerus).build();
                case ROMANA  -> new Numerus(lemma);
                case NULLA   -> null;
            }                : null;
        }

        /**
         * Hic modus valōrēs imputātōs huius reī restituit.
         * */
        public void restituo() {
            numerus = 0;
            lemma = StringUtils.EMPTY;
            lingua = Lingua.NULLA;
        }
    }

    /**
     * Extēnta huius classis rērum classis {@link Verbum.Multiplex} extendae cōnstruunt.
     * @param <Hoc> Hāc tabellā classis {@link Hoc} extēnsiōnem aptam datīs petītīs repraesentat.
     * */
    @Singleton public static abstract class Multiplicis<Hoc extends Curabile<Hoc> & Inflectabile<Hoc>> extends Constructor<Hoc> {
        /**
         * Hic valor fōrmam fīnem verbī repraesentat. <br>
         * Condiciōnibus plūrimīs est ut ūsūfructuāriī petīvit.
         */
        @NonNull protected String scriptio  = StringUtils.EMPTY;

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
    }

    /**
     * Classis {@link Constructor.Acti} est vās classis {@link Constructor} classī {@link Acti}.
     */
    @Singleton public static final class Acti extends Multiplicis<Actus> {
        @Nullable private static Acti instantia = null;

        @NonNull public static Supplier<Acti> faciendum =
                () -> ObjectUtils.firstNonNull(instantia, instantia = new Acti());
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

    /**
     * Classis {@link Constructor.Adverbii} est vās classis {@link Constructor} classī {@link Adverbium}.
     */
    @Singleton public static final class Adverbii extends Multiplicis<Adverbium> {
        @Nullable private static Adverbii instantia = null;

        @NonNull public static Supplier<Adverbii> faciendum =
                () -> ObjectUtils.firstNonNull(instantia, instantia = new Adverbii());

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

    @Singleton static abstract class Declinabilis<Hoc extends Verbum.Multiplex.Declinabile<Hoc> & Curabile<Hoc>>
            extends Multiplicis<Hoc> {
        /**
         * Hic valor dēsignat utrum haec rēs repraesentat certum necne.
         * @see Specialitas
         */
        @NonNull protected Specialitas specialitas = Specialitas.NULLUM;

        /**
         * Hic valor generem reī huius dēsignat.
         * @see Genus
         */
        @NonNull protected Genus genus = Genus.NULLUM;

        /**
         * Hic valor cāsum reī huius dēsignat.
         * @see Casus
         */
        @NonNull protected Casus casus = Casus.DERECTUS;

        /**
         * Hic valor numerum reī huius dēsignat.
         * @see Numeralis
         */
        @NonNull protected Numeralis numeralis = Numeralis.NULLUS;

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
    }

    /**
     * Classis {@link Constructor.Adiectivi} est vās classis {@link Constructor} classī {@link Adiectivum}.
     */
    @Singleton public static final class Adiectivi extends Declinabilis<Adiectivum> {
        @Nullable private static Adiectivi instantia = null;

        @NonNull public static Supplier<Adiectivi> faciendum =
                () -> ObjectUtils.firstNonNull(instantia, instantia = new Adiectivi());

        @NonNull private Gradus gradus = Gradus.NULLUS;

        /**
         * Hic modus valōrem {@link #gradus} induit.
         * @param gradus  Valor induendus
         * */
        public void gradus(@NonNull final Gradus gradus) {
            this.gradus = gradus;
        }

        /**
         * Hic modus cōnstrūctiōnem huius reī agit.
         * @return  Rem classis {@link Adiectivum} cum valōribus imputātīs.
         * @implNote  Hic modus {@code null} refert sī {@link #paratus()} valōrem {@code false} refert.
         * */
        @Nullable @Override
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

    /**
     * Classis {@link Constructor.Nominis} est vās classis {@link Constructor} classī {@link Nomen}.
     */
    @Singleton public static final class Nominis extends Declinabilis<Nomen> {
        @Nullable private static Nominis instantia = null;

        @NonNull public static Supplier<Nominis> faciendum =
                () -> ObjectUtils.firstNonNull(instantia, instantia = new Nominis());

        @NonNull private Tempus tempus = Tempus.INTEMPORALE;

        /**
         * Hic modus valōrem {@link #tempus} induit.
         * @param tempus  Valor induendus
         * */
        public void tempus(@NonNull final Tempus tempus) {
            this.tempus = tempus;
        }

        /**
         * Hic modus cōnstrūctiōnem huius reī agit.
         * @return  Rem classis {@link Nomen} cum valōribus imputātīs.
         * @implNote  Hic modus {@code null} refert sī {@link #paratus()} valōrem {@code false} refert.
         * */
        @Nullable @Override
        public Nomen build() {
            return paratus() ? Nomen.builder().lemma(lemma).specialitas(specialitas).genus(genus).casus(casus)
                                              .numeralis(numeralis).tempus(tempus).scriptio(scriptio).build()
                             : null;
        }

        /**
         * {@inheritDoc}
         * @see Specialitas#NULLUM
         * @see Genus#NULLUM
         * @see Casus#DERECTUS
         * @see Numeralis#NULLUS
         * @see Tempus#INTEMPORALE
         */
        @Override public void restituo() {
            specialitas = Specialitas.NULLUM;
            genus = Genus.NULLUM;
            casus = Casus.DERECTUS;
            numeralis = Numeralis.NULLUS;
            tempus = Tempus.INTEMPORALE;
            scriptio = StringUtils.EMPTY;
            lemma = StringUtils.EMPTY;
        }
    }

    /**
     * Classis {@link Constructor.Pronominis} est vās classis {@link Constructor} classī {@link Pronomen}.
     */
    @Singleton public static final class Pronominis extends Declinabilis<Pronomen> {
        @Nullable private static Pronominis instantia = null;

        @NonNull public static Supplier<Pronominis> faciendum =
                () -> ObjectUtils.firstNonNull(instantia, instantia = new Pronominis());

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
}
