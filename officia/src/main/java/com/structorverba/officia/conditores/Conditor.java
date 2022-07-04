package com.structorverba.officia.conditores;

import com.structorverba.officia.enumerationes.*;
import com.structorverba.officia.miscella.Omne;
import com.structorverba.officia.nuntii.Nuntius;
import com.structorverba.officia.tenores.Tenor;
import com.structorverba.officia.verba.*;

import androidx.annotation.*;

import java.util.function.Supplier;

/**
 * Classis {@link Conditor} data ā rēbus classis {@link Tenor} accipit eacumque rēs classis extentārum {@link Verbum}
 * cōnstruet.
 * @param <Hoc> classis extenta classis {@link Verbum}
 */
@SuppressWarnings("SpellCheckingInspection")
public abstract class Conditor <Hoc extends Verbum <Hoc>> extends Omne {
  @NonNull protected final Categoria categoria;
  /**
   * Hic valor est vās classis {@link Nuntius} classī hui.
   */
  @NonNull protected final Nuntius nuntius;

  /**
   * Hoc officium cōnstrūctōrem reī huius classis perpetrat.
   * @param nts valōrem {@link #nuntius} supplet.
   */
  protected Conditor(@NonNull final Categoria ctgr, @NonNull final Supplier <? extends Nuntius> nts) {
    categoria = ctgr;
    nuntius = nts.get();
  }

  /**
   * Hic modus rem classis {@link Hoc} cōnābitur cōnstruere.
   * @return Rem novam classis {@link Hoc}. <br> Modus hid valōrem {@code null} refert sī nōn valet valor aliquis haec rēs continet.
   */
  @Nullable public abstract Hoc condam();

  /**
   * Hic modus rem classis {@link VerbumSimplex.Coniunctio} accipit valōrīque {@link ConditorSimplicibus.ConditorConiunctionibus#nuntius}
   * ita refert.
   * @param hoc rem tentanda
   */
  protected void refero(@Nullable final Hoc hoc) {
    if (hoc == null) {
      nuntius.certioro(categoria.declina(Casus.NOMINATIVUS, Numeralis.SINGULARIS, true),
                       "fīnītur prōdūcere.");
    } else {
      nuntius.moneo(categoria.declina(Casus.DATIVUS, Numeralis.SINGULARIS, true),
                    "prōductiō formae nūllae prōcessit.");
    }
  }
}
