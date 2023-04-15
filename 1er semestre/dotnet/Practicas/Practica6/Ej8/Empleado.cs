namespace Ej8;
abstract class Empleado
{
    public string? Nombre { get; }
    public int DNI { get; }
    public DateTime FechaDeIngreso { get; }
    public double SalarioBase { get; protected set; }
    public abstract double Salario { get; }

    public Empleado(string nombre, int dni, DateTime fechaDeIngreso, double salarioBase)
    {
        Nombre = nombre;
        DNI = dni;
        FechaDeIngreso = fechaDeIngreso;
        SalarioBase = salarioBase;
    }

    public abstract void AumentarSalario();

    public override string ToString()
    {
        return $"{this.GetType()} Nombre: {this.Nombre}, DNI: {this.DNI}, Antiguedad: {(DateTime.Now - this.FechaDeIngreso).Days / 365}\nSalario base: {this.SalarioBase}, Salario: {this.Salario}\n------------";
    }
}