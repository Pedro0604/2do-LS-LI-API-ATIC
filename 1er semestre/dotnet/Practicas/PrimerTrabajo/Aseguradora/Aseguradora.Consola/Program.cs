using Aseguradora.Aplicacion;
using Aseguradora.Repositorios;

//creamos los casos de uso del repositorio de titulares inyectando dependencias
RepositorioTitular repoTitular = new RepositorioTitular();
AgregarTitularUseCase agregarTitular = new AgregarTitularUseCase(repoTitular);
ListarTitularesUseCase listarTitulares = new ListarTitularesUseCase(repoTitular);
ModificarTitularUseCase modificarTitular = new ModificarTitularUseCase(repoTitular);
EliminarTitularUseCase eliminarTitular = new EliminarTitularUseCase(repoTitular);
ListarTitularesConSusVehiculosUseCase listarTitularesConSusVehiculos = new ListarTitularesConSusVehiculosUseCase(repoTitular);

//creamos los casos de uso del repositorio de pólizas inyectando dependencias
RepositorioPoliza repoPoliza = new RepositorioPoliza();
AgregarPolizaUseCase agregarPoliza = new AgregarPolizaUseCase(repoPoliza);
ListarPolizasUseCase listarPolizas = new ListarPolizasUseCase(repoPoliza);
ModificarPolizaUseCase modificarPoliza = new ModificarPolizaUseCase(repoPoliza);
EliminarPolizaUseCase eliminarPoliza = new EliminarPolizaUseCase(repoPoliza);

//creamos los casos de uso del repositorio de vehículos inyectando dependencias
RepositorioVehiculo repoVehiculo = new RepositorioVehiculo();
AgregarVehiculoUseCase agregarVehiculo = new AgregarVehiculoUseCase(repoVehiculo);
ListarVehiculosUseCase listarVehiculos = new ListarVehiculosUseCase(repoVehiculo);
ModificarVehiculoUseCase modificarVehiculo = new ModificarVehiculoUseCase(repoVehiculo);
EliminarVehiculoUseCase eliminarVehiculo = new EliminarVehiculoUseCase(repoVehiculo);




//Agregamos varios titulares al repositorio:
Console.WriteLine("Agregando titulares al repositorio...");
PersistirTitular(new Titular(12345678, "Gutierrez", "Ignacio", "221-456-7890", "1 n° 2345", "nachoGutierrez@gmail.com"));
PersistirTitular(new Titular(23457654, "Dominguez", "Juana", "221-238-7814", "20 n° 2121", "dominguezJuana07@hotmail.com"));
PersistirTitular(new Titular(20645123, "Prieto", "Lucio", "221-456-2947", "10 n° 9876", "luchoPrieto@gmail.com"));
PersistirTitular(new Titular(17815456, "De la Fuente", "Dante", direccion: "13 n° 34", email: "DelaFuenteDan@gmail.com"));
PersistirTitular(new Titular(5123456, "Arias", "María", "221-408-0976", email: "MarAri@outlook.com"));
PersistirTitular(new Titular(98765432, "Valdez", "Susana", "223-523-5065", "25 n° 3847"));
PersistirTitular(new Titular(45613789, "Tronchatoro", "Mabel", "221-412-5328"));
PersistirTitular(new Titular(43254012, "Díaz", "Ricardo"));
PersistirTitular(new Titular(44858017, "Cucano", "Esteban", direccion: "Av. San Martin n°28"));
Console.WriteLine("Titulares agregados");

//Listamos titulares:
ListarTitulares();

//Intentamos agregar un titular con un DNI ya existente:
Console.WriteLine("Agregando un titular con un DNI ya existente (12345678)");
PersistirTitular(new Titular(12345678, "Gatti", "Abril"));

//Intentamos modificar un titular con un DNI que no existe:
Console.WriteLine("Modificando un titular con un DNI que no existe (0)");
ModificarTitular(new Titular(0, "Rodríguez", "Eugenia"));

//Modificamos un titular existente:
Console.WriteLine("Modificando al titular con DNI: 12345678");
ModificarTitular(new Titular(12345678, "Gatti", "Abril"));

//Listamos titulares:
ListarTitulares();

//Intentamos eliminar un titular con un id que no existe:
Console.WriteLine("Eliminando al titular con id que no existe (400)");
EliminarTitular(400);

//Modificamos un titular existente:
Console.WriteLine("Eliminando al titular con id: 2");
EliminarTitular(2);

//Listamos titulares:
ListarTitulares();




//Agregamos varios vehículos al repositorio:
Console.WriteLine("Agregando vehículos al repositorio...");
PersistirVehiculo(new Vehiculo("ABC-123", "Renault", 1, 2007));
PersistirVehiculo(new Vehiculo("AB-123-CD", "Fiat", 1, 2018));
PersistirVehiculo(new Vehiculo("XYZ-789", "Citroen", 3, 2010));
PersistirVehiculo(new Vehiculo("AA-000-AA", "Ford", 4, 2022));
PersistirVehiculo(new Vehiculo("RWT-845", "Chevrolet", 5, 2012));
PersistirVehiculo(new Vehiculo("GIX-601", "Suzuki", 6, 1996));
PersistirVehiculo(new Vehiculo("HOI-529", "Honda", 7, 2014));
PersistirVehiculo(new Vehiculo("AF-138-WH", "Audi", 8));
PersistirVehiculo(new Vehiculo("CWE-814", "BMW", 9));
Console.WriteLine("Vehículos agregados");

//Listamos vehículos:
ListarVehiculos();

//Intentamos agregar un vehículo con un dominio ya existente:
Console.WriteLine("Agregando un vehículo con un dominio ya existente (ABC-123)");
PersistirVehiculo(new Vehiculo("ABC-123", "Hyundai", 7));

//Intentamos agregar un vehículo con un id de titular que no existe:
Console.WriteLine("Agregando un vehículo con id de titular que no existe (400)");
PersistirVehiculo(new Vehiculo("ABC-111", "Hyundai", 400));

//Intentamos modificar un vehículo con un dominio que no existe:
Console.WriteLine("Modificando un vehículo con un dominio que no existe (ZZZ-000)");
ModificarVehiculo(new Vehiculo("ZZZ-000", "Alfa romeo", 3));

//Modificamos un vehículo existente:
Console.WriteLine("Modificando al vehículo con dominio: ABC-123");
ModificarVehiculo(new Vehiculo("ABC-123", "Hyundai", 7));

//Listamos vehículos:
ListarVehiculos();

//Intentamos eliminar un vehículo con un id que no existe:
Console.WriteLine("Eliminando al vehículo con id que no existe (400)");
EliminarVehiculo(400);

//Modificamos un vehículo existente:
Console.WriteLine("Eliminando al vehículo con id: 3");
EliminarVehiculo(3);

//Listamos vehículos:
ListarVehiculos();

//Listamos todos los titlulares con sus vehículos:
ListarTitularesConSusVehiculos();




//Agregamos varias pólizas al repositorio:
Console.WriteLine("Agregando pólizas al repositorio...");
PersistirPoliza(new Poliza(1, 200000.0, new DateTime(2020, 11, 10), new DateTime(2023, 11, 10), 30000.0, "Responsabilidad Civil Bienes y Personas"));
PersistirPoliza(new Poliza(3, 180000.0, new DateTime(2018, 1, 19), new DateTime(2024, 1, 19), 20000.0, "Responsabilidad Civil Catastrófica"));
PersistirPoliza(new Poliza(3, 500000.0, new DateTime(2022, 3, 30), new DateTime(2024, 3, 30), 50000.0, "Asistencia vial y viajes"));
PersistirPoliza(new Poliza(4, 100000.0, new DateTime(2021, 4, 6), new DateTime(2024, 4, 6), 10000.0, "Defensa jurídica"));
PersistirPoliza(new Poliza(5, 1000000.0, new DateTime(2014, 1, 7), new DateTime(2023, 7, 1), 70000.0, "Gastos médicos a ocupantes"));
PersistirPoliza(new Poliza(6, 50000.0, new DateTime(2023, 4, 26), new DateTime(2024, 4, 26), 50000.0, "Robo Total"));
PersistirPoliza(new Poliza(7, 300000.0, new DateTime(2019, 3, 23), new DateTime(2024, 3, 23), 15000.0, "Daños materiales"));
PersistirPoliza(new Poliza(8, 270000.0, new DateTime(2011, 7, 31), new DateTime(2023, 7, 31), 40000.0));
PersistirPoliza(new Poliza(9, 120000.0, new DateTime(2017, 12, 12), new DateTime(2023, 12, 12), 35000.0));
Console.WriteLine("Pólizas agregadas");

//Listamos pólizas:
ListarPolizas();

//Intentamos agregar una póliza con un id ya existente:
Console.WriteLine("Agregando una póliza con un id ya existente (3)");
Poliza poliza = new Poliza(9, 120000.0, new DateTime(2017, 12, 12), new DateTime(2023, 12, 12), 35000.0);
poliza.Id = 3;
PersistirPoliza(poliza);

//Intentamos agregar una póliza con un id de vehículo que no existe:
Console.WriteLine("Agregando una póliza con id de vehículo que no existe (400)");
PersistirPoliza(new Poliza(400, 400000.0, new DateTime(2015, 7, 15), new DateTime(2023, 7, 15), 25000.0));

//Intentamos modificar una póliza con un id que no existe:
Console.WriteLine("Modificando una póliza con un id que no existe (400)");
poliza.Id = 400;
ModificarPoliza(poliza);

//Modificamos una póliza existente:
Console.WriteLine("Modificando a la póliza con id: 7");
poliza = new Poliza(2, 150000.0, new DateTime(2017, 12, 12), new DateTime(2023, 12, 12), 40000.0);
poliza.Id = 7;
ModificarPoliza(poliza);

//Listamos pólizas:
ListarPolizas();

//Intentamos eliminar una póliza con un id que no existe:
Console.WriteLine("Eliminando a la póliza con id que no existe (400)");
EliminarPoliza(400);

//Modificamos una póliza existente:
Console.WriteLine("Eliminando a la póliza con id: 2");
EliminarPoliza(2);

//Listamos pólizas:
ListarPolizas();










//Metodos locales para titulares
void PersistirTitular(Titular t)
{
    try
    {
        agregarTitular.Ejecutar(t);
    }
    catch (Exception e)
    {
        Console.WriteLine(e.Message);
    }
}
void EliminarTitular(int id)
{
    try
    {
        eliminarTitular.Ejecutar(id);
    }
    catch (Exception e)
    {
        Console.WriteLine(e.Message);
    }
}
void ModificarTitular(Titular t)
{
    try
    {
        modificarTitular.Ejecutar(t);
    }
    catch (Exception e)
    {
        Console.WriteLine(e.Message);
    }
}
void ListarTitulares()
{
    Console.WriteLine("Listando todos los titulares de vehículos:");
    List<Titular> lista = listarTitulares.Ejecutar();
    foreach (Titular t in lista)
    {
        Console.WriteLine(t);
    }
}
void ListarTitularesConSusVehiculos()
{
    Console.WriteLine("Listando todos los titulares con sus vehículos:");
    List<string> lista = listarTitularesConSusVehiculos.Ejecutar();
    foreach (string st in lista)
    {
        Console.WriteLine(st);
    }
}

//Metodos locales para vehiculos
void PersistirVehiculo(Vehiculo v)
{
    try
    {
        agregarVehiculo.Ejecutar(v);
    }
    catch (Exception e)
    {
        Console.WriteLine(e.Message);
    }
}
void EliminarVehiculo(int id)
{
    try
    {
        eliminarVehiculo.Ejecutar(id);
    }
    catch (Exception e)
    {
        Console.WriteLine(e.Message);
    }
}
void ModificarVehiculo(Vehiculo v)
{
    try
    {
        modificarVehiculo.Ejecutar(v);
    }
    catch (Exception e)
    {
        Console.WriteLine(e.Message);
    }
}
void ListarVehiculos()
{
    Console.WriteLine("Listando todos los vehículos:");
    List<Vehiculo> lista = listarVehiculos.Ejecutar();
    foreach (Vehiculo t in lista)
    {
        Console.WriteLine(t);
    }
}

//Metodos locales para polizas
void PersistirPoliza(Poliza p)
{
    try
    {
        agregarPoliza.Ejecutar(p);
    }
    catch (Exception e)
    {
        Console.WriteLine(e.Message);
    }
}
void EliminarPoliza(int id)
{
    try
    {
        eliminarPoliza.Ejecutar(id);
    }
    catch (Exception e)
    {
        Console.WriteLine(e.Message);
    }
}
void ModificarPoliza(Poliza p)
{
    try
    {
        modificarPoliza.Ejecutar(p);
    }
    catch (Exception e)
    {
        Console.WriteLine(e.Message);
    }
}
void ListarPolizas()
{
    Console.WriteLine("Listando todas las polizas de vehículos:");
    List<Poliza> lista = listarPolizas.Ejecutar();
    foreach (Poliza t in lista)
    {
        Console.WriteLine(t);
    }
}