public static <T extends Comparable<T>>
void utvalgSortering( T[] data) {
    int minste;
    T temp;
    for (int neste = 0; neste < data.length - 1; neste++) {
        minste = neste;
        for (int sok = neste + 1; sok < data.length; sok++) {
            if (data[sok].compareTo(data[minste]) < 0) {
                minste = sok;
            }
        }
        /** Bytt verdiene */
        temp = data[minste];
        data[minste] = data[neste];
        data[neste] = temp;
    }
}

/*
Oppgave 5
a)
i)
7 5 9 1 6 3
1 5 9 7 6 3
1 3 9 7 6 5
1 3 5 7 6 9
1 3 5 6 7 9


b)
i)
man har en sortert del og en usortert del.
man velger neste i usortert del, og setter inn på riktig sted i sortert del.
fortsett til hele tabell er sortert.

ii)
7 5 9 1 6 3
5 7 9 1 6 3
5 7 9 1 6 3
1 5 7 9 6 3
1 5 6 7 9 3
1 3 5 6 7 9

c)
i)
metoden fletter sammen to sorterte deler som er ved siden av hverandre

ii)*/
public void fletteSort(T[] tabell, int foerste, int siste) {
    if (siste > foerste) {
        int midtpunkt = (siste + foerste) / 2;
        fletteSort(tabell, foerste,  midtpunkt);
        fletteSort(tabell, midtpunkt + 1, siste);
        flette(tabell, foerste, midtpunkt, siste);
    }
}


/*
iii)
6 7 9 4 6 1 3 8

iv)

*/