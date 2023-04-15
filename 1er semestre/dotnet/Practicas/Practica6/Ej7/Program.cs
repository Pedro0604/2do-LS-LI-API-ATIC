Imprimidor.Imprimir(new A(), new B(), new C(), new D());
class A
{
    public virtual void Imprimir() => Console.WriteLine("Soy una instancia A");
}
class B : A
{
    public override void Imprimir() => Console.WriteLine("Soy una instancia B");
}
class C : A
{
    public override void Imprimir() => Console.WriteLine("Soy una instancia C");
}
class D : A
{
    public override void Imprimir() => Console.WriteLine("Soy una instancia D");
}
static class Imprimidor
{
    public static void Imprimir(params A[] vector)
    {
        foreach (A a in vector)
        {
            a.Imprimir();
        }
    }
}