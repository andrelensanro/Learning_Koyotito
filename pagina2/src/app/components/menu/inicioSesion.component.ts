import { Component, Inject, OnInit } from '@angular/core';
import {MatDialog, MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';
import { AuthService } from '../services/authService.component';
import { UserDTO } from '../modelo/userDTO.model';
import { RegistroComponent } from '../registro/registro.component';
import { Usuario } from 'app/models/usuario';
import { Router } from '@angular/router';
import { UsuarioService } from 'app/services/usuario.service';
/*
export interface DialogData {
    contra: string;
    correo: string;
  }

  /*
  export class algo{
    constructor(
        public dialogRef: MatDialogRef<inicioSesionDialog>,
        @Inject(MAT_DIALOG_DATA) public data: DialogData,
      ) {}

  }*/
@Component({
    selector: 'app-inicioSesion',
    templateUrl: 'inicioSesion.component.html',
    styleUrls: ['./inicioSesion.component.css']
  })



  export class inicioSesionDialog implements OnInit {
    usr:Usuario = new Usuario();
    constructor(public dialog: MatDialog, private usuarioService:UsuarioService, private router:Router){

    }
  /*  public contra: string = "";
    public correo: string = "";


  constructor(public authService: AuthService){}

  login(){
    if (this.correo && this.contra) {
      const usr = new UserDTO();
      usr.contra = this.contra;
      usr.correo = this.correo;

      this.authService.login(usr);
    }
    return ;
  }

  user(){
    return this.authService.userData?.correo;
  }*/
  ngOnInit():void{

  }

  RegistroDialog(): void{
    const dialogRef = this.dialog.open(RegistroComponent, {
      //  data: {name: this.name},
    });
  }

  login(usuario:Usuario):void{
    this.usuarioService.login(usuario).subscribe(
        (usr) => {this.usr = usr;
          if (usr.idTipoUsuario === 2) {
            this.router.navigate(['/inicioProfesor'])
          }else if(usr.idTipoUsuario === 3){
            this.router.navigate(['/tomarClase'])
          }
        }
      )
  }
}
