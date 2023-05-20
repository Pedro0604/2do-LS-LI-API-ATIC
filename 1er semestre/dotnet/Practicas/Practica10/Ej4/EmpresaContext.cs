using Microsoft.EntityFrameworkCore;

namespace Ej4;

public class EmpresaContext: DbContext
{
    #nullable disable
    public DbSet<Cliente> Clientes { get; set; }
    public DbSet<Juego> Juegos { get; set; }
    public DbSet<Alquiler> Alquileres { get; set; }
    #nullable restore
    
    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
    {
        optionsBuilder.UseSqlite("data source=Empresa.sqlite");
    }
}