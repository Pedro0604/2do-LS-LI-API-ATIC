namespace Aseguradora.Aplicacion;

public class AgregarTitularUseCase
{
    private readonly IRepositorioTitular _repositorio;
    private static int s_ultimoId { get; set; }

    public AgregarTitularUseCase(IRepositorioTitular repositorio) => this._repositorio = repositorio;

    public void Ejecutar(Titular titular)
    {
        using var sr = new StreamReader("IdTitularUltimo.txt");
        string line = sr.ReadLine() ?? "0";
        s_ultimoId = int.Parse(line == "" ? "0" : line);
        titular.Id = ++s_ultimoId;
        using var sw = new StreamWriter("IdTitularUltimo.txt");
        sw.WriteLine(s_ultimoId);
        _repositorio.AgregarTitular(titular);
    }
}