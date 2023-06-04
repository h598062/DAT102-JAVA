/*
a)

insertion sort:
du bytter plass mellom første i usortert del og de i sortert del, slik at den blir plassert riktig i sortert del

selection sort:
en velger alltid den minste i usortert del og setter bakerst i sortert del, bytter plass mellom.

b)
i)
selectionsort: O(n^2)
			denne vil alltid gå gjennom tabellen n^2 antall ganger
insertionsort: O(n-1)
			hvis tabellen er allerede sortert vil den kun gå gjennom en gang
ii)
selectionsort: O(n^2)
insertionsort: O(n^2)


c)
ii)
metoden finner en pivot verdi, flytter alle elementer som er mindre til venstre, og større til høyre, og returnerer index til pivot verdien

iii)
25 40 10 45 30 15 20
15 20 10 25 40 45 30

d)
ii)
@BeforeEach: denne vil kjøre koden i metoden før hver test markert med @Test

@Test: indikerer at metoden den er festet til er en test metode, og JUnit skal kjøre den som en test.



*/

private static <T extends Comparable<T>> void kvikkSort(T[] data, int min, int max) {
    if (min < max) {
        int pivot = partition(data, min, max);
        kvikkSort(data, min, pivot - 1);
        kvikkSort(data, pivot + 1, max);
    }
}


public class SorteringTest {
    private static final int SIZE = 100;
    private Integer[] testdata = new Integer[SIZE];

    @BeforeEach //Det samme som @Before i JUnit4
    public final void setup() {
        Random rInt = new Random();
        for (int i = 0; i < testdata.length; i++) {
            testdata [i] = new Integer(rInt.nextInt());
        }
    }

    @Test
    public final void testKvikkSort() {
        Sortering.kvikkSort(testdata);
        assertTrue(verifiser(testdata));
    }

    private <T extends Comparable<T>> boolean verifiser(T[] data) {
        for(int i = 0; i < data.length - 1; i++) {
            if (data[i].compareTo(data[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }
}