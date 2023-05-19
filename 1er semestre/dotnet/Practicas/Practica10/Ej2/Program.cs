int[] vector = new int[] { 1, 3, 4, 5, 9, 4, 3, 4, 5, 1, 1, 4, 9, 4, 3, 1 };
vector.GroupBy(n => n)
.ToList()
.Select(g =>
{
    var obj = new
    {
        Numero = g.Key,
        Cantidad = g.Count()
    };
    return obj;
})
.OrderBy(o => o.Cantidad)
.ToList()
.ForEach(obj => Console.WriteLine(obj));
