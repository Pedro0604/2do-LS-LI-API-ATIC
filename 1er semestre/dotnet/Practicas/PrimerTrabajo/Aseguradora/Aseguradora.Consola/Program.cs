using Aseguradora.Aplicacion;
using Aseguradora.Repositorios;

//creamos los casos de uso inyectando dependencias
RepositorioTitular repoTitular = new RepositorioTitular();
AgregarTitularUseCase agregarTitular = new AgregarTitularUseCase(repoTitular);
ListarTitularesUseCase listarTitulares = new ListarTitularesUseCase(repoTitular);
ModificarTitularUseCase modificarTitular = new ModificarTitularUseCase(repoTitular);
EliminarTitularUseCase eliminarTitular = new EliminarTitularUseCase(repoTitular);
//Instanciamos un titular
Titular titular = new Titular(33123456, "García", "Juan")
{
    Direccion = "13 nro. 546",
    Telefono = "221-456456",
    Email = "joseGarcia@gmail.com"
};
Console.WriteLine($"Id del titular recién instanciado: {titular.Id}");
//agregamos el titular utilizando un método local
PersistirTitular(titular);
//el id que corresponde al titular es establecido por el repositorio
Console.WriteLine($"Id del titular una vez persistido: {titular.Id}");
//agregamos unos titulares más
PersistirTitular(new Titular(20654987, "Rodriguez", "Ana"));
PersistirTitular(new Titular(31456444, "Alconada", "Fermín"));
PersistirTitular(new Titular(12345654, "Perez", "Cecilia"));
//listamos los titulares utilizando un método local
ListarTitulares();
//no debe ser posible agregar un titular con igual DNI que uno existente
Console.WriteLine("Intentando agregar un titular con DNI 20654987");
titular = new Titular(20654987, "Alvarez", "Alvaro");