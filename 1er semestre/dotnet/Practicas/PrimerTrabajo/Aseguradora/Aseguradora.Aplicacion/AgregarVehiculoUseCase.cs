namespace Aseguradora.Aplicacion;

public class AgregarVehiculoUseCase
{
    private readonly IRepositorioVehiculo _repositorio;
    private static int s_ultimoId { get; set; }

    public AgregarVehiculoUseCase(IRepositorioVehiculo repositorio) => this._repositorio = repositorio;

    public void Ejecutar(Vehiculo vehiculo)
    {
        using var sr = new StreamReader("IdVehiculoUltimo.txt");
        string line = sr.ReadLine() ?? "0";
        s_ultimoId = int.Parse(line == "" ? "0" : line);
        vehiculo.Id = ++s_ultimoId;
        using var sw = new StreamWriter("IdVehiculoUltimo.txt");
        sw.WriteLine(s_ultimoId);
        _repositorio.AgregarVehiculo(vehiculo);
    }
}