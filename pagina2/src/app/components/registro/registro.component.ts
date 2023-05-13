import { Component } from '@angular/core';
import { Router} from '@angular/router';
import { Usuario } from 'src/app/models/usuario';
import { UsuarioService } from 'src/app/services/usuario.service';


@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
})
export class RegistroComponent {
  usuario: Usuario = {
    idUsuario: 0,
    nombre: 'Pablo',
    apellido1: 'Doe',
    apellido2: 'Tolpe',
    correo: 'pabloTuto@gmail.com',
    password: '1234',
    num_denuncias: 0,
    idTipoUsuario: 3,
    instPseudonimo: 'Manguuito'
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
    .subscribe(usr => console.log(usr));
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
