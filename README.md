# Strūctor Verba : Iava

Verba Latīna scrībere tetendistisne sed nōn potuistisne meminisse coniugātiōnem quam āctārum hārum aut generem nōminum illōrum?

Nōn iam! Vōbīs intrōdūcō programma StrūctorVerba scrīpta in linguā [Iavā](https://docs.oracle.com/javase/10/docs/api/overview-summary.html).

Programma hoc classēs novem dēfīnit catēgoriās novem verbōrum repraesentāre:

I. [Adverbium](src/main/java/net/strūctorverba/verba/VerbumSimplex.java)

II. [Coniūnctīvum](src/main/java/net/strūctorverba/verba/VerbumSimplex.java)

III. [Praepositiō](src/main/java/net/strūctorverba/verba/VerbumSimplex.java)

IV. [Numerus](src/main/java/net/strūctorverba/verba/VerbumSimplex.java)

V. [Nōmen](src/main/java/net/strūctorverba/verba/multiplicia/Nōmen.java)

VI. [Prōnōmen](src/main/java/net/strūctorverba/verba/multiplicia/Prōnōmen.java)

VII. [PrōnōmenConiūnctīvum](src/main/java/net/strūctorverba/verba/multiplicia/PrōnōmenConiūnctīvum.java)

VIII. [Adiectīvum](src/main/java/net/strūctorverba/verba/multiplicia/Adiectīvum.java)

XI. [Āctum](src/main/java/net/strūctorverba/verba/multiplicia/Āctum.java)

Omne quālitātēs ipsās prōpositaque ipsa habet et ligāmina illa tabellās aptās dūcet pellēgēre.

Praetereā tentāmina duo scrīpsī exsecūtiōnem modōsque programmātis recēnsēre.

I. [DolōremIpsum](src/main/test/net/strūctorverba/tentāmina/DolōremIpsum.java)

II. [Numerī](src/main/test/net/strūctorverba/tentāmina/Numerī.java)

Programmātem StrūctorVerba ūtī fac rem classis [StrūctorVerba](src/main/java/net/strūctorverba/mīscella/StrūctorVerba.java). Fūnctiōnēs omnēs per modīs eius accēdās.

```java
class Tentāmen {
  final StrūctorVerba strūctor = StrūctorVerba.fac.get();
  final Verba verba = strūctor.strue(strūctor.nōmenLege()
                                             .adveniam("verbum",
                                                       Speciālitās.COMMŪNE, Genus.NEUTRUM,
                                                       Cāsus.ACCŪSĀTĪVUS, Numerālis.PLŪRĀLIS),
                                     strūctor.adiectīvumLege()
                                             .adveniam("Latīnus",
                                                       Speciālitās.PROPRIUM, Genus.NEUTRUM,
                                                       Cāsus.ACCŪSĀTĪVUS, Numerālis.PLŪRĀLIS),
                                     strūctor.āctumLege()
                                             .adveniam("iūbilāre",
                                                       Modus.INDICĀTĪVUS, Vōx.ĀCTĪVA, Tempus.PRAESĒNS,
                                                       Numerālis.SINGULĀRIS, Persōna.PRĪMA),
                                     strūctor.āctumLege()
                                             .adveniam("scrībere",
                                                       Modus.ĪNFĪNĪTĪVUS, Vōx.ĀCTĪVA, Tempus.PRAESĒNS));
  System.out.println(verba); // Verba Latīna iūbilō scrībere
}
```

> Ingeniārius excōgitat problēmata quae nesciēbās.
> 
> Eum tibi etiamtum solvat in viam quam ignōrās.
> 
> Atque tibi pretiābit valōrem quem nōn potes praebēre.


