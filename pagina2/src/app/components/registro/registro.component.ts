import { Component } from '@angular/core';

@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
})
export class RegistroComponent {
  public pseudonimo: boolean=true;
  public profesor: boolean=true;
  public texto: string="";

  constructor(){}

  OpProf(){
    this.pseudonimo = true,
    this.profesor = false
  }

  OpTut(){
    this.pseudonimo = false,
    this.profesor = true
  }

  limpiar(){
    this.texto=''
  }
}
