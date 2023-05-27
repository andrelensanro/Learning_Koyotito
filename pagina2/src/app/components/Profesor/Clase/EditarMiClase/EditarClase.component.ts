
import { Component, OnInit } from "@angular/core";
import { MatDialog } from "@angular/material/dialog";
import { GuardarClaseComponent } from "../ClasesProfesor/GuardarClase.component";
interface Leng {
  valor: string;
  viewValue: string;
}
@Component({
    selector: 'app-EditarClase',
    templateUrl: "./EditarClase.component.html",
    styleUrls: ['./EditarClase.component.scss','../../FondoP.component.scss']
  })
  
  export class EditarClaseComponent{
    constructor(public dialog: MatDialog){

    }

    
    idiomas: Leng[] = [

      {valor: 'esp-1', viewValue: 'Español'},
      {valor: 'eng-2', viewValue: 'Inglés'},
    ];


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


  GuardarDialog(): void{
    const dialogRef = this.dialog.open(GuardarClaseComponent, { disableClose: true
      //  data: {name: this.name},
      });
  }


  public message1!: string;


  public imagePath;
  imgURL: any;
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
}