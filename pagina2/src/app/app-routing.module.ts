import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MenuComponent } from './components/menu/menu.component';
import { RegistroComponent } from './components/registro/registro.component';
import { HomeComponent } from './components/home';
import { RecuperarContraComponent } from './components/sesion/RecuperarContra.component';
import { ReestContraComponent } from './components/sesion/ReestContra.component';
import { CrearClaseComponent } from './components/Profesor/Clase/ClasesProfesor/CrearClase.component';
import { InicioAlumnoComponent } from './components/alumno/InicioAlumno.component';
import { ConfigPComponent } from './components/Profesor/Datos/ConfigP.component';
import { ConfigTComponent } from './components/Tutor/Config/ConfigT.component';
import { InicioTComponent } from './components/Tutor/InicioT.component';
import { BusquedasTComponent } from './components/Tutor/BusquedasT.component';
import { GruposComponent } from './components/Profesor/Grupos/grupos.component';
import { GrupoEspComponent } from './components/Profesor/Grupos/grupoEsp.component';
import { GruposTComponent } from './components/Tutor/Grupos/gruposT.component';
import { InicioProfComponent } from './components/Profesor/Inicio/InicioProf.component';
import { MeGustaPComponent } from './components/Profesor/ClasesMeGusta/MeGustaP.component';
import { HistorialPComponent } from './components/Profesor/HistorialP/HistorialP.component';
import { PrevisualizarClaseComponent } from './components/Profesor/Visualizar_Clase/PrevisualizarClase.component';
import { VerClaseComponent } from './components/Profesor/Clase/VerClase/VerClase.component';
import { MisClasesComponent } from './components/Profesor/MisClases/MisClases.component';
import { ClasesComponent } from './components/Tutor/Clases/Clases.component';
import { DenunciasPComponent } from './components/Profesor/Denuncias/DenunciasP.component';
import { DenunciasPagComponent } from './components/Profesor/Denuncias/DenunciasPag.component';
import { EditarClaseComponent } from './components/Profesor/Clase/EditarMiClase/EditarClase.component';
import { PrevisualizarMiClaseComponent } from './components/Profesor/MisClases/PrevisualizarMiClase.component';
import { PrevisualizarClaseTComponent } from './components/Tutor/Visualizar_Clase/PrevisualizarClase.component';
import { GruposAComponent } from './components/alumno/Grupos/grupos.component';
import { ClasesAComponent } from './components/alumno/Clases/Clases.component';
import { VerClaseAComponent } from './components/alumno/VerClase/VerClase.component';
import { MediaComponent } from './media/media.component';

const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'recpContra', component: RecuperarContraComponent},
  {path: 'reestablecimiento', component: ReestContraComponent},

  /*    http:localhost/idusuario/clase-crear/idclase     */
  {path: 'alumno/inicio', component: InicioAlumnoComponent},
  {path: 'alumno/ver-grupos', component: GruposAComponent }, 
  {path: 'alumno/ver-clases', component: ClasesAComponent },
  {path: 'alumno/reproducir-clase', component: VerClaseAComponent },

  {path: 'tutor/config', component: ConfigTComponent},
  {path: 'tutor/inicio', component: InicioTComponent},
  {path: 'tutor/ver-grupos', component: GruposTComponent },
  {path: 'tutor/ver-clases', component: ClasesComponent },
  {path: 'tutor/previa-clase', component: PrevisualizarClaseTComponent },
  
  {path: 'koyotito/busquedas', component: BusquedasTComponent},
  {path: 'koyotito/ver-vista-previa/:idClase', component: PrevisualizarClaseComponent },

  {path: 'profesor-inicio', component: InicioProfComponent},
  {path: 'profesor/crear-clase/:idclase', component: CrearClaseComponent},
  {path: 'profesor/config', component: ConfigPComponent},
  {path: 'profesor/ver-grupos', component: GruposComponent },
  {path: 'profesor/grupo/:idGrupo', component: GrupoEspComponent },
  {path: 'profesor/ver-clases-gusta', component: MeGustaPComponent },
  {path: 'profesor/ver-historial', component: HistorialPComponent },
  {path: 'profesor/mis-clases', component: MisClasesComponent },
  {path: 'profesor/mi-multimedia/:idUsuario', component: MediaComponent },
  {path: 'profesor/ver-clase/:idClase', component: VerClaseComponent },
  {path: 'profesor/ver-denuncias', component: DenunciasPagComponent },
  {path: 'profesor/editar-clase', component: EditarClaseComponent },
  {path: 'profesor/previa-mi-clase', component: PrevisualizarMiClaseComponent },

  {path: '**', redirectTo: 'home'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
