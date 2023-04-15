namespace Ej8;

public class Matriz
{
    double[,] _matriz;
    public Matriz(int filas, int columnas)
    {
        _matriz = new double[filas, columnas];
    }
    public Matriz(double[,] matriz) : this(matriz.GetLength(0), matriz.GetLength(1))
    {
        for (int i = 0; i < matriz.GetLength(0); i++)
        {
            for (int j = 0; j < matriz.GetLength(1); j++)
            {
                _matriz[i, j] = matriz[i, j];
            }
        }
    }

    public double this[int fila, int columna]
    {
        get { return _matriz[fila, columna]; }
        set { _matriz[fila, columna] = value; }
    }
    public void Imprimir()
    {
        for (int i = 0; i < _matriz.GetLength(0); i++)
        {
            for (int j = 0; j < _matriz.GetLength(1); j++)
            {
                Console.Write($"{_matriz[i, j],-5} ");
            }
            Console.WriteLine();
        }
        Console.WriteLine();
    }
    public void Imprimir(string formatString)
    {
        for (int i = 0; i < _matriz.GetLength(0); i++)
        {
            for (int j = 0; j < _matriz.GetLength(1); j++)
            {
                Console.Write(_matriz[i, j].ToString(formatString) + " ");
            }
            Console.WriteLine();
        }
        Console.WriteLine();
    }
    public double[] GetFila(int fila)
    {
        double[] f = new double[_matriz.GetLength(1)];
        for (int i = 0; i < _matriz.GetLength(1); i++)
        {
            f[i] = _matriz[fila, i];
        }
        return f;
    }
    public double[] GetColumna(int columna)
    {
        double[] c = new double[_matriz.GetLength(0)];
        for (int i = 0; i < _matriz.GetLength(0); i++)
        {
            c[i] = _matriz[i, columna];
        }
        return c;
    }

    public double[] DiagonalPrincipal
    {
        get
        {
            double[] d = new double[_matriz.GetLength(0)];
            if (_matriz.GetLength(0) != _matriz.GetLength(1))
            {
                throw new ArgumentException("La matriz no es cuadrada");
            }
            else
            {
                for (int i = 0; i < _matriz.GetLength(0); i++)
                {
                    d[i] = _matriz[i, i];
                }
            }
            return d;
        }
    }
    public double[] GetDiagonalPrincipal()
    {
        double[] d = new double[_matriz.GetLength(0)];
        if (_matriz.GetLength(0) != _matriz.GetLength(1))
        {
            throw new ArgumentException("La matriz no es cuadrada");
        }
        else
        {
            for (int i = 0; i < _matriz.GetLength(0); i++)
            {
                d[i] = _matriz[i, _matriz.GetLength(0) - i - 1];
            }
        }
        return d;
    }

    public double[][] getArregloDeArreglo()
    {
        double[][] aDeA = new double[_matriz.GetLength(0)][];
        for (int i = 0; i < _matriz.GetLength(0); i++)
        {
            aDeA[i] = new double[_matriz.GetLength(1)];
            for (int j = 0; j < _matriz.GetLength(1); j++)
            {
                aDeA[i][j] = _matriz[i, j];
            }
        }
        return aDeA;
    }
    public void sumarle(Matriz m)
    {
        if (_matriz.GetLength(0) == m._matriz.GetLength(0) && _matriz.GetLength(1) == m._matriz.GetLength(1))

            for (int i = 0; i < _matriz.GetLength(0); i++)
            {
                for (int j = 0; j < _matriz.GetLength(1); j++)
                {
                    _matriz[i, j] = _matriz[i, j] + m._matriz[i, j];
                }
            }
    }
    public void restarle(Matriz m)
    {
        if (_matriz.GetLength(0) == m._matriz.GetLength(0) && _matriz.GetLength(1) == m._matriz.GetLength(1))

            for (int i = 0; i < _matriz.GetLength(0); i++)
            {
                for (int j = 0; j < _matriz.GetLength(1); j++)
                {
                    _matriz[i, j] = _matriz[i, j] - m._matriz[i, j];
                }
            }
    }
    public void multiplicarPor(Matriz m)
    {
        if (_matriz.GetLength(1) != m._matriz.GetLength(0))
        {
            throw new ArgumentException("Invalid");
        }
        else
        {
            double[,] mat = new double[_matriz.GetLength(0), m._matriz.GetLength(1)];
            for (int i = 0; i < _matriz.GetLength(0); i++)
            {
                for (int j = 0; j < _matriz.GetLength(1); j++)
                {
                    double aux = 0;
                    for (int k = 0; k < _matriz.GetLength(0); k++)
                    {
                        aux += _matriz[i, k] * m._matriz[k, j];
                    }
                    mat[i, j] = aux;
                }
            }
            _matriz = mat;
        }
    }
}