import { Component, Inject, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-AprobarP',
  templateUrl: './AprobarP.component.html',
})
export class AprobarPComponent{
  alumnos = new FormControl('');

  ListaAlumnos: string[] = ['grupoI', 'grupoII', 'MSVXE 3', 'Grupo 4', 'ADSSA 28'];
  constructor(private toastr: ToastrService){}


  Alta(){
    this.toastr.success('Aprobado al grupo.', 'Éxito',{timeOut: 7000});
  }
}