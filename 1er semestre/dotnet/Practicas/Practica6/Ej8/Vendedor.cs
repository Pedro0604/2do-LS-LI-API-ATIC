namespace Ej8;

class Vendedor : Empleado
{
    public double Comision { get; set; }
    public override double Salario { get; }

    public Vendedor(string nombre, int dni, DateTime fechaDeIngreso, double salarioBase) : base(nombre, dni, fechaDeIngreso, salarioBase)
    {
        Salario = salarioBase + Comision;
    }

    public override void AumentarSalario()
    {
        SalarioBase += SalarioBase * (((DateTime.Now - this.FechaDeIngreso).Days / 365) < 10 ? 0.05 : 0.1);
    }
}