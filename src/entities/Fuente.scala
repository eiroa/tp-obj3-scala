package entities

import scala.collection.mutable.HashMap
import scala.collection.mutable.MutableList
import mixines.EntidadConRegistros
import mixines.EntidadConRegistros

class Fuente(val nombre:String,val censos:HashMap[Int,MutableList[Censo]] = new HashMap[Int,MutableList[Censo]](),
    val provinciasBajoJurisdiccion:MutableList[Provincia] = new MutableList[Provincia]) 
extends EntidadConRegistros{
	
	override def toString() = "fuente (" + this.nombre  + ")"
  
	def obtenerCensosDeAnio(anio:Int) : MutableList[Censo]={
	  return this.censos.getOrElse(anio, new MutableList[Censo])
	}
	
	def agregarCenso(anio:Int,censo:Censo): Unit = {
	  this.censos.+=((anio,(this.obtenerCensosDeAnio(anio).+=(censo))))
	  censo.provincia.registros.++=(censo.registros)
	}
	
	def obtenerVentasProvinciaPorAnio(anio:Int,prov:Provincia) = 
	     this.censos.getOrElse(anio, new MutableList[Censo]).
	     filter(_.provincia.equals(prov)).
	     foldRight(0){(b:Censo,a:Int) =>   a + b.obtenerMontoVentas}

	
    
    def registrosDeAnio(anio:Int): MutableList[Registro] = {
      return this.obtenerCensosDeAnio(anio).
      foldRight(new MutableList[Registro]){(b:Censo,a:MutableList[Registro]) =>   a.++=(b.registros ) }	
    }
    
    def registros(): MutableList[Registro] = {
	  return this.censos.foldRight(new MutableList[Registro])
	  {( kv:(Int,MutableList[Censo] ),a:MutableList[Registro]) =>   a.++=(censosARegistros(kv._2))}
    }
    
    def registrosDeGrupo(grupo:GrupoDepartamento):MutableList[Registro] = {
      return this.censos.foldRight(new MutableList[Registro])
	  {( kv:(Int,MutableList[Censo] ),a:MutableList[Registro]) =>   a.++=((censosARegistros(censosDeGrupo(kv._2, grupo))))}
    }
    
    def tieneRegistrosEnProvincia(prov:Provincia) = this.registros.count(_.provincia.eq(prov) ) > 0
    def tieneRegistrosEnDepartamento(dpto:Departamento) = this.registros.count(_.departamento.eq(dpto) ) > 0
    def tieneRegistrosEnGrupo(grupo:GrupoDepartamento) =   this.registrosDeGrupo(grupo).size > 0
    
    def censosARegistros(censos:MutableList[Censo]) =
      censos.foldRight(new MutableList[Registro]){(b:Censo,a:MutableList[Registro]) =>   a.++=(b.registros ) }	
    
    def censosDeGrupo(censos:MutableList[Censo],grupo:GrupoDepartamento) =
      censos.filter(_.grupoDepartamento.eq(grupo))
    
    
    def obtenerMontoTotalVentasDeEmpresasSegunAnio(anio:Int) = 
	    this.registrosDeAnio(anio).foldRight(0){(b:Registro,a:Int) =>   a + b.montoVentas }	

	
}