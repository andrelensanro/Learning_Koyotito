import { Component, ElementRef, Inject, OnInit, ViewChild } from '@angular/core';
import { DOCUMENT } from '@angular/common';
import { MatDialog } from '@angular/material/dialog';
import { PantallaFinAComponent } from './PantallaFin.component';
declare var jQuery: any;
declare var webkitSpeechRecognition: any;


var alumnoVoz = "hola";
var Puntos = 0;
@Component({
  selector: 'app-VerClaseA',
  templateUrl: './VerClase.component.html',
  styleUrls: ['./VerClase.component.scss', '../FondoA.component.scss']
})
export class VerClaseAComponent {
    isDisabled = false;
    constructor(public dialog: MatDialog){

    }
    startConverting (result:InnerHTML) {
       // result.innerHTML = "Escuchando...";
        this.isDisabled=true;
      if('webkitSpeechRecognition' in window) {
          var speechRecognizer = new webkitSpeechRecognition();
          speechRecognizer.continuous = true;
          speechRecognizer.interimResults = true;
          speechRecognizer.lang = 'es-ES';
          speechRecognizer.start();
          console.log("Speech recognition has started.");	
          var finalTranscripts = '';

          speechRecognizer.onresult = function(event) {
              var interimTranscripts = '';
              for(var i = event.resultIndex; i < event.results.length; i++){
                  var transcript = event.results[i][0].transcript;
                  transcript.replace("\n", "<br>");
                  if(event.results[i].isFinal) {
                      finalTranscripts += transcript;
                  }else{
                      interimTranscripts += transcript;
                  }
              }
              result.innerHTML = finalTranscripts + '<span style="color: #999">' + interimTranscripts + '</span>';
              alumnoVoz = finalTranscripts;
              console.log(alumnoVoz);
			};
          speechRecognizer.onerror = function (event) {

          };
      }else {
          result.innerHTML = 'Your browser is not supported. Please download Google chrome or Update your Google chrome!!';
      }
      this.delay(5000).then(any=>{
            speechRecognizer.stop();
            console.log("Speech recognition has stopped.");	
            this.isDisabled = false;
      });

      }


      async delay(ms: number) {
        return new Promise( resolve => setTimeout(resolve, ms) );
    }

 xpTot: number=0;
    validacion(solucion: string, result:InnerHTML){
        var xpMal = Math.floor(Math.random() * (3 - 1 + 1)) + 1;
        var xpBien = Math.floor(Math.random() *(10 - 6 + 1)) + 6;
        if(solucion.toUpperCase() === alumnoVoz.toUpperCase()){
            Puntos++;
            console.log("Correcto"+Puntos);
            result.innerHTML = 'Correcto, sigue así.<br> +'+xpBien+"xp";
            this.xpTot=this.xpTot+xpBien;
        }else{
            Puntos--;
            console.log("Incorrecto"+Puntos);
            result.innerHTML = 'Casi, la respuesta es '+solucion+', tenlo en cuenta para la próxima vez.<br> +'+xpMal+"xp";
            this.xpTot=this.xpTot+xpMal;
        }
        this.isDisabled=true;
        this.show = false;
    }

Disables(Solucion:InnerHTML, dos:InnerHTML){
    this.show=!this.show;  
    this.isDisabled=false;
    Solucion.innerHTML='';
    dos.innerHTML="<- Presiona y habla.";
}
        show = true;

    
      
      
        PantallaFinDialog(): void{
            localStorage.setItem("xp",this.xpTot.toString());
          const dialogRef = this.dialog.open(PantallaFinAComponent, { disableClose: true
            //  data: {name: this.name},
            });
        }
}  
