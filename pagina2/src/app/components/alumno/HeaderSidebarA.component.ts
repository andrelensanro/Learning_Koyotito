import { Component } from '@angular/core';


@Component({
  selector: 'app-HeaderSidebarA',
  templateUrl: './HeaderSidebarA.component.html',
  styleUrls: ['./HeaderSidebarA.component.scss']
})
export class  HeaderSidebarAComponent{
  menuType: String = "General";
  constructor() {}

  
  SelClase(valor:string): void{
    localStorage.setItem("clase",valor);
}
}