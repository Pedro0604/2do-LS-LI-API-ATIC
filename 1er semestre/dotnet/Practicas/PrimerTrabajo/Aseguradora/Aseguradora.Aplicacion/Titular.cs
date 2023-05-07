namespace Aseguradora.Aplicacion;

public class Titular : Persona
{
    public string? Direccion { get; set; }
    public string? CorreoElectronico { get; set; }
    public List<Vehiculo> ListaVehiculos { get; set; }

    public Titular()
    {
        ListaVehiculos = new List<Vehiculo>();
    }

    public Titular(string strFromText) : base(strFromText.Split('|'))
    {
        ListaVehiculos = new List<Vehiculo>();
        try
        {
            var infoPoliza = strFromText.Split('|');
            Direccion = infoPoliza[5];
            CorreoElectronico = infoPoliza[6];
            string vehiculos = infoPoliza[7];
            string[] lVehiculos = vehiculos.Split(';');
            foreach (string v in lVehiculos)
            {
                ListaVehiculos.Add(new Vehiculo(v));
            }
        }
        catch
        {
            Console.WriteLine("El formato de la cadena enviada no corresponde con el de un titular");
        }
    }

    public override string ToString()
    {
        return $"Titular: | {base.ToString()} - Direccion: {this.Direccion} - Correo electronico: {this.CorreoElectronico}";
    }
    public override string AStringParaTxt()
    {
        string st = $"{base.AStringParaTxt()}|{this.Direccion}|{this.CorreoElectronico}|";
        foreach (Vehiculo v in ListaVehiculos)
        {
            st += v.AStringParaTxt() + ";";
        }
        st.Remove(st.Count() - 1);
        return st;
    }
}