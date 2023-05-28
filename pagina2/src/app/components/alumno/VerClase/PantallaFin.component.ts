import { Component } from '@angular/core';


@Component({
  selector: 'app-PantallaFinA',
  templateUrl: './PantallaFin.component.html',
  styleUrls: ['./PantallaFin.component.scss']
})


export class PantallaFinAComponent{
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