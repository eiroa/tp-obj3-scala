package tests


import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.Spec
import org.scalatest._
import org.junit._
import Assert._
import entities.Registro
import java.util.Date
import entities.Empresa
import scala.collection.mutable.MutableList
import daos.RegistroDao
import entities.Fuente
import entities.Censo
import daos.EmpresaDao
import entities.Provincia
import daos.ProvinciaDao
import java.util.Calendar
import entities.Departamento
import daos.FuenteDao
import daos.CensoDao
import daos.DepartamentoDao
import entities.GrupoDepartamento
import daos.GrupoDepartamentoDao
class Tests {
  
   //Arrange
   
   //Provincias
  
	 
   
   val baires = new Provincia("Buenos Aires")
   val entrerios = new Provincia("Entre Rios")
   val santaFe = new Provincia("Santa fe")
   val mendoza = new Provincia("Mendoza")
   val tierraDelFuego = new Provincia("Tierra del Fuego")
   
   //Departamentos
   //Bs As
   val avellaneda = new Departamento("Avellaneda",baires )
   val quilmes = new Departamento("Quilmes",baires)
   val mdq = new Departamento("Mar del Plata",baires)
   val bahiaBlanca = new Departamento("Bahia Blanca",baires)
   val tigre = new Departamento("Tigre",baires)
   
   //Entre rios
   val colon = new Departamento("Colon",entrerios )
   val parana = new Departamento("Paraná",entrerios )
   
   //Santa fe
   val rosario = new Departamento("Rosario",santaFe )
   
   
   //Mendoza
   val mdzCapital = new Departamento("Mendoza capital",mendoza )
   val sanRafael = new Departamento("San Rafael",mendoza )
  
   //Tierra del fuego
   val rioGrande = new Departamento("Rio Grande",tierraDelFuego )
   val ushuaia = new Departamento("Ushuaia",tierraDelFuego )
   
   
   
   //Grupos
   
   val zonasPortuarias = new GrupoDepartamento("Zonas portuarias")
   val conurbano = new GrupoDepartamento("Conurbano")
   val cuyo = new GrupoDepartamento("Cuyo")
   val litoral= new GrupoDepartamento("Litoral")
   
   //Asignaciones dpts a provs
   
   baires.departamentos.+=(avellaneda )
   baires.departamentos.+=(quilmes )
   baires.departamentos.+=(tigre )
   baires.departamentos.+=(mdq)
   baires.departamentos.+=(bahiaBlanca )
   
   entrerios.departamentos.+=(colon)
   entrerios.departamentos.+=(parana )
   
   santaFe.departamentos.+=(rosario)
   
   mendoza.departamentos.+=(mdzCapital )
   mendoza.departamentos.+=(sanRafael )
   
   tierraDelFuego.departamentos.+=(rioGrande)
   tierraDelFuego.departamentos.+=(ushuaia )
   
   
   //Asignaciones dpts a grupos
   
   zonasPortuarias.departamentos.+=(bahiaBlanca )
   zonasPortuarias.departamentos.+=(mdq  )
   zonasPortuarias.departamentos.+=(rosario )
   zonasPortuarias.departamentos.+=(rioGrande  )
   zonasPortuarias.departamentos.+=(ushuaia  )
   
   conurbano.departamentos.+=(avellaneda )
   conurbano.departamentos.+=(quilmes  )
   conurbano.departamentos.+=(tigre )
   
   cuyo.departamentos.+=(mdzCapital  )
   cuyo.departamentos.+=(sanRafael  )
   
   litoral.departamentos.+=(parana)
   litoral.departamentos.+=(colon)
   ///////
   //Fuentes 
   val fbaires = new Fuente("Cámara de comercio de Buenos Aires")
   fbaires.provinciasBajoJurisdiccion.+=(baires)
   val flitoral = new Fuente("Cámara de comercio del Litoral")
   flitoral.provinciasBajoJurisdiccion.+=(entrerios)
   flitoral.provinciasBajoJurisdiccion.+=(santaFe)
   val fcuyo = new Fuente("Cámara de comercio de Cuyo")
   fcuyo.provinciasBajoJurisdiccion.+=(mendoza)
   val fpatagonia = new Fuente("Cámara de comercio patagónica")
   fpatagonia.provinciasBajoJurisdiccion.+=(tierraDelFuego )
   
   
   /////////
   //Empresas
   
   //Bs As
   val ave1 = new Empresa("Empresa Avellaneda 1",baires,avellaneda )
   val ave2 = new Empresa("Empresa Avellaneda 2",baires,avellaneda )
   val quil1 = new Empresa("Empresa Quilmes 1",baires,quilmes  )
   val quil2 = new Empresa("Empresa Quilmes 2",baires,quilmes)
   val mdq1 = new Empresa("Empresa Mar del Plata 1",baires,mdq )
   val mdq2 = new Empresa("Empresa Mar del Plata 2",baires,mdq )
   val mdq3 = new Empresa("Empresa Mar del Plata 3",baires,mdq )
   val bb1 = new Empresa("Empresa Bahia Blanca 1",baires,bahiaBlanca )
   val tigre1 = new Empresa("Empresa Tigre 1",baires,tigre)
   val tigre2 = new Empresa("Empresa Tigre 2",baires,tigre )
   // Entre rios
   val parana1= new Empresa("Empresa Parana 1",entrerios ,parana )
   val parana2 = new Empresa("Empresa Parana 2",entrerios,parana )
   val colon1 = new Empresa("Empresa Colon1", entrerios,colon)
   //Santa fe
   val rosario1 = new Empresa("Empresa Rosario 1",santaFe,rosario)
   val rosario2 = new Empresa("Empresa Rosario 2",santaFe,rosario)
   
   
   //Mendoza
   val mendoza1 = new Empresa("Empresa Mendoza Capital 1",mendoza,mdzCapital )
   val mendoza2 = new Empresa("Empresa Mendoza Capital 2",mendoza,mdzCapital )
   val sanRafael1 = new Empresa("Empresa San Rafael 1",mendoza,sanRafael )
   
   
   //Tierra del fuego 
   val rioGrande1 = new Empresa("Empresa Rio Grande 1",tierraDelFuego ,rioGrande  )
   val rioGrande2 = new Empresa("Empresa Rio Grande 2",tierraDelFuego ,rioGrande  )
   val rioGrande3 = new Empresa("Empresa Rio Grande 3",tierraDelFuego ,rioGrande  )
   val ushuaia1 = new Empresa("Empresa Ushuaia 1",tierraDelFuego ,ushuaia  )
   
   
   //Censos
   // Buenos Aires
   
   val c2014Avellaneda = new Censo(2014,fbaires,baires,avellaneda,conurbano )
   val c2013Avellaneda = new Censo(2013,fbaires,baires,avellaneda,conurbano )
   val c2012Avellaneda = new Censo(2012,fbaires,baires,avellaneda,conurbano )
   
   val c2014Quilmes= new Censo(2014,fbaires,baires,quilmes,conurbano )
   val c2013Quilmes= new Censo(2013,fbaires,baires,quilmes,conurbano )
   val c2012Quilmes = new Censo(2012,fbaires,baires,quilmes,conurbano )
   
   val c2014Tigre= new Censo(2014,fbaires,baires,tigre,conurbano )
   val c2013Tigre= new Censo(2013,fbaires,baires,tigre,conurbano )
   val c2012Tigre = new Censo(2012,fbaires,baires,tigre,conurbano )
   
   val c2014Mdq = new Censo(2014,fbaires,baires,mdq,zonasPortuarias )
   val c2013Mdq = new Censo(2013,fbaires,baires,mdq,zonasPortuarias)
   val c2012Mdq= new Censo(2012,fbaires,baires,mdq,zonasPortuarias)
   
   val c2014BahiaBlanca = new Censo(2014,fbaires,baires,bahiaBlanca,zonasPortuarias )
   val c2013BahiaBlanca = new Censo(2013,fbaires,baires,bahiaBlanca ,zonasPortuarias)
   val c2012BahiaBlanca = new Censo(2012,fbaires,baires,bahiaBlanca ,zonasPortuarias)
   
   //Entre rios
   val c2014Parana = new Censo(2014,flitoral ,entrerios ,parana,litoral)
   val c2013Parana = new Censo(2013,flitoral ,entrerios ,parana,litoral)
   
   val c2014Colon= new Censo(2014,flitoral ,entrerios ,colon,litoral)
   val c2013Colon= new Censo(2013,flitoral ,entrerios ,colon,litoral)
   
   //Santa Fe
   val c2014Rosario = new Censo(2014,flitoral ,santaFe,rosario,zonasPortuarias)
   val c2013Rosario = new Censo(2013,flitoral ,santaFe,rosario,zonasPortuarias)
   
   //Mendoza
   val c2014MendozaCapital= new Censo(2014,fcuyo ,mendoza,mdzCapital ,cuyo)
   val c2013MendozaCapital= new Censo(2013,fcuyo ,mendoza,mdzCapital ,cuyo)
   
   val c2014SanRafael= new Censo(2014,fcuyo ,mendoza,sanRafael  ,cuyo)
   val c2013SanRafael= new Censo(2013,fcuyo ,mendoza,sanRafael  ,cuyo)
   
   //Tierra del Fuego
   val c2014RioGrande= new Censo(2014,fpatagonia  ,tierraDelFuego ,rioGrande ,zonasPortuarias)
   val c2013RioGrande= new Censo(2013,fpatagonia  ,tierraDelFuego ,rioGrande ,zonasPortuarias)
   
   val c2014Ushuaia= new Censo(2014,fpatagonia  ,tierraDelFuego ,ushuaia ,zonasPortuarias)
   val c2013Ushuaia= new Censo(2013,fpatagonia  ,tierraDelFuego ,ushuaia,zonasPortuarias )
   
   
   //Carga de registros por Censo
   //Empresa == null => registro anonimo
   //______________________________________________\\
   /////////// B U E N O S     A I R E S \\\\\\\\\\\\
   
   //Avellaneda
   //c2014Avellaneda
   val r1c12014Avellaneda = new Registro(2014,ave1,baires,avellaneda,50000,25000)
   val r2c12014Avellaneda = new Registro(2014,ave2,baires,avellaneda,60000,30000) 
   val r3c12014Avellaneda = new Registro(2014,null,baires,avellaneda,70000,35000)
   val r4c12014Avellaneda = new Registro(2014,null,baires,avellaneda,100000,10000)
   val r5c12014Avellaneda =new Registro(2014,null,baires,avellaneda,40000,30000)
   
   c2014Avellaneda.agregarRegistro(r1c12014Avellaneda)
   c2014Avellaneda.agregarRegistro(r2c12014Avellaneda)
   c2014Avellaneda.agregarRegistro(r3c12014Avellaneda)
   c2014Avellaneda.agregarRegistro(r4c12014Avellaneda)
   c2014Avellaneda.agregarRegistro(r5c12014Avellaneda)
   
   // c2013Avellaneda
   
   val r1c12013Avellaneda = new Registro(2013,ave1,baires,avellaneda,40000,20000)
   val r2c12013Avellaneda = new Registro(2013,ave2,baires,avellaneda,50000,25000) 
   val r3c12013Avellaneda = new Registro(2013,null,baires,avellaneda,60000,30000)
   val r4c12013Avellaneda = new Registro(2013,null,baires,avellaneda,90000,5000)
   val r5c12013Avellaneda =new Registro(2013,null,baires,avellaneda,35000,20000)
   
   c2013Avellaneda.agregarRegistro(r1c12013Avellaneda)
   c2013Avellaneda.agregarRegistro(r2c12013Avellaneda)
   c2013Avellaneda.agregarRegistro(r3c12013Avellaneda)
   c2013Avellaneda.agregarRegistro(r4c12013Avellaneda)
   c2013Avellaneda.agregarRegistro(r5c12013Avellaneda)
   
      // c2012Avellaneda
   
   val r1c12012Avellaneda = new Registro(2012,ave1,baires,avellaneda,35000,18000)
   val r2c12012Avellaneda = new Registro(2012,ave2,baires,avellaneda,40000,20000) 
   val r3c12012Avellaneda = new Registro(2012,null,baires,avellaneda,50000,30000)
   val r4c12012Avellaneda = new Registro(2012,null,baires,avellaneda,80000,4000)
   val r5c12012Avellaneda =new Registro(2012,null,baires,avellaneda,30000,30000)
   
   c2012Avellaneda.agregarRegistro(r1c12012Avellaneda)
   c2012Avellaneda.agregarRegistro(r2c12012Avellaneda)
   c2012Avellaneda.agregarRegistro(r3c12012Avellaneda)
   c2012Avellaneda.agregarRegistro(r4c12012Avellaneda)
   c2012Avellaneda.agregarRegistro(r5c12012Avellaneda)
   
   
   //Quilmes
   
   //c2014Quilmes
   val r1c12014Quilmes= new Registro(2014,quil1,baires,quilmes,50000,25000)
   val r2c12014Quilmes= new Registro(2014,quil2,baires,quilmes,60000,30000) 
   val r3c12014Quilmes= new Registro(2014,null,baires,quilmes,70000,35000)
   val r4c12014Quilmes= new Registro(2014,null,baires,quilmes,100000,10000)
   val r5c12014Quilmes =new Registro(2014,null,baires,quilmes,40000,30000)
   
   c2014Quilmes.agregarRegistro(r1c12014Quilmes)
   c2014Quilmes.agregarRegistro(r2c12014Quilmes)
   c2014Quilmes.agregarRegistro(r3c12014Quilmes)
   c2014Quilmes.agregarRegistro(r4c12014Quilmes)
   c2014Quilmes.agregarRegistro(r5c12014Quilmes)
   
   // c2013Quilmes
   
   val r1c12013Quilmes= new Registro(2013,quil1,baires,quilmes,40000,20000)
   val r2c12013Quilmes = new Registro(2013,quil2,baires,quilmes,50000,25000) 
   val r3c12013Quilmes = new Registro(2013,null,baires,quilmes,60000,30000)
   val r4c12013Quilmes = new Registro(2013,null,baires,quilmes,90000,5000)
   val r5c12013Quilmes =new Registro(2013,null,baires,quilmes,35000,20000)
   
   c2013Quilmes.agregarRegistro(r1c12013Quilmes)
   c2013Quilmes.agregarRegistro(r2c12013Quilmes)
   c2013Quilmes.agregarRegistro(r3c12013Quilmes)
   c2013Quilmes.agregarRegistro(r4c12013Quilmes)
   c2013Quilmes.agregarRegistro(r5c12013Quilmes)
   
      // c2012Quilmes
   
   val r1c12012Quilmes = new Registro(2012,quil1,baires,quilmes,35000,18000)
   val r2c12012Quilmes= new Registro(2012,quil2,baires,quilmes,40000,20000) 
   val r3c12012Quilmes = new Registro(2012,null,baires,quilmes,50000,30000)
   val r4c12012Quilmes= new Registro(2012,null,baires,quilmes,80000,4000)
   val r5c12012Quilmes =new Registro(2012,null,baires,quilmes,30000,30000)
   
   c2012Quilmes.agregarRegistro(r1c12012Quilmes)
   c2012Quilmes.agregarRegistro(r2c12012Quilmes)
   c2012Quilmes.agregarRegistro(r3c12012Quilmes)
   c2012Quilmes.agregarRegistro(r4c12012Quilmes)
   c2012Quilmes.agregarRegistro(r5c12012Quilmes)
   
   
   //Tigre
   //c2014Tigre
   val r1c12014Tigre= new Registro(2014,tigre1,baires,tigre,50000,25000)
   val r2c12014Tigre= new Registro(2014,tigre2,baires,tigre,60000,30000) 
   val r3c12014Tigre= new Registro(2014,null,baires,tigre,70000,35000)
   val r4c12014Tigre= new Registro(2014,null,baires,tigre,100000,10000)
   val r5c12014Tigre =new Registro(2014,null,baires,tigre,40000,30000)
   
   c2014Tigre.agregarRegistro(r1c12014Tigre)
   c2014Tigre.agregarRegistro(r2c12014Tigre)
   c2014Tigre.agregarRegistro(r3c12014Tigre)
   c2014Tigre.agregarRegistro(r4c12014Tigre)
   c2014Tigre.agregarRegistro(r5c12014Tigre)
   
   // c2013Tigre
   
   val r1c12013Tigre= new Registro(2013,tigre1,baires,tigre,40000,20000)
   val r2c12013Tigre = new Registro(2013,tigre2,baires,tigre,50000,25000) 
   val r3c12013Tigre = new Registro(2013,null,baires,tigre,60000,30000)
   val r4c12013Tigre = new Registro(2013,null,baires,tigre,90000,5000)
   val r5c12013Tigre =new Registro(2013,null,baires,tigre,35000,20000)
   
   c2013Tigre.agregarRegistro(r1c12013Tigre)
   c2013Tigre.agregarRegistro(r2c12013Tigre)
   c2013Tigre.agregarRegistro(r3c12013Tigre)
   c2013Tigre.agregarRegistro(r4c12013Tigre)
   c2013Tigre.agregarRegistro(r5c12013Tigre)
   
      // c2012Tigre
   
   val r1c12012Tigre= new Registro(2012,tigre1,baires,tigre,35000,18000)
   val r2c12012Tigre= new Registro(2012,tigre2,baires,tigre,40000,20000) 
   val r3c12012Tigre= new Registro(2012,null,baires,tigre,50000,30000)
   val r4c12012Tigre= new Registro(2012,null,baires,tigre,80000,4000)
   val r5c12012Tigre=new Registro(2012,null,baires,tigre,30000,30000)
   
   c2012Tigre.agregarRegistro(r1c12012Tigre)
   c2012Tigre.agregarRegistro(r2c12012Tigre)
   c2012Tigre.agregarRegistro(r3c12012Tigre)
   c2012Tigre.agregarRegistro(r4c12012Tigre)
   c2012Tigre.agregarRegistro(r5c12012Tigre)
   
   
   ///////////////////
   // BAHIA BLANCA  //
   //c2014BahiaBlanca
   val r1c12014BahiaBlanca= new Registro(2014,bb1 ,baires,bahiaBlanca,50000,25000)
   val r4c12014BahiaBlanca= new Registro(2014,null,baires,bahiaBlanca,100000,10000)
   val r5c12014BahiaBlanca =new Registro(2014,null,baires,bahiaBlanca,40000,30000)
   
   c2014BahiaBlanca.agregarRegistro(r1c12014BahiaBlanca)
   c2014BahiaBlanca.agregarRegistro(r4c12014BahiaBlanca)
   c2014BahiaBlanca.agregarRegistro(r5c12014BahiaBlanca)
   
   // c2013BahiaBlanca
   
   val r1c12013BahiaBlanca= new Registro(2013,bb1,baires,bahiaBlanca,40000,20000)
   val r4c12013BahiaBlanca= new Registro(2013,null,baires,bahiaBlanca,90000,5000)
   val r5c12013BahiaBlanca =new Registro(2013,null,baires,bahiaBlanca,35000,20000)
   
   c2013BahiaBlanca.agregarRegistro(r1c12013BahiaBlanca)
   c2013BahiaBlanca.agregarRegistro(r4c12013BahiaBlanca)
   c2013BahiaBlanca.agregarRegistro(r5c12013BahiaBlanca)
   
      // c2012BahiaBlanca
   
   val r1c12012BahiaBlanca= new Registro(2012,bb1,baires,bahiaBlanca,35000,18000)
   val r4c12012BahiaBlanca= new Registro(2012,null,baires,bahiaBlanca,80000,20000)
   val r5c12012BahiaBlanca=new Registro(2012,null,baires,bahiaBlanca ,30000,30000)
   
   c2012BahiaBlanca.agregarRegistro(r1c12012BahiaBlanca)
   c2012BahiaBlanca.agregarRegistro(r4c12012BahiaBlanca)
   c2012BahiaBlanca.agregarRegistro(r5c12012BahiaBlanca)
   
   ///////////////////
   // Mar del Plata //
   //c2014Mdq
   val r1c12014Mdq= new Registro(2014,mdq1,baires,mdq,50000,25000)
   val r2c12014Mdq= new Registro(2014,mdq2,baires,mdq,60000,30000) 
   val r3c12014Mdq= new Registro(2014,mdq3,baires,mdq,30000,299999)
   val r4c12014Mdq= new Registro(2014,null,baires,mdq,100000,10000)
   val r5c12014Mdq= new Registro(2014,null,baires,mdq,150000,5000)
   val r6c12014Mdq =new Registro(2014,null,baires,mdq,40000,30000)
   
   c2014Mdq.agregarRegistro(r1c12014Mdq)
   c2014Mdq.agregarRegistro(r2c12014Mdq)
   c2014Mdq.agregarRegistro(r3c12014Mdq)
   c2014Mdq.agregarRegistro(r4c12014Mdq)
   c2014Mdq.agregarRegistro(r5c12014Mdq)
   c2014Mdq.agregarRegistro(r6c12014Mdq)
   
   // c2013Mdq
   
   val r1c12013Mdq= new Registro(2013,mdq1,baires,mdq,40000,20000)
   val r2c12013Mdq= new Registro(2013,mdq2,baires,mdq,50000,25000)
   val r3c12013Mdq= new Registro(2013,mdq3,baires,mdq,60000,30000)
   val r4c12013Mdq= new Registro(2013,null,baires,mdq,90000,5000)
   val r5c12013Mdq=new Registro(2013,null,baires,mdq,35000,20000)
   val r6c12013Mdq= new Registro(2013,null,baires,mdq,70000,150000) 
   
   c2013Mdq.agregarRegistro(r1c12013Mdq)
   c2013Mdq.agregarRegistro(r2c12013Mdq)
   c2013Mdq.agregarRegistro(r3c12013Mdq)
   c2013Mdq.agregarRegistro(r4c12013Mdq)
   c2013Mdq.agregarRegistro(r5c12013Mdq)
   c2013Mdq.agregarRegistro(r6c12013Mdq)
   
      // c2012Mdq
   
   val r1c12012Mdq= new Registro(2012,mdq1,baires,mdq,35000,18000)
   val r2c12012Mdq= new Registro(2012,mdq2,baires,mdq,40000,20000) 
   val r3c12012Mdq= new Registro(2012,mdq3,baires,mdq,50000,30000)
   val r4c12012Mdq= new Registro(2012,null,baires,mdq,80000,4000)
   val r5c12012Mdq=new Registro(2012,null,baires,mdq ,30000,30000)
   val r6c12012Mdq=new Registro(2012,null,baires,mdq ,70000,-20000)
   
   c2012Mdq.agregarRegistro(r1c12012Mdq)
   c2012Mdq.agregarRegistro(r2c12012Mdq)
   c2012Mdq.agregarRegistro(r3c12012Mdq)
   c2012Mdq.agregarRegistro(r4c12012Mdq)
   c2012Mdq.agregarRegistro(r5c12012Mdq)
   c2012Mdq.agregarRegistro(r6c12012Mdq)
   
   /////////////////
   ////////////////
   //  E N T R E     R I O S
   
   // PARANA
   //c2014parana
   val r1c12014Parana= new Registro(2014,parana1,entrerios,parana,50000,25000)
   val r2c12014Parana= new Registro(2014,parana2,entrerios,parana,60000,30000) 
   val r3c12014Parana= new Registro(2014,null,entrerios,parana,70000,35000)
   val r4c12014Parana= new Registro(2014,null,entrerios,parana,100000,10000)
   val r5c12014Parana =new Registro(2014,null,entrerios,parana,40000,30000)
   
   c2014Parana.agregarRegistro(r1c12014Parana)
   c2014Parana.agregarRegistro(r2c12014Parana)
   c2014Parana.agregarRegistro(r3c12014Parana)
   c2014Parana.agregarRegistro(r4c12014Parana)
   c2014Parana.agregarRegistro(r5c12014Parana)
   
   // c2013parana
   
   val r1c12013Parana= new Registro(2013,parana1,entrerios,parana,40000,20000)
   val r2c12013Parana = new Registro(2013,parana2,entrerios,parana,50000,25000) 
   val r3c12013Parana = new Registro(2013,null,entrerios,parana,60000,30000)
   val r4c12013Parana = new Registro(2013,null,entrerios,parana,90000,5000)
   val r5c12013Parana =new Registro(2013,null,entrerios ,parana,35000,20000)
   
   c2013Parana.agregarRegistro(r1c12013Parana)
   c2013Parana.agregarRegistro(r2c12013Parana)
   c2013Parana.agregarRegistro(r3c12013Parana)
   c2013Parana.agregarRegistro(r4c12013Parana)
   c2013Parana.agregarRegistro(r5c12013Parana)
   
   
   // COLON
   //c2014Colon
   val r1c12014Colon= new Registro(2014,colon1,entrerios,colon,50000,25000)
   val r2c12014Colon= new Registro(2014,null,entrerios,colon,100000,10000)
   val r3c12014Colon =new Registro(2014,null,entrerios,colon,40000,30000)
   
   c2014Colon.agregarRegistro(r1c12014Colon)
   c2014Colon.agregarRegistro(r2c12014Colon)
   c2014Colon.agregarRegistro(r3c12014Colon)
   
   // c2013Colon
   
   val r1c12013Colon = new Registro(2013,colon1,entrerios,colon,40000,20000)
   val r2c12013Colon = new Registro(2013,null,entrerios,colon,90000,5000)
   val r3c12013Colon =new Registro(2013,null,entrerios ,colon,35000,20000)
   
   c2013Colon.agregarRegistro(r1c12013Colon)
   c2013Colon.agregarRegistro(r2c12013Colon)
   c2013Colon.agregarRegistro(r3c12013Colon)
   
   
   /*
    *   //////////////////////
    *     S A N T A    FE
    *   \\\\\\\\\\\\\\\\\\\\\
    */   
   //ROSARIO
   
   //c2014rosario
   val r1c12014Rosario= new Registro(2014,rosario1,santaFe,rosario,120000,60000)
   val r2c12014Rosario= new Registro(2014,rosario2,santaFe,rosario,60000,30000) 
   val r3c12014Rosario= new Registro(2014,null,santaFe,rosario,70000,35000)
   val r4c12014Rosario= new Registro(2014,null,santaFe,rosario,100000,10000)
   val r5c12014Rosario =new Registro(2014,null,santaFe,rosario,40000,30000)
   
   c2014Rosario.agregarRegistro(r1c12014Rosario)
   c2014Rosario.agregarRegistro(r2c12014Rosario)
   c2014Rosario.agregarRegistro(r3c12014Rosario)
   c2014Rosario.agregarRegistro(r4c12014Rosario)
   c2014Rosario.agregarRegistro(r5c12014Rosario)
   
   // c2013rosario
   
   val r1c12013Rosario= new Registro(2013,rosario1,santaFe,rosario,40000,20000)
   val r2c12013Rosario = new Registro(2013,rosario2,santaFe,rosario,50000,25000) 
   val r3c12013Rosario = new Registro(2013,null,santaFe,rosario,60000,30000)
   val r4c12013Rosario = new Registro(2013,null,santaFe,rosario,90000,5000)
   val r5c12013Rosario =new Registro(2013,null,santaFe ,rosario,35000,20000)
   
   c2013Rosario.agregarRegistro(r1c12013Rosario)
   c2013Rosario.agregarRegistro(r2c12013Rosario)
   c2013Rosario.agregarRegistro(r3c12013Rosario)
   c2013Rosario.agregarRegistro(r4c12013Rosario)
   c2013Rosario.agregarRegistro(r5c12013Rosario)
   
   /*
    *  ---------------------
    *  |   M E N D O Z A   |
    *  ---------------------
    */
   //MENDOZACAPITAL
   //c2014mdzCapital
   val r1c12014MdzCapital= new Registro(2014,mendoza1,mendoza,mdzCapital,50000,25000)
   val r2c12014MdzCapital= new Registro(2014,mendoza2,mendoza,mdzCapital,60000,30000) 
   val r3c12014MdzCapital= new Registro(2014,null,mendoza,mdzCapital,70000,35000)
   val r4c12014MdzCapital= new Registro(2014,null,mendoza,mdzCapital,100000,10000)
   val r5c12014MdzCapital =new Registro(2014,null,mendoza,mdzCapital,40000,30000)
   
   c2014MendozaCapital.agregarRegistro(r1c12014MdzCapital)
   c2014MendozaCapital.agregarRegistro(r2c12014MdzCapital)
   c2014MendozaCapital.agregarRegistro(r3c12014MdzCapital)
   c2014MendozaCapital.agregarRegistro(r4c12014MdzCapital)
   c2014MendozaCapital.agregarRegistro(r5c12014MdzCapital)
   
   // c2013mdzCapital
   
   val r1c12013MdzCapital= new Registro(2013,mendoza1,mendoza,mdzCapital,40000,20000)
   val r2c12013MdzCapital = new Registro(2013,mendoza2,mendoza,mdzCapital,50000,25000) 
   val r3c12013MdzCapital = new Registro(2013,null,mendoza,mdzCapital,60000,30000)
   val r4c12013MdzCapital = new Registro(2013,null,mendoza,mdzCapital,90000,5000)
   val r5c12013MdzCapital =new Registro(2013,null,mendoza ,mdzCapital,35000,20000)
   
   c2013MendozaCapital.agregarRegistro(r1c12013MdzCapital)
   c2013MendozaCapital.agregarRegistro(r2c12013MdzCapital)
   c2013MendozaCapital.agregarRegistro(r3c12013MdzCapital)
   c2013MendozaCapital.agregarRegistro(r4c12013MdzCapital)
   c2013MendozaCapital.agregarRegistro(r5c12013MdzCapital)
   
   
   // SAn RAFAEL
   //c2014SanRafael
   val r1c12014SanRafael= new Registro(2014,sanRafael1,mendoza,sanRafael,80000,25000)
   val r2c12014SanRafael= new Registro(2014,null,mendoza,sanRafael,100000,10000)
   val r3c12014SanRafael =new Registro(2014,null,mendoza,sanRafael,40000,30000)
   
   c2014SanRafael.agregarRegistro(r1c12014SanRafael)
   c2014SanRafael.agregarRegistro(r2c12014SanRafael)
   c2014SanRafael.agregarRegistro(r3c12014SanRafael)
   
   // c2013SanRafael
   
   val r1c12013SanRafael = new Registro(2013,sanRafael1,mendoza,sanRafael,40000,20000)
   val r2c12013SanRafael = new Registro(2013,null,mendoza,sanRafael,90000,5000)
   val r3c12013SanRafael =new Registro(2013,null,mendoza ,sanRafael,35000,20000)
   
   c2013SanRafael.agregarRegistro(r1c12013SanRafael)
   c2013SanRafael.agregarRegistro(r2c12013SanRafael)
   c2013SanRafael.agregarRegistro(r3c12013SanRafael)
   
   
   ///////////////////////////////////////
   // T I E R R A   D E L   F U E G O  //
   // Rio Grande //
   //c2014RioGrande
   val r1c12014RioGrande= new Registro(2014,rioGrande1,tierraDelFuego,rioGrande,50000,25000)
   val r2c12014RioGrande= new Registro(2014,rioGrande2,tierraDelFuego,rioGrande,60000,30000) 
   val r3c12014RioGrande= new Registro(2014,rioGrande3,tierraDelFuego,rioGrande,30000,300000)
   val r4c12014RioGrande= new Registro(2014,null,tierraDelFuego,rioGrande,100000,10000)
   val r5c12014RioGrande= new Registro(2014,null,tierraDelFuego,rioGrande,150000,5000)
   val r6c12014RioGrande =new Registro(2014,null,tierraDelFuego,rioGrande,40000,30000)
   
   c2014RioGrande.agregarRegistro(r1c12014RioGrande)
   c2014RioGrande.agregarRegistro(r2c12014RioGrande)
   c2014RioGrande.agregarRegistro(r3c12014RioGrande)
   c2014RioGrande.agregarRegistro(r4c12014RioGrande)
   c2014RioGrande.agregarRegistro(r5c12014RioGrande)
   c2014RioGrande.agregarRegistro(r6c12014RioGrande)
   
   // c2013RioGrande
   
   val r1c12013RioGrande= new Registro(2013,rioGrande1,tierraDelFuego,rioGrande,40000,20000)
   val r2c12013RioGrande= new Registro(2013,rioGrande2,tierraDelFuego,rioGrande,50000,25000)
   val r3c12013RioGrande= new Registro(2013,rioGrande3 ,tierraDelFuego,rioGrande,60000,30000)
   val r4c12013RioGrande= new Registro(2013,null,tierraDelFuego,rioGrande,90000,5000)
   val r5c12013RioGrande=new Registro(2013,null,tierraDelFuego,rioGrande,35000,20000)
   val r6c12013RioGrande= new Registro(2013,null,tierraDelFuego,rioGrande,70000,150000) 
   
   c2013RioGrande.agregarRegistro(r1c12013RioGrande)
   c2013RioGrande.agregarRegistro(r2c12013RioGrande)
   c2013RioGrande.agregarRegistro(r3c12013RioGrande)
   c2013RioGrande.agregarRegistro(r4c12013RioGrande)
   c2013RioGrande.agregarRegistro(r5c12013RioGrande)
   c2013RioGrande.agregarRegistro(r6c12013RioGrande)
   
   // Ushuaia
   //c2014Ushuaia
   val r1c12014Ushuaia= new Registro(2014,ushuaia1,tierraDelFuego,ushuaia,50000,25000)
   val r2c12014Ushuaia= new Registro(2014,null,tierraDelFuego,ushuaia,100000,10000)
   val r3c12014Ushuaia =new Registro(2014,null,tierraDelFuego,ushuaia,40000,30000)
   
   c2014Ushuaia.agregarRegistro(r1c12014Ushuaia)
   c2014Ushuaia.agregarRegistro(r2c12014Ushuaia)
   c2014Ushuaia.agregarRegistro(r3c12014Ushuaia)
   
   // c2013Ushuaia
   
   val r1c12013Ushuaia = new Registro(2013,ushuaia1,tierraDelFuego,ushuaia,40000,20000)
   val r2c12013Ushuaia = new Registro(2013,null,tierraDelFuego,ushuaia,90000,5000)
   val r3c12013Ushuaia =new Registro(2013,null,tierraDelFuego ,ushuaia,35000,20000)
   
   c2013Ushuaia.agregarRegistro(r1c12013Ushuaia)
   c2013Ushuaia.agregarRegistro(r2c12013Ushuaia)
   c2013Ushuaia.agregarRegistro(r3c12013Ushuaia)
   
   
   ///////////////////////////
   // Carga de censos a sus fuentes
   
   fbaires.agregarCenso(2014, c2014Avellaneda )
   fbaires.agregarCenso(2013, c2013Avellaneda )
   fbaires.agregarCenso(2012, c2012Avellaneda )
   fbaires.agregarCenso(2014, c2014Quilmes )
   fbaires.agregarCenso(2013, c2013Quilmes )
   fbaires.agregarCenso(2012, c2012Quilmes)
   fbaires.agregarCenso(2014, c2014Tigre )
   fbaires.agregarCenso(2013, c2013Tigre)
   fbaires.agregarCenso(2012, c2012Tigre)
   fbaires.agregarCenso(2014, c2014Mdq)
   fbaires.agregarCenso(2013, c2013Mdq)
   fbaires.agregarCenso(2012, c2012Mdq)
   fbaires.agregarCenso(2014, c2014BahiaBlanca)
   fbaires.agregarCenso(2013, c2013BahiaBlanca)
   fbaires.agregarCenso(2012, c2012BahiaBlanca )
   
   flitoral.agregarCenso(2014, c2014Parana )
   flitoral.agregarCenso(2013, c2013Parana )
   flitoral.agregarCenso(2014, c2014Colon )
   flitoral.agregarCenso(2013, c2013Colon )
   flitoral.agregarCenso(2014, c2014Rosario)
   flitoral.agregarCenso(2013, c2013Rosario )
   
   fcuyo.agregarCenso(2014, c2014MendozaCapital )
   fcuyo.agregarCenso(2013, c2013MendozaCapital )
   fcuyo.agregarCenso(2014, c2014SanRafael )
   fcuyo.agregarCenso(2013, c2013SanRafael  )
   
   fpatagonia.agregarCenso(2014, c2014RioGrande )
   fpatagonia.agregarCenso(2013, c2013RioGrande )
   fpatagonia.agregarCenso(2014, c2014Ushuaia )
   fpatagonia.agregarCenso(2013, c2013Ushuaia )
   
   // DAOS
   
   val empresaDao:EmpresaDao = new EmpresaDao()
   val provinciaDao:ProvinciaDao = new ProvinciaDao()
   val departamentoDao:DepartamentoDao = new DepartamentoDao()
   val fuenteDao:FuenteDao = new FuenteDao()
   val censoDao:CensoDao = new CensoDao()
   val registroDao:RegistroDao = new RegistroDao()
   val grupoDao:GrupoDepartamentoDao = new GrupoDepartamentoDao()   
   
   //Simulacion guardado en base de datos
   //empresas
   empresaDao.save(ave1)
   empresaDao.save(ave2)
   empresaDao.save(quil1)
   empresaDao.save(quil2)
   empresaDao.save(tigre1)
   empresaDao.save(tigre2)
   empresaDao.save(bb1)
   empresaDao.save(mdq1)
   empresaDao.save(mdq2)
   empresaDao.save(mdq3)
   empresaDao.save(rosario1)
   empresaDao.save(rosario2)
   empresaDao.save(colon1)
   empresaDao.save(parana1)
   empresaDao.save(parana2)
   empresaDao.save(mendoza1)
   empresaDao.save(mendoza2)
   empresaDao.save(sanRafael1)
   empresaDao.save(rioGrande1)
   empresaDao.save(rioGrande2)
   empresaDao.save(rioGrande3)
   empresaDao.save(ushuaia1)
   
   

   
   //dptos
   departamentoDao.save(avellaneda )
   departamentoDao.save(quilmes )
   departamentoDao.save(tigre )
   departamentoDao.save(bahiaBlanca )
   departamentoDao.save(mdq  )
   departamentoDao.save(colon)
   departamentoDao.save(mdzCapital )
   departamentoDao.save(sanRafael  )
   departamentoDao.save(rosario  )
   departamentoDao.save(rioGrande  )
   departamentoDao.save(ushuaia  )
   departamentoDao.save(parana  )
   
   //grupos
   
   grupoDao.save(zonasPortuarias )
   grupoDao.save(conurbano)
   grupoDao.save(litoral )
   grupoDao.save(cuyo)
   
   //fuentes
   fuenteDao.save(fbaires )
   fuenteDao.save(flitoral )
   fuenteDao.save(fcuyo )
   fuenteDao.save(fpatagonia )
   
   
   //censos
   censoDao.saveAndSetSourceToRegisters(c2012Avellaneda )
   censoDao.saveAndSetSourceToRegisters(c2013Avellaneda )
   censoDao.saveAndSetSourceToRegisters(c2014Avellaneda )
   censoDao.saveAndSetSourceToRegisters(c2012Quilmes )
   censoDao.saveAndSetSourceToRegisters(c2013Quilmes)
   censoDao.saveAndSetSourceToRegisters(c2014Quilmes )
   censoDao.saveAndSetSourceToRegisters(c2012Tigre )
   censoDao.saveAndSetSourceToRegisters(c2013Tigre )
   censoDao.saveAndSetSourceToRegisters(c2014Tigre )
   censoDao.saveAndSetSourceToRegisters(c2012Mdq )
   censoDao.saveAndSetSourceToRegisters(c2013Mdq)
   censoDao.saveAndSetSourceToRegisters(c2014Mdq)
   censoDao.saveAndSetSourceToRegisters(c2012BahiaBlanca )
   censoDao.saveAndSetSourceToRegisters(c2013BahiaBlanca)
   censoDao.saveAndSetSourceToRegisters(c2014BahiaBlanca)
   
   censoDao.saveAndSetSourceToRegisters(c2014Parana)
   censoDao.saveAndSetSourceToRegisters(c2013Parana)
   censoDao.saveAndSetSourceToRegisters(c2014Colon)
   censoDao.saveAndSetSourceToRegisters(c2013Colon)
   
   censoDao.saveAndSetSourceToRegisters(c2014Rosario )
   censoDao.saveAndSetSourceToRegisters(c2013Rosario)
   
   censoDao.saveAndSetSourceToRegisters(c2014MendozaCapital )
   censoDao.saveAndSetSourceToRegisters(c2013MendozaCapital )
   censoDao.saveAndSetSourceToRegisters(c2014SanRafael )
   censoDao.saveAndSetSourceToRegisters(c2013SanRafael )
   
   censoDao.saveAndSetSourceToRegisters(c2014RioGrande )
   censoDao.saveAndSetSourceToRegisters(c2013RioGrande )
   censoDao.saveAndSetSourceToRegisters(c2014Ushuaia )
   censoDao.saveAndSetSourceToRegisters(c2013Ushuaia )
   
      //provincias
//   provinciaDao.save(baires)
//   provinciaDao.save(entrerios )
//   provinciaDao.save(santaFe )
//   provinciaDao.save(mendoza )
//   provinciaDao.save(tierraDelFuego )
   r2c12012Avellaneda.anioDeObtencionDeDatos = 2012
   r4c12012Avellaneda.fuente = flitoral 
   //
   provinciaDao.saveAndIncludeRegisters(baires, registroDao)
   provinciaDao.saveAndIncludeRegisters(entrerios , registroDao)
   provinciaDao.saveAndIncludeRegisters(santaFe , registroDao)
   provinciaDao.saveAndIncludeRegisters(mendoza , registroDao)
   provinciaDao.saveAndIncludeRegisters(tierraDelFuego , registroDao)
   
   
//   
//Prints para mostrar resultados
   
//   println(registroDao.elements.size)
//   println(empresaDao.nombreEmpresaConMayorGananciaEnAnio(2014))
//    println("Cantidad total de registros "+registroDao.elements.size )
//    println(provinciaDao.generarMapaEmpresaMontoVentaTotalPorAnio(2014))
//    println(empresaDao.generarListaConNombresDeEmpresasConVentasTotalesMayoresA(150000))
//   println(registroDao.elements.count(x => (x.departamento.eq(mdq))) + 
//       registroDao.elements.count(x => (x.departamento.eq(bahiaBlanca ))) +
//       registroDao.elements.count(x => (x.departamento.eq(rosario ))) +
//       registroDao.elements.count(x => (x.departamento.eq(rioGrande ))) +
//       registroDao.elements.count(x => (x.departamento.eq(ushuaia ))))
//   println(ushuaia.registros)
//   println(departamentoDao.generarMapaEmpresaMontoVentaTotalPorAnioYDepartamento(2012))
//   println(grupoDao.generarMapaEmpresaMontoVentaTotalPorAnioYGrupo(2014))
//   println(fuenteDao.generarMapaEmpresaMontoVentaTotalPorAnioYFuente(2014))
//   println(baires.registrosIdentificadosConVentasMayorA(50000))
//   println(provinciaDao.registrosIdentificadosConVentasMayoresA(50000))
//   println(provinciaDao.generarListaConNombresDeEmpresasConVentasTotalesMayoresA(1))
//   println(mdq1.aniosConVentasMayorA(35000))
//   println(empresaDao.empresasConRegistrosEnAnios(2012,2013,2014))
//   println(mdq1.registrosDeAnios(2012,2013,2014))
//   println(mdq1.obtenerMontoVentasTotalEnAnios(mdq1.registrosDeAnios(2012,2013,2014)))
//   println(registroDao.registrosConVentasMayoresAEnAnios(1, 2012))
//   println(provinciaDao.generarMapaEmpresaMontoVentaTotalPorAnios(2012,2013,2014))
   //Assert
   ///////////////////////
   //Parte 1 del TP
   //////////////////////
	@Test def montoVentas() {
    assertEquals(censoDao.montoVentasTotalCensosDeAnio(2014)  , 3640000)
    assertEquals(censoDao.montoVentasTotalCensosDeAnio(2013) , 3000000)
    assertEquals(censoDao.montoVentasTotalCensosDeAnio(2012) , 1155000) 
  }
   @Test def montoGanancias(){
      assertEquals(censoDao.montoGananciasTotalCensosDeAnio(2014) , 1874999)
      assertEquals(censoDao.montoGananciasTotalCensosDeAnio(2013) , 1280000)
      assertEquals(censoDao.montoGananciasTotalCensosDeAnio(2012), 456000)
   }
   @Test def registrosVentas(){
     assertEquals(registroDao.cantidadDeRegistrosTotalesConVentasMayorA(125000) ,2)
   }
   @Test def registrosGanancias(){
     assertEquals(registroDao.cantidadDeRegistrosTotalesConGananciasMayorA(250000) ,2)
   }
   @Test def registrosTasaGanancias(){
     assertEquals(registroDao.cantidadDeRegistrosTotalesConTasaDeGananciaMayorA(500) ,2)
   }
   
    @Test def montoPorProvinciaYAnio(){
      assertEquals(provinciaDao.generarMapaEmpresaMontoVentaTotalPorAnio(2012).size,1)
   }
   
    @Test def nombreDeEmpresasCuyosventasSuperenUnMonto(){
      assertEquals(empresaDao.generarListaConNombresDeEmpresasConVentasTotalesMayoresA(150000).size,1)
    }
    
    @Test def fuentesQueAportaronAlMenosUnRegistroEnUnAnio(){
      assertEquals(fuenteDao.fuentesConRegistrosEnAnio(2012).size,1)
    }
    
    @Test def empresaConMayorGananciaEnAnio(){
      assertEquals(empresaDao.nombreEmpresaConMayorGananciaEnAnio(2014),"Empresa Rio Grande 3")
    }
    
    @Test def esSospechosa(){
      assertEquals(ave1.esSospechosa , false)
    }
    
    @Test def noEsSospechosa(){
      assertEquals(rioGrande3.esSospechosa , true)
    }
    
    @Test def esSolida(){
      assertEquals(rioGrande1.esSolida , true)
    }
     ////////////////////////////////
    // FIN PARTE 1
   
    ///PARTE  2///
    //Montos de venta
    @Test def montoVentasPorProvinciaYAnio(){
      assertEquals(censoDao.montoVentasTotalProvinciaYAnio(baires, 2014)  , 1580000)
    }
    
    @Test def montoVentasPorDepartamentoYAnio(){
      assertEquals(censoDao.montoVentasTotalDepartamentoYAnio(avellaneda , 2014)  , 320000)
    }
    
    @Test def montoVentasPorGrupoYAnio(){
      assertEquals(censoDao.montoVentasTotalGrupoYAnio(zonasPortuarias , 2014) , 1630000)
    }
    
    @Test def montoVentasPorFuenteYAnio(){
      assertEquals(censoDao.montoVentasTotalFuenteYAnio(flitoral , 2014)  , 900000)
    }
    
    //Monto ganancias
    @Test def montoGananciasPorProvinciaYAnio(){
      assertEquals(censoDao.montoGananciasTotalProvinciaYAnio(baires, 2014)  , 854999)
    }
    
    @Test def montoGananciasPorDepartamentoYAnio(){
      assertEquals(censoDao.montoGananciasTotalDepartamentoYAnio(mdq , 2014)  , 399999)
    }
    
    @Test def montoGananciasPorGrupoYAnio(){
      assertEquals(censoDao.montoGananciasTotalGrupoYAnio(zonasPortuarias , 2014) , 1094999)
    }
    
    @Test def montoGananciasPorFuenteYAnio(){
      assertEquals(censoDao.montoGananciasTotalFuenteYAnio(flitoral , 2014)  , 360000)
    }

    //VentasMayoresA
  @Test def registrosVentasEnProvincia(){
    assertEquals(registroDao.cantidadDeRegistrosProvinciaConVentasMayoresA(140000, baires)  , 1)
   }
    
  @Test def registrosVentasEnDepartamento(){
    assertEquals(registroDao.cantidadDeRegistrosDepartamentoConVentasMayoresA(140000, mdq)  , 1)
   }
  
  @Test def registrosVentasEnGrupo(){
    assertEquals(registroDao.cantidadDeRegistrosGrupoConVentasMayoresA(10, zonasPortuarias )  , 55)
   }
    
  @Test def registrosVentasDeFuente(){
    assertEquals(censoDao.cantidadDeRegistrosFuenteConVentasMayoresA(100000, flitoral  )  , 1)
   }
    
    //Ganancias mayoresA
   @Test def registrosGananciasEnProvincia(){
     assertEquals(registroDao.cantidadDeRegistrosProvinciaConGananciasMayoresA(100000, baires)  , 2)
   }
   
   @Test def registrosGananciasEnDepartamento(){
     assertEquals(registroDao.cantidadDeRegistrosDepartamentoConGananciasMayoresA(140000, mdq)  , 2)
   }   
   
   @Test def registrosGananciasEnGrupo(){
     assertEquals(registroDao.cantidadDeRegistrosGrupoConGananciasMayoresA(1, zonasPortuarias )  , 54)
   }
   
   @Test def registrosGananciasDeFuente(){
     assertEquals(censoDao.cantidadDeRegistrosFuenteConGananciasMayoresA(50000, flitoral  )  , 1)
   }
   
   //Tasa de ganancia

            
   @Test def registrosTasaGananciasEnProvinciaMayorA(){
     assertEquals(registroDao.cantidadDeRegistrosProvinciaConTasaDeGananciaMayorA(80, baires)  , 7)
   }
   
   @Test def registrosTasaGananciasEnDepartamentoMayorA(){
     assertEquals(registroDao.cantidadDeRegistrosDepartamentoConTasaDeGananciaMayorA(100, mdq)  , 2)
   }   
   
   @Test def registrosTasaGananciasEnGrupoMayorA(){
     assertEquals(registroDao.cantidadDeRegistrosGrupoConTasaDeGananciaMayorA(100, zonasPortuarias )  , 4)
   }   

   @Test def registrosTasaGananciasDeFuenteMayorA(){
     assertEquals(censoDao.cantidadDeRegistrosFuenteConTasaDeGananciaMayorA(70, flitoral  )  , 3)
   }   
   
   //Mapas de venta
   
    @Test def montoPorDepartamentoYAnio(){
      assertEquals(departamentoDao.generarMapaEmpresaMontoVentaTotalPorAnioYDepartamento(2012).size,5)
   }
    
    @Test def montoPorGrupoYAnio(){
      assertEquals(grupoDao.generarMapaEmpresaMontoVentaTotalPorAnioYGrupo(2014).size,4)
   }    
 
    @Test def montoPorFuenteYAnio(){
      assertEquals(fuenteDao.generarMapaEmpresaMontoVentaTotalPorAnioYFuente(2014).size,4)
   }
    
   // NombresEmpresas 
    @Test def nombreDeEmpresasCuyasVentasSuperenUnMontoEnProvincia(){
      assertEquals(provinciaDao.generarListaConNombresDeEmpresasConVentasTotalesMayoresAEnProvincia(1,baires).size,10)
    }

    @Test def nombreDeEmpresasCuyasVentasSuperenUnMontoEnDepartamento(){
      assertEquals(departamentoDao.generarListaConNombresDeEmpresasConVentasTotalesMayoresAEnDepartamento(50000,mdq).size,2)
    }
    
    @Test def nombreDeEmpresasCuyasVentasSuperenUnMontoEnGrupo(){
      assertEquals(grupoDao.generarListaConNombresDeEmpresasConVentasTotalesMayoresAEnGrupo(50000,litoral ).size,1)
    }

    @Test def nombreDeEmpresasCuyosventasSuperenUnMontoDeFuente(){
      assertEquals(fuenteDao.generarListaConNombresDeEmpresasConVentasTotalesMayoresADeFuente(1,flitoral ).size,5)
    }
    
    //FuentesConRegistros
    @Test def fuentesQueAportaronAlMenosUnRegistroEnUnAnioEnProvincia(){
      assertEquals(fuenteDao.fuentesConRegistrosEnAnioYProvincia(2012,baires).size,1)
    }

    @Test def fuentesQueAportaronAlMenosUnRegistroEnUnAnioEnDepartamento(){
      assertEquals(fuenteDao.fuentesConRegistrosEnAnioYDepartamento(2012,rosario).size,0)
    }

    @Test def fuentesQueAportaronAlMenosUnRegistroEnUnAnioEnGrupo(){
      assertEquals(fuenteDao.fuentesConRegistrosEnAnioYGrupo(2014,zonasPortuarias ).size,3)
    }

    
    //EmpresaNombre
    @Test def empresaConMayorGananciaEnAnioEnProvincia(){
      assertEquals(empresaDao.nombreEmpresaConMayorGananciaEnAnioYProvincia(2014,baires),"Empresa Mar del Plata 3")
    }

    @Test def empresaConMayorGananciaEnAnioEnDepartamento(){
      assertEquals(departamentoDao.nombreEmpresaConMayorGananciaEnAnioYDepartamento(2014,avellaneda ),"Empresa Avellaneda 2")
    }
    
    @Test def empresaConMayorGananciaEnAnioEnGrupo(){
      assertEquals(grupoDao.nombreEmpresaConMayorGananciaEnAnioYGrupo(2014,zonasPortuarias ),"Empresa Rio Grande 3")
    }
    
    @Test def empresaConMayorGananciaEnAnioDeFuente(){
      assertEquals(fuenteDao.nombreEmpresaConMayorGananciaEnAnioYFuente(2014,flitoral ),"Empresa Rosario 1")
    }    
    //Grupos
    
    @Test def homogeneidad(){
      assertEquals(zonasPortuarias.esHomogeneo,false)
    }
    
    @Test def homogeneidad2(){
      assertEquals(conurbano.esHomogeneo,true)
    }
    
    @Test def provinciaEnGrupo(){
      assertEquals(zonasPortuarias.hayDepartamentosDeProvincia(tierraDelFuego ),true)
    }

      
    
      
    
    ////////////////////
    // P A R T E  3  //
    
    
    @Test def esConsistente(){
      assertEquals(r1c12012Avellaneda .esConsistenteMixin,true)
    }
    
    // Registro de buenos aires con fuente del litoral
    @Test def esConsistente2(){
      assertEquals(r4c12012Avellaneda .esConsistenteMixin,false)
    }
    
    //Registro con anio de obtencion igual al anio que hace referencia el registro
    @Test def esConsistente3(){
      assertEquals(r2c12012Avellaneda .esConsistenteMixin,false)
    }
    
    @Test def ventasEnAnios(){
      assertEquals(mdq1.obtenerMontoVentasTotalEnAnios(2012,2013,2014),125000)
    }
    
    @Test def ganaciaEnAnios(){
      assertEquals(mdq1.obtenerMontoGananciasTotalEnAnios(2012,2013,2014),63000)
    }
    
    @Test def registrosDe2012MayorA1DeVentas(){
      assertEquals(registroDao.registrosConVentasMayoresAEnAnios(1, 2012),24)
    }
    
    @Test def registrosDe2012y2013y2014y2015MayorA1DeVentas(){
      assertEquals(registroDao.registrosConVentasMayoresAEnAnios(1, 2012,2013,2014,2015),132)
    }
    
    @Test def registrosDe2014MayorA100000DeVentas(){
      assertEquals(registroDao.registrosConVentasMayoresAEnAnios(100000, 2014),3)
    }
    
    @Test def registrosDe2012MayorA1DeGanacia(){
      assertEquals(registroDao.registrosConGananciasMayoresAEnAnios(1, 2012),23)
    }
    
    @Test def registrosDe2012y2013y2014y2015MayorA1DeGanancias(){
      assertEquals(registroDao.registrosConGananciasMayoresAEnAnios(1, 2012,2013,2014,2015),131)
    }
    
    @Test def registrosDe2014MayorA100DeGanancias(){
      assertEquals(registroDao.registrosConGananciasMayoresAEnAnios(100000, 2014),2)
    }
    
    @Test def registrosDe2012MayorA1DeTasaDeGanacia(){
      assertEquals(registroDao.registrosConTasaDeGananciaMayorAEnAnios(1, 2012),23)
    }
    
    @Test def registrosDe2012y2013y2014y2015MayorA1DeTasaGanancias(){
      assertEquals(registroDao.registrosConTasaDeGananciaMayorAEnAnios(1, 2012,2013,2014,2015),131)
    }
    
    @Test def registrosDe2014MayorA100DeTasaGanancias(){
      assertEquals(registroDao.registrosConTasaDeGananciaMayorAEnAnios(100, 2014),2)
    }
    
    @Test def mapaProvinciaPorVentas1(){
      assertEquals(provinciaDao.generarMapaEmpresaMontoVentaTotalPorAnios(2012).size,1)
    }
    
    @Test def mapaProvinciaPorVentas2(){
      assertEquals(provinciaDao.generarMapaEmpresaMontoVentaTotalPorAnios(2012,2013,2014,2015).size,5)
    }
    
    @Test def mapaProvinciaPorVentas3(){
      assertEquals(provinciaDao.generarMapaEmpresaMontoVentaTotalPorAnios(2012,2013,2014,2015).filter(_._1.==(4070000)).toParArray.head._2.head ,baires)
    }
    
    
    @Test def nombreDeEmpresasCuyasVentasSuperenUnMontoEnAnios1(){
      assertEquals(empresaDao.generarListaConNombresDeEmpresasConVentasTotalesMayoresAEnAnios(150000,2012,2013,2014).head,"Empresa Rosario 1")
    }
    
    @Test def nombreDeEmpresasCuyasVentasSuperenUnMontoEnAnios2(){
      assertEquals(empresaDao.generarListaConNombresDeEmpresasConVentasTotalesMayoresAEnAnios(1,2012,2013,2014).size,22)
    }
    
    @Test def fuentesQueAportaronAlMenosUnRegistroEnAnios1(){
      assertEquals(fuenteDao.fuentesConRegistrosEnAnios(2012).size,1)
    }
    
    @Test def fuentesQueAportaronAlMenosUnRegistroEnAnios2(){
      assertEquals(fuenteDao.fuentesConRegistrosEnAnios(2012,2013,2014,2035).size,4)
    }
    
    @Test def empresaConMayorGananciaEnAnios1(){
      assertEquals(empresaDao.nombreEmpresaConMayorGananciaEnAnios(2012),"Empresa Mar del Plata 3")
    }
    
    @Test def empresaConMayorGananciaEnAnios2(){
      assertEquals(empresaDao.nombreEmpresaConMayorGananciaEnAnios(2013,2014),"Empresa Rio Grande 3")
    }
    
    @Test def empresaConMayorGananciaEnAnios3(){
      assertEquals(empresaDao.nombreEmpresaConMayorGananciaEnAnios(2013,2014,2012,1980),"Empresa Mar del Plata 3")
    }
    
    
}
