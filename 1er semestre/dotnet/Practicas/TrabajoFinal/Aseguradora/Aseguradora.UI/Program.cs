using Microsoft.AspNetCore.Components;
using Microsoft.AspNetCore.Components.Web;
using Aseguradora.UI.Data;

using Aseguradora.Repositorios;
using Aseguradora.Aplicacion.UseCases;
using Aseguradora.Aplicacion.Interfaces;

var builder = WebApplication.CreateBuilder(args);

// Add services to the container.
builder.Services.AddRazorPages();
builder.Services.AddServerSideBlazor();
builder.Services.AddSingleton<WeatherForecastService>();

// Agregamos servicios para agregar entidades
builder.Services.AddTransient<AgregarPolizaUseCase>();
builder.Services.AddTransient<AgregarTitularUseCase>();
builder.Services.AddTransient<AgregarVehiculoUseCase>();
builder.Services.AddTransient<AgregarTerceroUseCase>();
builder.Services.AddTransient<AgregarSiniestroUseCase>();

// Agregamos servicios para modificar entidades
builder.Services.AddTransient<ModificarPolizaUseCase>();
builder.Services.AddTransient<ModificarTitularUseCase>();
builder.Services.AddTransient<ModificarVehiculoUseCase>();
builder.Services.AddTransient<ModificarTerceroUseCase>();
builder.Services.AddTransient<ModificarSiniestroUseCase>();

// Agregamos servicios para eliminar entidades
builder.Services.AddTransient<EliminarPolizaUseCase>();
builder.Services.AddTransient<EliminarTitularUseCase>();
builder.Services.AddTransient<EliminarVehiculoUseCase>();
builder.Services.AddTransient<EliminarTerceroUseCase>();
builder.Services.AddTransient<EliminarSiniestroUseCase>();

// Agregamos servicios para listar entidades
builder.Services.AddTransient<ListarPolizasUseCase>();
builder.Services.AddTransient<ListarTitularesUseCase>();
builder.Services.AddTransient<ListarTitularesConSusVehiculosUseCase>();
builder.Services.AddTransient<ListarVehiculosUseCase>();
builder.Services.AddTransient<ListarTercerosUseCase>();
builder.Services.AddTransient<ListarSiniestrosUseCase>();

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
