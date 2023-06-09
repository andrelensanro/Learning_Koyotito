import { Component, Inject, OnInit } from '@angular/core';
import {MatDialog, MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';
import { CerrarSesionComponent } from '../../sesion/CerrarSesioncomponent';
import { CrearGrupoComponent } from '../Grupos/CrearGrupo.component';
import { ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-InicioProf',
  templateUrl: './InicioProf.component.html',
  styleUrls: ['../FondoP.component.scss', './InicioP.component.scss']
})
export class InicioProfComponent implements OnInit{
  constructor(
    public dialog: MatDialog,
    private route: ActivatedRoute,

  ){}
   public greaterThan(num: number) {    return num > 0;  }

//constructor(private authService :AuthService){}

CrearGrupoDialog(): void{


  const dialogRef = this.dialog.open(CrearGrupoComponent, {
  //  data: {name: this.name},
  });
}
  
/*
  display(){
    if (this.authService.isLoggedIn()) {
      return "Cerrar sesión";      
    }
    return "Iniciar sesión";
  }
  */
  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      const parametro = params.get('idUsuario');
      // Haz algo con el parámetro variable
      console.log(parametro);
    });
  }





}