namespace Ej6;

public class Nodo<T> where T : IComparable
{

    private T? _dato;
    private Nodo<T>? _hijoIzquierdo, _hijoDerecho;
    public int Altura
    {
        get
        {
            Queue<Nodo<T>?> q = new Queue<Nodo<T>?>();
            Nodo<T>? n;
            int altura = 0;
            q.Enqueue(this);
            q.Enqueue(null);
            while (q.Count != 0)
            {
                n = q.Dequeue();
                if (n != null)
                {
                    if (n.TieneHI()) q.Enqueue(n._hijoIzquierdo);
                    if (n.TieneHD()) q.Enqueue(n._hijoDerecho);
                }
                else
                {
                    if (q.Count != 0)
                    {
                        altura++;
                        q.Enqueue(null);
                    }
                }
            }
            return altura;
        }
    }
    public int CantNodos
    {
        get
        {
            Queue<Nodo<T>?> q = new Queue<Nodo<T>?>();
            Nodo<T>? n;
            int cantNodos = 0;
            q.Enqueue(this);
            q.Enqueue(null);
            while (q.Count != 0)
            {
                n = q.Dequeue();
                if (n != null)
                {
                    cantNodos++;
                    if (n.TieneHI()) q.Enqueue(n._hijoIzquierdo);
                    if (n.TieneHD()) q.Enqueue(n._hijoDerecho);
                }
                else
                {
                    if (q.Count != 0)
                    {
                        q.Enqueue(null);
                    }
                }
            }
            return cantNodos;
        }
    }
    public T? ValorMinimo
    {
        get
        {
            if (TieneHI()) return _hijoIzquierdo.ValorMinimo;
            return _dato;
        }
    }
    public T? ValorMaximo
    {
        get
        {
            if (TieneHD()) return _hijoDerecho.ValorMaximo;
            return _dato;
        }
    }
    public List<T?> InOrder
    {
        get
        {
            List<T?> l = new List<T?>();
            GetInOrderPrivate(l);
            return l;
        }
    }

    public Nodo(T dato)
    {
        _dato = dato;
        _hijoIzquierdo = null;
        _hijoDerecho = null;
    }

    public Boolean TieneHI() => _hijoIzquierdo != null;
    public Boolean TieneHD() => _hijoDerecho != null;

    public void Insertar(T valor)
    {
        if (_dato == null)
        {
            _dato = valor;
        }
        if (valor.CompareTo(_dato) < 0)
        {
            if (TieneHI())
            {
                _hijoIzquierdo?.Insertar(valor);
            }
            else
            {
                _hijoIzquierdo = new Nodo<T>(valor);
            }
        }
        else
        {
            if (TieneHD())
            {
                _hijoDerecho?.Insertar(valor);
            }
            else
            {
                _hijoDerecho = new Nodo<T>(valor);
            }
        }
    }

    private void GetInOrderPrivate(List<T?> l)
    {
        if (TieneHI()) _hijoIzquierdo?.GetInOrderPrivate(l);
        l.Add(_dato);
        if (TieneHD()) _hijoDerecho?.GetInOrderPrivate(l);
    }
}