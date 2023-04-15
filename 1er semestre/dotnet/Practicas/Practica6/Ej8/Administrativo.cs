namespace Ej8;

class Administrativo : Empleado
{
    public double Premio { get; set; }
    public override double Salario { get; }

    public Administrativo(string nombre, int dni, DateTime fechaDeIngreso, double salarioBase) : base(nombre, dni, fechaDeIngreso, salarioBase)
    {
        Salario = salarioBase + Premio;
    }

    public override void AumentarSalario()
    {
        SalarioBase += 0.01 * SalarioBase * ((DateTime.Now - this.FechaDeIngreso).Days / 365);
    }
}