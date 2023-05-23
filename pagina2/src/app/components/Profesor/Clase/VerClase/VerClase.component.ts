import { Component, ElementRef, Inject, OnInit, ViewChild } from '@angular/core';
import {script} from './script.js'
import { DOCUMENT } from '@angular/common';
declare var jQuery: any;
declare var webkitSpeechRecognition: any;


var alumnoVoz = "hola";
var Puntos = 0;
@Component({
  selector: 'app-VerClase',
  templateUrl: './VerClase.component.html',
  styleUrls: ['./VerClase.component.scss', '../../FondoP.component.scss']
})
export class VerClaseComponent {
    isDisabled = false;
    constructor() {
     }
    startConverting (result:InnerHTML) {
        this.isDisabled=true;
      if('webkitSpeechRecognition' in window) {
          var speechRecognizer = new webkitSpeechRecognition();
          speechRecognizer.continuous = true;
          speechRecognizer.interimResults = true;
          speechRecognizer.lang = 'en-MX';
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


    validacion(solucion: string, result:InnerHTML){
        if(solucion.toUpperCase() === alumnoVoz.toUpperCase()){
            Puntos++;
            console.log("Correcto"+Puntos);
            result.innerHTML = 'Correcto, sigue así.';
        }else{
            Puntos--;
            console.log("Incorrecto"+Puntos);
            result.innerHTML = 'Incorrecto, la respuesta es '+solucion+', tenlo en cuenta para la próxima vez.';
        }


        this.isDisabled=true;
        this.show = false;
    }

Disables(){
    this.show=!this.show;  
    this.isDisabled=false;
}
        show = true;
}  
