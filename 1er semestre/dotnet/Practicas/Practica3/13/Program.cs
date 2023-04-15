bool isBalanced(string st)
{
    Stack<char> pila = new Stack<char>();
    foreach (char c in st)
    {
        if (c == '(')
        {
            pila.Push(c);
        }
        else if (c == ')')
        {
            if (pila.Count == 0)
            {
                return false;
            }
            pila.Pop();
        }
    }
    return pila.Count == 0;
}

Console.WriteLine(isBalanced("3*2(+2)3423()"));
Console.ReadKey();