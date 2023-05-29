import { Component, Inject, OnInit } from '@angular/core';
import { MenuComponent } from '../menu/menu.component';
import { Router } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';
import { AuthService } from '../services/authService.component';


@Component({
  selector: 'app-CerrarSesion',
  templateUrl: './CerrarSesion.component.html'
})
export class CerrarSesionComponent{
    constructor(public dialog: MatDialog) {}
    
}