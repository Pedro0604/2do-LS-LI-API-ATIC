using Ej4;

using (var context = new EmpresaContext())
{
    context.Database.EnsureCreated();
}

var juego1 = new Juego()
{
    Nombre = "Cama Elastica",
    Descripcion = "Medida de 2 x 2",
    Estado = "Bueno",
    PrecioPorDia = 1000
};
var juego2 = new Juego()
{
    Nombre = "Castillo",
    Descripcion = "Hasta 10 personas",
    Estado = "Nuevo",
    PrecioPorDia = 1200
};
Agregar(juego1);
Agregar(juego2);
ListarJuegos();
var cliente1 = new Cliente()
{
    DNI = "20569784",
    ApellidoYNombre = "Perez, Juan",
    Direccion = "48 e/ 5 y 6 N°520"
};
var cliente2 = new Cliente()
{
    DNI = "10569784",
    ApellidoYNombre = "Gonzalez, Alejandra",
    Direccion = "25 e/ 9 y 10 N°520",
    Mail = "gale@gmail.com",
    Telefono = "221-15-569874"
};
Agregar(cliente1);
Agregar(cliente2);
ListarClientes();
var alquiler1 = new Alquiler()
{
    ClienteId = 1,
    JuegoId = 1,
    Fecha = DateTime.Now
};
var alquiler2 = new Alquiler()
{
    ClienteId = 1,
    JuegoId = 2,
    Fecha = DateTime.Now
};
Agregar(alquiler1);
Agregar(alquiler2);
ListarAlquileres();
ModificarCliente("10569784", "Gonzalez, Alejandra", "52 e/ 9 y 10 N°520", "gale@gmail.com",
"221-15-569874");
ListarClientes();
EliminarCliente("10569784");
ListarClientes();
ModificarJuego(1, "Cama Elastica", "Medida de 2 x 2", "Roto", 1500);
ListarJuegos();
ModificarAlquiler(1, 1562.25, new DateTime(2021, 11, 12));
ListarAlquileres();




void Agregar<T>(T obj)
{
    Console.WriteLine("-- Se agregó el " + obj.GetType() + " exitosamente.");
    using (var context = new EmpresaContext())
    {
        context.Add(obj);
        context.SaveChanges();
    }
}

void ListarClientes()
{
    Console.WriteLine($"-- Listado de clientes --");
    using (var context = new EmpresaContext())
    {
        foreach (Cliente c in context.Clientes)
        {
            Console.WriteLine($"Id = {c.Id}, DNI = {c.DNI}, Nombre = {c.ApellidoYNombre}, Dirección = {c.Direccion}, Tel = {c.Telefono}, Mail = {c.Mail}");
        }
    }
}

void ListarJuegos()
{
    Console.WriteLine($"-- Listado de juegos --");
    using (var context = new EmpresaContext())
    {
        foreach (Juego j in context.Juegos)
        {
            Console.WriteLine($"Id = {j.Id}, Nombre = {j.Nombre}, Descripción = {j.Descripcion}, Estado = {j.Estado}, Precio por día = {j.PrecioPorDia}");
        }
    }
}

void ListarAlquileres()
{
    Console.WriteLine($"-- Listado de alquileres --");
    using (var context = new EmpresaContext())
    {
        foreach (Alquiler a in context.Alquileres)
        {
            Console.WriteLine($"Id = {a.Id}, Fecha = {a.Fecha.ToShortDateString()}, Fecha de devolución = {a.FechaDevolucion.ToShortDateString()}, Cleinte = {context.Clientes.Where(c => c.Id == a.ClienteId).SingleOrDefault()?.ApellidoYNombre}, Juego = {context.Juegos.Where(j => j.Id == a.JuegoId).SingleOrDefault()?.Nombre}, Costo total = {a.CostoTotal}");
        }
    }
}

void EliminarCliente(string dni)
{
    using (var context = new EmpresaContext())
    {
        var clElim = context.Clientes
        .Where(c => c.DNI == dni).SingleOrDefault();
        if (clElim != null)
        {
            context.Remove(clElim);
        }
        context.SaveChanges();
    }
    Console.WriteLine($"-- Se eliminó el cliente con dni {dni} --");
}

void ModificarCliente(string dni, string apyn, string dir, string email, string tel)
{
    using (var context = new EmpresaContext())
    {
        var clMod = context.Clientes
        .Where(c => c.DNI == dni).SingleOrDefault();
        if (clMod != null)
        {
            clMod.ApellidoYNombre = apyn;
            clMod.Direccion = dir;
            clMod.Mail = email;
            clMod.Telefono = tel;
        }
        context.SaveChanges();
    }
    Console.WriteLine($"-- Se modificó el cliente con dni {dni} --");
}

void ModificarJuego(int id, string nom, string des, string estado, double ppd)
{
    using (var context = new EmpresaContext())
    {
        var jueMod = context.Juegos
        .Where(j => j.Id == id).SingleOrDefault();
        if (jueMod != null)
        {
            jueMod.Nombre = nom;
            jueMod.Descripcion = des;
            jueMod.Estado = estado;
            jueMod.PrecioPorDia = ppd;
        }
        context.SaveChanges();
    }
    Console.WriteLine($"-- Se modificó el Juego con id {id} --");
}

void ModificarAlquiler(int id, double costo, DateTime fec)
{
    using (var context = new EmpresaContext())
    {
        var alqMod = context.Alquileres
        .Where(a => a.Id == id).SingleOrDefault();
        if (alqMod != null)
        {
            alqMod.CostoTotal = costo;
            alqMod.FechaDevolucion = fec;
        }
        context.SaveChanges();
    }
    Console.WriteLine($"-- Se modificó el alquiler con id {id} --");
}