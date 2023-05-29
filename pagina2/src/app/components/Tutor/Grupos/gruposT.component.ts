import { Component, Inject, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
@Component({
  selector: 'app-GruposT',
  templateUrl: './gruposT.component.html',
  styleUrls: ['./gruposT.component.scss', '../FondoT.component.scss']
})
export class GruposTComponent{
  SelClase(valor:string): void{
      localStorage.setItem("clase",valor);
    }
}