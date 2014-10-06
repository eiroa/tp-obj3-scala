package daos

import entities.Departamento
import entities.Provincia
import scala.collection.mutable.HashMap
import scala.collection.immutable.ListSet
import scala.collection.mutable.MutableList
import entities.Registro

class DepartamentoDao extends AbstractDao[Departamento]{
  
	def generarMapaEmpresaMontoVentaTotalPorAnioYDepartamento(anio:Int) = 
     this.elements.filter(_.tieneRegistrosEnAnio(anio)).
     foldRight(new HashMap[Departamento, Int]) { (b: Departamento, a: HashMap[Departamento, Int]) => 
     a.+=((b, b.obtenerMontoTotalVentasDeEmpresasSegunAnio(anio))) }
	
	
	def registrosIdentificadosConVentasMayoresAEnDepartamento(monto:Int,dpto:Departamento):MutableList[Registro] ={
	  return this.elements.filter(_.eq(dpto)).foldRight(new MutableList[Registro])
	  { (b: Departamento, a: MutableList[Registro]) => a.++=(b.registrosIdentificadosConVentasMayorA(monto))}
	}  
	
	def generarListaConNombresDeEmpresasConVentasTotalesMayoresAEnDepartamento(monto:Int,dpto:Departamento) = {
	  var result:ListSet[String] = new ListSet[String]
	  result.++(this.registrosIdentificadosConVentasMayoresAEnDepartamento(monto,dpto).map{_.empresa.nombre})
	}

}