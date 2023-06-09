import { Component } from '@angular/core';
import { Router} from '@angular/router';
import { Usuario } from 'app/models/usuario';
import { UsuarioService } from 'app/services/usuario.service';


@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
})
export class RegistroComponent {
  private idUsuario!: number;
  usuario: Usuario = {
    idUsuario: 15,
    nombre: '',
    apellido1: '',
    apellido2: '',
    correo: '',
    password: '',
    num_denuncias: 0,
    idTipoUsuario: 2,
    instPseudonimo: ''
  };

  public pseudonimo: boolean=true;
  public profesor: boolean=true;
  public texto: string="";

  constructor(
    private usuarioService:UsuarioService,
    private router:Router
  ){}

  guardarUsuario(){
    this.usuarioService
    .registrar(this.usuario)
    .subscribe(usr => 
      this.redirecccionarUsr(usr)
    );
  }

  redirecccionarUsr(usr: Usuario){
    if(usr == null){
      console.log("error, el usuario ya esta registrado");

    }else{
      if(this.profesor == false){
        this.router.navigate(['profesor-inicio'],
        { queryParams:
          {idUsuario:usr.idUsuario}   
        })
      }else{
        this.router.navigate(['tutor/inicio'],
        { queryParams:
          {idUsuario:usr.idUsuario}
        })
      }
    }
  }

  OpProf(){
    this.pseudonimo = true,
    this.profesor = false
  }

  OpTut(){
    this.pseudonimo = false,
    this.profesor = true
  }

  limpiar(){
    this.texto=''
  }
}
