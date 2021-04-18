package net.strūctorverba.lēctōrēs;

import net.strūctorverba.nūntiī.Nūntius;
import net.strūctorverba.inventōrēs.*;
import net.strūctorverba.tenōrēs.TenorMultiplicibus;
import net.strūctorverba.verba.multiplicia.*;
import net.strūctorverba.ēnumerātiōnēs.*;
import org.apache.commons.lang3.ObjectUtils;
import org.jetbrains.annotations.*;

import javax.ejb.*;
import java.util.function.Supplier;

@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection" })
public abstract class LēctorMultiplicibus <Hoc extends VerbumMultiplex <Hoc>> extends Lēctor <Hoc> {
  private final @NotNull Inventor <Hoc> inventor;

  protected LēctorMultiplicibus(@NotNull final Catēgoria catēgoria,
                                @NotNull final Supplier <? extends Nūntius> nūntius,
                                @NotNull final Supplier <@NotNull ? extends TenorMultiplicibus <Hoc>> tenor,
                                @NotNull final Supplier <@NotNull ? extends Inventor <Hoc>> inventor) {
    super(catēgoria, nūntius, tenor);
    this.inventor = inventor.get();
  }


  public final @Nullable Hoc adveniam(@NotNull final String fundāmen, @NotNull final Enum <@NotNull ?>... illa) {
    legam(fundāmen);
    Hoc hoc = tenor.referō(inventor.allegō(illa).inquīram());
    inventor.restituō();
    if(hoc == null) {
      nūntius.moneō("Nihil advenī");
      return null;
    } else {
      nūntius.garriō("Advenī hoc:", hoc);
      return hoc;
    }
  }

  @Singleton @DependsOn({ "TenorNōminibus", "NūntiusLēctōrīNōminibus" })
  public static final class LēctorNōminibus extends LēctorMultiplicibus <Nōmen> {
    public static final @NotNull Supplier <LēctorNōminibus> fac = LēctorNōminibus::new;

    private LēctorNōminibus( ) {
      super(Catēgoria.NŌMEN, Nūntius.NūntiusLēctōrīNōminibus.fac,
            TenorMultiplicibus.TenorNōminibus.fac, InventorNōminibus.fac);
    }
  }

  @Singleton @DependsOn({ "TenorAdiectīvīs", "NūntiusLēctōrīAdiectīvīs" })
  public static final class LēctorAdiectīvīs extends LēctorMultiplicibus <Adiectīvum> {
    public static final @NotNull Supplier <LēctorAdiectīvīs> fac = LēctorAdiectīvīs::new;

    private LēctorAdiectīvīs( ) {
      super(Catēgoria.ADIECTĪVUM, Nūntius.NūntiusLēctōrīAdiectīvīs.fac,
            TenorMultiplicibus.TenorAdiectīvīs.fac, InventorAdiectīvīs.fac);
    }

    @SuppressWarnings("unused")
    public @Nullable Adiectīvum adveniam(final Numerālis numerālis, final Persōna persōna, final Enum<?>... illa) {
      try {
        return adveniam(switch (persōna) {
                          case PRĪMA -> switch (numerālis) {
                            case SINGULĀRIS -> "meus";
                            case PLŪRĀLIS -> "noster";
                            case NŪLLUS -> throw new IllegalArgumentException(String.format("Ūsus prāvus est ēnumerātiōnis %s",
                                                                                            Numerālis.NŪLLUS));
                          };
                          case SECUNDA -> switch (numerālis) {
                            case SINGULĀRIS -> "tuus";
                            case PLŪRĀLIS -> "voster";
                            case NŪLLUS -> throw new IllegalArgumentException(String.format("Ūsus prāvus est ēnumerātiōnis %s",
                                                                                            Numerālis.NŪLLUS));
                          };
                          case TERTIA -> "suus";
                          case NŪLLA -> throw new IllegalArgumentException(String.format("Ūsus prāvus est ēnumerātiōnis %s",
                                                                                          Persōna.NŪLLA));
                        }, illa);
      } catch (IllegalArgumentException e) {
        nūntius.terreō(e);
        return null;
      }
    }
  }

  @Singleton @DependsOn({ "TenorPrōnōminibus", "NūntiusLēctōrīPrōnōminibus" })
  public static final class LēctorPrōnōminibus extends LēctorMultiplicibus <Prōnōmen> {
    private static @Nullable LēctorPrōnōminibus īnstantia = null;

    public static final @NotNull Supplier <LēctorPrōnōminibus> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new LēctorPrōnōminibus());

    private LēctorPrōnōminibus( ) {
      super(Catēgoria.PRŌNŌMEN, Nūntius.NūntiusLēctōrīPrōnōminibus.fac,
            TenorMultiplicibus.TenorPrōnōminibus.fac, InventorPrōnōminibus.fac);
    }

    @SuppressWarnings("unused")
    public @Nullable Prōnōmen adveniam(final Persōna persōna, final Enum<?>... illa) {
      try {
        return adveniam(switch (persōna) {
                          case PRĪMA -> "ego";
                          case SECUNDA -> "tū";
                          case TERTIA -> "is";
                          case NŪLLA -> throw new IllegalArgumentException(String.format("Ūsus prāvus est ēnumerātiōnis %s",
                                                                                         Numerālis.NŪLLUS));
                        }, illa);
      } catch (IllegalArgumentException e) {
        nūntius.terreō(e);
        return null;
      }
    }
  }

  @Singleton @DependsOn({ "TenorPrōnōmibusConiūnctīvīs", "NūntiusLēctōrīPrōnōminibusConiūnctīvīs" })
  public static final class LēctorPrōnōminibusConiūnctīvīs extends LēctorMultiplicibus <PrōnōmenConiūnctīvum> {
    private static @Nullable LēctorPrōnōminibusConiūnctīvīs īnstantia = null;

    public static final @NotNull Supplier <LēctorPrōnōminibusConiūnctīvīs> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new LēctorPrōnōminibusConiūnctīvīs());

    private LēctorPrōnōminibusConiūnctīvīs( ) {
      super(Catēgoria.PRŌNŌMEN_CONIŪNCTĪVUM, Nūntius.NūntiusLēctōrīPrōnōminibusConiūnctīvīs.fac,
            TenorMultiplicibus.TenorPrōnōminibusConiūnctīvīs.fac, InventorPrōnōminibusConiūnctīvīs.fac);
    }
  }

  @Singleton @DependsOn({ "TenorĀctīs", "NūntiusLēctōrīĀctīs" })
  public static final class LēctorĀctīs extends LēctorMultiplicibus <Āctum> {
    private static @Nullable LēctorĀctīs īnstantia = null;

    public static final @NotNull Supplier <LēctorĀctīs> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new LēctorĀctīs());

    private LēctorĀctīs( ) {
      super(Catēgoria.ĀCTUM, Nūntius.NūntiusLēctōrīĀctīs.fac,
            TenorMultiplicibus.TenorĀctīs.fac, InventorĀctīs.fac);
    }

    public @Nullable Āctum adveniam(@NotNull final Enum<?>... illa) {
      return adveniam("esse", illa);
    }
  }
}
