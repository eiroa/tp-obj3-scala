tp-obj3-scala
=============

Trabajo Práctico 1 De Objetos 3.  Scala.


TP 1
Objetos 3 – UNQ
2 de septiembre de 2014
Se desea informatizar el procesamiento de informaci ́n generada por un censo econ ́mico permanente de
la Argentina. La informaci ́n es recabada por distintas fuentes. De cada una de estas fuentes, alcanza con
manejar el nombre, o sea un String.
Hay un conjunto de empresas cuyos datos se registran todos los a ̃os. A cada empresa se asocia una
n fuente, que es la encargada de recabar sus datos. Cada empresa se identifica por su nombre. P.ej. una
empresa podr ́ ser Sapucay S.A., y la fuente que recaba la informaci ́n sobre esta empresa, la C ́maraıa
o
a
de Industria del Litoral. Otro dato importante tiene que ver con d ́nde est ́ ubicada la empresa. Cada
o
a
provincia tiene varios departamentos; nos interesa el departamento en el que est ́ cada empresa. A efectos
a
de este TP, supondremos que una empresa no puede cambiar de departamento. P.ej. Sapucay S.A. est ́ en
a
el departamento de Esquina, provincia de Corrientes. Los datos que se registran cada a ̃o, para cada una de
n
estas empresas, son: el a ̃o, el monto total de ventas, y el monto de sus ganancias. Tambi ́n queda registrado
n
e
en qu ́ fecha se cargaron los datos.
e
Por lo tanto, en cada a ̃o tendremos un registro para cada empresa que participa en forma permanente en
n
el censo. A estos registros se agregan otros, de otras empresas que no son las registradas, y que son an ́nimos,
o
en el sentido de que no se sabe de qu ́ empresa son. Cada registro corresponde a un a ̃o. Los datos que se
e
n
toman son: departamento en donde est ́ la empresa, a ̃o, monto total de ventas del a ̃o, monto anual de
a
n
n
ganancia. En este caso, tambi ́n queda registrado en qu ́ fecha se cargaron los datos.
e
e
A partir de los montos de ventas y de ganancia se puede establecer la tasa de ganancias de una empresa
en un a ̃o: se calcula as ́
n
ı:
g
tg = × 100
v
donde tg es “tasa de ganancias”, g es el monto anual de ganancias, y v es el monto anual de ventas.
I.
Totales anuales y datos de una empresa
Dise ̃ar la informaci ́n planteada de forma tal que pueda obtenerse, para un a ̃o determinado
n
o
n
a) El total de ventas, contando todos los registros, los de las empresas conocidas, y tambi ́n los registros
e
an ́nimos. Implementarlo de dos formas distintas, una usando fold, la otra sin usar fold.
o
b) El total de ganancias, tambi ́n contando todos los registros.
e
c) La cantidad de registros (no importa si de empresas conocidas o an ́nimas) cuyo total de ventas supera
o
un par ́metro. P.ej., cu ́ntos registros hay cuyo total de ventas sea mayor a 100.000 pesos en el a ̃o que
a
a
n
nos interesa.
d) La cantidad de registros cuyo monto de ganancias supere un par ́metro, an ́logo al anterior.
a
a
e) La cantidad de registros cuya tasa de ganancia supere un par ́metro, an ́logo al anterior.
a
a
f) Un mapa donde la clave sea cada provincia, y el valor sea el total de ventas para todos las empresas
(ya sea conocidas o an ́nimas) que correspondan a esa provincia, para todas las provincias que tengan al
o
menos un registro en el a ̃o en cuesti ́n.
n
o
g) Los nombres de las empresas cuyas ventas superen un cierto valor. No tener en cuenta registros an ́nimos
o
en este  ́
ıtem.
h) El conjunto de fuentes que aportaron al menos un registro en el a ̃o en cuesti ́n, sin repetidos.
n
o
i) El nombre de la empresa con mayor monto de ganancias en el a ̃o en cuesti ́n. No tener en cuenta registros
n
o
an ́nimos en este  ́
o
ıtem.
1
Objetos 3
TP 1 – 2do cuatrimestre 2014
Tiene que haber un objeto, al que se crea parametriz ́ndolo con el a ̃o, que tenga un mensaje para cada uno
a
n
de estos  ́
ıtems. P.ej., se tiene que poder obtener el total de ventas ( ́
ıtem a)) de esta forma
new EstadisticasAnuales(2013).totalVentas
Adem ́s, para una empresa conocida, se tiene que poder calcular
a
Si es s ́lida: una empresa es s ́lida si en todos sus registros, la tasa de ganancia es mayor a 10.
o
o
Si es sospechosa: una empresa es sospechosa si en al menos un registro, la tasa de ganancia es mayor
a 85.
Estas dos cosas se tienen que poder obtener envi ́ndole un mensaje a un objeto, no vale que el test sea m ́s
a
a
complicado que eso.
Como dijimos en clase, la idea de DAO, o Home, les puede venir bien para implementar este TP.
II.
Totales por distintos criterios
1) Agregar al modelo lo siguiente: cada fuente de informaci ́n puede obtener datos solamente de algunas
o
provincias, no de todas. P.ej. la C ́mara de Industria del Litoral puede obtener datos de empresas de
a
Corrientes, Santa Fe y Entre R ́ nada m ́s. Con este cambio, ya no vale representar a cada fuente de
ıos,
a
informaci ́n como un String, es un objeto que tiene cierto comportamiento. Por ahora no hacer ning ́n
o
u
chequeo, eso viene m ́s adelante.
a
2) Modelar grupos de departamentos, que pueden estar en la misma provincia o no. A un grupo de
departamentos se le tiene que poder preguntar:
si es homog ́neo o no. Un grupo de departamentos es homog ́neo si todos sus departamentos est ́n
e
e
a
en la misma provincia.
si incluye o no departamentos de una provincia que se le pasa por par ́metro.
a
3) Lograr que se pueda obtener la informaci ́n correspondiente a los  ́
o
ıtems a) a i), para:
Una provincia.
Un departamento.
Un grupo de departamentos.
Los registros obtenidos mediante una determinada fuente de informaci ́n.
o
En cada caso, cada uno de los  ́
ıtems tiene que corresponder a un mensaje que le env ́ al objeto co-
ıe
rrespondiente, o sea, al que representa a una provincia, un departamento, un grupo de departamentos,
y una fuente de informaci ́n respectivamente. Hay que tomar en cuenta todos los registros correspon-
o
dientes a la provincia, departamento, etc. en cuesti ́n, de cualquier a ̃o.
o
n
Para los  ́
ıtems c), d), e), si tenemos varios registros para la misma empresa conocida, hay que contarlos
todos. P.ej. si para Sapucay S.A. tenemos tres registros, cuya cantidad de ventas es 80000, 105000 y
124000 respectivamente, entonces hay que contar dos registros cuyo total de ventas es mayor a 100000.
Para el  ́
ıtem g), que el conjunto de nombres de empresas conocidas no tenga repetidos.
Hint obvio: usar mixines.
III.
M ́s cosas
a
1) Para una empresa conocida, obtener: el total de ventas contando todos sus registros, el total de ganan-
cias, la cantidad de a ̃os para los cuales su total de ventas supera un par ́metro, idem para ganancias
n
a
y para tasa de ganancias. Hacerlo usando un truco parecido al de la secci ́n II, f ́
o
ıjense que son exacta-
mente los datos que corresponden a los  ́
ıtems a) a e). Queda m ́s elegante si a una empresa no se le
a
pueden preguntar los datos de los  ́
ıtems f) a i).
2) Agregar, a la informaci ́n con que se cuenta para cada registro, en qu ́ a ̃o se obtuvo la informaci ́n.
o
e n
o
P.ej. para un registro correspondiente a 2012 se pudo haber obtenido la informaci ́n en 2013, 2014,
o
2015, etc..
2
Objetos 3
TP 1 – 2do cuatrimestre 2014
3) Se definen los siguientes chequeos de consistencia de un registro:
El importe de ventas debe ser mayor o igual a cero, o sea, no puede ser negativo.
La informaci ́n se tuvo que haber obtenido despu ́s del a ̃o al que se refiere el registro. P.ej. si
o
e
n
un registro corresponde a 2012, la informaci ́n correspondiente se tuvo que haber conseguido en
o
2013 o despu ́s, si en el registro dice que la informaci ́n se obtuvo en 2012, o antes, entonces el
e
o
registro es inconsistente.
La provincia del registro debe ser coherente con las provincias de las que fuente que obtuvo la
informaci ́n puede obtener datos. Este chequeo se hace solamente para registros an ́nimos. P.ej. un
o
o
registro correspondiente a C ́rdoba cuya fuente es la C ́mara de Industria del Litoral es inv ́lido.
o
a
a
Lograr que los objetos que representan registros entiendan el mensaje esConsistente. Hacer dos im-
plementaciones: una en la cual cada chequeo es un mixin, otra donde cada chequeo es un Strategy o
algo as ́ Para mantener las dos en el mismo proyecto, se puede hacer p.ej. que los registros entien-
ı.
dan esConsistenteMixin y esConsistenteStrategy. Hacer una peque ̃a (entre 5 renglones y media
n
carilla) comparaci ́n entre las dos soluciones implementadas.
o
4) Lograr que puedan obtenerse los datos de los  ́
ıtems a) a i) para un conjunto de a ̃os, considerando
n
para cada empresa el total de ventas y de ganancias para todos los a ̃os en ese conjunto. Tener en
n
cuenta solamente los registros de empresas conocidas. P.ej. si los a ̃os elegidos son 2009, 2011 y 2013,
n
y Sapucay vendi ́ 35000 pesos en 2009, 58000 en 2011, y 42000 en 2013, entonces hay que incluirla
o
entre las empresas que vendieron m ́s de 100000 pesos, porque se toma el total, que es 135000 pesos.
a
5) Lo mismo que el punto anterior, pero considerando para cada empresa, el promedio de lo que vendieron
en cada uno de los a ̃os indicados. P.ej. en el mismo ejemplo descripto en el punto anterior, para Sapucay
n
se considera un total de ventas de 45000 pesos, que es el promedio de lo que vendi ́ en 2009, 2011 y
o
2013. En los puntos a), b), f) se suma el promedio de ventas o ganancias de cada empresa.
