package com.structorverba.officia.enumerationes;

import androidx.annotation.NonNull;
import com.structorverba.officia.verba.*;
import com.structorverba.officia.verba.multiplicia.*;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

/**
 * Haec ēnumerātiō extēnsiōnem classī {@link Verbum} dēsignat cui verbum omne respondet.
 * @see Verbum
 */
@SuppressWarnings("SpellCheckingInspection")
public enum Categoria {
  /**
   * Hic valor classem {@link Nomen} respondet.
   */
  NOMEN,

  /**
   * Hic valor classem {@link Adiectivum} respondet.
   */
  ADIECTIVUM,

  /**
   * Hic valor classem {@link Pronomen} respondet.
   */
  PRONOMEN,

  /**
   * Hic valor classem {@link Actus} respondet.
   */
  ACTUS,

  /**
   * Hic valor classem {@link Adverbium} respondet.
   */
  ADVERBIUM,

  /**
   * Hic valor classem {@link Simplex.Coniunctio} respondet.
   */
  CONIUNCTIO,

  /**
   * Hic valor classem {@link Simplex.Interiectio} respondet.
   */
  INTERIECTIO,

  /**
   * Hic valor classem {@link Simplex.Praepositio} respondet.
   */
  PRAEPOSITIO,

  /**
   * Hic valor classem {@link Numerus} respondet.
   */
  NUMERUS;

  /**
   * Hic valor nōminātur scrīnium intrā quō scāpum verbī omnī cōnservātum est.
   */
  public final @NotNull String scriptio = declina(Casus.NOMINATIVUS, Numeralis.PLURALIS, false);

  /**
   * Hic modus dēterminat utrum rēs classis {@link Verbum} catēgoriae {@code categoria} classem {@link Multiplex} extendant necne.
   * @param categoria  Rēs dēterminanda
   * @return {@code true} sī  rēs catēgoriae {@code categoria} classem {@link Multiplex} extendunt; {@code false} aliter
   * */
  public static boolean multiplex(@NonNull final Categoria categoria) {
    return !Arrays.asList(CONIUNCTIO, INTERIECTIO, PRAEPOSITIO, NUMERUS).contains(categoria);
  }

  /**
   * Hic modus dēterminat utrum rēs quaeque classis {@link Verbum} catēgoriae {@code categoria} in scāpō singulō contineātur necne.
   * @param categoria  Rēs dēterminanda
   * @return {@code true} sī  rēs catēgoriae {@code categoria} in scāpō singulō continētur; {@code false} aliter
   * */
  public static boolean singulaScapis(@NonNull final Categoria categoria) {
    return !Arrays.asList(PRAEPOSITIO, NUMERUS).contains(categoria);
  }

  /**
   * Hic modus dēclīnat dē valōribus imputātīs verbum ly {@link Categoria}.
   * @param casus  Valor classis {@link Casus} dēclīnātiōnī
   * @param numeralis  Valor classis {@link Numeralis} dēclīnātiōnī
   * @param primaCapitanea indīcat utrum littera prīma capitānea sit necne
   * */
  @NonNull public String declina(@NonNull final Casus casus, @NonNull final Numeralis numeralis,
                                 final boolean primaCapitanea) {
    return switch (this) {
      case ACTUS -> switch (casus) {
        case NOMINATIVUS, VOCATIVUS, DERECTUS -> switch (numeralis) {
          case SINGULARIS, NULLUS -> primaCapitanea ? "Āctus" : "āctus";
          case PLURALIS -> primaCapitanea ? "Āctūs" : "āctūs";
        };
        case GENITIVUS -> switch (numeralis) {
          case SINGULARIS, NULLUS -> primaCapitanea ? "Āctūs" : "āctūs";
          case PLURALIS -> primaCapitanea ? "Āctuum" : "āctuum";
        };
        case DATIVUS -> switch (numeralis) {
          case SINGULARIS, NULLUS -> primaCapitanea ? "Āctuī" : "āctuī";
          case PLURALIS -> primaCapitanea ? "Āctibus" : "āctibus";
        };
        case ACCUSATIVUS -> switch (numeralis) {
          case SINGULARIS, NULLUS -> primaCapitanea ? "Āctum" : "āctum";
          case PLURALIS -> primaCapitanea ? "Āctūs" : "āctūs";
        };
        case ABLATIVUS, INSTRUMENTALIS, LOCATIVUS -> switch (numeralis) {
          case SINGULARIS, NULLUS -> primaCapitanea ? "Āctū" : "āctū";
          case PLURALIS -> primaCapitanea ? "Āctibus" : "āctibus";
        };
      };
      case ADIECTIVUM -> switch (casus) {
          case NOMINATIVUS, ACCUSATIVUS, VOCATIVUS, DERECTUS -> switch (numeralis) {
            case SINGULARIS, NULLUS -> primaCapitanea ? "Adiectīvum" : "adiectīvum";
            case PLURALIS -> primaCapitanea ? "Adiectīva" : "adiectīva";
          };
          case GENITIVUS -> switch (numeralis) {
            case SINGULARIS, NULLUS -> primaCapitanea ? "Adiectīvī" : "adiectīvī";
            case PLURALIS -> primaCapitanea? "Adiectīvōrum" : "adiectīvōrum";
          };
          case DATIVUS, ABLATIVUS, INSTRUMENTALIS, LOCATIVUS -> switch (numeralis) {
            case SINGULARIS, NULLUS -> primaCapitanea ? "Adiectīvō" : "adiectīvō";
            case PLURALIS -> primaCapitanea ? "Adiectīvīs" : "adiectīvīs";
          };
        };
      case ADVERBIUM -> switch (casus) {
        case NOMINATIVUS, ACCUSATIVUS, VOCATIVUS, DERECTUS -> switch (numeralis) {
          case SINGULARIS, NULLUS -> primaCapitanea ? "Adverbium" : "adverbium";
          case PLURALIS -> primaCapitanea ? "Adverbia" : "adverbia";
        };
        case GENITIVUS -> switch (numeralis) {
          case SINGULARIS, NULLUS -> primaCapitanea ? "Adverbiī" : "adverbiī";
          case PLURALIS -> primaCapitanea? "Adverbiōrum" : "adverbiōrum";
        };
        case DATIVUS, ABLATIVUS, INSTRUMENTALIS, LOCATIVUS -> switch (numeralis) {
          case SINGULARIS, NULLUS -> primaCapitanea ? "Adverbiō" : "adverbiō";
          case PLURALIS -> primaCapitanea ? "Adverbiīs" : "adverbiīs";
        };
      };
      case CONIUNCTIO -> switch (casus) {
        case NOMINATIVUS, VOCATIVUS, DERECTUS -> switch (numeralis) {
          case SINGULARIS, NULLUS -> primaCapitanea ? "Coniūnctiō" : "coniūnctiō";
          case PLURALIS -> primaCapitanea ? "Coniūnctiōnēs" : "coniūnctiōnēs";
        };
        case GENITIVUS -> switch (numeralis) {
          case SINGULARIS, NULLUS -> primaCapitanea ? "Coniūnctiōnis" : "coniūnctiōnis";
          case PLURALIS -> primaCapitanea? "Coniūnctiōnum" : "coniūnctiōnum";
        };
        case ACCUSATIVUS -> switch (numeralis) {
          case SINGULARIS, NULLUS -> primaCapitanea ? "Coniūnctiōnem" : "coniūnctiōnem";
          case PLURALIS -> primaCapitanea ? "Coniūnctiōnēs" : "coniūnctiōnēs";
        };
        case DATIVUS -> switch (numeralis) {
          case SINGULARIS, NULLUS -> primaCapitanea ? "Coniūnctiōnī" : "coniūnctiōnī";
          case PLURALIS -> primaCapitanea ? "Coniūnctiōnibus" : "coniūnctiōnibus";
        };
        case ABLATIVUS, INSTRUMENTALIS, LOCATIVUS -> switch (numeralis) {
          case SINGULARIS, NULLUS -> primaCapitanea ? "Coniūnctiōne" : "coniūnctiōne";
          case PLURALIS -> primaCapitanea ? "Coniūnctiōnibus" : "coniūnctiōnibus";
        };
      };
      case INTERIECTIO -> switch (casus) {
        case NOMINATIVUS, VOCATIVUS, DERECTUS -> switch (numeralis) {
          case SINGULARIS, NULLUS -> primaCapitanea ? "Interiectiō" : "interiectiō";
          case PLURALIS -> primaCapitanea ? "Interiectiōnēs" : "interiectiōnēs";
        };
        case GENITIVUS -> switch (numeralis) {
          case SINGULARIS, NULLUS -> primaCapitanea ? "Interiectiōnis" : "interiectiōnis";
          case PLURALIS -> primaCapitanea? "Interiectiōnum" : "interiectiōnum";
        };
        case ACCUSATIVUS -> switch (numeralis) {
          case SINGULARIS, NULLUS -> primaCapitanea ? "Interiectiōnem" : "interiectiōnem";
          case PLURALIS -> primaCapitanea ? "Interiectiōnēs" : "interiectiōnēs";
        };
        case DATIVUS -> switch (numeralis) {
          case SINGULARIS, NULLUS -> primaCapitanea ? "Interiectiōnī" : "interiectiōnī";
          case PLURALIS -> primaCapitanea ? "Interiectiōnibus" : "interiectiōnibus";
        };
        case ABLATIVUS, INSTRUMENTALIS, LOCATIVUS -> switch (numeralis) {
          case SINGULARIS, NULLUS -> primaCapitanea ? "Interiectiōne" : "interiectiōne";
          case PLURALIS -> primaCapitanea ? "Interiectiōnibus" : "interiectiōnibus";
        };
      };
      case NOMEN -> switch (casus) {
        case NOMINATIVUS, ACCUSATIVUS, VOCATIVUS, DERECTUS -> switch (numeralis) {
          case SINGULARIS, NULLUS -> primaCapitanea ? "Nōmen" : "nōmen";
          case PLURALIS -> primaCapitanea ? "Nōmina" : "nōmina";
        };
        case GENITIVUS -> switch (numeralis) {
          case SINGULARIS, NULLUS -> primaCapitanea ? "Nōminis" : "nōminis";
          case PLURALIS -> primaCapitanea? "Nōminum" : "nōminum";
        };
        case DATIVUS -> switch (numeralis) {
          case SINGULARIS, NULLUS -> primaCapitanea ? "Nōminī" : "nōminī";
          case PLURALIS -> primaCapitanea ? "Nōminibus" : "nōminibus";
        };
        case ABLATIVUS, INSTRUMENTALIS, LOCATIVUS -> switch (numeralis) {
          case SINGULARIS, NULLUS -> primaCapitanea ? "Nōmine" : "nōmine";
          case PLURALIS -> primaCapitanea ? "Nōminibus" : "nōminibus";
        };
      };
      case NUMERUS -> switch (casus) {
        case NOMINATIVUS, VOCATIVUS, DERECTUS -> switch (numeralis) {
          case SINGULARIS, NULLUS -> primaCapitanea ? "Numerus" : "numerus";
          case PLURALIS -> primaCapitanea ? "Numerī" : "numerī";
        };
        case GENITIVUS -> switch (numeralis) {
          case SINGULARIS, NULLUS -> primaCapitanea ? "Numerī" : "numerī";
          case PLURALIS -> primaCapitanea ? "Numerōrum" : "numerōrum";
        };
        case ACCUSATIVUS -> switch (numeralis) {
          case SINGULARIS, NULLUS -> primaCapitanea ? "Numerum" : "numerum";
          case PLURALIS -> primaCapitanea ? "Numerōs" : "numerōs";
        };
        case DATIVUS, ABLATIVUS, INSTRUMENTALIS, LOCATIVUS -> switch (numeralis) {
          case SINGULARIS, NULLUS -> primaCapitanea ? "Numerō" : "numerō";
          case PLURALIS -> primaCapitanea ? "Numerīs" : "numerīs";
        };
      };
      case PRAEPOSITIO -> switch (casus) {
        case NOMINATIVUS, VOCATIVUS, DERECTUS -> switch (numeralis) {
          case SINGULARIS, NULLUS -> primaCapitanea ? "Praepositiō" : "praepositiō";
          case PLURALIS -> primaCapitanea ? "Praepositiōnēs" : "praepositiōnēs";
        };
        case GENITIVUS -> switch (numeralis) {
          case SINGULARIS, NULLUS -> primaCapitanea ? "Praepositiōnis" : "praepositiōnis";
          case PLURALIS -> primaCapitanea? "Praepositiōnum" : "praepositiōnum";
        };
        case ACCUSATIVUS -> switch (numeralis) {
          case SINGULARIS, NULLUS -> primaCapitanea ? "Praepositiōnem" : "praepositiōnem";
          case PLURALIS -> primaCapitanea ? "Praepositiōnēs" : "praepositiōnēs";
        };
        case DATIVUS -> switch (numeralis) {
          case SINGULARIS, NULLUS -> primaCapitanea ? "Praepositiōnī" : "praepositiōnī";
          case PLURALIS -> primaCapitanea ? "Praepositiōnibus" : "praepositiōnibus";
        };
        case ABLATIVUS, INSTRUMENTALIS, LOCATIVUS -> switch (numeralis) {
          case SINGULARIS, NULLUS -> primaCapitanea ? "Praepositiōne" : "praepositiōne";
          case PLURALIS -> primaCapitanea ? "Praepositiōnibus" : "praepositiōnibus";
        };
      };
      case PRONOMEN -> switch (casus) {
        case NOMINATIVUS, ACCUSATIVUS, VOCATIVUS, DERECTUS -> switch (numeralis) {
          case SINGULARIS, NULLUS -> primaCapitanea ? "Prōnōmen" : "prōnōmen";
          case PLURALIS -> primaCapitanea ? "Prōnōmina" : "prōnōmina";
        };
        case GENITIVUS -> switch (numeralis) {
          case SINGULARIS, NULLUS -> primaCapitanea ? "Prōnōminis" : "prōnōminis";
          case PLURALIS -> primaCapitanea? "Prōnōminum" : "prōnōminum";
        };
        case DATIVUS -> switch (numeralis) {
          case SINGULARIS, NULLUS -> primaCapitanea ? "Prōnōminī" : "prōnōminī";
          case PLURALIS -> primaCapitanea ? "Prōnōminibus" : "prōnōminibus";
        };
        case ABLATIVUS, INSTRUMENTALIS, LOCATIVUS -> switch (numeralis) {
          case SINGULARIS, NULLUS -> primaCapitanea ? "Prōnōmine" : "prōnōmine";
          case PLURALIS -> primaCapitanea ? "Prōnōminibus" : "prōnōminibus";
        };
      };
    };
  }
}
