package net.structorverba.bibliotheca.tenores;

import net.structorverba.bibliotheca.conditores.Conditōr;
import net.structorverba.bibliotheca.lectores.*;
import net.structorverba.bibliotheca.miscella.Omnum;
import net.structorverba.bibliotheca.nuntiī.Nūntius;
import net.structorverba.bibliotheca.verba.Verbum;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.*;
import org.xml.sax.helpers.DefaultHandler;

import java.util.*;
import java.util.function.*;

/**
 * Classis {@link Tenor} data lēcta ā rēbus classis {@link Lēctor} sēliget reīque aptae classis {@link Conditōr}
 * praebet.
 * @param <Hoc> classis extenta classis {@link Verbum}
 * @see Omnum
 * @see <a href="https://docs.oracle.com/javase/7/docs/api/org/xml/sax/helpers/DefaultHandler.html">DefaultHandler</a>
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection" })
public abstract class Tenor <Hoc extends Verbum <Hoc>> extends DefaultHandler {
  /**
   * Valor hic est vās classis {@link Nūntius} classī extentī huius.
   */
  @NotNull protected final Nūntius nūntius;
  /**
   * Valor hic seriem rērum classis {@link Hoc} praebendārum ad rē classis {@link LēctorMultiplicibus} tenet.
   */
  protected final @NotNull List <@NotNull Hoc> seriēs = new ArrayList <>();
  /**
   * Valor hic rem classis {@link Hoc} tenet cōnstruenumque ā reī aptae classis {@link Conditōr} praebendumque ad rē
   * classis {@link Lēctor}.
   */
  @Nullable protected Hoc hoc;

  /**
   * Officium hoc cōnstrūctōrem reī classis huius perpetrat.
   * @param nts valōrem {@link #nūntius} supplet.
   */
  protected Tenor(@NotNull final Supplier <@NotNull ? extends Nūntius> nts) {
    Thread.currentThread().setUncaughtExceptionHandler(Nūntius.NūntiusErrōribus.fac.get());
    nūntius = nts.get();
  }

  /**
   * @return Valōrem {@link #hoc}
   */
  @Nullable public Hoc referō( ) {
    return hoc;
  }

  /**
   * Modus hic valōrem {@link #seriēs} per valōrem {@code quaestiō} cōlat ut rem singulam prōdūcat.
   * @param quaestiō quaestiō tentanda
   * @return valōrem {@link #seriēs} valōrem {@code quaestiō} percōlāta
   */
  public final @Nullable Hoc referō(Predicate <@NotNull Hoc> quaestiō) {
    return seriēs.stream().filter(quaestiō)
                 .findFirst().orElse(null);
  }

  /**
   * Modus hic fōrmam scrīptam prōvīsam ā rē classis <a href="https://docs.oracle.com/en/java/javase/11/docs/api/java.xml/org/xml/sax/XMLReader.html">XMLReader</a>
   * prōcēdit.
   * @param litterae litterae prōvīsae
   * @param incepta  positiō incepta in valōrem {@code litterae}
   * @param longitia longitia valōris {@code litterae} ūtendī
   * @see <a href="https://docs.oracle.com/javase/7/docs/api/org/xml/sax/helpers/DefaultHandler.html#characters(char[],%20int,%20int)">DefaultHandler.characters</a>
   */
  @Override public final void characters(final char[] litterae, final int incepta, final int longitia) {
    String fōrma = new String(litterae, incepta, longitia).trim();
    if (StringUtils.isNotBlank(fōrma)) {
      nūntius.garriō("Verbum illud est", fōrma);
      scrībō(fōrma);
      fīniam();
    } else {
      nūntius.moneō("Prōductiō verbī prōcessimus nūllae fōrmae.");
    }
  }

  /**
   * Modus hic rem aptam classis {@link Conditōr} imperat ut fōrmam scrīptam reī prōductae classis {@link Hoc} indat.
   * @param scrīptiō fōrmam scrīptam indendus
   * @see #characters(char[], int, int)
   */
  protected abstract void scrībō(@NotNull final String scrīptiō);

  /**
   * Modus hic rem aptam classis {@link Conditōr} imperat cōnstrūctiōnem reī prōductae classis {@link Hoc} fīnīre.
   */
  protected abstract void fīniam( );
}
