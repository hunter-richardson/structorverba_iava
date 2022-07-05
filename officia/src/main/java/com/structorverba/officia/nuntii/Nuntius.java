package com.structorverba.officia.nuntii;

import androidx.annotation.*;
import com.structorverba.officia.miscella.Omne;
import org.apache.commons.lang3.*;

import java.util.Objects;
import java.util.logging.Logger;
import java.util.stream.Stream;


/**
 * Classis {@link Nuntius} nūntia dē exsecūtiōne programmātis StrūctorVerba in scāpīs LOG scrībit. <br>
 * Classēs plūrimae aliae in programmātem StrūctorVerba rem huius classis habet.
 * @see Omne
 */
@SuppressWarnings("SpellCheckingInspection")
public abstract class Nuntius {
  @NonNull private final GradusNuntii gradusMinimus;
  @NonNull private final Logger       praeco;

  /**
   * Hoc officium cōnstrūctōrem reī huius classis perpetrat.
   * @param parametri Hic valor parametrōs ūsōs prō generātiōne organum internum huius reī continet.
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
   * Hic modus persignat quod exsecūtiōnem programmātis StrūuctorVerba errōrem continuātur.
   * @param error error continuātus
   * @see #terreo(Object...)
   */
  public final void terreo(@NonNull final Throwable error) {
    final StackTraceElement historia = error.getStackTrace()[ 0 ];
    praeco.throwing(historia.getClassName(), historia.getMethodName(), error);
    terreo("Modus", historia.getMethodName(), "classe",
           historia.getClassName(), "continātu'st errorem:",
           error.getClass().getSimpleName(), error.getLocalizedMessage());
  }

  /**
   * Hic modus persignat quod exsecūtiōnem programmātis StrūctorVerba continuātur condiciōnem quam errōrem indicat.
   * @param nuntia seriēs reī persignāre
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
   * Hic modus persignat quod exsecūtiōnem programmātis StrūctorVerba continuātur condiciōnem quam auctōribus
   * programmātis intersit.
   * @param nuntia seriēs reī persignāre
   * @see GradusNuntii#PRAEGRESSURUS
   */
  public final void noto(@Nullable final Object... nuntia) {
    nuntio(GradusNuntii.PRAEGRESSURUS, nuntia);
  }

  /**
   * Hic modus persignat quod exsecūtiōnem programmātis StrūctorVerba continuātur condiciōnem quam errōrem addūcat.
   * @param nuntia seriēs reī persignāre
   * @see GradusNuntii#PRAEMONITORIUS
   */
  public final void moneo(@Nullable final Object... nuntia) {
    nuntio(GradusNuntii.PRAEMONITORIUS, nuntia);
  }

  /**
   * Hic modus persignat quod exsecūtiōnem programmātis StrūctorVerba continuātur condiciōnem quam ūsūfructuāriīs
   * programmātis intersit.
   * @param nuntia seriēs reī persignāre
   * @see GradusNuntii#INFORMATIVUS
   */
  public final void certioro(@Nullable final Object... nuntia) {
    nuntio(GradusNuntii.INFORMATIVUS, nuntia);
  }

  /**
   * Hic modus persignat quod exsecūtiōnem programmātis StrūctorVerba continuātur condiciōnem quam nēminī fortasse
   * intersit.
   * @param nuntia seriēs reī persignāre
   * @see GradusNuntii#SCRUTANS
   */
  public final void garrio(@Nullable final Object... nuntia) {
    nuntio(GradusNuntii.SCRUTANS, nuntia);
  }

  /**
   * Hic modus persignat quod exsecūtiōnem programmātis StrūctorVerba continuātur condiciōnem quam nēminī probābiliter
   * intersit.
   * @param nuntia seriēs reī persignāre
   * @see GradusNuntii#SAEPE_SCRUTANS
   */
  public final void plusGarrio(@Nullable final Object... nuntia) {
    nuntio(GradusNuntii.SAEPE_SCRUTANS, nuntia);
  }

  /**
   * Hic modus persignat quod exsecūtiōnem programmātis StrūctorVerba continuātur condiciōnem quam nēminī certissime
   * intersit.
   * @param nuntia seriēs reī persignāre
   * @see GradusNuntii#SEMPER_SCRUTANS
   */
  public final void plurimumGarrio(@Nullable final Object... nuntia) {
    nuntio(GradusNuntii.SEMPER_SCRUTANS, nuntia);
  }
}
