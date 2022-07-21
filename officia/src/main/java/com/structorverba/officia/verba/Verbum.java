package com.structorverba.officia.verba;

import androidx.annotation.NonNull;
import com.structorverba.officia.enumerationes.*;
import com.structorverba.officia.miscella.*;
import com.structorverba.officia.quadriiugia.*;
import com.structorverba.officia.verba.interfacta.*;
import com.structorverba.officia.verba.multiplicia.*;
import com.structorverba.officia.verba.simplicia.*;

import java.util.stream.Stream;

/**
 * Classis {@link Verbum} repraesentat verba Latīna, fōrmās omnēs
 * datōrum quās ūsūfructuāriī petunt. <br>
 * Rem omnem huius classis rēs classis {@link Lector} colliget
 * rēs classis {@link Tenor} sēliget rēsque classis {@link Curator} tandem cōnstruet. <br>
 * Rēs classis {@link Lector} colliget data ā scāpō XML intrā
 * scrīnium <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>. <br>
 * Rēs classis {@link Inventor} ūtitur cōlāre rēs
 * multiplicēs huius classis quae classem {@link Multiplex} extendit.
 * @param <Hoc> Hāc tabellā classis {@link Hoc} extēnsiōnem
 *             aptam datīs petītīs repraesentat.
 * @see Multiplex
 * @see Simplex
 */
@SuppressWarnings("SpellCheckingInspection")
public abstract class Verbum <Hoc extends Verbum <Hoc>> extends Omne implements Comparable<Verbum<?>> {
  /**
   * Hic valor repraesentat fōrmam verbī cui rādīcēscit. <br>
   * Quoque nōminātur scāpum XML quō cōnservātum est.
   */
  @NonNull
  public final String lemma;

  /**
   * Hic valor extentum classem reī huic dēsignat.
   * {@link Categoria#scriptio} quoque nōminātur scrīnium
   * intrā quō scāpum eius cōnservātum est.
   * @see Categoria
   */
  @SuppressWarnings("unused")
  @NonNull public final Categoria catagoria;

  /**
   * Hoc officium cōnstrūctōrem reī huius classis perpetrat.
   * @param ctgr valōrem {@link #catagoria} indicat.
   * @param lm valōrem {@link #lemma} indicat.
   */
  protected Verbum(@NonNull final Categoria ctgr, @NonNull final String lm) {
    catagoria = ctgr;
    lemma = Utilitas.minisculae.apply(lm);
  }

  /**
  * Hic modus modum {@link Comparable#compareTo(Object)} implit.
  * @return {@code 0} sī hoc valorque {@code aliud} sē aequant; valor negātīvus sī hoc minor'st quam valor {@code aliud};
  *         valor positīvus sī hoc maior'st quam valor {@code aliud}.
  * @see  Comparable#compareTo(Object)
  * */
  @Override
  public int compareTo(Verbum<?> aliud) {
    return toString().compareTo(aliud.toString());
  }

  /**
   * @return Repraesentātiōnem scrīpta reī classis {@link Verbum}.
   * @see Object#toString()
   */
  @Override @NonNull
  public abstract String toString();

  /**
   * Classis {@link Simplex} repraesentat verbum aliquem quod fōrmam ūnam sōlum habet. <br>
   * Rēs classis {@link Inventor} rēbus huius classis absunt atque inūtilēs fuerint. <br>
   * @param <Hoc> Hāc tabellā classis {@link Hoc} extēnsiōnem aptam datīs petītīs repraesentat.
   * @see Coniunctio
   * @see Interiectio
   * @see Numerus
   * @see Praepositio
   */
  public static abstract class Simplex<Hoc extends Verbum <Hoc> & Immutans<Hoc>>
          extends Verbum <Hoc> implements Immutans<Hoc> {
    /**
     * Hoc officium cōnstrūctōrem reī huius classis perpetrat.
     * @param ctgr valōrem {@link #catagoria} indicat.
     * @param lm valōrem {@link #lemma} indicat.
     */
    protected Simplex(@NonNull final Categoria ctgr, @NonNull final String lm) {
      super(ctgr, lm);
    }

    /**
     * @return Repraesentātiōnem scrīpta reī classis {@link Simplex}. <br>
     * Sōlum valōrem {@link Verbum#lemma} potest referre cum fōrmā ūnā.
     */
    @Override @NonNull
    public String toString() {
      return lemma;
    }
  }

  /**
   * Classis {@link Multiplex} repraesentat verbum aliquem quod fōrmās multās habet. <br>
   * Rēs classis {@link Inventor} rēbus huius classis adsunt ūtilissimaeque sunt rēs huius classis percōlere. <br>
   * Discrīmina prīmōria inter hīs classibus classeque {@link Simplex}
   * sunt huius valōrēs {@link #scriptio}que {@link #encliticum}que.
   * @param <Hoc> Hāc tabellā classis {@link Hoc} extēnsiōnem aptam datīs petītīs repraesentat.
   * @see Lector.Multiplicibus
   * @see Tenor.Multiplicibus
   * @see Curator.Multiplicibus
   * @see Declinabile
   * @see Actus
   * @see Adverbium
   */
  @SuppressWarnings("SpellCheckingInspection")
  public static abstract class Multiplex<Hoc extends Verbum<Hoc> & Inflectabile<Hoc>>
          extends Verbum <Hoc> implements Inflectabile<Hoc> {
    /**
     * Hic valor fōrmam fīnem verbī repraesentat. <br>
     * Condiciōnibus plūrimīs est ut ūsūfructuāriī petīvit.
     */
    public final @NonNull String scriptio;

    /**
     * Hic valor <a href="https://en.wiktionary.org/wiki/Category:Latin_clitics">encliticum</a> subiūnctum dēsignat.
     * @see Encliticum
     */
    protected @NonNull Encliticum encliticum;

    /**
     * Hoc officium cōnstrūctōrem reī huius classis perpetrat.
     * @param categoria  valōrem {@link Verbum#catagoria} indicat.
     * @param lemma  valōrem {@link Verbum#lemma} indicat.
     * @param scrpt valōrem {@link #scriptio} indicat.
     */
    protected Multiplex(@NonNull final Categoria categoria, @NonNull final String lemma,
                        @NonNull final String scrpt) {
      super(categoria, lemma);
      scriptio = Utilitas.minisculae.apply(scrpt);
      encliticum = Encliticum.NOLENS;
    }

    /**
     * {@inheritDoc}
     * @see Encliticum
     */
    @SuppressWarnings("UnusedReturnValue")
    @NonNull public Hoc allegam(@NonNull final Encliticum cltm) {
      encliticum = Stream.of(Encliticum.values())
              .anyMatch(e -> lemma.endsWith(e.scriptio)) ? Encliticum.NOLENS
              : cltm;
      //noinspection unchecked
      return (Hoc) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unused")
    @NonNull public Encliticum encliticum() {
      return encliticum;
    }

    /**
     * @return Repraesentātiōnem scrīpta huius. <br>
     * Valōrem {@link #encliticum} valōrī {@link #scriptio} addit.
     */
    @Override @NonNull
    public String toString() {
      return Encliticum.NOLENS.equals(encliticum) ? scriptio
              : String.format("%s%s", scriptio, encliticum.scriptio);
    }

    /**
     * Classis {@link Declinabile} verbum aliquem dēclīnātum repraesentat.
     * @param <Hoc> Hāc tabellā classis {@link Hoc} extēnsiōnem aptam datīs petītīs repraesentat.
     * @see Adiectivum
     * @see Nomen
     * @see Pronomen
     */
    public static abstract class Declinabile<Hoc extends Verbum.Multiplex<Hoc>> extends Verbum.Multiplex<Hoc> {
      /**
       * Hic valor dēsignat utrum haec rēs repraesentat certum necne.
       * @see Specialitas
       */
      @NonNull public final Specialitas specialitas;

      /**
       * Hic valor generem reī huius dēsignat.
       * @see Genus
       */
      @NonNull public final Genus genus;

      /**
       * Hic valor cāsum reī huius dēsignat.
       * @see Casus
       */
      @NonNull public final Casus casus;

      /**
       * Hic valor numerum reī huius dēsignat.
       * @see Numeralis
       */
      @NonNull public final Numeralis numeralis;

      /**
       * Hoc officium cōnstrūctōrem reī huius classis perpetrat.
       * @param categoria  valōrem {@link Verbum#catagoria} indicat.
       * @param spclt valōrem {@link Declinabile#specialitas} indicat.
       * @param gns   valōrem {@link Declinabile#genus} indicat.
       * @param css   valōrem {@link Declinabile#casus} indicat.
       * @param nmrl  valōrem {@link Declinabile#numeralis} indicat.
       * @param lemma  valōrem {@link Verbum#lemma} indicat.
       * @param scriptio valōrem {@link #scriptio} indicat.
       */
      protected Declinabile(@NonNull final Categoria categoria, @NonNull final Specialitas spclt,
                            @NonNull final Genus gns, @NonNull final Casus css, @NonNull final Numeralis nmrl,
                            @NonNull final String lemma, @NonNull final String scriptio) {
        super(categoria, lemma, Specialitas.PROPRIUM.equals(spclt) ? Utilitas.primaCapitanea.apply(scriptio)
                                                                   : scriptio);
        specialitas = spclt;
        genus = gns;
        casus = css;
        numeralis = nmrl;
      }
    }
  }
}
