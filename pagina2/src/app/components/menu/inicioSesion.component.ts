import { Component, Inject } from '@angular/core';
import { MatDialog, MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';
import { AuthService } from '../services/authService.component';
import { UserDTO } from '../modelo/userDTO.model';
import { RegistroComponent } from '../registro/registro.component';
import { UsuarioService } from 'src/app/services/usuario.service';
import { Router } from '@angular/router';
import { Usuario } from 'src/app/models/usuario';

@Component({
    selector: 'app-inicioSesion',
    templateUrl: 'inicioSesion.component.html',
    styleUrls: ['./inicioSesion.component.css']
  })


  
  export class inicioSesionComponent {

    usuario!:Usuario;

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

  RegistroDialog(): void{
    const dialogRef = this.dialog.open(RegistroComponent, {
      //  data: {name: this.name},
    });
  }


  login(usuario:Usuario):void{
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