package entities

import scala.collection.mutable.MutableList
import mixines.EntidadConRegistros

/*
 * A cada empresa se asocia una
fuente, que es la encargada de recabar sus datos. Cada empresa se identifica por su nombre. P.ej. una
empresa podr´ıa ser Sapucay S.A., y la fuente que recaba la informaci´on sobre esta empresa, la C´amara
de Industria del Litoral. Otro dato importante tiene que ver con d´onde est´a ubicada la empresa. Cada
provincia tiene varios departamentos; nos interesa el departamento en el que est´a cada empresa. A efectos
de este TP, supondremos que una empresa no puede cambiar de departamento. P.ej. Sapucay S.A. est´a en
el departamento de Esquina, provincia de Corrientes. Los datos que se registran cada a˜no, para cada una de
estas empresas, son: el a˜no, el monto total de ventas, y el monto de sus ganancias. Tambi´en queda registrado
en qu´e fecha se cargaron los datos.
Por lo tanto, en cada a˜no tendremos un registro para cada empresa que participa en forma permanente en
el censo. A estos registros se agregan otros, de otras empresas que no son las registradas, y que son an´onimos,
en el sentido de que no se sabe de qu´e empresa son. Cada registro corresponde a un a˜no. Los datos que se
toman son: departamento en donde est´a la empresa, a˜no, monto total de ventas del a˜no, monto anual de
ganancia. En este caso, tambi´en queda registrado en qu´e fecha se cargaron los datos.
A partir de los montos de ventas y de ganancia se puede establecer la tasa de ganancias de una empresa
en un a˜no: se calcula as´ı:
tg =gv × 100
donde tg es “tasa de ganancias”, g es el monto anual de ganancias, y v es el monto anual de ventas.
 * 
 * 
 */

class Empresa(val nombre: String, val provincia:Provincia,
    val departamento:Departamento) extends EntidadConRegistros{
	val registros:MutableList[Registro] = new MutableList[Registro]
	
  def obtenerMontoVentasTotal()  =  
    this.registros.foldRight(0){(b:Registro,a:Int) =>   a + b.montoVentas }
	
  def obtenerMontoGanaciaTotal() = 
    this.registros.foldRight(0){(b:Registro,a:Int) =>   a + b.montoGanancia  }
  
  def obtenerTasaDeGanaciaTotal() = (this.obtenerMontoGanaciaTotal * 100 )/this.obtenerMontoVentasTotal
	
  def obtenerMontoGananciasEnAnio(anio:Int) = 
    this.registros.filter(_.anio.==(anio)).
    foldRight(0){(b:Registro,a:Int) =>   a + b.montoGanancia  }
  
	
  def esSolida():Boolean = this.obtenerTasaDeGanaciaTotal > 10
	
  def esSospechosa():Boolean = this.obtenerTasaDeGanaciaTotal > 85

	  override def toString() = {
    "Empresa (" + this.nombre  + ")"
  }
}