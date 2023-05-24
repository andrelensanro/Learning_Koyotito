
import { CookieService } from 'ngx-cookie-service';
import { Component, Inject, OnInit } from '@angular/core';
import { MatDialog, MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';
import { AuthService } from '../services/authService.component'; 
import { UserDTO } from '../modelo/userDTO.model';
import { RegistroComponent } from '../registro/registro.component';
import { LoginService } from 'app/services/login.service';
import { UsuarioService } from 'app/services/usuario.service';
import { Router } from '@angular/router';
//import { Usuario } from 'src/app/models/usuario';
import { Usuario } from 'app/models/usuario';

@Component({
    selector: 'app-inicioSesion',
    templateUrl: 'inicioSesion.component.html',
    styleUrls: ['./inicioSesion.component.css']
  })


  
export class inicioSesionComponent{
  usuario!:Usuario;
  public correo: string = "";

  constructor(
    public dialog: MatDialog,
    private usuarioService:UsuarioService, 
    private router:Router,
    private loginService:LoginService,
    private cookieService:CookieService,
  ){}

  send(): any{
    this.loginService.login(this.usuario)
    .subscribe((user) => {
      this.cookieService.set('token', this.usuario.correo);
      this.cookieService.set('token', this.usuario.password);
    });
  }
  /* En caso de no tener una cuenta, lo redigire a un formulario de registro*/
  RegistroDialog(): void{
    const dialogRef = this.dialog.open(RegistroComponent, {
      //  data: {name: this.name},
    });
  }

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
