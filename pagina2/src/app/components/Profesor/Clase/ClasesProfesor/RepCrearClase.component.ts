
import { Component, OnInit } from "@angular/core";
import { FormControl } from "@angular/forms";


@Component({
    selector: 'app-RepCrearClase',
    templateUrl: "./RepCrearClase.component.html",
    styleUrls: ['./RepCrearClase.component.scss']
  })
  
  export class RepCrearClaseComponent{
    previews: string[] = [];
    grupos = new FormControl('');

  ListaGrupo: string[] = ['Grupo 1', 'Grupo 2', 'Grupo 3', 'Grupo 4', 'Grupo 5', 'Grupo 6'];



    
    datos = new Tarjeta(); 
}


  export class Tarjeta{
    TipoLetra: string = "Arial";
    TamLetra: string = "12";
    Instruccion : string | undefined;
    Respuesta: string | undefined;
    Idioma: string = "Español";
    Titulo: string | undefined;
    Tags: string | undefined;
  }