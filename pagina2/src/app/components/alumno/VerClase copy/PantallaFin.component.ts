import { Component } from '@angular/core';


@Component({
  selector: 'app-PantallaFin',
  templateUrl: './PantallaFin.component.html',
  styleUrls: ['./PantallaFin.component.scss']
})


export class PantallaFinComponent{
  xpFin="";
  constructor(){
    
  }
   result=false;
  cargar(){
    this.result=true;
    console.log(localStorage.getItem("xp"));
    return localStorage.getItem("xp");
  }
  
}