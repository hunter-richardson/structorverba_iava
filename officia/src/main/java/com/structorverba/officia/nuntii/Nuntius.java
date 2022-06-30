package com.structorverba.officia.nuntii;

import androidx.annotation.*;
import com.structorverba.officia.miscella.Omne;
import org.apache.commons.lang3.*;

import java.util.Objects;
import java.util.logging.Logger;
import java.util.stream.Stream;


/**
 * Classis {@link Nuntius} n\u016Bntia d\u0113 exsec\u016Bti\u014Dne programm\u0101tis Str\u016BctorVerba in sc\u0101p\u012Bs LOG scr\u012Bbit. <br>
 * Class\u0113s pl\u016Brimae aliae in programm\u0101tem Str\u016BctorVerba rem classis huius habet.
 * @see Omne
 */
@SuppressWarnings("SpellCheckingInspection")
public abstract class Nuntius {
  @NonNull private final GradusNuntii gradusMinimus;
  @NonNull private final Logger       praeco;

  /**
   * Officium hoc c\u014Dnstr\u016Bct\u014Drem re\u012B classis huius perpetrat.
   * @param parametri Valor hic parametr\u014Ds \u016Bs\u014Ds pr\u014D gener\u0101ti\u014Dne organum internum re\u012B huius continet.
   */
  protected Nuntius(@NonNull final ParametriNuntii parametri) {
    gradusMinimus = parametri.gradusMinimus;
    praeco = parametri.praeconium.get();
  }

  private void nuntio(@NonNull final GradusNuntii gradus, @Nullable final Object... nuntia) {
    if (GradusNuntii.compareTo(gradus, gradusMinimus) >= 0) {
      if (nuntia != null) {
        final StringBuilder structor = new StringBuilder();
        Stream.of(nuntia)
              .filter(Objects::nonNull)
              .filter(pars -> StringUtils.isNotBlank(pars.toString()))
              .forEachOrdered(pars -> structor.append(pars).append(' '));
        praeco.log(gradus.gressus.get(), structor.toString());
      } else {
        praeco.log(gradus.gressus.get(), StringUtils.EMPTY);
      }
    }
  }

  /**
   * Modus hic persignat quod exsec\u016Bti\u014Dnem programm\u0101tis Str\u016BuctorVerba err\u014Drem continu\u0101tur.
   * @param error error continu\u0101tus
   * @see #terreo(Object...)
   */
  public final void terreo(@NonNull final Throwable error) {
    final StackTraceElement historia = error.getStackTrace()[ 0 ];
    praeco.throwing(historia.getClassName(), historia.getMethodName(), error);
    terreo("Modus", historia.getMethodName(), "classe",
           historia.getClassName(), "contin\u0101tu'st errorem:",
           error.getClass().getSimpleName(), error.getLocalizedMessage());
  }

  /**
   * Modus hic persignat quod exsec\u016Bti\u014Dnem programm\u0101tis Str\u016BctorVerba continu\u0101tur condici\u014Dnem quam err\u014Drem indicat.
   * @param nuntia seri\u0113s re\u012B persign\u0101re
   * @see GradusNuntii#GRAVIS
   */
  public final void terreo(@Nullable final Object... nuntia) {
    if (ArrayUtils.isEmpty(nuntia)) {
      Stream.of(nuntia)
            .filter(Objects::nonNull)
            .filter(pars -> pars instanceof Throwable)
            .forEach(pars -> terreo((Throwable) pars));
      nuntio(GradusNuntii.GRAVIS, Stream.of(nuntia)
                                        .filter(Objects::nonNull)
                                        .filter(pars -> !(pars instanceof Throwable))
                                        .filter(pars -> StringUtils.isNotBlank(pars.toString()))
                                        .toArray());
    } else {
      nuntio(GradusNuntii.GRAVIS);
    }
  }

  /**
   * Modus hic persignat quod exsec\u016Bti\u014Dnem programm\u0101tis Str\u016BctorVerba continu\u0101tur condici\u014Dnem quam auct\u014Dribus
   * programm\u0101tis intersit.
   * @param nuntia seri\u0113s re\u012B persign\u0101re
   * @see GradusNuntii#PRAEGRESSURUS
   */
  public final void noto(@Nullable final Object... nuntia) {
    nuntio(GradusNuntii.PRAEGRESSURUS, nuntia);
  }

  /**
   * Modus hic persignat quod exsec\u016Bti\u014Dnem programm\u0101tis Str\u016BctorVerba continu\u0101tur condici\u014Dnem quam err\u014Drem add\u016Bcat.
   * @param nuntia seri\u0113s re\u012B persign\u0101re
   * @see GradusNuntii#PRAEMONITORIUS
   */
  public final void moneo(@Nullable final Object... nuntia) {
    nuntio(GradusNuntii.PRAEMONITORIUS, nuntia);
  }

  /**
   * Modus hic persignat quod exsec\u016Bti\u014Dnem programm\u0101tis Str\u016BctorVerba continu\u0101tur condici\u014Dnem quam \u016Bs\u016Bfructu\u0101ri\u012Bs
   * programm\u0101tis intersit.
   * @param nuntia seri\u0113s re\u012B persign\u0101re
   * @see GradusNuntii#INFORMATIVUS
   */
  public final void certioro(@Nullable final Object... nuntia) {
    nuntio(GradusNuntii.INFORMATIVUS, nuntia);
  }

  /**
   * Modus hic persignat quod exsec\u016Bti\u014Dnem programm\u0101tis Str\u016BctorVerba continu\u0101tur condici\u014Dnem quam n\u0113min\u012B fortasse
   * intersit.
   * @param nuntia seri\u0113s re\u012B persign\u0101re
   * @see GradusNuntii#SCRUTANS
   */
  public final void garrio(@Nullable final Object... nuntia) {
    nuntio(GradusNuntii.SCRUTANS, nuntia);
  }

  /**
   * Modus hic persignat quod exsec\u016Bti\u014Dnem programm\u0101tis Str\u016BctorVerba continu\u0101tur condici\u014Dnem quam n\u0113min\u012B prob\u0101biliter
   * intersit.
   * @param nuntia seri\u0113s re\u012B persign\u0101re
   * @see GradusNuntii#SCRUTANTIOR
   */
  public final void plusGarrio(@Nullable final Object... nuntia) {
    nuntio(GradusNuntii.SCRUTANTIOR, nuntia);
  }

  /**
   * Modus hic persignat quod exsec\u016Bti\u014Dnem programm\u0101tis Str\u016BctorVerba continu\u0101tur condici\u014Dnem quam n\u0113min\u012B certissime
   * intersit.
   * @param nuntia seri\u0113s re\u012B persign\u0101re
   * @see GradusNuntii#SCRUTANTISSIMUS
   */
  public final void plurimumGarrio(@Nullable final Object... nuntia) {
    nuntio(GradusNuntii.SCRUTANTISSIMUS, nuntia);
  }
}
