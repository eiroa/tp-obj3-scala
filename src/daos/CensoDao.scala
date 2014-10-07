package daos

import entities.Censo
import entities.Provincia
import entities.Departamento
import entities.GrupoDepartamento
import entities.Fuente
import scala.collection.mutable.MutableList
import entities.Registro

class CensoDao extends AbstractDao[Censo] {
	
	def saveAndSetSourceToRegisters(censo:Censo) = {
	  this.elements.+=(censo)
	  censo.registros.map(_.setFuente(censo.fuente))
	}
	  
	  

	def getElements():MutableList[Censo] ={
	  return this.elements 
	}

	def getCenso(censo:Censo):Censo= {
	  return getElements.find(_.eq(censo)).get	  
	}   
  
	def montoVentasTotalCensosDeAnio(anio:Int) = 
	  this.elements.filter(_.anio == anio).
	  	foldRight(0){ (b: Censo, a: Int) => a + b.obtenerMontoVentasFold }
	

	def montoGananciasTotalCensosDeAnio(anio:Int) = 
	  this.elements.filter(_.anio == anio)
	  .foldRight(0){ (b: Censo, a: Int) => a + b.obtenerMontoGanancias }
	
	
	def montoVentasTotalProvinciaYAnio(prov:Provincia,anio:Int)  = 
	  this.elements.filter( x => (x.anio == anio && x.provincia.eq(prov))).
	  	foldRight(0){ (b: Censo, a: Int) => a + b.obtenerMontoVentasFold }
	
	
	def montoVentasTotalDepartamentoYAnio(dpto:Departamento,anio:Int) = 
	  this.elements.filter(x => (x.anio == anio && x.departamento.eq(dpto))).
	  	foldRight(0){ (b: Censo, a: Int) => a + b.obtenerMontoVentasFold }
	
		def montoVentasTotalGrupoYAnio(grupo:GrupoDepartamento,anio:Int)  = 
	  this.elements.filter( x => (x.anio == anio &&  x.grupoDepartamento.eq(grupo))).
	  	foldRight(0){ (b: Censo, a: Int) => a + b.obtenerMontoVentasFold }
		
	def montoVentasTotalFuenteYAnio(fuente:Fuente,anio:Int)  = 
	  this.elements.filter( x => (x.anio == anio && x.fuente.eq(fuente))).
	  	foldRight(0){ (b: Censo, a: Int) => a + b.obtenerMontoVentasFold}	

	
	def montoGananciasTotalProvinciaYAnio(prov:Provincia,anio:Int) = 
	  this.elements.filter( x => (x.anio == anio && x.provincia.eq(prov))).
	  	foldRight(0){ (b: Censo, a: Int) => a + b.obtenerMontoGanancias }
	
	
	def montoGananciasTotalDepartamentoYAnio(dpto:Departamento,anio:Int)  = 
	  this.elements.filter( x => (x.anio == anio && x.departamento.eq(dpto))).
	  	foldRight(0){ (b: Censo, a: Int) => a + b.obtenerMontoGanancias}
	
	def montoGananciasTotalFuenteYAnio(fuente:Fuente,anio:Int)  = 
	  this.elements.filter( x => (x.anio == anio && x.fuente.eq(fuente))).
	  	foldRight(0){ (b: Censo, a: Int) => a + b.obtenerMontoGanancias}
	
	def montoGananciasTotalGrupoYAnio(grupo:GrupoDepartamento,anio:Int)  = 
	  this.elements.filter( x => (x.anio == anio &&  x.grupoDepartamento.eq(grupo))).
	  	foldRight(0){ (b: Censo, a: Int) => a + b.obtenerMontoGanancias }
	


	def censosDefuente(fuente:Fuente ) :MutableList[Censo]= {
	  //censos
	  return getElements.filter(_.fuente.eq(fuente))
	}
	
	def registrosDeCensos(censos:MutableList[Censo]):MutableList[Registro] = {
	  return censos.foldRight(new MutableList[Registro])
			  {(b:Censo,a:MutableList[Registro]) =>   a.++=(b.registros )  }
	}
	
	
	
	//Correspondiente a parte 2
	  
	def cantidadDeRegistrosFuenteConVentasMayoresA(monto:Int, fuente:Fuente ) = {
	  registrosDeCensos(censosDefuente(fuente)).count(_.montoVentas > monto)
	}  
	
	def cantidadDeRegistrosFuenteConGananciasMayoresA(monto:Int, fuente:Fuente ) = {
	  registrosDeCensos(censosDefuente(fuente)).count(_.montoGanancia  > monto)
	} 
	
	def cantidadDeRegistrosFuenteConTasaDeGananciaMayorA(tasa:Int, fuente:Fuente) = {
	  registrosDeCensos(censosDefuente(fuente)).count(_.tasaDeGanancia  > tasa)
	}
	
	
}	  