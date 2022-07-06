package com.structorverba.officia;

import androidx.annotation.NonNull;
import com.structorverba.officia.enumerationes.*;
import com.structorverba.officia.miscella.*;
import com.structorverba.officia.tentamina.Tentamen;
import com.structorverba.officia.verba.*;
import lombok.Getter;
import org.junit.jupiter.api.*;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * Classis {@link Numeri} operātiōnēs mathēmaticās rērum classis {@link Numerus} tentat.
 */
@SuppressWarnings({"SpellCheckingInspection", "FieldCanBeLocal", "NewClassNamingConvention"})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
final class Numeri extends Omne {
  @NonNull private static final Map<Operatio, Map.Entry<Short, Short>> data = new HashMap<>();
  static {
    data.put(Operatio.ADDITIO,      Map.entry((short) 3,  (short) 17));
    data.put(Operatio.SUBTRACTIO,   Map.entry((short) 12, (short) 7));
    data.put(Operatio.MULTIPLICIO,  Map.entry((short) 2,  (short) 3));
    data.put(Operatio.DIVISIO,      Map.entry((short) 18, (short) 6));
    data.put(Operatio.MANSIO,       Map.entry((short) 12, (short) 9));
  }

  @NonNull
  @Getter(lazy = true)
  private final StructorVerba structor = StructorVerba.faciendum.get();

  @NonNull @Getter(lazy = true)
  private final Consumer<Operatio> agendum = operatio -> {
            final Map.Entry<Short, Short> numeri = data.get(operatio);
            //noinspection ConstantConditions
            final short expectatus = operatio.arabicus.apply(numeri.getKey().intValue(), numeri.getValue().intValue()).shortValue();
            try {
              System.out.println(new Tentamen.TentamenMathematicum(numeri, operatio)
                      .exsequar(structor.numeram(expectatus)));
            } catch (IllegalArgumentException e) {
              System.out.printf("Prōductā conversiōnis relicta'st prōductiō numerī %d.%n", expectatus);
            }
          };

  private final short NUMERUM_MAXIMUM = 3998;
  private final short XLII_NUMERUM    = 42;

  private final @NonNull String XLII_SCRIPTIO = "XLII";

  /**
   * Hic modus conversiōnem ā numerō reī classis {@link Numerus} tentat. <br>
   * Scrīptiunculam {@code 42 = XLII} prōdūcat.
   */
  @Test @Order(1)
  public void conversionis() {
    try {
      System.out.println(new Tentamen.TentamenNumeraleConversionis(XLII_SCRIPTIO, XLII_NUMERUM)
              .exsequar(structor.numeram(XLII_NUMERUM)));
    } catch (IllegalArgumentException e) {
      System.out.printf("Prōductā conversiōnis relicta'st prōductiō numerī %d.%n", XLII_NUMERUM);
    }
  }

  /**
   * Hic modus reversiōnem ā rē classis {@link Numerus} numerō tentat. <br>
   * Scrīptiunculam {@code XLII = 42} prōdūcat.
   */
  @Test @Order(2)
  public void reversionis() {
    try {
      System.out.println(new Tentamen.TentamenNumeraleReversionis(XLII_NUMERUM, XLII_SCRIPTIO)
              .exsequar(structor.adveniam(XLII_SCRIPTIO, Categoria.NUMERUS)));
    } catch (IllegalArgumentException e) {
      System.out.printf("Prōductā conversiōnis relicta'st prōductiō numerī %d.%n", XLII_NUMERUM);
    }
  }

  /**
   * Hic modus conversiōnem ā numerō reī classis {@link Numerus} atque reversiōnem versam tentat. <br>
   * Scrīptiunculās et {@code 42 = XLII} et {@code XLII = 42} dē numerō nescītō inter I et MMMCMXCIX prōdūcat.
   */
  @Test @Order(3)
  public void combinationis() {
    final short numerus = Integer.valueOf(new Random().ints(1, NUMERUM_MAXIMUM)
                                                      .distinct().findFirst().orElse(10)).shortValue();
    try {
      System.out.println(new Tentamen.TentamenNumeraleCombinationis(numerus)
              .exsequar(structor.numeram(numerus)));
    } catch (IllegalArgumentException e) {
      System.out.println("Prōductā conversiōnis relicta'st prōductiō numerī.");
    }
  }

  /**
   * Hic modus rēs duās classis {@link Numerus} addit. <br>
   * Scrīptiunculās et {@code 17 = XVIII} et {@code 3 = III} et {@code 17 + 3 = 20 = XX} prōdūcat.
   * @see Operatio#ADDITIO
   */
  @Test @Order(4)
  public void additionis() {
    agendum.accept(Operatio.ADDITIO);
  }

  /**
   * Hic modus rēs duās classis {@link Numerus} subtrahit. <br>
   * Scrīptiunculās et {@code 12 = XII} et {@code 7 = VII} et {@code 12 - 7 = 5 = V} prōdūcat.
   * @see Operatio#SUBTRACTIO
   */
  @Test @Order(5)
  public void subtractionis() {
    agendum.accept(Operatio.SUBTRACTIO);
  }

  /**
   * Hic modus rēs duās classis {@link Numerus} multiplicat. <br>
   * Scrīptiunculās et {@code 3 = III} et {@code 2 = II} et {@code 3 * 2 = 6 = VI} prōdūcat.
   * @see Operatio#MULTIPLICIO
   */
  @Test @Order(6)
  public void multiplicationis() {
    agendum.accept(Operatio.MULTIPLICIO);
  }

  /**
   * Hic modus rēs duās classis {@link Numerus} dīvidit. <br>
   * Scrīptiunculās et {@code 18 = XVII} et {@code 6 = VI} et {@code 18 / 6 = 3 = III} prōdūcat.
   * @see Operatio#DIVISIO
   */
  @Test @Order(7)
  public void divisionis() {
    agendum.accept(Operatio.DIVISIO);
  }

  /**
   * Hic modus rēs duās classis {@link Numerus} manet. <br>
   * Scrīptiunculās et {@code 12 = XII} et {@code 9 = IX} et {@code 12 % 9 = 3 = III} prōdūcat.
   * @see Operatio#MANSIO
   */
  @Test @Order(8)
  public void mansionis() {
    agendum.accept(Operatio.MANSIO);
  }

  /**
   * Hic modus operātiōnēs omnnēs classis {@link Operatio} agit.
   * */
  @Test @Order(9)
  public void omnesMathematicae() {
    Stream.of(Operatio.values()).forEach(agendum);
  }
}
