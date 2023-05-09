namespace Aseguradora.Repositorios;

using Aseguradora.Aplicacion;

public class RepositorioTitular : IRepositorioTitular
{
    public readonly string _nombreRepositorio = "RepositorioTitular.txt";
    private static int s_ultimoId { get; set; }
    public void AgregarTitular(Titular titular)
    {
        List<Titular> list = ListarTitulares();

        //Si ya existe un titular con el mismo DNI se lanza una excepción
        if (!list.Exists(t => t.DNI == titular.DNI))
        {
            //Se lee el último Id de titular
            {
                using var sr = new StreamReader("IdTitularUltimo.txt");
                string line = sr.ReadLine() ?? "0";
                s_ultimoId = int.Parse(line == "" ? "0" : line);
                titular.Id = ++s_ultimoId;
            }
            //Se actualiza el archivo con el Id del titular actual
            {
                using var sw = new StreamWriter("IdTitularUltimo.txt");
                sw.WriteLine(s_ultimoId);
            }
            //Se agrega el nuevo titular al repositorio
            {
                using var sw = new StreamWriter(_nombreRepositorio, true);
                sw.WriteLine(titular.AStringParaTxt());
            }
        }
        else
        {
            throw new ArgumentException($"El titular de DNI {titular.DNI} ya existe");
        }
    }
    public void EliminarTitular(int id)
    {
        List<Titular> list = ListarTitulares();

        //Se elimina el titular, en caso de no encontrarse (el resultado de RemoveAll es 0, es decir, no se eliminó ningún titular), se lanza una excepción
        if (list.RemoveAll(titular => titular.Id == id) == 0)
        {
            throw new ArgumentException($"El titular de id {id} no existe");
        }
        else
        {//Se escribe la lista actualizada en el repositorio
            using var sw = new StreamWriter(_nombreRepositorio);
            foreach (Titular t in list)
            {
                sw.WriteLine(t.AStringParaTxt());
            }
        }
    }

    public void ModificarTitular(Titular titular)
    {
        List<Titular> list = ListarTitulares();
        int index = list.FindIndex(t => t.DNI == titular.DNI);

        //Se busca el titular, en caso de no encontrarse (el resultado de FindIndex es -1), se lanza una excepción
        if (index == -1)
        {
            throw new ArgumentException($"El titular de DNI {titular.DNI} no existe");
        }
        else
        {
            //Se mantiene el Id del titular previo
            titular.Id = list[index].Id;
            list[index] = titular;

            //Se escribe la lista actualizada en el repositorio
            using var sw = new StreamWriter(_nombreRepositorio);
            foreach (Titular t in list)
            {
                sw.WriteLine(t.AStringParaTxt());
            }
        }
    }

    public List<Titular> ListarTitulares()
    {
        //Cada titular del repositorio se añade a la variable list
        using var sr = new StreamReader(_nombreRepositorio);
        List<Titular> list = new List<Titular>();
        string linea;
        while (!sr.EndOfStream)
        {
            linea = sr.ReadLine() ?? "";
            list.Add(new Titular(linea));
        }
        return list;
    }

    public List<string> ListarTitularesConSusVehiculos()
    {
        //Para cada titular del repositorio se crea un string (que se guarda en la variable listTitConV) donde se le concatenan todos los vehículos que tiene dicha persona
        List<Titular> list = ListarTitulares();
        var listTitConV = new List<string>();
        string? st;
        foreach (Titular t in list)
        {

            st = "";
            st += t.ToString();
            if (t.ListaVehiculos.Count != 0)
            {
                st += " - Vehículos: [";
                foreach (Vehiculo v in t.ListaVehiculos)
                {
                    st += v.ToString() + "; ";
                }
                st = st.Remove(st.Length - 1);
                st += "]";
            }
            listTitConV.Add(st);
        }
        return listTitConV;
    }
}