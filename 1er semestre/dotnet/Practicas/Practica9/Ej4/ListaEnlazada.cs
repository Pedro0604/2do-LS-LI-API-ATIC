namespace Ej4;

public class ListaEnlazada<T>
{
    Nodo<T>? Inicio { get; set; } = null;
    Nodo<T>? Ultimo { get; set; } = null;
    Nodo<T>? Actual { get; set; } = null;
    int Tamaño { get; set; } = 0;

    public void AgregarAdelante(T elem)
    {
        var nodoNuevo = new Nodo<T>(elem);
        nodoNuevo.Proximo = Inicio;
        Inicio = nodoNuevo;
        if (Tamaño == 0)
        {
            Ultimo = nodoNuevo;
        }
        Tamaño++;
    }

    public void AgregarAtras(T elem)
    {
        var nodoNuevo = new Nodo<T>(elem);
        if (Ultimo != null)
        {
            Ultimo.Proximo = nodoNuevo;
        }
        else
        {
            Inicio = nodoNuevo;
        }
        Ultimo = nodoNuevo;
        Tamaño++;
    }

    public void Comenzar()
    {
        Actual = Inicio;
    }

    public IEnumerator<T> GetEnumerator()
    {
        Comenzar();
        while (Actual != null)
        {
            yield return Actual.Valor;
            Actual = Actual.Proximo;
        }
    }
}