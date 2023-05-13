import { Component, Inject } from '@angular/core';
import { MatDialog, MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';
import { AuthService } from '../services/authService.component';
import { UserDTO } from '../modelo/userDTO.model';
import { RegistroComponent } from '../registro/registro.component';
import { UsuarioService } from 'src/app/services/usuario.service';
import { Router } from '@angular/router';
import { Usuario } from 'src/app/models/usuario';
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


  
  export class inicioSesionDialog {
    usuario: Usuario = {
      idUsuario: 0,
      nombre: '',
      apellido1: '',
      apellido2: '',
      correo: 'pabloTuto@gmail.com',
      password: '1234',
      num_denuncias: 0,
      idTipoUsuario: 0,
      instPseudonimo: ''
    };
  
    constructor(
      public dialog: MatDialog,
      private usuarioService:UsuarioService, 
      private router:Router
      ){}
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


  login():void{
    this.usuarioService
      .login(this.usuario)
      .subscribe(
        (usr) => {
          console.log("Inicio sesión:" + usr);
          this.router.navigate(['/inicioProfesor']);
        }
      )
  }
}