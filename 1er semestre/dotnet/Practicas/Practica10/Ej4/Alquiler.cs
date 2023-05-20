namespace Ej4;

public class Alquiler
{
    public int Id { get; set; }
    public int IdCliente { get; set; }
    public int IdJuego { get; set; }
    public DateTime Fecha { get; set; }
    public DateTime FechaTentativaDevolucion { get; set; }
    public DateTime FechaDevolucion { get; set; }
    public double CostoTotal { get; set; }
}