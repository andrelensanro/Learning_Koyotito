import { Component, Inject, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ToastrService } from 'ngx-toastr';
@Component({
  selector: 'app-Invitacion',
  templateUrl: './Invitacion.component.html',
  styleUrls: ['./Invitacion.component.scss']
})
export class InvitacionComponent{
  constructor(private toastr: ToastrService) {}

  Invitacion(){
    this.toastr.success('Invitación enviada', 'Éxito',{timeOut: 5000});
  }
}



