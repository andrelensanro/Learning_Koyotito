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

const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'recpContra', component: RecuperarContraComponent},
  {path: 'reestablecimiento', component: ReestContraComponent},
  {path: 'InicioProfesor', component: InicioProfComponent},
    {path: 'CrearClase', component: CrearClaseComponent},
    {path: 'Alumno/Inicio', component: InicioAlumnoComponent},
    {path: 'ConfigP', component: ConfigPComponent},
    {path: 'ConfigT', component: ConfigTComponent},
    {path: 'InicioTutor', component: InicioTComponent},
    {path: 'BusquedasT', component: BusquedasTComponent},
    {path: 'InicioAlumno', component: InicioAlumnoComponent},
    {path: 'Grupos', component: GruposComponent },
    {path: 'GrupoEsp', component: GrupoEspComponent },
    {path: 'GruposT', component: GruposTComponent },
    {path: 'MeGustaP', component: MeGustaPComponent },
    {path: 'HistorialP', component: HistorialPComponent },
    {path: 'MisClases', component: MisClasesComponent },
    {path: 'PreviewClaseP', component: PrevisualizarClaseComponent },
    {path: 'VerClaseP', component: VerClaseComponent },
    {path: 'Tutor/Clases', component: ClasesComponent },
    {path: 'Tutor/PreviewClase', component: PrevisualizarClaseTComponent },
    {path: 'Profesor/Denuncias', component: DenunciasPagComponent },
    {path: 'Profesor/EditarClase', component: EditarClaseComponent },
    {path: 'Profesor/PreviewMiClase', component: PrevisualizarMiClaseComponent },
    {path: 'Alumno/Grupo', component: GruposAComponent },
    {path: 'Alumno/Clases', component: ClasesAComponent },
    {path: 'Alumno/ReproducirClase', component: VerClaseAComponent },
    {path: '**', redirectTo: 'home'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
