package net.strūctorverba.ēnumerātiōnēs;

import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection", "unused" })
public enum Encliticum {
  INTERROGĀNS("ne"),
  CONIUGĀNS("que"),
  ĒLIĒNS("ve"),
  NŌLĒNS(StringUtils.EMPTY);

  public final String scrīptiō;

  Encliticum(@NotNull final String scrpt) {
    scrīptiō = scrpt;
  }
}
