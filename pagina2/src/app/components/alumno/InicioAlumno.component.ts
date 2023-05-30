import { HttpClient, HttpEventType, HttpResponse } from "@angular/common/http";
import { Component, OnInit } from "@angular/core";
import { Observable } from "rxjs";
import { BehaviorSubject } from 'rxjs';
import SwiperCore, { Keyboard, Pagination, Navigation, Virtual } from 'swiper';
SwiperCore.use([Keyboard, Pagination, Navigation, Virtual]);

@Component({
    selector: 'app-InicioAlumno',
    templateUrl: "./InicioAlumno.component.html",
    styleUrls: ['./FondoA.component.scss', 'inicioA.component.scss']
  })
  
  export class InicioAlumnoComponent{
    slides$ = new BehaviorSubject<string[]>(['']);
    ngOnInit(): void {
      this.slides$.next(
        Array.from({ length: 600 }).map((el, index) => `Slide ${index + 1}`)
      );
    }
}