import { Component, Inject, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-AprobarT',
  templateUrl: './Aprobar.component.html',
})
export class AprobarTComponent{
  alumnos = new FormControl('');

  ListaAlumnos: string[] = ['alumno1', 'alumno 2', 'Alumno 3', 'Alumno 4', 'Alumno 5'];
}