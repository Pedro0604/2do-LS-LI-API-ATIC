namespace Aseguradora.Aplicacion;

public class AgregarPolizaUseCase
{
    private readonly IRepositorioPoliza _repositorio;
    private static int s_ultimoId { get; set; }

    public AgregarPolizaUseCase(IRepositorioPoliza repositorio) => this._repositorio = repositorio;

    public void Ejecutar(Poliza poliza)
    {
        using var sr = new StreamReader("IdPolizaUltimo.txt");
        string line = sr.ReadLine() ?? "0";
        s_ultimoId = int.Parse(line == "" ? "0" : line);
        poliza.Id = ++s_ultimoId;
        using var sw = new StreamWriter("IdPolizaUltimo.txt");
        sw.WriteLine(s_ultimoId);
        _repositorio.AgregarPoliza(poliza);
    }
}