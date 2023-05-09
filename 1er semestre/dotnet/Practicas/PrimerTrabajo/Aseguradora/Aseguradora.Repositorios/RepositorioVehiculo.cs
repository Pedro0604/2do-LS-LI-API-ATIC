namespace Aseguradora.Repositorios;

using Aseguradora.Aplicacion;

public class RepositorioVehiculo : IRepositorioVehiculo
{
    public readonly string _nombreRepositorio = "RepositorioVehiculo.txt";
    private static int s_ultimoId { get; set; }
    public void AgregarVehiculo(Vehiculo vehiculo)
    {
        List<Vehiculo> list = ListarVehiculos();

        //Si ya existe un vehículo con el mismo dominio se lanza una excepción
        if (!list.Exists(v => v.Dominio == vehiculo.Dominio))
        {
            //Se encuentra al titular con el Id = vehiculo.titularId
            var listarTit = new ListarTitularesUseCase(new RepositorioTitular());
            List<Titular> lTit = listarTit.Ejecutar();
            var titular = lTit.Find(t => t.Id == vehiculo.TitularId);

            //Si el titular no existe (el resultado de Find es null) se lanza una excepción
            if (titular == null)
            {
                throw new ArgumentException($"No hay ningún titular de vehículo que tenga el Id {vehiculo.TitularId}");
            }
            else
            {
                //Se lee el último Id de vehículo
                {
                    using var sr = new StreamReader("IdVehiculoUltimo.txt");
                    string line = sr.ReadLine() ?? "0";
                    s_ultimoId = int.Parse(line == "" ? "0" : line);
                    vehiculo.Id = ++s_ultimoId;
                }
                //Se actualiza el archivo con el Id del vehículo actual
                {
                    using var sw = new StreamWriter("IdVehiculoUltimo.txt");
                    sw.WriteLine(s_ultimoId);
                }
                //Se agrega el nuevo vehículo al repositorio
                {
                    using var sw = new StreamWriter(_nombreRepositorio, true);
                    sw.WriteLine(vehiculo.AStringParaTxt());
                }
                //Se añade el vehículo a la lista de vehículos del titular
                titular.ListaVehiculos.Add(vehiculo);
                var modificarTit = new ModificarTitularUseCase(new RepositorioTitular());

                //Se modifica el repositorio de titulares con el titular con el vehículo nuevo
                modificarTit.Ejecutar(titular);
            }
        }
        else
        {
            throw new ArgumentException($"El vehículo de dominio {vehiculo.Dominio} ya existe");
        }
    }

    public void EliminarVehiculo(int id)
    {
        List<Vehiculo> list = ListarVehiculos();

        //Se encuentra al vehículo con el Id = vehiculo.Id
        var vehiculo = list.Find(v => v.Id == id);

        //Si el vehículo no existe (el resultado de Find es null) se lanza una excepción
        if (vehiculo == null)
        {
            throw new ArgumentException($"El vehículo de id {id} no existe");
        }
        else
        {
            //Se elimina el vehículo
            list.Remove(vehiculo);

            //Se escribe la lista actualizada en el repositorio
            using var sw = new StreamWriter(_nombreRepositorio);
            foreach (Vehiculo v in list)
            {
                sw.WriteLine(v.AStringParaTxt());
            }

            //Se encuentra el titular del vehículo eliminado
            var listarTit = new ListarTitularesUseCase(new RepositorioTitular());
            List<Titular> lTit = listarTit.Ejecutar();
            var titular = lTit.Find(t => t.Id == vehiculo.TitularId);

            //Si el titular no existe (el resultado de Find es null) se lanza una excepción
            if (titular != null)
            {
                //Se elimina el vehículo de la lista de vehículos del titular
                titular.ListaVehiculos.RemoveAll(v => v.Id == vehiculo.Id);
                var modificarTit = new ModificarTitularUseCase(new RepositorioTitular());

                //Se modifica el repositorio de titulares con el titular sin el vehículo eliminado
                modificarTit.Ejecutar(titular);
            }
            else
            {
                throw new Exception($"El titular de id {vehiculo.TitularId} no existe");
            }
        }
    }

    public void ModificarVehiculo(Vehiculo vehiculo)
    {
        List<Vehiculo> list = ListarVehiculos();
        int index = list.FindIndex(v => v.Dominio == vehiculo.Dominio);

        //Se busca el vehículo, en caso de no encontrarse (el resultado de FindIndex es -1), se lanza una excepción
        if (index == -1)
        {
            throw new ArgumentException($"El vehículo de dominio {vehiculo.Dominio} no existe");
        }
        else
        {
            Vehiculo vehiculoAnterior = list[index];

            //Se mantiene el Id del vehículo previo
            vehiculo.Id = vehiculoAnterior.Id;

            //En caso de que se haya modificado el titular...
            if (vehiculo.TitularId != vehiculoAnterior.TitularId)
            {
                //Se encuentra al titular del vehículo anterior
                var listarTit = new ListarTitularesUseCase(new RepositorioTitular());
                List<Titular> lTit = listarTit.Ejecutar();
                var titularAnterior = lTit.Find(t => t.Id == vehiculoAnterior.TitularId);

                //Si no existe se lanza una excepción
                if (titularAnterior != null)
                {
                    //Se elimina el vehículo de la lista de vehículos del titular anterior
                    titularAnterior.ListaVehiculos.RemoveAll(v => v.Id == vehiculoAnterior.Id);
                    var modificarTit = new ModificarTitularUseCase(new RepositorioTitular());

                    //Se modifica el repositorio de titulares con el titular anterior sin el vehículo modificado
                    modificarTit.Ejecutar(titularAnterior);
                }
                else
                {
                    throw new Exception($"El titular de id {vehiculo.TitularId} no existe");
                }

                //Se encuentra al titular del nuevo vehículo
                var titular = lTit.Find(t => t.Id == vehiculo.TitularId);

                //Si no existe se lanza una excepción
                if (titular != null)
                {
                    //Se añade el vehículo de la lista de vehículos del nuevo titular
                    titular.ListaVehiculos.Add(vehiculo);
                    var modificarTit = new ModificarTitularUseCase(new RepositorioTitular());

                    //Se modifica el repositorio de titulares con el nuevo titular con el vehículo modificado
                    modificarTit.Ejecutar(titular);
                }
                else
                {
                    throw new Exception($"El titular de id {vehiculo.TitularId} no existe");
                }
            }
            //Se modifica el vehículo en la lista de vehículos
            list[index] = vehiculo;

            //Se escribe la lista actualizada en el repositorio
            using var sw = new StreamWriter(_nombreRepositorio);
            foreach (Vehiculo v in list)
            {
                sw.WriteLine(v.AStringParaTxt());
            }
        }
    }

    public List<Vehiculo> ListarVehiculos()
    {
        //Cada vehículo del repositorio se añade a la variable list
        using var sr = new StreamReader(_nombreRepositorio);
        var list = new List<Vehiculo>();
        string linea;
        while (!sr.EndOfStream)
        {
            linea = sr.ReadLine() ?? "";
            list.Add(new Vehiculo(linea));
        }
        return list;
    }
}