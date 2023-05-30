import { HttpClient, HttpEventType, HttpResponse } from "@angular/common/http";
import { Component, OnInit } from "@angular/core";
import { of,Observable } from "rxjs";
import { CrearClaseService } from "./CrearClase.service";
import { FormControl } from "@angular/forms";
import { GuardarClaseComponent } from "./GuardarClase.component";
import { MatDialog } from "@angular/material/dialog";


interface Leng {
  valor: string;
  viewValue: string;
}
var ImgHidden = false;
@Component({
    selector: 'app-CrearClase',
    templateUrl: "./CrearClase.component.html",
    styleUrls: ['./CrearClase.component.scss','../../FondoP.component.scss']
  })
  
  export class CrearClaseComponent{
    idiomas: Leng[] = [

      {valor: 'esp-1', viewValue: 'Español'},
      {valor: 'eng-2', viewValue: 'Inglés'},
    ];
    selectedFood = this.idiomas[1].valor;
  selectedFiles?: FileList;
  selectedFileNames: string[] = [];

  progressInfos: any[] = [];
  message: string[] = [];

  previews: string[] = [];
  imageInfos?: Observable<any>;


    grupos = new FormControl('');

  ListaGrupo: string[] = ['Grupo 1', 'Grupo 2', 'Grupo 3', 'Grupo 4', 'Grupo 5', 'Grupo 6'];
    
    datos = new Tarjeta(); 
    itemsAsObjects = [{id: 0, name: 'Clase', readonly: true}];

    autocompleteItemsAsObjects = [
      {value: 'Ciencias', id: 0},
      {value: 'Matemáticas', id: 1},
      {value: 'Historia', id: 2},
      {value: 'Vocabulario', id: 3},
      {value: '1', id: 4},
      {value: '2', id: 5},
      {value: '3', id: 6},
      {value: 'Básico', id: 7},
      {value: 'Intermedio', id: 8},
      {value: 'Difícil', id: 9},
  ];

  public imagePath;
  imgURL: any;
  public message1!: string;
 
  preview(files) {
    if (files.length === 0)
      return;
 
    var mimeType = files[0].type;
    if (mimeType.match(/image\/*/) == null) {
      this.message1 = "Only images are supported.";
      return;
    }
 
    var reader = new FileReader();
    this.imagePath = files;
    reader.readAsDataURL(files[0]); 
    reader.onload = (_event) => { 
      this.imgURL = reader.result;
      console.log(this.imagePath);
    }
  }


  vacio(files){
    console.log("Vacio: "+ files);
    if (files.length === 0){
      ImgHidden=true;
      console.log("Vacio 2: "+ files);
    }else{
      console.log("Falso");
    }
  }


  constructor(public dialog: MatDialog){

  }


  GuardarDialog(): void{
    const dialogRef = this.dialog.open(GuardarClaseComponent, { disableClose: true
      //  data: {name: this.name},
      });
  }
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