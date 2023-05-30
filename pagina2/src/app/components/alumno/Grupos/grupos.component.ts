import { Component, Inject, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
@Component({
  selector: 'app-GruposA',
  templateUrl: './grupos.component.html',
  styleUrls: ['./grupos.component.scss', '../FondoA.component.scss']
})
export class GruposAComponent{
  SelClase(valor:string): void{
      localStorage.setItem("clase",valor);
    }
}