import numpy as np

# "llegada1-{lote1}/llegada2-{lote2}/llegada3-{lote3}..."

ejercicio=input("Ingrese el número de ejercicio (13(default)/15/16): ")

# Ejercicio 13
inicio = "83"
previo = 75
requerimientosArray="0-86, 147, 91, 177, 94, 150, 102, 175, 130, 32, 120, 58, 66, 115"
maxRango = 199
if(ejercicio=="15"):
    # Ejercicio 15
    inicio = "143"
    previo = 125
    requerimientosArray="0-{126, 147, 81, 277, 94, 150, 212, 175, 140, 225, 280, 50, 99, 118, 22, 55}/30-{75, 115, 220, 266}"
    maxRango = 299
if(ejercicio=="16"):
    # Ejercicio 16
    inicio = "140"
    previo = 130
    requerimientosArray="0-{99, 110, 42, 25, 186, 270, 50, 99, 147PF, 81, 257, 94, 133, 212, 175, 130}/30-{85, 15PF, 202, 288}/70-{75, 149PF, 285, 201, 59}"
    maxRango = 299

print("")
print("#################################")
print(f"   Inicio: {inicio}")
print(f"   Previo: {previo}")
print(f"   Máximo valor del rango: {maxRango}")
print(f"   Requerimientos: {requerimientosArray}")
print("#################################")
print("")

algo=input("Ingrese el algoritmo(1=FCFS(default) - 2=SSTF - 3=SCAN - 4=LOOK - 5=C-SCAN - 6=C-LOOK): ")
if(algo not in ["1","2","3","4","5","6"]):
    algo=1
algo=int(algo)

requerimientosArray=requerimientosArray.split("/")
llegadas={}
for i in range(0, len(requerimientosArray)):
    llegadas[i]=int(requerimientosArray[i].split("-")[0])
    requerimientosArray[i]=requerimientosArray[i].split("-")[1]
    requerimientosArray[i]=requerimientosArray[i].removeprefix("{")
    requerimientosArray[i]=requerimientosArray[i].removesuffix("}")
    requerimientosArray[i]=requerimientosArray[i].split(", ")

llegadas[0]=-1
requerimientos=requerimientosArray[0]
requerimientosPageFault=[]
requerimientos.insert(0,inicio)

for requerimiento in requerimientos:
    if ("PF" in requerimiento or "pf" in requerimiento):
        requerimientos.remove(requerimiento)
        requerimientosPageFault.append(int(requerimiento.removesuffix("PF").removesuffix("pf")))


for i in range(0, len(requerimientosArray)):
    for j in range(0, len(requerimientosArray[i])):
        val=requerimientosArray[i][j]
        if ("PF" not in val and "pf" not in val):
            requerimientosArray[i][j]=int(val)


def indexClosest(actual, requerimientos, sentido, requerimientosPageFault):
    min=9999999
    index=0
    if len(requerimientosPageFault)==0:
        for i in range(0, len(requerimientos)):
            diff=requerimientos[i]-actual
            isClosest=False
            if(sentido=="asc"):
                isClosest=diff>0 and diff<min
            elif(sentido=="desc"):
                isClosest=diff<0 and abs(diff)<min
            else:
                isClosest=abs(diff)<min or (abs(diff)==min and i<index)
            if(isClosest):
                min=abs(diff)
                index=i
        if(min==9999999):
            return -1
    else:
        for i in range(0, len(requerimientosPageFault)):
            diff=requerimientosPageFault[i]-actual
            isClosest=False
            if(sentido=="asc"):
                isClosest=diff>0 and diff<min
            elif(sentido=="desc"):
                isClosest=diff<0 and abs(diff)<min
            else:
                isClosest=abs(diff)<min or (abs(diff)==min and i<index)
            if(isClosest):
                min=abs(diff)
                index=i
        if(sentido!="both" and min==9999999):
            for i in range(0, len(requerimientosPageFault)):
                diff=abs(requerimientosPageFault[i]-actual)
                if(diff<min or (diff==min and i<index)):
                    min=diff
                    index=i
    return index

def deleteRepeated(requerimientos):
    l = np.array(requerimientos)    
    unique_index = np.unique(l, return_index = True)[-1]
    return [l[i] for i in sorted(unique_index)]

def checkRequerimientosPendientes(requerimientos, llegadas, requerimientosArray, cantMov, requerimientosPageFault):
    for i in range(0, len(llegadas)):
        if(llegadas[i]!=-1 and llegadas[i]<=cantMov):
            print("---------------------------------")
            print(f"Llegó lote {i+1}(movimiento {llegadas[i]})")
            print("---------------------------------")
            llegadas[i]=-1
            requerimientos+=requerimientosArray[i]
            for requerimiento in requerimientosArray[i]:
                if ("PF" in str(requerimiento) or "pf" in str(requerimiento)):
                    requerimientos.remove(requerimiento)
                    requerimientosPageFault.insert(0,int(requerimiento.removesuffix("PF").removesuffix("pf")))
    return requerimientos

def printMovimiento(anterior, actual, pf):
    str=""
    if pf:
        str="PF"
    print("Desde: ",anterior," - Hasta: ",actual,str)
    print("Movimientos: ",abs(anterior-actual))
    print("#################################")
    return abs(anterior-actual)

cantMov=0
print("#################################")
print("#################################")
print("#################################")

pf=False

if(algo==1):
    longTotal = 0
    if len(requerimientosPageFault)>0:
        for j in range(0, len(requerimientosPageFault)):
            requerimientos.insert(j+1,requerimientosPageFault[-(j+1)])
            requerimientosPageFault.remove(requerimientosPageFault[j])

    for requerimiento in requerimientosArray:
        longTotal+=len(requerimiento)

    for i in range(0, longTotal-1):        
        cantMov += printMovimiento(requerimientos[i], requerimientos[i+1], pf)
        pf=False
        requerimientos = checkRequerimientosPendientes(requerimientos, llegadas, requerimientosArray, cantMov, requerimientosPageFault)
        if len(requerimientosPageFault)>0:
            pf=True
            for j in range(0, len(requerimientosPageFault)):
                requerimientos.insert(i+2,requerimientosPageFault[-(j+1)])
                requerimientosPageFault.remove(requerimientosPageFault[j])
elif(algo==2):
    requerimientos=deleteRepeated(requerimientos)
    anterior=requerimientos[0]
    actual=requerimientos[0]
    while(len(requerimientos)>1):
        if(pf):
            requerimientosPageFault.remove(actual)
            pf=False
        else:
            requerimientos.remove(actual)
        index=indexClosest(actual,requerimientos,"both",requerimientosPageFault)
        anterior=actual
        if(len(requerimientosPageFault)==0):
            actual=requerimientos[index]
        else:
            pf=True
            actual=requerimientosPageFault[index]

        cantMov += printMovimiento(anterior, actual, pf)
        requerimientos = checkRequerimientosPendientes(requerimientos, llegadas, requerimientosArray, cantMov, requerimientosPageFault)
elif(algo==3 or algo==4 or algo==5 or algo==6):
    requerimientos=deleteRepeated(requerimientos)
    anterior=requerimientos[0]
    actual=requerimientos[0]
    sentido="asc"
    if(previo>requerimientos[0]):
        sentido="desc"
    while(len(requerimientos)>1):
        if(actual!=maxRango and actual!=0):
            if(pf):
                requerimientosPageFault.remove(actual)
                pf=False
            else:
                requerimientos.remove(actual)
        index=indexClosest(actual,requerimientos,sentido,requerimientosPageFault)
        if(index!=-1):
            anterior=actual
            if(len(requerimientosPageFault)==0):
                actual=requerimientos[index]
            else:
                pf=True
                actual=requerimientosPageFault[index]
                if(algo==3 or algo==4):
                    if(anterior<=actual):
                        sentido="asc"
                    else:
                        sentido="desc"
        else:
            anterior=actual
            if(sentido=="asc"):
                if(algo==3 or algo==4):
                    sentido="desc"
                if(algo==3 or (algo==5 and actual!=maxRango)):
                    actual=maxRango
                elif(algo==5 and actual==maxRango):
                    anterior=0
                    actual=requerimientos[indexClosest(0,requerimientos,"asc",requerimientosPageFault)]
                else:
                    if(algo==4):
                        actual=requerimientos[indexClosest(actual,requerimientos,"desc",requerimientosPageFault)]
                    else:
                        anterior=requerimientos[indexClosest(0,requerimientos,"asc",requerimientosPageFault)]
                        requerimientos.remove(anterior)
                        actual=requerimientos[indexClosest(anterior,requerimientos,"asc",requerimientosPageFault)]
            else:
                if(algo==3 or algo==4):
                    sentido="asc"
                if(algo==3 or (algo==5 and actual!=0)):
                    actual=0
                elif(algo==5 and actual==0):
                    anterior=maxRango
                    actual=requerimientos[indexClosest(maxRango,requerimientos,"desc",requerimientosPageFault)]
                else:
                    if(algo==4):
                        actual=requerimientos[indexClosest(actual,requerimientos,"asc",requerimientosPageFault)]
                    else:
                        actual=requerimientos[indexClosest(maxRango,requerimientos,"desc",requerimientosPageFault)]
                        requerimientos.remove(anterior)
                        actual=requerimientos[indexClosest(maxRango,requerimientos,"desc",requerimientosPageFault)]
        cantMov += printMovimiento(anterior, actual, pf)
        requerimientos = checkRequerimientosPendientes(requerimientos, llegadas, requerimientosArray, cantMov, requerimientosPageFault)

print("Movimientos totales: ",cantMov)