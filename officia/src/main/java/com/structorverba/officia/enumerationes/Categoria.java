package com.structorverba.officia.enumerationes;

import androidx.annotation.NonNull;
import com.structorverba.officia.verba.*;
import com.structorverba.officia.verba.multiplicia.*;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

/**
 * Ēnumerātiō haec extēnsiōnem classī {@link Verbum} dēsignat cui verbum omne respondet.
 * @see Verbum
 */
@SuppressWarnings("SpellCheckingInspection")
public enum Categoria {
  /**
   * Valor hic classem {@link Nomen} respondet.
   */
  NOMEN,

  /**
   * Valor hic classem {@link Adiectivum} respondet.
   */
  ADIECTIVUM,

  /**
   * Valor hic classem {@link Pronomen} respondet.
   */
  PRONOMEN,

  /**
   * Valor hic classem {@link Actus} respondet.
   */
  ACTUS,

  /**
   * Valor hic classem {@link Adverbium} respondet.
   */
  ADVERBIUM,

  /**
   * Valor hic classem {@link VerbumSimplex.Coniunctio} respondet.
   */
  CONIUNCTIO,

  /**
   * Valor hic classem {@link VerbumSimplex.Interiectio} respondet.
   */
  INTERIECTIO,

  /**
   * Valor hic classem {@link VerbumSimplex.Praepositio} respondet.
   */
  PRAEPOSITIO,

  /**
   * Valor hic classem {@link VerbumSimplex.Numerus} respondet.
   */
  NUMERUS;

  /**
   * Valor hic nōminātur scrīnium intrā quō scāpum verbī omnī cōnservātum est.
   */
  public final @NotNull String scriptio = declina(Casus.NOMINATIVUS, Numeralis.PLURALIS, false);

  public static boolean multiplex(@NonNull final Categoria categoria) {
    return !Arrays.asList(CONIUNCTIO, INTERIECTIO, PRAEPOSITIO, NUMERUS).contains(categoria);
  }

  public static boolean singulaScapis(@NonNull final Categoria categoria) {
    return !Arrays.asList(PRAEPOSITIO, NUMERUS).contains(categoria);
  }

  @NonNull public String declina(@NonNull final Casus casus, @NonNull final Numeralis numeralis,
                                 final boolean primaCapitania) {
    return switch (this) {
      case ACTUS -> switch (casus) {
        case NOMINATIVUS, VOCATIVUS, DERECTUS -> switch (numeralis) {
          case SINGULARIS, NULLUS -> primaCapitania ? "Āctus" : "āctus";
          case PLURALIS -> primaCapitania ? "Āctūs" : "āctūs";
        };
        case GENITIVUS -> switch (numeralis) {
          case SINGULARIS, NULLUS -> primaCapitania ? "Āctūs" : "āctūs";
          case PLURALIS -> primaCapitania ? "Āctuum" : "āctuum";
        };
        case DATIVUS -> switch (numeralis) {
          case SINGULARIS, NULLUS -> primaCapitania ? "Āctuī" : "āctuī";
          case PLURALIS -> primaCapitania ? "Āctibus" : "āctibus";
        };
        case ACCUSATIVUS -> switch (numeralis) {
          case SINGULARIS, NULLUS -> primaCapitania ? "Āctum" : "āctum";
          case PLURALIS -> primaCapitania ? "Āctūs" : "āctūs";
        };
        case ABLATIVUS, INSTRUMENTALIS, LOCATIVUS -> switch (numeralis) {
          case SINGULARIS, NULLUS -> primaCapitania ? "Āctū" : "āctū";
          case PLURALIS -> primaCapitania ? "Āctibus" : "āctibus";
        };
      };
      case ADIECTIVUM -> switch (casus) {
          case NOMINATIVUS, ACCUSATIVUS, VOCATIVUS, DERECTUS -> switch (numeralis) {
            case SINGULARIS, NULLUS -> primaCapitania ? "Adiectīvum" : "adiectīvum";
            case PLURALIS -> primaCapitania ? "Adiectīva" : "adiectīva";
          };
          case GENITIVUS -> switch (numeralis) {
            case SINGULARIS, NULLUS -> primaCapitania ? "Adiectīvī" : "adiectīvī";
            case PLURALIS -> primaCapitania? "Adiectīvōrum" : "adiectīvōrum";
          };
          case DATIVUS, ABLATIVUS, INSTRUMENTALIS, LOCATIVUS -> switch (numeralis) {
            case SINGULARIS, NULLUS -> primaCapitania ? "Adiectīvō" : "adiectīvō";
            case PLURALIS -> primaCapitania ? "Adiectīvīs" : "adiectīvīs";
          };
        };
      case ADVERBIUM -> switch (casus) {
        case NOMINATIVUS, ACCUSATIVUS, VOCATIVUS, DERECTUS -> switch (numeralis) {
          case SINGULARIS, NULLUS -> primaCapitania ? "Adverbium" : "adverbium";
          case PLURALIS -> primaCapitania ? "Adverbia" : "adverbia";
        };
        case GENITIVUS -> switch (numeralis) {
          case SINGULARIS, NULLUS -> primaCapitania ? "Adverbiī" : "adverbiī";
          case PLURALIS -> primaCapitania? "Adverbiōrum" : "adverbiōrum";
        };
        case DATIVUS, ABLATIVUS, INSTRUMENTALIS, LOCATIVUS -> switch (numeralis) {
          case SINGULARIS, NULLUS -> primaCapitania ? "Adverbiō" : "adverbiō";
          case PLURALIS -> primaCapitania ? "Adverbiīs" : "adverbiīs";
        };
      };
      case CONIUNCTIO -> switch (casus) {
        case NOMINATIVUS, VOCATIVUS, DERECTUS -> switch (numeralis) {
          case SINGULARIS, NULLUS -> primaCapitania ? "Coniūnctiō" : "coniūnctiō";
          case PLURALIS -> primaCapitania ? "Coniūnctiōnēs" : "coniūnctiōnēs";
        };
        case GENITIVUS -> switch (numeralis) {
          case SINGULARIS, NULLUS -> primaCapitania ? "Coniūnctiōnis" : "coniūnctiōnis";
          case PLURALIS -> primaCapitania? "Coniūnctiōnum" : "coniūnctiōnum";
        };
        case ACCUSATIVUS -> switch (numeralis) {
          case SINGULARIS, NULLUS -> primaCapitania ? "Coniūnctiōnem" : "coniūnctiōnem";
          case PLURALIS -> primaCapitania ? "Coniūnctiōnēs" : "coniūnctiōnēs";
        };
        case DATIVUS -> switch (numeralis) {
          case SINGULARIS, NULLUS -> primaCapitania ? "Coniūnctiōnī" : "coniūnctiōnī";
          case PLURALIS -> primaCapitania ? "Coniūnctiōnibus" : "coniūnctiōnibus";
        };
        case ABLATIVUS, INSTRUMENTALIS, LOCATIVUS -> switch (numeralis) {
          case SINGULARIS, NULLUS -> primaCapitania ? "Coniūnctiōne" : "coniūnctiōne";
          case PLURALIS -> primaCapitania ? "Coniūnctiōnibus" : "coniūnctiōnibus";
        };
      };
      case INTERIECTIO -> switch (casus) {
        case NOMINATIVUS, VOCATIVUS, DERECTUS -> switch (numeralis) {
          case SINGULARIS, NULLUS -> primaCapitania ? "Interiectiō" : "interiectiō";
          case PLURALIS -> primaCapitania ? "Interiectiōnēs" : "interiectiōnēs";
        };
        case GENITIVUS -> switch (numeralis) {
          case SINGULARIS, NULLUS -> primaCapitania ? "Interiectiōnis" : "interiectiōnis";
          case PLURALIS -> primaCapitania? "Interiectiōnum" : "interiectiōnum";
        };
        case ACCUSATIVUS -> switch (numeralis) {
          case SINGULARIS, NULLUS -> primaCapitania ? "Interiectiōnem" : "interiectiōnem";
          case PLURALIS -> primaCapitania ? "Interiectiōnēs" : "interiectiōnēs";
        };
        case DATIVUS -> switch (numeralis) {
          case SINGULARIS, NULLUS -> primaCapitania ? "Interiectiōnī" : "interiectiōnī";
          case PLURALIS -> primaCapitania ? "Interiectiōnibus" : "interiectiōnibus";
        };
        case ABLATIVUS, INSTRUMENTALIS, LOCATIVUS -> switch (numeralis) {
          case SINGULARIS, NULLUS -> primaCapitania ? "Interiectiōne" : "interiectiōne";
          case PLURALIS -> primaCapitania ? "Interiectiōnibus" : "interiectiōnibus";
        };
      };
      case NOMEN -> switch (casus) {
        case NOMINATIVUS, ACCUSATIVUS, VOCATIVUS, DERECTUS -> switch (numeralis) {
          case SINGULARIS, NULLUS -> primaCapitania ? "Nōmen" : "nōmen";
          case PLURALIS -> primaCapitania ? "Nōmina" : "nōmina";
        };
        case GENITIVUS -> switch (numeralis) {
          case SINGULARIS, NULLUS -> primaCapitania ? "Nōminis" : "nōminis";
          case PLURALIS -> primaCapitania? "Nōminum" : "nōminum";
        };
        case DATIVUS -> switch (numeralis) {
          case SINGULARIS, NULLUS -> primaCapitania ? "Nōminī" : "nōminī";
          case PLURALIS -> primaCapitania ? "Nōminibus" : "nōminibus";
        };
        case ABLATIVUS, INSTRUMENTALIS, LOCATIVUS -> switch (numeralis) {
          case SINGULARIS, NULLUS -> primaCapitania ? "Nōmine" : "nōmine";
          case PLURALIS -> primaCapitania ? "Nōminibus" : "nōminibus";
        };
      };
      case NUMERUS -> switch (casus) {
        case NOMINATIVUS, VOCATIVUS, DERECTUS -> switch (numeralis) {
          case SINGULARIS, NULLUS -> primaCapitania ? "Numerus" : "numerus";
          case PLURALIS -> primaCapitania ? "Numerī" : "numerī";
        };
        case GENITIVUS -> switch (numeralis) {
          case SINGULARIS, NULLUS -> primaCapitania ? "Numerī" : "numerī";
          case PLURALIS -> primaCapitania ? "Numerōrum" : "numerōrum";
        };
        case ACCUSATIVUS -> switch (numeralis) {
          case SINGULARIS, NULLUS -> primaCapitania ? "Numerum" : "numerum";
          case PLURALIS -> primaCapitania ? "Numerōs" : "numerōs";
        };
        case DATIVUS, ABLATIVUS, INSTRUMENTALIS, LOCATIVUS -> switch (numeralis) {
          case SINGULARIS, NULLUS -> primaCapitania ? "Numerō" : "numerō";
          case PLURALIS -> primaCapitania ? "Numerīs" : "numerīs";
        };
      };
      case PRAEPOSITIO -> switch (casus) {
        case NOMINATIVUS, VOCATIVUS, DERECTUS -> switch (numeralis) {
          case SINGULARIS, NULLUS -> primaCapitania ? "Praepositiō" : "praepositiō";
          case PLURALIS -> primaCapitania ? "Praepositiōnēs" : "praepositiōnēs";
        };
        case GENITIVUS -> switch (numeralis) {
          case SINGULARIS, NULLUS -> primaCapitania ? "Praepositiōnis" : "praepositiōnis";
          case PLURALIS -> primaCapitania? "Praepositiōnum" : "praepositiōnum";
        };
        case ACCUSATIVUS -> switch (numeralis) {
          case SINGULARIS, NULLUS -> primaCapitania ? "Praepositiōnem" : "praepositiōnem";
          case PLURALIS -> primaCapitania ? "Praepositiōnēs" : "praepositiōnēs";
        };
        case DATIVUS -> switch (numeralis) {
          case SINGULARIS, NULLUS -> primaCapitania ? "Praepositiōnī" : "praepositiōnī";
          case PLURALIS -> primaCapitania ? "Praepositiōnibus" : "praepositiōnibus";
        };
        case ABLATIVUS, INSTRUMENTALIS, LOCATIVUS -> switch (numeralis) {
          case SINGULARIS, NULLUS -> primaCapitania ? "Praepositiōne" : "praepositiōne";
          case PLURALIS -> primaCapitania ? "Praepositiōnibus" : "praepositiōnibus";
        };
      };
      case PRONOMEN -> switch (casus) {
        case NOMINATIVUS, ACCUSATIVUS, VOCATIVUS, DERECTUS -> switch (numeralis) {
          case SINGULARIS, NULLUS -> primaCapitania ? "Prōnōmen" : "prōnōmen";
          case PLURALIS -> primaCapitania ? "Prōnōmina" : "prōnōmina";
        };
        case GENITIVUS -> switch (numeralis) {
          case SINGULARIS, NULLUS -> primaCapitania ? "Prōnōminis" : "prōnōminis";
          case PLURALIS -> primaCapitania? "Prōnōminum" : "prōnōminum";
        };
        case DATIVUS -> switch (numeralis) {
          case SINGULARIS, NULLUS -> primaCapitania ? "Prōnōminī" : "prōnōminī";
          case PLURALIS -> primaCapitania ? "Prōnōminibus" : "prōnōminibus";
        };
        case ABLATIVUS, INSTRUMENTALIS, LOCATIVUS -> switch (numeralis) {
          case SINGULARIS, NULLUS -> primaCapitania ? "Prōnōmine" : "prōnōmine";
          case PLURALIS -> primaCapitania ? "Prōnōminibus" : "prōnōminibus";
        };
      };
    };
  }
}
