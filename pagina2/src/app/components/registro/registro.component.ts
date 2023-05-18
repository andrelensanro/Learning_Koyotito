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
    idUsuario: 0,
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
    .subscribe(usuario => {
      this.idUsuario = usuario.idUsuario;
      this.redirigir(usuario.idTipoUsuario);
    });
  }

  redirigir(idTipoUsuario:number){
    if (idTipoUsuario == 2){
      this.router.navigate(['/InicioProfesor/:this.idUsuario']);
    }
    if(idTipoUsuario == 3){
      this.router.navigate(['/InicioTutor/:this.idUsuario']);
    }else{
      this.router.navigate(['/']);
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
