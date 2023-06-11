using Aseguradora.Repositorios;
using Aseguradora.Aplicacion.UseCases;
using Aseguradora.Aplicacion.Interfaces;

var builder = WebApplication.CreateBuilder(args);

// Add services to the container.
builder.Services.AddRazorPages();
builder.Services.AddServerSideBlazor();

// Agregamos servicios para agregar entidades
builder.Services.AddTransient<AgregarTitularUseCase>();
builder.Services.AddTransient<AgregarVehiculoUseCase>();
builder.Services.AddTransient<AgregarPolizaUseCase>();
builder.Services.AddTransient<AgregarSiniestroUseCase>();
builder.Services.AddTransient<AgregarTerceroUseCase>();

// Agregamos servicios para modificar entidades
builder.Services.AddTransient<ModificarTitularUseCase>();
builder.Services.AddTransient<ModificarVehiculoUseCase>();
builder.Services.AddTransient<ModificarPolizaUseCase>();
builder.Services.AddTransient<ModificarSiniestroUseCase>();
builder.Services.AddTransient<ModificarTerceroUseCase>();

// Agregamos servicios para eliminar entidades
builder.Services.AddTransient<EliminarTitularUseCase>();
builder.Services.AddTransient<EliminarVehiculoUseCase>();
builder.Services.AddTransient<EliminarPolizaUseCase>();
builder.Services.AddTransient<EliminarSiniestroUseCase>();
builder.Services.AddTransient<EliminarTerceroUseCase>();

// Agregamos servicios para listar entidades
builder.Services.AddTransient<ListarTitularesUseCase>();
builder.Services.AddTransient<ListarVehiculosUseCase>();
builder.Services.AddTransient<ListarPolizasUseCase>();
builder.Services.AddTransient<ListarSiniestrosUseCase>();
builder.Services.AddTransient<ListarTercerosUseCase>();

// Agregamos servicios para obtener una entidad
builder.Services.AddTransient<GetTitularUseCase>();
builder.Services.AddTransient<GetVehiculoUseCase>();
builder.Services.AddTransient<GetPolizaUseCase>();
builder.Services.AddTransient<GetSiniestroUseCase>();
builder.Services.AddTransient<GetTerceroUseCase>();

// Agregamos los servicios de los repositorios
builder.Services.AddScoped<IRepositorioPoliza, RepositorioPoliza>();
builder.Services.AddScoped<IRepositorioTitular, RepositorioTitular>();
builder.Services.AddScoped<IRepositorioVehiculo, RepositorioVehiculo>();
builder.Services.AddScoped<IRepositorioTercero, RepositorioTercero>();
builder.Services.AddScoped<IRepositorioSiniestro, RepositorioSiniestro>();

EnsureCreated.Ensure();

var app = builder.Build();

// Configure the HTTP request pipeline.
if (!app.Environment.IsDevelopment())
{
    app.UseExceptionHandler("/Error");
}


app.UseStaticFiles();

app.UseRouting();

app.MapBlazorHub();
app.MapFallbackToPage("/_Host");

app.Run();
