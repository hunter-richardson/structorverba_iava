package net.strūctorverba.ēnumerātiōnēs;

import org.jetbrains.annotations.NotNull;

import java.time.Month;

@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection" })
public enum Mēnsis {
  IANUĀRIĪ(  "Iānuāriī"),
  FEBRUĀRIĪ( "Februāriī"),
  MĀRTIS(    "Martis"),
  APRĪLIS(   "Aprīlis"),
  MAIĪ(      "Maiī"),
  IŪNIĪ(     "Iūniī"),
  IŪLIUS(    "Iūliī"),
  AUGUSTĪ(   "Augustī"),
  SEPTEMBRIS("Septembris"),
  OCTŌBRIS(  "Octōbris"),
  NOVEMBRIS( "Novembris"),
  DECEMBRIS( "Decembris");

  public final @NotNull String scrīptiō;

  Mēnsis(@NotNull final String scrpt) {
    scrīptiō = scrpt;
  }

  public static @NotNull Mēnsis indīcam(@NotNull final Month ēnumerātiō) {
    return switch (ēnumerātiō) {
             case JANUARY -> IANUĀRIĪ;
             case FEBRUARY -> FEBRUĀRIĪ;
             case MARCH -> MĀRTIS;
             case APRIL -> APRĪLIS;
             case MAY -> MAIĪ;
             case JUNE -> IŪNIĪ;
             case JULY -> IŪLIUS;
             case AUGUST -> AUGUSTĪ;
             case SEPTEMBER -> SEPTEMBRIS;
             case OCTOBER -> OCTŌBRIS;
             case NOVEMBER -> NOVEMBRIS;
             case DECEMBER -> DECEMBRIS;
           };
  }

  public @NotNull String toString() {
    return scrīptiō;
  }
}
