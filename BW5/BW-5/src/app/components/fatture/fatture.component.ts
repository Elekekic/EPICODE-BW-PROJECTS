import { Component, OnInit } from '@angular/core';
import { Fatture } from 'src/app/interfaces/fatture';
import { FattureService } from 'src/app/services/fatture.service';

@Component({
  selector: 'app-fatture',
  templateUrl: './fatture.component.html',
  styleUrls: ['./fatture.component.scss'],
})
export class FattureComponent implements OnInit {
  fatture: Fatture[] = [];
  risposta: any;
  caricamento = true;

  constructor(private fatturaSrv: FattureService) {}

  ngOnInit(): void {
    setTimeout(() => {
      this.caricamento = false;
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
}
