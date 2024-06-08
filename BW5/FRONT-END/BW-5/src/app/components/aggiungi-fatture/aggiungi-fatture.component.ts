import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/auth/auth.service';
import { Cliente } from 'src/app/interfaces/cliente';
import { ClientiServiceService } from 'src/app/services/clienti-service.service';
import { FattureService } from 'src/app/services/fatture.service';
import { Toast } from 'bootstrap';

@Component({
  selector: 'app-aggiungi-fatture',
  templateUrl: './aggiungi-fatture.component.html',
  styleUrls: ['./aggiungi-fatture.component.scss']
})
export class AggiungiFattureComponent implements OnInit{

  caricamento=true;
  clienti:Cliente[]=[];
  risposta:any;
  
  constructor(private clienteSrv: ClientiServiceService, private fatturaSrv: FattureService, private authSrv: AuthService, private router: Router) {}

  ngOnInit(): void {
    this.caricamento = false;
      this.clienteSrv.getClienti().subscribe(
        (data) => {
          this.risposta = data;
          this.clienti=this.risposta.content;
          console.log(this.clienti);
        },
        (error) => {
          console.error('There was an error!', error);
        }
      );
  }
  
  creaFattura(form:NgForm){
    console.log(form.value)
    try {
      this.fatturaSrv.postAggiungiFattura(form.value).subscribe();
      
    } catch (error) {
      console.error(error)
      return
    }
  }

    showToast() {
      const toastElement = document.getElementById('liveToast');
      if (toastElement) {
        const toast = new Toast(toastElement);
        toast.show();
      }
    }
  }