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

Valōrem [StrūctorVerba.fac](src/main/java/net/strūctorverba/mīscella/StrūctorVerba.java) invocā ut fūnctiōnēs omnēs programmātis StrūctorVerba accēdās:

```java
class Tentāmen {
  @SuppressWarning("ConstantConditions")
  private void main(String[] args) {
    final StrūctorVerba strūctor = StrūctorVerba.fac.get();
    final Verba verba = strūctor.strue(
      strūctor.adveniam("lingua", Catēgoria.NŌMEN,
                        Speciālitās.COMMŪNE, Genus.FĒMINĪNUM,
                        Cāsus.NŌMINĀTĪVUS, Numerālis.SINGULĀRIS),
      strūctor.adveniam("Latīnus", Catēgoria.ADIECTĪVUM,
                        Speciālitās.PROPRIUM, Genus.FĒMINĪNUM,
                        Cāsus.NŌMINĀTĪVUS, Numerālis.SINGULĀRIS),
      strūctor.adveniam("plācēre", Catēgoria.ĀCTUM,
                        Modus.INDICĀTĪVUS, Vōx.ĀCTĪVA, Tempus.PRAESĒNS,
                        Numerālis.SINGULĀRIS, Persōna.TERTIA),
      strūctor.adveniam("prōdesse", Catēgoria.ĀCTUM,
                        Modus.ĪNFĪNĪTĪVUS, Vōx.ĀCTĪVA, Tempus.PRAESĒNS)
              .allegō(Encliticum.INTERRŌGANS);
    System.out.println(verba); // Lingua Latīna placet prōdestque
  }
}
```

Significētur quod programma haec per ipse officia lexicōnī dēest. Verba servat nōn dēfīnīre quam sōlum in formīs īnflexīs petītīs eōrum scrībere. Officia haec forsit aliquandō acquīrat in coniūnctiōne cum programmātis aliā quā fungitur ut lexicon. Autem experiendus modestē in linguā Latīnā ūsūfructuāriīs programmātis StrūctorVerbae iam est. 

> Ingeniārius invenit problēmata quae ignōrābās.
> 
> Ea tibi etiamtum solvat in modīs quōs vix intellegās.
> 
> Tibi atque petet pecūniam quam nōn poteris solvere.
