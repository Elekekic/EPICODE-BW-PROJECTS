import { Component, OnInit } from '@angular/core';
import { Cliente } from 'src/app/interfaces/cliente';
import { Fatture } from 'src/app/interfaces/fatture';
import { ClientiServiceService } from 'src/app/services/clienti-service.service';
import { FattureService } from 'src/app/services/fatture.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
})
export class HomeComponent implements OnInit {
  clienti: Cliente[] = [];
  fatture: { [clienteId: number]: Fatture[] } = {};
  //fatture: Fatture[];
  risposta:any;
  caricamento = true;

  constructor(private clienteSrv: ClientiServiceService, private fatturaSrv: FattureService) {}

  ngOnInit(): void {
    setTimeout(() => {
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
      this.fatturaSrv.getFatture().subscribe(
        (data) => {
          this.risposta = data;
          this.fatture = this.risposta.content;
          console.log(this.fatture);
        },
        (error) => {
          console.error('There was an error!', error);
        }
      );
    }, 500);
    setTimeout(() => {
      this.caricamento = false;
    }, 1000);
  }

  loadFatture(clienteId: number): void {
    if (!this.fatture[clienteId]) {
      this.fatturaSrv.getFattureByClienteId(clienteId).subscribe((data: Fatture[]) => {
        this.fatture[clienteId] = data;
        console.log(this.fatture[clienteId]);
      });
    }
  }
}
