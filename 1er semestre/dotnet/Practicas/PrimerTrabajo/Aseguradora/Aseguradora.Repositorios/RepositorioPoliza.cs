namespace Aseguradora.Repositorios;

using Aseguradora.Aplicacion;

public class RepositorioPoliza : IRepositorioPoliza
{
    public readonly string _nombreRepositorio = "RepositorioPoliza.txt";
    private static int s_ultimoId { get; set; }
    public void AgregarPoliza(Poliza poliza)
    {
        List<Poliza> list = ListarPolizas();

        //Si ya existe una póliza con el mismo id se lanza una excepción
        if (!list.Exists(p => p.Id == poliza.Id))
        {
            //Se encuentra al vehiculo con el Id = poliza.VehiculoId
            var listarV = new ListarVehiculosUseCase(new RepositorioVehiculo());
            List<Vehiculo> lVe = listarV.Ejecutar();
            var vehiculo = lVe.Find(v => v.Id == poliza.VehiculoId);

            //Si el vehiculo no existe (el resultado de Find es null) se lanza una excepción
            if (vehiculo == null)
            {
                throw new ArgumentException($"No hay ningún vehículo que tenga el Id {poliza.VehiculoId}");
            }
            else
            {
                //Se lee el último Id de póliza
                {
                    using var sr = new StreamReader("IdPolizaUltimo.txt");
                    string line = sr.ReadLine() ?? "0";
                    s_ultimoId = int.Parse(line == "" ? "0" : line);
                    poliza.Id = ++s_ultimoId;
                }
                //Se actualiza el archivo con el Id de la póliza actual
                {
                    using var sw = new StreamWriter("IdPolizaUltimo.txt");
                    sw.WriteLine(s_ultimoId);
                }
                //Se agrega la nueva póliza al repositorio
                {
                    using var sw = new StreamWriter(_nombreRepositorio, true);
                    sw.WriteLine(poliza.AStringParaTxt());
                }
            }
        }
        else
        {
            throw new ArgumentException($"La póliza de id {poliza.Id} ya existe");
        }
    }

    public void EliminarPoliza(int id)
    {
        List<Poliza> list = ListarPolizas();

        //Se elimina la póliza, en caso de no encontrarse (el resultado de RemoveAll es 0, es decir, no se eliminó ninguna póliza), se lanza una excepción
        if (list.RemoveAll(poliza => poliza.Id == id) == 0)
        {
            throw new ArgumentException($"La póliza de id {id} no existe");
        }
        else
        {
            //Se escribe la lista actualizada en el repositorio
            using var sw = new StreamWriter(_nombreRepositorio);
            foreach (Poliza p in list)
            {
                sw.WriteLine(p.AStringParaTxt());
            }
        }
    }

    public void ModificarPoliza(Poliza poliza)
    {
        List<Poliza> list = ListarPolizas();
        int index = list.FindIndex(p => p.Id == poliza.Id);

        //Se busca la póliza, en caso de no encontrarse (el resultado de FindIndex es -1), se lanza una excepción
        if (index == -1)
        {
            throw new ArgumentException($"La póliza de id {poliza.Id} no existe");
        }
        else
        {
            //Se mantiene el Id de la póliza previa
            poliza.Id = list[index].Id;
            list[index] = poliza;

            //Se escribe la lista actualizada en el repositorio
            using var sw = new StreamWriter(_nombreRepositorio);
            foreach (Poliza p in list)
            {
                sw.WriteLine(p.AStringParaTxt());
            }
        }
    }

    public List<Poliza> ListarPolizas()
    {
        //Cada póliza del repositorio se añade a la variable list
        using var sr = new StreamReader(_nombreRepositorio);
        var list = new List<Poliza>();
        while (!sr.EndOfStream)
        {
            list.Add(new Poliza(sr.ReadLine() ?? ""));
        }
        return list;
    }
}