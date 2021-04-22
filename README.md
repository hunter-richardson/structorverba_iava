# Strūctor Verba : Iava

Verba Latīna scrībere tetendistisne sed nōn potuistisne meminisse coniugātiōnem quam āctārum hārum aut generem nōminum illōrum?

Nōn iam! Vōbīs intrōdūcō programma StrūctorVerba scrīpta in linguā [Iavā](https://docs.oracle.com/javase/10/docs/api/overview-summary.html).

Programma hoc classēs octō dēfīnit catēgoriās octō verbōrum repraesentāre:

I. [Coniūnctīvum](src/main/java/net/strūctorverba/verba/VerbumSimplex.java)

II. [Praepositiō](src/main/java/net/strūctorverba/verba/VerbumSimplex.java)

III. [Numerus](src/main/java/net/strūctorverba/verba/VerbumSimplex.java)

IV. [Adverbium](src/main/java/net/strūctorverba/verba/multiplicia/Adverbium.java)

V. [Nōmen](src/main/java/net/strūctorverba/verba/multiplicia/Nōmen.java)

VI. [Prōnōmen](src/main/java/net/strūctorverba/verba/multiplicia/Prōnōmen.java)

VII. [Adiectīvum](src/main/java/net/strūctorverba/verba/multiplicia/Adiectīvum.java)

VII. [Āctum](src/main/java/net/strūctorverba/verba/multiplicia/Āctum.java)

Omne quālitātēs ipsās prōpositaque ipsa habet et ligāmina illa tabellās aptās dūcet pellēgēre.

Praetereā tentāmina duo scrīpsī exsecūtiōnem modōsque programmātis recēnsēre.

I. [DolōremIpsum](src/main/test/net/strūctorverba/tentāmina/DolōremIpsum.java)

II. [Numerī](src/main/test/net/strūctorverba/tentāmina/Numerī.java)

Valōrem [StrūctorVerba.fac](src/main/java/net/strūctorverba/mīscella/StrūctorVerba.java) ut fūnctiōnēs omnēs programmātis StrūctorVerba accēdās:

```java
class Tentāmen {
  private void main(String[] args) {
    final StrūctorVerba strūctor = StrūctorVerba.fac.get();
    final Verba verba = strūctor.strue(strūctor.adveniam("verbum", Catēgoria.NŌMEN,
                                                         Speciālitās.COMMŪNE, Genus.NEUTRUM,
                                                         Cāsus.ACCŪSĀTĪVUS, Numerālis.PLŪRĀLIS),
                                       strūctor.adveniam("Latīnus", Catēgoria.ADIECTĪVUM,
                                                         Speciālitās.PROPRIUM, Genus.NEUTRUM,
                                                         Cāsus.ACCŪSĀTĪVUS, Numerālis.PLŪRĀLIS),
                                       strūctor.adveniam("iūbilāre", Catēgoria.ĀCTUM,
                                                         Modus.INDICĀTĪVUS, Vōx.ĀCTĪVA, Tempus.PRAESĒNS,
                                                         Numerālis.SINGULĀRIS, Persōna.PRĪMA),
                                       strūctor.adveniam("scrībere", Catēgoria.ĀCTUM,
                                                         Modus.ĪNFĪNĪTĪVUS, Vōx.ĀCTĪVA, Tempus.PRAESĒNS));
    System.out.println(verba); // Verba Latīna iūbilō scrībere
  }
}
```

> Ingeniārius invenit problēmata quae ignōrābās.
> 
> Ea tibi etiamtum solvat in modīs quōs vix intellegās.
> 
> Tibi atque petet pecūniam quam nōn poteris solvere.
