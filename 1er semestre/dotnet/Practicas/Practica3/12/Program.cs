string Codificar(string st, int key)
{
    st = st.ToUpper();
    Stack<int> aux = new Stack<int>();
    Queue<int> q = new Queue<int>();
    while (key != 0)
    {
        aux.Push(key % 10);
        key /= 10;
    }
    foreach (int i in aux)
    {
        q.Enqueue(i);
    }

    string codedString = "";
    char[] w = new char[28] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'Ñ', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', ' ' };

    for (int i = 0; i < st.Length; i++)
    {
        key = q.Dequeue();
        int index = Array.IndexOf(w, st[i]);
        index += key;
        char newLetter = w[index % 28];
        codedString += newLetter;
        q.Enqueue(key);
    }
    return codedString;
}

string Decodificar(string st, int key)
{
    st = st.ToUpper();
    Stack<int> aux = new Stack<int>();
    Queue<int> q = new Queue<int>();
    while (key != 0)
    {
        aux.Push(key % 10);
        key /= 10;
    }
    foreach (int i in aux)
    {
        q.Enqueue(i);
    }

    string codedString = "";
    char[] w = new char[28] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'Ñ', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', ' ' };

    for (int i = 0; i < st.Length; i++)
    {
        key = q.Dequeue();
        int index = Array.IndexOf(w, st[i]);
        index -= key;
        char newLetter = index >= 0 ? w[index] : w[28 + index];
        codedString += newLetter;
        q.Enqueue(key);
    }
    return codedString;
}
string st = Codificar("Hola mundo", 5397);
Console.WriteLine(st);
Console.WriteLine(Decodificar(st, 5397));
Console.ReadKey();