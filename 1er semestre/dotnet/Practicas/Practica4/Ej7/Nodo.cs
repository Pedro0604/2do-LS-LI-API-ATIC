namespace Ej7;

public class Nodo
{
    public class Info
    {
        public int _altura, _cantNodos;

        public Info(int altura, int cantNodos)
        {
            _altura = altura;
            _cantNodos = cantNodos;
        }
    }

    int? _dato;
    Nodo? _hijoIzquierdo, _hijoDerecho;

    public Nodo()
    {
        _dato = null;
        _hijoIzquierdo = null;
        _hijoDerecho = null;
    }
    public Nodo(int dato) : this()
    {
        _dato = dato;
    }

    public Boolean TieneHI() => _hijoIzquierdo != null;
    public Boolean TieneHD() => _hijoDerecho != null;

    public void Insertar(int valor)
    {
        if (_dato == null)
        {
            _dato = valor;
        }
        if (valor < _dato)
        {
            if (TieneHI())
            {
                _hijoIzquierdo.Insertar(valor);
            }
            else
            {
                _hijoIzquierdo = new Nodo(valor);
            }
        }
        else if (valor > _dato)
        {
            if (TieneHD())
            {
                _hijoDerecho.Insertar(valor);
            }
            else
            {
                _hijoDerecho = new Nodo(valor);
            }
        }
    }

    public List<int?> GetInOrder()
    {
        List<int?> l = new List<int?>();
        GetInOrderPrivate(l);
        return l;
    }

    private void GetInOrderPrivate(List<int?> l)
    {
        if (TieneHI()) _hijoIzquierdo.GetInOrderPrivate(l);
        l.Add(_dato);
        if (TieneHD()) _hijoDerecho.GetInOrderPrivate(l);
    }

    public int GetAltura()
    {
        Info i = GetInfo();
        return i._altura;
    }

    public int GetCantNodos()
    {
        Info i = GetInfo();
        return i._cantNodos;
    }

    public Info GetInfo()
    {
        Queue<Nodo?> q = new Queue<Nodo?>();
        Nodo? n;
        int altura = 0;
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
                    altura++;
                    q.Enqueue(null);
                }
            }
        }
        return new Info(altura, cantNodos);
    }

    public int GetValorMaximo()
    {
        if (TieneHD()) return _hijoDerecho.GetValorMaximo();
        return _dato ?? 0;
    }
    public int GetValorMinimo()
    {
        if (TieneHI()) return _hijoIzquierdo.GetValorMinimo();
        return _dato ?? 0;
    }
}