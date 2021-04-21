package net.strūctorverba.tenōrēs;

import net.strūctorverba.conditōrēs.Conditōr;
import net.strūctorverba.lēctōrēs.*;
import net.strūctorverba.nūntiī.Nūntius;
import net.strūctorverba.verba.Verbum;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.*;
import org.xml.sax.helpers.DefaultHandler;

import java.util.*;
import java.util.function.*;

/**
 * Classis {@link Tenor} data lēcta ā rēbus classis {@link Lēctor} sēliget et reī aptae classis {@link Conditōr} praebet.
 * @param <Hoc> classis extenta classis {@link Verbum}
 * @see <a href="https://docs.oracle.com/javase/7/docs/api/org/xml/sax/helpers/DefaultHandler.html">DefaultHandler</a>
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection" })
public abstract class Tenor <Hoc extends Verbum <Hoc>> extends DefaultHandler {
  /**
   * Valor hic est vās classis {@link Nūntius} classī extentī huius.
   */
  @NotNull protected final Nūntius nūntius;

  /**
   * Valor hic rem classis {@link Hoc} tenet et cōnstruenum ā reī aptae classis {@link Conditōr} et praebendum ad rē classis {@link LēctorSimplicibus}.
   */
  @Nullable protected Hoc hoc;

  /**
   * Valor hic seriem rērum classis {@link Hoc} tenet praebendum ad rē classis {@link LēctorMultiplicibus}.
   */
  protected final @NotNull List <@NotNull Hoc> seriēs = new ArrayList <>();

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
   * Modus hic valōrem {@link #seriēs} per valōrem {@code quaestiō} cōlat rem singulam prōdūcere.
   * @param quaestiō quaestiō tentanda
   * @return valōrem {@link #seriēs} valōrem {@code quaestiō} percōlāta
   */
  public final @Nullable Hoc referō(Predicate <@NotNull Hoc> quaestiō) {
    return seriēs.stream().filter(quaestiō)
                 .findFirst().orElse(null);
  }

  /**
   * Modus hic fōrmam scrīptam prōcēdit prōvīsam ā rē classis <a href="https://docs.oracle.com/en/java/javase/11/docs/api/java.xml/org/xml/sax/XMLReader.html">XMLReader</a>
   * @param litterae litterae prōvīsae
   * @param incepta positiō incepta in valōrem {@code litterae}
   * @param longitia longitia valōris {@code litterae} ūtendī
   * @see <a href="https://docs.oracle.com/javase/7/docs/api/org/xml/sax/helpers/DefaultHandler.html#characters(char[],%20int,%20int)">DefaultHandler.characters</a>
   */
  @Override public final void characters(final char[] litterae, final int incepta, final int longitia) {
    String fōrma = new String(litterae, incepta, longitia).trim();
    if(StringUtils.isNotBlank(fōrma)) {
      nūntius.garriō("Verbum illud est", fōrma);
      scrībō(fōrma);
      fīniam();
    } else {
      nūntius.moneō("Prōductiō verbī prōcessimus nūllae fōrmae.");
    }
  }

  /**
   * Modus hic rem aptam classis {@link Conditōr} imperat fōrmam scrīptam reī prōductae classis {@link Hoc} indere.
   * @param scrīptiō fōrmam scrīptam indendus
   * @see #characters(char[], int, int)
   */
  protected abstract void scrībō(@NotNull final String scrīptiō);

  /**
   * Modus hic rem aptam classis {@link Conditōr} imperat cōnstrūctiōnem reī prōductae classis {@link Hoc} fīnīre.
   */
  protected abstract void fīniam( );
}
