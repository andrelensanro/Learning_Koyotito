import { Component, Inject, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { InvitacionComponent } from './Invitacion.component';
@Component({
  selector: 'app-GrupoEsp',
  templateUrl: './grupoEsp.component.html',
  styleUrls: ['./grupoEsp.component.scss', '../FondoP.component.scss']
})
export class GrupoEspComponent{


  constructor(public dialog: MatDialog){}

  DInvitacion(): void {
      const dialogRef = this.dialog.open(InvitacionComponent, {
      //  data: {name: this.name},
      });
  
    }
}