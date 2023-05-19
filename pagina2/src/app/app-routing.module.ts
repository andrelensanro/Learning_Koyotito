import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MenuComponent } from './components/menu/menu.component';
import { RegistroComponent } from './components/registro/registro.component';
import { HomeComponent } from './components/home';
import { RecuperarContraComponent } from './components/sesion/RecuperarContra.component';
import { ReestContraComponent } from './components/sesion/ReestContra.component';
import { CalificacionComponent } from './components/alumno/calificacion.component';
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

const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'recpContra', component: RecuperarContraComponent},
  {path: 'reestablecimiento', component: ReestContraComponent},
  {path: 'InicioProfesor', component: InicioProfComponent},
    {path: 'CrearClase', component: CrearClaseComponent},
    {path: 'Calificacion', component: CalificacionComponent},
    {path: 'TomarClase', component: InicioAlumnoComponent},
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
    {path: '**', redirectTo: 'home'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
