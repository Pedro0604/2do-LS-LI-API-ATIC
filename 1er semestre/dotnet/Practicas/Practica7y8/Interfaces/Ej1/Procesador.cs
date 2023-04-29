namespace Ej1;

static class Procesador
{
    public static void Alquilar(IAlquilable x, Persona p) => x.AlquilarA(p);
    public static void Devolver(IAlquilable x, Persona p) => x.DevueltaPor(p);
    public static void Vender(IVendible x, Persona p) => x.VenderA(p);
    public static void Lavar(ILavable x) => x.Lavar();
    public static void Secar(ILavable x) => x.Secar();
    public static void Reciclar(IReciclable x) => x.Reciclar();
    public static void Atender(IAtendible x) => x.Atender();

}