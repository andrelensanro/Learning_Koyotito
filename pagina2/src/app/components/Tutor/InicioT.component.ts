import { Component, Inject, OnInit } from '@angular/core';
import {MatDialog, MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';
import { AuthService } from '../services/authService.component';
import { Router } from '@angular/router';
import { CerrarSesionComponent } from '../sesion/CerrarSesioncomponent';
import { MenuComponent } from '../menu/menu.component';
import { Dialog } from '@angular/cdk/dialog';

@Component({
  selector: 'app-InicioT',
  templateUrl: './InicioT.component.html',
  styleUrls: ['./FondoT.component.scss', './InicioT.component.scss']
})
export class InicioTComponent{
  constructor(public dialog: MatDialog){}
//constructor(private authService :AuthService){}

DCerrarSesion(): void{
  const dialogRef = this.dialog.open(CerrarSesionComponent, {
    //  data: {name: this.name},
    });
}
  
public greaterThan(num: number) {    return num > 0;  }
/*
  display(){
    if (this.authService.isLoggedIn()) {
      return "Cerrar sesión";      
    }
    return "Iniciar sesión";
  }
  */
  SelClase(valor:string): void{
    if(valor==="matematicas"){
      localStorage.setItem("clase","Matemáticas");
    }else if(valor==="espanol"){
      localStorage.setItem("clase","Español");
    }else if(valor==="artes"){
      localStorage.setItem("clase","Artes");
    }else if(valor==="ciencias"){
      localStorage.setItem("clase","Conocimientos Naturales");
    }else if(valor==="logica"){
      localStorage.setItem("clase","Razonamiento lógico");
    }else if(valor==="ingles"){
      localStorage.setItem("clase","Inglés");
    }else{
      localStorage.setItem("clase",valor);
    }
}

} 