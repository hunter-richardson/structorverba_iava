package net.strūctorverba.ēnumerātiōnēs;

import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection" })
public enum Catēgoria {
  NŌMEN("nōmina"),
  ADIECTĪVUM("adiectīva"),
  PRŌNŌMEN("prōnōmina"),
  ĀCTUM("ācta"),
  ADVERBIUM("adverbia"),
  CONIŪNCTĪVUM("coniūnctīva"),
  PRAEPOSITIŌ("praepositiōnēs"),
  PRŌNŌMEN_CONIŪNCTĪVUM("prōnōminaConiūnctīva"),
  NUMERUM(StringUtils.EMPTY),
  VERBA_PRAEPOSITIŌNE(StringUtils.EMPTY);

  public final @NotNull String scrīptiō;

  Catēgoria(@NotNull final String scrpt) {
    scrīptiō = scrpt;
  }
}
