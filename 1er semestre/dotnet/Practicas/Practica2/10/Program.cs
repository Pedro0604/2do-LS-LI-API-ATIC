const string format = "HH:mm:ss.fffffff";

long count = 0L;
DateTime start = DateTime.Now;
Console.WriteLine(start.ToString(format));

for (long i = 0L; i < 7388934384; i++)
{
    count += 1;
}

DateTime end = DateTime.Now;
Console.WriteLine(end.ToString(format));
Console.WriteLine("Total time: " + (end - start));
Console.ReadKey();