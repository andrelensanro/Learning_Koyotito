import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MenuComponent } from './components/menu/menu.component';
import { MatToolbarModule } from "@angular/material/toolbar";
import { HomeComponent } from './components/home';
import { MatButtonModule } from "@angular/material/button";
import { RegistroComponent } from './components/registro/registro.component';
import { MatInputModule } from "@angular/material/input";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import {MatDialogModule} from '@angular/material/dialog';
import {  MatCardModule } from "@angular/material/card";
import { inicioSesionComponent } from './components/menu/inicioSesion.component';
import {MatIconModule} from '@angular/material/icon';
import {MatButtonToggleModule} from '@angular/material/button-toggle';
import { RecuperarContraComponent } from './components/sesion/RecuperarContra.component';
import {ToastrModule} from 'ngx-toastr';
import { ReestContraComponent } from './components/sesion/ReestContra.component';
import { navBar1Component } from './components/Profesor/navBar1.component';
import {MatSidenavModule} from '@angular/material/sidenav';
import { CalificacionComponent } from './components/alumno/calificacion.component';
import { CrearClaseComponent } from './components/Profesor/Clase/ClasesProfesor/CrearClase.component';
import { RouterModule } from '@angular/router';
import { MAT_FORM_FIELD_DEFAULT_OPTIONS, MatFormFieldModule } from '@angular/material/form-field';
import { MatProgressBarModule } from '@angular/material/progress-bar';
import { MatListModule } from '@angular/material/list';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';
import {MatSelectModule} from '@angular/material/select';
import { register } from 'swiper/element/bundle';
import { CerrarSesionComponent } from './components/sesion/CerrarSesioncomponent';
import { ConfigPComponent } from './components/Profesor/Datos/ConfigP.component';
import { HeaderSidebarPComponent } from './components/Profesor/HeaderSidebarP.component';
import { HeaderSidebarTComponent } from './components/Tutor/HeaderSidebarT.component';
import { ConfigTComponent } from './components/Tutor/Config/ConfigT.component';
import { InicioTComponent } from './components/Tutor/InicioT.component';
import { BarraBusquedasComponent } from './components/Profesor/BarraBusquedas.component';
import { BusquedasTComponent } from './components/Tutor/BusquedasT.component';
import { FooterComponent } from './components/Tutor/Footer.component';
import { HeaderSidebarAComponent } from './components/alumno/HeaderSidebarA.component';
import { InicioAlumnoComponent } from './components/alumno/InicioAlumno.component';
import { GruposComponent } from './components/Profesor/Grupos/grupos.component';
import { GrupoEspComponent } from './components/Profesor/Grupos/grupoEsp.component';
import { FooterCrearComponent } from './components/Profesor/FooterCrear.component';
import { InvitacionComponent } from './components/Profesor/Grupos/Invitacion.component';
import { GruposTComponent } from './components/Tutor/Grupos/gruposT.component';
//import { SwiperModule } from 'swiper/angular';
import {MatBadgeModule} from '@angular/material/badge';
import { DenunciasPComponent } from './components/Profesor/Denuncias/DenunciasP.component';
import { InicioProfComponent } from './components/Profesor/Inicio/InicioProf.component';
import { MeGustaPComponent } from './components/Profesor/ClasesMeGusta/MeGustaP.component';
import { HistorialPComponent } from './components/Profesor/HistorialP/HistorialP.component';
import { CrearGrupoComponent } from './components/Profesor/Grupos/CrearGrupo.component';

@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    RegistroComponent,
    HomeComponent,
    inicioSesionComponent,
    RecuperarContraComponent,
    ReestContraComponent,
    InicioProfComponent,
    navBar1Component,
    CalificacionComponent,
    CrearClaseComponent,
    CerrarSesionComponent,
    ConfigPComponent,
    HeaderSidebarPComponent,
    ConfigTComponent,
    HeaderSidebarTComponent,
    InicioTComponent,
    BarraBusquedasComponent,
    BusquedasTComponent,
    FooterComponent,
    HeaderSidebarAComponent,
    InicioAlumnoComponent,
    GruposComponent,
    GrupoEspComponent,
    FooterCrearComponent,
    InvitacionComponent,
    GruposTComponent,
    DenunciasPComponent,
    MeGustaPComponent,
    HistorialPComponent,
    CrearGrupoComponent,
      ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatInputModule,
    MatButtonModule,
    FormsModule,
    MatDialogModule,
    MatCardModule,
    MatIconModule,
    MatButtonToggleModule,
    ToastrModule.forRoot({
      timeOut: 1000,
      positionClass: 'toast-bottom-right'
    }),
    RouterModule,
    MatFormFieldModule,
  MatProgressBarModule,
  MatSelectModule,
  MatListModule,
//  SwiperModule,
  HttpClientModule,
  ReactiveFormsModule,
  MatSidenavModule,
  MatBadgeModule
  ],
  providers: [{provide: MAT_FORM_FIELD_DEFAULT_OPTIONS, useValue: {appearance: 'outline'}}],
  bootstrap: [AppComponent]
})
export class AppModule { }
