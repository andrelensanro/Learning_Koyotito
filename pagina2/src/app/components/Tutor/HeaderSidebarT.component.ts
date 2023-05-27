import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';


@Component({
  selector: 'app-HeaderSidebarT',
  templateUrl: './HeaderSidebarT.component.html',
  styleUrls: ['./HeaderSidebarT.component.scss']
})
export class  HeaderSidebarTComponent{
  menuType: String = "General";
  constructor(public dialog: MatDialog) {}

  SelClase(valor:string): void{
    localStorage.setItem("clase",valor);
}
}