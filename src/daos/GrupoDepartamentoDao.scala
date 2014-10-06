package daos

import entities.GrupoDepartamento
import scala.collection.mutable.MutableList
import entities.Departamento
import entities.Registro
import scala.collection.mutable.HashMap
import scala.collection.immutable.ListSet

class GrupoDepartamentoDao extends AbstractDao[GrupoDepartamento] {
  
	def getElements():MutableList[GrupoDepartamento] ={
	  return this.elements 
	}

	def getGrupoDepartamento(grupo:GrupoDepartamento):GrupoDepartamento = {
	  return getElements.find(_.eq(grupo)).get	  
	}  
	
	def generarMapaEmpresaMontoVentaTotalPorAnioYGrupo(anio:Int) = {
	  this.elements.filter(_.tieneRegistrosEnAnio(anio)).
	  	foldRight(new HashMap[GrupoDepartamento, Int]) { (b: GrupoDepartamento, a: HashMap[GrupoDepartamento, Int]) => 
	  	a.+=((b, b.obtenerMontoTotalVentasDeEmpresasSegunAnio(anio))) }
	}
	
   def registrosIdentificadosConVentasMayoresAEnGrupo(monto:Int,grupo:GrupoDepartamento):MutableList[Registro] ={
	  return this.elements.filter(_.eq(grupo)).foldRight(new MutableList[Registro])
	  { (b: GrupoDepartamento, a: MutableList[Registro]) => a.++=(b.registrosIdentificadosConVentasMayorA(monto))}
	}  
	
	def generarListaConNombresDeEmpresasConVentasTotalesMayoresAEnGrupo(monto:Int,grupo:GrupoDepartamento) = {
	  var result:ListSet[String] = new ListSet[String]
	  result.++(this.registrosIdentificadosConVentasMayoresAEnGrupo(monto,grupo).map{_.empresa.nombre})
	}
	

	  
}