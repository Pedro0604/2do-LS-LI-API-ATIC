namespace Aseguradora.Aplicacion;

public class Titular : Persona
{
    public string? Direccion { get; set; }
    public string? Email { get; set; }
    public List<Vehiculo> ListaVehiculos { get; set; } = new List<Vehiculo>();

    protected Titular() { }

    //Constructor que recibe un string con la información del Titular con el formato que tienen los repositorios
    public Titular(string strFromText) : base(strFromText.Split('|'))
    {
        try
        {
            //Se transforma el string en un string[], separandolo por el caracter '|'
            string[] infoTitular = strFromText.Split('|');

            //Se setean las propiedades del Titular
            Direccion = infoTitular[5];
            Email = infoTitular[6];
            string vehiculos = infoTitular[7];
            if (vehiculos != "")
            {
                string[] lVehiculos = vehiculos.Split(';');
                foreach (string v in lVehiculos)
                {
                    ListaVehiculos.Add(new Vehiculo(v, '~'));
                }
            }
        }
        catch
        {
            Console.WriteLine("El formato de la cadena enviada no corresponde con el de un titular");
        }
    }

    //Constructor para inicializar las propiedades
    //que recibe obligatoriamente: dni, apellido y nombre
    //y opcionalmente: direccion y email
    //Llama al constructor de su clase base
    public Titular(int dni, string? apellido, string? nombre, string? telefono = "", string? direccion = "", string? email = "") : base(dni, apellido, nombre, telefono)
    {
        this.Direccion = direccion;
        this.Email = email;
    }

    public override string ToString()
    {
        string st = $"Titular: | {base.ToString()}";
        st += this.Direccion != "" ? $" - Direccion: {this.Direccion}" : "";
        st += this.Email != "" ? $" - Correo electronico: {this.Email}" : "";
        return st;
    }

    //Se transforma el Titular en un string con el formato que tienen los repositorios
    public override string AStringParaTxt()
    {
        string st = $"{base.AStringParaTxt()}|{this.Direccion}|{this.Email}|";
        foreach (Vehiculo v in ListaVehiculos)
        {
            st += v.AStringParaTxt('~') + ";";
        }
        st.Remove(st.Count() - 1);
        return st;
    }
}